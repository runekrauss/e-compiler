package com.runekrauss.compiler;

import com.runekrauss.parser.EBaseVisitor;
import com.runekrauss.parser.EParser.SayContext;
import com.runekrauss.parser.EParser.AdditionContext;
import com.runekrauss.parser.EParser.SubtractionContext;
import com.runekrauss.parser.EParser.MultiplicationContext;
import com.runekrauss.parser.EParser.DivisionContext;
import com.runekrauss.parser.EParser.ModuloContext;
import com.runekrauss.parser.EParser.DigitContext;

/**
 * Processes the syntax tree for code generation by traversing it (post order).
 * For this reason, the specific grammar is defined recursively.
 */
public class EVisitor extends EBaseVisitor<String> {
    /**
     * Called when an multiplication is present. The left child is the multiplication operator, the right child is a
     * digit. The operation imul pops the top two integers from the operand stack, multiplies them, and pushes the
     * integer result back onto the stack. On overflow, imul produces a result whose low order bits are correct, but
     * whose sign bit may be incorrect. The opcode is 0x68 (104).
     *
     * @param ctx Multiplication rule
     * @return Instructions
     */
    @Override
    public String visitMultiplication(MultiplicationContext ctx) {
        return visitChildren(ctx) + "\n\timul";
    }

    /**
     * Called when an division is present. The left child is the division operator, the right child is a digit. The
     * operation idiv pops the top two integers from the operand stack and divides the second-from top integer by the
     * top integer. The quotient result is truncated to the nearest integer and placed on the stack. The opcode is
     * 0x6C (108).
     *
     * @param ctx Division rule
     * @return Instructions
     */
    @Override
    public String visitDivision(DivisionContext ctx) {
        return visitChildren(ctx) + "\n\tidiv";
    }

    /**
     * Called when an modulo is present. The left child is the modulo operator, the right child is a digit. The
     * operation irem pops two ints off the operand stack, divides value2 by value1, computes the remainder and pushes
     * the int remainder back onto the stack. The opcode is 0x70 (112).
     *
     * @param ctx Modulo rule
     * @return Instructions
     */
    @Override
    public String visitModulo(ModuloContext ctx) {
        return visitChildren(ctx) + "\n\tirem";
    }

    /**
     * Called when an addition is present. Here, the readability for the visitor was increased by using labels.
     * The left child is the addition operator, the right child is a digit.
     *
     * @param ctx Addition rule
     * @return Instructions
     */
    @Override
    public String visitAddition(AdditionContext ctx) {
        /**
         * The operation iadd pops two integers from the operand stack, adds them, and pushes the integer result back
         * onto the stack. On overflow, iadd produces a result whose low order bits are correct, but whose sign bit
         * may be incorrect. The opcode is 0x60 (96).
         */
        return visitChildren(ctx) + "\n\tiadd";
    }

    /**
     * Called when an subtraction is present. The left child is the subtraction operator, the right child is a digit.
     * The operation isub pops two ints off the operand stack, subtracts the top one from the second and pushes the
     * int result back onto the stack. The opcode is 0x64 (100).
     *
     * @param ctx Subtraction rule
     * @return Instructions
     */
    @Override
    public String visitSubtraction(SubtractionContext ctx) {
        return visitChildren(ctx) + "\n\tisub";
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
                visit(ctx.argument) + "\n" +
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
