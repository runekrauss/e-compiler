package com.runekrauss.compiler;

import com.runekrauss.compiler.exception.AlreadyDefinedVariableException;
import com.runekrauss.compiler.exception.UndeclaredVariableException;
import com.runekrauss.parser.EBaseVisitor;
import com.runekrauss.parser.EParser.DivisionContext;
import com.runekrauss.parser.EParser.MultiplicationContext;
import com.runekrauss.parser.EParser.ModuloContext;
import com.runekrauss.parser.EParser.SubtractionContext;
import com.runekrauss.parser.EParser.AdditionContext;
import com.runekrauss.parser.EParser.PrintContext;
import com.runekrauss.parser.EParser.VariableDeclarationContext;
import com.runekrauss.parser.EParser.AssignmentContext;
import com.runekrauss.parser.EParser.VariableContext;
import com.runekrauss.parser.EParser.DigitContext;
import org.antlr.v4.runtime.Token;

import java.util.HashMap;
import java.util.Map;

/**
 * Processes the syntax tree for code generation by traversing it (post order).
 * For this reason, the specific grammar is defined recursively.
 *
 * @author Rune Krauss
 */
public class EVisitor extends EBaseVisitor<String> {
    /**
     * The variables in the table are accessed numerically. For this reason, the names are mapped to positions in the
     * table.
     */
    private Map<String, Integer> variables = new HashMap<>();

    /**
     * Called when an multiplication is present. The left child is the multiplication operator, the right child is a
     * digit. The operation imul pops the top two integers from the operand stack, multiplies them and pushes the
     * integer result back onto the stack. On overflow, imul produces a result whose low order bits are correct, but
     * whose sign bit may be incorrect. The opcode is 0x68 (104).
     *
     * @param context Multiplication rule
     * @return Instructions
     */
    @Override
    public String visitMultiplication(MultiplicationContext context) {
        return visitChildren(context) + "\n\timul";
    }

    /**
     * Called when an division is present. The left child is the division operator, the right child is a digit. The
     * operation idiv pops the top two integers from the operand stack and divides the second-from top integer by the
     * top integer. The quotient result is truncated to the nearest integer and placed on the stack. The opcode is
     * 0x6C (108).
     *
     * @param context Division rule
     * @return Instructions
     */
    @Override
    public String visitDivision(DivisionContext context) {
        return visitChildren(context) + "\n\tidiv";
    }

    /**
     * Called when an modulo is present. The left child is the modulo operator, the right child is a digit. The
     * operation irem pops two integers from the operand stack, divides value2 by value1, computes the remainder and pushes
     * the integer remainder back onto the stack. The opcode is 0x70 (112).
     *
     * @param context Modulo rule
     * @return Instructions
     */
    @Override
    public String visitModulo(ModuloContext context) {
        return visitChildren(context) + "\n\tirem";
    }

    /**
     * Called when an subtraction is present. The left child is the subtraction operator, the right child is a digit.
     * The operation isub pops two integers from the operand stack, subtracts the top one from the second and pushes the
     * int result back onto the stack. The opcode is 0x64 (100).
     *
     * @param context Subtraction rule
     * @return Instructions
     */
    @Override
    public String visitSubtraction(SubtractionContext context) {
        return visitChildren(context) + "\n\tisub";
    }

    /**
     * Called when an addition is present. Here, the readability for the visitor was increased by using labels.
     * The left child is the addition operator, the right child is a digit. The operation iadd pops two integers from
     * the operand stack, adds them and pushes the integer result back onto the stack. On overflow, iadd produces a
     * result whose low order bits are correct, but whose sign bit may be incorrect. The opcode is 0x60 (96).
     *
     * @param context Addition rule
     * @return Instructions
     */
    @Override
    public String visitAddition(AdditionContext context) {
        return visitChildren(context) + "\n\tiadd";
    }

    /**
     * Called if a "print" appears in the tree. The node is responsible for outputting text.
     *
     * @param context Print rule
     * @return Code for the output
     */
    @Override
    public String visitPrint(PrintContext context) {
        /*
         * 1. Push System.out to the stack.
         * 2. Compute a series of instructions and get a value from this.
         * 3. Output the value.
         */
        return "\tgetstatic java/lang/System/out Ljava/io/PrintStream;\n" +
                visit(context.arg) + "\n" +
                "\tinvokevirtual java/io/PrintStream/println(I)V\n";
    }

    /**
     * Called if a variable declaration appears in the tree. The variable table is defined by "limit locals" whereby
     * each variable takes 4 bytes. For example, the command "limit locals 100" means that 100 variables can be created.
     * No instructions are generated.
     *
     * @param context Rule for the declaration of variables
     * @return Empty string
     */
    @Override
    public String visitVariableDeclaration(VariableDeclarationContext context) {
        if (variables.containsKey(context.var.getText()))
            throw new AlreadyDefinedVariableException(context.var);
        variables.put(context.var.getText(), variables.size());
        return "";
    }

    /**
     * Called if an assignment appears in the tree. The command "istore" gets the topmost int from the stack and places
     * it in the table regarding the variables. For example, the command "istore 5" places the specific value at
     * position 5 in this table.
     *
     * @param context Rule for the assignment
     * @return Instruction regarding the value at position context.identifier.getText() in the variables table
     */
    @Override
    public String visitAssignment(AssignmentContext context) {
        return visit(context.expr) + "\n" + "\tistore " + getVarIndexById(context.var);
    }

    /**
     * Does the opposite of {@link #visitAssignment}.
     *
     * @param context Variables rule
     * @return Instruction with regard to loading a value from the table at position identifier.getText() onto the stack
     */
    @Override
    public String visitVariable(VariableContext context) {
        return "\tiload " + getVarIndexById(context.var);
    }

    /**
     * Get position of a variable in the table
     *
     * @param var Variable
     * @return Position in the variable table
     */
    private int getVarIndexById(Token var) {
        Integer varIndex = variables.get(var.getText());
        // Variable was not declared before use
        if (varIndex == null)
            throw new UndeclaredVariableException(var);
        return varIndex;
    }

    /**
     * Called when an digit is present.
     *
     * @param context DIGIT rule
     * @return Instructions
     */
    @Override
    public String visitDigit(DigitContext context) {
        return "\tldc " + context.digit.getText();
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
