package com.runekrauss.compiler;

/**
 * Holds all data types known to the compiler. This includes, for example, numbers, arrays and
 * string literals.
 *
 * @author Rune Krauss
 */
public enum DataType {
  /** Calls the enum constructor with a specific type regarding the JVM and E. */
  BOOL("bool", "Z"),
  INT("int", "I"),
  IARRAY("int[]", "[I"),
  FLOAT("float", "F"),
  FARRAY("float[]", "[F"),
  STRING("String", "Ljava/lang/String;"),
  SARRAY("String[]", "[Ljava/lang/String;"),
  VOID("void", "V"),
  OBJREF("", "");

  /** Type in E */
  private final String type;

  /** Type in the JVM */
  private final String jvmType;

  /**
   * Creates a data type that is also logged.
   *
   * @param type Type in E
   * @param jvmType Type in the JVM
   */
  DataType(final String type, final String jvmType) {
    this.type = type;
    this.jvmType = jvmType;
  }

  /**
   * Returns a data type using an abbreviation.
   *
   * @param type Name of the specific data type
   * @return Desired data type
   */
  public static DataType getType(final String type) {
    switch (type) {
      case "bool":
        return BOOL;
      case "int":
        return INT;
      case "int[]":
        return IARRAY;
      case "float":
        return FLOAT;
      case "float[]":
        return FARRAY;
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

  public final String getType() {
    return type;
  }

  public final String getJvmType() {
    return jvmType;
  }
}
