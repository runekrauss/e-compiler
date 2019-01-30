package com.runekrauss.compiler;

import com.runekrauss.compiler.exception.AlreadyDeclaredVariableException;
import com.runekrauss.compiler.exception.UndeclaredStructException;
import com.runekrauss.parser.EBaseVisitor;
import com.runekrauss.parser.EParser.ProgramContext;
import com.runekrauss.parser.EParser.StatementCommandContext;
import com.runekrauss.parser.EParser.VariableDeclarationContext;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * Collects the static variables in the main block and creates references to your own defined data
 * types.
 *
 * @author Rune Krauss
 */
public class StaticVariableVisitor {
  /**
   * Represents a pure function to collect the static (struct) variables in the respective program.
   *
   * @param tree AST
   * @param structs All custom defined types with their content
   * @return All static variables
   */
  public static Map<String, TypeInformation> findStaticVariables(
      final ParseTree tree, final LinkedHashMap<String, CustomType> structs) {
    /** Saves the names and types (also references) of the static variables. */
    final Map<String, TypeInformation> staticVars = new HashMap<>();

    // An anonymous class
    new EBaseVisitor<Void>() {
      int typeId = 0;

      /**
       * Only the variables that are in the main area are considered.
       *
       * @param ctx Program context rule
       * @return null (not important)
       */
      @Override
      public Void visitProgram(ProgramContext ctx) {
        for (ParseTree child : ctx.children) {
          if (child instanceof StatementCommandContext) {
            visit(child);
          }
        }
        return null;
      };

      /**
       * Visits the variable declarations and sets references to structures if necessary.
       *
       * @param ctx Variable declaration rule
       * @return null (not important)
       */
      @Override
      public Void visitVariableDeclaration(VariableDeclarationContext ctx) {
        final String varType = ctx.type.getText();
        final DataType dataType = DataType.getType(ctx.type.getText());
        final String varId = ctx.varId.getText();
        if (staticVars.containsKey(varId)) {
          // A variable must not be declared twice
          throw new AlreadyDeclaredVariableException(ctx.varId);
        } else if (dataType == DataType.OBJREF) {
          final CustomType struct = structs.get(varType);
          if (struct == null) {
            throw new UndeclaredStructException(ctx.start);
          } else {
            // There is a reference => Map the variable type to the struct position
            staticVars.put(varId, new TypeInformation(typeId, dataType, struct.getId()));
          }
        } else {
          // Primitive data type
          staticVars.put(varId, new TypeInformation(typeId, dataType));
        }
        ++typeId;
        return null;
      }
    }.visit(tree);
    return staticVars;
  }
}
