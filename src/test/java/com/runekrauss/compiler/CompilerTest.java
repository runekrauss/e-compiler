package com.runekrauss.compiler;

import jasmin.ClassFile;
import org.antlr.v4.runtime.CharStreams;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.InputStream;
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
        if ( file.isDirectory() )
            for ( File child : file.listFiles() ) deleteRecursive(child);
        if ( !file.delete() ) throw new Error("Could not delete file: " + file);
    }

    @DataProvider
    public Object[][] provideCodeExpectedOutput() {
        return new Object[][] {
                {"say(1+2);", "3" + System.lineSeparator()},
                {"say(1+2+50);", "53" + System.lineSeparator()},
                {"say(5-3);", "2" + System.lineSeparator()},
                {"say(2*5);", "10" + System.lineSeparator()},
                {"say(9/3);", "3" + System.lineSeparator()},
                {"say(10/3);", "3" + System.lineSeparator()},
                {"say(12%5);", "2" + System.lineSeparator()},
                {"say(15/5*3);", "9" + System.lineSeparator()},
                {"say(9-1*3);", "6" + System.lineSeparator()},
                {"say(3+5*2);", "13" + System.lineSeparator()},
                {"say(1); say(2);",
                        "1" + System.lineSeparator() +
                        "2" + System.lineSeparator()},
        };
    }

    @Test(dataProvider = "provideCodeExpectedOutput")
    public void testOutputs(String sourceCode, String expectedOutput) throws Exception {
        String currentOutput = compileAndRun(sourceCode);
        Assert.assertEquals(currentOutput, expectedOutput);
    }

    private String compileAndRun(String sourceCode) throws Exception {
        sourceCode = Main.compile( CharStreams.fromString(sourceCode) );
        ClassFile classFile = new ClassFile();
        classFile.readJasmin(new StringReader(sourceCode), "", false);
        Path outputPath = tempDir.resolve(classFile.getClassName() + ".class");
        classFile.write( Files.newOutputStream(outputPath) );
        return runClass(tempDir, classFile.getClassName());
    }

    private String runClass(Path dir, String className) throws Exception {
        Process process = Runtime.getRuntime().exec(new String[]{"java", "-cp", dir.toString(), className});
        try (InputStream input = process.getInputStream()) {
            return new Scanner(input).useDelimiter("\\A").next();
        }
    }
}
