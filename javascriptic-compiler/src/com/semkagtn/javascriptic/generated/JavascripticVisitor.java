// Generated from Javascriptic.g4 by ANTLR 4.1

package com.semkagtn.javascriptic.generated;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link JavascripticParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface JavascripticVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link JavascripticParser#functionArgs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionArgs(@NotNull JavascripticParser.FunctionArgsContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavascripticParser#functionParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionParams(@NotNull JavascripticParser.FunctionParamsContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavascripticParser#exprStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprStat(@NotNull JavascripticParser.ExprStatContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavascripticParser#Array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(@NotNull JavascripticParser.ArrayContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavascripticParser#Constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant(@NotNull JavascripticParser.ConstantContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavascripticParser#Eq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEq(@NotNull JavascripticParser.EqContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavascripticParser#GetIndex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGetIndex(@NotNull JavascripticParser.GetIndexContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavascripticParser#blockStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStat(@NotNull JavascripticParser.BlockStatContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavascripticParser#MulDivMod}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDivMod(@NotNull JavascripticParser.MulDivModContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavascripticParser#returnStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStat(@NotNull JavascripticParser.ReturnStatContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavascripticParser#index}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndex(@NotNull JavascripticParser.IndexContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavascripticParser#Parens}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParens(@NotNull JavascripticParser.ParensContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavascripticParser#Assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(@NotNull JavascripticParser.AssignContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavascripticParser#varDeclStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclStat(@NotNull JavascripticParser.VarDeclStatContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavascripticParser#Function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(@NotNull JavascripticParser.FunctionContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavascripticParser#AddSub}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSub(@NotNull JavascripticParser.AddSubContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavascripticParser#UnaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpr(@NotNull JavascripticParser.UnaryExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavascripticParser#FunctionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(@NotNull JavascripticParser.FunctionCallContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavascripticParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(@NotNull JavascripticParser.StatContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavascripticParser#whileStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStat(@NotNull JavascripticParser.WhileStatContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavascripticParser#PutIndex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPutIndex(@NotNull JavascripticParser.PutIndexContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavascripticParser#ifStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStat(@NotNull JavascripticParser.IfStatContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavascripticParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(@NotNull JavascripticParser.ProgramContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavascripticParser#Cmp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmp(@NotNull JavascripticParser.CmpContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavascripticParser#Or}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr(@NotNull JavascripticParser.OrContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavascripticParser#Var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(@NotNull JavascripticParser.VarContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavascripticParser#And}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(@NotNull JavascripticParser.AndContext ctx);
}