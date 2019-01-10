package com.runekrauss.compiler.exception;

import org.antlr.v4.runtime.Token;

/**
 * This exception occurs when an attempt is made to call an already defined function.
 * Note: Name mangling is implemented, i.e. overloaded functions are permitted.
 */
public class AlreadyDefinedFunctionException extends CompilerException {
    /**
     * Name of the already defined function
     */
    private String id;

    /**
     * Creates an exception for an already defined function.
     *
     * @param func Function in the code
     */
    public AlreadyDefinedFunctionException(Token func) {
        super(func);
        id = func.getText();
    }

    /**
     * Identifies the row and column in which a function was defined twice.
     *
     * @return Error message
     */
    @Override
    public String getMessage() {
        return line + ":" + column + " Already defined function: <" + id + ">";
    }
}