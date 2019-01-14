package com.runekrauss.compiler;

import com.runekrauss.compiler.exception.AlreadyDefinedVariableException;
import com.runekrauss.compiler.exception.UndeclaredVariableException;
import com.runekrauss.compiler.exception.UndefinedFunctionException;
import com.runekrauss.parser.EBaseVisitor;
import com.runekrauss.parser.EParser.ProgramContext;
import com.runekrauss.parser.EParser.MainStatementContext;
import com.runekrauss.parser.EParser.DivisionContext;
import com.runekrauss.parser.EParser.MultiplicationContext;
import com.runekrauss.parser.EParser.ModuloContext;
import com.runekrauss.parser.EParser.SubtractionContext;
import com.runekrauss.parser.EParser.AdditionContext;
import com.runekrauss.parser.EParser.PrintContext;
import com.runekrauss.parser.EParser.VariableDeclarationContext;
import com.runekrauss.parser.EParser.AssignmentContext;
import com.runekrauss.parser.EParser.BranchContext;
import com.runekrauss.parser.EParser.VariableContext;
import com.runekrauss.parser.EParser.DigitContext;
import com.runekrauss.parser.EParser.FunctionCallContext;
import com.runekrauss.parser.EParser.FunctionDefinitionContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

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
     * A list with all already defined functions
     */
    private final FunctionList functions;

    /**
     * The variables in the table are accessed numerically. For this reason, the names are mapped to positions in the
     * table.
     */
    private Map<String, Integer> variables;

    /**
     * Counts the branches because no label may be ambiguous.
     */
    private int branchCounter;

    /**
     * Creates a visitor for semantic analysis and subsequent code generation where all defined functions are already
     * known.
     *
     * @param definedFunctions All defined functions after the first traversing
     */
    public EVisitor(FunctionList definedFunctions) {
        // If there are no functions
        if (definedFunctions == null)
            throw new NullPointerException();
        else
            functions = definedFunctions;
        variables = new HashMap<>();
        branchCounter = 0;
    }

    /**
     * The program has several children, namely once functions and statements. The respective code is determined
     * separately in an iteration and then returned concatenated.
     *
     * @param context Program rule
     * @return Instructions for the statements and functions (outside the main method)
     */
    @Override
    public String visitProgram(ProgramContext context) {
        StringBuilder statements = new StringBuilder();
        StringBuilder functions = new StringBuilder();
        for (int i = 0; i < context.getChildCount(); ++i) {
            ParseTree child = context.getChild(i);
            String instructions = visit(child);
            if (child instanceof MainStatementContext)
                statements.append(instructions + '\n');
            else
                functions.append(instructions + '\n');
        }
        return '\n' + functions.toString() + '\n' +
                ".method public static main([Ljava/lang/String;)V\n" +
                "\t.limit stack 100\n" +
                "\t.limit locals 100\n" +
                statements.toString() +
                "\treturn\n" +
                ".end method";
    }

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
                visit(context.arg) + '\n' +
                "\tinvokevirtual java/io/PrintStream/println(I)V";
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
        if (variables.containsKey(context.varId.getText()))
            throw new AlreadyDefinedVariableException(context.varId);
        variables.put(context.varId.getText(), variables.size());
        return "";
    }

    /**
     * Called if an assignment appears in the tree. The command "istore" gets the topmost int from the stack and places
     * it in the table regarding the variables. For example, the command "istore 5" places the specific value at
     * position 5 in this table. The opcode is 0x36 (54).
     *
     * @param context Rule for the assignment
     * @return Instruction regarding the value at position context.identifier.getText() in the variables table
     */
    @Override
    public String visitAssignment(AssignmentContext context) {
        return visit(context.expr) + "\n\tistore " + getVarIndexById(context.varId);
    }

    /**
     * Is called if a branch like if-else exists. The branch was implemented with the command "ifne" and the respective
     * opcode is 0x9A (154). The basic structure is ifne else .. false .. goto exit .. else: true .. exit: ...
     *
     * @param context Rule for the branch
     * @return Instruction regarding the branch
     */
    @Override
    public String visitBranch(BranchContext context) {
        // Generate code for conditions
        String conditionInstructions = visit(context.cond);
        // If the condition is true (everything except 0 is true), this code is generated
        String onTrueInstructions = visit(context.onTrue);
        // If the condition is false, this code is generated
        String onFalseInstructions = visit(context.onFalse);
        // Each branch must be unique
        int branch_number = branchCounter;
        ++branch_number;
        return conditionInstructions + '\n' +
                "\tifne else" + branch_number + '\n' +
                onFalseInstructions + '\n' +
                "\tgoto exit" + branch_number + '\n' +
                "else" + branch_number + ":\n" +
                onTrueInstructions + '\n' +
                "exit" + branch_number + ":\n";
    }

    /**
     * Does the opposite of {@link #visitAssignment}. The opcode is 0x15 (21).
     *
     * @param context Variables rule
     * @return Instruction with regard to loading a value from the table at position identifier.getText() onto the stack
     */
    @Override
    public String visitVariable(VariableContext context) {
        return "\tiload " + getVarIndexById(context.varId);
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
     * Called when an digit is present. The opcode is 0x12 (18).
     *
     * @param context DIGIT rule
     * @return Instruction for a digit
     */
    @Override
    public String visitDigit(DigitContext context) {
        return "\tldc " + context.digit.getText();
    }

    /**
     * Called as soon as a function is executed. This can happen anywhere in the source code. The instruction
     * "invokestatic" (followed by the class name) calls a static function. The entire method signature is therefore
     * specified.The opcode is 0xB8 (184).
     *
     * @param context Rule for the function call
     * @return Instruction for a function call
     */
    @Override
    public String visitFunctionCall(FunctionCallContext context) {
        // Get number of parameters
        int parameterNumber = context.currentParams.exprs.size();
        // If the called function does not exist
        if (!functions.contains(context.funcId.getText(), parameterNumber))
            throw new UndefinedFunctionException(context.funcId);
        StringBuilder result = new StringBuilder();
        // Save the values of the arguments to the stack
        String currentParametersInstructions = visit(context.currentParams);
        if (currentParametersInstructions != null)
            result.append(currentParametersInstructions + '\n');
        result.append("\tinvokestatic E/" + context.funcId.getText() + "(");
        result.append(repeatType("I", parameterNumber));
        result.append(")I\n");
        return result.toString();
    }

    /**
     * Called when a function is defined.  The return value is placed on the stack and returned using "ireturn".
     * The opcode is 0xAC (172).
     *
     * @param context Rule for the function definition
     * @return Instructions for a function definition
     */
    @Override
    public String visitFunctionDefinition(FunctionDefinitionContext context) {
        // Work with a (different) local scope
        Map<String, Integer> globalVariables = variables;
        variables = new HashMap<>();
        // Store all variables regarding formal parameters
        visit(context.formalParams);
        // Generate code for the statements in the function body
        String statements = visit(context.stmts);
        StringBuilder result = new StringBuilder(".method public static " + context.funcId.getText() + "(");
        int parameterNumber = context.formalParams.decls.size();
        result.append(repeatType("I", parameterNumber));
        result.append(")I\n" +
                "\t.limit stack 100\n" +
                "\t.limit locals 100\n" +
                // The return value can also be entered directly.
                (statements == null ? "" : statements) + '\n' +
                // Get instructions
                visit(context.returnVal) + '\n' +
                "\tireturn\n" +
                ".end method");
        variables = globalVariables;
        return result.toString();
    }

    /**
     * Repeats the placeholders of the data types for parameters regarding functions.
     *
     * @param type Type
     * @param count How often should the placeholder be repeated?
     * @return Repeated placeholders
     */
    private String repeatType(String type, int count) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; ++i)
            result.append(type);
        return result.toString();
    }

    /**
     * Since the method visitChildren() is executed on several nodes, it is merged to create a string.
     * The Visitor is always at exactly one point in the tree.
     *
     * @param aggregate Current result
     * @param nextResult Next result
     * @return Instructions
     */
    @Override
    protected String aggregateResult(String aggregate, String nextResult) {
        if (aggregate == null) return nextResult;
        if (nextResult == null) return aggregate;
        else return aggregate + '\n' + nextResult;
    }
}
