package com.runekrauss.compiler.exception;

import org.antlr.v4.runtime.Token;

/**
 * A compiler recognizes during context analysis the position and column where a struct was used
 * before the declaration, besides the types of lexemes.
 *
 * @author Rune Krauss
 */
public class UndeclaredStructException extends CompilerException {
  /** Which identifier was not declared before use? */
  private final String id;

  /**
   * Creates an exception for incorrect use of a struct.
   *
   * @param var Variable in the code
   */
  public UndeclaredStructException(final Token var) {
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
    return line + ":" + column + " Undeclared struct: <" + id + ">;";
  }
}
