package com.runekrauss.compiler;

import java.util.ArrayList;
import java.util.List;

/**
 * This list as a data structure contains the defined functions and is used to check whether a function has been
 * defined twice with regard to the signature.
 *
 * @author Rune Krauss
 */
public class FunctionList {
    /**
     * The signature of a method consists of the name of the function and the number of parameters.
     */
    private static class Function {
        /**
         * Name of the function
         */
        private final String functionId;

        /**
         * Number of parameters
         */
        private final int parameterNumber;

        /**
         * Creates a function with the respective signature.
         *
         * @param functionId Name of the function
         * @param parameterNumber Number of parameters
         */
        private Function (String functionId, int parameterNumber) {
            this.functionId = functionId;
            this.parameterNumber = parameterNumber;
        }
    }

    /**
     * Contains all functions from the respective program.
     */
    private List<Function> functions = new ArrayList<>();

    /**
     * Is there already a function with this signature in this list?
     *
     * @param functionId Name of this function
     * @param parameterNumber Number of parameters
     * @return Status whether the list already contains this function
     */
    public boolean contains(String functionId, int parameterNumber) {
        for (Function function : functions)
            if (function.functionId.equals(functionId) && function.parameterNumber == parameterNumber)
                return true;
        return false;
    }

    /**
     * Adds a method to this list.
     *
     * @param functionId Name of this function
     * @param parameterNumber Number of parameters
     */
    public void add(String functionId, int parameterNumber) {
        functions.add(new Function(functionId, parameterNumber));
    }
}
