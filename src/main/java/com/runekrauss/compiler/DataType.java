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
    INT("int", "I"), IARRAY("int[]", "[I"), LONG("long", "J"), LARRAY("long[]", "[J"), FLOAT("float", "F"),
    FARRAY("float[]", "[F"), DOUBLE("double", "D"), DARRAY("double[]", "[D"), STRING("String", "Ljava/lang/String;"),
    SARRAY("String[]", "[Ljava/lang/String;"), VOID("void", "V"), OBJREF("", "");

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
            case "int[]":
                return IARRAY;
            case "long":
                return LONG;
            case "long[]":
                return LARRAY;
            case "float":
                return FLOAT;
            case "float[]":
                return FARRAY;
            case "double":
                return DOUBLE;
            case "double[]":
                return DARRAY;
            case "String":
                return STRING;
            case "String[]":
                return SARRAY;
            case "void":
                return VOID;
            default:
                return OBJREF;
        }
    }

    public String getType() { return type; }

    public String getJvmType() { return jvmType; }
}
