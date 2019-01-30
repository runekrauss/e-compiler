package com.runekrauss.compiler;

import java.util.List;
import java.util.Map;

/**
 * This is where the information about a defined structure such as data types, names and references
 * are stored.
 *
 * @author Rune Krauss
 */
public class CustomType {
  /** Id of the custom type */
  private final int id;

  /** Types of all variables in the defined order */
  private final List<TypeInformation> types;

  /**
   * Maps the variable ids to their index in the list
   *
   * @see CustomType#types
   */
  private final Map<String, Integer> varIds;

  public CustomType(
      final int id, final List<TypeInformation> types, final Map<String, Integer> varIds) {
    this.id = id;
    this.types = types;
    this.varIds = varIds;
  }

  public final int getId() {
    return id;
  }

  public final List<TypeInformation> getTypes() {
    return types;
  }

  /**
   * Returns the position of a variable in a struct depends on the given id.
   *
   * @param id Identifier of the desired variable
   * @return Position of the variable in the structure
   */
  public final Integer getAddress(final String id) {
    return varIds.get(id);
  }
}
