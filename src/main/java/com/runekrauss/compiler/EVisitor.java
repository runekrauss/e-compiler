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
import com.runekrauss.parser.EParser.RelationalOperationContext;
import com.runekrauss.parser.EParser.ConjunctionContext;
import com.runekrauss.parser.EParser.DisjunctionContext;
import com.runekrauss.parser.EParser.ContravalenceContext;
import com.runekrauss.parser.EParser.PrintContext;
import com.runekrauss.parser.EParser.PrintLineContext;
import com.runekrauss.parser.EParser.VariableDeclarationContext;
import com.runekrauss.parser.EParser.AssignmentContext;
import com.runekrauss.parser.EParser.BranchContext;
import com.runekrauss.parser.EParser.VariableContext;
import com.runekrauss.parser.EParser.DigitContext;
import com.runekrauss.parser.EParser.StringContext;
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
     * Logs the used data types at compile time.
     */
    private DataTypeStack typeStack;

    /**
     * Counts the branches because no label may be ambiguous.
     */
    private int branchCounter;

    /**
     * Counts the comparisons because no label may be ambiguous.
     */
    private int comparisonCounter;

    /**
     * Counts the conjunctions because no label may be ambiguous.
     */
    private int conjunctionCounter;

    /**
     * Counts the disjunctions because no label may be ambiguous.
     */
    private int disjunctionCounter;

    /**
     * Counts the contravalences because no label may be ambiguous.
     */
    private int contravalenceCounter;

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
        typeStack = new DataTypeStack();
        branchCounter = 0;
        comparisonCounter = 0;
        conjunctionCounter = 0;
        disjunctionCounter = 0;
        contravalenceCounter = 0;
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
            // Visit a parse tree and return a user-defined result of the operation
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
     * Called when an multiplication is present. The operation <code>imul</code> pops the top two integers from the
     * operand stack, multiplies them and pushes the integer result back onto the stack. On overflow, imul produces a
     * result whose low order bits are correct, but whose sign bit may be incorrect. The opcode is 0x68 (104).
     *
     * @param context Multiplication rule
     * @return Instructions that depend on the multiplication
     */
    @Override
    public String visitMultiplication(MultiplicationContext context) {
        String instructions = visitChildren(context) + "\n\timul";
        typeStack.pop();
        typeStack.pop();
        typeStack.push(DataType.INT);
        return instructions;
    }

    /**
     * Called when an division is present. The operation <code>idiv</code> pops the top two integers from the operand
     * stack and divides the second-from top integer by the top integer. The quotient result is truncated to the nearest
     * integer and placed on the stack. The opcode is 0x6C (108).
     *
     * @param context Division rule
     * @return Instructions that depend on the division
     */
    @Override
    public String visitDivision(DivisionContext context) {
        String instructions = visitChildren(context) + "\n\tidiv";
        typeStack.pop();
        typeStack.pop();
        typeStack.push(DataType.INT);
        return instructions;
    }

    /**
     * Called when an modulo is present. The operation <code>irem</code> pops two integers from the operand stack,
     * divides value2 by value1, computes the remainder and pushes the integer remainder back onto the stack. The
     * opcode is 0x70 (112).
     *
     * @param context Modulo rule
     * @return Instructions that depend on the modulo
     */
    @Override
    public String visitModulo(ModuloContext context) {
        String instructions = visitChildren(context) + "\n\tirem";
        typeStack.pop();
        typeStack.pop();
        typeStack.push(DataType.INT);
        return instructions;
    }

    /**
     * Called when an subtraction is present. The operation <code>isub</code> pops two integers from the operand stack,
     * subtracts the top one from the second and pushes the int result back onto the stack. The opcode is 0x64 (100).
     *
     * @param context Subtraction rule
     * @return Instructions that depend on the subtraction
     */
    @Override
    public String visitSubtraction(SubtractionContext context) {
        String instructions = visitChildren(context) + "\n\tisub";
        typeStack.pop();
        typeStack.pop();
        typeStack.push(DataType.INT);
        return instructions;
    }

    /**
     * Called when an addition is present. Here, the readability for the visitor was increased by using labels.
     * The operation <code>iadd</code> pops two integers from the operand stack, adds them and pushes the integer result
     * back onto the stack. On overflow, <code>iadd</code> produces a result whose low order bits are correct, but
     * whose sign bit may be incorrect. The opcode is 0x60 (96).
     *
     * @param context Addition rule
     * @return Instructions that depend on the addition
     */
    @Override
    public String visitAddition(AdditionContext context) {
        String instructions = visitChildren(context) + "\n\tiadd";
        typeStack.pop();
        typeStack.pop();
        typeStack.push(DataType.INT);
        return instructions;
    }

    /**
     * Called when a relational operation like "lower than" and so on is present. For this reason, there are several
     * commands:
     * <ul>
     *     <li><code>if_icmplt</code>: "Lower than" with opcode 0xA1 (161)</li>
     *     <li><code>if_icmple</code>: "Lower than or equal" with opcode 0xA4 (164)</li>
     *     <li><code>if_icmpgt</code>: "Greater than" with opcode 0xA3 (163)</li>
     *     <li><code>if_icmpge</code>: "Greater than or equal" with opcode 0xA2 (162)</li>
     * </ul>
     * Generally, these operations pop the top two ints off the stack and compares them. For example, if value2 is less
     * than value1, the execution branches to the address (pc + branchoffset), where pc is the address of the
     * <code>if_icmplt</code> opcode in the bytecode and branchoffset is a 16-bit signed integer parameter following
     * the <code>if_icmplt</code> opcode in the bytecode. If value2 is greater than or equal to value1, execution
     * continues at the next instruction in this context.
     *
     * @param context "Lower than" rule
     * @return Instructions that depend on the comparisons
     */
    @Override
    public String visitRelationalOperation(RelationalOperationContext context) {
        String jumpInstruction;
        switch(context.op.getText()) {
            case "<":
                jumpInstruction = "if_icmplt";
                break;
            case "<=":
                jumpInstruction = "if_icmple";
                break;
            case ">":
                jumpInstruction = "if_icmpgt";
                break;
            case ">=":
                jumpInstruction = "if_icmpge";
                break;
            default:
                throw new IllegalArgumentException("Unknown operator: " + context.op.getText());
        }
        int comparisonNumber = comparisonCounter++;
        String instructions = visitChildren(context) + '\n' +
                '\t' + jumpInstruction + " onCmpTrue" + comparisonNumber + '\n' +
                "\tldc 0\n" +
                "\tgoto cmpExit" + comparisonNumber + '\n' +
                "onCmpTrue" + comparisonNumber + ":\n" +
                "\tldc 1\n" +
                "cmpExit" + comparisonNumber + ":\n";
        // Two operands were removed by the jumps, put one back up
        typeStack.pop();
        typeStack.pop();
        typeStack.push(DataType.INT);
        return instructions;
    }

    /**
     * Called when an conjunction is present. The operation <code>iand</code> is deliberately omitted in order to use a
     * lazy evaluation. Instead, <code>ifeq</code> is used with opcode 0x99 (153). The command <code>ifeq</code> pops
     * the top int off the operand stack. If the int equals zero, execution branches to the address (pc + branchoffset),
     * where pc is the address of the ifeq opcode in the bytecode and branchoffset is a 16-bit signed integer parameter
     * following the ifeq opcode in the bytecode. If the int on the stack does not equal zero, execution continues at
     * the next instruction.
     *
     * @param context Conjunction rule
     * @return Instructions that depend on the conjunction
     */
    @Override
    public String visitConjunction(ConjunctionContext context) {
        String leftInstructions = visit(context.lExpr);
        // This part may be skipped later
        String rightInstructions = visit(context.rExpr);
        typeStack.pop();
        typeStack.pop();
        typeStack.push(DataType.INT);
        int conjunctionNumber = conjunctionCounter++;
        return leftInstructions + '\n' +
                "\tifeq onAndFalse" + conjunctionNumber + "\n\t" +
                rightInstructions + '\n' +
                "\tifeq onAndFalse" + conjunctionNumber + '\n' +
                "\tldc 1\n" +
                "\tgoto andExit" + conjunctionNumber + '\n' +
                "onAndFalse" + conjunctionNumber + ":\n\t" +
                "ldc 0\n" +
                "\tandExit" + conjunctionNumber + ":\n";
    }

    /**
     * Called when an disjunction is present. Similar to the conjunction, <code>ior</code> is not used here. However,
     * <code>efne</code> is used to ensure a lazy evaluation. The logic is therefore only reversed here.
     *
     * @see EVisitor#visitConjunction
     * @param context Disjunction rule
     * @return Instructions that depend on the disjunction
     */
    @Override
    public String visitDisjunction(DisjunctionContext context) {
        // Split instructions for lazy evaluation
        String leftInstructions = visit(context.lExpr);
        String rightInstructions = visit(context.rExpr);
        typeStack.pop();
        typeStack.pop();
        typeStack.push(DataType.INT);
        int disjunctionNumber = disjunctionCounter++;
        return leftInstructions + '\n' +
                "\tifne onOrTrue" + disjunctionNumber + "\n\t" +
                rightInstructions + '\n' +
                "\tifne onOrTrue" + disjunctionNumber + '\n' +
                "\tldc 0\n" +
                "\tgoto orExit" + disjunctionNumber + '\n' +
                "onOrTrue" + disjunctionNumber + ":\n\t" +
                "ldc 1\n" +
                "\torExit" + disjunctionNumber + ":\n";
    }

    /**
     * Called when an contravalence is present. Pops two integers off the operand stack. Computes the bitwise exclusive
     * or of value1 and value2. The integer result replaces value1 and value2 on the stack. The opcode is 0x82 (130).
     *
     * @param context Contravalence rule
     * @return Instructions that depend on the contravalence
     */
    @Override
    public String visitContravalence(ContravalenceContext context) {
        String instructions = visitChildren(context) + "\n\tixor";
        typeStack.pop();
        typeStack.pop();
        typeStack.push(DataType.INT);
        return instructions;
    }

    /**
     * Called if a "print" appears in the tree. The node is responsible for outputting text.
     *
     * @param context Print rule
     * @return Code for the output
     */
    @Override
    public String visitPrint(PrintContext context) {
        // Get the type that "visit" put on the stack.
        return "\tgetstatic java/lang/System/out Ljava/io/PrintStream;\n" +
                visit(context.arg) +
                "\n\tinvokevirtual java/io/PrintStream/print(" + typeStack.pop().getType() + ")V";
    }

    /**
     * Called if a "println" appears in the tree. The output is with a new line at the end.
     *
     * @param context Print rule
     * @return Code for the output
     */
    @Override
    public String visitPrintLine(PrintLineContext context) {
        return "\tgetstatic java/lang/System/out Ljava/io/PrintStream;\n" +
                visit(context.arg) +
                "\n\tinvokevirtual java/io/PrintStream/println(" + typeStack.pop().getType() + ")V";
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
        String instructions = visit(context.expr) + "\n\tistore " + getVarIndexById(context.varId);
        typeStack.pop();
        return instructions;
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
        // Generate code for conditions (0 or 1)
        String conditionInstructions = visit(context.cond);
        typeStack.pop();
        // If the condition is true (everything except 0 is true), this code is generated
        String onTrueInstructions = visit(context.onTrue);
        // If the condition is false, this code is generated
        String onFalseInstructions = visit(context.onFalse);
        // Each branch must be unique
        int branchNumber = branchCounter++;
        return conditionInstructions + '\n' +
                "\tifne onTrue" + branchNumber + '\n' +
                onFalseInstructions + '\n' +
                "\tgoto exit" + branchNumber + '\n' +
                "onTrue" + branchNumber + ":\n" +
                onTrueInstructions + '\n' +
                "exit" + branchNumber + ":\n";
    }

    /**
     * Does the opposite of {@link #visitAssignment}. The opcode is 0x15 (21).
     *
     * @param context Variables rule
     * @return Instruction with regard to loading a value from the table at position identifier.getText() onto the stack
     */
    @Override
    public String visitVariable(VariableContext context) {
        typeStack.push(DataType.INT);
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
     * Called when a digit is present. The opcode is 0x12 (18).
     *
     * @param context DIGIT rule
     * @return Instruction for a digit
     */
    @Override
    public String visitDigit(DigitContext context) {
        typeStack.push(DataType.INT);
        return "\tldc " + context.digit.getText();
    }

    /**
     * Called when a string is present. A string consists of any number of characters. Again, you can simply use the
     * "ldc" command to load a string to the stack.
     *
     * @param context STRING rule
     * @return Instruction for a string
     */
    @Override
    public String visitString(StringContext context) {
        typeStack.push(DataType.STRING);
        return "\tldc " + context.strLit.getText();
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
        // Because each argument creates a value on the stack
        for (int i = 0; i < parameterNumber; ++i) {
            typeStack.pop();
        }
        typeStack.push(DataType.INT);
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
        DataTypeStack globalTypesStack = typeStack;
        typeStack = new DataTypeStack();
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
        // Check if there is a value you can take down
        typeStack.pop();
        variables = globalVariables;
        typeStack = globalTypesStack;
        return result.toString();
    }

    /**
     * Repeats the placeholders of the data types for parameters regarding functions.
     *
     * @param type  Type
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
     * Since the method <code>visitChildren</code> (visits the children of a node and returns a user-defined result of
     * the operation) is executed on several nodes, it is merged to create a string. The Visitor is always at exactly
     * one point in the tree. In addition, two elements are placed on the stack by <code>visitChildren</code>.
     *
     * @param aggregate  Current result
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
