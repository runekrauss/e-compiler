package com.runekrauss.compiler;

/**
 * Holds all data types known to the compiler. This includes, for example, numbers and string literals.
 *
 * @author Rune Krauss
 */
public enum DataType {
    /**
     * Calls the enum constructor with a specific type.
     */
    INT("I"), STRING("Ljava/lang/String;");

    /**
     * The type is the type of the JVM.
     */
    private final String type;

    /**
     * Creates a data type that is also logged.
     *
     * @param type Type of the JVM
     */
    DataType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
