// Generated from E.g4 by ANTLR 4.7.2
package com.runekrauss.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class EParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		BOOL=39, INTEGER=40, FLOAT=41, STRING=42, IDENTIFIER=43, BUILTINFUNCTION=44, 
		COMMENT=45, WHITESPACE=46, SCOLON=47, DOT=48, COMMA=49, ASSIGN=50, QMARK=51, 
		OPAREN=52, CPAREN=53, OBRACE=54, CBRACE=55, OBRACKET=56, CBRACKET=57, 
		OCBRACKET=58;
	public static final int
		RULE_program = 0, RULE_includes = 1, RULE_module = 2, RULE_noMain = 3, 
		RULE_command = 4, RULE_statement = 5, RULE_print = 6, RULE_printLine = 7, 
		RULE_variableDeclaration = 8, RULE_assignment = 9, RULE_structVariableAssignment = 10, 
		RULE_functionCall = 11, RULE_branch = 12, RULE_loop = 13, RULE_assembly = 14, 
		RULE_includedFunctionCall = 15, RULE_builtinFunctionCall = 16, RULE_functionDefinition = 17, 
		RULE_structDeclaration = 18, RULE_structInitialization = 19, RULE_assignments = 20, 
		RULE_expression = 21, RULE_currentParameters = 22, RULE_block = 23, RULE_statements = 24, 
		RULE_formalParameters = 25, RULE_dataType = 26, RULE_primitive = 27;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "includes", "module", "noMain", "command", "statement", "print", 
			"printLine", "variableDeclaration", "assignment", "structVariableAssignment", 
			"functionCall", "branch", "loop", "assembly", "includedFunctionCall", 
			"builtinFunctionCall", "functionDefinition", "structDeclaration", "structInitialization", 
			"assignments", "expression", "currentParameters", "block", "statements", 
			"formalParameters", "dataType", "primitive"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'use'", "'#define'", "'noMain'", "'print'", "'println'", "'if'", 
			"'else'", "'while'", "'asm'", "'invoke'", "'new'", "'pushToStack'", "'setTopOfStack'", 
			"':'", "'return'", "'struct'", "'!'", "'/'", "'*'", "'%'", "'-'", "'+'", 
			"'<<'", "'>>'", "'<'", "'<='", "'>'", "'>='", "'=='", "'!='", "'&&'", 
			"'||'", "'^'", "'bool'", "'int'", "'float'", "'String'", "'void'", null, 
			null, null, null, null, null, null, null, "';'", "'.'", "','", "'='", 
			"'\"'", "'('", "')'", "'{'", "'}'", "'['", "']'", "'[]'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "BOOL", "INTEGER", "FLOAT", "STRING", "IDENTIFIER", 
			"BUILTINFUNCTION", "COMMENT", "WHITESPACE", "SCOLON", "DOT", "COMMA", 
			"ASSIGN", "QMARK", "OPAREN", "CPAREN", "OBRACE", "CBRACE", "OBRACKET", 
			"CBRACKET", "OCBRACKET"
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

	@Override
	public String getGrammarFileName() { return "E.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public EParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public IncludesContext includes;
		public List<IncludesContext> incls = new ArrayList<IncludesContext>();
		public NoMainContext noMain;
		public List<NoMainContext> noMains = new ArrayList<NoMainContext>();
		public TerminalNode EOF() { return getToken(EParser.EOF, 0); }
		public List<CommandContext> command() {
			return getRuleContexts(CommandContext.class);
		}
		public CommandContext command(int i) {
			return getRuleContext(CommandContext.class,i);
		}
		public List<IncludesContext> includes() {
			return getRuleContexts(IncludesContext.class);
		}
		public IncludesContext includes(int i) {
			return getRuleContext(IncludesContext.class,i);
		}
		public List<NoMainContext> noMain() {
			return getRuleContexts(NoMainContext.class);
		}
		public NoMainContext noMain(int i) {
			return getRuleContext(NoMainContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EVisitor ) return ((EVisitor<? extends T>)visitor).visitProgram(this);
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
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(56);
				((ProgramContext)_localctx).includes = includes();
				((ProgramContext)_localctx).incls.add(((ProgramContext)_localctx).includes);
				}
				}
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(62);
				((ProgramContext)_localctx).noMain = noMain();
				((ProgramContext)_localctx).noMains.add(((ProgramContext)_localctx).noMain);
				}
				}
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(69); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(68);
				command();
				}
				}
				setState(71); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__15) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << IDENTIFIER) | (1L << BUILTINFUNCTION))) != 0) );
			setState(73);
			match(EOF);
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

	public static class IncludesContext extends ParserRuleContext {
		public ModuleContext module;
		public List<ModuleContext> mods = new ArrayList<ModuleContext>();
		public TerminalNode OPAREN() { return getToken(EParser.OPAREN, 0); }
		public TerminalNode CPAREN() { return getToken(EParser.CPAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(EParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(EParser.COMMA, i);
		}
		public List<ModuleContext> module() {
			return getRuleContexts(ModuleContext.class);
		}
		public ModuleContext module(int i) {
			return getRuleContext(ModuleContext.class,i);
		}
		public IncludesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_includes; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EVisitor ) return ((EVisitor<? extends T>)visitor).visitIncludes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IncludesContext includes() throws RecognitionException {
		IncludesContext _localctx = new IncludesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_includes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			match(T__0);
			setState(76);
			match(OPAREN);
			setState(78); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(77);
				((IncludesContext)_localctx).module = module();
				((IncludesContext)_localctx).mods.add(((IncludesContext)_localctx).module);
				}
				}
				setState(80); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IDENTIFIER );
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(82);
				match(COMMA);
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==IDENTIFIER) {
					{
					{
					setState(83);
					((IncludesContext)_localctx).module = module();
					((IncludesContext)_localctx).mods.add(((IncludesContext)_localctx).module);
					}
					}
					setState(88);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(94);
			match(CPAREN);
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

	public static class ModuleContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(EParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(EParser.IDENTIFIER, i);
		}
		public List<TerminalNode> DOT() { return getTokens(EParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(EParser.DOT, i);
		}
		public ModuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_module; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EVisitor ) return ((EVisitor<? extends T>)visitor).visitModule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModuleContext module() throws RecognitionException {
		ModuleContext _localctx = new ModuleContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_module);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(IDENTIFIER);
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(97);
				match(DOT);
				setState(98);
				match(IDENTIFIER);
				}
				}
				setState(103);
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

	public static class NoMainContext extends ParserRuleContext {
		public Token name;
		public NoMainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_noMain; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EVisitor ) return ((EVisitor<? extends T>)visitor).visitNoMain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NoMainContext noMain() throws RecognitionException {
		NoMainContext _localctx = new NoMainContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_noMain);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			match(T__1);
			setState(105);
			((NoMainContext)_localctx).name = match(T__2);
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

	public static class CommandContext extends ParserRuleContext {
		public CommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_command; }
	 
		public CommandContext() { }
		public void copyFrom(CommandContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StructDeclarationCommandContext extends CommandContext {
		public StructDeclarationContext structDeclaration() {
			return getRuleContext(StructDeclarationContext.class,0);
		}
		public StructDeclarationCommandContext(CommandContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EVisitor ) return ((EVisitor<? extends T>)visitor).visitStructDeclarationCommand(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatementCommandContext extends CommandContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public StatementCommandContext(CommandContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EVisitor ) return ((EVisitor<? extends T>)visitor).visitStatementCommand(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunctionDefinitionCommandContext extends CommandContext {
		public FunctionDefinitionContext functionDefinition() {
			return getRuleContext(FunctionDefinitionContext.class,0);
		}
		public FunctionDefinitionCommandContext(CommandContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EVisitor ) return ((EVisitor<? extends T>)visitor).visitFunctionDefinitionCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommandContext command() throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_command);
		try {
			setState(110);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new StatementCommandContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(107);
				statement();
				}
				break;
			case 2:
				_localctx = new FunctionDefinitionCommandContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(108);
				functionDefinition();
				}
				break;
			case 3:
				_localctx = new StructDeclarationCommandContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(109);
				structDeclaration();
				}
				break;
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

	public static class StatementContext extends ParserRuleContext {
		public PrintContext print() {
			return getRuleContext(PrintContext.class,0);
		}
		public TerminalNode SCOLON() { return getToken(EParser.SCOLON, 0); }
		public PrintLineContext printLine() {
			return getRuleContext(PrintLineContext.class,0);
		}
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public BranchContext branch() {
			return getRuleContext(BranchContext.class,0);
		}
		public LoopContext loop() {
			return getRuleContext(LoopContext.class,0);
		}
		public IncludedFunctionCallContext includedFunctionCall() {
			return getRuleContext(IncludedFunctionCallContext.class,0);
		}
		public BuiltinFunctionCallContext builtinFunctionCall() {
			return getRuleContext(BuiltinFunctionCallContext.class,0);
		}
		public AssemblyContext assembly() {
			return getRuleContext(AssemblyContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EVisitor ) return ((EVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_statement);
		try {
			setState(136);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(112);
				print();
				setState(113);
				match(SCOLON);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(115);
				printLine();
				setState(116);
				match(SCOLON);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(118);
				variableDeclaration();
				setState(119);
				match(SCOLON);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(121);
				assignment();
				setState(122);
				match(SCOLON);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(124);
				functionCall();
				setState(125);
				match(SCOLON);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(127);
				branch();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(128);
				loop();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(129);
				includedFunctionCall();
				setState(130);
				match(SCOLON);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(132);
				builtinFunctionCall();
				setState(133);
				match(SCOLON);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(135);
				assembly();
				}
				break;
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

	public static class PrintContext extends ParserRuleContext {
		public ExpressionContext arg;
		public TerminalNode OPAREN() { return getToken(EParser.OPAREN, 0); }
		public TerminalNode CPAREN() { return getToken(EParser.CPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EVisitor ) return ((EVisitor<? extends T>)visitor).visitPrint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintContext print() throws RecognitionException {
		PrintContext _localctx = new PrintContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_print);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(T__3);
			setState(139);
			match(OPAREN);
			setState(140);
			((PrintContext)_localctx).arg = expression(0);
			setState(141);
			match(CPAREN);
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

	public static class PrintLineContext extends ParserRuleContext {
		public ExpressionContext arg;
		public TerminalNode OPAREN() { return getToken(EParser.OPAREN, 0); }
		public TerminalNode CPAREN() { return getToken(EParser.CPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PrintLineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printLine; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EVisitor ) return ((EVisitor<? extends T>)visitor).visitPrintLine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintLineContext printLine() throws RecognitionException {
		PrintLineContext _localctx = new PrintLineContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_printLine);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			match(T__4);
			setState(144);
			match(OPAREN);
			setState(145);
			((PrintLineContext)_localctx).arg = expression(0);
			setState(146);
			match(CPAREN);
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

	public static class VariableDeclarationContext extends ParserRuleContext {
		public DataTypeContext type;
		public Token varId;
		public ExpressionContext expr;
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(EParser.IDENTIFIER, 0); }
		public TerminalNode ASSIGN() { return getToken(EParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EVisitor ) return ((EVisitor<? extends T>)visitor).visitVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclarationContext variableDeclaration() throws RecognitionException {
		VariableDeclarationContext _localctx = new VariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_variableDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			((VariableDeclarationContext)_localctx).type = dataType();
			setState(149);
			((VariableDeclarationContext)_localctx).varId = match(IDENTIFIER);
			setState(152);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(150);
				match(ASSIGN);
				setState(151);
				((VariableDeclarationContext)_localctx).expr = expression(0);
				}
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

	public static class AssignmentContext extends ParserRuleContext {
		public Token varId;
		public ExpressionContext expr;
		public ExpressionContext index;
		public TerminalNode ASSIGN() { return getToken(EParser.ASSIGN, 0); }
		public TerminalNode IDENTIFIER() { return getToken(EParser.IDENTIFIER, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode OBRACKET() { return getToken(EParser.OBRACKET, 0); }
		public TerminalNode CBRACKET() { return getToken(EParser.CBRACKET, 0); }
		public StructVariableAssignmentContext structVariableAssignment() {
			return getRuleContext(StructVariableAssignmentContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EVisitor ) return ((EVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_assignment);
		try {
			setState(165);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(154);
				((AssignmentContext)_localctx).varId = match(IDENTIFIER);
				setState(155);
				match(ASSIGN);
				setState(156);
				((AssignmentContext)_localctx).expr = expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(157);
				((AssignmentContext)_localctx).varId = match(IDENTIFIER);
				setState(158);
				match(OBRACKET);
				setState(159);
				((AssignmentContext)_localctx).index = expression(0);
				setState(160);
				match(CBRACKET);
				setState(161);
				match(ASSIGN);
				setState(162);
				((AssignmentContext)_localctx).expr = expression(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(164);
				structVariableAssignment();
				}
				break;
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

	public static class StructVariableAssignmentContext extends ParserRuleContext {
		public Token structId;
		public Token varId;
		public ExpressionContext expr;
		public ExpressionContext index;
		public TerminalNode DOT() { return getToken(EParser.DOT, 0); }
		public TerminalNode ASSIGN() { return getToken(EParser.ASSIGN, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(EParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(EParser.IDENTIFIER, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode OBRACKET() { return getToken(EParser.OBRACKET, 0); }
		public TerminalNode CBRACKET() { return getToken(EParser.CBRACKET, 0); }
		public StructVariableAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structVariableAssignment; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EVisitor ) return ((EVisitor<? extends T>)visitor).visitStructVariableAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructVariableAssignmentContext structVariableAssignment() throws RecognitionException {
		StructVariableAssignmentContext _localctx = new StructVariableAssignmentContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_structVariableAssignment);
		try {
			setState(181);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(167);
				((StructVariableAssignmentContext)_localctx).structId = match(IDENTIFIER);
				setState(168);
				match(DOT);
				setState(169);
				((StructVariableAssignmentContext)_localctx).varId = match(IDENTIFIER);
				setState(170);
				match(ASSIGN);
				setState(171);
				((StructVariableAssignmentContext)_localctx).expr = expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(172);
				((StructVariableAssignmentContext)_localctx).structId = match(IDENTIFIER);
				setState(173);
				match(DOT);
				setState(174);
				((StructVariableAssignmentContext)_localctx).varId = match(IDENTIFIER);
				setState(175);
				match(OBRACKET);
				setState(176);
				((StructVariableAssignmentContext)_localctx).index = expression(0);
				setState(177);
				match(CBRACKET);
				setState(178);
				match(ASSIGN);
				setState(179);
				((StructVariableAssignmentContext)_localctx).expr = expression(0);
				}
				break;
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
		public Token funcId;
		public CurrentParametersContext currentParams;
		public TerminalNode OPAREN() { return getToken(EParser.OPAREN, 0); }
		public TerminalNode CPAREN() { return getToken(EParser.CPAREN, 0); }
		public TerminalNode IDENTIFIER() { return getToken(EParser.IDENTIFIER, 0); }
		public CurrentParametersContext currentParameters() {
			return getRuleContext(CurrentParametersContext.class,0);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EVisitor ) return ((EVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_functionCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			((FunctionCallContext)_localctx).funcId = match(IDENTIFIER);
			setState(184);
			match(OPAREN);
			setState(185);
			((FunctionCallContext)_localctx).currentParams = currentParameters();
			setState(186);
			match(CPAREN);
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

	public static class BranchContext extends ParserRuleContext {
		public ExpressionContext cond;
		public BlockContext onTrue;
		public BlockContext onFalse;
		public TerminalNode OPAREN() { return getToken(EParser.OPAREN, 0); }
		public TerminalNode CPAREN() { return getToken(EParser.CPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public BranchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_branch; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EVisitor ) return ((EVisitor<? extends T>)visitor).visitBranch(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BranchContext branch() throws RecognitionException {
		BranchContext _localctx = new BranchContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_branch);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			match(T__5);
			setState(189);
			match(OPAREN);
			setState(190);
			((BranchContext)_localctx).cond = expression(0);
			setState(191);
			match(CPAREN);
			setState(192);
			((BranchContext)_localctx).onTrue = block();
			setState(195);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(193);
				match(T__6);
				setState(194);
				((BranchContext)_localctx).onFalse = block();
				}
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

	public static class LoopContext extends ParserRuleContext {
		public ExpressionContext cond;
		public BlockContext body;
		public TerminalNode OPAREN() { return getToken(EParser.OPAREN, 0); }
		public TerminalNode CPAREN() { return getToken(EParser.CPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public LoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EVisitor ) return ((EVisitor<? extends T>)visitor).visitLoop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopContext loop() throws RecognitionException {
		LoopContext _localctx = new LoopContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_loop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			match(T__7);
			setState(198);
			match(OPAREN);
			setState(199);
			((LoopContext)_localctx).cond = expression(0);
			setState(200);
			match(CPAREN);
			setState(201);
			((LoopContext)_localctx).body = block();
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

	public static class AssemblyContext extends ParserRuleContext {
		public AssemblyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assembly; }
	 
		public AssemblyContext() { }
		public void copyFrom(AssemblyContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class InitObjectContext extends AssemblyContext {
		public Token type;
		public TerminalNode STRING() { return getToken(EParser.STRING, 0); }
		public InitObjectContext(AssemblyContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EVisitor ) return ((EVisitor<? extends T>)visitor).visitInitObject(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SetTopOfStackContext extends AssemblyContext {
		public Token type;
		public TerminalNode STRING() { return getToken(EParser.STRING, 0); }
		public SetTopOfStackContext(AssemblyContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EVisitor ) return ((EVisitor<? extends T>)visitor).visitSetTopOfStack(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InlineAssemblyContext extends AssemblyContext {
		public Token str;
		public TerminalNode OBRACE() { return getToken(EParser.OBRACE, 0); }
		public TerminalNode CBRACE() { return getToken(EParser.CBRACE, 0); }
		public TerminalNode STRING() { return getToken(EParser.STRING, 0); }
		public InlineAssemblyContext(AssemblyContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EVisitor ) return ((EVisitor<? extends T>)visitor).visitInlineAssembly(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PushToStackContext extends AssemblyContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PushToStackContext(AssemblyContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EVisitor ) return ((EVisitor<? extends T>)visitor).visitPushToStack(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InvokeAssemblyContext extends AssemblyContext {
		public Token mod;
		public Token id;
		public Token STRING;
		public List<Token> args = new ArrayList<Token>();
		public TerminalNode OPAREN() { return getToken(EParser.OPAREN, 0); }
		public TerminalNode CPAREN() { return getToken(EParser.CPAREN, 0); }
		public List<TerminalNode> STRING() { return getTokens(EParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(EParser.STRING, i);
		}
		public InvokeAssemblyContext(AssemblyContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EVisitor ) return ((EVisitor<? extends T>)visitor).visitInvokeAssembly(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssemblyContext assembly() throws RecognitionException {
		AssemblyContext _localctx = new AssemblyContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_assembly);
		int _la;
		try {
			setState(224);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__8:
				_localctx = new InlineAssemblyContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(203);
				match(T__8);
				setState(204);
				match(OBRACE);
				setState(205);
				((InlineAssemblyContext)_localctx).str = match(STRING);
				setState(206);
				match(CBRACE);
				}
				break;
			case T__9:
				_localctx = new InvokeAssemblyContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(207);
				match(T__9);
				setState(208);
				((InvokeAssemblyContext)_localctx).mod = match(STRING);
				setState(209);
				((InvokeAssemblyContext)_localctx).id = match(STRING);
				setState(210);
				match(OPAREN);
				setState(214);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==STRING) {
					{
					{
					setState(211);
					((InvokeAssemblyContext)_localctx).STRING = match(STRING);
					((InvokeAssemblyContext)_localctx).args.add(((InvokeAssemblyContext)_localctx).STRING);
					}
					}
					setState(216);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(217);
				match(CPAREN);
				}
				break;
			case T__10:
				_localctx = new InitObjectContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(218);
				match(T__10);
				setState(219);
				((InitObjectContext)_localctx).type = match(STRING);
				}
				break;
			case T__11:
				_localctx = new PushToStackContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(220);
				match(T__11);
				setState(221);
				expression(0);
				}
				break;
			case T__12:
				_localctx = new SetTopOfStackContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(222);
				match(T__12);
				setState(223);
				((SetTopOfStackContext)_localctx).type = match(STRING);
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

	public static class IncludedFunctionCallContext extends ParserRuleContext {
		public Token inclDir;
		public Token funcId;
		public CurrentParametersContext args;
		public DataTypeContext type;
		public TerminalNode DOT() { return getToken(EParser.DOT, 0); }
		public TerminalNode OPAREN() { return getToken(EParser.OPAREN, 0); }
		public TerminalNode CPAREN() { return getToken(EParser.CPAREN, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(EParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(EParser.IDENTIFIER, i);
		}
		public CurrentParametersContext currentParameters() {
			return getRuleContext(CurrentParametersContext.class,0);
		}
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public IncludedFunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_includedFunctionCall; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EVisitor ) return ((EVisitor<? extends T>)visitor).visitIncludedFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IncludedFunctionCallContext includedFunctionCall() throws RecognitionException {
		IncludedFunctionCallContext _localctx = new IncludedFunctionCallContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_includedFunctionCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			((IncludedFunctionCallContext)_localctx).inclDir = match(IDENTIFIER);
			setState(227);
			match(DOT);
			setState(228);
			((IncludedFunctionCallContext)_localctx).funcId = match(IDENTIFIER);
			setState(229);
			match(OPAREN);
			setState(230);
			((IncludedFunctionCallContext)_localctx).args = currentParameters();
			setState(231);
			match(CPAREN);
			setState(232);
			match(T__13);
			setState(233);
			((IncludedFunctionCallContext)_localctx).type = dataType();
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

	public static class BuiltinFunctionCallContext extends ParserRuleContext {
		public Token funcId;
		public CurrentParametersContext args;
		public TerminalNode OPAREN() { return getToken(EParser.OPAREN, 0); }
		public TerminalNode CPAREN() { return getToken(EParser.CPAREN, 0); }
		public TerminalNode BUILTINFUNCTION() { return getToken(EParser.BUILTINFUNCTION, 0); }
		public CurrentParametersContext currentParameters() {
			return getRuleContext(CurrentParametersContext.class,0);
		}
		public BuiltinFunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_builtinFunctionCall; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EVisitor ) return ((EVisitor<? extends T>)visitor).visitBuiltinFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BuiltinFunctionCallContext builtinFunctionCall() throws RecognitionException {
		BuiltinFunctionCallContext _localctx = new BuiltinFunctionCallContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_builtinFunctionCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
			((BuiltinFunctionCallContext)_localctx).funcId = match(BUILTINFUNCTION);
			setState(236);
			match(OPAREN);
			setState(237);
			((BuiltinFunctionCallContext)_localctx).args = currentParameters();
			setState(238);
			match(CPAREN);
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

	public static class FunctionDefinitionContext extends ParserRuleContext {
		public DataTypeContext type;
		public Token funcId;
		public FormalParametersContext formalParams;
		public StatementsContext stmts;
		public ExpressionContext returnVal;
		public TerminalNode OPAREN() { return getToken(EParser.OPAREN, 0); }
		public TerminalNode CPAREN() { return getToken(EParser.CPAREN, 0); }
		public TerminalNode OBRACE() { return getToken(EParser.OBRACE, 0); }
		public TerminalNode CBRACE() { return getToken(EParser.CBRACE, 0); }
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(EParser.IDENTIFIER, 0); }
		public FormalParametersContext formalParameters() {
			return getRuleContext(FormalParametersContext.class,0);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public TerminalNode SCOLON() { return getToken(EParser.SCOLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FunctionDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EVisitor ) return ((EVisitor<? extends T>)visitor).visitFunctionDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDefinitionContext functionDefinition() throws RecognitionException {
		FunctionDefinitionContext _localctx = new FunctionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_functionDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			((FunctionDefinitionContext)_localctx).type = dataType();
			setState(241);
			((FunctionDefinitionContext)_localctx).funcId = match(IDENTIFIER);
			setState(242);
			match(OPAREN);
			setState(243);
			((FunctionDefinitionContext)_localctx).formalParams = formalParameters();
			setState(244);
			match(CPAREN);
			setState(245);
			match(OBRACE);
			setState(246);
			((FunctionDefinitionContext)_localctx).stmts = statements();
			setState(251);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(247);
				match(T__14);
				setState(248);
				((FunctionDefinitionContext)_localctx).returnVal = expression(0);
				setState(249);
				match(SCOLON);
				}
			}

			setState(253);
			match(CBRACE);
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

	public static class StructDeclarationContext extends ParserRuleContext {
		public Token structId;
		public VariableDeclarationContext variableDeclaration;
		public List<VariableDeclarationContext> decls = new ArrayList<VariableDeclarationContext>();
		public TerminalNode OBRACE() { return getToken(EParser.OBRACE, 0); }
		public TerminalNode CBRACE() { return getToken(EParser.CBRACE, 0); }
		public TerminalNode IDENTIFIER() { return getToken(EParser.IDENTIFIER, 0); }
		public List<TerminalNode> SCOLON() { return getTokens(EParser.SCOLON); }
		public TerminalNode SCOLON(int i) {
			return getToken(EParser.SCOLON, i);
		}
		public List<VariableDeclarationContext> variableDeclaration() {
			return getRuleContexts(VariableDeclarationContext.class);
		}
		public VariableDeclarationContext variableDeclaration(int i) {
			return getRuleContext(VariableDeclarationContext.class,i);
		}
		public StructDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EVisitor ) return ((EVisitor<? extends T>)visitor).visitStructDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructDeclarationContext structDeclaration() throws RecognitionException {
		StructDeclarationContext _localctx = new StructDeclarationContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_structDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			match(T__15);
			setState(256);
			((StructDeclarationContext)_localctx).structId = match(IDENTIFIER);
			setState(257);
			match(OBRACE);
			setState(261); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(258);
				((StructDeclarationContext)_localctx).variableDeclaration = variableDeclaration();
				((StructDeclarationContext)_localctx).decls.add(((StructDeclarationContext)_localctx).variableDeclaration);
				setState(259);
				match(SCOLON);
				}
				}
				setState(263); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << IDENTIFIER))) != 0) );
			setState(265);
			match(CBRACE);
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

	public static class StructInitializationContext extends ParserRuleContext {
		public DataTypeContext object;
		public AssignmentsContext args;
		public PrimitiveContext type;
		public ExpressionContext size;
		public TerminalNode OPAREN() { return getToken(EParser.OPAREN, 0); }
		public TerminalNode CPAREN() { return getToken(EParser.CPAREN, 0); }
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public AssignmentsContext assignments() {
			return getRuleContext(AssignmentsContext.class,0);
		}
		public TerminalNode OBRACKET() { return getToken(EParser.OBRACKET, 0); }
		public TerminalNode CBRACKET() { return getToken(EParser.CBRACKET, 0); }
		public PrimitiveContext primitive() {
			return getRuleContext(PrimitiveContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StructInitializationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structInitialization; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EVisitor ) return ((EVisitor<? extends T>)visitor).visitStructInitialization(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructInitializationContext structInitialization() throws RecognitionException {
		StructInitializationContext _localctx = new StructInitializationContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_structInitialization);
		try {
			setState(279);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(267);
				match(T__10);
				setState(268);
				((StructInitializationContext)_localctx).object = dataType();
				setState(269);
				match(OPAREN);
				setState(270);
				((StructInitializationContext)_localctx).args = assignments();
				setState(271);
				match(CPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(273);
				match(T__10);
				setState(274);
				((StructInitializationContext)_localctx).type = primitive();
				setState(275);
				match(OBRACKET);
				setState(276);
				((StructInitializationContext)_localctx).size = expression(0);
				setState(277);
				match(CBRACKET);
				}
				break;
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

	public static class AssignmentsContext extends ParserRuleContext {
		public ExpressionContext expression;
		public List<ExpressionContext> asgmts = new ArrayList<ExpressionContext>();
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(EParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(EParser.COMMA, i);
		}
		public AssignmentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignments; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EVisitor ) return ((EVisitor<? extends T>)visitor).visitAssignments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentsContext assignments() throws RecognitionException {
		AssignmentsContext _localctx = new AssignmentsContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_assignments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281);
			((AssignmentsContext)_localctx).expression = expression(0);
			((AssignmentsContext)_localctx).asgmts.add(((AssignmentsContext)_localctx).expression);
			setState(286);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(282);
				match(COMMA);
				setState(283);
				((AssignmentsContext)_localctx).expression = expression(0);
				((AssignmentsContext)_localctx).asgmts.add(((AssignmentsContext)_localctx).expression);
				}
				}
				setState(288);
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

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StructInitializationExpressionContext extends ExpressionContext {
		public StructInitializationContext structInitialization() {
			return getRuleContext(StructInitializationContext.class,0);
		}
		public StructInitializationExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EVisitor ) return ((EVisitor<? extends T>)visitor).visitStructInitializationExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RelationalExpressionContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public RelationalExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EVisitor ) return ((EVisitor<? extends T>)visitor).visitRelationalExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BuiltinFunctionExpressionContext extends ExpressionContext {
		public BuiltinFunctionCallContext builtinFunctionCall() {
			return getRuleContext(BuiltinFunctionCallContext.class,0);
		}
		public BuiltinFunctionExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EVisitor ) return ((EVisitor<? extends T>)visitor).visitBuiltinFunctionExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IncludedFunctionExpressionContext extends ExpressionContext {
		public IncludedFunctionCallContext includedFunctionCall() {
			return getRuleContext(IncludedFunctionCallContext.class,0);
		}
		public IncludedFunctionExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EVisitor ) return ((EVisitor<? extends T>)visitor).visitIncludedFunctionExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DisjunctionExpressionContext extends ExpressionContext {
		public ExpressionContext lExpr;
		public ExpressionContext rExpr;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public DisjunctionExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EVisitor ) return ((EVisitor<? extends T>)visitor).visitDisjunctionExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VariableExpressionContext extends ExpressionContext {
		public Token varId;
		public TerminalNode IDENTIFIER() { return getToken(EParser.IDENTIFIER, 0); }
		public VariableExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EVisitor ) return ((EVisitor<? extends T>)visitor).visitVariableExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntegerExpressionContext extends ExpressionContext {
		public Token number;
		public TerminalNode INTEGER() { return getToken(EParser.INTEGER, 0); }
		public IntegerExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EVisitor ) return ((EVisitor<? extends T>)visitor).visitIntegerExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ShiftExpressionContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ShiftExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EVisitor ) return ((EVisitor<? extends T>)visitor).visitShiftExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SubtractionAdditionExpressionContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public SubtractionAdditionExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EVisitor ) return ((EVisitor<? extends T>)visitor).visitSubtractionAdditionExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolExpressionContext extends ExpressionContext {
		public Token bool;
		public TerminalNode BOOL() { return getToken(EParser.BOOL, 0); }
		public BoolExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EVisitor ) return ((EVisitor<? extends T>)visitor).visitBoolExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FloatingPointExpressionContext extends ExpressionContext {
		public Token number;
		public TerminalNode FLOAT() { return getToken(EParser.FLOAT, 0); }
		public FloatingPointExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EVisitor ) return ((EVisitor<? extends T>)visitor).visitFloatingPointExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StructExpressionContext extends ExpressionContext {
		public Token structId;
		public Token varId;
		public TerminalNode DOT() { return getToken(EParser.DOT, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(EParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(EParser.IDENTIFIER, i);
		}
		public StructExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EVisitor ) return ((EVisitor<? extends T>)visitor).visitStructExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunctionExpressionContext extends ExpressionContext {
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public FunctionExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EVisitor ) return ((EVisitor<? extends T>)visitor).visitFunctionExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ContravalenceExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ContravalenceExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EVisitor ) return ((EVisitor<? extends T>)visitor).visitContravalenceExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StructArrayExpressionContext extends ExpressionContext {
		public Token structId;
		public Token varId;
		public ExpressionContext index;
		public TerminalNode DOT() { return getToken(EParser.DOT, 0); }
		public TerminalNode OPAREN() { return getToken(EParser.OPAREN, 0); }
		public TerminalNode CPAREN() { return getToken(EParser.CPAREN, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(EParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(EParser.IDENTIFIER, i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StructArrayExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EVisitor ) return ((EVisitor<? extends T>)visitor).visitStructArrayExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringExpressionContext extends ExpressionContext {
		public Token str;
		public TerminalNode STRING() { return getToken(EParser.STRING, 0); }
		public StringExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EVisitor ) return ((EVisitor<? extends T>)visitor).visitStringExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DivisionMultiplicationModuloExpressionContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public DivisionMultiplicationModuloExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EVisitor ) return ((EVisitor<? extends T>)visitor).visitDivisionMultiplicationModuloExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayExpressionContext extends ExpressionContext {
		public Token varId;
		public ExpressionContext index;
		public TerminalNode OPAREN() { return getToken(EParser.OPAREN, 0); }
		public TerminalNode CPAREN() { return getToken(EParser.CPAREN, 0); }
		public TerminalNode IDENTIFIER() { return getToken(EParser.IDENTIFIER, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ArrayExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EVisitor ) return ((EVisitor<? extends T>)visitor).visitArrayExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NegationExpressionContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NegationExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EVisitor ) return ((EVisitor<? extends T>)visitor).visitNegationExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConjunctionExpressionContext extends ExpressionContext {
		public ExpressionContext lExpr;
		public ExpressionContext rExpr;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ConjunctionExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EVisitor ) return ((EVisitor<? extends T>)visitor).visitConjunctionExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 42;
		enterRecursionRule(_localctx, 42, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(316);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				_localctx = new NegationExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(290);
				match(T__16);
				setState(291);
				expression(20);
				}
				break;
			case 2:
				{
				_localctx = new IncludedFunctionExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(292);
				includedFunctionCall();
				}
				break;
			case 3:
				{
				_localctx = new BuiltinFunctionExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(293);
				builtinFunctionCall();
				}
				break;
			case 4:
				{
				_localctx = new StructInitializationExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(294);
				structInitialization();
				}
				break;
			case 5:
				{
				_localctx = new ArrayExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(295);
				((ArrayExpressionContext)_localctx).varId = match(IDENTIFIER);
				setState(296);
				match(OPAREN);
				setState(297);
				((ArrayExpressionContext)_localctx).index = expression(0);
				setState(298);
				match(CPAREN);
				}
				break;
			case 6:
				{
				_localctx = new StructExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(300);
				((StructExpressionContext)_localctx).structId = match(IDENTIFIER);
				setState(301);
				match(DOT);
				setState(302);
				((StructExpressionContext)_localctx).varId = match(IDENTIFIER);
				}
				break;
			case 7:
				{
				_localctx = new StructArrayExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(303);
				((StructArrayExpressionContext)_localctx).structId = match(IDENTIFIER);
				setState(304);
				match(DOT);
				setState(305);
				((StructArrayExpressionContext)_localctx).varId = match(IDENTIFIER);
				setState(306);
				match(OPAREN);
				setState(307);
				((StructArrayExpressionContext)_localctx).index = expression(0);
				setState(308);
				match(CPAREN);
				}
				break;
			case 8:
				{
				_localctx = new FunctionExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(310);
				functionCall();
				}
				break;
			case 9:
				{
				_localctx = new VariableExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(311);
				((VariableExpressionContext)_localctx).varId = match(IDENTIFIER);
				}
				break;
			case 10:
				{
				_localctx = new BoolExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(312);
				((BoolExpressionContext)_localctx).bool = match(BOOL);
				}
				break;
			case 11:
				{
				_localctx = new IntegerExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(313);
				((IntegerExpressionContext)_localctx).number = match(INTEGER);
				}
				break;
			case 12:
				{
				_localctx = new FloatingPointExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(314);
				((FloatingPointExpressionContext)_localctx).number = match(FLOAT);
				}
				break;
			case 13:
				{
				_localctx = new StringExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(315);
				((StringExpressionContext)_localctx).str = match(STRING);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(341);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(339);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
					case 1:
						{
						_localctx = new DivisionMultiplicationModuloExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(318);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(319);
						((DivisionMultiplicationModuloExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__17) | (1L << T__18) | (1L << T__19))) != 0)) ) {
							((DivisionMultiplicationModuloExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(320);
						expression(20);
						}
						break;
					case 2:
						{
						_localctx = new SubtractionAdditionExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(321);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(322);
						((SubtractionAdditionExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__20 || _la==T__21) ) {
							((SubtractionAdditionExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(323);
						expression(19);
						}
						break;
					case 3:
						{
						_localctx = new ShiftExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(324);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(325);
						((ShiftExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__22 || _la==T__23) ) {
							((ShiftExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(326);
						expression(18);
						}
						break;
					case 4:
						{
						_localctx = new RelationalExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(327);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(328);
						((RelationalExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29))) != 0)) ) {
							((RelationalExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(329);
						expression(17);
						}
						break;
					case 5:
						{
						_localctx = new ConjunctionExpressionContext(new ExpressionContext(_parentctx, _parentState));
						((ConjunctionExpressionContext)_localctx).lExpr = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(330);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(331);
						match(T__30);
						setState(332);
						((ConjunctionExpressionContext)_localctx).rExpr = expression(16);
						}
						break;
					case 6:
						{
						_localctx = new DisjunctionExpressionContext(new ExpressionContext(_parentctx, _parentState));
						((DisjunctionExpressionContext)_localctx).lExpr = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(333);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(334);
						match(T__31);
						setState(335);
						((DisjunctionExpressionContext)_localctx).rExpr = expression(15);
						}
						break;
					case 7:
						{
						_localctx = new ContravalenceExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(336);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(337);
						match(T__32);
						setState(338);
						expression(14);
						}
						break;
					}
					} 
				}
				setState(343);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
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

	public static class CurrentParametersContext extends ParserRuleContext {
		public ExpressionContext expression;
		public List<ExpressionContext> exprs = new ArrayList<ExpressionContext>();
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(EParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(EParser.COMMA, i);
		}
		public CurrentParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_currentParameters; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EVisitor ) return ((EVisitor<? extends T>)visitor).visitCurrentParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CurrentParametersContext currentParameters() throws RecognitionException {
		CurrentParametersContext _localctx = new CurrentParametersContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_currentParameters);
		int _la;
		try {
			setState(353);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
			case T__16:
			case BOOL:
			case INTEGER:
			case FLOAT:
			case STRING:
			case IDENTIFIER:
			case BUILTINFUNCTION:
				enterOuterAlt(_localctx, 1);
				{
				setState(344);
				((CurrentParametersContext)_localctx).expression = expression(0);
				((CurrentParametersContext)_localctx).exprs.add(((CurrentParametersContext)_localctx).expression);
				setState(349);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(345);
					match(COMMA);
					setState(346);
					((CurrentParametersContext)_localctx).expression = expression(0);
					((CurrentParametersContext)_localctx).exprs.add(((CurrentParametersContext)_localctx).expression);
					}
					}
					setState(351);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case CPAREN:
				enterOuterAlt(_localctx, 2);
				{
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

	public static class BlockContext extends ParserRuleContext {
		public TerminalNode OBRACE() { return getToken(EParser.OBRACE, 0); }
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public TerminalNode CBRACE() { return getToken(EParser.CBRACE, 0); }
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EVisitor ) return ((EVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(355);
			match(OBRACE);
			setState(356);
			statements();
			setState(357);
			match(CBRACE);
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

	public static class StatementsContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EVisitor ) return ((EVisitor<? extends T>)visitor).visitStatements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_statements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(362);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << IDENTIFIER) | (1L << BUILTINFUNCTION))) != 0)) {
				{
				{
				setState(359);
				statement();
				}
				}
				setState(364);
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

	public static class FormalParametersContext extends ParserRuleContext {
		public VariableDeclarationContext variableDeclaration;
		public List<VariableDeclarationContext> decls = new ArrayList<VariableDeclarationContext>();
		public List<VariableDeclarationContext> variableDeclaration() {
			return getRuleContexts(VariableDeclarationContext.class);
		}
		public VariableDeclarationContext variableDeclaration(int i) {
			return getRuleContext(VariableDeclarationContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(EParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(EParser.COMMA, i);
		}
		public FormalParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameters; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EVisitor ) return ((EVisitor<? extends T>)visitor).visitFormalParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalParametersContext formalParameters() throws RecognitionException {
		FormalParametersContext _localctx = new FormalParametersContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_formalParameters);
		int _la;
		try {
			setState(374);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__33:
			case T__34:
			case T__35:
			case T__36:
			case T__37:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(365);
				((FormalParametersContext)_localctx).variableDeclaration = variableDeclaration();
				((FormalParametersContext)_localctx).decls.add(((FormalParametersContext)_localctx).variableDeclaration);
				setState(370);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(366);
					match(COMMA);
					setState(367);
					((FormalParametersContext)_localctx).variableDeclaration = variableDeclaration();
					((FormalParametersContext)_localctx).decls.add(((FormalParametersContext)_localctx).variableDeclaration);
					}
					}
					setState(372);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case CPAREN:
				enterOuterAlt(_localctx, 2);
				{
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

	public static class DataTypeContext extends ParserRuleContext {
		public PrimitiveContext primitive() {
			return getRuleContext(PrimitiveContext.class,0);
		}
		public TerminalNode OCBRACKET() { return getToken(EParser.OCBRACKET, 0); }
		public TerminalNode IDENTIFIER() { return getToken(EParser.IDENTIFIER, 0); }
		public DataTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EVisitor ) return ((EVisitor<? extends T>)visitor).visitDataType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataTypeContext dataType() throws RecognitionException {
		DataTypeContext _localctx = new DataTypeContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_dataType);
		try {
			setState(384);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__33:
			case T__34:
			case T__35:
			case T__36:
			case T__37:
				enterOuterAlt(_localctx, 1);
				{
				setState(376);
				primitive();
				setState(378);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
				case 1:
					{
					setState(377);
					match(OCBRACKET);
					}
					break;
				}
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(380);
				match(IDENTIFIER);
				setState(382);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
				case 1:
					{
					setState(381);
					match(OCBRACKET);
					}
					break;
				}
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

	public static class PrimitiveContext extends ParserRuleContext {
		public PrimitiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitive; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EVisitor ) return ((EVisitor<? extends T>)visitor).visitPrimitive(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimitiveContext primitive() throws RecognitionException {
		PrimitiveContext _localctx = new PrimitiveContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_primitive);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(386);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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
		case 21:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 19);
		case 1:
			return precpred(_ctx, 18);
		case 2:
			return precpred(_ctx, 17);
		case 3:
			return precpred(_ctx, 16);
		case 4:
			return precpred(_ctx, 15);
		case 5:
			return precpred(_ctx, 14);
		case 6:
			return precpred(_ctx, 13);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3<\u0187\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\7\2<\n\2\f\2\16\2?\13\2\3"+
		"\2\7\2B\n\2\f\2\16\2E\13\2\3\2\6\2H\n\2\r\2\16\2I\3\2\3\2\3\3\3\3\3\3"+
		"\6\3Q\n\3\r\3\16\3R\3\3\3\3\7\3W\n\3\f\3\16\3Z\13\3\7\3\\\n\3\f\3\16\3"+
		"_\13\3\3\3\3\3\3\4\3\4\3\4\7\4f\n\4\f\4\16\4i\13\4\3\5\3\5\3\5\3\6\3\6"+
		"\3\6\5\6q\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u008b\n\7\3\b\3\b\3\b\3\b"+
		"\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\5\n\u009b\n\n\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00a8\n\13\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00b8\n\f\3\r\3\r\3\r\3"+
		"\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00c6\n\16\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\7\20\u00d7"+
		"\n\20\f\20\16\20\u00da\13\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00e3"+
		"\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22"+
		"\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00fe"+
		"\n\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\6\24\u0108\n\24\r\24\16"+
		"\24\u0109\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\5\25\u011a\n\25\3\26\3\26\3\26\7\26\u011f\n\26\f\26\16\26\u0122"+
		"\13\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\5\27\u013f\n\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\7\27\u0156\n\27\f\27"+
		"\16\27\u0159\13\27\3\30\3\30\3\30\7\30\u015e\n\30\f\30\16\30\u0161\13"+
		"\30\3\30\5\30\u0164\n\30\3\31\3\31\3\31\3\31\3\32\7\32\u016b\n\32\f\32"+
		"\16\32\u016e\13\32\3\33\3\33\3\33\7\33\u0173\n\33\f\33\16\33\u0176\13"+
		"\33\3\33\5\33\u0179\n\33\3\34\3\34\5\34\u017d\n\34\3\34\3\34\5\34\u0181"+
		"\n\34\5\34\u0183\n\34\3\35\3\35\3\35\2\3,\36\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\34\36 \"$&(*,.\60\62\64\668\2\7\3\2\24\26\3\2\27\30\3\2\31\32\3"+
		"\2\33 \3\2$(\2\u01a5\2=\3\2\2\2\4M\3\2\2\2\6b\3\2\2\2\bj\3\2\2\2\np\3"+
		"\2\2\2\f\u008a\3\2\2\2\16\u008c\3\2\2\2\20\u0091\3\2\2\2\22\u0096\3\2"+
		"\2\2\24\u00a7\3\2\2\2\26\u00b7\3\2\2\2\30\u00b9\3\2\2\2\32\u00be\3\2\2"+
		"\2\34\u00c7\3\2\2\2\36\u00e2\3\2\2\2 \u00e4\3\2\2\2\"\u00ed\3\2\2\2$\u00f2"+
		"\3\2\2\2&\u0101\3\2\2\2(\u0119\3\2\2\2*\u011b\3\2\2\2,\u013e\3\2\2\2."+
		"\u0163\3\2\2\2\60\u0165\3\2\2\2\62\u016c\3\2\2\2\64\u0178\3\2\2\2\66\u0182"+
		"\3\2\2\28\u0184\3\2\2\2:<\5\4\3\2;:\3\2\2\2<?\3\2\2\2=;\3\2\2\2=>\3\2"+
		"\2\2>C\3\2\2\2?=\3\2\2\2@B\5\b\5\2A@\3\2\2\2BE\3\2\2\2CA\3\2\2\2CD\3\2"+
		"\2\2DG\3\2\2\2EC\3\2\2\2FH\5\n\6\2GF\3\2\2\2HI\3\2\2\2IG\3\2\2\2IJ\3\2"+
		"\2\2JK\3\2\2\2KL\7\2\2\3L\3\3\2\2\2MN\7\3\2\2NP\7\66\2\2OQ\5\6\4\2PO\3"+
		"\2\2\2QR\3\2\2\2RP\3\2\2\2RS\3\2\2\2S]\3\2\2\2TX\7\63\2\2UW\5\6\4\2VU"+
		"\3\2\2\2WZ\3\2\2\2XV\3\2\2\2XY\3\2\2\2Y\\\3\2\2\2ZX\3\2\2\2[T\3\2\2\2"+
		"\\_\3\2\2\2][\3\2\2\2]^\3\2\2\2^`\3\2\2\2_]\3\2\2\2`a\7\67\2\2a\5\3\2"+
		"\2\2bg\7-\2\2cd\7\62\2\2df\7-\2\2ec\3\2\2\2fi\3\2\2\2ge\3\2\2\2gh\3\2"+
		"\2\2h\7\3\2\2\2ig\3\2\2\2jk\7\4\2\2kl\7\5\2\2l\t\3\2\2\2mq\5\f\7\2nq\5"+
		"$\23\2oq\5&\24\2pm\3\2\2\2pn\3\2\2\2po\3\2\2\2q\13\3\2\2\2rs\5\16\b\2"+
		"st\7\61\2\2t\u008b\3\2\2\2uv\5\20\t\2vw\7\61\2\2w\u008b\3\2\2\2xy\5\22"+
		"\n\2yz\7\61\2\2z\u008b\3\2\2\2{|\5\24\13\2|}\7\61\2\2}\u008b\3\2\2\2~"+
		"\177\5\30\r\2\177\u0080\7\61\2\2\u0080\u008b\3\2\2\2\u0081\u008b\5\32"+
		"\16\2\u0082\u008b\5\34\17\2\u0083\u0084\5 \21\2\u0084\u0085\7\61\2\2\u0085"+
		"\u008b\3\2\2\2\u0086\u0087\5\"\22\2\u0087\u0088\7\61\2\2\u0088\u008b\3"+
		"\2\2\2\u0089\u008b\5\36\20\2\u008ar\3\2\2\2\u008au\3\2\2\2\u008ax\3\2"+
		"\2\2\u008a{\3\2\2\2\u008a~\3\2\2\2\u008a\u0081\3\2\2\2\u008a\u0082\3\2"+
		"\2\2\u008a\u0083\3\2\2\2\u008a\u0086\3\2\2\2\u008a\u0089\3\2\2\2\u008b"+
		"\r\3\2\2\2\u008c\u008d\7\6\2\2\u008d\u008e\7\66\2\2\u008e\u008f\5,\27"+
		"\2\u008f\u0090\7\67\2\2\u0090\17\3\2\2\2\u0091\u0092\7\7\2\2\u0092\u0093"+
		"\7\66\2\2\u0093\u0094\5,\27\2\u0094\u0095\7\67\2\2\u0095\21\3\2\2\2\u0096"+
		"\u0097\5\66\34\2\u0097\u009a\7-\2\2\u0098\u0099\7\64\2\2\u0099\u009b\5"+
		",\27\2\u009a\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b\23\3\2\2\2\u009c"+
		"\u009d\7-\2\2\u009d\u009e\7\64\2\2\u009e\u00a8\5,\27\2\u009f\u00a0\7-"+
		"\2\2\u00a0\u00a1\7:\2\2\u00a1\u00a2\5,\27\2\u00a2\u00a3\7;\2\2\u00a3\u00a4"+
		"\7\64\2\2\u00a4\u00a5\5,\27\2\u00a5\u00a8\3\2\2\2\u00a6\u00a8\5\26\f\2"+
		"\u00a7\u009c\3\2\2\2\u00a7\u009f\3\2\2\2\u00a7\u00a6\3\2\2\2\u00a8\25"+
		"\3\2\2\2\u00a9\u00aa\7-\2\2\u00aa\u00ab\7\62\2\2\u00ab\u00ac\7-\2\2\u00ac"+
		"\u00ad\7\64\2\2\u00ad\u00b8\5,\27\2\u00ae\u00af\7-\2\2\u00af\u00b0\7\62"+
		"\2\2\u00b0\u00b1\7-\2\2\u00b1\u00b2\7:\2\2\u00b2\u00b3\5,\27\2\u00b3\u00b4"+
		"\7;\2\2\u00b4\u00b5\7\64\2\2\u00b5\u00b6\5,\27\2\u00b6\u00b8\3\2\2\2\u00b7"+
		"\u00a9\3\2\2\2\u00b7\u00ae\3\2\2\2\u00b8\27\3\2\2\2\u00b9\u00ba\7-\2\2"+
		"\u00ba\u00bb\7\66\2\2\u00bb\u00bc\5.\30\2\u00bc\u00bd\7\67\2\2\u00bd\31"+
		"\3\2\2\2\u00be\u00bf\7\b\2\2\u00bf\u00c0\7\66\2\2\u00c0\u00c1\5,\27\2"+
		"\u00c1\u00c2\7\67\2\2\u00c2\u00c5\5\60\31\2\u00c3\u00c4\7\t\2\2\u00c4"+
		"\u00c6\5\60\31\2\u00c5\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\33\3\2"+
		"\2\2\u00c7\u00c8\7\n\2\2\u00c8\u00c9\7\66\2\2\u00c9\u00ca\5,\27\2\u00ca"+
		"\u00cb\7\67\2\2\u00cb\u00cc\5\60\31\2\u00cc\35\3\2\2\2\u00cd\u00ce\7\13"+
		"\2\2\u00ce\u00cf\78\2\2\u00cf\u00d0\7,\2\2\u00d0\u00e3\79\2\2\u00d1\u00d2"+
		"\7\f\2\2\u00d2\u00d3\7,\2\2\u00d3\u00d4\7,\2\2\u00d4\u00d8\7\66\2\2\u00d5"+
		"\u00d7\7,\2\2\u00d6\u00d5\3\2\2\2\u00d7\u00da\3\2\2\2\u00d8\u00d6\3\2"+
		"\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00db\3\2\2\2\u00da\u00d8\3\2\2\2\u00db"+
		"\u00e3\7\67\2\2\u00dc\u00dd\7\r\2\2\u00dd\u00e3\7,\2\2\u00de\u00df\7\16"+
		"\2\2\u00df\u00e3\5,\27\2\u00e0\u00e1\7\17\2\2\u00e1\u00e3\7,\2\2\u00e2"+
		"\u00cd\3\2\2\2\u00e2\u00d1\3\2\2\2\u00e2\u00dc\3\2\2\2\u00e2\u00de\3\2"+
		"\2\2\u00e2\u00e0\3\2\2\2\u00e3\37\3\2\2\2\u00e4\u00e5\7-\2\2\u00e5\u00e6"+
		"\7\62\2\2\u00e6\u00e7\7-\2\2\u00e7\u00e8\7\66\2\2\u00e8\u00e9\5.\30\2"+
		"\u00e9\u00ea\7\67\2\2\u00ea\u00eb\7\20\2\2\u00eb\u00ec\5\66\34\2\u00ec"+
		"!\3\2\2\2\u00ed\u00ee\7.\2\2\u00ee\u00ef\7\66\2\2\u00ef\u00f0\5.\30\2"+
		"\u00f0\u00f1\7\67\2\2\u00f1#\3\2\2\2\u00f2\u00f3\5\66\34\2\u00f3\u00f4"+
		"\7-\2\2\u00f4\u00f5\7\66\2\2\u00f5\u00f6\5\64\33\2\u00f6\u00f7\7\67\2"+
		"\2\u00f7\u00f8\78\2\2\u00f8\u00fd\5\62\32\2\u00f9\u00fa\7\21\2\2\u00fa"+
		"\u00fb\5,\27\2\u00fb\u00fc\7\61\2\2\u00fc\u00fe\3\2\2\2\u00fd\u00f9\3"+
		"\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u0100\79\2\2\u0100"+
		"%\3\2\2\2\u0101\u0102\7\22\2\2\u0102\u0103\7-\2\2\u0103\u0107\78\2\2\u0104"+
		"\u0105\5\22\n\2\u0105\u0106\7\61\2\2\u0106\u0108\3\2\2\2\u0107\u0104\3"+
		"\2\2\2\u0108\u0109\3\2\2\2\u0109\u0107\3\2\2\2\u0109\u010a\3\2\2\2\u010a"+
		"\u010b\3\2\2\2\u010b\u010c\79\2\2\u010c\'\3\2\2\2\u010d\u010e\7\r\2\2"+
		"\u010e\u010f\5\66\34\2\u010f\u0110\7\66\2\2\u0110\u0111\5*\26\2\u0111"+
		"\u0112\7\67\2\2\u0112\u011a\3\2\2\2\u0113\u0114\7\r\2\2\u0114\u0115\5"+
		"8\35\2\u0115\u0116\7:\2\2\u0116\u0117\5,\27\2\u0117\u0118\7;\2\2\u0118"+
		"\u011a\3\2\2\2\u0119\u010d\3\2\2\2\u0119\u0113\3\2\2\2\u011a)\3\2\2\2"+
		"\u011b\u0120\5,\27\2\u011c\u011d\7\63\2\2\u011d\u011f\5,\27\2\u011e\u011c"+
		"\3\2\2\2\u011f\u0122\3\2\2\2\u0120\u011e\3\2\2\2\u0120\u0121\3\2\2\2\u0121"+
		"+\3\2\2\2\u0122\u0120\3\2\2\2\u0123\u0124\b\27\1\2\u0124\u0125\7\23\2"+
		"\2\u0125\u013f\5,\27\26\u0126\u013f\5 \21\2\u0127\u013f\5\"\22\2\u0128"+
		"\u013f\5(\25\2\u0129\u012a\7-\2\2\u012a\u012b\7\66\2\2\u012b\u012c\5,"+
		"\27\2\u012c\u012d\7\67\2\2\u012d\u013f\3\2\2\2\u012e\u012f\7-\2\2\u012f"+
		"\u0130\7\62\2\2\u0130\u013f\7-\2\2\u0131\u0132\7-\2\2\u0132\u0133\7\62"+
		"\2\2\u0133\u0134\7-\2\2\u0134\u0135\7\66\2\2\u0135\u0136\5,\27\2\u0136"+
		"\u0137\7\67\2\2\u0137\u013f\3\2\2\2\u0138\u013f\5\30\r\2\u0139\u013f\7"+
		"-\2\2\u013a\u013f\7)\2\2\u013b\u013f\7*\2\2\u013c\u013f\7+\2\2\u013d\u013f"+
		"\7,\2\2\u013e\u0123\3\2\2\2\u013e\u0126\3\2\2\2\u013e\u0127\3\2\2\2\u013e"+
		"\u0128\3\2\2\2\u013e\u0129\3\2\2\2\u013e\u012e\3\2\2\2\u013e\u0131\3\2"+
		"\2\2\u013e\u0138\3\2\2\2\u013e\u0139\3\2\2\2\u013e\u013a\3\2\2\2\u013e"+
		"\u013b\3\2\2\2\u013e\u013c\3\2\2\2\u013e\u013d\3\2\2\2\u013f\u0157\3\2"+
		"\2\2\u0140\u0141\f\25\2\2\u0141\u0142\t\2\2\2\u0142\u0156\5,\27\26\u0143"+
		"\u0144\f\24\2\2\u0144\u0145\t\3\2\2\u0145\u0156\5,\27\25\u0146\u0147\f"+
		"\23\2\2\u0147\u0148\t\4\2\2\u0148\u0156\5,\27\24\u0149\u014a\f\22\2\2"+
		"\u014a\u014b\t\5\2\2\u014b\u0156\5,\27\23\u014c\u014d\f\21\2\2\u014d\u014e"+
		"\7!\2\2\u014e\u0156\5,\27\22\u014f\u0150\f\20\2\2\u0150\u0151\7\"\2\2"+
		"\u0151\u0156\5,\27\21\u0152\u0153\f\17\2\2\u0153\u0154\7#\2\2\u0154\u0156"+
		"\5,\27\20\u0155\u0140\3\2\2\2\u0155\u0143\3\2\2\2\u0155\u0146\3\2\2\2"+
		"\u0155\u0149\3\2\2\2\u0155\u014c\3\2\2\2\u0155\u014f\3\2\2\2\u0155\u0152"+
		"\3\2\2\2\u0156\u0159\3\2\2\2\u0157\u0155\3\2\2\2\u0157\u0158\3\2\2\2\u0158"+
		"-\3\2\2\2\u0159\u0157\3\2\2\2\u015a\u015f\5,\27\2\u015b\u015c\7\63\2\2"+
		"\u015c\u015e\5,\27\2\u015d\u015b\3\2\2\2\u015e\u0161\3\2\2\2\u015f\u015d"+
		"\3\2\2\2\u015f\u0160\3\2\2\2\u0160\u0164\3\2\2\2\u0161\u015f\3\2\2\2\u0162"+
		"\u0164\3\2\2\2\u0163\u015a\3\2\2\2\u0163\u0162\3\2\2\2\u0164/\3\2\2\2"+
		"\u0165\u0166\78\2\2\u0166\u0167\5\62\32\2\u0167\u0168\79\2\2\u0168\61"+
		"\3\2\2\2\u0169\u016b\5\f\7\2\u016a\u0169\3\2\2\2\u016b\u016e\3\2\2\2\u016c"+
		"\u016a\3\2\2\2\u016c\u016d\3\2\2\2\u016d\63\3\2\2\2\u016e\u016c\3\2\2"+
		"\2\u016f\u0174\5\22\n\2\u0170\u0171\7\63\2\2\u0171\u0173\5\22\n\2\u0172"+
		"\u0170\3\2\2\2\u0173\u0176\3\2\2\2\u0174\u0172\3\2\2\2\u0174\u0175\3\2"+
		"\2\2\u0175\u0179\3\2\2\2\u0176\u0174\3\2\2\2\u0177\u0179\3\2\2\2\u0178"+
		"\u016f\3\2\2\2\u0178\u0177\3\2\2\2\u0179\65\3\2\2\2\u017a\u017c\58\35"+
		"\2\u017b\u017d\7<\2\2\u017c\u017b\3\2\2\2\u017c\u017d\3\2\2\2\u017d\u0183"+
		"\3\2\2\2\u017e\u0180\7-\2\2\u017f\u0181\7<\2\2\u0180\u017f\3\2\2\2\u0180"+
		"\u0181\3\2\2\2\u0181\u0183\3\2\2\2\u0182\u017a\3\2\2\2\u0182\u017e\3\2"+
		"\2\2\u0183\67\3\2\2\2\u0184\u0185\t\6\2\2\u01859\3\2\2\2 =CIRX]gp\u008a"+
		"\u009a\u00a7\u00b7\u00c5\u00d8\u00e2\u00fd\u0109\u0119\u0120\u013e\u0155"+
		"\u0157\u015f\u0163\u016c\u0174\u0178\u017c\u0180\u0182";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}