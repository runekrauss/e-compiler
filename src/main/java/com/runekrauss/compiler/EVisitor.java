package com.runekrauss.compiler;

import com.runekrauss.parser.EBaseVisitor;
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
