package com.runekrauss.compiler;

import com.runekrauss.compiler.exception.AlreadyDefinedFunctionException;
import com.runekrauss.parser.EBaseVisitor;
import com.runekrauss.parser.EParser.FunctionDefinitionContext;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * Traverses the AST before the main traverse to determine all valid function definitions. Thus it is also possible to
 * call a function before the definition.
 *
 * @author Rune Krauss
 */
public class FunctionDefinitionVisitor {
    /**
     * Represents a pure function to collect the defined functions in the respective program. However, the built-in
     * functions that must not be overwritten are also noted.
     *
     * @param tree AST
     * @return Defined functions
     */
    public static FunctionDefinitionList findFunctions(final ParseTree tree) {
        // Remember all defined functions
        final FunctionDefinitionList definedFunctions = new FunctionDefinitionList();
        // Notice the built-in functions
        setBuiltInFunctionDefinitions(definedFunctions);
        // An anonymous class
        new EBaseVisitor<Void>() {
            /**
             * Visits function definitions and checks whether functions have been illegally overwritten.
             *
             * @param context Function definition rule
             * @return null (not important)
             */
            @Override
            public Void visitFunctionDefinition(FunctionDefinitionContext context) {
                // Get return type
                DataType returnType = DataType.INT;
                switch(context.type.getText()) {
                    case "int":
                        break;
                    case "long":
                        returnType = DataType.LONG;
                        break;
                    case "float":
                        returnType = DataType.FLOAT;
                        break;
                    case "double":
                        returnType = DataType.DOUBLE;
                        break;
                    case "String":
                        returnType = DataType.STRING;
                        break;
                    case "void":
                        returnType = DataType.VOID;
                        break;
                    default:
                        break;
                }
                // Get function identifier
                final String functionId = context.funcId.getText();
                final int parameterNumber = context.formalParams.decls.size();
                final TypeInformation[] parameterTypes = new TypeInformation[parameterNumber];
                // Get parameters
                for (int i = 0; i < parameterNumber; ++i) {
                    DataType parameterType = DataType.INT;
                    switch (context.formalParams.decls.get(i).type.getText()) {
                        case "int":
                            break;
                        case "long":
                            parameterType = DataType.LONG;
                            break;
                        case "float":
                            parameterType = DataType.FLOAT;
                            break;
                        case "double":
                            parameterType = DataType.DOUBLE;
                            break;
                        case "String":
                            parameterType = DataType.STRING;
                            break;
                        default:
                            break;
                    }
                    parameterTypes[i] = new TypeInformation(parameterType);
                }
                // Has a function regarding the signature already been defined?
                if (definedFunctions.contains(functionId, parameterTypes))
                    throw new AlreadyDefinedFunctionException(context.funcId);
                definedFunctions.add(new TypeInformation(returnType), functionId, parameterTypes);
                return null;
            }
        }.visit(tree);
        return definedFunctions;
    }

    /**
     * Sets the built-in function definitions, for example, for outputting variables.
     *
     * @param definedFunctions List for defined functions
     */
    private static void setBuiltInFunctionDefinitions(FunctionDefinitionList definedFunctions) {
        definedFunctions.add(new TypeInformation(DataType.VOID),"print", new TypeInformation[] {
                new TypeInformation(DataType.INT)});
        definedFunctions.add(new TypeInformation(DataType.VOID),"print", new TypeInformation[] {
                new TypeInformation(DataType.DOUBLE)});
        definedFunctions.add(new TypeInformation(DataType.VOID),"print", new TypeInformation[] {
                new TypeInformation(DataType.STRING)});
        definedFunctions.add(new TypeInformation(DataType.VOID),"println", new TypeInformation[] {
                new TypeInformation(DataType.INT)});
        definedFunctions.add(new TypeInformation(DataType.VOID),"println", new TypeInformation[] {
                new TypeInformation(DataType.DOUBLE)});
        definedFunctions.add(new TypeInformation(DataType.VOID),"println", new TypeInformation[] {
                new TypeInformation(DataType.STRING)});
    }
}
