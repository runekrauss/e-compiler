package com.runekrauss.compiler.exception;

import org.antlr.v4.runtime.Token;

/**
 * This exception occurs if an unknown or invalid data type was used in an operation.
 */
public class WrongDataTypeException extends CompilerException {
    /**
     * For which identifier was a data type applied incorrectly?
     * Tracks all of the nodes in the AST traversed by the parser.
     */
    private String track;

    /**
     * Creates an exception for incorrect use of a data type regarding an operation.
     *
     * @param track Function in the code
     */
    public WrongDataTypeException(Token track) {
        super(track);
        this.track = track.getText();
    }

    /**
     * Identifies the row and column in which an identifier with an incorrect data type was used within an operation.
     *
     * @return Error message
     */
    @Override
    public String getMessage() {
        return line + ":" + column + " Wrong data type: <" + track + ">";
    }
}