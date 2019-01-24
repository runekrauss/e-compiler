package com.runekrauss.compiler;

/**
 * Holds some information about a type regarding functions and so on.
 *
 * @author Rune Krauss
 */
public class TypeInformation {
    /**
     * Id (for example the position in the symbol table regarding variables)
     */
    private int id;

    /**
     * Type of the parameter
     */
    private final DataType type;

    public TypeInformation(DataType type) {
        this.type = type;
    }

    public TypeInformation(int id, DataType type) {
        this.type = type;
    }

    public DataType getType() {
        return type;
    }

    public String getJvmType() {
        return type.getJvmType();
    }
}
