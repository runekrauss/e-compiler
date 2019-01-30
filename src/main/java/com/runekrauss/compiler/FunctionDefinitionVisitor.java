package com.runekrauss.compiler;

import com.runekrauss.compiler.exception.AlreadyDefinedFunctionException;
import com.runekrauss.compiler.exception.WrongDataTypeException;
import com.runekrauss.parser.EBaseVisitor;
import com.runekrauss.parser.EParser.FunctionDefinitionContext;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * Traverses the AST before the main traverse to determine all valid function definitions. Thus it
 * is also possible to call a function before the definition.
 *
 * @author Rune Krauss
 */
public class FunctionDefinitionVisitor {
  /**
   * Represents a pure function to collect the defined functions in the respective program. However,
   * the built-in functions that must not be overwritten are also noted.
   *
   * @param tree AST
   * @return Prototypes of the defined functions
   */
  public static FunctionPrototypeList findFunctionPrototypes(final ParseTree tree) {
    // Remember all prototypes of defined functions
    final FunctionPrototypeList definedFunctionPrototypes = new FunctionPrototypeList();
    // Notice the built-in functions
    setBuiltInFunctionDefinitions(definedFunctionPrototypes);
    // An anonymous class
    new EBaseVisitor<Void>() {
      /**
       * Visits function definitions and checks whether functions have been illegally overwritten.
       * Possible references are initially left blank.
       *
       * @param ctx Function definition rule
       * @return null (not important)
       */
      @Override
      public Void visitFunctionDefinition(FunctionDefinitionContext ctx) {
        // Get return type
        final DataType returnType = DataType.getType(ctx.type.getText());
        /*
         * if (returnType == DataType.OBJREF) { throw new WrongDataTypeException(ctx.start); }
         */
        // Get function identifier
        final String functionId = ctx.funcId.getText();
        final int paramNumber = ctx.formalParams.decls.size();
        final TypeInformation[] paramTypes = new TypeInformation[paramNumber];
        // Get parameters
        for (int i = 0; i < paramNumber; ++i) {
          final DataType paramType = DataType.getType(ctx.formalParams.decls.get(i).type.getText());
          if (paramType == DataType.VOID) {
            throw new WrongDataTypeException(ctx.start);
          }
          paramTypes[i] = new TypeInformation(paramType);
        }
        // Has a function regarding the signature already been defined?
        if (definedFunctionPrototypes.contains(functionId, paramTypes)) {
          throw new AlreadyDefinedFunctionException(ctx.funcId);
        }
        definedFunctionPrototypes.add(new TypeInformation(returnType), functionId, paramTypes);
        return null;
      }
    }.visit(tree);
    return definedFunctionPrototypes;
  }

  /**
   * Sets the built-in function definitions, for example, for outputting variables.
   *
   * @param definedFunctions List for defined functions
   */
  private static void setBuiltInFunctionDefinitions(FunctionPrototypeList definedFunctions) {
    definedFunctions.add(
        new TypeInformation(DataType.VOID),
        "print",
        new TypeInformation[] {new TypeInformation(DataType.INT)});
    definedFunctions.add(
        new TypeInformation(DataType.VOID),
        "print",
        new TypeInformation[] {new TypeInformation(DataType.FLOAT)});
    definedFunctions.add(
        new TypeInformation(DataType.VOID),
        "print",
        new TypeInformation[] {new TypeInformation(DataType.STRING)});
    definedFunctions.add(
        new TypeInformation(DataType.VOID),
        "println",
        new TypeInformation[] {new TypeInformation(DataType.INT)});
    definedFunctions.add(
        new TypeInformation(DataType.VOID),
        "println",
        new TypeInformation[] {new TypeInformation(DataType.FLOAT)});
    definedFunctions.add(
        new TypeInformation(DataType.VOID),
        "println",
        new TypeInformation[] {new TypeInformation(DataType.STRING)});
    definedFunctions.add(
        new TypeInformation(DataType.STRING),
        "append",
        new TypeInformation[] {new TypeInformation(DataType.STRING)});
    definedFunctions.add(
        new TypeInformation(DataType.INT),
        "length",
        new TypeInformation[] {new TypeInformation(DataType.IARRAY)});
    definedFunctions.add(
        new TypeInformation(DataType.INT),
        "length",
        new TypeInformation[] {new TypeInformation(DataType.FARRAY)});
    definedFunctions.add(
        new TypeInformation(DataType.INT),
        "length",
        new TypeInformation[] {new TypeInformation(DataType.SARRAY)});
  }
}
