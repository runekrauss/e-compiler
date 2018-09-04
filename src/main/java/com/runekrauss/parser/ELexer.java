// Generated from E.g4 by ANTLR 4.7.1
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
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		TYPE=10, IDENTIFIER=11, INT=12, DIGIT=13, LETTER=14, WHITESPACE=15;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"TYPE", "IDENTIFIER", "INT", "DIGIT", "LETTER", "WHITESPACE"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'/'", "'*'", "'%'", "'-'", "'+'", "'say('", "')'", "'='", 
		"'int'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, "TYPE", "IDENTIFIER", 
		"INT", "DIGIT", "LETTER", "WHITESPACE"
	};
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\21R\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\3\3\3\3\4"+
		"\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13"+
		"\3\13\3\13\3\13\3\f\3\f\3\f\7\f>\n\f\f\f\16\fA\13\f\3\r\6\rD\n\r\r\r\16"+
		"\rE\3\16\3\16\3\17\3\17\3\20\6\20M\n\20\r\20\16\20N\3\20\3\20\2\2\21\3"+
		"\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37"+
		"\21\3\2\5\3\2\62;\5\2C\\aac|\5\2\13\f\17\17\"\"\2U\2\3\3\2\2\2\2\5\3\2"+
		"\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\3!\3\2\2\2\5#\3\2\2\2\7%\3\2\2\2\t\'\3"+
		"\2\2\2\13)\3\2\2\2\r+\3\2\2\2\17-\3\2\2\2\21\62\3\2\2\2\23\64\3\2\2\2"+
		"\25\66\3\2\2\2\27:\3\2\2\2\31C\3\2\2\2\33G\3\2\2\2\35I\3\2\2\2\37L\3\2"+
		"\2\2!\"\7=\2\2\"\4\3\2\2\2#$\7\61\2\2$\6\3\2\2\2%&\7,\2\2&\b\3\2\2\2\'"+
		"(\7\'\2\2(\n\3\2\2\2)*\7/\2\2*\f\3\2\2\2+,\7-\2\2,\16\3\2\2\2-.\7u\2\2"+
		"./\7c\2\2/\60\7{\2\2\60\61\7*\2\2\61\20\3\2\2\2\62\63\7+\2\2\63\22\3\2"+
		"\2\2\64\65\7?\2\2\65\24\3\2\2\2\66\67\7k\2\2\678\7p\2\289\7v\2\29\26\3"+
		"\2\2\2:?\5\35\17\2;>\5\35\17\2<>\5\33\16\2=;\3\2\2\2=<\3\2\2\2>A\3\2\2"+
		"\2?=\3\2\2\2?@\3\2\2\2@\30\3\2\2\2A?\3\2\2\2BD\5\33\16\2CB\3\2\2\2DE\3"+
		"\2\2\2EC\3\2\2\2EF\3\2\2\2F\32\3\2\2\2GH\t\2\2\2H\34\3\2\2\2IJ\t\3\2\2"+
		"J\36\3\2\2\2KM\t\4\2\2LK\3\2\2\2MN\3\2\2\2NL\3\2\2\2NO\3\2\2\2OP\3\2\2"+
		"\2PQ\b\20\2\2Q \3\2\2\2\7\2=?EN\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}