package com.runekrauss.compiler;

/**
 * The prototype of a method consists of the type and name of the function as well as the
 * number/types of parameters regarding the order.
 *
 * @author Rune Krauss
 */
public class FunctionPrototype {
  /** Type of the function */
  private final TypeInformation typeInfo;

  /** Name of the function */
  private final String functionId;

  /** Parameters of the function */
  private final TypeInformation[] params;

  public FunctionPrototype(
      final TypeInformation typeInfo, final String functionId, final TypeInformation[] params) {
    this.typeInfo = typeInfo;
    this.functionId = functionId;
    this.params = params;
  }

  public final TypeInformation getTypeInfo() {
    return typeInfo;
  }

  public final String getFunctionId() {
    return functionId;
  }

  public final TypeInformation[] getParams() {
    return params;
  }

  public final int getParamNumber() {
    return params.length;
  }
}
