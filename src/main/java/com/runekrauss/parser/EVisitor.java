// Generated from E.g4 by ANTLR 4.7.2
package com.runekrauss.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link EParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface EVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link EParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(EParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link EParser#includes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncludes(EParser.IncludesContext ctx);
	/**
	 * Visit a parse tree produced by {@link EParser#module}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModule(EParser.ModuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link EParser#noMain}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoMain(EParser.NoMainContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementCommand}
	 * labeled alternative in {@link EParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementCommand(EParser.StatementCommandContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionDefinitionCommand}
	 * labeled alternative in {@link EParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDefinitionCommand(EParser.FunctionDefinitionCommandContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StructDeclarationCommand}
	 * labeled alternative in {@link EParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructDeclarationCommand(EParser.StructDeclarationCommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link EParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(EParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link EParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(EParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link EParser#printLine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintLine(EParser.PrintLineContext ctx);
	/**
	 * Visit a parse tree produced by {@link EParser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(EParser.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link EParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(EParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link EParser#structVariableAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructVariableAssignment(EParser.StructVariableAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link EParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(EParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link EParser#branch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBranch(EParser.BranchContext ctx);
	/**
	 * Visit a parse tree produced by {@link EParser#loop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoop(EParser.LoopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InlineAssembly}
	 * labeled alternative in {@link EParser#assembly}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInlineAssembly(EParser.InlineAssemblyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InvokeAssembly}
	 * labeled alternative in {@link EParser#assembly}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInvokeAssembly(EParser.InvokeAssemblyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InitObject}
	 * labeled alternative in {@link EParser#assembly}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitObject(EParser.InitObjectContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PushToStack}
	 * labeled alternative in {@link EParser#assembly}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPushToStack(EParser.PushToStackContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SetTopOfStack}
	 * labeled alternative in {@link EParser#assembly}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetTopOfStack(EParser.SetTopOfStackContext ctx);
	/**
	 * Visit a parse tree produced by {@link EParser#includedFunctionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncludedFunctionCall(EParser.IncludedFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link EParser#builtinFunctionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuiltinFunctionCall(EParser.BuiltinFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link EParser#functionDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDefinition(EParser.FunctionDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link EParser#structDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructDeclaration(EParser.StructDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link EParser#structInitialization}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructInitialization(EParser.StructInitializationContext ctx);
	/**
	 * Visit a parse tree produced by {@link EParser#assignments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignments(EParser.AssignmentsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StructInitializationExpression}
	 * labeled alternative in {@link EParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructInitializationExpression(EParser.StructInitializationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RelationalExpression}
	 * labeled alternative in {@link EParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpression(EParser.RelationalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BuiltinFunctionExpression}
	 * labeled alternative in {@link EParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuiltinFunctionExpression(EParser.BuiltinFunctionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IncludedFunctionExpression}
	 * labeled alternative in {@link EParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncludedFunctionExpression(EParser.IncludedFunctionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DisjunctionExpression}
	 * labeled alternative in {@link EParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDisjunctionExpression(EParser.DisjunctionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VariableExpression}
	 * labeled alternative in {@link EParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableExpression(EParser.VariableExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntegerExpression}
	 * labeled alternative in {@link EParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerExpression(EParser.IntegerExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ShiftExpression}
	 * labeled alternative in {@link EParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShiftExpression(EParser.ShiftExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SubtractionAdditionExpression}
	 * labeled alternative in {@link EParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubtractionAdditionExpression(EParser.SubtractionAdditionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BoolExpression}
	 * labeled alternative in {@link EParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolExpression(EParser.BoolExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FloatingPointExpression}
	 * labeled alternative in {@link EParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatingPointExpression(EParser.FloatingPointExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StructExpression}
	 * labeled alternative in {@link EParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructExpression(EParser.StructExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionExpression}
	 * labeled alternative in {@link EParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionExpression(EParser.FunctionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ContravalenceExpression}
	 * labeled alternative in {@link EParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContravalenceExpression(EParser.ContravalenceExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StructArrayExpression}
	 * labeled alternative in {@link EParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructArrayExpression(EParser.StructArrayExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringExpression}
	 * labeled alternative in {@link EParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringExpression(EParser.StringExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DivisionMultiplicationModuloExpression}
	 * labeled alternative in {@link EParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivisionMultiplicationModuloExpression(EParser.DivisionMultiplicationModuloExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayExpression}
	 * labeled alternative in {@link EParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayExpression(EParser.ArrayExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NegationExpression}
	 * labeled alternative in {@link EParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegationExpression(EParser.NegationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConjunctionExpression}
	 * labeled alternative in {@link EParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConjunctionExpression(EParser.ConjunctionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link EParser#currentParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCurrentParameters(EParser.CurrentParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link EParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(EParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link EParser#statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatements(EParser.StatementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link EParser#formalParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameters(EParser.FormalParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link EParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataType(EParser.DataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link EParser#primitive}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitive(EParser.PrimitiveContext ctx);
}