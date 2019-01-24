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
        deleteRecursive(tempDir.toFile());
    }

    private void deleteRecursive(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null)
                for (File child : files) deleteRecursive(child);
        }
        if (!file.delete()) throw new Error("Could not delete file: " + file);
    }

    @DataProvider
    public Object[][] provideCodeExpectedOutput() throws Exception {
        return new Object[][]{
                {"Print a number", "print(1);", "1"},
                {"Print a number with a new line", "println(1);", "1" + System.lineSeparator()},
                {"Addition", "print(1+2);", "3"},
                {"Chained addition", "print(1+2+50);", "53"},
                {"Subtraction", "print(5-3);", "2"},
                {"Multiplication", "print(2*5);", "10"},
                {"Division", "print(9/3);", "3"},
                {"Integer division", "print(10/3);", "3"},
                {"Modulo", "print(12%5);", "2"},
                {"Division and multiplication", "print(15/5*3);", "9"},
                {"Subtraction and addition", "print(3-2+5);", "6"},
                {"Addition and subtraction", "print(3+2-5);", "0"},
                {"Order of operations", "print(9-1*3);", "6"},
                {"Order of operations 2", "print(3+5*2);", "13"},
                {"Multiple output", "println(1); println(2);", "1" + System.lineSeparator() + "2" + System.lineSeparator()},
                {"Variable declaration", "int a; a = 5; print(a);", "5"},
                {"Variable declaration 2", "int _a; _a = 5; print(_a);", "5"},
                {"Variable declaration and constant", "int a; a = 5; print(a+3);", "8"},
                {"Variable declaration and calculation", "int a; a = 5; int b; b = 3; print(a+b);", "8"},
                loadTestCode("function/simple", "3"),
                loadTestCode("function/local_parameter", "3"),
                loadTestCode("function/scope", "3" + System.lineSeparator() + "5"),
                loadTestCode("function/current_formal_parameter", "15"),
                loadTestCode("function/overloading", "1" + System.lineSeparator() + "5"),
                loadTestCode("branch/if-else_zero_false", "1"),
                loadTestCode("branch/if-else_one_true", "1"),
                loadTestCode("branch/if-else_other_true", "1"),
                {"Left shift", "print(5 << 1);", "10"},
                {"Right shift", "print(4 >> 1);", "2"},
                {"Lower than to true", "print(0 < 1);", "1"},
                {"Lower than to false", "print(2 < 2);", "0"},
                {"Lower than to false 2", "print(3 < 2);", "0"},
                {"Lower than/equal to true", "print(0 <= 1);", "1"},
                {"Lower than/equal to true 2", "print(2 <= 2);", "1"},
                {"Lower than/equal to false", "print(3 <= 2);", "0"},
                {"Greater than to true", "print(1 > 0);", "1"},
                {"Greater than to false", "print(2 > 2);", "0"},
                {"Greater than to false 2", "print(1 > 2);", "0"},
                {"Greater than/equal to true", "print(1 >= 0);", "1"},
                {"Greater than/equal to true 2", "print(2 >= 2);", "1"},
                {"Greater than/equal to false", "print(0 >= 1);", "0"},
                {"Equal to true", "print(0 == 0);", "1"},
                {"Equal to false", "print(1 == 0);", "0"},
                {"Not equal to true", "print(1 != 0);", "1"},
                {"Not equal to false", "print(0 != 0);", "0"},
                {"Logical conjunction to true", "print(1 && 1);", "1"},
                {"Logical conjunction to false", "print(0 && 1);", "0"},
                {"Logical conjunction to false 2", "print(1 && 0);", "0"},
                {"Logical conjunction to false 3", "print(0 && 0);", "0"},
                {"Logical disjunction to true", "print(1 || 1);", "1"},
                {"Logical disjunction to true 2", "print(0 || 1);", "1"},
                {"Logical disjunction to true 3", "print(1 || 0);", "1"},
                {"Logical disjunction to false", "print(0 || 0);", "0"},
                loadTestCode("operators/lazy_eval_and", "0" + System.lineSeparator() + "0"),
                loadTestCode("operators/lazy_eval_or", "1" + System.lineSeparator() + "1"),
                {"Logical contravalence to true", "print(0 ^ 1);", "1"},
                {"Logical contravalence to true 2", "print(1 ^ 0);", "1"},
                {"Logical contravalence to false", "print(0 ^ 0);", "0"},
                {"Logical contravalence to false 2", "print(0 ^ 0);", "0"},
                {"Print string literal", "print(\"Hello world\");", "Hello world"},
                loadTestCode("comments/line_comment", "5"),
                loadTestCode("comments/multiline_comment", "5")
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
        compileAndRun("int get_val() { return 1; }" + System.lineSeparator() + "int get_val() { return 2; }");
    }

    private String compileAndRun(String sourceCode) throws Exception {
        sourceCode = Main.compile(CharStreams.fromString(sourceCode));
        //System.out.println(sourceCode);
        ClassFile classFile = new ClassFile();
        classFile.readJasmin(new StringReader(sourceCode), "", false);
        Path outputPath = tempDir.resolve(classFile.getClassName() + ".class");
        try (OutputStream output = Files.newOutputStream(outputPath)) {
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
