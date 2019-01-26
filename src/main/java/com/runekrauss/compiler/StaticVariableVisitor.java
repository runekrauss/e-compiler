package com.runekrauss.compiler;

import com.runekrauss.compiler.exception.AlreadyDefinedVariableException;
import com.runekrauss.parser.EBaseVisitor;
import com.runekrauss.parser.EParser.ProgramContext;
import com.runekrauss.parser.EParser.StatementCommandContext;
import com.runekrauss.parser.EParser.VariableDeclarationContext;
import org.antlr.v4.runtime.tree.ParseTree;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.HashMap;

/**
 * Collects the static variables in the main block and creates references to your own defined data types.
 *
 * @author Rune Krauss
 */
public class StaticVariableVisitor {
    /**
     * Represents a pure function to collect the static variables in the respective program.
     *
     * @param tree AST
     * @param structs All custom defined types with their content
     * @return All static variables
     */
    public static Map<String, TypeInformation> findStaticVariables(ParseTree tree, LinkedHashMap<String, CustomType> structs) {
        /**
         * Saves the names and types (also references) of the static variables.
         */
        final Map<String, TypeInformation> staticVariables = new HashMap<>();

        // An anonymous class
        new EBaseVisitor<Void>() {
            int typeId = 0;

            /**
             * Only the variables that are in the main area are considered.
             *
             * @param context Program context rule
             * @return null (not important)
             */
            @Override
            public Void visitProgram(ProgramContext context) {
                for (ParseTree child: context.children) {
                    if (child instanceof StatementCommandContext) {
                        visit(child);
                    }
                }
                return null;
            };

            /**
             * Visits the variable declarations and sets references to structures if necessary.
             *
             * @param context Variable declaration rule
             * @return null (not important)
             */
            @Override
            public Void visitVariableDeclaration(VariableDeclarationContext context) {
                final String variableType = context.type.getText();
                final DataType type = DataType.getType(context.type.getText());
                final String variableId = context.varId.getText();
                if (staticVariables.containsKey(variableId)) {
                    // A variable must not be declared twice
                    throw new AlreadyDefinedVariableException(context.varId);
                } else if (type == DataType.OBJREF) {
                    // Set the reference to the defined structure
                    staticVariables.put(variableId, new TypeInformation(typeId, type, structs.get(variableType).getId()));
                } else {
                    // Primitive data type
                    staticVariables.put(variableId, new TypeInformation(typeId, type));
                }
                ++typeId;
                return null;
            }
        }.visit(tree);
        return staticVariables;
    }
}
