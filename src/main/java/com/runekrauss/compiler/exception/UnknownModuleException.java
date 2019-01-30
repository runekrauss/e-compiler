package com.runekrauss.compiler.exception;

import org.antlr.v4.runtime.Token;

/**
 * This exception is thrown if a module could not be found during an included function call.
 *
 * @author Rune Krauss
 */
public class UnknownModuleException extends CompilerException {
  /** Which module was not found? */
  private final String id;

  /**
   * Creates an exception for a module that was not found.
   *
   * @param mod Module in the code
   */
  public UnknownModuleException(final Token mod) {
    super(mod);
    id = mod.getText();
  }

  /**
   * Outputs the line and column where the module could not be found.
   *
   * @return Error message
   */
  @Override
  public String getMessage() {
    return line + ":" + column + " The module could not be found: <" + id + ">;";
  }
}
