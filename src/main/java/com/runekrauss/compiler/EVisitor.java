package com.runekrauss.compiler;

import com.runekrauss.parser.EBaseVisitor;
import com.runekrauss.parser.EParser.SayContext;
import com.runekrauss.parser.EParser.AdditionContext;
import com.runekrauss.parser.EParser.DigitContext;

/**
 * Processes the syntax tree for code generation by traversing it (post order).
 * For this reason, the specific grammar is defined recursively.
 */
public class EVisitor extends EBaseVisitor<String> {
    /**
     * Called when an addition is present. Here, the readability for the visitor was increased by using labels.
     * The left child is an addition, the right child is a digit.
     *
     * @param ctx Add rule
     * @return Instructions
     */
    @Override
    public String visitAddition(AdditionContext ctx) {
        return visitChildren(ctx) + "\n" + "\tldc " + ctx.right.getText() + "\n" + "\tiadd";
    }

    /**
     * Called if a "say" appears in the tree. The node is responsible for outputting text.
     *
     * @param ctx Say rule
     * @return Code for the output
     */
    @Override
    public String visitSay(SayContext ctx) {
        /**
         * 1. Push System.out to the stack.
         * 2. Compute a series of instructions and get a value from this.
         * 3. Output the value.
         */
        return "\tgetstatic java/lang/System/out Ljava/io/PrintStream;\n" +
                visit(ctx.arg) + "\n" +
                "\tinvokevirtual java/io/PrintStream/println(I)V\n";
    }

    /**
     * Called when an digit is present.
     *
     * @param ctx DIGIT rule
     * @return Instructions
     */
    @Override
    public String visitDigit(DigitContext ctx) {
        return "\tldc " + ctx.digit.getText();
    }

    /**
     * Since the method visitChildren() is executed on several nodes, it is merged to create a string.
     *
     * @param aggregate Current result
     * @param nextResult Next result
     * @return Instructions
     */
    @Override
    protected String aggregateResult(String aggregate, String nextResult) {
        if (aggregate == null) return nextResult;
        if (nextResult == null) return aggregate;
        else return aggregate + "\n" + nextResult;
    }
}
