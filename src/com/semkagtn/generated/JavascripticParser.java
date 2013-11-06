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
		T__17=1, T__16=2, T__15=3, T__14=4, T__13=5, T__12=6, T__11=7, T__10=8, 
		T__9=9, T__8=10, T__7=11, T__6=12, T__5=13, T__4=14, T__3=15, T__2=16, 
		T__1=17, T__0=18, NOT=19, MINUS=20, MUL=21, DIV=22, MOD=23, ADD=24, LT=25, 
		LQ=26, GT=27, GE=28, EQ=29, NE=30, NUM=31, STR=32, BOOL=33, UNDEF=34, 
		ID=35, COMMENT=36, LINE_COMMENT=37, WS=38;
	public static final String[] tokenNames = {
		"<INVALID>", "','", "'while'", "'('", "'if'", "'continue'", "'var'", "'{'", 
		"'break'", "'else'", "'}'", "'do'", "'function'", "')'", "'='", "'return'", 
		"';'", "'&&'", "'||'", "'!'", "'-'", "'*'", "'/'", "'%'", "'+'", "'<'", 
		"'<='", "'>'", "'>='", "'=='", "'!='", "NUM", "STR", "BOOL", "'undefined'", 
		"ID", "COMMENT", "LINE_COMMENT", "WS"
	};
	public static final int
		RULE_program = 0, RULE_stat = 1, RULE_scopeStat = 2, RULE_functionDecl = 3, 
		RULE_varDecl = 4, RULE_assign = 5, RULE_ifStat = 6, RULE_whileStat = 7, 
		RULE_doWhileStat = 8, RULE_expr = 9, RULE_constantExpr = 10, RULE_functionCall = 11, 
		RULE_returnStat = 12, RULE_breakStat = 13, RULE_continueStat = 14, RULE_exprStat = 15, 
		RULE_functionParams = 16, RULE_param = 17, RULE_functionArgs = 18;
	public static final String[] ruleNames = {
		"program", "stat", "scopeStat", "functionDecl", "varDecl", "assign", "ifStat", 
		"whileStat", "doWhileStat", "expr", "constantExpr", "functionCall", "returnStat", 
		"breakStat", "continueStat", "exprStat", "functionParams", "param", "functionArgs"
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
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 11) | (1L << 12) | (1L << 15) | (1L << NOT) | (1L << MINUS) | (1L << NUM) | (1L << STR) | (1L << BOOL) | (1L << UNDEF) | (1L << ID))) != 0)) {
				{
				{
				setState(38); stat();
				}
				}
				setState(43);
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
		public ReturnStatContext returnStat() {
			return getRuleContext(ReturnStatContext.class,0);
		}
		public ContinueStatContext continueStat() {
			return getRuleContext(ContinueStatContext.class,0);
		}
		public VarDeclContext varDecl() {
			return getRuleContext(VarDeclContext.class,0);
		}
		public FunctionDeclContext functionDecl() {
			return getRuleContext(FunctionDeclContext.class,0);
		}
		public DoWhileStatContext doWhileStat() {
			return getRuleContext(DoWhileStatContext.class,0);
		}
		public IfStatContext ifStat() {
			return getRuleContext(IfStatContext.class,0);
		}
		public ScopeStatContext scopeStat() {
			return getRuleContext(ScopeStatContext.class,0);
		}
		public BreakStatContext breakStat() {
			return getRuleContext(BreakStatContext.class,0);
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
			setState(54);
			switch (_input.LA(1)) {
			case 7:
				enterOuterAlt(_localctx, 1);
				{
				setState(44); scopeStat();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 2);
				{
				setState(45); functionDecl();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 3);
				{
				setState(46); varDecl();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(47); ifStat();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 5);
				{
				setState(48); whileStat();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 6);
				{
				setState(49); doWhileStat();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 7);
				{
				setState(50); returnStat();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(51); breakStat();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 9);
				{
				setState(52); continueStat();
				}
				break;
			case 3:
			case NOT:
			case MINUS:
			case NUM:
			case STR:
			case BOOL:
			case UNDEF:
			case ID:
				enterOuterAlt(_localctx, 10);
				{
				setState(53); exprStat();
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

	public static class ScopeStatContext extends ParserRuleContext {
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public ScopeStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scopeStat; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavascripticVisitor ) return ((JavascripticVisitor<? extends T>)visitor).visitScopeStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScopeStatContext scopeStat() throws RecognitionException {
		ScopeStatContext _localctx = new ScopeStatContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_scopeStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56); match(7);
			setState(60);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 3) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 11) | (1L << 12) | (1L << 15) | (1L << NOT) | (1L << MINUS) | (1L << NUM) | (1L << STR) | (1L << BOOL) | (1L << UNDEF) | (1L << ID))) != 0)) {
				{
				{
				setState(57); stat();
				}
				}
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(63); match(10);
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

	public static class FunctionDeclContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(JavascripticParser.ID, 0); }
		public ScopeStatContext scopeStat() {
			return getRuleContext(ScopeStatContext.class,0);
		}
		public FunctionParamsContext functionParams() {
			return getRuleContext(FunctionParamsContext.class,0);
		}
		public FunctionDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavascripticVisitor ) return ((JavascripticVisitor<? extends T>)visitor).visitFunctionDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDeclContext functionDecl() throws RecognitionException {
		FunctionDeclContext _localctx = new FunctionDeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_functionDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65); match(12);
			setState(66); match(ID);
			setState(67); match(3);
			setState(69);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(68); functionParams();
				}
			}

			setState(71); match(13);
			setState(72); scopeStat();
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

	public static class VarDeclContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ID() { return getToken(JavascripticParser.ID, 0); }
		public VarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavascripticVisitor ) return ((JavascripticVisitor<? extends T>)visitor).visitVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclContext varDecl() throws RecognitionException {
		VarDeclContext _localctx = new VarDeclContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_varDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74); match(6);
			setState(75); match(ID);
			setState(78);
			_la = _input.LA(1);
			if (_la==14) {
				{
				setState(76); match(14);
				setState(77); expr(0);
				}
			}

			setState(80); match(16);
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

	public static class AssignContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ID() { return getToken(JavascripticParser.ID, 0); }
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavascripticVisitor ) return ((JavascripticVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82); match(ID);
			setState(83); match(14);
			setState(84); expr(0);
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
		enterRule(_localctx, 12, RULE_ifStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86); match(4);
			setState(87); match(3);
			setState(88); expr(0);
			setState(89); match(13);
			setState(90); stat();
			setState(93);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(91); match(9);
				setState(92); stat();
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
		enterRule(_localctx, 14, RULE_whileStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95); match(2);
			setState(96); match(3);
			setState(97); expr(0);
			setState(98); match(13);
			setState(99); stat();
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

	public static class DoWhileStatContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public DoWhileStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doWhileStat; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavascripticVisitor ) return ((JavascripticVisitor<? extends T>)visitor).visitDoWhileStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoWhileStatContext doWhileStat() throws RecognitionException {
		DoWhileStatContext _localctx = new DoWhileStatContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_doWhileStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101); match(11);
			setState(102); stat();
			setState(103); match(2);
			setState(104); match(3);
			setState(105); expr(0);
			setState(106); match(13);
			setState(107); match(16);
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
	public static class FunctionCallExprContext extends ExprContext {
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public FunctionCallExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavascripticVisitor ) return ((JavascripticVisitor<? extends T>)visitor).visitFunctionCallExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignExprContext extends ExprContext {
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public AssignExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavascripticVisitor ) return ((JavascripticVisitor<? extends T>)visitor).visitAssignExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VariableContext extends ExprContext {
		public TerminalNode ID() { return getToken(JavascripticParser.ID, 0); }
		public VariableContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavascripticVisitor ) return ((JavascripticVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddSubExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public AddSubExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavascripticVisitor ) return ((JavascripticVisitor<? extends T>)visitor).visitAddSubExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public AndExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavascripticVisitor ) return ((JavascripticVisitor<? extends T>)visitor).visitAndExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public OrExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavascripticVisitor ) return ((JavascripticVisitor<? extends T>)visitor).visitOrExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParenExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavascripticVisitor ) return ((JavascripticVisitor<? extends T>)visitor).visitParenExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public EqExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavascripticVisitor ) return ((JavascripticVisitor<? extends T>)visitor).visitEqExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MulDivModExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public MulDivModExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavascripticVisitor ) return ((JavascripticVisitor<? extends T>)visitor).visitMulDivModExpr(this);
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
	public static class CmpExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public CmpExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavascripticVisitor ) return ((JavascripticVisitor<? extends T>)visitor).visitCmpExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConstantContext extends ExprContext {
		public ConstantExprContext constantExpr() {
			return getRuleContext(ConstantExprContext.class,0);
		}
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
		int _startState = 18;
		enterRecursionRule(_localctx, RULE_expr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				_localctx = new UnaryExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(110);
				((UnaryExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==NOT || _la==MINUS) ) {
					((UnaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(111); expr(12);
				}
				break;

			case 2:
				{
				_localctx = new AssignExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(112); assign();
				}
				break;

			case 3:
				{
				_localctx = new ParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(113); match(3);
				setState(114); expr(0);
				setState(115); match(13);
				}
				break;

			case 4:
				{
				_localctx = new VariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(117); match(ID);
				}
				break;

			case 5:
				{
				_localctx = new ConstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(118); constantExpr();
				}
				break;

			case 6:
				{
				_localctx = new FunctionCallExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(119); functionCall();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(142);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(140);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivModExprContext(new ExprContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(122);
						if (!(11 >= _localctx._p)) throw new FailedPredicateException(this, "11 >= $_p");
						setState(123);
						((MulDivModExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUL) | (1L << DIV) | (1L << MOD))) != 0)) ) {
							((MulDivModExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(124); expr(12);
						}
						break;

					case 2:
						{
						_localctx = new AddSubExprContext(new ExprContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(125);
						if (!(10 >= _localctx._p)) throw new FailedPredicateException(this, "10 >= $_p");
						setState(126);
						((AddSubExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MINUS || _la==ADD) ) {
							((AddSubExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(127); expr(11);
						}
						break;

					case 3:
						{
						_localctx = new CmpExprContext(new ExprContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(128);
						if (!(9 >= _localctx._p)) throw new FailedPredicateException(this, "9 >= $_p");
						setState(129);
						((CmpExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LT) | (1L << LQ) | (1L << GT) | (1L << GE))) != 0)) ) {
							((CmpExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(130); expr(10);
						}
						break;

					case 4:
						{
						_localctx = new EqExprContext(new ExprContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(131);
						if (!(8 >= _localctx._p)) throw new FailedPredicateException(this, "8 >= $_p");
						setState(132);
						((EqExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQ || _la==NE) ) {
							((EqExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(133); expr(9);
						}
						break;

					case 5:
						{
						_localctx = new AndExprContext(new ExprContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(134);
						if (!(7 >= _localctx._p)) throw new FailedPredicateException(this, "7 >= $_p");
						setState(135); match(17);
						setState(136); expr(8);
						}
						break;

					case 6:
						{
						_localctx = new OrExprContext(new ExprContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(137);
						if (!(6 >= _localctx._p)) throw new FailedPredicateException(this, "6 >= $_p");
						setState(138); match(18);
						setState(139); expr(7);
						}
						break;
					}
					} 
				}
				setState(144);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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

	public static class ConstantExprContext extends ParserRuleContext {
		public TerminalNode BOOL() { return getToken(JavascripticParser.BOOL, 0); }
		public TerminalNode UNDEF() { return getToken(JavascripticParser.UNDEF, 0); }
		public TerminalNode STR() { return getToken(JavascripticParser.STR, 0); }
		public TerminalNode NUM() { return getToken(JavascripticParser.NUM, 0); }
		public ConstantExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantExpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavascripticVisitor ) return ((JavascripticVisitor<? extends T>)visitor).visitConstantExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantExprContext constantExpr() throws RecognitionException {
		ConstantExprContext _localctx = new ConstantExprContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_constantExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUM) | (1L << STR) | (1L << BOOL) | (1L << UNDEF))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class FunctionCallContext extends ParserRuleContext {
		public FunctionArgsContext functionArgs() {
			return getRuleContext(FunctionArgsContext.class,0);
		}
		public TerminalNode ID() { return getToken(JavascripticParser.ID, 0); }
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavascripticVisitor ) return ((JavascripticVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_functionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147); match(ID);
			setState(148); match(3);
			setState(150);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << NOT) | (1L << MINUS) | (1L << NUM) | (1L << STR) | (1L << BOOL) | (1L << UNDEF) | (1L << ID))) != 0)) {
				{
				setState(149); functionArgs();
				}
			}

			setState(152); match(13);
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
		enterRule(_localctx, 24, RULE_returnStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154); match(15);
			setState(156);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << NOT) | (1L << MINUS) | (1L << NUM) | (1L << STR) | (1L << BOOL) | (1L << UNDEF) | (1L << ID))) != 0)) {
				{
				setState(155); expr(0);
				}
			}

			setState(158); match(16);
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

	public static class BreakStatContext extends ParserRuleContext {
		public BreakStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_breakStat; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavascripticVisitor ) return ((JavascripticVisitor<? extends T>)visitor).visitBreakStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BreakStatContext breakStat() throws RecognitionException {
		BreakStatContext _localctx = new BreakStatContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_breakStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160); match(8);
			setState(161); match(16);
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

	public static class ContinueStatContext extends ParserRuleContext {
		public ContinueStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continueStat; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavascripticVisitor ) return ((JavascripticVisitor<? extends T>)visitor).visitContinueStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContinueStatContext continueStat() throws RecognitionException {
		ContinueStatContext _localctx = new ContinueStatContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_continueStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163); match(5);
			setState(164); match(16);
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
		enterRule(_localctx, 30, RULE_exprStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166); expr(0);
			setState(167); match(16);
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
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
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
		enterRule(_localctx, 32, RULE_functionParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169); param();
			setState(174);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==1) {
				{
				{
				setState(170); match(1);
				setState(171); param();
				}
				}
				setState(176);
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

	public static class ParamContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(JavascripticParser.ID, 0); }
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavascripticVisitor ) return ((JavascripticVisitor<? extends T>)visitor).visitParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177); match(ID);
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
		enterRule(_localctx, 36, RULE_functionArgs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179); expr(0);
			setState(184);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==1) {
				{
				{
				setState(180); match(1);
				setState(181); expr(0);
				}
				}
				setState(186);
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
		case 9: return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return 11 >= _localctx._p;

		case 1: return 10 >= _localctx._p;

		case 2: return 9 >= _localctx._p;

		case 3: return 8 >= _localctx._p;

		case 4: return 7 >= _localctx._p;

		case 5: return 6 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3(\u00be\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\7\2*\n\2\f\2\16\2-\13\2\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\5\39\n\3\3\4\3\4\7\4=\n\4\f\4\16\4@\13\4\3\4\3\4\3"+
		"\5\3\5\3\5\3\5\5\5H\n\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\5\6Q\n\6\3\6\3\6\3"+
		"\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b`\n\b\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\5\13{\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u008f\n\13"+
		"\f\13\16\13\u0092\13\13\3\f\3\f\3\r\3\r\3\r\5\r\u0099\n\r\3\r\3\r\3\16"+
		"\3\16\5\16\u009f\n\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21"+
		"\3\21\3\22\3\22\3\22\7\22\u00af\n\22\f\22\16\22\u00b2\13\22\3\23\3\23"+
		"\3\24\3\24\3\24\7\24\u00b9\n\24\f\24\16\24\u00bc\13\24\3\24\2\25\2\4\6"+
		"\b\n\f\16\20\22\24\26\30\32\34\36 \"$&\2\b\3\2\25\26\3\2\27\31\4\2\26"+
		"\26\32\32\3\2\33\36\3\2\37 \3\2!$\u00c7\2+\3\2\2\2\48\3\2\2\2\6:\3\2\2"+
		"\2\bC\3\2\2\2\nL\3\2\2\2\fT\3\2\2\2\16X\3\2\2\2\20a\3\2\2\2\22g\3\2\2"+
		"\2\24z\3\2\2\2\26\u0093\3\2\2\2\30\u0095\3\2\2\2\32\u009c\3\2\2\2\34\u00a2"+
		"\3\2\2\2\36\u00a5\3\2\2\2 \u00a8\3\2\2\2\"\u00ab\3\2\2\2$\u00b3\3\2\2"+
		"\2&\u00b5\3\2\2\2(*\5\4\3\2)(\3\2\2\2*-\3\2\2\2+)\3\2\2\2+,\3\2\2\2,\3"+
		"\3\2\2\2-+\3\2\2\2.9\5\6\4\2/9\5\b\5\2\609\5\n\6\2\619\5\16\b\2\629\5"+
		"\20\t\2\639\5\22\n\2\649\5\32\16\2\659\5\34\17\2\669\5\36\20\2\679\5 "+
		"\21\28.\3\2\2\28/\3\2\2\28\60\3\2\2\28\61\3\2\2\28\62\3\2\2\28\63\3\2"+
		"\2\28\64\3\2\2\28\65\3\2\2\28\66\3\2\2\28\67\3\2\2\29\5\3\2\2\2:>\7\t"+
		"\2\2;=\5\4\3\2<;\3\2\2\2=@\3\2\2\2><\3\2\2\2>?\3\2\2\2?A\3\2\2\2@>\3\2"+
		"\2\2AB\7\f\2\2B\7\3\2\2\2CD\7\16\2\2DE\7%\2\2EG\7\5\2\2FH\5\"\22\2GF\3"+
		"\2\2\2GH\3\2\2\2HI\3\2\2\2IJ\7\17\2\2JK\5\6\4\2K\t\3\2\2\2LM\7\b\2\2M"+
		"P\7%\2\2NO\7\20\2\2OQ\5\24\13\2PN\3\2\2\2PQ\3\2\2\2QR\3\2\2\2RS\7\22\2"+
		"\2S\13\3\2\2\2TU\7%\2\2UV\7\20\2\2VW\5\24\13\2W\r\3\2\2\2XY\7\6\2\2YZ"+
		"\7\5\2\2Z[\5\24\13\2[\\\7\17\2\2\\_\5\4\3\2]^\7\13\2\2^`\5\4\3\2_]\3\2"+
		"\2\2_`\3\2\2\2`\17\3\2\2\2ab\7\4\2\2bc\7\5\2\2cd\5\24\13\2de\7\17\2\2"+
		"ef\5\4\3\2f\21\3\2\2\2gh\7\r\2\2hi\5\4\3\2ij\7\4\2\2jk\7\5\2\2kl\5\24"+
		"\13\2lm\7\17\2\2mn\7\22\2\2n\23\3\2\2\2op\b\13\1\2pq\t\2\2\2q{\5\24\13"+
		"\2r{\5\f\7\2st\7\5\2\2tu\5\24\13\2uv\7\17\2\2v{\3\2\2\2w{\7%\2\2x{\5\26"+
		"\f\2y{\5\30\r\2zo\3\2\2\2zr\3\2\2\2zs\3\2\2\2zw\3\2\2\2zx\3\2\2\2zy\3"+
		"\2\2\2{\u0090\3\2\2\2|}\6\13\2\3}~\t\3\2\2~\u008f\5\24\13\2\177\u0080"+
		"\6\13\3\3\u0080\u0081\t\4\2\2\u0081\u008f\5\24\13\2\u0082\u0083\6\13\4"+
		"\3\u0083\u0084\t\5\2\2\u0084\u008f\5\24\13\2\u0085\u0086\6\13\5\3\u0086"+
		"\u0087\t\6\2\2\u0087\u008f\5\24\13\2\u0088\u0089\6\13\6\3\u0089\u008a"+
		"\7\23\2\2\u008a\u008f\5\24\13\2\u008b\u008c\6\13\7\3\u008c\u008d\7\24"+
		"\2\2\u008d\u008f\5\24\13\2\u008e|\3\2\2\2\u008e\177\3\2\2\2\u008e\u0082"+
		"\3\2\2\2\u008e\u0085\3\2\2\2\u008e\u0088\3\2\2\2\u008e\u008b\3\2\2\2\u008f"+
		"\u0092\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\25\3\2\2"+
		"\2\u0092\u0090\3\2\2\2\u0093\u0094\t\7\2\2\u0094\27\3\2\2\2\u0095\u0096"+
		"\7%\2\2\u0096\u0098\7\5\2\2\u0097\u0099\5&\24\2\u0098\u0097\3\2\2\2\u0098"+
		"\u0099\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009b\7\17\2\2\u009b\31\3\2\2"+
		"\2\u009c\u009e\7\21\2\2\u009d\u009f\5\24\13\2\u009e\u009d\3\2\2\2\u009e"+
		"\u009f\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a1\7\22\2\2\u00a1\33\3\2\2"+
		"\2\u00a2\u00a3\7\n\2\2\u00a3\u00a4\7\22\2\2\u00a4\35\3\2\2\2\u00a5\u00a6"+
		"\7\7\2\2\u00a6\u00a7\7\22\2\2\u00a7\37\3\2\2\2\u00a8\u00a9\5\24\13\2\u00a9"+
		"\u00aa\7\22\2\2\u00aa!\3\2\2\2\u00ab\u00b0\5$\23\2\u00ac\u00ad\7\3\2\2"+
		"\u00ad\u00af\5$\23\2\u00ae\u00ac\3\2\2\2\u00af\u00b2\3\2\2\2\u00b0\u00ae"+
		"\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1#\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b3"+
		"\u00b4\7%\2\2\u00b4%\3\2\2\2\u00b5\u00ba\5\24\13\2\u00b6\u00b7\7\3\2\2"+
		"\u00b7\u00b9\5\24\13\2\u00b8\u00b6\3\2\2\2\u00b9\u00bc\3\2\2\2\u00ba\u00b8"+
		"\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\'\3\2\2\2\u00bc\u00ba\3\2\2\2\17+8"+
		">GP_z\u008e\u0090\u0098\u009e\u00b0\u00ba";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}