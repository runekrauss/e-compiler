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
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, DATATYPE=31, 
		PRIMITIVE=32, BOOL=33, INTEGER=34, DOUBLE=35, STRING=36, IDENTIFIER=37, 
		BUILTINFUNCTION=38, COMMENT=39, WHITESPACE=40, SCOLON=41, DOT=42, COMMA=43, 
		ASSIGN=44, QMARK=45, OPAREN=46, CPAREN=47, OBRACE=48, CBRACE=49, OBRACKET=50, 
		CBRACKET=51;
	public static final int
		RULE_program = 0, RULE_includes = 1, RULE_module = 2, RULE_command = 3, 
		RULE_statement = 4, RULE_print = 5, RULE_printLine = 6, RULE_variableDeclaration = 7, 
		RULE_assignment = 8, RULE_structVariableAssignment = 9, RULE_functionCall = 10, 
		RULE_currentParameters = 11, RULE_branch = 12, RULE_loop = 13, RULE_block = 14, 
		RULE_statements = 15, RULE_assembly = 16, RULE_includedFunctionCall = 17, 
		RULE_builtinFunctionCall = 18, RULE_functionDefinition = 19, RULE_formalParameters = 20, 
		RULE_structDeclaration = 21, RULE_structInitialization = 22, RULE_assignments = 23, 
		RULE_expression = 24;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "includes", "module", "command", "statement", "print", "printLine", 
			"variableDeclaration", "assignment", "structVariableAssignment", "functionCall", 
			"currentParameters", "branch", "loop", "block", "statements", "assembly", 
			"includedFunctionCall", "builtinFunctionCall", "functionDefinition", 
			"formalParameters", "structDeclaration", "structInitialization", "assignments", 
			"expression"
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
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(50);
				((ProgramContext)_localctx).includes = includes();
				((ProgramContext)_localctx).incls.add(((ProgramContext)_localctx).includes);
				}
				}
				setState(55);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(57); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(56);
				command();
				}
				}
				setState(59); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__13) | (1L << DATATYPE) | (1L << IDENTIFIER) | (1L << BUILTINFUNCTION))) != 0) );
			setState(61);
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
			setState(63);
			match(T__0);
			setState(64);
			match(OPAREN);
			setState(66); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(65);
				((IncludesContext)_localctx).module = module();
				((IncludesContext)_localctx).mods.add(((IncludesContext)_localctx).module);
				}
				}
				setState(68); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IDENTIFIER );
			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(70);
				match(COMMA);
				setState(74);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==IDENTIFIER) {
					{
					{
					setState(71);
					((IncludesContext)_localctx).module = module();
					((IncludesContext)_localctx).mods.add(((IncludesContext)_localctx).module);
					}
					}
					setState(76);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(81);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(82);
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
			setState(84);
			match(IDENTIFIER);
			setState(89);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(85);
				match(DOT);
				setState(86);
				match(IDENTIFIER);
				}
				}
				setState(91);
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
		enterRule(_localctx, 6, RULE_command);
		try {
			setState(95);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new StatementCommandContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(92);
				statement();
				}
				break;
			case 2:
				_localctx = new FunctionDefinitionCommandContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(93);
				functionDefinition();
				}
				break;
			case 3:
				_localctx = new StructDeclarationCommandContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(94);
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
		enterRule(_localctx, 8, RULE_statement);
		try {
			setState(121);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(97);
				print();
				setState(98);
				match(SCOLON);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(100);
				printLine();
				setState(101);
				match(SCOLON);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(103);
				variableDeclaration();
				setState(104);
				match(SCOLON);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(106);
				assignment();
				setState(107);
				match(SCOLON);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(109);
				functionCall();
				setState(110);
				match(SCOLON);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(112);
				branch();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(113);
				loop();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(114);
				includedFunctionCall();
				setState(115);
				match(SCOLON);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(117);
				builtinFunctionCall();
				setState(118);
				match(SCOLON);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(120);
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
		enterRule(_localctx, 10, RULE_print);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			match(T__1);
			setState(124);
			match(OPAREN);
			setState(125);
			((PrintContext)_localctx).arg = expression(0);
			setState(126);
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
		enterRule(_localctx, 12, RULE_printLine);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			match(T__2);
			setState(129);
			match(OPAREN);
			setState(130);
			((PrintLineContext)_localctx).arg = expression(0);
			setState(131);
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
		public Token type;
		public Token varId;
		public ExpressionContext expr;
		public TerminalNode DATATYPE() { return getToken(EParser.DATATYPE, 0); }
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
		enterRule(_localctx, 14, RULE_variableDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			((VariableDeclarationContext)_localctx).type = match(DATATYPE);
			setState(134);
			((VariableDeclarationContext)_localctx).varId = match(IDENTIFIER);
			setState(137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(135);
				match(ASSIGN);
				setState(136);
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
		enterRule(_localctx, 16, RULE_assignment);
		try {
			setState(150);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(139);
				((AssignmentContext)_localctx).varId = match(IDENTIFIER);
				setState(140);
				match(ASSIGN);
				setState(141);
				((AssignmentContext)_localctx).expr = expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(142);
				((AssignmentContext)_localctx).varId = match(IDENTIFIER);
				setState(143);
				match(OBRACKET);
				setState(144);
				((AssignmentContext)_localctx).index = expression(0);
				setState(145);
				match(CBRACKET);
				setState(146);
				match(ASSIGN);
				setState(147);
				((AssignmentContext)_localctx).expr = expression(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(149);
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
		enterRule(_localctx, 18, RULE_structVariableAssignment);
		try {
			setState(166);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(152);
				((StructVariableAssignmentContext)_localctx).structId = match(IDENTIFIER);
				setState(153);
				match(DOT);
				setState(154);
				((StructVariableAssignmentContext)_localctx).varId = match(IDENTIFIER);
				setState(155);
				match(ASSIGN);
				setState(156);
				((StructVariableAssignmentContext)_localctx).expr = expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(157);
				((StructVariableAssignmentContext)_localctx).structId = match(IDENTIFIER);
				setState(158);
				match(DOT);
				setState(159);
				((StructVariableAssignmentContext)_localctx).varId = match(IDENTIFIER);
				setState(160);
				match(OBRACKET);
				setState(161);
				((StructVariableAssignmentContext)_localctx).index = expression(0);
				setState(162);
				match(CBRACKET);
				setState(163);
				match(ASSIGN);
				setState(164);
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
		enterRule(_localctx, 20, RULE_functionCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			((FunctionCallContext)_localctx).funcId = match(IDENTIFIER);
			setState(169);
			match(OPAREN);
			setState(170);
			((FunctionCallContext)_localctx).currentParams = currentParameters();
			setState(171);
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
		enterRule(_localctx, 22, RULE_currentParameters);
		int _la;
		try {
			setState(182);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__8:
			case BOOL:
			case INTEGER:
			case DOUBLE:
			case STRING:
			case IDENTIFIER:
			case BUILTINFUNCTION:
				enterOuterAlt(_localctx, 1);
				{
				setState(173);
				((CurrentParametersContext)_localctx).expression = expression(0);
				((CurrentParametersContext)_localctx).exprs.add(((CurrentParametersContext)_localctx).expression);
				setState(178);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(174);
					match(COMMA);
					setState(175);
					((CurrentParametersContext)_localctx).expression = expression(0);
					((CurrentParametersContext)_localctx).exprs.add(((CurrentParametersContext)_localctx).expression);
					}
					}
					setState(180);
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
			setState(184);
			match(T__3);
			setState(185);
			match(OPAREN);
			setState(186);
			((BranchContext)_localctx).cond = expression(0);
			setState(187);
			match(CPAREN);
			setState(188);
			((BranchContext)_localctx).onTrue = block();
			setState(191);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(189);
				match(T__4);
				setState(190);
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
			setState(193);
			match(T__5);
			setState(194);
			match(OPAREN);
			setState(195);
			((LoopContext)_localctx).cond = expression(0);
			setState(196);
			match(CPAREN);
			setState(197);
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
		enterRule(_localctx, 28, RULE_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			match(OBRACE);
			setState(200);
			statements();
			setState(201);
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
		enterRule(_localctx, 30, RULE_statements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << DATATYPE) | (1L << IDENTIFIER) | (1L << BUILTINFUNCTION))) != 0)) {
				{
				{
				setState(203);
				statement();
				}
				}
				setState(208);
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
		enterRule(_localctx, 32, RULE_assembly);
		int _la;
		try {
			setState(230);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
				_localctx = new InlineAssemblyContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(209);
				match(T__6);
				setState(210);
				match(OBRACE);
				setState(211);
				((InlineAssemblyContext)_localctx).str = match(STRING);
				setState(212);
				match(CBRACE);
				}
				break;
			case T__7:
				_localctx = new InvokeAssemblyContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(213);
				match(T__7);
				setState(214);
				((InvokeAssemblyContext)_localctx).mod = match(STRING);
				setState(215);
				((InvokeAssemblyContext)_localctx).id = match(STRING);
				setState(216);
				match(OPAREN);
				setState(220);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==STRING) {
					{
					{
					setState(217);
					((InvokeAssemblyContext)_localctx).STRING = match(STRING);
					((InvokeAssemblyContext)_localctx).args.add(((InvokeAssemblyContext)_localctx).STRING);
					}
					}
					setState(222);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(223);
				match(CPAREN);
				}
				break;
			case T__8:
				_localctx = new InitObjectContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(224);
				match(T__8);
				setState(225);
				((InitObjectContext)_localctx).type = match(STRING);
				}
				break;
			case T__9:
				_localctx = new PushToStackContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(226);
				match(T__9);
				setState(227);
				expression(0);
				}
				break;
			case T__10:
				_localctx = new SetTopOfStackContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(228);
				match(T__10);
				setState(229);
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
		public Token type;
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
		public TerminalNode DATATYPE() { return getToken(EParser.DATATYPE, 0); }
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
		enterRule(_localctx, 34, RULE_includedFunctionCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			((IncludedFunctionCallContext)_localctx).inclDir = match(IDENTIFIER);
			setState(233);
			match(DOT);
			setState(234);
			((IncludedFunctionCallContext)_localctx).funcId = match(IDENTIFIER);
			setState(235);
			match(OPAREN);
			setState(236);
			((IncludedFunctionCallContext)_localctx).args = currentParameters();
			setState(237);
			match(CPAREN);
			setState(238);
			match(T__11);
			setState(239);
			((IncludedFunctionCallContext)_localctx).type = match(DATATYPE);
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
		enterRule(_localctx, 36, RULE_builtinFunctionCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			((BuiltinFunctionCallContext)_localctx).funcId = match(BUILTINFUNCTION);
			setState(242);
			match(OPAREN);
			setState(243);
			((BuiltinFunctionCallContext)_localctx).args = currentParameters();
			setState(244);
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
		public Token type;
		public Token funcId;
		public FormalParametersContext formalParams;
		public StatementsContext stmts;
		public ExpressionContext returnVal;
		public TerminalNode OPAREN() { return getToken(EParser.OPAREN, 0); }
		public TerminalNode CPAREN() { return getToken(EParser.CPAREN, 0); }
		public TerminalNode OBRACE() { return getToken(EParser.OBRACE, 0); }
		public TerminalNode SCOLON() { return getToken(EParser.SCOLON, 0); }
		public TerminalNode CBRACE() { return getToken(EParser.CBRACE, 0); }
		public TerminalNode DATATYPE() { return getToken(EParser.DATATYPE, 0); }
		public TerminalNode IDENTIFIER() { return getToken(EParser.IDENTIFIER, 0); }
		public FormalParametersContext formalParameters() {
			return getRuleContext(FormalParametersContext.class,0);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
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
		enterRule(_localctx, 38, RULE_functionDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			((FunctionDefinitionContext)_localctx).type = match(DATATYPE);
			setState(247);
			((FunctionDefinitionContext)_localctx).funcId = match(IDENTIFIER);
			setState(248);
			match(OPAREN);
			setState(249);
			((FunctionDefinitionContext)_localctx).formalParams = formalParameters();
			setState(250);
			match(CPAREN);
			setState(251);
			match(OBRACE);
			setState(252);
			((FunctionDefinitionContext)_localctx).stmts = statements();
			setState(253);
			match(T__12);
			setState(254);
			((FunctionDefinitionContext)_localctx).returnVal = expression(0);
			setState(255);
			match(SCOLON);
			setState(256);
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
		enterRule(_localctx, 40, RULE_formalParameters);
		int _la;
		try {
			setState(267);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DATATYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(258);
				((FormalParametersContext)_localctx).variableDeclaration = variableDeclaration();
				((FormalParametersContext)_localctx).decls.add(((FormalParametersContext)_localctx).variableDeclaration);
				setState(263);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(259);
					match(COMMA);
					setState(260);
					((FormalParametersContext)_localctx).variableDeclaration = variableDeclaration();
					((FormalParametersContext)_localctx).decls.add(((FormalParametersContext)_localctx).variableDeclaration);
					}
					}
					setState(265);
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
		enterRule(_localctx, 42, RULE_structDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(269);
			match(T__13);
			setState(270);
			((StructDeclarationContext)_localctx).structId = match(IDENTIFIER);
			setState(271);
			match(OBRACE);
			setState(275); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(272);
				((StructDeclarationContext)_localctx).variableDeclaration = variableDeclaration();
				((StructDeclarationContext)_localctx).decls.add(((StructDeclarationContext)_localctx).variableDeclaration);
				setState(273);
				match(SCOLON);
				}
				}
				setState(277); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==DATATYPE );
			setState(279);
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
		public Token type;
		public AssignmentsContext args;
		public ExpressionContext size;
		public TerminalNode OPAREN() { return getToken(EParser.OPAREN, 0); }
		public TerminalNode CPAREN() { return getToken(EParser.CPAREN, 0); }
		public TerminalNode DATATYPE() { return getToken(EParser.DATATYPE, 0); }
		public AssignmentsContext assignments() {
			return getRuleContext(AssignmentsContext.class,0);
		}
		public TerminalNode OBRACKET() { return getToken(EParser.OBRACKET, 0); }
		public TerminalNode CBRACKET() { return getToken(EParser.CBRACKET, 0); }
		public TerminalNode PRIMITIVE() { return getToken(EParser.PRIMITIVE, 0); }
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
		enterRule(_localctx, 44, RULE_structInitialization);
		try {
			setState(293);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(281);
				match(T__8);
				setState(282);
				((StructInitializationContext)_localctx).type = match(DATATYPE);
				setState(283);
				match(OPAREN);
				setState(284);
				((StructInitializationContext)_localctx).args = assignments();
				setState(285);
				match(CPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(287);
				match(T__8);
				setState(288);
				((StructInitializationContext)_localctx).type = match(PRIMITIVE);
				setState(289);
				match(OBRACKET);
				setState(290);
				((StructInitializationContext)_localctx).size = expression(0);
				setState(291);
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
		enterRule(_localctx, 46, RULE_assignments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(295);
			((AssignmentsContext)_localctx).expression = expression(0);
			((AssignmentsContext)_localctx).asgmts.add(((AssignmentsContext)_localctx).expression);
			setState(300);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(296);
				match(COMMA);
				setState(297);
				((AssignmentsContext)_localctx).expression = expression(0);
				((AssignmentsContext)_localctx).asgmts.add(((AssignmentsContext)_localctx).expression);
				}
				}
				setState(302);
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
	public static class IdentifierExpressionContext extends ExpressionContext {
		public Token varId;
		public TerminalNode IDENTIFIER() { return getToken(EParser.IDENTIFIER, 0); }
		public IdentifierExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EVisitor ) return ((EVisitor<? extends T>)visitor).visitIdentifierExpression(this);
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
		public TerminalNode DOUBLE() { return getToken(EParser.DOUBLE, 0); }
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
		int _startState = 48;
		enterRecursionRule(_localctx, 48, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(328);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				_localctx = new IncludedFunctionExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(304);
				includedFunctionCall();
				}
				break;
			case 2:
				{
				_localctx = new BuiltinFunctionExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(305);
				builtinFunctionCall();
				}
				break;
			case 3:
				{
				_localctx = new StructInitializationExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(306);
				structInitialization();
				}
				break;
			case 4:
				{
				_localctx = new ArrayExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(307);
				((ArrayExpressionContext)_localctx).varId = match(IDENTIFIER);
				setState(308);
				match(OPAREN);
				setState(309);
				((ArrayExpressionContext)_localctx).index = expression(0);
				setState(310);
				match(CPAREN);
				}
				break;
			case 5:
				{
				_localctx = new StructExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(312);
				((StructExpressionContext)_localctx).structId = match(IDENTIFIER);
				setState(313);
				match(DOT);
				setState(314);
				((StructExpressionContext)_localctx).varId = match(IDENTIFIER);
				}
				break;
			case 6:
				{
				_localctx = new StructArrayExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(315);
				((StructArrayExpressionContext)_localctx).structId = match(IDENTIFIER);
				setState(316);
				match(DOT);
				setState(317);
				((StructArrayExpressionContext)_localctx).varId = match(IDENTIFIER);
				setState(318);
				match(OPAREN);
				setState(319);
				((StructArrayExpressionContext)_localctx).index = expression(0);
				setState(320);
				match(CPAREN);
				}
				break;
			case 7:
				{
				_localctx = new FunctionExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(322);
				functionCall();
				}
				break;
			case 8:
				{
				_localctx = new IdentifierExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(323);
				((IdentifierExpressionContext)_localctx).varId = match(IDENTIFIER);
				}
				break;
			case 9:
				{
				_localctx = new BoolExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(324);
				((BoolExpressionContext)_localctx).bool = match(BOOL);
				}
				break;
			case 10:
				{
				_localctx = new IntegerExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(325);
				((IntegerExpressionContext)_localctx).number = match(INTEGER);
				}
				break;
			case 11:
				{
				_localctx = new FloatingPointExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(326);
				((FloatingPointExpressionContext)_localctx).number = match(DOUBLE);
				}
				break;
			case 12:
				{
				_localctx = new StringExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(327);
				((StringExpressionContext)_localctx).str = match(STRING);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(353);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(351);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
					case 1:
						{
						_localctx = new DivisionMultiplicationModuloExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(330);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(331);
						((DivisionMultiplicationModuloExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << T__16))) != 0)) ) {
							((DivisionMultiplicationModuloExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(332);
						expression(20);
						}
						break;
					case 2:
						{
						_localctx = new SubtractionAdditionExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(333);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(334);
						((SubtractionAdditionExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__17 || _la==T__18) ) {
							((SubtractionAdditionExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(335);
						expression(19);
						}
						break;
					case 3:
						{
						_localctx = new ShiftExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(336);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(337);
						((ShiftExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__19 || _la==T__20) ) {
							((ShiftExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(338);
						expression(18);
						}
						break;
					case 4:
						{
						_localctx = new RelationalExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(339);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(340);
						((RelationalExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26))) != 0)) ) {
							((RelationalExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(341);
						expression(17);
						}
						break;
					case 5:
						{
						_localctx = new ConjunctionExpressionContext(new ExpressionContext(_parentctx, _parentState));
						((ConjunctionExpressionContext)_localctx).lExpr = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(342);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(343);
						match(T__27);
						setState(344);
						((ConjunctionExpressionContext)_localctx).rExpr = expression(16);
						}
						break;
					case 6:
						{
						_localctx = new DisjunctionExpressionContext(new ExpressionContext(_parentctx, _parentState));
						((DisjunctionExpressionContext)_localctx).lExpr = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(345);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(346);
						match(T__28);
						setState(347);
						((DisjunctionExpressionContext)_localctx).rExpr = expression(15);
						}
						break;
					case 7:
						{
						_localctx = new ContravalenceExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(348);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(349);
						match(T__29);
						setState(350);
						expression(14);
						}
						break;
					}
					} 
				}
				setState(355);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 24:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\65\u0167\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\3\2\7\2\66\n\2\f\2\16\29\13\2\3\2\6\2<\n\2\r\2\16\2=\3\2\3"+
		"\2\3\3\3\3\3\3\6\3E\n\3\r\3\16\3F\3\3\3\3\7\3K\n\3\f\3\16\3N\13\3\7\3"+
		"P\n\3\f\3\16\3S\13\3\3\3\3\3\3\4\3\4\3\4\7\4Z\n\4\f\4\16\4]\13\4\3\5\3"+
		"\5\3\5\5\5b\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6|\n\6\3\7\3\7\3\7\3\7\3"+
		"\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\5\t\u008c\n\t\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0099\n\n\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00a9\n\13\3\f\3\f\3\f\3"+
		"\f\3\f\3\r\3\r\3\r\7\r\u00b3\n\r\f\r\16\r\u00b6\13\r\3\r\5\r\u00b9\n\r"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00c2\n\16\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\20\3\20\3\20\3\20\3\21\7\21\u00cf\n\21\f\21\16\21\u00d2\13"+
		"\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\7\22\u00dd\n\22\f\22"+
		"\16\22\u00e0\13\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00e9\n\22"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26"+
		"\3\26\7\26\u0108\n\26\f\26\16\26\u010b\13\26\3\26\5\26\u010e\n\26\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\6\27\u0116\n\27\r\27\16\27\u0117\3\27\3\27\3"+
		"\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u0128"+
		"\n\30\3\31\3\31\3\31\7\31\u012d\n\31\f\31\16\31\u0130\13\31\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u014b\n\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\7\32\u0162\n\32\f\32\16\32\u0165\13\32\3\32"+
		"\2\3\62\33\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\2\6\3"+
		"\2\21\23\3\2\24\25\3\2\26\27\3\2\30\35\2\u0182\2\67\3\2\2\2\4A\3\2\2\2"+
		"\6V\3\2\2\2\ba\3\2\2\2\n{\3\2\2\2\f}\3\2\2\2\16\u0082\3\2\2\2\20\u0087"+
		"\3\2\2\2\22\u0098\3\2\2\2\24\u00a8\3\2\2\2\26\u00aa\3\2\2\2\30\u00b8\3"+
		"\2\2\2\32\u00ba\3\2\2\2\34\u00c3\3\2\2\2\36\u00c9\3\2\2\2 \u00d0\3\2\2"+
		"\2\"\u00e8\3\2\2\2$\u00ea\3\2\2\2&\u00f3\3\2\2\2(\u00f8\3\2\2\2*\u010d"+
		"\3\2\2\2,\u010f\3\2\2\2.\u0127\3\2\2\2\60\u0129\3\2\2\2\62\u014a\3\2\2"+
		"\2\64\66\5\4\3\2\65\64\3\2\2\2\669\3\2\2\2\67\65\3\2\2\2\678\3\2\2\28"+
		";\3\2\2\29\67\3\2\2\2:<\5\b\5\2;:\3\2\2\2<=\3\2\2\2=;\3\2\2\2=>\3\2\2"+
		"\2>?\3\2\2\2?@\7\2\2\3@\3\3\2\2\2AB\7\3\2\2BD\7\60\2\2CE\5\6\4\2DC\3\2"+
		"\2\2EF\3\2\2\2FD\3\2\2\2FG\3\2\2\2GQ\3\2\2\2HL\7-\2\2IK\5\6\4\2JI\3\2"+
		"\2\2KN\3\2\2\2LJ\3\2\2\2LM\3\2\2\2MP\3\2\2\2NL\3\2\2\2OH\3\2\2\2PS\3\2"+
		"\2\2QO\3\2\2\2QR\3\2\2\2RT\3\2\2\2SQ\3\2\2\2TU\7\61\2\2U\5\3\2\2\2V[\7"+
		"\'\2\2WX\7,\2\2XZ\7\'\2\2YW\3\2\2\2Z]\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2\\\7"+
		"\3\2\2\2][\3\2\2\2^b\5\n\6\2_b\5(\25\2`b\5,\27\2a^\3\2\2\2a_\3\2\2\2a"+
		"`\3\2\2\2b\t\3\2\2\2cd\5\f\7\2de\7+\2\2e|\3\2\2\2fg\5\16\b\2gh\7+\2\2"+
		"h|\3\2\2\2ij\5\20\t\2jk\7+\2\2k|\3\2\2\2lm\5\22\n\2mn\7+\2\2n|\3\2\2\2"+
		"op\5\26\f\2pq\7+\2\2q|\3\2\2\2r|\5\32\16\2s|\5\34\17\2tu\5$\23\2uv\7+"+
		"\2\2v|\3\2\2\2wx\5&\24\2xy\7+\2\2y|\3\2\2\2z|\5\"\22\2{c\3\2\2\2{f\3\2"+
		"\2\2{i\3\2\2\2{l\3\2\2\2{o\3\2\2\2{r\3\2\2\2{s\3\2\2\2{t\3\2\2\2{w\3\2"+
		"\2\2{z\3\2\2\2|\13\3\2\2\2}~\7\4\2\2~\177\7\60\2\2\177\u0080\5\62\32\2"+
		"\u0080\u0081\7\61\2\2\u0081\r\3\2\2\2\u0082\u0083\7\5\2\2\u0083\u0084"+
		"\7\60\2\2\u0084\u0085\5\62\32\2\u0085\u0086\7\61\2\2\u0086\17\3\2\2\2"+
		"\u0087\u0088\7!\2\2\u0088\u008b\7\'\2\2\u0089\u008a\7.\2\2\u008a\u008c"+
		"\5\62\32\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\21\3\2\2\2\u008d"+
		"\u008e\7\'\2\2\u008e\u008f\7.\2\2\u008f\u0099\5\62\32\2\u0090\u0091\7"+
		"\'\2\2\u0091\u0092\7\64\2\2\u0092\u0093\5\62\32\2\u0093\u0094\7\65\2\2"+
		"\u0094\u0095\7.\2\2\u0095\u0096\5\62\32\2\u0096\u0099\3\2\2\2\u0097\u0099"+
		"\5\24\13\2\u0098\u008d\3\2\2\2\u0098\u0090\3\2\2\2\u0098\u0097\3\2\2\2"+
		"\u0099\23\3\2\2\2\u009a\u009b\7\'\2\2\u009b\u009c\7,\2\2\u009c\u009d\7"+
		"\'\2\2\u009d\u009e\7.\2\2\u009e\u00a9\5\62\32\2\u009f\u00a0\7\'\2\2\u00a0"+
		"\u00a1\7,\2\2\u00a1\u00a2\7\'\2\2\u00a2\u00a3\7\64\2\2\u00a3\u00a4\5\62"+
		"\32\2\u00a4\u00a5\7\65\2\2\u00a5\u00a6\7.\2\2\u00a6\u00a7\5\62\32\2\u00a7"+
		"\u00a9\3\2\2\2\u00a8\u009a\3\2\2\2\u00a8\u009f\3\2\2\2\u00a9\25\3\2\2"+
		"\2\u00aa\u00ab\7\'\2\2\u00ab\u00ac\7\60\2\2\u00ac\u00ad\5\30\r\2\u00ad"+
		"\u00ae\7\61\2\2\u00ae\27\3\2\2\2\u00af\u00b4\5\62\32\2\u00b0\u00b1\7-"+
		"\2\2\u00b1\u00b3\5\62\32\2\u00b2\u00b0\3\2\2\2\u00b3\u00b6\3\2\2\2\u00b4"+
		"\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b9\3\2\2\2\u00b6\u00b4\3\2"+
		"\2\2\u00b7\u00b9\3\2\2\2\u00b8\u00af\3\2\2\2\u00b8\u00b7\3\2\2\2\u00b9"+
		"\31\3\2\2\2\u00ba\u00bb\7\6\2\2\u00bb\u00bc\7\60\2\2\u00bc\u00bd\5\62"+
		"\32\2\u00bd\u00be\7\61\2\2\u00be\u00c1\5\36\20\2\u00bf\u00c0\7\7\2\2\u00c0"+
		"\u00c2\5\36\20\2\u00c1\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\33\3\2"+
		"\2\2\u00c3\u00c4\7\b\2\2\u00c4\u00c5\7\60\2\2\u00c5\u00c6\5\62\32\2\u00c6"+
		"\u00c7\7\61\2\2\u00c7\u00c8\5\36\20\2\u00c8\35\3\2\2\2\u00c9\u00ca\7\62"+
		"\2\2\u00ca\u00cb\5 \21\2\u00cb\u00cc\7\63\2\2\u00cc\37\3\2\2\2\u00cd\u00cf"+
		"\5\n\6\2\u00ce\u00cd\3\2\2\2\u00cf\u00d2\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d0"+
		"\u00d1\3\2\2\2\u00d1!\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d3\u00d4\7\t\2\2"+
		"\u00d4\u00d5\7\62\2\2\u00d5\u00d6\7&\2\2\u00d6\u00e9\7\63\2\2\u00d7\u00d8"+
		"\7\n\2\2\u00d8\u00d9\7&\2\2\u00d9\u00da\7&\2\2\u00da\u00de\7\60\2\2\u00db"+
		"\u00dd\7&\2\2\u00dc\u00db\3\2\2\2\u00dd\u00e0\3\2\2\2\u00de\u00dc\3\2"+
		"\2\2\u00de\u00df\3\2\2\2\u00df\u00e1\3\2\2\2\u00e0\u00de\3\2\2\2\u00e1"+
		"\u00e9\7\61\2\2\u00e2\u00e3\7\13\2\2\u00e3\u00e9\7&\2\2\u00e4\u00e5\7"+
		"\f\2\2\u00e5\u00e9\5\62\32\2\u00e6\u00e7\7\r\2\2\u00e7\u00e9\7&\2\2\u00e8"+
		"\u00d3\3\2\2\2\u00e8\u00d7\3\2\2\2\u00e8\u00e2\3\2\2\2\u00e8\u00e4\3\2"+
		"\2\2\u00e8\u00e6\3\2\2\2\u00e9#\3\2\2\2\u00ea\u00eb\7\'\2\2\u00eb\u00ec"+
		"\7,\2\2\u00ec\u00ed\7\'\2\2\u00ed\u00ee\7\60\2\2\u00ee\u00ef\5\30\r\2"+
		"\u00ef\u00f0\7\61\2\2\u00f0\u00f1\7\16\2\2\u00f1\u00f2\7!\2\2\u00f2%\3"+
		"\2\2\2\u00f3\u00f4\7(\2\2\u00f4\u00f5\7\60\2\2\u00f5\u00f6\5\30\r\2\u00f6"+
		"\u00f7\7\61\2\2\u00f7\'\3\2\2\2\u00f8\u00f9\7!\2\2\u00f9\u00fa\7\'\2\2"+
		"\u00fa\u00fb\7\60\2\2\u00fb\u00fc\5*\26\2\u00fc\u00fd\7\61\2\2\u00fd\u00fe"+
		"\7\62\2\2\u00fe\u00ff\5 \21\2\u00ff\u0100\7\17\2\2\u0100\u0101\5\62\32"+
		"\2\u0101\u0102\7+\2\2\u0102\u0103\7\63\2\2\u0103)\3\2\2\2\u0104\u0109"+
		"\5\20\t\2\u0105\u0106\7-\2\2\u0106\u0108\5\20\t\2\u0107\u0105\3\2\2\2"+
		"\u0108\u010b\3\2\2\2\u0109\u0107\3\2\2\2\u0109\u010a\3\2\2\2\u010a\u010e"+
		"\3\2\2\2\u010b\u0109\3\2\2\2\u010c\u010e\3\2\2\2\u010d\u0104\3\2\2\2\u010d"+
		"\u010c\3\2\2\2\u010e+\3\2\2\2\u010f\u0110\7\20\2\2\u0110\u0111\7\'\2\2"+
		"\u0111\u0115\7\62\2\2\u0112\u0113\5\20\t\2\u0113\u0114\7+\2\2\u0114\u0116"+
		"\3\2\2\2\u0115\u0112\3\2\2\2\u0116\u0117\3\2\2\2\u0117\u0115\3\2\2\2\u0117"+
		"\u0118\3\2\2\2\u0118\u0119\3\2\2\2\u0119\u011a\7\63\2\2\u011a-\3\2\2\2"+
		"\u011b\u011c\7\13\2\2\u011c\u011d\7!\2\2\u011d\u011e\7\60\2\2\u011e\u011f"+
		"\5\60\31\2\u011f\u0120\7\61\2\2\u0120\u0128\3\2\2\2\u0121\u0122\7\13\2"+
		"\2\u0122\u0123\7\"\2\2\u0123\u0124\7\64\2\2\u0124\u0125\5\62\32\2\u0125"+
		"\u0126\7\65\2\2\u0126\u0128\3\2\2\2\u0127\u011b\3\2\2\2\u0127\u0121\3"+
		"\2\2\2\u0128/\3\2\2\2\u0129\u012e\5\62\32\2\u012a\u012b\7-\2\2\u012b\u012d"+
		"\5\62\32\2\u012c\u012a\3\2\2\2\u012d\u0130\3\2\2\2\u012e\u012c\3\2\2\2"+
		"\u012e\u012f\3\2\2\2\u012f\61\3\2\2\2\u0130\u012e\3\2\2\2\u0131\u0132"+
		"\b\32\1\2\u0132\u014b\5$\23\2\u0133\u014b\5&\24\2\u0134\u014b\5.\30\2"+
		"\u0135\u0136\7\'\2\2\u0136\u0137\7\60\2\2\u0137\u0138\5\62\32\2\u0138"+
		"\u0139\7\61\2\2\u0139\u014b\3\2\2\2\u013a\u013b\7\'\2\2\u013b\u013c\7"+
		",\2\2\u013c\u014b\7\'\2\2\u013d\u013e\7\'\2\2\u013e\u013f\7,\2\2\u013f"+
		"\u0140\7\'\2\2\u0140\u0141\7\60\2\2\u0141\u0142\5\62\32\2\u0142\u0143"+
		"\7\61\2\2\u0143\u014b\3\2\2\2\u0144\u014b\5\26\f\2\u0145\u014b\7\'\2\2"+
		"\u0146\u014b\7#\2\2\u0147\u014b\7$\2\2\u0148\u014b\7%\2\2\u0149\u014b"+
		"\7&\2\2\u014a\u0131\3\2\2\2\u014a\u0133\3\2\2\2\u014a\u0134\3\2\2\2\u014a"+
		"\u0135\3\2\2\2\u014a\u013a\3\2\2\2\u014a\u013d\3\2\2\2\u014a\u0144\3\2"+
		"\2\2\u014a\u0145\3\2\2\2\u014a\u0146\3\2\2\2\u014a\u0147\3\2\2\2\u014a"+
		"\u0148\3\2\2\2\u014a\u0149\3\2\2\2\u014b\u0163\3\2\2\2\u014c\u014d\f\25"+
		"\2\2\u014d\u014e\t\2\2\2\u014e\u0162\5\62\32\26\u014f\u0150\f\24\2\2\u0150"+
		"\u0151\t\3\2\2\u0151\u0162\5\62\32\25\u0152\u0153\f\23\2\2\u0153\u0154"+
		"\t\4\2\2\u0154\u0162\5\62\32\24\u0155\u0156\f\22\2\2\u0156\u0157\t\5\2"+
		"\2\u0157\u0162\5\62\32\23\u0158\u0159\f\21\2\2\u0159\u015a\7\36\2\2\u015a"+
		"\u0162\5\62\32\22\u015b\u015c\f\20\2\2\u015c\u015d\7\37\2\2\u015d\u0162"+
		"\5\62\32\21\u015e\u015f\f\17\2\2\u015f\u0160\7 \2\2\u0160\u0162\5\62\32"+
		"\20\u0161\u014c\3\2\2\2\u0161\u014f\3\2\2\2\u0161\u0152\3\2\2\2\u0161"+
		"\u0155\3\2\2\2\u0161\u0158\3\2\2\2\u0161\u015b\3\2\2\2\u0161\u015e\3\2"+
		"\2\2\u0162\u0165\3\2\2\2\u0163\u0161\3\2\2\2\u0163\u0164\3\2\2\2\u0164"+
		"\63\3\2\2\2\u0165\u0163\3\2\2\2\33\67=FLQ[a{\u008b\u0098\u00a8\u00b4\u00b8"+
		"\u00c1\u00d0\u00de\u00e8\u0109\u010d\u0117\u0127\u012e\u014a\u0161\u0163";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}