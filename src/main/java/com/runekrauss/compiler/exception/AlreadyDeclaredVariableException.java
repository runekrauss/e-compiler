package com.runekrauss.compiler.exception;

import org.antlr.v4.runtime.Token;

/**
 * This class refers to variables that have already been defined and that are attempted to be
 * declared again.
 *
 * @author Rune Krauss
 */
public class AlreadyDeclaredVariableException extends CompilerException {
  /** Which identifier has already been defined? */
  private final String id;

  /**
   * Creates an exception for an already defined variable.
   *
   * @param var Variable in the code
   */
  public AlreadyDeclaredVariableException(final Token var) {
    super(var);
    id = var.getText();
  }

  /**
   * Outputs the line and column where a variable was defined again.
   *
   * @return Error message
   */
  @Override
  public String getMessage() {
    return line + ":" + column + " Already defined variable: <" + id + ">;";
  }
}
