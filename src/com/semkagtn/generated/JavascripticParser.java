// Generated from Javascriptic.g4 by ANTLR 4.1

package com.semkagtn.generated;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class JavascripticParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__14=1, T__13=2, T__12=3, T__11=4, T__10=5, T__9=6, T__8=7, T__7=8, T__6=9, 
		T__5=10, T__4=11, T__3=12, T__2=13, T__1=14, T__0=15, NOT=16, MINUS=17, 
		MUL=18, DIV=19, MOD=20, ADD=21, LT=22, LE=23, GT=24, GE=25, EQ=26, NE=27, 
		NUM=28, STR=29, BOOL=30, UNDEF=31, ID=32, COMMENT=33, LINE_COMMENT=34, 
		WS=35;
	public static final String[] tokenNames = {
		"<INVALID>", "','", "'while'", "'('", "'if'", "'var'", "'{'", "'else'", 
		"'}'", "')'", "'function'", "'='", "'return'", "';'", "'&&'", "'||'", 
		"'!'", "'-'", "'*'", "'/'", "'%'", "'+'", "'<'", "'<='", "'>'", "'>='", 
		"'=='", "'!='", "NUM", "STR", "BOOL", "'undefined'", "ID", "COMMENT", 
		"LINE_COMMENT", "WS"
	};
	public static final int
		RULE_program = 0, RULE_stat = 1, RULE_blockStat = 2, RULE_varDeclStat = 3, 
		RULE_ifStat = 4, RULE_whileStat = 5, RULE_returnStat = 6, RULE_exprStat = 7, 
		RULE_expr = 8, RULE_functionArgs = 9, RULE_functionParams = 10;
	public static final String[] ruleNames = {
		"program", "stat", "blockStat", "varDeclStat", "ifStat", "whileStat", 
		"returnStat", "exprStat", "expr", "functionArgs", "functionParams"
	};

	@Override
	public String getGrammarFileName() { return "Javascriptic.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public JavascripticParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavascripticVisitor ) return ((JavascripticVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(25);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 10) | (1L << 12) | (1L << NOT) | (1L << MINUS) | (1L << NUM) | (1L << STR) | (1L << BOOL) | (1L << UNDEF) | (1L << ID))) != 0)) {
				{
				{
				setState(22); stat();
				}
				}
				setState(27);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatContext extends ParserRuleContext {
		public ExprStatContext exprStat() {
			return getRuleContext(ExprStatContext.class,0);
		}
		public WhileStatContext whileStat() {
			return getRuleContext(WhileStatContext.class,0);
		}
		public BlockStatContext blockStat() {
			return getRuleContext(BlockStatContext.class,0);
		}
		public ReturnStatContext returnStat() {
			return getRuleContext(ReturnStatContext.class,0);
		}
		public VarDeclStatContext varDeclStat() {
			return getRuleContext(VarDeclStatContext.class,0);
		}
		public IfStatContext ifStat() {
			return getRuleContext(IfStatContext.class,0);
		}
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavascripticVisitor ) return ((JavascripticVisitor<? extends T>)visitor).visitStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stat);
		try {
			setState(34);
			switch (_input.LA(1)) {
			case 6:
				enterOuterAlt(_localctx, 1);
				{
				setState(28); blockStat();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 2);
				{
				setState(29); varDeclStat();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 3);
				{
				setState(30); ifStat();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 4);
				{
				setState(31); whileStat();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 5);
				{
				setState(32); returnStat();
				}
				break;
			case 3:
			case 10:
			case NOT:
			case MINUS:
			case NUM:
			case STR:
			case BOOL:
			case UNDEF:
			case ID:
				enterOuterAlt(_localctx, 6);
				{
				setState(33); exprStat();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockStatContext extends ParserRuleContext {
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public BlockStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockStat; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavascripticVisitor ) return ((JavascripticVisitor<? extends T>)visitor).visitBlockStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockStatContext blockStat() throws RecognitionException {
		BlockStatContext _localctx = new BlockStatContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_blockStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36); match(6);
			setState(40);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 10) | (1L << 12) | (1L << NOT) | (1L << MINUS) | (1L << NUM) | (1L << STR) | (1L << BOOL) | (1L << UNDEF) | (1L << ID))) != 0)) {
				{
				{
				setState(37); stat();
				}
				}
				setState(42);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(43); match(8);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDeclStatContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ID() { return getToken(JavascripticParser.ID, 0); }
		public VarDeclStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDeclStat; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavascripticVisitor ) return ((JavascripticVisitor<? extends T>)visitor).visitVarDeclStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclStatContext varDeclStat() throws RecognitionException {
		VarDeclStatContext _localctx = new VarDeclStatContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_varDeclStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45); match(5);
			setState(46); match(ID);
			setState(49);
			_la = _input.LA(1);
			if (_la==11) {
				{
				setState(47); match(11);
				setState(48); expr(0);
				}
			}

			setState(51); match(13);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfStatContext extends ParserRuleContext {
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public IfStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStat; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavascripticVisitor ) return ((JavascripticVisitor<? extends T>)visitor).visitIfStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatContext ifStat() throws RecognitionException {
		IfStatContext _localctx = new IfStatContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_ifStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53); match(4);
			setState(54); match(3);
			setState(55); expr(0);
			setState(56); match(9);
			setState(57); stat();
			setState(60);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(58); match(7);
				setState(59); stat();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileStatContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public WhileStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStat; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavascripticVisitor ) return ((JavascripticVisitor<? extends T>)visitor).visitWhileStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStatContext whileStat() throws RecognitionException {
		WhileStatContext _localctx = new WhileStatContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_whileStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62); match(2);
			setState(63); match(3);
			setState(64); expr(0);
			setState(65); match(9);
			setState(66); stat();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnStatContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStat; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavascripticVisitor ) return ((JavascripticVisitor<? extends T>)visitor).visitReturnStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatContext returnStat() throws RecognitionException {
		ReturnStatContext _localctx = new ReturnStatContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_returnStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68); match(12);
			setState(70);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 10) | (1L << NOT) | (1L << MINUS) | (1L << NUM) | (1L << STR) | (1L << BOOL) | (1L << UNDEF) | (1L << ID))) != 0)) {
				{
				setState(69); expr(0);
				}
			}

			setState(72); match(13);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprStatContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprStat; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavascripticVisitor ) return ((JavascripticVisitor<? extends T>)visitor).visitExprStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprStatContext exprStat() throws RecognitionException {
		ExprStatContext _localctx = new ExprStatContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_exprStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74); expr(0);
			setState(75); match(13);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public int _p;
		public ExprContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExprContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
			this._p = ctx._p;
		}
	}
	public static class EqContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public EqContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavascripticVisitor ) return ((JavascripticVisitor<? extends T>)visitor).visitEq(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParensContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParensContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavascripticVisitor ) return ((JavascripticVisitor<? extends T>)visitor).visitParens(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ID() { return getToken(JavascripticParser.ID, 0); }
		public AssignContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavascripticVisitor ) return ((JavascripticVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunctionContext extends ExprContext {
		public BlockStatContext blockStat() {
			return getRuleContext(BlockStatContext.class,0);
		}
		public FunctionParamsContext functionParams() {
			return getRuleContext(FunctionParamsContext.class,0);
		}
		public FunctionContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavascripticVisitor ) return ((JavascripticVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddSubContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public AddSubContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavascripticVisitor ) return ((JavascripticVisitor<? extends T>)visitor).visitAddSub(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CmpContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public CmpContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavascripticVisitor ) return ((JavascripticVisitor<? extends T>)visitor).visitCmp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public OrContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavascripticVisitor ) return ((JavascripticVisitor<? extends T>)visitor).visitOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnaryExprContext extends ExprContext {
		public Token op;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public UnaryExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavascripticVisitor ) return ((JavascripticVisitor<? extends T>)visitor).visitUnaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MulDivModContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public MulDivModContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavascripticVisitor ) return ((JavascripticVisitor<? extends T>)visitor).visitMulDivMod(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarContext extends ExprContext {
		public TerminalNode ID() { return getToken(JavascripticParser.ID, 0); }
		public VarContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavascripticVisitor ) return ((JavascripticVisitor<? extends T>)visitor).visitVar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunctionCallContext extends ExprContext {
		public FunctionArgsContext functionArgs() {
			return getRuleContext(FunctionArgsContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FunctionCallContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavascripticVisitor ) return ((JavascripticVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public AndContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavascripticVisitor ) return ((JavascripticVisitor<? extends T>)visitor).visitAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConstantContext extends ExprContext {
		public TerminalNode BOOL() { return getToken(JavascripticParser.BOOL, 0); }
		public TerminalNode UNDEF() { return getToken(JavascripticParser.UNDEF, 0); }
		public TerminalNode STR() { return getToken(JavascripticParser.STR, 0); }
		public TerminalNode NUM() { return getToken(JavascripticParser.NUM, 0); }
		public ConstantContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavascripticVisitor ) return ((JavascripticVisitor<? extends T>)visitor).visitConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState, _p);
		ExprContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, RULE_expr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				_localctx = new UnaryExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(78);
				((UnaryExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==NOT || _la==MINUS) ) {
					((UnaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(79); expr(11);
				}
				break;

			case 2:
				{
				_localctx = new AssignContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(80); match(ID);
				setState(81); match(11);
				setState(82); expr(4);
				}
				break;

			case 3:
				{
				_localctx = new ParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(83); match(3);
				setState(84); expr(0);
				setState(85); match(9);
				}
				break;

			case 4:
				{
				_localctx = new VarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(87); match(ID);
				}
				break;

			case 5:
				{
				_localctx = new ConstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(88);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUM) | (1L << STR) | (1L << BOOL) | (1L << UNDEF))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;

			case 6:
				{
				_localctx = new FunctionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(89); match(10);
				setState(90); match(3);
				setState(92);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(91); functionParams();
					}
				}

				setState(94); match(9);
				setState(95); blockStat();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(124);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(122);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivModContext(new ExprContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(98);
						if (!(10 >= _localctx._p)) throw new FailedPredicateException(this, "10 >= $_p");
						setState(99);
						((MulDivModContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUL) | (1L << DIV) | (1L << MOD))) != 0)) ) {
							((MulDivModContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(100); expr(11);
						}
						break;

					case 2:
						{
						_localctx = new AddSubContext(new ExprContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(101);
						if (!(9 >= _localctx._p)) throw new FailedPredicateException(this, "9 >= $_p");
						setState(102);
						((AddSubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MINUS || _la==ADD) ) {
							((AddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(103); expr(10);
						}
						break;

					case 3:
						{
						_localctx = new CmpContext(new ExprContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(104);
						if (!(8 >= _localctx._p)) throw new FailedPredicateException(this, "8 >= $_p");
						setState(105);
						((CmpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LT) | (1L << LE) | (1L << GT) | (1L << GE))) != 0)) ) {
							((CmpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(106); expr(9);
						}
						break;

					case 4:
						{
						_localctx = new EqContext(new ExprContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(107);
						if (!(7 >= _localctx._p)) throw new FailedPredicateException(this, "7 >= $_p");
						setState(108);
						((EqContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQ || _la==NE) ) {
							((EqContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(109); expr(8);
						}
						break;

					case 5:
						{
						_localctx = new AndContext(new ExprContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(110);
						if (!(6 >= _localctx._p)) throw new FailedPredicateException(this, "6 >= $_p");
						setState(111); match(14);
						setState(112); expr(7);
						}
						break;

					case 6:
						{
						_localctx = new OrContext(new ExprContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(113);
						if (!(5 >= _localctx._p)) throw new FailedPredicateException(this, "5 >= $_p");
						setState(114); match(15);
						setState(115); expr(6);
						}
						break;

					case 7:
						{
						_localctx = new FunctionCallContext(new ExprContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(116);
						if (!(12 >= _localctx._p)) throw new FailedPredicateException(this, "12 >= $_p");
						setState(117); match(3);
						setState(119);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 10) | (1L << NOT) | (1L << MINUS) | (1L << NUM) | (1L << STR) | (1L << BOOL) | (1L << UNDEF) | (1L << ID))) != 0)) {
							{
							setState(118); functionArgs();
							}
						}

						setState(121); match(9);
						}
						break;
					}
					} 
				}
				setState(126);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class FunctionArgsContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public FunctionArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionArgs; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavascripticVisitor ) return ((JavascripticVisitor<? extends T>)visitor).visitFunctionArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionArgsContext functionArgs() throws RecognitionException {
		FunctionArgsContext _localctx = new FunctionArgsContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_functionArgs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127); expr(0);
			setState(132);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==1) {
				{
				{
				setState(128); match(1);
				setState(129); expr(0);
				}
				}
				setState(134);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionParamsContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(JavascripticParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(JavascripticParser.ID, i);
		}
		public FunctionParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionParams; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavascripticVisitor ) return ((JavascripticVisitor<? extends T>)visitor).visitFunctionParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionParamsContext functionParams() throws RecognitionException {
		FunctionParamsContext _localctx = new FunctionParamsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_functionParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135); match(ID);
			setState(140);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==1) {
				{
				{
				setState(136); match(1);
				setState(137); match(ID);
				}
				}
				setState(142);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 8: return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return 10 >= _localctx._p;

		case 1: return 9 >= _localctx._p;

		case 2: return 8 >= _localctx._p;

		case 3: return 7 >= _localctx._p;

		case 4: return 6 >= _localctx._p;

		case 5: return 5 >= _localctx._p;

		case 6: return 12 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3%\u0092\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\3\2\7\2\32\n\2\f\2\16\2\35\13\2\3\3\3\3\3\3\3\3\3\3\3\3\5"+
		"\3%\n\3\3\4\3\4\7\4)\n\4\f\4\16\4,\13\4\3\4\3\4\3\5\3\5\3\5\3\5\5\5\64"+
		"\n\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6?\n\6\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\b\3\b\5\bI\n\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n_\n\n\3\n\3\n\5\nc\n\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\5\nz\n\n\3\n\7\n}\n\n\f\n\16\n\u0080\13\n\3\13\3\13\3\13\7\13\u0085"+
		"\n\13\f\13\16\13\u0088\13\13\3\f\3\f\3\f\7\f\u008d\n\f\f\f\16\f\u0090"+
		"\13\f\3\f\2\r\2\4\6\b\n\f\16\20\22\24\26\2\b\3\2\22\23\3\2\36!\3\2\24"+
		"\26\4\2\23\23\27\27\3\2\30\33\3\2\34\35\u00a0\2\33\3\2\2\2\4$\3\2\2\2"+
		"\6&\3\2\2\2\b/\3\2\2\2\n\67\3\2\2\2\f@\3\2\2\2\16F\3\2\2\2\20L\3\2\2\2"+
		"\22b\3\2\2\2\24\u0081\3\2\2\2\26\u0089\3\2\2\2\30\32\5\4\3\2\31\30\3\2"+
		"\2\2\32\35\3\2\2\2\33\31\3\2\2\2\33\34\3\2\2\2\34\3\3\2\2\2\35\33\3\2"+
		"\2\2\36%\5\6\4\2\37%\5\b\5\2 %\5\n\6\2!%\5\f\7\2\"%\5\16\b\2#%\5\20\t"+
		"\2$\36\3\2\2\2$\37\3\2\2\2$ \3\2\2\2$!\3\2\2\2$\"\3\2\2\2$#\3\2\2\2%\5"+
		"\3\2\2\2&*\7\b\2\2\')\5\4\3\2(\'\3\2\2\2),\3\2\2\2*(\3\2\2\2*+\3\2\2\2"+
		"+-\3\2\2\2,*\3\2\2\2-.\7\n\2\2.\7\3\2\2\2/\60\7\7\2\2\60\63\7\"\2\2\61"+
		"\62\7\r\2\2\62\64\5\22\n\2\63\61\3\2\2\2\63\64\3\2\2\2\64\65\3\2\2\2\65"+
		"\66\7\17\2\2\66\t\3\2\2\2\678\7\6\2\289\7\5\2\29:\5\22\n\2:;\7\13\2\2"+
		";>\5\4\3\2<=\7\t\2\2=?\5\4\3\2><\3\2\2\2>?\3\2\2\2?\13\3\2\2\2@A\7\4\2"+
		"\2AB\7\5\2\2BC\5\22\n\2CD\7\13\2\2DE\5\4\3\2E\r\3\2\2\2FH\7\16\2\2GI\5"+
		"\22\n\2HG\3\2\2\2HI\3\2\2\2IJ\3\2\2\2JK\7\17\2\2K\17\3\2\2\2LM\5\22\n"+
		"\2MN\7\17\2\2N\21\3\2\2\2OP\b\n\1\2PQ\t\2\2\2Qc\5\22\n\2RS\7\"\2\2ST\7"+
		"\r\2\2Tc\5\22\n\2UV\7\5\2\2VW\5\22\n\2WX\7\13\2\2Xc\3\2\2\2Yc\7\"\2\2"+
		"Zc\t\3\2\2[\\\7\f\2\2\\^\7\5\2\2]_\5\26\f\2^]\3\2\2\2^_\3\2\2\2_`\3\2"+
		"\2\2`a\7\13\2\2ac\5\6\4\2bO\3\2\2\2bR\3\2\2\2bU\3\2\2\2bY\3\2\2\2bZ\3"+
		"\2\2\2b[\3\2\2\2c~\3\2\2\2de\6\n\2\3ef\t\4\2\2f}\5\22\n\2gh\6\n\3\3hi"+
		"\t\5\2\2i}\5\22\n\2jk\6\n\4\3kl\t\6\2\2l}\5\22\n\2mn\6\n\5\3no\t\7\2\2"+
		"o}\5\22\n\2pq\6\n\6\3qr\7\20\2\2r}\5\22\n\2st\6\n\7\3tu\7\21\2\2u}\5\22"+
		"\n\2vw\6\n\b\3wy\7\5\2\2xz\5\24\13\2yx\3\2\2\2yz\3\2\2\2z{\3\2\2\2{}\7"+
		"\13\2\2|d\3\2\2\2|g\3\2\2\2|j\3\2\2\2|m\3\2\2\2|p\3\2\2\2|s\3\2\2\2|v"+
		"\3\2\2\2}\u0080\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177\23\3\2\2\2\u0080~\3"+
		"\2\2\2\u0081\u0086\5\22\n\2\u0082\u0083\7\3\2\2\u0083\u0085\5\22\n\2\u0084"+
		"\u0082\3\2\2\2\u0085\u0088\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2"+
		"\2\2\u0087\25\3\2\2\2\u0088\u0086\3\2\2\2\u0089\u008e\7\"\2\2\u008a\u008b"+
		"\7\3\2\2\u008b\u008d\7\"\2\2\u008c\u008a\3\2\2\2\u008d\u0090\3\2\2\2\u008e"+
		"\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f\27\3\2\2\2\u0090\u008e\3\2\2"+
		"\2\17\33$*\63>H^by|~\u0086\u008e";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}