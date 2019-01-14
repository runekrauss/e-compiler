// Generated from E.g4 by ANTLR 4.7.1
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
	 * Visit a parse tree produced by the {@code MainStatement}
	 * labeled alternative in {@link EParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainStatement(EParser.MainStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ProgramFunction}
	 * labeled alternative in {@link EParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgramFunction(EParser.ProgramFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link EParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(EParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Function}
	 * labeled alternative in {@link EParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(EParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Digit}
	 * labeled alternative in {@link EParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDigit(EParser.DigitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Multiplication}
	 * labeled alternative in {@link EParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplication(EParser.MultiplicationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Addition}
	 * labeled alternative in {@link EParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddition(EParser.AdditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link EParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(EParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Subtraction}
	 * labeled alternative in {@link EParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubtraction(EParser.SubtractionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Modulo}
	 * labeled alternative in {@link EParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModulo(EParser.ModuloContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Division}
	 * labeled alternative in {@link EParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivision(EParser.DivisionContext ctx);
	/**
	 * Visit a parse tree produced by {@link EParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(EParser.PrintContext ctx);
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
	 * Visit a parse tree produced by {@link EParser#branch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBranch(EParser.BranchContext ctx);
	/**
	 * Visit a parse tree produced by {@link EParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(EParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link EParser#functionDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDefinition(EParser.FunctionDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link EParser#formalParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameters(EParser.FormalParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link EParser#statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatements(EParser.StatementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link EParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(EParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link EParser#currentParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCurrentParameters(EParser.CurrentParametersContext ctx);
}