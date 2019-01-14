package com.runekrauss.compiler;

import com.runekrauss.compiler.exception.AlreadyDefinedFunctionException;
import com.runekrauss.compiler.exception.AlreadyDefinedVariableException;
import com.runekrauss.compiler.exception.UndeclaredVariableException;
import com.runekrauss.compiler.exception.UndefinedFunctionException;
import jasmin.ClassFile;
import org.antlr.v4.runtime.CharStreams;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class CompilerTest {
    private Path tempDir;

    @BeforeClass
    public void createTempDir() throws Exception {
        tempDir = Files.createTempDirectory("compilerTest");
    }

    @AfterClass
    public void deleteTempDir() {
        deleteRecursive( tempDir.toFile() );
    }

    private void deleteRecursive(File file) {
        if ( file.isDirectory() ) {
            File[] files = file.listFiles();
            if (files != null)
                for (File child : files) deleteRecursive(child);
        }
        if ( !file.delete() ) throw new Error("Could not delete file: " + file);
    }

    @DataProvider
    public Object[][] provideCodeExpectedOutput() throws Exception {
        return new Object[][] {
                {"Addition", "print(1+2);", "3" + System.lineSeparator()},
                {"Chained addition", "print(1+2+50);", "53" + System.lineSeparator()},
                {"Subtraction", "print(5-3);", "2" + System.lineSeparator()},
                {"Multiplication", "print(2*5);", "10" + System.lineSeparator()},
                {"Division", "print(9/3);", "3" + System.lineSeparator()},
                {"Integer division", "print(10/3);", "3" + System.lineSeparator()},
                {"Modulo", "print(12%5);", "2" + System.lineSeparator()},
                {"Division and multiplication", "print(15/5*3);", "9" + System.lineSeparator()},
                {"Subtraction and addition", "print(3-2+5);", "6" + System.lineSeparator()},
                {"Addition and subtraction", "print(3+2-5);", "0" + System.lineSeparator()},
                {"Order of operations", "print(9-1*3);", "6" + System.lineSeparator()},
                {"Order of operations 2", "print(3+5*2);", "13" + System.lineSeparator()},
                {"Multiple output", "print(1); print(2);", "1" + System.lineSeparator() + "2" + System.lineSeparator()},
                {"Variable declaration", "int a; a = 5; print(a);", "5" + System.lineSeparator()},
                {"Variable declaration 2", "int _a; _a = 5; print(_a);", "5" + System.lineSeparator()},
                {"Variable declaration and constant", "int a; a = 5; print(a+3);", "8" + System.lineSeparator()},
                {"Variable declaration and calculation", "int a; a = 5; int b; b = 3; print(a+b);", "8" + System.lineSeparator()},
                loadTestCode("function/simple", "3" + System.lineSeparator()),
                loadTestCode("function/local_parameter", "3" + System.lineSeparator()),
                loadTestCode("function/scope", "3" + System.lineSeparator() + "5" + System.lineSeparator()),
                loadTestCode("function/current_formal_parameter", "15" + System.lineSeparator()),
                loadTestCode("function/overloading", "1" + System.lineSeparator() + "5" + System.lineSeparator()),
                loadTestCode("branch/if-else_zero_false", "1" + System.lineSeparator()),
                loadTestCode("branch/if-else_one_true", "1" + System.lineSeparator()),
                loadTestCode("branch/if-else_other_true", "1" + System.lineSeparator())
        };
    }

    private static String[] loadTestCode(String filePath, String expectedResult) throws Exception {
        try (InputStream input = CompilerTest.class.getResourceAsStream("/" + filePath + ".e")) {
            if (input == null)
                throw new IllegalArgumentException("The file " + filePath + ".e does not exist");
            String code = new Scanner(input).useDelimiter("\\A").next();
            return new String[]{filePath, code, expectedResult};
        }
    }

    @Test(dataProvider = "provideCodeExpectedOutput")
    public void testCodeExecution(String description, String sourceCode, String expectedOutput) throws Exception {
        String currentOutput = compileAndRun(sourceCode);
        Assert.assertEquals(currentOutput, expectedOutput);
    }

    @Test(expectedExceptions = UndeclaredVariableException.class, expectedExceptionsMessageRegExp = "1:6 Undeclared variable: <a>")
    public void testReadingUndeclaredVariable() throws Exception {
        compileAndRun("print(a);");
    }

    @Test(expectedExceptions = UndeclaredVariableException.class, expectedExceptionsMessageRegExp = "1:0 Undeclared variable: <a>")
    public void testWritingUndeclaredVariable() throws Exception {
        compileAndRun("a = 9;");
    }

    @Test(expectedExceptions = AlreadyDefinedVariableException.class, expectedExceptionsMessageRegExp = "2:4 Already defined variable: <a>")
    public void testWritingAlreadyDefinedVariable() throws Exception {
        compileAndRun("int a;" + System.lineSeparator() + "int a;");
    }

    @Test(expectedExceptions = UndefinedFunctionException.class, expectedExceptionsMessageRegExp = "1:6 Undefined function: <foo>")
    public void testReadingUndefinedFunction() throws Exception {
        compileAndRun("print(foo());");
    }

    @Test(expectedExceptions = AlreadyDefinedFunctionException.class, expectedExceptionsMessageRegExp = "2:4 Already defined function: <get_val>")
    public void testWritingAlreadyDefinedFunction() throws Exception {
        compileAndRun("int get_val() { return 1; }" + '\n' + "int get_val() { return 2; }");
    }

    private String compileAndRun(String sourceCode) throws Exception {
        sourceCode = Main.compile( CharStreams.fromString(sourceCode) );
        //System.out.println(sourceCode);
        ClassFile classFile = new ClassFile();
        classFile.readJasmin(new StringReader(sourceCode), "", false);
        Path outputPath = tempDir.resolve(classFile.getClassName() + ".class");
        try ( OutputStream output = Files.newOutputStream(outputPath) ) {
            classFile.write(output);
        }
        return runClass(tempDir, classFile.getClassName());
    }

    private String runClass(Path dir, String className) throws Exception {
        Process process = Runtime.getRuntime().exec(new String[]{"java", "-cp", dir.toString(), className});
        try (InputStream input = process.getInputStream()) {
            return new Scanner(input).useDelimiter("\\A").next();
        }
    }
}
