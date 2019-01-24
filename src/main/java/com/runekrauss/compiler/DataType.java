package com.runekrauss.compiler;

/**
 * Holds all data types known to the compiler. This includes, for example, numbers, arrays and string literals.
 *
 * @author Rune Krauss
 */
public enum DataType {
    /**
     * Calls the enum constructor with a specific type regarding the JVM and E.
     */
    INT("int", "I"), LONG("long", "J"), FLOAT("float", "F"), DOUBLE("double", "D"),
    STRING("String", "Ljava/lang/String;"), VOID("void", "V");

    /**
     * Type in E
     */
    private final String type;

    /**
     * Type in the JVM
     */
    private final String jvmType;

    /**
     * Creates a data type that is also logged.
     *
     * @param type Type in E
     * @param jvmType Type in the JVM
     */
    DataType(String type, String jvmType) {
        this.type = type;
        this.jvmType = jvmType;
    }

    /**
     * Returns a data type using an abbreviation.
     *
     * @param type Name of the specific data type
     * @return Desired data type
     */
    public static DataType getType(String type) {
        switch(type) {
            case "int":
                return INT;
            case "long":
                return LONG;
            case "float":
                return FLOAT;
            case "double":
                return DOUBLE;
            case "String":
                return STRING;
            default:
                return VOID;
        }
    }

    public String getType() { return type; }

    public String getJvmType() { return jvmType; }
}
