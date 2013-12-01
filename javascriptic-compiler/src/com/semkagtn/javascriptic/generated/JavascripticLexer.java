// Generated from Javascriptic.g4 by ANTLR 4.1

package com.semkagtn.javascriptic.generated;

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
		T__16=1, T__15=2, T__14=3, T__13=4, T__12=5, T__11=6, T__10=7, T__9=8, 
		T__8=9, T__7=10, T__6=11, T__5=12, T__4=13, T__3=14, T__2=15, T__1=16, 
		T__0=17, NOT=18, MINUS=19, MUL=20, DIV=21, MOD=22, ADD=23, LT=24, LE=25, 
		GT=26, GE=27, EQ=28, NE=29, NUM=30, STR=31, BOOL=32, UNDEF=33, ID=34, 
		COMMENT=35, LINE_COMMENT=36, WS=37;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"']'", "','", "'while'", "'['", "'('", "'if'", "'var'", "'{'", "'else'", 
		"'}'", "')'", "'function'", "'='", "'return'", "';'", "'&&'", "'||'", 
		"'!'", "'-'", "'*'", "'/'", "'%'", "'+'", "'<'", "'<='", "'>'", "'>='", 
		"'=='", "'!='", "NUM", "STR", "BOOL", "'undefined'", "ID", "COMMENT", 
		"LINE_COMMENT", "WS"
	};
	public static final String[] ruleNames = {
		"T__16", "T__15", "T__14", "T__13", "T__12", "T__11", "T__10", "T__9", 
		"T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", 
		"NOT", "MINUS", "MUL", "DIV", "MOD", "ADD", "LT", "LE", "GT", "GE", "EQ", 
		"NE", "NUM", "STR", "BOOL", "UNDEF", "ID", "COMMENT", "LINE_COMMENT", 
		"WS", "DIGIT", "ID_LETTER", "ESC"
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
		case 34: COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 35: LINE_COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 36: WS_action((RuleContext)_localctx, actionIndex); break;
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\'\u010b\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\3\2\3\2\3\3\3"+
		"\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b"+
		"\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3"+
		"\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3"+
		"\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\34\3\34\3\34\3"+
		"\35\3\35\3\35\3\36\3\36\3\36\3\37\6\37\u00ab\n\37\r\37\16\37\u00ac\3\37"+
		"\3\37\6\37\u00b1\n\37\r\37\16\37\u00b2\5\37\u00b5\n\37\3\37\3\37\3\37"+
		"\5\37\u00ba\n\37\3 \3 \3 \7 \u00bf\n \f \16 \u00c2\13 \3 \3 \3!\3!\3!"+
		"\3!\3!\3!\3!\3!\3!\5!\u00cf\n!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\""+
		"\3#\3#\3#\7#\u00de\n#\f#\16#\u00e1\13#\3$\3$\3$\3$\7$\u00e7\n$\f$\16$"+
		"\u00ea\13$\3$\3$\3$\3$\3$\3%\3%\3%\3%\7%\u00f5\n%\f%\16%\u00f8\13%\3%"+
		"\3%\3%\3%\3&\6&\u00ff\n&\r&\16&\u0100\3&\3&\3\'\3\'\3(\3(\3)\3)\3)\5\u00c0"+
		"\u00e8\u00f6*\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13"+
		"\1\25\f\1\27\r\1\31\16\1\33\17\1\35\20\1\37\21\1!\22\1#\23\1%\24\1\'\25"+
		"\1)\26\1+\27\1-\30\1/\31\1\61\32\1\63\33\1\65\34\1\67\35\19\36\1;\37\1"+
		"= \1?!\1A\"\1C#\1E$\1G%\2I&\3K\'\4M\2\1O\2\1Q\2\1\3\2\7\4\2$$^^\5\2\13"+
		"\f\17\17\"\"\3\2\62;\6\2&&C\\aac|\n\2$$\61\61^^ddhhppttvv\u0113\2\3\3"+
		"\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2"+
		"\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3"+
		"\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2"+
		"%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61"+
		"\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2"+
		"\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I"+
		"\3\2\2\2\2K\3\2\2\2\3S\3\2\2\2\5U\3\2\2\2\7W\3\2\2\2\t]\3\2\2\2\13_\3"+
		"\2\2\2\ra\3\2\2\2\17d\3\2\2\2\21h\3\2\2\2\23j\3\2\2\2\25o\3\2\2\2\27q"+
		"\3\2\2\2\31s\3\2\2\2\33|\3\2\2\2\35~\3\2\2\2\37\u0085\3\2\2\2!\u0087\3"+
		"\2\2\2#\u008a\3\2\2\2%\u008d\3\2\2\2\'\u008f\3\2\2\2)\u0091\3\2\2\2+\u0093"+
		"\3\2\2\2-\u0095\3\2\2\2/\u0097\3\2\2\2\61\u0099\3\2\2\2\63\u009b\3\2\2"+
		"\2\65\u009e\3\2\2\2\67\u00a0\3\2\2\29\u00a3\3\2\2\2;\u00a6\3\2\2\2=\u00b9"+
		"\3\2\2\2?\u00bb\3\2\2\2A\u00ce\3\2\2\2C\u00d0\3\2\2\2E\u00da\3\2\2\2G"+
		"\u00e2\3\2\2\2I\u00f0\3\2\2\2K\u00fe\3\2\2\2M\u0104\3\2\2\2O\u0106\3\2"+
		"\2\2Q\u0108\3\2\2\2ST\7_\2\2T\4\3\2\2\2UV\7.\2\2V\6\3\2\2\2WX\7y\2\2X"+
		"Y\7j\2\2YZ\7k\2\2Z[\7n\2\2[\\\7g\2\2\\\b\3\2\2\2]^\7]\2\2^\n\3\2\2\2_"+
		"`\7*\2\2`\f\3\2\2\2ab\7k\2\2bc\7h\2\2c\16\3\2\2\2de\7x\2\2ef\7c\2\2fg"+
		"\7t\2\2g\20\3\2\2\2hi\7}\2\2i\22\3\2\2\2jk\7g\2\2kl\7n\2\2lm\7u\2\2mn"+
		"\7g\2\2n\24\3\2\2\2op\7\177\2\2p\26\3\2\2\2qr\7+\2\2r\30\3\2\2\2st\7h"+
		"\2\2tu\7w\2\2uv\7p\2\2vw\7e\2\2wx\7v\2\2xy\7k\2\2yz\7q\2\2z{\7p\2\2{\32"+
		"\3\2\2\2|}\7?\2\2}\34\3\2\2\2~\177\7t\2\2\177\u0080\7g\2\2\u0080\u0081"+
		"\7v\2\2\u0081\u0082\7w\2\2\u0082\u0083\7t\2\2\u0083\u0084\7p\2\2\u0084"+
		"\36\3\2\2\2\u0085\u0086\7=\2\2\u0086 \3\2\2\2\u0087\u0088\7(\2\2\u0088"+
		"\u0089\7(\2\2\u0089\"\3\2\2\2\u008a\u008b\7~\2\2\u008b\u008c\7~\2\2\u008c"+
		"$\3\2\2\2\u008d\u008e\7#\2\2\u008e&\3\2\2\2\u008f\u0090\7/\2\2\u0090("+
		"\3\2\2\2\u0091\u0092\7,\2\2\u0092*\3\2\2\2\u0093\u0094\7\61\2\2\u0094"+
		",\3\2\2\2\u0095\u0096\7\'\2\2\u0096.\3\2\2\2\u0097\u0098\7-\2\2\u0098"+
		"\60\3\2\2\2\u0099\u009a\7>\2\2\u009a\62\3\2\2\2\u009b\u009c\7>\2\2\u009c"+
		"\u009d\7?\2\2\u009d\64\3\2\2\2\u009e\u009f\7@\2\2\u009f\66\3\2\2\2\u00a0"+
		"\u00a1\7@\2\2\u00a1\u00a2\7?\2\2\u00a28\3\2\2\2\u00a3\u00a4\7?\2\2\u00a4"+
		"\u00a5\7?\2\2\u00a5:\3\2\2\2\u00a6\u00a7\7#\2\2\u00a7\u00a8\7?\2\2\u00a8"+
		"<\3\2\2\2\u00a9\u00ab\5M\'\2\u00aa\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac"+
		"\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00b4\3\2\2\2\u00ae\u00b0\7\60"+
		"\2\2\u00af\u00b1\5M\'\2\u00b0\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2"+
		"\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b5\3\2\2\2\u00b4\u00ae\3\2"+
		"\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00ba\3\2\2\2\u00b6\u00b7\7P\2\2\u00b7"+
		"\u00b8\7c\2\2\u00b8\u00ba\7P\2\2\u00b9\u00aa\3\2\2\2\u00b9\u00b6\3\2\2"+
		"\2\u00ba>\3\2\2\2\u00bb\u00c0\7$\2\2\u00bc\u00bf\5Q)\2\u00bd\u00bf\n\2"+
		"\2\2\u00be\u00bc\3\2\2\2\u00be\u00bd\3\2\2\2\u00bf\u00c2\3\2\2\2\u00c0"+
		"\u00c1\3\2\2\2\u00c0\u00be\3\2\2\2\u00c1\u00c3\3\2\2\2\u00c2\u00c0\3\2"+
		"\2\2\u00c3\u00c4\7$\2\2\u00c4@\3\2\2\2\u00c5\u00c6\7v\2\2\u00c6\u00c7"+
		"\7t\2\2\u00c7\u00c8\7w\2\2\u00c8\u00cf\7g\2\2\u00c9\u00ca\7h\2\2\u00ca"+
		"\u00cb\7c\2\2\u00cb\u00cc\7n\2\2\u00cc\u00cd\7u\2\2\u00cd\u00cf\7g\2\2"+
		"\u00ce\u00c5\3\2\2\2\u00ce\u00c9\3\2\2\2\u00cfB\3\2\2\2\u00d0\u00d1\7"+
		"w\2\2\u00d1\u00d2\7p\2\2\u00d2\u00d3\7f\2\2\u00d3\u00d4\7g\2\2\u00d4\u00d5"+
		"\7h\2\2\u00d5\u00d6\7k\2\2\u00d6\u00d7\7p\2\2\u00d7\u00d8\7g\2\2\u00d8"+
		"\u00d9\7f\2\2\u00d9D\3\2\2\2\u00da\u00df\5O(\2\u00db\u00de\5O(\2\u00dc"+
		"\u00de\5M\'\2\u00dd\u00db\3\2\2\2\u00dd\u00dc\3\2\2\2\u00de\u00e1\3\2"+
		"\2\2\u00df\u00dd\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0F\3\2\2\2\u00e1\u00df"+
		"\3\2\2\2\u00e2\u00e3\7\61\2\2\u00e3\u00e4\7,\2\2\u00e4\u00e8\3\2\2\2\u00e5"+
		"\u00e7\13\2\2\2\u00e6\u00e5\3\2\2\2\u00e7\u00ea\3\2\2\2\u00e8\u00e9\3"+
		"\2\2\2\u00e8\u00e6\3\2\2\2\u00e9\u00eb\3\2\2\2\u00ea\u00e8\3\2\2\2\u00eb"+
		"\u00ec\7,\2\2\u00ec\u00ed\7\61\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00ef\b$"+
		"\2\2\u00efH\3\2\2\2\u00f0\u00f1\7\61\2\2\u00f1\u00f2\7\61\2\2\u00f2\u00f6"+
		"\3\2\2\2\u00f3\u00f5\13\2\2\2\u00f4\u00f3\3\2\2\2\u00f5\u00f8\3\2\2\2"+
		"\u00f6\u00f7\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f7\u00f9\3\2\2\2\u00f8\u00f6"+
		"\3\2\2\2\u00f9\u00fa\7\f\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fc\b%\3\2\u00fc"+
		"J\3\2\2\2\u00fd\u00ff\t\3\2\2\u00fe\u00fd\3\2\2\2\u00ff\u0100\3\2\2\2"+
		"\u0100\u00fe\3\2\2\2\u0100\u0101\3\2\2\2\u0101\u0102\3\2\2\2\u0102\u0103"+
		"\b&\4\2\u0103L\3\2\2\2\u0104\u0105\t\4\2\2\u0105N\3\2\2\2\u0106\u0107"+
		"\t\5\2\2\u0107P\3\2\2\2\u0108\u0109\7^\2\2\u0109\u010a\t\6\2\2\u010aR"+
		"\3\2\2\2\17\2\u00ac\u00b2\u00b4\u00b9\u00be\u00c0\u00ce\u00dd\u00df\u00e8"+
		"\u00f6\u0100";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}