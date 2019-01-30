package com.runekrauss.compiler.exception;

import org.antlr.v4.runtime.Token;

/**
 * This class refers to structs that have already been defined and that are attempted to be declared
 * again.
 *
 * @author Rune Krauss
 */
public class AlreadyDeclaredStructException extends CompilerException {
  /** Which identifier has already been defined? */
  private final String id;

  /**
   * Creates an exception for an already defined struct.
   *
   * @param var Variable in the code
   */
  public AlreadyDeclaredStructException(final Token var) {
    super(var);
    id = var.getText();
  }

  /**
   * Outputs the line and column where a struct was defined again.
   *
   * @return Error message
   */
  @Override
  public String getMessage() {
    return line + ":" + column + " Already declared struct: <" + id + ">;";
  }
}
