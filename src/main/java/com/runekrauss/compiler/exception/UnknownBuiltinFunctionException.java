package com.runekrauss.compiler.exception;

import org.antlr.v4.runtime.Token;

/**
 * This exception is thrown if a builtin function could not be found during an included function
 * call.
 *
 * @author Rune Krauss
 */
public class UnknownBuiltinFunctionException extends CompilerException {
  /** Which builtin function was not found? */
  private final String id;

  /**
   * Creates an exception for a builtin function that was not found.
   *
   * @param func Builtin function in the code
   */
  public UnknownBuiltinFunctionException(final Token func) {
    super(func);
    id = func.getText();
  }

  /**
   * Outputs the line and column where the builtin function could not be found.
   *
   * @return Error message
   */
  @Override
  public String getMessage() {
    return line + ":" + column + " The built-in function could not be found: <" + id + ">;";
  }
}
