package com.runekrauss.compiler;

import com.runekrauss.compiler.exception.*;
import com.runekrauss.parser.EBaseVisitor;
import com.runekrauss.parser.EParser.*;
import java.io.File;
import java.util.*;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * Processes the syntax tree for code generation by traversing it (post order). For this reason, the
 * specific grammar is defined recursively.
 *
 * @author Rune Krauss
 */
public class EVisitor extends EBaseVisitor<String> {
  /** A list with all already defined functions */
  private final FunctionPrototypeList functions;

  /** Structs with declared variables and types (including references) */
  private final LinkedHashMap<String, CustomType> structs;

  /** Static variables in the main program (including references to structs) */
  private final Map<String, TypeInformation> staticVarsNamesTypes;

  /** Static variables in the form of text */
  private final StringBuilder staticVars;

  /** The namespace of the program you want to compile currently */
  private final String namespace;

  /** Descriptor for own declared types as reference */
  private final String typeNamespace;

  /** Parent directory (path to file for legacy) */
  private final File parentDir;

  /** Saves the module name as well as the path */
  private final Map<String, String> includedModules;

  /** Should a main method be created? */
  private boolean noMain;

  /**
   * The variables in the table are accessed numerically. For this reason, the names are mapped to
   * positions in the table (including the respective data type).
   */
  private Map<String, TypeInformation> vars;

  /** Logs the used data types at compile time. */
  private DataTypeStack dataTypeStack;

  /** Is one in a function or the main program? */
  private boolean isGlobalScope;

  /** Counts the branches because no label may be ambiguous. */
  private int branchCounter;

  /** Counts the comparisons because no label may be ambiguous. */
  private int comparisonCounter;

  /** Counts the conjunctions because no label may be ambiguous. */
  private int conjunctionCounter;

  /** Counts the disjunctions because no label may be ambiguous. */
  private int disjunctionCounter;

  /** Counts the loops because no label may be ambiguous. */
  private int loopCounter;

  /** Needed when initializing a structure */
  private String lookupStoreCommand;

  /** Also required when initializing a structure */
  private String lookupLoadCommand;

  /** Holds the current id of a struct */
  private int lookupStructId;

  /**
   * Creates a visitor for semantic analysis and subsequent code generation where all defined
   * functions are already known.
   *
   * @param definedFunctions All defined functions after the first traversing
   * @param declaredStructs All declared structs after the second/third traversing
   * @param declaredStaticVars All declared static variables after the fourth traversing
   * @param namespace Namespace for references
   * @param parentDir Parent directory of the file to compile
   */
  public EVisitor(
      FunctionPrototypeList definedFunctions,
      LinkedHashMap<String, CustomType> declaredStructs,
      Map<String, TypeInformation> declaredStaticVars,
      String namespace,
      File parentDir) {
    if (definedFunctions == null || declaredStructs == null || declaredStaticVars == null) {
      throw new NullPointerException(
          "An error has occurred in handling functions, structures or variables;");
    } else {
      functions = definedFunctions;
      structs = declaredStructs;
      staticVarsNamesTypes = declaredStaticVars;
      staticVars = new StringBuilder();
      this.namespace = namespace;
      typeNamespace = "struct_" + namespace;
      this.parentDir = parentDir;
      includedModules = new HashMap<>();
      noMain = false;
      vars = new HashMap<>();
      dataTypeStack = new DataTypeStack();
      isGlobalScope = true;
      branchCounter = 0;
      comparisonCounter = 0;
      conjunctionCounter = 0;
      disjunctionCounter = 0;
      loopCounter = 0;
      lookupStoreCommand = "";
      lookupLoadCommand = "";
      lookupStructId = 0;
    }
  }

  /**
   * The program has several children, namely once functions, structs and statements. The respective
   * code is determined separately in an iteration and then returned concatenated.
   *
   * @param ctx Program rule
   * @return Instructions for the statements, structs and functions (outside the main method)
   */
  @Override
  public String visitProgram(ProgramContext ctx) {
    // Generate potential code for the imports
    final int importNumber = ctx.incls.size();
    for (int i = 0; i < importNumber; ++i) {
      visit(ctx.getChild(i));
    }
    final int noMainNumber = ctx.noMains.size();
    for (int i = importNumber; i < noMainNumber; ++i) {
      visit(ctx.getChild(i));
    }
    final StringBuilder mainInstructions = new StringBuilder();
    final StringBuilder functionInstructions = new StringBuilder();
    // Regarding structs
    final StringBuilder extraClassesInstructions = new StringBuilder();
    for (int i = importNumber; i < ctx.getChildCount() - 1; ++i) {
      final ParseTree child = ctx.getChild(i);
      // Visit a parse tree and return a user-defined result of the operation
      final String instructions = visit(child);
      if (child instanceof StatementCommandContext) {
        mainInstructions.append(instructions).append('\n');
      } else if (child instanceof StructDeclarationCommandContext) {
        // The structures are marked accordingly because afterwards own files are created for them
        extraClassesInstructions.append("\n*").append(instructions).append('\n');
      } else {
        functionInstructions.append(instructions).append('\n');
      }
    }
    final StringBuilder instructions =
        new StringBuilder(".class public ")
            .append(namespace)
            .append("\n.super java/lang/Object\n\n")
            .append(staticVars.toString())
            .append('\n')
            .append(functionInstructions.toString())
            .append('\n');
    if (!noMain) {
      instructions
          .append(".method public static main([Ljava/lang/String;)V\n")
          .append(".limit stack ")
          .append(dataTypeStack.getMaxStackSize())
          .append("\n.limit locals 1\n\n")
          .append(mainInstructions.toString())
          .append("\nreturn\n\n")
          .append(".end method")
          .append(extraClassesInstructions.toString());
    } else {
      instructions
          .append(mainInstructions.toString())
          .append('\n')
          .append(extraClassesInstructions.toString());
    }
    return instructions.toString();
  }

  /**
   * Called if no start method is to be created for a class. This is the case, for example, when
   * files from the standard library are included.
   *
   * @param ctx No main rule
   * @return Empty (not important)
   * @see EVisitor#includedModules
   */
  @Override
  public String visitNoMain(NoMainContext ctx) {
    if (ctx.name.getText().equals("noMain")) {
      noMain = true;
    }
    return "";
  }

  /**
   * Here the imports and the corresponding paths are determined or whether they have already been
   * compiled.
   *
   * @param ctx Includes rule
   * @return Empty (not important)
   * @see EVisitor#includedModules
   */
  @Override
  public String visitIncludes(IncludesContext ctx) {
    for (int i = 0; i < ctx.mods.size(); ++i) {
      final String namespace = ctx.mods.get(i).getText().replace('.', '_');
      final File file = new File(parentDir, namespace);
      final String address =
          file.getAbsolutePath().substring(parentDir.getAbsolutePath().length() + 1);
      if (!Main.programs.contains(address) && !Main.compiledPrograms.contains(address)) {
        // Add the respective module to the compilation list
        Main.programs.add(address.replace("_", "/"));
      }
      final String fileName = file.getName().split("_")[file.getName().split("_").length - 1];
      // Stores the filename (e.g. "math") and the path (e.g. e_std_math) to the file (to compile)
      includedModules.put(fileName, address);
    }
    return "";
  }

  /**
   * Called if a "print" appears in the tree. The node is responsible for outputting text. A
   * reference can also be specified, for example to a struct.
   *
   * @param ctx Print rule
   * @return Code for the output
   */
  @Override
  public String visitPrint(PrintContext ctx) {
    final String argumentInstructions = visit(ctx.arg);
    // Get type to output
    final TypeInformation typeInfo = dataTypeStack.pop();
    // Get the associated JVM type
    String jvmType = typeInfo.getJvmType();
    if (typeInfo.getDataType() == DataType.OBJREF) {
      // Get the address (position) of the struct
      jvmType = 'L' + typeNamespace + jvmType + ';';
    }
    // Get the type that "visit" put on the stack
    return "getstatic java/lang/System/out Ljava/io/PrintStream;\n"
        + argumentInstructions
        + "\ninvokevirtual java/io/PrintStream/print("
        + jvmType
        + ")V\n";
  }

  /**
   * Called if a "println" appears in the tree. The output is with a new line at the end.
   *
   * @param ctx Print rule
   * @return Code for the output
   */
  @Override
  public String visitPrintLine(PrintLineContext ctx) {
    final String argumentInstructions = visit(ctx.arg);
    final TypeInformation type = dataTypeStack.pop();
    String jvmType = type.getJvmType();
    if (type.getDataType() == DataType.OBJREF) {
      jvmType = "L" + typeNamespace + jvmType + ';';
    }
    return "getstatic java/lang/System/out Ljava/io/PrintStream;\n"
        + argumentInstructions
        + "\ninvokevirtual java/io/PrintStream/println("
        + jvmType
        + ")V\n";
  }

  /**
   * Called if a variable declaration appears in the tree. The variable table is defined by "limit
   * locals" whereby each variable takes different bytes. For example, the command "limit locals
   * 100" means that 100 variables can be created. Since there are various scopes, differentiation
   * is also made here. If there is a static variable, the .field directive is used to add it to the
   * main class. If a reference exists, it is also added to the variable. Various commands are used
   * to store or load values to the stack depending on the type (regarding functions):
   *
   * <ul>
   *   <li><code>astore/aload</code>: Refers to references with the opcode 0x3A (58)/0x19 (25)
   *   <li><code>istore/iload</code>: Refers to integers with the opcode 0x36 (54)/0x15 (21)
   *   <li><code>fstore/fload</code>: Refers to floats with the opcode 0x38 (56)/0x17 (23)
   * </ul>
   *
   * The commands <code>putstatic</code> and <code>getstatic</code> are used for the global scope.
   * The command <code>getstatic</code> pops a reference to an object from the stack, retrieves the
   * value of the static field (also known as a class field) and pushes the one-word or two-word
   * value onto the operand stack. The opcode is 0xB2 (178). The command <code>putstatic</code>
   * putstatic sets the value of the static field to the single or double word value on the operand
   * stack. The opcode is 0xB3 (179). For example, these commands are used to initialize an object
   * later (if no global scope applies).
   *
   * @param ctx Rule for the declaration of variables
   * @return Instruction for a variable declaration
   */
  @Override
  public String visitVariableDeclaration(VariableDeclarationContext ctx) {
    String instructions = "";
    final Token varIdToken = ctx.varId;
    final String varId = varIdToken.getText();
    final String type = ctx.type.getText();
    // Get type object by type name
    final DataType dataType = DataType.getType(type);
    // Command to store a variable
    String storeCommand = "";
    final ExpressionContext exprContext = ctx.expr;
    if (isGlobalScope) {
      // When you are in the main method
      // Get type information by variable name
      final TypeInformation typeInfo = staticVarsNamesTypes.get(varId);
      lookupStoreCommand = "putstatic " + namespace + "/v" + typeInfo.getId();
      lookupLoadCommand = "getstatic " + namespace + "/v" + typeInfo.getId();
      storeCommand = "putstatic " + namespace + "/v";
      // Descriptor for field access
      String descriptor;
      if (dataType == DataType.OBJREF) {
        descriptor = "L" + typeNamespace + structs.get(type).getId() + ';';
        vars.put(varId, new TypeInformation(vars.size(), dataType, structs.get(type).getId()));
      } else {
        descriptor = dataType.getJvmType();
        vars.put(varId, new TypeInformation(vars.size(), dataType));
      }
      staticVars
          .append(".field public static v")
          .append(getVariableIndexByVariableIdToken(varIdToken))
          .append(' ')
          .append(descriptor)
          .append('\n');
      if (exprContext != null) {
        instructions =
            visit(exprContext)
                + '\n'
                + storeCommand
                + getVariableIndexByVariableIdToken(varIdToken)
                + ' '
                + descriptor;
        if (dataTypeStack.peek().getDataType() != dataType) {
          throw new WrongDataTypeException(varIdToken);
        }
        dataTypeStack.pop();
        return instructions;
      }
      return instructions;
    } else {
      // When you are in a function
      if (vars.containsKey(varId)) {
        throw new AlreadyDeclaredVariableException(varIdToken);
      }
      if (dataType == DataType.OBJREF) {
        vars.put(varId, new TypeInformation(vars.size(), dataType, structs.get(type).getId()));
      } else {
        vars.put(varId, new TypeInformation(vars.size(), dataType));
      }
      final TypeInformation typeInformation = vars.get(varId);
      if (typeInformation.isArray() || dataType == DataType.STRING || dataType == DataType.OBJREF) {
        storeCommand = "astore";
        lookupStoreCommand = storeCommand + ' ' + typeInformation.getId();
        lookupLoadCommand = "aload " + typeInformation.getId();
      } else if (dataType == DataType.INT) {
        storeCommand = "istore";
        lookupStoreCommand = storeCommand + ' ' + typeInformation.getId();
        lookupLoadCommand = "iload " + typeInformation.getId();
      } else if (dataType == DataType.FLOAT) {
        storeCommand = "fstore";
        lookupStoreCommand = storeCommand + ' ' + typeInformation.getId();
        lookupLoadCommand = "fload " + typeInformation.getId();
      }
      if (exprContext != null) {
        instructions = visit(exprContext) + '\n';
        instructions += storeCommand + ' ' + getVariableIndexByVariableIdToken(varIdToken);
        if (dataTypeStack.peek().getDataType() != dataType) {
          throw new WrongDataTypeException(varIdToken);
        }
        dataTypeStack.pop();
        return instructions;
      }
      return instructions;
    }
  }

  /**
   * Called if an assignment appears in the tree. A distinction is made between different scopes. If
   * a global scope exists, values of variables are added statically, otherwise locally. The <code>
   * putstatic</code> and <code>getstatic</code> commands apply to the global scope. On the other
   * hand, commands like <code>iload</code> or <code>aload</code> refer to the local scope. The
   * command <code>istore</code> gets the topmost int from the stack and places it in the table
   * regarding the variables. For example, the command <code>istore 5</code> places the specific
   * value at position 5 in this table. However, if there is an int array, for example, the
   * reference must first be fetched using <code>getstatic</code>. Then you can use <code>iastore
   * </code> (0x4F) to insert a value. The following commands (including the arrays) apply
   * analogously to the declaration:
   *
   * <ul>
   *   <li><code>fastore</code>: Refers to floats with the opcode 0x51 (81)
   *   <li><code>aastore</code>: Refers to strings with the opcode 0x53 (83)
   * </ul>
   *
   * If a data type is used incorrectly, an exception is thrown.
   *
   * @param ctx Rule for the assignment
   * @return Instruction regarding an assignment of a variable
   */
  @Override
  public String visitAssignment(AssignmentContext ctx) {
    if (ctx.expr == null) {
      return visitChildren(ctx);
    } else {
      // Generate code for expressions
      final String expressions = visit(ctx.expr);
      final Token varIdToken = ctx.varId;
      final String instructions = expressions + '\n';
      String targetTypeId;
      String result;
      // A variable may already have been declared
      if (isGlobalScope) {
        final TypeInformation typeInfo;
        typeInfo = getTypeInformationByStaticVariableIdToken(varIdToken);
        if (dataTypeStack.peek().getDataType() != typeInfo.getDataType() && !typeInfo.isArray()) {
          throw new WrongDataTypeException(varIdToken);
        }
        final int typeInfoId = typeInfo.getId();
        lookupStoreCommand = "putstatic " + namespace + "/v" + typeInfoId;
        lookupLoadCommand = "getstatic " + namespace + "/v" + typeInfoId;
        targetTypeId = Integer.toString(typeInfoId);
        final DataType dataType = typeInfo.getDataType();
        final String jvmType = dataType.getJvmType();
        switch (dataType) {
          case INT:
            result =
                instructions
                    + "putstatic "
                    + namespace
                    + "/v"
                    + targetTypeId
                    + ' '
                    + jvmType
                    + '\n';
            dataTypeStack.pop();
            break;
          case IARRAY:
            if (ctx.index == null) {
              // Create a new array
              result =
                  expressions
                      + '\n'
                      + "putstatic "
                      + namespace
                      + "/v"
                      + getVariableIndexByVariableIdToken(varIdToken)
                      + ' '
                      + jvmType;
            } else {
              // Visit the elements of the array and store the new value
              String index = visit(ctx.index) + '\n';
              result =
                  "getstatic "
                      + namespace
                      + "/v"
                      + targetTypeId
                      + ' '
                      + jvmType
                      + '\n'
                      + index
                      + instructions
                      + "iastore\n";
              // Because of the index
              dataTypeStack.push(new TypeInformation(DataType.INT));
              dataTypeStack.pop();
              dataTypeStack.pop();
            }
            break;
          case FLOAT:
            result =
                instructions
                    + "putstatic "
                    + namespace
                    + "/v"
                    + targetTypeId
                    + ' '
                    + jvmType
                    + '\n';
            dataTypeStack.pop();
            break;
          case FARRAY:
            if (ctx.index == null) {
              result =
                  expressions
                      + '\n'
                      + "putstatic "
                      + namespace
                      + "/v"
                      + getVariableIndexByVariableIdToken(varIdToken)
                      + ' '
                      + jvmType;
            } else {
              String index = visit(ctx.index) + '\n';
              result =
                  "getstatic "
                      + namespace
                      + "/v"
                      + targetTypeId
                      + ' '
                      + jvmType
                      + '\n'
                      + index
                      + instructions
                      + "fastore\n";
              // Because of the index
              dataTypeStack.push(new TypeInformation(DataType.INT));
              dataTypeStack.pop();
              dataTypeStack.pop();
            }
            break;
          case STRING:
            result =
                instructions
                    + "putstatic "
                    + namespace
                    + "/v"
                    + targetTypeId
                    + ' '
                    + jvmType
                    + '\n';
            dataTypeStack.pop();
            break;
          case SARRAY:
            if (ctx.index == null) {
              result =
                  expressions
                      + '\n'
                      + "putstatic "
                      + namespace
                      + "/v"
                      + getVariableIndexByVariableIdToken(varIdToken)
                      + ' '
                      + jvmType;
            } else {
              String index = visit(ctx.index) + '\n';
              result =
                  "getstatic "
                      + namespace
                      + "/v"
                      + targetTypeId
                      + ' '
                      + jvmType
                      + '\n'
                      + index
                      + instructions
                      + "aastore\n";
              // Because of the index
              dataTypeStack.push(new TypeInformation(DataType.INT));
              dataTypeStack.pop();
              dataTypeStack.pop();
            }
            break;
          default:
            // A reference
            result =
                instructions
                    + "putstatic "
                    + namespace
                    + "/v"
                    + targetTypeId
                    + ' '
                    + jvmType
                    + '\n';
            dataTypeStack.pop();
        }
        return result;
      } else {
        final TypeInformation typeInfo = getTypeInformationByVariableIdToken(varIdToken);
        targetTypeId = Integer.toString(typeInfo.getId());
        if (dataTypeStack.peek().getDataType() != typeInfo.getDataType()) {
          throw new WrongDataTypeException(varIdToken);
        }
        final int typeId = typeInfo.getId();
        switch (typeInfo.getDataType()) {
          case INT:
            result = instructions + "istore " + targetTypeId + '\n';
            lookupStoreCommand = "istore " + typeId;
            lookupLoadCommand = "iload " + typeId;
            dataTypeStack.pop();
            break;
          case IARRAY:
            String index = visit(ctx.index) + '\n';
            result = "aload " + targetTypeId + '\n' + index + instructions + "iastore\n";
            lookupStoreCommand = "astore " + typeId;
            lookupLoadCommand = "aload " + typeId;
            dataTypeStack.push(new TypeInformation(DataType.INT));
            dataTypeStack.pop();
            dataTypeStack.pop();
            break;
          case FLOAT:
            result = instructions + "fstore " + targetTypeId + '\n';
            lookupStoreCommand = "fstore " + typeId;
            lookupLoadCommand = "fload " + typeId;
            dataTypeStack.pop();
            break;
          case FARRAY:
            index = visit(ctx.index) + '\n';
            result = "aload " + targetTypeId + '\n' + index + instructions + "fastore\n";
            lookupStoreCommand = "astore " + typeId;
            lookupLoadCommand = "aload " + typeId;
            dataTypeStack.push(new TypeInformation(DataType.INT));
            dataTypeStack.pop();
            dataTypeStack.pop();
            break;
          case STRING:
            result = instructions + "astore " + targetTypeId + '\n';
            lookupStoreCommand = "astore " + typeId;
            lookupLoadCommand = "aload " + typeId;
            dataTypeStack.pop();
            break;
          case SARRAY:
            index = visit(ctx.index) + '\n';
            result = "aload " + targetTypeId + '\n' + index + instructions + "aastore\n";
            lookupStoreCommand = "astore " + typeId;
            lookupLoadCommand = "aload " + typeId;
            dataTypeStack.push(new TypeInformation(DataType.INT));
            dataTypeStack.pop();
            dataTypeStack.pop();
            break;
          default:
            result = instructions + "astore " + targetTypeId + '\n';
            lookupStoreCommand = "astore " + typeId;
            lookupLoadCommand = "aload " + typeId;
            dataTypeStack.pop();
            break;
        }
        return result;
      }
    }
  }

  /**
   * This accesses attributes of structures or assigns values.
   *
   * @param ctx Rule for the assignment regarding structs
   * @return Instructions for an assignment regarding structs
   */
  @Override
  public String visitStructVariableAssignment(StructVariableAssignmentContext ctx) {
    final int objectId;
    final TypeInformation typeInfoObject;
    final String varId = ctx.varId.getText();
    final int typeInfoObjectId;
    final String structVarId = ctx.structVarId.getText();
    String loadCommand;
    final int structVarIndex;
    final TypeInformation typeInfoStructVar;
    String jvmType;
    final String expression = visit(ctx.expr) + '\n';
    if (ctx.index == null) {
      // Primitive type or struct
      if (isGlobalScope) {
        final TypeInformation typeInfo = staticVarsNamesTypes.get(varId);
        if (typeInfo == null) {
          throw new UndeclaredVariableException(ctx.varId);
        }
        objectId = typeInfo.getAddress();
        typeInfoObject = getTypeInformationByStaticVariableIdToken(ctx.varId);
        lookupLoadCommand = "getstatic " + namespace + "/v" + typeInfoObject.getId();
        lookupStoreCommand = "putstatic " + namespace + "/v" + typeInfoObject.getId();
        loadCommand = lookupLoadCommand;
        loadCommand += " L" + typeNamespace + objectId + ';';
      } else {
        // Inside a function
        objectId = vars.get(varId).getAddress();
        typeInfoObject = getTypeInformationByVariableIdToken(ctx.varId);
        typeInfoObjectId = typeInfoObject.getId();
        final DataType dataType =
            structs
                .get(varId)
                .getTypes()
                .get(structs.get(varId).getAddress(structVarId))
                .getDataType();
        switch (dataType) {
          case INT:
            lookupLoadCommand = "iload " + typeInfoObjectId;
            lookupStoreCommand = "istore " + typeInfoObjectId;
          case FLOAT:
            lookupLoadCommand = "fload " + typeInfoObjectId;
            lookupStoreCommand = "fstore " + typeInfoObjectId;
          default:
            lookupLoadCommand = "aload " + typeInfoObjectId;
            lookupStoreCommand = "astore " + typeInfoObjectId;
        }
        loadCommand = lookupLoadCommand;
      }
      loadCommand += '\n';
      if ((new ArrayList<>(structs.values())).get(objectId).getAddress(structVarId) == null) {
        throw new UndeclaredVariableException(ctx.structVarId);
      }
      structVarIndex = (new ArrayList<>(structs.values())).get(objectId).getAddress(structVarId);
      typeInfoStructVar =
          (new ArrayList<>(structs.values())).get(objectId).getTypes().get(structVarIndex);
      jvmType = typeInfoStructVar.getJvmType();
      if (typeInfoStructVar.getDataType() == DataType.OBJREF) {
        jvmType = 'L' + typeNamespace + jvmType + ';';
      }
      dataTypeStack.pop();
      return loadCommand
          + expression
          + "putfield "
          + typeNamespace
          + objectId
          + "/a"
          + structVarIndex
          + ' '
          + jvmType
          + '\n';
    } else {
      // Array
      if (isGlobalScope) {
        objectId = staticVarsNamesTypes.get(varId).getAddress();
        typeInfoObject = getTypeInformationByStaticVariableIdToken(ctx.varId);
        lookupLoadCommand = "getstatic " + namespace + "/v" + typeInfoObject.getId();
        lookupStoreCommand = "putstatic " + namespace + "/v" + typeInfoObject.getId();
        loadCommand = lookupLoadCommand;
        loadCommand += " L" + typeNamespace + objectId + ';';
      } else {
        // Inside a function
        objectId = vars.get(varId).getAddress();
        typeInfoObject = getTypeInformationByVariableIdToken(ctx.varId);
        typeInfoObjectId = typeInfoObject.getId();
        lookupLoadCommand = "aload " + typeInfoObjectId;
        lookupStoreCommand = "astore " + typeInfoObjectId;
        loadCommand = lookupLoadCommand;
      }
      loadCommand += '\n';
      structVarIndex = (new ArrayList<>(structs.values())).get(objectId).getAddress(structVarId);
      typeInfoStructVar =
          (new ArrayList<>(structs.values())).get(objectId).getTypes().get(structVarIndex);
      jvmType = typeInfoStructVar.getJvmType();
      if (typeInfoStructVar.getDataType() == DataType.OBJREF) {
        jvmType = 'L' + typeNamespace + jvmType + ';';
      }
      dataTypeStack.pop();
      return loadCommand
          + expression
          + "putfield "
          + typeNamespace
          + objectId
          + "/a"
          + structVarIndex
          + ' '
          + jvmType
          + '\n';
    }
  }

  /**
   * Called as soon as a function is executed. This can happen anywhere in the source code. The
   * instruction <code>invokestatic</code> (followed by the class name) calls a static function. The
   * entire method signature is therefore specified. The opcode is 0xB8 (184).
   *
   * @param ctx Rule for the function call
   * @return Instructions for a function call
   */
  @Override
  public String visitFunctionCall(FunctionCallContext ctx) {
    // Get number of parameters
    final int paramNumber = ctx.currentParams.exprs.size();
    final TypeInformation[] params = new TypeInformation[paramNumber];
    StringBuilder argumentInstructions = new StringBuilder();
    for (int i = 0; i < paramNumber; i++) {
      // Save the values of the arguments to the stack
      argumentInstructions.append(visit(ctx.currentParams.expression(i))).append('\n');
      // Get types of the parameters
      params[i] = dataTypeStack.peek();
    }
    // If the called function does not exist
    if (!functions.contains(ctx.funcId.getText(), params)) {
      throw new UndefinedFunctionException(ctx.funcId);
    } else {
      final TypeInformation typeInfo;
      typeInfo =
          Objects.requireNonNull(functions.get(ctx.funcId.getText(), paramNumber)).getTypeInfo();
      final StringBuilder instructions = new StringBuilder();
      instructions.append(argumentInstructions.toString()).append('\n');
      instructions
          .append("invokestatic ")
          .append(namespace)
          .append('/')
          .append(ctx.funcId.getText())
          .append('(');
      // Iterate over the parameter types
      for (final TypeInformation paramType : params) {
        String jvmType = paramType.getJvmType();
        if (paramType.getDataType() == DataType.OBJREF) {
          jvmType = 'L' + typeNamespace + paramType.getJvmType() + ';';
        }
        instructions.append(jvmType);
      }
      instructions.append(')');
      String jvmType = typeInfo.getJvmType();
      if (typeInfo.getDataType() == DataType.OBJREF) {
        jvmType = 'L' + typeNamespace + typeInfo.getJvmType() + ';';
      }
      instructions.append(jvmType);
      for (int i = 0; i < paramNumber; ++i) {
        // Because each argument creates a value on the stack
        dataTypeStack.pop();
      }
      dataTypeStack.push(typeInfo);
      return instructions.toString();
    }
  }

  /**
   * Is called if a branch like if-else exists. The branch was implemented with the command <code>
   * ifne</code> and the respective opcode is 0x9A (154). The basic structure is "ifne onTrue ..
   * false .. goto exit .. onTrue: true .. exit: ...".
   *
   * @param ctx Rule for the branch
   * @return Instructions regarding the branch
   */
  @Override
  public String visitBranch(BranchContext ctx) {
    // Generate code for conditions (0 or 1)
    final String instructions = visit(ctx.cond);
    dataTypeStack.pop();
    // If the condition is true (everything except 0 is true), this code is generated
    String onTrueInstructions = visit(ctx.onTrue);
    if (onTrueInstructions == null) {
      onTrueInstructions = "";
    }
    // If the condition is false, this code is generated
    String onFalseInstructions = "";
    if (ctx.onFalse != null) {
      // So there is an else part
      onFalseInstructions = visit(ctx.onFalse);
      if (onFalseInstructions == null) {
        onFalseInstructions = "";
      }
    }
    // Each branch must be unique
    return instructions
        + '\n'
        + "ifne onTrue"
        + ++branchCounter
        + '\n'
        + onFalseInstructions
        + '\n'
        + "goto endIf"
        + branchCounter
        + '\n'
        + "onTrue"
        + branchCounter
        + ":\n"
        + onTrueInstructions
        + '\n'
        + "endIf"
        + branchCounter
        + ":\n";
  }

  /**
   * Is called if a loop like <code>while</code> exists. The loop was implemented with the command
   * <code>ifeq</code>. For example, the structure is "ldc 0 putstatic e_test_main/a0 I beginLoop1:
   * getstatic e_test_main/a0 I ldc 3 if_icmplt onCmpTrue1 ldc 0 goto endCmp1 onCmpTrue1: ldc 1
   * endCmp1: ifeq endLoop1 getstatic e_test_main/a0 ldc 1 iadd pustatic e_test_main/a0 ... goto
   * beginLoop1 endLoop1: ...".
   *
   * @see EVisitor#visitBranch(BranchContext)
   * @param ctx Rule for the loop
   * @return Instructions regarding the loop
   */
  @Override
  public String visitLoop(LoopContext ctx) {
    final String conditionInstructions = visit(ctx.cond);
    dataTypeStack.pop();
    String body = visit(ctx.body);
    if (body == null) {
      body = "";
    }
    return "beginLoop"
        + ++loopCounter
        + ":\n"
        + conditionInstructions
        + "\nifeq endLoop"
        + loopCounter
        + '\n'
        + body
        + "\ngoto beginLoop"
        + loopCounter
        + "\nendLoop"
        + loopCounter
        + ":\n";
  }

  /**
   * This visitor is called when an included function is called, e.g. from the standard library.
   *
   * @param ctx Rule for the included function call
   * @return Instructions regarding the included function call
   */
  @Override
  public String visitIncludedFunctionCall(IncludedFunctionCallContext ctx) {
    // Try to get the address of the included file like "math"
    if (includedModules.get(ctx.inclDir.getText()) == null) {
      throw new UnknownModuleException(ctx.inclDir);
    }
    final StringBuilder argumentInstructions = new StringBuilder();
    final int paramNumber = ctx.args.exprs.size();
    final TypeInformation[] params = new TypeInformation[paramNumber];
    for (int i = 0; i < paramNumber; i++) {
      argumentInstructions.append(visit(ctx.args.expression(i))).append('\n');
      params[i] = dataTypeStack.peek();
    }
    final StringBuilder paramTypes = new StringBuilder();
    for (final TypeInformation typeInfo : params) {
      paramTypes.append(typeInfo.getJvmType());
    }
    final DataType returnType = DataType.getType(ctx.type.getText());
    //
    String instructions =
        argumentInstructions.toString()
            + '\n'
            + "invokestatic "
            + includedModules.get(ctx.inclDir.getText())
            + '/'
            + ctx.funcId.getText()
            + '('
            + paramTypes.toString()
            + ')'
            + returnType.getJvmType();
    for (int i = 0; i < paramNumber; ++i) {
      dataTypeStack.pop();
    }
    dataTypeStack.push(new TypeInformation(returnType));
    return instructions;
  }

  /**
   * When a standard routine is called, this visitor becomes active. Among others, the following
   * standard functions are available:
   *
   * <ul>
   *   <li>f2i, i2f: Refers to primitive types with the opcodes 0x8B (139) and 0x86 (134)
   *   <li>toString, ...: Refers to objects like strings.
   * </ul>
   *
   * For example, <code>i2f</code> pops an int off the operand stack, casts it into a
   * single-precision float, and pushes the float back onto the stack. If a system function is not
   * found, an exception is thrown. For <code>append</code> the command <code>invokespecial</code>
   * with the opcode 0xB7 (183) is used to create an object of the StringBuffer.
   *
   * @param ctx Rule for the built-in function call
   * @return Instructions regarding the built-in function call
   */
  @Override
  public String visitBuiltinFunctionCall(BuiltinFunctionCallContext ctx) {
    final int paramNumber = ctx.currentParams.exprs.size();
    final List<String> argumentInstructionsContainer = new ArrayList<>();
    final StringBuilder argumentInstructions = new StringBuilder();
    for (int i = 0; i < ctx.currentParams.exprs.size(); ++i) {
      argumentInstructionsContainer.add(visit(ctx.currentParams.expression(i)) + '\n');
      argumentInstructions.append(argumentInstructionsContainer.get(i));
    }
    final String builtinFuncId = ctx.funcId.getText();
    String commands;
    final DataType dataType = dataTypeStack.peek().getDataType();
    DataType targetDataType;
    switch (builtinFuncId) {
      case "toInt":
        if (dataType == DataType.FLOAT) {
          commands = "f2i";
        } else if (dataType == DataType.STRING) {
          commands = "invokestatic java/lang/Integer.parseInt(Ljava/lang/String;)I";
        } else {
          throw new WrongDataTypeException(ctx.funcId);
        }
        targetDataType = DataType.INT;
        break;
      case "toFloat":
        if (dataType == DataType.INT) {
          commands = "i2f";
        } else if (dataType == DataType.STRING) {
          commands = "invokestatic java/lang/Float.parseFloat(Ljava/lang/String;)F";
        } else {
          throw new WrongDataTypeException(ctx.funcId);
        }
        targetDataType = DataType.FLOAT;
        break;
      case "toString":
        if (dataType == DataType.INT) {
          commands = "invokestatic java/lang/Integer.toString(I)Ljava/lang/String;";
        } else if (dataType == DataType.FLOAT) {
          commands = "invokestatic java/lang/Float.toString(F)Ljava/lang/String;";
        } else {
          throw new WrongDataTypeException(ctx.funcId);
        }
        targetDataType = DataType.STRING;
        break;
      case "append":
        commands =
            "new java/lang/StringBuffer\n"
                + "dup\n"
                + "invokespecial java/lang/StringBuffer/<init>()V\n"
                + argumentInstructionsContainer.get(0)
                + '\n'
                + "invokevirtual java/lang/StringBuffer/append(Ljava/lang/String;)Ljava/lang/StringBuffer;\n"
                + argumentInstructionsContainer.get(1)
                + '\n'
                + "invokevirtual java/lang/StringBuffer/append(Ljava/lang/String;)Ljava/lang/StringBuffer;\n"
                + "invokevirtual java/lang/StringBuffer/toString()Ljava/lang/String;";
        targetDataType = DataType.STRING;
        argumentInstructions.setLength(0);
        break;
      case "length":
        commands = "arraylength";
        targetDataType = DataType.INT;
        break;
      default:
        throw new UnknownBuiltinFunctionException(ctx.funcId);
    }
    for (int i = 0; i < paramNumber; ++i) {
      dataTypeStack.pop();
    }
    dataTypeStack.push(new TypeInformation(targetDataType));
    return argumentInstructions + commands;
  }

  /**
   * Called when an assembly block is introduced by "asm".
   *
   * @param ctx Rule for an assembly block
   * @return Instructions regarding assembly
   */
  @Override
  public String visitInlineAssembly(InlineAssemblyContext ctx) {
    return ctx.str.getText().replaceAll("\"", "");
  }

  /**
   * Called when an assembly block is executed.
   *
   * @param ctx Rule for an executed assembly block
   * @return Instructions regarding executed assembly
   */
  @Override
  public String visitInvokeAssembly(InvokeAssemblyContext ctx) {
    final StringBuilder jvmTypes = new StringBuilder();
    for (int i = 0; i < ctx.args.size(); ++i) {
      jvmTypes.append(visit(ctx.args.get(i)));
      dataTypeStack.pop();
    }
    final DataType dataType = DataType.getType(ctx.returnType.getText().replaceAll("\"", ""));
    dataTypeStack.push(new TypeInformation(dataType));
    String returnType = dataType.getJvmType();
    if (dataType == DataType.OBJREF) {
      returnType = ctx.returnType.getText().replaceAll("\"", "");
    }
    return "invoke"
        + ctx.mod.getText().replaceAll("\"", "")
        + " "
        + ctx.id.getText().replaceAll("\"", "")
        + '('
        + jvmTypes.toString()
        + ')'
        + returnType
        + '\n';
  }

  /**
   * Initializes an object using <code>invokespecial</code> and <code>dup</code>, for example <code>
   * invokespecial java/lang/StringBuffer/<init>()V</code> The opcode is 0x59 (89).
   *
   * @param ctx Rule for creating a new object
   * @return Instructions regarding creating a new object
   */
  @Override
  public String visitInitObject(InitObjectContext ctx) {
    dataTypeStack.push(new TypeInformation(DataType.OBJREF));
    return "new "
        + ctx.type.getText().replaceAll("\"", "")
        + "\ndup\n"
        + "invokespecial "
        + ctx.type.getText().replaceAll("\"", "")
        + "/<init>()V\n";
  }

  /**
   * This can be used to push something onto the stack within assembly blocks.
   *
   * @param ctx Rule to push something onto the stack
   * @return Code for childs
   */
  @Override
  public String visitPushToStack(PushToStackContext ctx) {
    return visitChildren(ctx);
  }

  /**
   * This can be used to visit the top element in the stack.
   *
   * @param ctx Rule for visiting the top element in the stack
   * @return Empty (not important)
   */
  @Override
  public String visitSetTopOfStack(SetTopOfStackContext ctx) {
    final DataType dataType = DataType.getType(ctx.type.getText().replaceAll("\"", ""));
    dataTypeStack.push(new TypeInformation(dataType));
    return "";
  }

  /**
   * Cleans the parameters during inline assembly.
   *
   * @param ctx Rule for cleaning the assembly parameters
   * @return Cleaned parameters
   */
  @Override
  public String visitJvmType(JvmTypeContext ctx) {
    return ctx.getText().replaceAll("\"", "");
  }

  /**
   * Called when a function is defined. The return value is placed on the stack and returned using a
   * command depends on a type. There are the following types:
   *
   * <ul>
   *   <li><code>ireturn</code>: Refers to integers with the opcode 0xAC (172)
   *   <li><code>freturn</code>: Refers to floats with the opcode 0xAE (174)
   *   <li><code>areturn</code>: Refers to strings (references) with the opcode 0xB0 (176)
   * </ul>
   *
   * For example, such a command pops a type from the top of the stack and pushes it onto the
   * operand stack of the invoker (i.e. the method which used invokevirtual, invokespecial,
   * invokestatic or invokeinterface to call the currently executing method).
   *
   * @param ctx Rule for the function definition
   * @return Instructions for a function definition
   */
  @Override
  public String visitFunctionDefinition(FunctionDefinitionContext ctx) {
    // Set a local scope
    isGlobalScope = false;
    vars = new HashMap<>();
    DataTypeStack globaldataTypeStack = dataTypeStack;
    dataTypeStack = new DataTypeStack();
    // Store all variables regarding formal parameters
    visit(ctx.formalParams);
    // Generate code for the statements in the function body
    final String statementInstructions = visit(ctx.stmts);
    final StringBuilder instructions =
        new StringBuilder(".method public static " + ctx.funcId.getText() + '(');
    final int parameterNumber = ctx.formalParams.decls.size();
    TypeInformation[] paramTypes =
        Objects.requireNonNull(functions.get(ctx.funcId.getText(), parameterNumber)).getParams();
    final DataType dataType = DataType.getType(ctx.type.getText());
    String returnType;
    switch (dataType) {
      case VOID:
        returnType = "return";
        break;
      case INT:
        returnType = "ireturn";
        break;
      case FLOAT:
        returnType = "freturn";
        break;
      case STRING:
        returnType = "areturn";
        break;
      default:
        throw new WrongDataTypeException(ctx.start);
    }
    for (final TypeInformation paramType : paramTypes) {
      String jvmType = paramType.getJvmType();
      if (paramType.getDataType() == DataType.OBJREF) {
        jvmType = 'L' + typeNamespace + paramType.getJvmType() + ';';
      }
      instructions.append(jvmType);
      dataTypeStack.push(paramType);
    }
    ExpressionContext returnVal = ctx.returnVal;
    instructions
        .append(')')
        .append(dataType.getJvmType())
        .append("\n.limit locals ")
        .append(vars.size())
        .append("\n.limit stack ")
        .append(dataTypeStack.getMaxStackSize())
        .append('\n')
        .append(statementInstructions == null ? "" : statementInstructions + '\n')
        .append(
            // Get instructions
            returnVal == null ? "" : visit(returnVal))
        .append('\n')
        .append(returnType)
        .append("\n.end method\n");
    // Check if there is a value you can take down
    if (returnVal != null) {
      dataTypeStack.pop();
    }
    vars = new HashMap<>();
    dataTypeStack = globaldataTypeStack;
    // Switch to global scope
    isGlobalScope = true;
    return instructions.toString();
  }

  /**
   * Called when declaring a custom type using the keyword "struct". Furthermore, attributes are
   * assigned to the structure via ".field". Internally, a structure is translated into a class and
   * stored in a separate file. Among other things, the index in a loop is used as a suffix for the
   * variable name.
   *
   * @param ctx Rule for the struct declaration
   * @return Instructions for a struct declaration
   */
  @Override
  public String visitStructDeclaration(StructDeclarationContext ctx) {
    final StringBuilder vars = new StringBuilder();
    // Get struct
    final CustomType struct = structs.get(ctx.structId.getText());
    // Get type infos of the relevant struct
    final List<TypeInformation> typeInfos = struct.getTypes();
    // Create attributes with ".field"
    for (int i = 0; i < typeInfos.size(); ++i) {
      final DataType dataType = typeInfos.get(i).getDataType();
      if (dataType != DataType.OBJREF) {
        vars.append(".field public a")
            .append(i)
            .append(' ')
            .append(dataType.getJvmType())
            .append("\n");
      } else {
        vars.append(".field public a")
            .append(i)
            .append(" L")
            .append(typeNamespace)
            .append(dataType.getJvmType())
            .append(";\n");
      }
    }
    return ".class "
        + typeNamespace
        + struct.getId()
        + "\n.super java/lang/Object\n\n"
        + vars.toString()
        + ".method public <init>()V\n"
        + "aload_0\n"
        + "invokespecial java/lang/Object/<init>()V\n"
        + "return\n"
        + ".end method\n";
  }

  /**
   * When a structure is initialized, this visitor is called. A distinction is made between an array
   * and a structure. For example, "invokespecial" must be called for an object in order to create
   * it.
   *
   * @param ctx Rule for the struct initialization
   * @return Instructions for a struct initialization
   */
  @Override
  public String visitStructArrayInitialization(StructArrayInitializationContext ctx) {
    if (ctx.size == null) {
      // Struct
      if (structs.get(ctx.object.getText()) == null) {
        throw new UndeclaredStructException(ctx.object.start);
      }
      final int structId = structs.get(ctx.object.getText()).getId();
      lookupStructId = structId;
      final StringBuilder instructions =
          new StringBuilder("new ")
              .append(typeNamespace)
              .append(structId)
              .append("\ndup\ninvokespecial ")
              .append(typeNamespace)
              .append(structId)
              .append("/<init>()V\n")
              .append(lookupStoreCommand);
      if (isGlobalScope) {
        instructions.append(" L").append(typeNamespace).append(structId).append(';');
      }
      instructions.append('\n').append(visit(ctx.args)).append(lookupLoadCommand);
      if (isGlobalScope) {
        instructions.append(" L").append(typeNamespace).append(lookupStructId).append(';');
      }
      instructions.append('\n');
      dataTypeStack.push(new TypeInformation(DataType.OBJREF, structId));
      return instructions.toString();
    } else {
      // Array
      final String elementInstructions = visit(ctx.size);
      final String arrayCommand;
      final String type;
      dataTypeStack.pop();
      final DataType dataType = DataType.getType(ctx.type.getText());
      final DataType arrayType;
      switch (dataType) {
        case INT:
          arrayType = DataType.IARRAY;
          arrayCommand = "newarray";
          type = DataType.INT.getType();
          break;
        case FLOAT:
          arrayType = DataType.FARRAY;
          arrayCommand = "newarray";
          type = DataType.FLOAT.getType();
          break;
        case STRING:
          arrayType = DataType.SARRAY;
          arrayCommand = "anewarray";
          type = "java/lang/String";
          break;
        default:
          throw new WrongDataTypeException(ctx.start);
      }
      dataTypeStack.push(new TypeInformation(arrayType));
      return elementInstructions + '\n' + arrayCommand + ' ' + type + '\n';
    }
  }

  /**
   * When a structure is instantiated, the current attributes must be transferred to formal
   * attributes. In this context, the command <code>putfield</code> with the opcode 0xB5 (181) sets
   * the value of the field identified by a field specification in a reference to an object to the
   * single or double word value on the operand stack.
   *
   * @param ctx Rule for the struct initialization
   * @return Instructions for a struct initialization
   */
  @Override
  public String visitAssignments(AssignmentsContext ctx) {
    final StringBuilder instructions = new StringBuilder();
    for (int i = 0; i < ctx.asgmts.size(); ++i) {
      final String expression = visit(ctx.asgmts.get(i)) + '\n';
      instructions.append(lookupLoadCommand);
      if (isGlobalScope) {
        instructions.append(" L").append(typeNamespace).append(lookupStructId).append(';');
      }
      instructions.append('\n').append(expression);
      final TypeInformation typeInfo =
          (new ArrayList<>(structs.values())).get(lookupStructId).getTypes().get(i);
      String jvmType = typeInfo.getJvmType();
      if (typeInfo.getDataType() == DataType.OBJREF) {
        jvmType = 'L' + typeNamespace + jvmType + ';';
      }
      instructions
          .append("putfield ")
          .append(typeNamespace)
          .append(lookupStructId)
          .append("/a")
          .append(i)
          .append(' ')
          .append(jvmType)
          .append("\n");
    }
    return instructions.toString();
  }

  /**
   * Is called when a value is to be negated. The following operations are available:
   *
   * <ul>
   *   <li><code>ineg</code>: Refers to integers with opcode 0x74 (116)
   *   <li><code>fneg</code>: Refers to floating point numbers with opcode 0x76 (118)
   * </ul>
   *
   * For example, it pops an int off the stack, negates it, and pushes the negated integer value
   * back onto the stack.
   *
   * @param ctx Negation rule
   * @return Instructions that depend on the negation
   */
  @Override
  public String visitUnaryMinusExpression(UnaryMinusExpressionContext ctx) {
    String instructions = visitChildren(ctx);
    final TypeInformation typeInfo = dataTypeStack.pop();
    switch (typeInfo.getDataType()) {
      case INT:
        instructions += "\nineg";
        break;
      case FLOAT:
        instructions += "\nfneg";
        break;
      default:
        throw new WrongDataTypeException(ctx.start);
    }
    dataTypeStack.push(typeInfo);
    return instructions;
  }

  /**
   * Is called if there is a division, multiplication or modulo operation. Depending on the data
   * types, the following commands are available:
   *
   * <ul>
   *   <li><code>imul (0x68), fmul (0x6A)</code>: Refers to multiplication
   *   <li><code>idiv (0x6C), fdiv (0x6E)</code>: Refers to division
   *   <li><code>irem (0x70), frem (0x72)</code>: Refers to modulo
   * </ul>
   *
   * For example, <code>imul</code> pops the top two integers from the operand stack, multiplies
   * them and pushes the integer result back onto the stack. On overflow, <code>imul</code> produces
   * a result whose low order bits are correct, but whose sign bit may be incorrect. The operation
   * <code>idiv</code> divides the second-from top integer (value2) by the top integer (value1),
   * i.e. computes (value2 div value1). If there is an attempt to divide by 0, an exception will be
   * thrown. The operation <code>irem</code> pops two integers from the operand stack, divides
   * value2 by value1, computes the remainder and pushes the integer remainder back onto the stack.
   *
   * @param ctx DivisionMultiplicationModulo rule
   * @return Instructions that depend on the division, multiplication or modulo operation
   */
  @Override
  public String visitDivisionMultiplicationModuloExpression(
      DivisionMultiplicationModuloExpressionContext ctx) {
    String instructions = visitChildren(ctx);
    final TypeInformation typeInfo = dataTypeStack.peek();
    final DataType leftOperandType = dataTypeStack.pop().getDataType();
    final DataType rightOperandType = dataTypeStack.pop().getDataType();
    // Only integer and floating point numbers are allowed
    if (leftOperandType != DataType.INT && leftOperandType != DataType.FLOAT
        || leftOperandType != rightOperandType) {
      throw new WrongDataTypeException(ctx.start);
    }
    final String arithmeticOperator = ctx.op.getText();
    switch (arithmeticOperator) {
      case "/":
        switch (typeInfo.getDataType()) {
          case INT:
            instructions += "\nidiv";
            break;
          case FLOAT:
            instructions += "\nfdiv";
            break;
          default:
            throw new WrongDataTypeException(ctx.start);
        }
        break;
      case "*":
        switch (typeInfo.getDataType()) {
          case INT:
            instructions += "\nimul";
            break;
          case FLOAT:
            instructions += "\nfmul";
            break;
          default:
            throw new WrongDataTypeException(ctx.start);
        }
        break;
      case "%":
        switch (typeInfo.getDataType()) {
          case INT:
            instructions += "\nirem";
            break;
          case FLOAT:
            instructions += "\nfrem";
            break;
          default:
            throw new WrongDataTypeException(ctx.start);
        }
        break;
      default:
        throw new IllegalArgumentException("Unknown operator: " + arithmeticOperator);
    }
    dataTypeStack.push(typeInfo);
    return instructions;
  }

  /**
   * Is called if there is an subtraction or addition. Depending on the data types, the following
   * commands are available:
   *
   * <ul>
   *   <li><code>isub (0x64), fsub (0x66)</code>: Refers to subtraction
   *   <li><code>iadd (0x60), fadd (0x62)</code>: Refers to addition
   * </ul>
   *
   * Here, the readability for the visitor was increased by using labels. For example, he operation
   * <code>isub</code> pops two integers from the operand stack, subtracts the top one from the
   * second and pushes the int result back onto the stack. The operation <code>iadd</code> pops two
   * integers from the operand stack, adds them and pushes the integer result back onto the stack.
   * On overflow, <code>iadd</code> produces a result whose low order bits are correct, but whose
   * sign bit may be incorrect.
   *
   * @param ctx SubtractionAddition rule
   * @return Instructions that depend on the subtraction or addition
   */
  @Override
  public String visitSubtractionAdditionExpression(SubtractionAdditionExpressionContext ctx) {
    String instructions = visitChildren(ctx);
    final TypeInformation typeInfo = dataTypeStack.peek();
    final DataType leftOperandType = dataTypeStack.pop().getDataType();
    final DataType rightOperandType = dataTypeStack.pop().getDataType();
    // Only integer and floating point numbers are allowed
    if (leftOperandType != DataType.INT && leftOperandType != DataType.FLOAT
        || leftOperandType != rightOperandType) {
      throw new WrongDataTypeException(ctx.start);
    }
    final String arithmeticOperator = ctx.op.getText();
    switch (arithmeticOperator) {
      case "-":
        switch (typeInfo.getDataType()) {
          case INT:
            instructions += "\nisub";
            break;
          case FLOAT:
            instructions += "\nfsub";
            break;
          default:
            throw new WrongDataTypeException(ctx.start);
        }
        break;
      case "+":
        switch (typeInfo.getDataType()) {
          case INT:
            instructions += "\niadd";
            break;
          case FLOAT:
            instructions += "\nfadd";
            break;
          default:
            throw new WrongDataTypeException(ctx.start);
        }
        break;
      default:
        throw new IllegalArgumentException("Unknown arithmetic operator: " + arithmeticOperator);
    }
    dataTypeStack.push(typeInfo);
    return instructions;
  }

  /**
   * Visited when an integer shift appears. The command <code>ishl</code> (0x78) pops two ints off
   * the stack. It shifts value2 left by the amount indicated in the five low bits of value1. The
   * int result is then pushed back onto the stack. On the other hand, the command <code>ishr</code>
   * (0x7A) shifts value1 right by the amount indicated in the five low bits of value2.
   *
   * @param ctx Shift rule
   * @return Instructions that depend on the shifts
   */
  @Override
  public String visitShiftExpression(ShiftExpressionContext ctx) {
    String instructions = visitChildren(ctx);
    final TypeInformation typeInfo = dataTypeStack.peek();
    final DataType leftOperandType = dataTypeStack.pop().getDataType();
    final DataType rightOperandType = dataTypeStack.pop().getDataType();
    if (leftOperandType != DataType.INT || leftOperandType != rightOperandType) {
      throw new WrongDataTypeException(ctx.start);
    }
    final String shiftOperator = ctx.op.getText();
    switch (shiftOperator) {
      case "<<":
        if (typeInfo.getDataType() == DataType.INT) {
          instructions += "\nishl";
        } else {
          throw new WrongDataTypeException(ctx.start);
        }
        break;
      case ">>":
        if (typeInfo.getDataType() == DataType.INT) {
          instructions += "\nishr";
        } else {
          throw new WrongDataTypeException(ctx.start);
        }
        break;
      default:
        throw new IllegalArgumentException("Unknown shift operator: " + shiftOperator);
    }
    dataTypeStack.push(typeInfo);
    return instructions;
  }

  /**
   * Called when a relational operation like "lower than" and so on is present. For this reason,
   * there are several commands:
   *
   * <ul>
   *   <li><code>if_icmplt</code>: "Lower than" with opcode 0xA1 (161)
   *   <li><code>if_icmple</code>: "Lower than or equal" with opcode 0xA4 (164)
   *   <li><code>if_icmpgt</code>: "Greater than" with opcode 0xA3 (163)
   *   <li><code>if_icmpge</code>: "Greater than or equal" with opcode 0xA2 (162)
   *   <li><code>if_icmpeq</code>: "Equal" with opcode 0x9F (159)
   *   <li><code>if_icmpne</code>: "Not equal" with opcode 0xA0 (160)
   * </ul>
   *
   * Generally, these operations pop the top two ints off the stack and compares them. For example,
   * if value2 is less than value1, the execution branches to the address (pc + branchoffset), where
   * pc is the address of the <code>if_icmplt</code> opcode in the bytecode and branchoffset is a
   * 16-bit signed integer parameter following the <code>if_icmplt</code> opcode in the bytecode. If
   * value2 is greater than or equal to value1, execution continues at the next instruction in this
   * context.
   *
   * @param ctx Relational rule
   * @return Instructions that depend on the comparisons
   */
  @Override
  public String visitRelationalExpression(RelationalExpressionContext ctx) {
    final String jumpInstruction;
    final String instructions = visitChildren(ctx);
    // Two operands were removed by the jumps, put one back up
    final DataType leftOperandType = dataTypeStack.pop().getDataType();
    final DataType rightOperandType = dataTypeStack.pop().getDataType();
    if (leftOperandType != rightOperandType) {
      throw new WrongDataTypeException(ctx.start);
    }
    final String relationalOperator = ctx.op.getText();
    switch (relationalOperator) {
      case "<":
        jumpInstruction = "if_icmplt";
        break;
      case "<=":
        jumpInstruction = "if_icmple";
        break;
      case ">":
        jumpInstruction = "if_icmpgt";
        break;
      case ">=":
        jumpInstruction = "if_icmpge";
        break;
      case "==":
        jumpInstruction = "if_icmpeq";
        break;
      case "!=":
        jumpInstruction = "if_icmpne";
        break;
      default:
        throw new IllegalArgumentException("Unknown relational operator: " + relationalOperator);
    }
    dataTypeStack.push(new TypeInformation(DataType.INT));
    return instructions
        + '\n'
        + jumpInstruction
        + " onCmpTrue"
        + ++comparisonCounter
        + '\n'
        + "ldc 0\n"
        + "goto endCmp"
        + comparisonCounter
        + '\n'
        + "onCmpTrue"
        + comparisonCounter
        + ":\n"
        + "ldc 1\n"
        + "endCmp"
        + comparisonCounter
        + ':';
  }

  /**
   * Called when a conjunction is present. The operation <code>iand</code> is deliberately omitted
   * in order to use a lazy evaluation. Instead, <code>ifeq</code> is used with opcode 0x99 (153).
   * The command <code>ifeq</code> pops the top int off the operand stack. If the int equals zero,
   * execution branches to the address (pc + branchoffset), where pc is the address of the ifeq
   * opcode in the bytecode and branchoffset is a 16-bit signed integer parameter following the ifeq
   * opcode in the bytecode. If the int on the stack does not equal zero, execution continues at the
   * next instruction.
   *
   * @param ctx Conjunction rule
   * @return Instructions that depend on the conjunction
   */
  @Override
  public String visitConjunctionExpression(ConjunctionExpressionContext ctx) {
    final String leftInstructions = visit(ctx.lExpr);
    // This part may be skipped later
    final String rightInstructions = visit(ctx.rExpr);
    final DataType leftOperandType = dataTypeStack.pop().getDataType();
    final DataType rightOperandType = dataTypeStack.pop().getDataType();
    if (leftOperandType != DataType.INT && leftOperandType != DataType.BOOL
        || leftOperandType != rightOperandType) {
      throw new WrongDataTypeException(ctx.start);
    }
    final String instructions =
        leftInstructions
            + '\n'
            + "ifeq onAndFalse"
            + ++conjunctionCounter
            + '\n'
            + rightInstructions
            + '\n'
            + "ifeq onAndFalse"
            + conjunctionCounter
            + '\n'
            + "ldc 1\n"
            + "goto endAnd"
            + conjunctionCounter
            + '\n'
            + "onAndFalse"
            + conjunctionCounter
            + ":\n"
            + "ldc 0\n"
            + "endAnd"
            + conjunctionCounter
            + ":\n";
    dataTypeStack.push(new TypeInformation(DataType.INT));
    return instructions;
  }

  /**
   * Called when a disjunction is present. Similar to the conjunction, <code>ior</code> is not used
   * here. However, <code>efne</code> is used to ensure a lazy evaluation. The logic is therefore
   * only reversed here.
   *
   * @param ctx Disjunction rule
   * @return Instructions that depend on the disjunction
   * @see EVisitor#visitConjunctionExpression
   */
  @Override
  public String visitDisjunctionExpression(DisjunctionExpressionContext ctx) {
    // Split instructions for lazy evaluation
    final String leftInstructions = visit(ctx.lExpr);
    final String rightInstructions = visit(ctx.rExpr);
    final DataType leftOperandType = dataTypeStack.pop().getDataType();
    final DataType rightOperandType = dataTypeStack.pop().getDataType();
    if (leftOperandType != DataType.INT && leftOperandType != DataType.BOOL
        || leftOperandType != rightOperandType) {
      throw new WrongDataTypeException(ctx.start);
    }
    final String instructions =
        leftInstructions
            + '\n'
            + "ifne onOrTrue"
            + ++disjunctionCounter
            + '\n'
            + rightInstructions
            + '\n'
            + "ifne onOrTrue"
            + disjunctionCounter
            + '\n'
            + "ldc 0\n"
            + "goto endOr"
            + disjunctionCounter
            + '\n'
            + "onOrTrue"
            + disjunctionCounter
            + ":\n"
            + "ldc 1\n"
            + "endOr"
            + disjunctionCounter
            + ":\n";
    dataTypeStack.push(new TypeInformation(DataType.INT));
    return instructions;
  }

  /**
   * Called when a contravalence is present. Pops two integers off the operand stack. Computes the
   * bitwise exclusive or of value1 and value2. The integer result replaces value1 and value2 on the
   * stack. The opcode is 0x82 (130).
   *
   * @param ctx Contravalence rule
   * @return Instructions that depend on the contravalence
   */
  @Override
  public String visitContravalenceExpression(ContravalenceExpressionContext ctx) {
    final String instructions = visitChildren(ctx) + "\nixor";
    final DataType leftOperandType = dataTypeStack.pop().getDataType();
    final DataType rightOperandType = dataTypeStack.pop().getDataType();
    if (leftOperandType != DataType.INT && leftOperandType != DataType.BOOL
        || leftOperandType != rightOperandType) {
      throw new WrongDataTypeException(ctx.start);
    }
    dataTypeStack.push(new TypeInformation(DataType.INT));
    return instructions;
  }

  /**
   * Is called when an attribute of a structure is accessed.
   *
   * @param ctx Struct rule
   * @return Instructions regarding a struct access
   */
  @Override
  public String visitStructExpression(StructExpressionContext ctx) {
    final String structId = ctx.structId.getText();
    final TypeInformation typeInfoVar = staticVarsNamesTypes.get(structId);
    if (typeInfoVar == null) {
      throw new UndeclaredStructException(ctx.structId);
    }
    final int typeInfoId = typeInfoVar.getId();
    final int structAddress = staticVarsNamesTypes.get(structId).getAddress();
    final int index =
        (new ArrayList<>(structs.values())).get(structAddress).getAddress(ctx.varId.getText());
    final TypeInformation typeInfo =
        (new ArrayList<>(structs.values())).get(structAddress).getTypes().get(index);
    String jvmType = typeInfo.getJvmType();
    if (typeInfo.getDataType() == DataType.OBJREF) {
      jvmType = 'L' + typeNamespace + jvmType + ';';
    }
    dataTypeStack.push(
        (new ArrayList<>(structs.values())).get(structAddress).getTypes().get(index));
    if (isGlobalScope) {
      return "getstatic "
          + namespace
          + "/v"
          + typeInfoId
          + " L"
          + typeNamespace
          + structAddress
          + ";\ngetfield "
          + typeNamespace
          + structAddress
          + "/a"
          + index
          + " "
          + jvmType
          + '\n';
    } else {
      return "aload "
          + typeInfoId
          + '\n'
          + "getfield "
          + typeNamespace
          + vars.get(structId).getAddress()
          + "/a"
          + index
          + ' '
          + jvmType
          + '\n';
    }
  }

  /**
   * Is called when accessing a slot in an array.
   *
   * @param ctx Array rule
   * @return Instructions regarding an array access
   */
  @Override
  public String visitArrayExpression(ArrayExpressionContext ctx) {
    final TypeInformation typeInfo;
    final int index;
    final String loadCommand;
    final DataType dataType;
    if (isGlobalScope) {
      typeInfo = getTypeInformationByStaticVariableIdToken(ctx.varId);
    } else {
      typeInfo = getTypeInformationByVariableIdToken(ctx.varId);
    }
    index = typeInfo.getId();
    switch (typeInfo.getDataType()) {
      case IARRAY:
        loadCommand = "iaload";
        dataType = DataType.INT;
        break;
      case FARRAY:
        loadCommand = "faload";
        dataType = DataType.FLOAT;
        break;
      case SARRAY:
        loadCommand = "aaload";
        dataType = DataType.STRING;
        break;
      default:
        throw new WrongDataTypeException(ctx.varId);
    }
    dataTypeStack.push(new TypeInformation((DataType.INT)));
    final String instructions;
    if (isGlobalScope) {
      instructions =
          "getstatic "
              + namespace
              + "/v"
              + index
              + " ["
              + dataType.getJvmType()
              + '\n'
              + visit(ctx.index)
              + '\n'
              + loadCommand;
    } else {
      instructions = "aload " + index + '\n' + visit(ctx.index) + '\n' + loadCommand;
    }
    dataTypeStack.pop();
    dataTypeStack.pop();
    dataTypeStack.push(new TypeInformation(dataType));
    return instructions;
  }

  /**
   * Called when accessing a slot in an array where the array is in a structure.
   *
   * @param ctx Struct array rule
   * @return Instructions regarding an array access in a structure.
   */
  @Override
  public String visitStructArrayExpression(StructArrayExpressionContext ctx) {
    final int typeInfoId;
    final String structId = ctx.structId.getText();
    final int objectId;
    if (isGlobalScope) {
      typeInfoId = staticVarsNamesTypes.get(structId).getId();
      objectId = staticVarsNamesTypes.get(structId).getAddress();
    } else {
      typeInfoId = vars.get(structId).getId();
      objectId = vars.get(structId).getAddress();
    }
    final CustomType struct = (new ArrayList<>(structs.values())).get(objectId);
    final int index = struct.getAddress(ctx.varId.getText());
    final TypeInformation typeInfo = struct.getTypes().get(index);
    String jvmType = typeInfo.getJvmType();
    if (typeInfo.getDataType() == DataType.OBJREF) {
      jvmType = "L" + typeNamespace + typeInfo.getJvmType() + ";";
    }
    final StringBuilder instructions = new StringBuilder();
    if (isGlobalScope) {
      instructions
          .append("getstatic ")
          .append(namespace)
          .append("/v")
          .append(typeInfoId)
          .append(" L")
          .append(typeNamespace)
          .append(objectId)
          .append(";\n")
          .append("getfield ")
          .append(typeNamespace)
          .append(staticVarsNamesTypes.get(structId).getAddress())
          .append("/a")
          .append(index)
          .append(' ')
          .append(jvmType)
          .append('\n');
      dataTypeStack.push(new TypeInformation(typeInfoId, DataType.OBJREF));
      instructions.append(visit(ctx.index)).append('\n');
      final String loadCommand;
      if (jvmType.equals(DataType.IARRAY.getJvmType())) {
        loadCommand = "iaload";
      } else if (jvmType.equals(DataType.FARRAY.getJvmType())) {
        loadCommand = "faload";
      } else {
        loadCommand = "aaload";
      }
      instructions.append(loadCommand).append('\n');
      dataTypeStack.pop();
      dataTypeStack.pop();
      final DataType dataType;
      switch (struct.getTypes().get(index).getDataType()) {
        case IARRAY:
          dataType = DataType.INT;
          break;
        case FARRAY:
          dataType = DataType.FLOAT;
          break;
        case STRING:
          dataType = DataType.STRING;
          break;
        default:
          throw new WrongDataTypeException(ctx.varId);
      }
      dataTypeStack.push(new TypeInformation((dataType)));
    } else {
      instructions.append("aload ").append(typeInfoId).append('\n');
      instructions
          .append("getfield ")
          .append(typeNamespace)
          .append(vars.get(structId).getAddress())
          .append("/a")
          .append(index)
          .append(' ')
          .append(jvmType)
          .append('\n');
      dataTypeStack.push(new TypeInformation(DataType.OBJREF));
      instructions.append(visit(ctx.index));
      dataTypeStack.pop();
      dataTypeStack.pop();
      dataTypeStack.push(struct.getTypes().get(index));
    }
    return instructions.toString();
  }

  /**
   * Called when a boolean is present. This data type is simulated by an integer. If, for example,
   * "true" is present, a 1 is loaded onto the stack.
   *
   * @param ctx Bool rule
   * @return Instruction for a boolean
   */
  @Override
  public String visitBoolExpression(BoolExpressionContext ctx) {
    dataTypeStack.push(new TypeInformation(DataType.BOOL));
    if (ctx.bool.getText().equals("true")) {
      return "ldc 1";
    } else {
      return "ldc 0";
    }
  }

  /**
   * Called when an integer is present. The opcode is 0x12 (18).
   *
   * @param ctx Integer rule
   * @return Instruction for an integer
   */
  @Override
  public String visitIntegerExpression(IntegerExpressionContext ctx) {
    dataTypeStack.push(new TypeInformation(DataType.INT));
    return "ldc " + ctx.number.getText();
  }

  /**
   * Called when a floating point number is present. Therefore, if a floating point number is called
   * without an explicit type statement, the default value is float.
   *
   * @param ctx Floating point rule
   * @return Instruction for a floating point number
   */
  @Override
  public String visitFloatingPointExpression(FloatingPointExpressionContext ctx) {
    dataTypeStack.push(new TypeInformation(DataType.FLOAT));
    return "ldc " + ctx.number.getText();
  }

  /**
   * Called when a string is present. A string consists of any number of characters. Again, you can
   * simply use the "ldc" command to load a string to the stack.
   *
   * @param ctx STRING rule
   * @return Instruction for a string
   */
  @Override
  public String visitStringExpression(StringExpressionContext ctx) {
    dataTypeStack.push(new TypeInformation(DataType.STRING));
    return "ldc " + ctx.str.getText();
  }

  /**
   * Does the opposite of {@link #visitAssignment}. This visitor is always called when a variable is
   * used. A distinction is also made between the global and local scope. If a global scope exists,
   * the system tries to get the value from the reference and push it to the stack. Otherwise, a
   * command like <code>iload</code> is used to load the value of the variable (also pushed onto the
   * stack).
   *
   * @param ctx Variable rule
   * @return Instruction with regard to loading a value from the table at a position onto the stack
   */
  @Override
  public String visitVariableExpression(VariableExpressionContext ctx) {
    final TypeInformation typeInfo;
    if (isGlobalScope) {
      // Refers to the main content
      typeInfo = getTypeInformationByStaticVariableIdToken(ctx.varId);
      dataTypeStack.push(typeInfo);
      if (typeInfo.getDataType() == DataType.OBJREF || typeInfo.getDataType() == null) {
        return "getstatic "
            + namespace
            + "/v"
            + typeInfo.getId()
            + ' '
            + 'L'
            + typeNamespace
            + typeInfo.getJvmType()
            + ";\n";
      }
      return "getstatic "
          + namespace
          + "/v"
          + typeInfo.getId()
          + ' '
          + typeInfo.getDataType().getJvmType();
    } else {
      typeInfo = getTypeInformationByVariableIdToken(ctx.varId);
      final TypeInformation newTypeInfo;
      if (typeInfo.getDataType() == DataType.OBJREF) {
        newTypeInfo = new TypeInformation(typeInfo.getDataType(), typeInfo.getAddress());
      } else {
        newTypeInfo = new TypeInformation(typeInfo.getDataType());
      }
      dataTypeStack.push(newTypeInfo);
      String loadCommand = "";
      final DataType dataType = typeInfo.getDataType();
      if (typeInfo.isArray() || dataType == DataType.STRING) {
        loadCommand = "aload";
      } else {
        switch (dataType) {
          case INT:
            loadCommand = "iload";
            break;
          case FLOAT:
            loadCommand = "fload";
            break;
          default:
            break;
        }
      }
      return loadCommand + ' ' + getVariableIndexByVariableIdToken(ctx.varId);
    }
  }

  /**
   * Visits the top of the stack (for example at the end of a method).
   *
   * @param ctx Rule for visiting the top of the stack
   * @return Empty (not important)
   */
  @Override
  public String visitTopOfStack(TopOfStackContext ctx) {
    return "";
  }

  /**
   * Determines the corresponding position using a variable name. If it is not possible, the
   * variable was not declared before use.
   *
   * @param varIdToken Name of the variable
   * @return Position of the variable
   * @see EVisitor#visitVariableDeclaration(VariableDeclarationContext)
   */
  private int getVariableIndexByVariableIdToken(Token varIdToken) {
    TypeInformation typeInformation = vars.get(varIdToken.getText());
    if (typeInformation == null) {
      throw new UndeclaredVariableException(varIdToken);
    } else {
      return typeInformation.getId();
    }
  }

  /**
   * Use a static variable to determine the associated type information. If there is none, the
   * variable was not declared.
   *
   * @param varIdToken Name of the variable
   * @return Position of the variable
   * @see EVisitor#visitAssignment(AssignmentContext)
   */
  private TypeInformation getTypeInformationByStaticVariableIdToken(Token varIdToken) {
    TypeInformation typeInformation = staticVarsNamesTypes.get(varIdToken.getText());
    if (typeInformation == null) {
      throw new UndeclaredVariableException(varIdToken);
    } else {
      return typeInformation;
    }
  }

  /**
   * Use a variable to determine the associated type information. If there is none, the variable was
   * not declared.
   *
   * @param varIdToken Name of the variable
   * @return Position of the variable
   */
  private TypeInformation getTypeInformationByVariableIdToken(Token varIdToken) {
    TypeInformation typeInformation = vars.get(varIdToken.getText());
    if (typeInformation == null) {
      throw new UndeclaredVariableException(varIdToken);
    } else {
      return typeInformation;
    }
  }

  /**
   * Since the method <code>visitChildren</code> (visits the children of a node and returns a
   * user-defined result of the operation) is executed on several nodes, it is merged to create a
   * string. The Visitor is always at exactly one point in the tree. In addition, two elements are
   * placed on the stack by <code>visitChildren</code>.
   *
   * @param aggregate Current result
   * @param nextResult Next result
   * @return Instructions
   */
  @Override
  protected String aggregateResult(String aggregate, String nextResult) {
    if (aggregate == null) {
      return nextResult;
    }
    if (nextResult == null) {
      return aggregate;
    } else {
      return aggregate + '\n' + nextResult;
    }
  }
}
