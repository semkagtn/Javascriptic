// Generated from Javascriptic.g4 by ANTLR 4.1

package com.semkagtn.generated;

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
	 * Visit a parse tree produced by {@link JavascripticParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(@NotNull JavascripticParser.ParamContext ctx);

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
	 * Visit a parse tree produced by {@link JavascripticParser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl(@NotNull JavascripticParser.VarDeclContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavascripticParser#exprStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprStat(@NotNull JavascripticParser.ExprStatContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavascripticParser#Constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant(@NotNull JavascripticParser.ConstantContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavascripticParser#AssignExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignExpr(@NotNull JavascripticParser.AssignExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavascripticParser#AndExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpr(@NotNull JavascripticParser.AndExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavascripticParser#EqExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqExpr(@NotNull JavascripticParser.EqExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavascripticParser#blockStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStat(@NotNull JavascripticParser.BlockStatContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavascripticParser#CmpExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmpExpr(@NotNull JavascripticParser.CmpExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavascripticParser#FunctionCallExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallExpr(@NotNull JavascripticParser.FunctionCallExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavascripticParser#returnStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStat(@NotNull JavascripticParser.ReturnStatContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavascripticParser#continueStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStat(@NotNull JavascripticParser.ContinueStatContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavascripticParser#Variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(@NotNull JavascripticParser.VariableContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavascripticParser#AddSubExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSubExpr(@NotNull JavascripticParser.AddSubExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavascripticParser#ParenExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpr(@NotNull JavascripticParser.ParenExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavascripticParser#MulDivModExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDivModExpr(@NotNull JavascripticParser.MulDivModExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavascripticParser#UnaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpr(@NotNull JavascripticParser.UnaryExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavascripticParser#constantExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantExpr(@NotNull JavascripticParser.ConstantExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavascripticParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(@NotNull JavascripticParser.StatContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavascripticParser#functionDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDecl(@NotNull JavascripticParser.FunctionDeclContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavascripticParser#doWhileStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoWhileStat(@NotNull JavascripticParser.DoWhileStatContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavascripticParser#whileStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStat(@NotNull JavascripticParser.WhileStatContext ctx);

	/**
	 * Visit a parse tree produced by {@link JavascripticParser#OrExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpr(@NotNull JavascripticParser.OrExprContext ctx);

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
	 * Visit a parse tree produced by {@link JavascripticParser#breakStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStat(@NotNull JavascripticParser.BreakStatContext ctx);
}