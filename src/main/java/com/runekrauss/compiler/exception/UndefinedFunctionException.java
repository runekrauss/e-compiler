package com.runekrauss.compiler.exception;

import org.antlr.v4.runtime.Token;

/**
 * This exception occurs when an attempt is made to call an undefined function.
 *
 * @author Rune Krauss
 */
public class UndefinedFunctionException extends CompilerException {
  /** Which function name was not defined before use? */
  private final String id;

  /**
   * Creates an exception for incorrect use of a function (call).
   *
   * @param func Function in the code
   */
  public UndefinedFunctionException(final Token func) {
    super(func);
    id = func.getText();
  }

  /**
   * Indicates the line and column in which an identifier was used before a definition.
   *
   * @return Error message
   */
  @Override
  public String getMessage() {
    return line + ":" + column + " Undefined function: <" + id + ">;";
  }
}
