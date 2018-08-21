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
	 * Visit a parse tree produced by the {@code Digit}
	 * labeled alternative in {@link EParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDigit(EParser.DigitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Addition}
	 * labeled alternative in {@link EParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddition(EParser.AdditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Multiplication}
	 * labeled alternative in {@link EParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplication(EParser.MultiplicationContext ctx);
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
	 * Visit a parse tree produced by {@link EParser#say}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSay(EParser.SayContext ctx);
}