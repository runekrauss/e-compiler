package com.runekrauss.compiler;

import com.runekrauss.compiler.exception.AlreadyDefinedFunctionException;
import com.runekrauss.parser.EBaseVisitor;
import com.runekrauss.parser.EParser.FunctionDefinitionContext;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * Traverses the AST before the main traverse to determine all valid function definitions (names). Thus it is also
 * possible to call a function before the definition.
 *
 * @author Rune Krauss
 */
public class FunctionVisitor {
    /**
     * Represents a pure function to collect the defined functions in the respective program.
     *
     * @param tree AST
     * @return Defined functions
     */
    public static FunctionList findFunctions(final ParseTree tree) {
        /**
         * Remembers all defined functions.
         */
        final FunctionList definedFunctions = new FunctionList();
        /**
         * An anonymous class
         */
        new EBaseVisitor<Void>() {
            /**
             * Visits function definitions.
             *
             * @param context Function definition rule
             * @return null
             */
            @Override
            public Void visitFunctionDefinition(FunctionDefinitionContext context) {
                String functionId = context.funcId.getText();
                int parameterNumber = context.formalParams.decls.size();
                // Has a function regarding the signature already been defined?
                if (definedFunctions.contains(functionId, parameterNumber))
                    throw new AlreadyDefinedFunctionException(context.funcId);
                definedFunctions.add(functionId, parameterNumber);
                return null;
            }
        }.visit(tree);
        return definedFunctions;
    }
}
