package com.runekrauss.compiler;

import com.runekrauss.compiler.exception.AlreadyDeclaredStructException;
import com.runekrauss.compiler.exception.AlreadyDeclaredVariableException;
import com.runekrauss.compiler.exception.UndeclaredStructException;
import com.runekrauss.parser.EBaseVisitor;
import com.runekrauss.parser.EParser.StructDeclarationContext;
import java.util.*;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * Collects your own defined types or structures or familiarizes them with the compiler.
 *
 * @author Rune Krauss
 */
public class CustomTypeVisitor {
  /**
   * Represents a pure function to collect the custom defined types (structures) in the respective
   * program.
   *
   * @param tree AST
   * @return Own defined types
   */
  public static LinkedHashMap<String, CustomType> findTypes(final ParseTree tree) {
    /** Saves the names of the structures and their positions (from top to bottom). */
    final Map<String, Integer> structIds = new LinkedHashMap<>();

    /** Holds the structures with variables and types as well as references. */
    final LinkedHashMap<String, CustomType> structs = new LinkedHashMap<>();

    // An anonymous class (first round)
    new EBaseVisitor<Void>() {
      /** Position of the custom data type */
      int typeId = 0;

      /**
       * Visits struct declarations and stores the names of the structures as well as their
       * positions in order.
       *
       * @param ctx Struct declaration rule
       * @return null (not important)
       */
      @Override
      public Void visitStructDeclaration(StructDeclarationContext ctx) {
        // The name of the structure must not appear twice
        if (structIds.get(ctx.structId.getText()) != null) {
          throw new AlreadyDeclaredStructException(ctx.structId);
        } else {
          structIds.put(ctx.structId.getText(), typeId++);
        }
        return null;
      }
    }.visit(tree);

    // An anonymous class (second round)
    new EBaseVisitor<Void>() {
      /** Position of the custom data type */
      int typeId = 0;

      /**
       * Visits struct declarations and stores the names of the structures as well as the data types
       * and names of the variables in order.
       *
       * @param ctx Struct declaration rule
       * @return null (not important)
       */
      @Override
      public Void visitStructDeclaration(StructDeclarationContext ctx) {
        // Store the variables types
        final List<TypeInformation> varTypes = new ArrayList<>();
        // Maps the variable identifiers to its positions
        final Map<String, Integer> varIds = new HashMap<>();
        // Iterate over the variables in the structure
        for (int i = 0; i < ctx.decls.size(); ++i) {
          final String varType = ctx.decls.get(i).type.getText();
          // Get Data type object for the desired data type
          final DataType type = DataType.getType(varType);
          TypeInformation newType;
          if (type == DataType.OBJREF) {
            final Integer structId = structIds.get(varType);
            if (structId == null) {
              throw new UndeclaredStructException(ctx.decls.get(i).type.start);
            } else {
              // There is a reference => Map the variable type to the struct position
              newType = new TypeInformation(type, structId);
            }
          } else {
            newType = new TypeInformation(type);
          }
          varTypes.add(newType);
          final String varId = ctx.decls.get(i).varId.getText();
          if (!varIds.containsKey(varId)) {
            varIds.put(varId, i);
          } else {
            throw new AlreadyDeclaredVariableException(ctx.decls.get(i).varId);
          }
        }
        structs.put(ctx.structId.getText(), new CustomType(typeId++, varTypes, varIds));
        return null;
      }
    }.visit(tree);
    return structs;
  }
}
