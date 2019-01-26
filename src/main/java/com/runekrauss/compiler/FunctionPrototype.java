package com.runekrauss.compiler;

/**
 * The prototype of a method consists of the type and name of the function as well as the number/types of parameters
 * regarding the order.
 *
 * @author Rune Krauss
 */
public class FunctionPrototype {
    /**
     * Type of the function
     */
    private final TypeInformation type;

    /**
     * Name of the function
     */
    private final String functionId;

    /**
     * Parameters of the function
     */
    private final TypeInformation[] parameters;

    public FunctionPrototype(TypeInformation type, String functionId, TypeInformation[] parameters) {
        this.type = type;
        this.functionId = functionId;
        this.parameters = parameters;
    }

    TypeInformation getType() {
        return type;
    }

    String getFunctionId() {
        return functionId;
    }

    TypeInformation[] getParameters() {
        return parameters;
    }
}
