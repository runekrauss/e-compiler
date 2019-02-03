package com.runekrauss.compiler;

import com.runekrauss.parser.ELexer;
import com.runekrauss.parser.EParser;
import jasmin.ClassFile;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * Represents a compiler for the language E: EBNF ->(ANTLR4) Lexer/Parser ->(Code) Syntax
 * ->(Visitor) Assembly ->(Jasmin) Bytecode ->(Java) Output
 *
 * @author Rune Krauss
 */
public class Main {
  /** Parent directory (path to file for legacy) */
  private static File parentDir;

  /** The namespace of the program you want to compile currently */
  private static String namespace;

  /** Temporary directory for the compiled files */
  public static Path tempDir;

  /** Holds the programs (including path) to compile. */
  public static Queue<String> programs;

  /** Holds the compiled programs (including path). */
  public static Queue<String> compiledPrograms;

  /**
   * Fetches the source code and compiles it.
   *
   * @param args Command line parameters
   * @throws Exception Treats errors like usage before definitions
   */
  public static void main(String[] args) throws Exception {
    // Path to the main program
    final String fileName = "e/test/main";
    // Create a temporary directory for programs compiled later
    tempDir = createTempDir(fileName);
    parentDir = tempDir.toFile();
    programs = new LinkedList<>();
    // Add the program you want to compile
    programs.add(fileName);
    compiledPrograms = new LinkedList<>();
    // Process the programs
    while (!programs.isEmpty()) {
      final String program = programs.poll();
      compiledPrograms.add(program);
      // Set the namespace for later references
      namespace = program.replace('/', '_');
      // The current file to compile
      final File currentFile = new File(parentDir.getPath(), namespace + ".e");
      final CharStream srcCode = CharStreams.fromFileName(program + ".e");
      if (Debug.ON) {
        System.out.println(tempDir + " # Location of the " + "folder");
        System.out.println(program + " # Location of the source code " + "to compile");
        System.out.println(namespace + " # Class name");
        System.out.println(currentFile + " # Current file " + "to compile");
        System.out.println("# Source code\n" + srcCode);
      }
      // Separate the main program from the structures
      final String[] compiledCode = compile(srcCode).split("\\*");
      if (Debug.ON) {
        System.out.println("# Compiled code");
        System.out.println(Arrays.toString(compiledCode));
      }
      if (!compiledCode[0].isEmpty()) {
        final ClassFile classFile = new ClassFile();
        classFile.readJasmin(new StringReader(compiledCode[0]), "", false);
        final Path outputPath =
            tempDir.resolve(
                currentFile
                        .getAbsolutePath()
                        .substring(0, currentFile.getAbsolutePath().length() - 2)
                    + ".class");
        classFile.write(Files.newOutputStream(outputPath));
        final ClassFile[] extraFiles = new ClassFile[compiledCode.length - 1];
        // Create class files for the declared structs
        for (int i = 0; i < compiledCode.length - 1; ++i) {
          final ClassFile file = new ClassFile();
          extraFiles[i] = file;
          file.readJasmin(new StringReader(compiledCode[i + 1]), "", false);
          final Path newPath = tempDir.resolve(file.getClassName() + ".class");
          file.write(Files.newOutputStream(newPath));
        }
      }
    }
    // Run the compiled program
    final String result = runClass(tempDir, fileName.replace("/", "_"));
    // Delete the created temporary directory
    deleteTempDir();
    if (Debug.ON) {
      if (result != null) {
        // Print the result
        System.out.println(result);
      }
    }
  }

  /**
   * Compiles the source code as follows:
   *
   * <ol>
   *   <li>Lexical analysis: Recognizes words (lexeme) with finite automatons (regular expressions)
   *   <li>Syntax analysis: Builds a logical structure (AST) using a LL(1) top down parser
   *   <li>Context analysis: Attributes the AST through declaration analysis and type analysis (ASG)
   *   <li>Synthesis: Creates assembler instructions regarding Jasmin
   * </ol>
   *
   * In addition, an optimization is carried out, such as a simplification of isomorphisms.
   *
   * @param sourceCode Source code
   * @return Assembly program
   */
  public static String compile(final CharStream sourceCode) {
    // Control characters are ignored
    ELexer lexer = new ELexer(sourceCode);
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    EParser parser = new EParser(tokens);
    // Start rule
    ParseTree tree = parser.program();
    // Collect all function definitions (without body)
    FunctionPrototypeList definedFunctionPrototypes =
        FunctionDefinitionVisitor.findFunctionPrototypes(tree);
    // Collect all structs with declared variables and types
    // (including references)
    LinkedHashMap<String, CustomType> declaredStructs = CustomTypeVisitor.findTypes(tree);
    // Collect all static variables in the main program
    // (including references to structs)
    Map<String, TypeInformation> declaredStaticVars =
        StaticVariableVisitor.findStaticVariables(tree, declaredStructs);
    if (Debug.ON) {
      if (!definedFunctionPrototypes.getFunctionPrototypes().isEmpty()) {
        // Function prototypes
        System.out.println("# Function Protoypes");
        System.out.println("# Return type, name, parameter types");
        for (FunctionPrototype prototype : definedFunctionPrototypes.getFunctionPrototypes()) {
          System.out.print(
              '\t'
                  + prototype.getTypeInfo().getDataType().getType()
                  + ' '
                  + prototype.getFunctionId()
                  + '(');
          final int paramNumber = prototype.getParamNumber();
          for (int i = 0; i < paramNumber; ++i) {
            System.out.print(prototype.getParams()[i].getDataType().getType());
            if (i < paramNumber - 1) {
              System.out.print(", ");
            }
          }
          System.out.println(')');
        }
      }
      if (!declaredStructs.isEmpty()) {
        // Structs
        System.out.println("# Structs");
        System.out.println("# Name, Id, Types (or references)");
        for (Map.Entry<String, CustomType> struct : declaredStructs.entrySet()) {
          final CustomType customType = struct.getValue();
          System.out.print(struct.getKey() + ' ' + customType.getId() + " {");
          final int typesSize = customType.getTypes().size();
          for (int i = 0; i < typesSize; ++i) {
            final TypeInformation typeInfo = customType.getTypes().get(i);
            final DataType dataType = typeInfo.getDataType();
            if (dataType == DataType.OBJREF) {
              System.out.print(typeInfo.getAddress());
            } else {
              System.out.print(dataType.getType());
            }
            if (i < typesSize - 1) {
              System.out.print(", ");
            }
          }
          System.out.println('}');
        }
      }
      if (!declaredStaticVars.isEmpty()) {
        // Static variables
        System.out.println("# Static variables");
        System.out.println("# Name, type (or references)");
        for (Map.Entry<String, TypeInformation> staticVar : declaredStaticVars.entrySet()) {
          System.out.print(staticVar.getKey() + " : ");
          final TypeInformation typeInfo = staticVar.getValue();
          final DataType dataType = typeInfo.getDataType();
          if (dataType == DataType.OBJREF) {
            System.out.println(typeInfo.getAddress());
          } else {
            System.out.println(dataType.getType());
          }
        }
      }
    }
    // Create an assembler program for Jasmin based on instructions
    return new EVisitor(
            definedFunctionPrototypes, declaredStructs, declaredStaticVars, namespace, parentDir)
        .visit(tree);
  }

  /**
   * Creates a temporary folder in the system environment where the compiled programs are located.
   *
   * @param fileNamePath Path to the name of the program
   * @throws IOException If the temporary folder cannot be created
   */
  public static Path createTempDir(final String fileNamePath) throws IOException {
    // "a/b/c" to "c"
    return Files.createTempDirectory(fileNamePath.split("/")[fileNamePath.split("/").length - 1]);
  }

  /** Deletes all class files and the related folder. */
  private static void deleteTempDir() {
    deleteRecursive(tempDir.toFile());
  }

  /**
   * A helper method for deleting the created files and folders in the root folder
   *
   * @param file Start file
   */
  public static void deleteRecursive(final File file) {
    if (file.isDirectory()) {
      for (final File child : Objects.requireNonNull(file.listFiles())) {
        deleteRecursive(child);
      }
    }
    if (!file.delete()) {
      throw new Error("Could not delete file: " + file + ';');
    }
  }

  /**
   * Runs the bytecode of the created .class file in the JVM.
   *
   * @param dir Directory to the file
   * @param className Name of the class
   * @return Result
   * @throws Exception If the file could not be processed correctly
   */
  public static String runClass(final Path dir, final String className) throws Exception {
    final Process process =
        Runtime.getRuntime().exec(new String[] {"java", "-cp", dir.toString(), className});
    try (InputStream input = process.getInputStream()) {
      Scanner scanner = new Scanner(input);
      if (scanner.useDelimiter("\\A").hasNext()) {
        String result = scanner.useDelimiter("\\A").next();
        scanner.close();
        return result;
      }
      scanner.close();
      return null;
    }
  }
}
