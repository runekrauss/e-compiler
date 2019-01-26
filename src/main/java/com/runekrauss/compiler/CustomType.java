package com.runekrauss.compiler;

import java.util.List;
import java.util.Map;

/**
 * This is where the information about a defined structure such as data types, names and references are stored.
 *
 * @author Rune Krauss
 */
public class CustomType {
    /**
     * Id of the custom type
     */
    private int id;

    /**
     * Types of all variables in the defined order
     */
    private List<TypeInformation> types;

    /**
     * Maps the variable ids to their index in the list
     *
     * @see CustomType#types
     */
    private Map<String, Integer> variableIds;

    public CustomType(int id, List<TypeInformation> types, Map<String, Integer> variableIds) {
        this.id = id;
        this.types = types;
        this.variableIds = variableIds;
    }

    public int getId() {
        return id;
    }

    public List<TypeInformation> getTypes() {
        return types;
    }

    /**
     * Returns the position of a variable in a struct depends on the given id.
     *
     * @param id Identifier of the desired variable
     * @return Position of the variable in the structure
     */
    public Integer getAddress(final String id) {
        return variableIds.get(id);
    }
}
