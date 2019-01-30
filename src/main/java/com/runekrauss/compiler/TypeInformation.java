package com.runekrauss.compiler;

/**
 * Holds some information about a type regarding functions and so on. If a reference exists, the
 * address is also stored.
 *
 * @author Rune Krauss
 */
public class TypeInformation {
  /** Id (for example the position in the symbol table regarding variables) */
  private int id;

  /** Type of the construct (function, variable, ...) */
  private final DataType dataType;

  /** Address of a type (structure) regarding references */
  private int address;

  public TypeInformation(final DataType dataType) {
    this.dataType = dataType;
  }

  public TypeInformation(final int id, final DataType dataType) {
    this.id = id;
    this.dataType = dataType;
  }

  public TypeInformation(final DataType dataType, final int address) {
    this.dataType = dataType;
    this.address = address;
  }

  public TypeInformation(final int id, final DataType dataType, final int address) {
    this.id = id;
    this.dataType = dataType;
    this.address = address;
  }

  public final int getId() {
    return id;
  }

  public final DataType getDataType() {
    return dataType;
  }

  public final int getAddress() {
    return address;
  }

  /**
   * If it is a reference, the address is returned, otherwise the direct data type.
   *
   * @return Jvm type
   */
  public final String getJvmType() {
    if (dataType != DataType.OBJREF) {
      return dataType.getJvmType();
    } else {
      return Integer.toString(address);
    }
  }

  public final boolean isArray() {
    switch (dataType) {
      case IARRAY:
      case FARRAY:
      case SARRAY:
        return true;
      default:
        return false;
    }
  }
}
