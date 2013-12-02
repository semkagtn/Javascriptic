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
		GT=26, GE=27, EQ=28, NE=29, SEQ=30, SNE=31, NUM=32, STR=33, BOOL=34, UNDEF=35, 
		ID=36, COMMENT=37, LINE_COMMENT=38, WS=39;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"']'", "','", "'while'", "'['", "'('", "'if'", "'var'", "'{'", "'else'", 
		"'}'", "')'", "'function'", "'='", "'return'", "';'", "'&&'", "'||'", 
		"'!'", "'-'", "'*'", "'/'", "'%'", "'+'", "'<'", "'<='", "'>'", "'>='", 
		"'=='", "'!='", "'==='", "'!=='", "NUM", "STR", "BOOL", "'undefined'", 
		"ID", "COMMENT", "LINE_COMMENT", "WS"
	};
	public static final String[] ruleNames = {
		"T__16", "T__15", "T__14", "T__13", "T__12", "T__11", "T__10", "T__9", 
		"T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", 
		"NOT", "MINUS", "MUL", "DIV", "MOD", "ADD", "LT", "LE", "GT", "GE", "EQ", 
		"NE", "SEQ", "SNE", "NUM", "STR", "BOOL", "UNDEF", "ID", "COMMENT", "LINE_COMMENT", 
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
		case 36: COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 37: LINE_COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 38: WS_action((RuleContext)_localctx, actionIndex); break;
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2)\u0117\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\3"+
		"\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\b"+
		"\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25"+
		"\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\34"+
		"\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3 \3 \3 "+
		"\3 \3!\6!\u00b7\n!\r!\16!\u00b8\3!\3!\6!\u00bd\n!\r!\16!\u00be\5!\u00c1"+
		"\n!\3!\3!\3!\5!\u00c6\n!\3\"\3\"\3\"\7\"\u00cb\n\"\f\"\16\"\u00ce\13\""+
		"\3\"\3\"\3#\3#\3#\3#\3#\3#\3#\3#\3#\5#\u00db\n#\3$\3$\3$\3$\3$\3$\3$\3"+
		"$\3$\3$\3%\3%\3%\7%\u00ea\n%\f%\16%\u00ed\13%\3&\3&\3&\3&\7&\u00f3\n&"+
		"\f&\16&\u00f6\13&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\7\'\u0101\n\'\f\'\16"+
		"\'\u0104\13\'\3\'\3\'\3\'\3\'\3(\6(\u010b\n(\r(\16(\u010c\3(\3(\3)\3)"+
		"\3*\3*\3+\3+\3+\5\u00cc\u00f4\u0102,\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r"+
		"\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1\33\17\1\35\20\1\37\21"+
		"\1!\22\1#\23\1%\24\1\'\25\1)\26\1+\27\1-\30\1/\31\1\61\32\1\63\33\1\65"+
		"\34\1\67\35\19\36\1;\37\1= \1?!\1A\"\1C#\1E$\1G%\1I&\1K\'\2M(\3O)\4Q\2"+
		"\1S\2\1U\2\1\3\2\7\4\2$$^^\5\2\13\f\17\17\"\"\3\2\62;\6\2&&C\\aac|\n\2"+
		"$$\61\61^^ddhhppttvv\u011f\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2"+
		"\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2"+
		"\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3"+
		"\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2"+
		"\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67"+
		"\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2"+
		"\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2"+
		"\3W\3\2\2\2\5Y\3\2\2\2\7[\3\2\2\2\ta\3\2\2\2\13c\3\2\2\2\re\3\2\2\2\17"+
		"h\3\2\2\2\21l\3\2\2\2\23n\3\2\2\2\25s\3\2\2\2\27u\3\2\2\2\31w\3\2\2\2"+
		"\33\u0080\3\2\2\2\35\u0082\3\2\2\2\37\u0089\3\2\2\2!\u008b\3\2\2\2#\u008e"+
		"\3\2\2\2%\u0091\3\2\2\2\'\u0093\3\2\2\2)\u0095\3\2\2\2+\u0097\3\2\2\2"+
		"-\u0099\3\2\2\2/\u009b\3\2\2\2\61\u009d\3\2\2\2\63\u009f\3\2\2\2\65\u00a2"+
		"\3\2\2\2\67\u00a4\3\2\2\29\u00a7\3\2\2\2;\u00aa\3\2\2\2=\u00ad\3\2\2\2"+
		"?\u00b1\3\2\2\2A\u00c5\3\2\2\2C\u00c7\3\2\2\2E\u00da\3\2\2\2G\u00dc\3"+
		"\2\2\2I\u00e6\3\2\2\2K\u00ee\3\2\2\2M\u00fc\3\2\2\2O\u010a\3\2\2\2Q\u0110"+
		"\3\2\2\2S\u0112\3\2\2\2U\u0114\3\2\2\2WX\7_\2\2X\4\3\2\2\2YZ\7.\2\2Z\6"+
		"\3\2\2\2[\\\7y\2\2\\]\7j\2\2]^\7k\2\2^_\7n\2\2_`\7g\2\2`\b\3\2\2\2ab\7"+
		"]\2\2b\n\3\2\2\2cd\7*\2\2d\f\3\2\2\2ef\7k\2\2fg\7h\2\2g\16\3\2\2\2hi\7"+
		"x\2\2ij\7c\2\2jk\7t\2\2k\20\3\2\2\2lm\7}\2\2m\22\3\2\2\2no\7g\2\2op\7"+
		"n\2\2pq\7u\2\2qr\7g\2\2r\24\3\2\2\2st\7\177\2\2t\26\3\2\2\2uv\7+\2\2v"+
		"\30\3\2\2\2wx\7h\2\2xy\7w\2\2yz\7p\2\2z{\7e\2\2{|\7v\2\2|}\7k\2\2}~\7"+
		"q\2\2~\177\7p\2\2\177\32\3\2\2\2\u0080\u0081\7?\2\2\u0081\34\3\2\2\2\u0082"+
		"\u0083\7t\2\2\u0083\u0084\7g\2\2\u0084\u0085\7v\2\2\u0085\u0086\7w\2\2"+
		"\u0086\u0087\7t\2\2\u0087\u0088\7p\2\2\u0088\36\3\2\2\2\u0089\u008a\7"+
		"=\2\2\u008a \3\2\2\2\u008b\u008c\7(\2\2\u008c\u008d\7(\2\2\u008d\"\3\2"+
		"\2\2\u008e\u008f\7~\2\2\u008f\u0090\7~\2\2\u0090$\3\2\2\2\u0091\u0092"+
		"\7#\2\2\u0092&\3\2\2\2\u0093\u0094\7/\2\2\u0094(\3\2\2\2\u0095\u0096\7"+
		",\2\2\u0096*\3\2\2\2\u0097\u0098\7\61\2\2\u0098,\3\2\2\2\u0099\u009a\7"+
		"\'\2\2\u009a.\3\2\2\2\u009b\u009c\7-\2\2\u009c\60\3\2\2\2\u009d\u009e"+
		"\7>\2\2\u009e\62\3\2\2\2\u009f\u00a0\7>\2\2\u00a0\u00a1\7?\2\2\u00a1\64"+
		"\3\2\2\2\u00a2\u00a3\7@\2\2\u00a3\66\3\2\2\2\u00a4\u00a5\7@\2\2\u00a5"+
		"\u00a6\7?\2\2\u00a68\3\2\2\2\u00a7\u00a8\7?\2\2\u00a8\u00a9\7?\2\2\u00a9"+
		":\3\2\2\2\u00aa\u00ab\7#\2\2\u00ab\u00ac\7?\2\2\u00ac<\3\2\2\2\u00ad\u00ae"+
		"\7?\2\2\u00ae\u00af\7?\2\2\u00af\u00b0\7?\2\2\u00b0>\3\2\2\2\u00b1\u00b2"+
		"\7#\2\2\u00b2\u00b3\7?\2\2\u00b3\u00b4\7?\2\2\u00b4@\3\2\2\2\u00b5\u00b7"+
		"\5Q)\2\u00b6\u00b5\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b8"+
		"\u00b9\3\2\2\2\u00b9\u00c0\3\2\2\2\u00ba\u00bc\7\60\2\2\u00bb\u00bd\5"+
		"Q)\2\u00bc\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00bc\3\2\2\2\u00be"+
		"\u00bf\3\2\2\2\u00bf\u00c1\3\2\2\2\u00c0\u00ba\3\2\2\2\u00c0\u00c1\3\2"+
		"\2\2\u00c1\u00c6\3\2\2\2\u00c2\u00c3\7P\2\2\u00c3\u00c4\7c\2\2\u00c4\u00c6"+
		"\7P\2\2\u00c5\u00b6\3\2\2\2\u00c5\u00c2\3\2\2\2\u00c6B\3\2\2\2\u00c7\u00cc"+
		"\7$\2\2\u00c8\u00cb\5U+\2\u00c9\u00cb\n\2\2\2\u00ca\u00c8\3\2\2\2\u00ca"+
		"\u00c9\3\2\2\2\u00cb\u00ce\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cc\u00ca\3\2"+
		"\2\2\u00cd\u00cf\3\2\2\2\u00ce\u00cc\3\2\2\2\u00cf\u00d0\7$\2\2\u00d0"+
		"D\3\2\2\2\u00d1\u00d2\7v\2\2\u00d2\u00d3\7t\2\2\u00d3\u00d4\7w\2\2\u00d4"+
		"\u00db\7g\2\2\u00d5\u00d6\7h\2\2\u00d6\u00d7\7c\2\2\u00d7\u00d8\7n\2\2"+
		"\u00d8\u00d9\7u\2\2\u00d9\u00db\7g\2\2\u00da\u00d1\3\2\2\2\u00da\u00d5"+
		"\3\2\2\2\u00dbF\3\2\2\2\u00dc\u00dd\7w\2\2\u00dd\u00de\7p\2\2\u00de\u00df"+
		"\7f\2\2\u00df\u00e0\7g\2\2\u00e0\u00e1\7h\2\2\u00e1\u00e2\7k\2\2\u00e2"+
		"\u00e3\7p\2\2\u00e3\u00e4\7g\2\2\u00e4\u00e5\7f\2\2\u00e5H\3\2\2\2\u00e6"+
		"\u00eb\5S*\2\u00e7\u00ea\5S*\2\u00e8\u00ea\5Q)\2\u00e9\u00e7\3\2\2\2\u00e9"+
		"\u00e8\3\2\2\2\u00ea\u00ed\3\2\2\2\u00eb\u00e9\3\2\2\2\u00eb\u00ec\3\2"+
		"\2\2\u00ecJ\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ee\u00ef\7\61\2\2\u00ef\u00f0"+
		"\7,\2\2\u00f0\u00f4\3\2\2\2\u00f1\u00f3\13\2\2\2\u00f2\u00f1\3\2\2\2\u00f3"+
		"\u00f6\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f5\u00f7\3\2"+
		"\2\2\u00f6\u00f4\3\2\2\2\u00f7\u00f8\7,\2\2\u00f8\u00f9\7\61\2\2\u00f9"+
		"\u00fa\3\2\2\2\u00fa\u00fb\b&\2\2\u00fbL\3\2\2\2\u00fc\u00fd\7\61\2\2"+
		"\u00fd\u00fe\7\61\2\2\u00fe\u0102\3\2\2\2\u00ff\u0101\13\2\2\2\u0100\u00ff"+
		"\3\2\2\2\u0101\u0104\3\2\2\2\u0102\u0103\3\2\2\2\u0102\u0100\3\2\2\2\u0103"+
		"\u0105\3\2\2\2\u0104\u0102\3\2\2\2\u0105\u0106\7\f\2\2\u0106\u0107\3\2"+
		"\2\2\u0107\u0108\b\'\3\2\u0108N\3\2\2\2\u0109\u010b\t\3\2\2\u010a\u0109"+
		"\3\2\2\2\u010b\u010c\3\2\2\2\u010c\u010a\3\2\2\2\u010c\u010d\3\2\2\2\u010d"+
		"\u010e\3\2\2\2\u010e\u010f\b(\4\2\u010fP\3\2\2\2\u0110\u0111\t\4\2\2\u0111"+
		"R\3\2\2\2\u0112\u0113\t\5\2\2\u0113T\3\2\2\2\u0114\u0115\7^\2\2\u0115"+
		"\u0116\t\6\2\2\u0116V\3\2\2\2\17\2\u00b8\u00be\u00c0\u00c5\u00ca\u00cc"+
		"\u00da\u00e9\u00eb\u00f4\u0102\u010c";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}