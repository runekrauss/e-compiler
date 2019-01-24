// Generated from E.g4 by ANTLR 4.7.2
package com.runekrauss.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ELexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, DATATYPE=31, 
		PRIMITIVE=32, BOOL=33, INTEGER=34, DOUBLE=35, STRING=36, IDENTIFIER=37, 
		BUILTINFUNCTION=38, COMMENT=39, WHITESPACE=40, SCOLON=41, DOT=42, COMMA=43, 
		ASSIGN=44, QMARK=45, OPAREN=46, CPAREN=47, OBRACE=48, CBRACE=49, OBRACKET=50, 
		CBRACKET=51;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
			"T__25", "T__26", "T__27", "T__28", "T__29", "DATATYPE", "PRIMITIVE", 
			"BOOL", "INTEGER", "DOUBLE", "STRING", "IDENTIFIER", "BUILTINFUNCTION", 
			"COMMENT", "WHITESPACE", "SCOLON", "DOT", "COMMA", "ASSIGN", "QMARK", 
			"OPAREN", "CPAREN", "OBRACE", "CBRACE", "OBRACKET", "CBRACKET", "LETTER", 
			"DIGIT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'include'", "'print'", "'println'", "'if'", "'else'", "'while'", 
			"'asm'", "'invoke'", "'new'", "'pushToStack'", "'setTopOfStack'", "':'", 
			"'return'", "'struct'", "'/'", "'*'", "'%'", "'-'", "'+'", "'<<'", "'>>'", 
			"'<'", "'<='", "'>'", "'>='", "'=='", "'!='", "'&&'", "'||'", "'^'", 
			null, null, null, null, null, null, null, null, null, null, "';'", "'.'", 
			"','", "'='", "'\"'", "'('", "')'", "'{'", "'}'", "'['", "']'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, "DATATYPE", "PRIMITIVE", "BOOL", 
			"INTEGER", "DOUBLE", "STRING", "IDENTIFIER", "BUILTINFUNCTION", "COMMENT", 
			"WHITESPACE", "SCOLON", "DOT", "COMMA", "ASSIGN", "QMARK", "OPAREN", 
			"CPAREN", "OBRACE", "CBRACE", "OBRACKET", "CBRACKET"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public ELexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "E.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\65\u01a9\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3"+
		"\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r"+
		"\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\25"+
		"\3\26\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\32\3\32\3\32\3\33"+
		"\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3 \3"+
		" \3 \5 \u00f6\n \3 \3 \3 \5 \u00fb\n \5 \u00fd\n \3!\3!\3!\3!\3!\3!\3"+
		"!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\5!\u0116\n!\3\"\3\""+
		"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u0121\n\"\3#\6#\u0124\n#\r#\16#\u0125"+
		"\3$\3$\3$\3$\3%\3%\7%\u012e\n%\f%\16%\u0131\13%\3%\3%\3&\3&\3&\7&\u0138"+
		"\n&\f&\16&\u013b\13&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3"+
		"\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'"+
		"\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u016b"+
		"\n\'\3(\3(\3(\3(\7(\u0171\n(\f(\16(\u0174\13(\3(\5(\u0177\n(\3(\3(\3("+
		"\3(\3(\7(\u017e\n(\f(\16(\u0181\13(\3(\3(\5(\u0185\n(\3(\3(\3)\6)\u018a"+
		"\n)\r)\16)\u018b\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3"+
		"\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66\4\u012f\u017f"+
		"\2\67\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"+
		";\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\2k\2\3"+
		"\2\6\4\2\f\f\17\17\5\2\13\f\17\17\"\"\5\2C\\aac|\3\2\62;\2\u01bd\2\3\3"+
		"\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2"+
		"\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3"+
		"\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2"+
		"%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61"+
		"\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2"+
		"\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I"+
		"\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2"+
		"\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2"+
		"\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\3m\3\2\2\2\5u\3\2\2\2\7{\3\2\2\2\t\u0083"+
		"\3\2\2\2\13\u0086\3\2\2\2\r\u008b\3\2\2\2\17\u0091\3\2\2\2\21\u0095\3"+
		"\2\2\2\23\u009c\3\2\2\2\25\u00a0\3\2\2\2\27\u00ac\3\2\2\2\31\u00ba\3\2"+
		"\2\2\33\u00bc\3\2\2\2\35\u00c3\3\2\2\2\37\u00ca\3\2\2\2!\u00cc\3\2\2\2"+
		"#\u00ce\3\2\2\2%\u00d0\3\2\2\2\'\u00d2\3\2\2\2)\u00d4\3\2\2\2+\u00d7\3"+
		"\2\2\2-\u00da\3\2\2\2/\u00dc\3\2\2\2\61\u00df\3\2\2\2\63\u00e1\3\2\2\2"+
		"\65\u00e4\3\2\2\2\67\u00e7\3\2\2\29\u00ea\3\2\2\2;\u00ed\3\2\2\2=\u00f0"+
		"\3\2\2\2?\u00fc\3\2\2\2A\u0115\3\2\2\2C\u0120\3\2\2\2E\u0123\3\2\2\2G"+
		"\u0127\3\2\2\2I\u012b\3\2\2\2K\u0134\3\2\2\2M\u016a\3\2\2\2O\u0184\3\2"+
		"\2\2Q\u0189\3\2\2\2S\u018f\3\2\2\2U\u0191\3\2\2\2W\u0193\3\2\2\2Y\u0195"+
		"\3\2\2\2[\u0197\3\2\2\2]\u0199\3\2\2\2_\u019b\3\2\2\2a\u019d\3\2\2\2c"+
		"\u019f\3\2\2\2e\u01a1\3\2\2\2g\u01a3\3\2\2\2i\u01a5\3\2\2\2k\u01a7\3\2"+
		"\2\2mn\7k\2\2no\7p\2\2op\7e\2\2pq\7n\2\2qr\7w\2\2rs\7f\2\2st\7g\2\2t\4"+
		"\3\2\2\2uv\7r\2\2vw\7t\2\2wx\7k\2\2xy\7p\2\2yz\7v\2\2z\6\3\2\2\2{|\7r"+
		"\2\2|}\7t\2\2}~\7k\2\2~\177\7p\2\2\177\u0080\7v\2\2\u0080\u0081\7n\2\2"+
		"\u0081\u0082\7p\2\2\u0082\b\3\2\2\2\u0083\u0084\7k\2\2\u0084\u0085\7h"+
		"\2\2\u0085\n\3\2\2\2\u0086\u0087\7g\2\2\u0087\u0088\7n\2\2\u0088\u0089"+
		"\7u\2\2\u0089\u008a\7g\2\2\u008a\f\3\2\2\2\u008b\u008c\7y\2\2\u008c\u008d"+
		"\7j\2\2\u008d\u008e\7k\2\2\u008e\u008f\7n\2\2\u008f\u0090\7g\2\2\u0090"+
		"\16\3\2\2\2\u0091\u0092\7c\2\2\u0092\u0093\7u\2\2\u0093\u0094\7o\2\2\u0094"+
		"\20\3\2\2\2\u0095\u0096\7k\2\2\u0096\u0097\7p\2\2\u0097\u0098\7x\2\2\u0098"+
		"\u0099\7q\2\2\u0099\u009a\7m\2\2\u009a\u009b\7g\2\2\u009b\22\3\2\2\2\u009c"+
		"\u009d\7p\2\2\u009d\u009e\7g\2\2\u009e\u009f\7y\2\2\u009f\24\3\2\2\2\u00a0"+
		"\u00a1\7r\2\2\u00a1\u00a2\7w\2\2\u00a2\u00a3\7u\2\2\u00a3\u00a4\7j\2\2"+
		"\u00a4\u00a5\7V\2\2\u00a5\u00a6\7q\2\2\u00a6\u00a7\7U\2\2\u00a7\u00a8"+
		"\7v\2\2\u00a8\u00a9\7c\2\2\u00a9\u00aa\7e\2\2\u00aa\u00ab\7m\2\2\u00ab"+
		"\26\3\2\2\2\u00ac\u00ad\7u\2\2\u00ad\u00ae\7g\2\2\u00ae\u00af\7v\2\2\u00af"+
		"\u00b0\7V\2\2\u00b0\u00b1\7q\2\2\u00b1\u00b2\7r\2\2\u00b2\u00b3\7Q\2\2"+
		"\u00b3\u00b4\7h\2\2\u00b4\u00b5\7U\2\2\u00b5\u00b6\7v\2\2\u00b6\u00b7"+
		"\7c\2\2\u00b7\u00b8\7e\2\2\u00b8\u00b9\7m\2\2\u00b9\30\3\2\2\2\u00ba\u00bb"+
		"\7<\2\2\u00bb\32\3\2\2\2\u00bc\u00bd\7t\2\2\u00bd\u00be\7g\2\2\u00be\u00bf"+
		"\7v\2\2\u00bf\u00c0\7w\2\2\u00c0\u00c1\7t\2\2\u00c1\u00c2\7p\2\2\u00c2"+
		"\34\3\2\2\2\u00c3\u00c4\7u\2\2\u00c4\u00c5\7v\2\2\u00c5\u00c6\7t\2\2\u00c6"+
		"\u00c7\7w\2\2\u00c7\u00c8\7e\2\2\u00c8\u00c9\7v\2\2\u00c9\36\3\2\2\2\u00ca"+
		"\u00cb\7\61\2\2\u00cb \3\2\2\2\u00cc\u00cd\7,\2\2\u00cd\"\3\2\2\2\u00ce"+
		"\u00cf\7\'\2\2\u00cf$\3\2\2\2\u00d0\u00d1\7/\2\2\u00d1&\3\2\2\2\u00d2"+
		"\u00d3\7-\2\2\u00d3(\3\2\2\2\u00d4\u00d5\7>\2\2\u00d5\u00d6\7>\2\2\u00d6"+
		"*\3\2\2\2\u00d7\u00d8\7@\2\2\u00d8\u00d9\7@\2\2\u00d9,\3\2\2\2\u00da\u00db"+
		"\7>\2\2\u00db.\3\2\2\2\u00dc\u00dd\7>\2\2\u00dd\u00de\7?\2\2\u00de\60"+
		"\3\2\2\2\u00df\u00e0\7@\2\2\u00e0\62\3\2\2\2\u00e1\u00e2\7@\2\2\u00e2"+
		"\u00e3\7?\2\2\u00e3\64\3\2\2\2\u00e4\u00e5\7?\2\2\u00e5\u00e6\7?\2\2\u00e6"+
		"\66\3\2\2\2\u00e7\u00e8\7#\2\2\u00e8\u00e9\7?\2\2\u00e98\3\2\2\2\u00ea"+
		"\u00eb\7(\2\2\u00eb\u00ec\7(\2\2\u00ec:\3\2\2\2\u00ed\u00ee\7~\2\2\u00ee"+
		"\u00ef\7~\2\2\u00ef<\3\2\2\2\u00f0\u00f1\7`\2\2\u00f1>\3\2\2\2\u00f2\u00f5"+
		"\5A!\2\u00f3\u00f4\7]\2\2\u00f4\u00f6\7_\2\2\u00f5\u00f3\3\2\2\2\u00f5"+
		"\u00f6\3\2\2\2\u00f6\u00fd\3\2\2\2\u00f7\u00fa\5K&\2\u00f8\u00f9\7]\2"+
		"\2\u00f9\u00fb\7_\2\2\u00fa\u00f8\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fd"+
		"\3\2\2\2\u00fc\u00f2\3\2\2\2\u00fc\u00f7\3\2\2\2\u00fd@\3\2\2\2\u00fe"+
		"\u00ff\7d\2\2\u00ff\u0100\7q\2\2\u0100\u0101\7q\2\2\u0101\u0116\7n\2\2"+
		"\u0102\u0103\7k\2\2\u0103\u0104\7p\2\2\u0104\u0116\7v\2\2\u0105\u0106"+
		"\7f\2\2\u0106\u0107\7q\2\2\u0107\u0108\7w\2\2\u0108\u0109\7d\2\2\u0109"+
		"\u010a\7n\2\2\u010a\u0116\7g\2\2\u010b\u010c\7U\2\2\u010c\u010d\7v\2\2"+
		"\u010d\u010e\7t\2\2\u010e\u010f\7k\2\2\u010f\u0110\7p\2\2\u0110\u0116"+
		"\7i\2\2\u0111\u0112\7x\2\2\u0112\u0113\7q\2\2\u0113\u0114\7k\2\2\u0114"+
		"\u0116\7f\2\2\u0115\u00fe\3\2\2\2\u0115\u0102\3\2\2\2\u0115\u0105\3\2"+
		"\2\2\u0115\u010b\3\2\2\2\u0115\u0111\3\2\2\2\u0116B\3\2\2\2\u0117\u0118"+
		"\7v\2\2\u0118\u0119\7t\2\2\u0119\u011a\7w\2\2\u011a\u0121\7g\2\2\u011b"+
		"\u011c\7h\2\2\u011c\u011d\7c\2\2\u011d\u011e\7n\2\2\u011e\u011f\7u\2\2"+
		"\u011f\u0121\7g\2\2\u0120\u0117\3\2\2\2\u0120\u011b\3\2\2\2\u0121D\3\2"+
		"\2\2\u0122\u0124\5k\66\2\u0123\u0122\3\2\2\2\u0124\u0125\3\2\2\2\u0125"+
		"\u0123\3\2\2\2\u0125\u0126\3\2\2\2\u0126F\3\2\2\2\u0127\u0128\5E#\2\u0128"+
		"\u0129\5U+\2\u0129\u012a\5E#\2\u012aH\3\2\2\2\u012b\u012f\5[.\2\u012c"+
		"\u012e\13\2\2\2\u012d\u012c\3\2\2\2\u012e\u0131\3\2\2\2\u012f\u0130\3"+
		"\2\2\2\u012f\u012d\3\2\2\2\u0130\u0132\3\2\2\2\u0131\u012f\3\2\2\2\u0132"+
		"\u0133\5[.\2\u0133J\3\2\2\2\u0134\u0139\5i\65\2\u0135\u0138\5i\65\2\u0136"+
		"\u0138\5k\66\2\u0137\u0135\3\2\2\2\u0137\u0136\3\2\2\2\u0138\u013b\3\2"+
		"\2\2\u0139\u0137\3\2\2\2\u0139\u013a\3\2\2\2\u013aL\3\2\2\2\u013b\u0139"+
		"\3\2\2\2\u013c\u013d\7n\2\2\u013d\u013e\7g\2\2\u013e\u013f\7p\2\2\u013f"+
		"\u0140\7i\2\2\u0140\u0141\7v\2\2\u0141\u016b\7j\2\2\u0142\u0143\7c\2\2"+
		"\u0143\u0144\7r\2\2\u0144\u0145\7r\2\2\u0145\u0146\7g\2\2\u0146\u0147"+
		"\7p\2\2\u0147\u016b\7f\2\2\u0148\u0149\7v\2\2\u0149\u014a\7q\2\2\u014a"+
		"\u014b\7K\2\2\u014b\u014c\7p\2\2\u014c\u016b\7v\2\2\u014d\u014e\7v\2\2"+
		"\u014e\u014f\7q\2\2\u014f\u0150\7N\2\2\u0150\u0151\7q\2\2\u0151\u0152"+
		"\7p\2\2\u0152\u016b\7i\2\2\u0153\u0154\7v\2\2\u0154\u0155\7q\2\2\u0155"+
		"\u0156\7H\2\2\u0156\u0157\7n\2\2\u0157\u0158\7q\2\2\u0158\u0159\7c\2\2"+
		"\u0159\u016b\7v\2\2\u015a\u015b\7v\2\2\u015b\u015c\7q\2\2\u015c\u015d"+
		"\7F\2\2\u015d\u015e\7q\2\2\u015e\u015f\7w\2\2\u015f\u0160\7d\2\2\u0160"+
		"\u0161\7n\2\2\u0161\u016b\7g\2\2\u0162\u0163\7v\2\2\u0163\u0164\7q\2\2"+
		"\u0164\u0165\7U\2\2\u0165\u0166\7v\2\2\u0166\u0167\7t\2\2\u0167\u0168"+
		"\7k\2\2\u0168\u0169\7p\2\2\u0169\u016b\7i\2\2\u016a\u013c\3\2\2\2\u016a"+
		"\u0142\3\2\2\2\u016a\u0148\3\2\2\2\u016a\u014d\3\2\2\2\u016a\u0153\3\2"+
		"\2\2\u016a\u015a\3\2\2\2\u016a\u0162\3\2\2\2\u016bN\3\2\2\2\u016c\u016d"+
		"\7\61\2\2\u016d\u016e\7\61\2\2\u016e\u0172\3\2\2\2\u016f\u0171\n\2\2\2"+
		"\u0170\u016f\3\2\2\2\u0171\u0174\3\2\2\2\u0172\u0170\3\2\2\2\u0172\u0173"+
		"\3\2\2\2\u0173\u0176\3\2\2\2\u0174\u0172\3\2\2\2\u0175\u0177\7\17\2\2"+
		"\u0176\u0175\3\2\2\2\u0176\u0177\3\2\2\2\u0177\u0178\3\2\2\2\u0178\u0185"+
		"\7\f\2\2\u0179\u017a\7\61\2\2\u017a\u017b\7,\2\2\u017b\u017f\3\2\2\2\u017c"+
		"\u017e\13\2\2\2\u017d\u017c\3\2\2\2\u017e\u0181\3\2\2\2\u017f\u0180\3"+
		"\2\2\2\u017f\u017d\3\2\2\2\u0180\u0182\3\2\2\2\u0181\u017f\3\2\2\2\u0182"+
		"\u0183\7,\2\2\u0183\u0185\7\61\2\2\u0184\u016c\3\2\2\2\u0184\u0179\3\2"+
		"\2\2\u0185\u0186\3\2\2\2\u0186\u0187\b(\2\2\u0187P\3\2\2\2\u0188\u018a"+
		"\t\3\2\2\u0189\u0188\3\2\2\2\u018a\u018b\3\2\2\2\u018b\u0189\3\2\2\2\u018b"+
		"\u018c\3\2\2\2\u018c\u018d\3\2\2\2\u018d\u018e\b)\2\2\u018eR\3\2\2\2\u018f"+
		"\u0190\7=\2\2\u0190T\3\2\2\2\u0191\u0192\7\60\2\2\u0192V\3\2\2\2\u0193"+
		"\u0194\7.\2\2\u0194X\3\2\2\2\u0195\u0196\7?\2\2\u0196Z\3\2\2\2\u0197\u0198"+
		"\7$\2\2\u0198\\\3\2\2\2\u0199\u019a\7*\2\2\u019a^\3\2\2\2\u019b\u019c"+
		"\7+\2\2\u019c`\3\2\2\2\u019d\u019e\7}\2\2\u019eb\3\2\2\2\u019f\u01a0\7"+
		"\177\2\2\u01a0d\3\2\2\2\u01a1\u01a2\7]\2\2\u01a2f\3\2\2\2\u01a3\u01a4"+
		"\7_\2\2\u01a4h\3\2\2\2\u01a5\u01a6\t\4\2\2\u01a6j\3\2\2\2\u01a7\u01a8"+
		"\t\5\2\2\u01a8l\3\2\2\2\22\2\u00f5\u00fa\u00fc\u0115\u0120\u0125\u012f"+
		"\u0137\u0139\u016a\u0172\u0176\u017f\u0184\u018b\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}