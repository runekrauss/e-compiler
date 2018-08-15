package com.runekrauss.compiler;

import com.runekrauss.parser.ELexer;
import com.runekrauss.parser.EParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.CommonTokenStream;

/**
 * Represents a compiler for the language E:
 * EBNF ->(ANTLR4) Lexer/Parser ->(Code) Syntax tree ->(Visitor) Assembly ->(Jasmin) Bytecode ->(Java) Output
 */
public class Main {

    /**
     * Fetches the source code and compiles it.
     *
     * @param args Command line parameters
     * @throws Exception Treats errors like usage before definitions
     */
    public static void main(String[] args) throws Exception {
        CharStream sourceCode = CharStreams.fromFileName("test.e");
        System.out.println(compile(sourceCode));
    }

    /**
     * Compiles the source code as follows:
     *  1. Lexical analysis: Recognizes words (lexeme) with finite automatons (regular expressions)
     *  2. Syntax analysis: Builds a logical structure (AST) using a top down parser
     *  3. Context analysis: Attributes the AST through declaration analysis and type analysis (ASG)
     *  4. Synthesis: Creates assembler instructions
     *  In addition, an optimization is carried out, such as a simplification of isomorphisms.
     *
     * @param sourceCode Source code
     * @return Assembly program
     */
    public static String compile(CharStream sourceCode) {
        ELexer lexer = new ELexer(sourceCode);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        EParser parser = new EParser(tokens);
        ParseTree tree = parser.add();
        return createAssembly(new EVisitor().visit(tree));
    }

    /**
     * Creates an assembler program for Jasmin based on instructions.
     *
     * @param instructions Instructions
     * @return Assembler program
     */
    private static String createAssembly(String instructions) {
        return ".class public E\n" +
                ".super java/lang/Object\n" +
                "\n" +
                ".method public static main([Ljava/lang/String;)V\n" +
                "\t.limit stack 100\n" +
                "\t.limit locals 100\n" +
                "\t\n" +
                "\tgetstatic java/lang/System/out Ljava/io/PrintStream;\n" +
                instructions + "\n" +
                "\tinvokevirtual java/io/PrintStream/println(I)V\n" +
                "\treturn\n" +
                "\n" +
                ".end method";
    }
}
