package com.runekrauss.compiler;

import com.runekrauss.parser.ELexer;
import com.runekrauss.parser.EParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.CommonTokenStream;

/**
 * Represents a compiler for the language E:
 *  EBNF ->(ANTLR4) Lexer/Parser ->(Code) Syntax tree ->(Visitor) Assembly ->(Jasmin) Bytecode ->(Java) Output
 *
 *  @author Rune Krauss
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
     *  2. Syntax analysis: Builds a logical structure (AST) using a LL(1) top down parser
     *  3. Context analysis: Attributes the AST through declaration analysis and type analysis (ASG)
     *  4. Synthesis: Creates assembler instructions regarding Jasmin
     *  In addition, an optimization is carried out, such as a simplification of isomorphisms.
     *
     * @param sourceCode Source code
     * @return Assembly program
     */
    public static String compile(CharStream sourceCode) {
        // Control characters are ignored.
        ELexer lexer = new ELexer(sourceCode);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        EParser parser = new EParser(tokens);
        // Start rule
        ParseTree tree = parser.program();
        return createAssembly(new EVisitor().visit(tree));
    }

    /**
     * Creates an assembler program for Jasmin based on instructions.
     *
     * @param instructions Instructions
     * @return Assembler program
     */
    private static String createAssembly(String instructions) {
        /*
         * 1. E inherits from Object.
         * 2. Create a method "main" without a return value.
         * 3. Limit the stack and local variables to 100.
         * 4. Get the instructions that work with the stack.
         */
        return ".class public E\n" +
                ".super java/lang/Object\n" +
                instructions;
    }
}
