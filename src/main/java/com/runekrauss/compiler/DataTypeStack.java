package com.runekrauss.compiler;

import java.util.Deque;
import java.util.LinkedList;

/**
 * This class is used to log data types at compile time, e.g. to handle output. The values, on the other hand, are not
 * known until runtime.
 *
 * @author Rune Krauss
 */
public class DataTypeStack {
    /**
     * A linked list of types
     */
    private Deque<DataType> typesStack = new LinkedList<>();

    /**
     * Pushes a data type to the stack.
     *
     * @param dataType Specific data type
     */
    void push(DataType dataType) {
        typesStack.push(dataType);
    }

    /**
     * Pops a data type off the stack (LIFO principle).
     *
     * @return Data type
     */
    DataType pop() {
        return typesStack.pop();
    }
}
