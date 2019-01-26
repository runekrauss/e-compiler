package com.runekrauss.compiler;

import com.runekrauss.parser.EBaseVisitor;
import com.runekrauss.parser.EParser.StructDeclarationContext;
import org.antlr.v4.runtime.tree.ParseTree;
import java.util.*;

/**
 * Collects your own defined types or structures or familiarizes them with the compiler.
 *
 * @author Rune Krauss
 */
public class CustomTypeVisitor {
    /**
     * Represents a pure function to collect the custom defined types (structures) in the respective program.
     *
     * @param tree AST
     * @return Own defined types
     */
    public static LinkedHashMap<String, CustomType> findTypes(final ParseTree tree) {
        /**
         * Saves the names of the structures and their positions (from top to bottom).
         */
        final Map<String, Integer> structIds = new LinkedHashMap<>();

        /**
         * Holds the structures with variables and types as well as references.
         */
        final LinkedHashMap<String, CustomType> structs = new LinkedHashMap<>();

        // An anonymous class (first round)
        new EBaseVisitor<Void>() {
            /**
             * Position of the custom data type
             */
            int typeId = 0;

            /**
             * Visits struct declarations and stores the names of the structures as well as their positions in order.
             *
             * @param context Struct declaration rule
             * @return null (not important)
             */
            @Override
            public Void visitStructDeclaration(StructDeclarationContext context) {
                structIds.put(context.structId.getText(), typeId++);
                return null;
            }
        }.visit(tree);

        // An anonymous class (second round)
        new EBaseVisitor<Void>() {
            /**
             * Position of the custom data type
             */
            int typeId = 0;

            /**
             * Visits struct declarations and stores the names of the structures as well as the data types and names of
             * the variables in order.
             *
             * @param context Struct declaration rule
             * @return null (not important)
             */
            @Override
            public Void visitStructDeclaration(StructDeclarationContext context) {
                // Store the variables types
                List<TypeInformation> variablesTypes = new ArrayList<>();
                // Maps the variable identifiers to its positions
                Map<String, Integer> variablesIds = new HashMap<>();
                // Iterate over the variables in the structure
                for (int i = 0; i < context.decls.size(); ++i) {
                    final String variableType = context.decls.get(i).type.getText();
                    // Get Data type object for the desired data type
                    final DataType type = DataType.getType(variableType);
                    TypeInformation newType;
                    if (type == DataType.OBJREF) {
                        // There is a reference => Map the variable type to the struct position
                        newType = new TypeInformation(type, structIds.get(variableType));
                    } else {
                        newType = new TypeInformation(type);
                    }
                    variablesTypes.add(newType);
                    variablesIds.put(variableType, i);
                }

                structs.put(context.structId.getText(), new CustomType(typeId++, variablesTypes, variablesIds));
                return null;
            }

        }.visit(tree);
        return structs;
    }
}
