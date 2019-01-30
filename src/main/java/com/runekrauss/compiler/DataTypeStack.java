package com.runekrauss.compiler;

import java.util.Deque;
import java.util.LinkedList;

/**
 * This class is used to log data types at compile time, e.g. to handle output. The values, on the
 * other hand, are not known until runtime.
 *
 * @author Rune Krauss
 */
public class DataTypeStack {
  /** A linked list of types */
  private final Deque<TypeInformation> typesStack;

  /** Maximum stack size for variables and so on */
  private int maxStackSize;

  DataTypeStack() {
    typesStack = new LinkedList<>();
    maxStackSize = 0;
  }

  /**
   * Pushes a data type to the stack.
   *
   * @param type Specific data type
   */
  public final void push(TypeInformation type) {
    if (type.getDataType() != DataType.VOID) {
      typesStack.push(type);
    }
    if (typesStack.size() > maxStackSize) {
      ++maxStackSize;
    }
  }

  /**
   * Pops a data type off the stack (LIFO principle).
   *
   * @return Data type
   */
  public final TypeInformation pop() {
    return typesStack.pop();
  }

  /**
   * Peeks a data type off the stack.
   *
   * @return Data type
   */
  public final TypeInformation peek() {
    return typesStack.peek();
  }

  public final int getMaxStackSize() {
    return maxStackSize + 1;
  }
}
