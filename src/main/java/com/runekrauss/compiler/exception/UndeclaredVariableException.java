package com.runekrauss.compiler.exception;

import org.antlr.v4.runtime.Token;

/**
 * A compiler recognizes during context analysis the position and column where a variable was used before the declaration,
 * besides the types of lexemes.
 */
public class UndeclaredVariableException extends CompilerException {
    /**
     * Which identifier was not declared before use?
     */
    private String id;

    /**
     * Creates an exception for incorrect use of a variable.
     *
     * @param var Variable in the code
     */
    public UndeclaredVariableException(Token var) {
        super(var);
        id = var.getText();
    }

    /**
     * Indicates the line and column in which an identifier was used before a declaration.
     *
     * @return Error message
     */
    @Override
    public String getMessage() {
        return line + ":" + column + " Undeclared variable: <" + id + ">";
    }
}
