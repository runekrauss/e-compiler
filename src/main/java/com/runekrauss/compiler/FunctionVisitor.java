package com.runekrauss.compiler;

import com.runekrauss.parser.EBaseVisitor;
import com.runekrauss.parser.EParser.FunctionDefinitionContext;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Traverses the AST before the main traverse to determine all valid function definitions (names). Thus it is also
 * possible to call a function before the definition.
 *
 * @author Rune Krauss
 */
public class FunctionVisitor extends EBaseVisitor<Set<String>> {
    /**
     * Returns a function name in a set.
     *
     * @param context Function definition rule
     * @return Function name in a set
     */
    @Override
    public Set<String> visitFunctionDefinition(FunctionDefinitionContext context) {
        String functionId = context.funcId.getText();
        return Collections.singleton(functionId);
    }

    /**
     * Since there can be several function definitions (names), these are combined here.
     *
     * @param aggregate Current result
     * @param nextResult Next result
     * @return Function definitions
     */
    @Override
    protected Set<String> aggregateResult(Set<String> aggregate, Set<String> nextResult) {
        if (aggregate == null) return nextResult;
        if (nextResult == null) return aggregate;
        Set<String> combinedFunctionIds = new HashSet<>(aggregate);
        combinedFunctionIds.addAll(nextResult);
        return combinedFunctionIds;
    }
}
