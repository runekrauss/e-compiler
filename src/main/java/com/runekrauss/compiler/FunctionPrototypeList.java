package com.runekrauss.compiler;

import java.util.ArrayList;
import java.util.List;

/**
 * This list as a data structure contains the defined functions and is used to check whether a
 * function has been defined twice with regard to the signature.
 *
 * @author Rune Krauss
 */
public class FunctionPrototypeList {
  /** Contains all function prototypes from the respective program. */
  private final List<FunctionPrototype> functionPrototypes;

  FunctionPrototypeList() {
    functionPrototypes = new ArrayList<>();
  }

  /**
   * Is there already a function with this signature in this list?
   *
   * @param functionId Name of this function
   * @param params Parameters of this function
   * @return Status whether the list already contains this function
   */
  public final boolean contains(final String functionId, final TypeInformation[] params) {
    for (FunctionPrototype prototype : functionPrototypes) {
      // Get parameters of the current function in the list
      final TypeInformation[] functionParameters = prototype.getParams();
      // The function may only exist if the number of parameters and the function name match
      if (functionParameters.length == params.length
          && functionId.equals(prototype.getFunctionId())) {
        if (functionParameters.length == 0 && params.length == 0) {
          // There are no parameters available => The function signatures are the same
          return true;
        }
        boolean match = true;
        // Look more closely at the individual data types of the parameters
        for (int i = 0; i < functionParameters.length; ++i) {
          if (functionParameters[i].getDataType() != params[i].getDataType()) {
            // Data types do not match => function signatures cannot be the same
            match = false;
            break;
          }
        }
        if (match) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * Adds a method prototype to this list.
   *
   * @param typeInfo Type of the function
   * @param functionId Name of this function
   * @param params Parameters of the function
   */
  public final void add(
      final TypeInformation typeInfo, final String functionId, final TypeInformation[] params) {
    functionPrototypes.add(new FunctionPrototype(typeInfo, functionId, params));
  }

  final List<FunctionPrototype> getFunctionPrototypes() {
    return functionPrototypes;
  }

  /**
   * Returns a function by a given name and number of parameters.
   *
   * @param functionId Name of a function
   * @param parameterNumber Number of parameters
   * @return Function prototype
   */
  public final FunctionPrototype get(final String functionId, final int parameterNumber) {
    for (FunctionPrototype prototype : functionPrototypes) {
      if (prototype.getFunctionId().equals(functionId)
          && prototype.getParamNumber() == parameterNumber) {
        return prototype;
      }
    }
    return null;
  }
}
