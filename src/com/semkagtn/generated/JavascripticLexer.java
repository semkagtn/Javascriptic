// Generated from Javascriptic.g4 by ANTLR 4.1

package com.semkagtn.generated;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class JavascripticLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__15=1, T__14=2, T__13=3, T__12=4, T__11=5, T__10=6, T__9=7, T__8=8, 
		T__7=9, T__6=10, T__5=11, T__4=12, T__3=13, T__2=14, T__1=15, T__0=16, 
		NOT=17, MINUS=18, MUL=19, DIV=20, MOD=21, ADD=22, LT=23, LQ=24, GT=25, 
		GE=26, EQ=27, NE=28, NUM=29, STR=30, BOOL=31, UNDEF=32, ID=33, COMMENT=34, 
		LINE_COMMENT=35, WS=36;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"','", "'while'", "'('", "'if'", "'var'", "'{'", "'else'", "'}'", "'do'", 
		"'function'", "')'", "'='", "'return'", "';'", "'&&'", "'||'", "'!'", 
		"'-'", "'*'", "'/'", "'%'", "'+'", "'<'", "'<='", "'>'", "'>='", "'=='", 
		"'!='", "NUM", "STR", "BOOL", "'undefined'", "ID", "COMMENT", "LINE_COMMENT", 
		"WS"
	};
	public static final String[] ruleNames = {
		"T__15", "T__14", "T__13", "T__12", "T__11", "T__10", "T__9", "T__8", 
		"T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "NOT", 
		"MINUS", "MUL", "DIV", "MOD", "ADD", "LT", "LQ", "GT", "GE", "EQ", "NE", 
		"NUM", "STR", "BOOL", "UNDEF", "ID", "COMMENT", "LINE_COMMENT", "WS", 
		"DIGIT", "ID_LETTER", "ESC"
	};


	public JavascripticLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Javascriptic.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 33: COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 34: LINE_COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 35: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2: skip();  break;
		}
	}
	private void LINE_COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1: skip();  break;
		}
	}
	private void COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2&\u00fb\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\3\2\3\2\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3"+
		"\b\3\b\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\20\3\20"+
		"\3\20\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26"+
		"\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\33\3\33\3\33\3\34\3\34"+
		"\3\34\3\35\3\35\3\35\3\36\6\36\u00a8\n\36\r\36\16\36\u00a9\3\37\3\37\3"+
		"\37\7\37\u00af\n\37\f\37\16\37\u00b2\13\37\3\37\3\37\3 \3 \3 \3 \3 \3"+
		" \3 \3 \3 \5 \u00bf\n \3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\7\"\u00ce"+
		"\n\"\f\"\16\"\u00d1\13\"\3#\3#\3#\3#\7#\u00d7\n#\f#\16#\u00da\13#\3#\3"+
		"#\3#\3#\3#\3$\3$\3$\3$\7$\u00e5\n$\f$\16$\u00e8\13$\3$\3$\3$\3$\3%\6%"+
		"\u00ef\n%\r%\16%\u00f0\3%\3%\3&\3&\3\'\3\'\3(\3(\3(\5\u00b0\u00d8\u00e6"+
		")\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27"+
		"\r\1\31\16\1\33\17\1\35\20\1\37\21\1!\22\1#\23\1%\24\1\'\25\1)\26\1+\27"+
		"\1-\30\1/\31\1\61\32\1\63\33\1\65\34\1\67\35\19\36\1;\37\1= \1?!\1A\""+
		"\1C#\1E$\2G%\3I&\4K\2\1M\2\1O\2\1\3\2\6\5\2\13\f\17\17\"\"\3\2\62;\6\2"+
		"&&C\\aac|\b\2$$^^ddppttvv\u0100\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2"+
		"\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2"+
		"\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2"+
		"\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2"+
		"\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2"+
		"\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2"+
		"\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\3Q\3\2\2\2\5S\3\2\2\2\7Y"+
		"\3\2\2\2\t[\3\2\2\2\13^\3\2\2\2\rb\3\2\2\2\17d\3\2\2\2\21i\3\2\2\2\23"+
		"k\3\2\2\2\25n\3\2\2\2\27w\3\2\2\2\31y\3\2\2\2\33{\3\2\2\2\35\u0082\3\2"+
		"\2\2\37\u0084\3\2\2\2!\u0087\3\2\2\2#\u008a\3\2\2\2%\u008c\3\2\2\2\'\u008e"+
		"\3\2\2\2)\u0090\3\2\2\2+\u0092\3\2\2\2-\u0094\3\2\2\2/\u0096\3\2\2\2\61"+
		"\u0098\3\2\2\2\63\u009b\3\2\2\2\65\u009d\3\2\2\2\67\u00a0\3\2\2\29\u00a3"+
		"\3\2\2\2;\u00a7\3\2\2\2=\u00ab\3\2\2\2?\u00be\3\2\2\2A\u00c0\3\2\2\2C"+
		"\u00ca\3\2\2\2E\u00d2\3\2\2\2G\u00e0\3\2\2\2I\u00ee\3\2\2\2K\u00f4\3\2"+
		"\2\2M\u00f6\3\2\2\2O\u00f8\3\2\2\2QR\7.\2\2R\4\3\2\2\2ST\7y\2\2TU\7j\2"+
		"\2UV\7k\2\2VW\7n\2\2WX\7g\2\2X\6\3\2\2\2YZ\7*\2\2Z\b\3\2\2\2[\\\7k\2\2"+
		"\\]\7h\2\2]\n\3\2\2\2^_\7x\2\2_`\7c\2\2`a\7t\2\2a\f\3\2\2\2bc\7}\2\2c"+
		"\16\3\2\2\2de\7g\2\2ef\7n\2\2fg\7u\2\2gh\7g\2\2h\20\3\2\2\2ij\7\177\2"+
		"\2j\22\3\2\2\2kl\7f\2\2lm\7q\2\2m\24\3\2\2\2no\7h\2\2op\7w\2\2pq\7p\2"+
		"\2qr\7e\2\2rs\7v\2\2st\7k\2\2tu\7q\2\2uv\7p\2\2v\26\3\2\2\2wx\7+\2\2x"+
		"\30\3\2\2\2yz\7?\2\2z\32\3\2\2\2{|\7t\2\2|}\7g\2\2}~\7v\2\2~\177\7w\2"+
		"\2\177\u0080\7t\2\2\u0080\u0081\7p\2\2\u0081\34\3\2\2\2\u0082\u0083\7"+
		"=\2\2\u0083\36\3\2\2\2\u0084\u0085\7(\2\2\u0085\u0086\7(\2\2\u0086 \3"+
		"\2\2\2\u0087\u0088\7~\2\2\u0088\u0089\7~\2\2\u0089\"\3\2\2\2\u008a\u008b"+
		"\7#\2\2\u008b$\3\2\2\2\u008c\u008d\7/\2\2\u008d&\3\2\2\2\u008e\u008f\7"+
		",\2\2\u008f(\3\2\2\2\u0090\u0091\7\61\2\2\u0091*\3\2\2\2\u0092\u0093\7"+
		"\'\2\2\u0093,\3\2\2\2\u0094\u0095\7-\2\2\u0095.\3\2\2\2\u0096\u0097\7"+
		">\2\2\u0097\60\3\2\2\2\u0098\u0099\7>\2\2\u0099\u009a\7?\2\2\u009a\62"+
		"\3\2\2\2\u009b\u009c\7@\2\2\u009c\64\3\2\2\2\u009d\u009e\7@\2\2\u009e"+
		"\u009f\7?\2\2\u009f\66\3\2\2\2\u00a0\u00a1\7?\2\2\u00a1\u00a2\7?\2\2\u00a2"+
		"8\3\2\2\2\u00a3\u00a4\7#\2\2\u00a4\u00a5\7?\2\2\u00a5:\3\2\2\2\u00a6\u00a8"+
		"\5K&\2\u00a7\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00a7\3\2\2\2\u00a9"+
		"\u00aa\3\2\2\2\u00aa<\3\2\2\2\u00ab\u00b0\7$\2\2\u00ac\u00af\5O(\2\u00ad"+
		"\u00af\13\2\2\2\u00ae\u00ac\3\2\2\2\u00ae\u00ad\3\2\2\2\u00af\u00b2\3"+
		"\2\2\2\u00b0\u00b1\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b1\u00b3\3\2\2\2\u00b2"+
		"\u00b0\3\2\2\2\u00b3\u00b4\7$\2\2\u00b4>\3\2\2\2\u00b5\u00b6\7v\2\2\u00b6"+
		"\u00b7\7t\2\2\u00b7\u00b8\7w\2\2\u00b8\u00bf\7g\2\2\u00b9\u00ba\7h\2\2"+
		"\u00ba\u00bb\7c\2\2\u00bb\u00bc\7n\2\2\u00bc\u00bd\7u\2\2\u00bd\u00bf"+
		"\7g\2\2\u00be\u00b5\3\2\2\2\u00be\u00b9\3\2\2\2\u00bf@\3\2\2\2\u00c0\u00c1"+
		"\7w\2\2\u00c1\u00c2\7p\2\2\u00c2\u00c3\7f\2\2\u00c3\u00c4\7g\2\2\u00c4"+
		"\u00c5\7h\2\2\u00c5\u00c6\7k\2\2\u00c6\u00c7\7p\2\2\u00c7\u00c8\7g\2\2"+
		"\u00c8\u00c9\7f\2\2\u00c9B\3\2\2\2\u00ca\u00cf\5M\'\2\u00cb\u00ce\5M\'"+
		"\2\u00cc\u00ce\5K&\2\u00cd\u00cb\3\2\2\2\u00cd\u00cc\3\2\2\2\u00ce\u00d1"+
		"\3\2\2\2\u00cf\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0D\3\2\2\2\u00d1"+
		"\u00cf\3\2\2\2\u00d2\u00d3\7\61\2\2\u00d3\u00d4\7,\2\2\u00d4\u00d8\3\2"+
		"\2\2\u00d5\u00d7\13\2\2\2\u00d6\u00d5\3\2\2\2\u00d7\u00da\3\2\2\2\u00d8"+
		"\u00d9\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d9\u00db\3\2\2\2\u00da\u00d8\3\2"+
		"\2\2\u00db\u00dc\7,\2\2\u00dc\u00dd\7\61\2\2\u00dd\u00de\3\2\2\2\u00de"+
		"\u00df\b#\2\2\u00dfF\3\2\2\2\u00e0\u00e1\7\61\2\2\u00e1\u00e2\7\61\2\2"+
		"\u00e2\u00e6\3\2\2\2\u00e3\u00e5\13\2\2\2\u00e4\u00e3\3\2\2\2\u00e5\u00e8"+
		"\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e7\u00e9\3\2\2\2\u00e8"+
		"\u00e6\3\2\2\2\u00e9\u00ea\7\f\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00ec\b$"+
		"\3\2\u00ecH\3\2\2\2\u00ed\u00ef\t\2\2\2\u00ee\u00ed\3\2\2\2\u00ef\u00f0"+
		"\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2"+
		"\u00f3\b%\4\2\u00f3J\3\2\2\2\u00f4\u00f5\t\3\2\2\u00f5L\3\2\2\2\u00f6"+
		"\u00f7\t\4\2\2\u00f7N\3\2\2\2\u00f8\u00f9\7^\2\2\u00f9\u00fa\t\5\2\2\u00fa"+
		"P\3\2\2\2\f\2\u00a9\u00ae\u00b0\u00be\u00cd\u00cf\u00d8\u00e6\u00f0";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}