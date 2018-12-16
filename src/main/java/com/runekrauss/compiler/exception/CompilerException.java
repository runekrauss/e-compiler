package com.runekrauss.compiler.exception;

import org.antlr.v4.runtime.Token;

/**
 * Identifies the base class for all errors that may occur when using the programming language E.
 */
public class CompilerException extends RuntimeException {
    /**
     * In which line of code did the problem occur?
     */
    protected int line;

    /**
     * In which column of code did the problem occur?
     */
    protected int column;

    /**
     * Creates an exception for an incorrect application of a construct of the programming language E.
     *
     * @param token A construct in code
     */
    public CompilerException(Token token) {
        line = token.getLine();
        column = token.getCharPositionInLine();
    }
}
