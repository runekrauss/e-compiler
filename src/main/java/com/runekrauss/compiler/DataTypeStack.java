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
    private Deque<TypeInformation> typesStack;

    DataTypeStack() {
        typesStack = new LinkedList<>();
    }

    /**
     * Pushes a data type to the stack.
     *
     * @param type Specific data type
     */
    void push(TypeInformation type) {
        if (type.getType() != DataType.VOID)
            typesStack.push(type);
    }

    /**
     * Pops a data type off the stack (LIFO principle).
     *
     * @return Data type
     */
    TypeInformation pop() {
        return typesStack.pop();
    }

    /**
     * Peeks a data type off the stack.
     *
     * @return Data type
     */
    TypeInformation peek() {
        return typesStack.peek();
    }
}
