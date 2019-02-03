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
		T__38=39, BUILTINFUNCTION=40, BOOL=41, INTEGER=42, FLOAT=43, STRING=44, 
		IDENTIFIER=45, COMMENT=46, WHITESPACE=47, SCOLON=48, DOT=49, COMMA=50, 
		ASSIGN=51, QMARK=52, OPAREN=53, CPAREN=54, OBRACE=55, CBRACE=56, OBRACKET=57, 
		CBRACKET=58, OCBRACKET=59;
	public static final int
		RULE_program = 0, RULE_includes = 1, RULE_module = 2, RULE_noMain = 3, 
		RULE_command = 4, RULE_statement = 5, RULE_print = 6, RULE_printLine = 7, 
		RULE_variableDeclaration = 8, RULE_assignment = 9, RULE_structVariableAssignment = 10, 
		RULE_functionCall = 11, RULE_branch = 12, RULE_loop = 13, RULE_assembly = 14, 
		RULE_jvmType = 15, RULE_includedFunctionCall = 16, RULE_builtinFunctionCall = 17, 
		RULE_functionDefinition = 18, RULE_structDeclaration = 19, RULE_structArrayInitialization = 20, 
		RULE_assignments = 21, RULE_expression = 22, RULE_currentParameters = 23, 
		RULE_block = 24, RULE_statements = 25, RULE_formalParameters = 26, RULE_dataType = 27, 
		RULE_primitive = 28;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "includes", "module", "noMain", "command", "statement", "print", 
			"printLine", "variableDeclaration", "assignment", "structVariableAssignment", 
			"functionCall", "branch", "loop", "assembly", "jvmType", "includedFunctionCall", 
			"builtinFunctionCall", "functionDefinition", "structDeclaration", "structArrayInitialization", 
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
			"'||'", "'^'", "'topOfStack'", "'bool'", "'int'", "'float'", "'String'", 
			"'void'", null, null, null, null, null, null, null, null, "';'", "'.'", 
			"','", "'='", "'\"'", "'('", "')'", "'{'", "'}'", "'['", "']'", "'[]'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "BUILTINFUNCTION", "BOOL", "INTEGER", "FLOAT", 
			"STRING", "IDENTIFIER", "COMMENT", "WHITESPACE", "SCOLON", "DOT", "COMMA", 
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
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(58);
				((ProgramContext)_localctx).includes = includes();
				((ProgramContext)_localctx).incls.add(((ProgramContext)_localctx).includes);
				}
				}
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(64);
				((ProgramContext)_localctx).noMain = noMain();
				((ProgramContext)_localctx).noMains.add(((ProgramContext)_localctx).noMain);
				}
				}
				setState(69);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(71); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(70);
				command();
				}
				}
				setState(73); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__15) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << BUILTINFUNCTION) | (1L << IDENTIFIER))) != 0) );
			setState(75);
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
			setState(77);
			match(T__0);
			setState(78);
			match(OPAREN);
			setState(80); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(79);
				((IncludesContext)_localctx).module = module();
				((IncludesContext)_localctx).mods.add(((IncludesContext)_localctx).module);
				}
				}
				setState(82); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IDENTIFIER );
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(84);
				match(COMMA);
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==IDENTIFIER) {
					{
					{
					setState(85);
					((IncludesContext)_localctx).module = module();
					((IncludesContext)_localctx).mods.add(((IncludesContext)_localctx).module);
					}
					}
					setState(90);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(96);
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
			setState(98);
			match(IDENTIFIER);
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(99);
				match(DOT);
				setState(100);
				match(IDENTIFIER);
				}
				}
				setState(105);
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
			setState(106);
			match(T__1);
			setState(107);
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
			setState(112);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new StatementCommandContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(109);
				statement();
				}
				break;
			case 2:
				_localctx = new FunctionDefinitionCommandContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(110);
				functionDefinition();
				}
				break;
			case 3:
				_localctx = new StructDeclarationCommandContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(111);
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
			setState(138);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(114);
				print();
				setState(115);
				match(SCOLON);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(117);
				printLine();
				setState(118);
				match(SCOLON);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(120);
				variableDeclaration();
				setState(121);
				match(SCOLON);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(123);
				assignment();
				setState(124);
				match(SCOLON);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(126);
				functionCall();
				setState(127);
				match(SCOLON);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(129);
				branch();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(130);
				loop();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(131);
				includedFunctionCall();
				setState(132);
				match(SCOLON);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(134);
				builtinFunctionCall();
				setState(135);
				match(SCOLON);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(137);
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
			setState(140);
			match(T__3);
			setState(141);
			match(OPAREN);
			setState(142);
			((PrintContext)_localctx).arg = expression(0);
			setState(143);
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
			setState(145);
			match(T__4);
			setState(146);
			match(OPAREN);
			setState(147);
			((PrintLineContext)_localctx).arg = expression(0);
			setState(148);
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
			setState(150);
			((VariableDeclarationContext)_localctx).type = dataType();
			setState(151);
			((VariableDeclarationContext)_localctx).varId = match(IDENTIFIER);
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(152);
				match(ASSIGN);
				setState(153);
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
			setState(167);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(156);
				((AssignmentContext)_localctx).varId = match(IDENTIFIER);
				setState(157);
				match(ASSIGN);
				setState(158);
				((AssignmentContext)_localctx).expr = expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(159);
				((AssignmentContext)_localctx).varId = match(IDENTIFIER);
				setState(160);
				match(OBRACKET);
				setState(161);
				((AssignmentContext)_localctx).index = expression(0);
				setState(162);
				match(CBRACKET);
				setState(163);
				match(ASSIGN);
				setState(164);
				((AssignmentContext)_localctx).expr = expression(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(166);
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
		public Token varId;
		public Token structVarId;
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
			setState(183);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(169);
				((StructVariableAssignmentContext)_localctx).varId = match(IDENTIFIER);
				setState(170);
				match(DOT);
				setState(171);
				((StructVariableAssignmentContext)_localctx).structVarId = match(IDENTIFIER);
				setState(172);
				match(ASSIGN);
				setState(173);
				((StructVariableAssignmentContext)_localctx).expr = expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(174);
				((StructVariableAssignmentContext)_localctx).varId = match(IDENTIFIER);
				setState(175);
				match(DOT);
				setState(176);
				((StructVariableAssignmentContext)_localctx).structVarId = match(IDENTIFIER);
				setState(177);
				match(OBRACKET);
				setState(178);
				((StructVariableAssignmentContext)_localctx).index = expression(0);
				setState(179);
				match(CBRACKET);
				setState(180);
				match(ASSIGN);
				setState(181);
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
			setState(185);
			((FunctionCallContext)_localctx).funcId = match(IDENTIFIER);
			setState(186);
			match(OPAREN);
			setState(187);
			((FunctionCallContext)_localctx).currentParams = currentParameters();
			setState(188);
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
			setState(190);
			match(T__5);
			setState(191);
			match(OPAREN);
			setState(192);
			((BranchContext)_localctx).cond = expression(0);
			setState(193);
			match(CPAREN);
			setState(194);
			((BranchContext)_localctx).onTrue = block();
			setState(197);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(195);
				match(T__6);
				setState(196);
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
			setState(199);
			match(T__7);
			setState(200);
			match(OPAREN);
			setState(201);
			((LoopContext)_localctx).cond = expression(0);
			setState(202);
			match(CPAREN);
			setState(203);
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
		public TerminalNode SCOLON() { return getToken(EParser.SCOLON, 0); }
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
		public TerminalNode SCOLON() { return getToken(EParser.SCOLON, 0); }
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
		public TerminalNode SCOLON() { return getToken(EParser.SCOLON, 0); }
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
		public JvmTypeContext jvmType;
		public List<JvmTypeContext> args = new ArrayList<JvmTypeContext>();
		public Token returnType;
		public TerminalNode OPAREN() { return getToken(EParser.OPAREN, 0); }
		public TerminalNode CPAREN() { return getToken(EParser.CPAREN, 0); }
		public TerminalNode SCOLON() { return getToken(EParser.SCOLON, 0); }
		public List<TerminalNode> STRING() { return getTokens(EParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(EParser.STRING, i);
		}
		public List<JvmTypeContext> jvmType() {
			return getRuleContexts(JvmTypeContext.class);
		}
		public JvmTypeContext jvmType(int i) {
			return getRuleContext(JvmTypeContext.class,i);
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
			setState(232);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__8:
				_localctx = new InlineAssemblyContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(205);
				match(T__8);
				setState(206);
				match(OBRACE);
				setState(207);
				((InlineAssemblyContext)_localctx).str = match(STRING);
				setState(208);
				match(CBRACE);
				}
				break;
			case T__9:
				_localctx = new InvokeAssemblyContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(209);
				match(T__9);
				setState(210);
				((InvokeAssemblyContext)_localctx).mod = match(STRING);
				setState(211);
				((InvokeAssemblyContext)_localctx).id = match(STRING);
				setState(212);
				match(OPAREN);
				setState(216);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==STRING) {
					{
					{
					setState(213);
					((InvokeAssemblyContext)_localctx).jvmType = jvmType();
					((InvokeAssemblyContext)_localctx).args.add(((InvokeAssemblyContext)_localctx).jvmType);
					}
					}
					setState(218);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(219);
				match(CPAREN);
				setState(220);
				((InvokeAssemblyContext)_localctx).returnType = match(STRING);
				setState(221);
				match(SCOLON);
				}
				break;
			case T__10:
				_localctx = new InitObjectContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(222);
				match(T__10);
				setState(223);
				((InitObjectContext)_localctx).type = match(STRING);
				setState(224);
				match(SCOLON);
				}
				break;
			case T__11:
				_localctx = new PushToStackContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(225);
				match(T__11);
				setState(226);
				expression(0);
				setState(227);
				match(SCOLON);
				}
				break;
			case T__12:
				_localctx = new SetTopOfStackContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(229);
				match(T__12);
				setState(230);
				((SetTopOfStackContext)_localctx).type = match(STRING);
				setState(231);
				match(SCOLON);
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

	public static class JvmTypeContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(EParser.STRING, 0); }
		public JvmTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jvmType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EVisitor ) return ((EVisitor<? extends T>)visitor).visitJvmType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JvmTypeContext jvmType() throws RecognitionException {
		JvmTypeContext _localctx = new JvmTypeContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_jvmType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			match(STRING);
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
		enterRule(_localctx, 32, RULE_includedFunctionCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			((IncludedFunctionCallContext)_localctx).inclDir = match(IDENTIFIER);
			setState(237);
			match(DOT);
			setState(238);
			((IncludedFunctionCallContext)_localctx).funcId = match(IDENTIFIER);
			setState(239);
			match(OPAREN);
			setState(240);
			((IncludedFunctionCallContext)_localctx).args = currentParameters();
			setState(241);
			match(CPAREN);
			setState(242);
			match(T__13);
			setState(243);
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
		public CurrentParametersContext currentParams;
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
		enterRule(_localctx, 34, RULE_builtinFunctionCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
			((BuiltinFunctionCallContext)_localctx).funcId = match(BUILTINFUNCTION);
			setState(246);
			match(OPAREN);
			setState(247);
			((BuiltinFunctionCallContext)_localctx).currentParams = currentParameters();
			setState(248);
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
		enterRule(_localctx, 36, RULE_functionDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			((FunctionDefinitionContext)_localctx).type = dataType();
			setState(251);
			((FunctionDefinitionContext)_localctx).funcId = match(IDENTIFIER);
			setState(252);
			match(OPAREN);
			setState(253);
			((FunctionDefinitionContext)_localctx).formalParams = formalParameters();
			setState(254);
			match(CPAREN);
			setState(255);
			match(OBRACE);
			setState(256);
			((FunctionDefinitionContext)_localctx).stmts = statements();
			setState(261);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(257);
				match(T__14);
				setState(258);
				((FunctionDefinitionContext)_localctx).returnVal = expression(0);
				setState(259);
				match(SCOLON);
				}
			}

			setState(263);
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
		enterRule(_localctx, 38, RULE_structDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
			match(T__15);
			setState(266);
			((StructDeclarationContext)_localctx).structId = match(IDENTIFIER);
			setState(267);
			match(OBRACE);
			setState(271); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(268);
				((StructDeclarationContext)_localctx).variableDeclaration = variableDeclaration();
				((StructDeclarationContext)_localctx).decls.add(((StructDeclarationContext)_localctx).variableDeclaration);
				setState(269);
				match(SCOLON);
				}
				}
				setState(273); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << IDENTIFIER))) != 0) );
			setState(275);
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

	public static class StructArrayInitializationContext extends ParserRuleContext {
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
		public StructArrayInitializationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structArrayInitialization; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EVisitor ) return ((EVisitor<? extends T>)visitor).visitStructArrayInitialization(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructArrayInitializationContext structArrayInitialization() throws RecognitionException {
		StructArrayInitializationContext _localctx = new StructArrayInitializationContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_structArrayInitialization);
		try {
			setState(289);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(277);
				match(T__10);
				setState(278);
				((StructArrayInitializationContext)_localctx).object = dataType();
				setState(279);
				match(OPAREN);
				setState(280);
				((StructArrayInitializationContext)_localctx).args = assignments();
				setState(281);
				match(CPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(283);
				match(T__10);
				setState(284);
				((StructArrayInitializationContext)_localctx).type = primitive();
				setState(285);
				match(OBRACKET);
				setState(286);
				((StructArrayInitializationContext)_localctx).size = expression(0);
				setState(287);
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
		enterRule(_localctx, 42, RULE_assignments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291);
			((AssignmentsContext)_localctx).expression = expression(0);
			((AssignmentsContext)_localctx).asgmts.add(((AssignmentsContext)_localctx).expression);
			setState(296);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(292);
				match(COMMA);
				setState(293);
				((AssignmentsContext)_localctx).expression = expression(0);
				((AssignmentsContext)_localctx).asgmts.add(((AssignmentsContext)_localctx).expression);
				}
				}
				setState(298);
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
		public TerminalNode OBRACKET() { return getToken(EParser.OBRACKET, 0); }
		public TerminalNode CBRACKET() { return getToken(EParser.CBRACKET, 0); }
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
	public static class TopOfStackContext extends ExpressionContext {
		public TopOfStackContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EVisitor ) return ((EVisitor<? extends T>)visitor).visitTopOfStack(this);
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
		public TerminalNode OBRACKET() { return getToken(EParser.OBRACKET, 0); }
		public TerminalNode CBRACKET() { return getToken(EParser.CBRACKET, 0); }
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
	public static class StructArrayInitializationExpressionContext extends ExpressionContext {
		public StructArrayInitializationContext structArrayInitialization() {
			return getRuleContext(StructArrayInitializationContext.class,0);
		}
		public StructArrayInitializationExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EVisitor ) return ((EVisitor<? extends T>)visitor).visitStructArrayInitializationExpression(this);
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
		int _startState = 44;
		enterRecursionRule(_localctx, 44, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(327);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				_localctx = new NegationExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(300);
				match(T__16);
				setState(301);
				expression(21);
				}
				break;
			case 2:
				{
				_localctx = new StructExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(302);
				((StructExpressionContext)_localctx).structId = match(IDENTIFIER);
				setState(303);
				match(DOT);
				setState(304);
				((StructExpressionContext)_localctx).varId = match(IDENTIFIER);
				}
				break;
			case 3:
				{
				_localctx = new ArrayExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(305);
				((ArrayExpressionContext)_localctx).varId = match(IDENTIFIER);
				setState(306);
				match(OBRACKET);
				setState(307);
				((ArrayExpressionContext)_localctx).index = expression(0);
				setState(308);
				match(CBRACKET);
				}
				break;
			case 4:
				{
				_localctx = new StructArrayExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(310);
				((StructArrayExpressionContext)_localctx).structId = match(IDENTIFIER);
				setState(311);
				match(DOT);
				setState(312);
				((StructArrayExpressionContext)_localctx).varId = match(IDENTIFIER);
				setState(313);
				match(OBRACKET);
				setState(314);
				((StructArrayExpressionContext)_localctx).index = expression(0);
				setState(315);
				match(CBRACKET);
				}
				break;
			case 5:
				{
				_localctx = new StructArrayInitializationExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(317);
				structArrayInitialization();
				}
				break;
			case 6:
				{
				_localctx = new BoolExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(318);
				((BoolExpressionContext)_localctx).bool = match(BOOL);
				}
				break;
			case 7:
				{
				_localctx = new IntegerExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(319);
				((IntegerExpressionContext)_localctx).number = match(INTEGER);
				}
				break;
			case 8:
				{
				_localctx = new FloatingPointExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(320);
				((FloatingPointExpressionContext)_localctx).number = match(FLOAT);
				}
				break;
			case 9:
				{
				_localctx = new StringExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(321);
				((StringExpressionContext)_localctx).str = match(STRING);
				}
				break;
			case 10:
				{
				_localctx = new VariableExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(322);
				((VariableExpressionContext)_localctx).varId = match(IDENTIFIER);
				}
				break;
			case 11:
				{
				_localctx = new BuiltinFunctionExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(323);
				builtinFunctionCall();
				}
				break;
			case 12:
				{
				_localctx = new FunctionExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(324);
				functionCall();
				}
				break;
			case 13:
				{
				_localctx = new IncludedFunctionExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(325);
				includedFunctionCall();
				}
				break;
			case 14:
				{
				_localctx = new TopOfStackContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(326);
				match(T__33);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(352);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(350);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
					case 1:
						{
						_localctx = new DivisionMultiplicationModuloExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(329);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(330);
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
						setState(331);
						expression(21);
						}
						break;
					case 2:
						{
						_localctx = new SubtractionAdditionExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(332);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(333);
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
						setState(334);
						expression(20);
						}
						break;
					case 3:
						{
						_localctx = new ShiftExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(335);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(336);
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
						setState(337);
						expression(19);
						}
						break;
					case 4:
						{
						_localctx = new RelationalExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(338);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(339);
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
						setState(340);
						expression(18);
						}
						break;
					case 5:
						{
						_localctx = new ConjunctionExpressionContext(new ExpressionContext(_parentctx, _parentState));
						((ConjunctionExpressionContext)_localctx).lExpr = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(341);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(342);
						match(T__30);
						setState(343);
						((ConjunctionExpressionContext)_localctx).rExpr = expression(17);
						}
						break;
					case 6:
						{
						_localctx = new DisjunctionExpressionContext(new ExpressionContext(_parentctx, _parentState));
						((DisjunctionExpressionContext)_localctx).lExpr = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(344);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(345);
						match(T__31);
						setState(346);
						((DisjunctionExpressionContext)_localctx).rExpr = expression(16);
						}
						break;
					case 7:
						{
						_localctx = new ContravalenceExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(347);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(348);
						match(T__32);
						setState(349);
						expression(15);
						}
						break;
					}
					} 
				}
				setState(354);
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
		enterRule(_localctx, 46, RULE_currentParameters);
		int _la;
		try {
			setState(364);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
			case T__16:
			case T__33:
			case BUILTINFUNCTION:
			case BOOL:
			case INTEGER:
			case FLOAT:
			case STRING:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(355);
				((CurrentParametersContext)_localctx).expression = expression(0);
				((CurrentParametersContext)_localctx).exprs.add(((CurrentParametersContext)_localctx).expression);
				setState(360);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(356);
					match(COMMA);
					setState(357);
					((CurrentParametersContext)_localctx).expression = expression(0);
					((CurrentParametersContext)_localctx).exprs.add(((CurrentParametersContext)_localctx).expression);
					}
					}
					setState(362);
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
		enterRule(_localctx, 48, RULE_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(366);
			match(OBRACE);
			setState(367);
			statements();
			setState(368);
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
		enterRule(_localctx, 50, RULE_statements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(373);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << BUILTINFUNCTION) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(370);
				statement();
				}
				}
				setState(375);
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
		enterRule(_localctx, 52, RULE_formalParameters);
		int _la;
		try {
			setState(385);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__34:
			case T__35:
			case T__36:
			case T__37:
			case T__38:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(376);
				((FormalParametersContext)_localctx).variableDeclaration = variableDeclaration();
				((FormalParametersContext)_localctx).decls.add(((FormalParametersContext)_localctx).variableDeclaration);
				setState(381);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(377);
					match(COMMA);
					setState(378);
					((FormalParametersContext)_localctx).variableDeclaration = variableDeclaration();
					((FormalParametersContext)_localctx).decls.add(((FormalParametersContext)_localctx).variableDeclaration);
					}
					}
					setState(383);
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
		enterRule(_localctx, 54, RULE_dataType);
		try {
			setState(395);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__34:
			case T__35:
			case T__36:
			case T__37:
			case T__38:
				enterOuterAlt(_localctx, 1);
				{
				setState(387);
				primitive();
				setState(389);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
				case 1:
					{
					setState(388);
					match(OCBRACKET);
					}
					break;
				}
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(391);
				match(IDENTIFIER);
				setState(393);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
				case 1:
					{
					setState(392);
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
		enterRule(_localctx, 56, RULE_primitive);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(397);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38))) != 0)) ) {
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
		case 22:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 20);
		case 1:
			return precpred(_ctx, 19);
		case 2:
			return precpred(_ctx, 18);
		case 3:
			return precpred(_ctx, 17);
		case 4:
			return precpred(_ctx, 16);
		case 5:
			return precpred(_ctx, 15);
		case 6:
			return precpred(_ctx, 14);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3=\u0192\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\7\2>\n\2\f\2\16"+
		"\2A\13\2\3\2\7\2D\n\2\f\2\16\2G\13\2\3\2\6\2J\n\2\r\2\16\2K\3\2\3\2\3"+
		"\3\3\3\3\3\6\3S\n\3\r\3\16\3T\3\3\3\3\7\3Y\n\3\f\3\16\3\\\13\3\7\3^\n"+
		"\3\f\3\16\3a\13\3\3\3\3\3\3\4\3\4\3\4\7\4h\n\4\f\4\16\4k\13\4\3\5\3\5"+
		"\3\5\3\6\3\6\3\6\5\6s\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u008d\n\7\3\b"+
		"\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\5\n\u009d\n\n\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00aa\n\13\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00ba\n\f\3\r"+
		"\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00c8\n\16\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\7\20\u00d9\n\20\f\20\16\20\u00dc\13\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00eb\n\20\3\21\3\21\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u0108\n\24\3\24"+
		"\3\24\3\25\3\25\3\25\3\25\3\25\3\25\6\25\u0112\n\25\r\25\16\25\u0113\3"+
		"\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5"+
		"\26\u0124\n\26\3\27\3\27\3\27\7\27\u0129\n\27\f\27\16\27\u012c\13\27\3"+
		"\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3"+
		"\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5"+
		"\30\u014a\n\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\7\30\u0161\n\30\f\30"+
		"\16\30\u0164\13\30\3\31\3\31\3\31\7\31\u0169\n\31\f\31\16\31\u016c\13"+
		"\31\3\31\5\31\u016f\n\31\3\32\3\32\3\32\3\32\3\33\7\33\u0176\n\33\f\33"+
		"\16\33\u0179\13\33\3\34\3\34\3\34\7\34\u017e\n\34\f\34\16\34\u0181\13"+
		"\34\3\34\5\34\u0184\n\34\3\35\3\35\5\35\u0188\n\35\3\35\3\35\5\35\u018c"+
		"\n\35\5\35\u018e\n\35\3\36\3\36\3\36\2\3.\37\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\34\36 \"$&(*,.\60\62\64\668:\2\7\3\2\24\26\3\2\27\30\3\2\31\32"+
		"\3\2\33 \3\2%)\2\u01b0\2?\3\2\2\2\4O\3\2\2\2\6d\3\2\2\2\bl\3\2\2\2\nr"+
		"\3\2\2\2\f\u008c\3\2\2\2\16\u008e\3\2\2\2\20\u0093\3\2\2\2\22\u0098\3"+
		"\2\2\2\24\u00a9\3\2\2\2\26\u00b9\3\2\2\2\30\u00bb\3\2\2\2\32\u00c0\3\2"+
		"\2\2\34\u00c9\3\2\2\2\36\u00ea\3\2\2\2 \u00ec\3\2\2\2\"\u00ee\3\2\2\2"+
		"$\u00f7\3\2\2\2&\u00fc\3\2\2\2(\u010b\3\2\2\2*\u0123\3\2\2\2,\u0125\3"+
		"\2\2\2.\u0149\3\2\2\2\60\u016e\3\2\2\2\62\u0170\3\2\2\2\64\u0177\3\2\2"+
		"\2\66\u0183\3\2\2\28\u018d\3\2\2\2:\u018f\3\2\2\2<>\5\4\3\2=<\3\2\2\2"+
		">A\3\2\2\2?=\3\2\2\2?@\3\2\2\2@E\3\2\2\2A?\3\2\2\2BD\5\b\5\2CB\3\2\2\2"+
		"DG\3\2\2\2EC\3\2\2\2EF\3\2\2\2FI\3\2\2\2GE\3\2\2\2HJ\5\n\6\2IH\3\2\2\2"+
		"JK\3\2\2\2KI\3\2\2\2KL\3\2\2\2LM\3\2\2\2MN\7\2\2\3N\3\3\2\2\2OP\7\3\2"+
		"\2PR\7\67\2\2QS\5\6\4\2RQ\3\2\2\2ST\3\2\2\2TR\3\2\2\2TU\3\2\2\2U_\3\2"+
		"\2\2VZ\7\64\2\2WY\5\6\4\2XW\3\2\2\2Y\\\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[^\3"+
		"\2\2\2\\Z\3\2\2\2]V\3\2\2\2^a\3\2\2\2_]\3\2\2\2_`\3\2\2\2`b\3\2\2\2a_"+
		"\3\2\2\2bc\78\2\2c\5\3\2\2\2di\7/\2\2ef\7\63\2\2fh\7/\2\2ge\3\2\2\2hk"+
		"\3\2\2\2ig\3\2\2\2ij\3\2\2\2j\7\3\2\2\2ki\3\2\2\2lm\7\4\2\2mn\7\5\2\2"+
		"n\t\3\2\2\2os\5\f\7\2ps\5&\24\2qs\5(\25\2ro\3\2\2\2rp\3\2\2\2rq\3\2\2"+
		"\2s\13\3\2\2\2tu\5\16\b\2uv\7\62\2\2v\u008d\3\2\2\2wx\5\20\t\2xy\7\62"+
		"\2\2y\u008d\3\2\2\2z{\5\22\n\2{|\7\62\2\2|\u008d\3\2\2\2}~\5\24\13\2~"+
		"\177\7\62\2\2\177\u008d\3\2\2\2\u0080\u0081\5\30\r\2\u0081\u0082\7\62"+
		"\2\2\u0082\u008d\3\2\2\2\u0083\u008d\5\32\16\2\u0084\u008d\5\34\17\2\u0085"+
		"\u0086\5\"\22\2\u0086\u0087\7\62\2\2\u0087\u008d\3\2\2\2\u0088\u0089\5"+
		"$\23\2\u0089\u008a\7\62\2\2\u008a\u008d\3\2\2\2\u008b\u008d\5\36\20\2"+
		"\u008ct\3\2\2\2\u008cw\3\2\2\2\u008cz\3\2\2\2\u008c}\3\2\2\2\u008c\u0080"+
		"\3\2\2\2\u008c\u0083\3\2\2\2\u008c\u0084\3\2\2\2\u008c\u0085\3\2\2\2\u008c"+
		"\u0088\3\2\2\2\u008c\u008b\3\2\2\2\u008d\r\3\2\2\2\u008e\u008f\7\6\2\2"+
		"\u008f\u0090\7\67\2\2\u0090\u0091\5.\30\2\u0091\u0092\78\2\2\u0092\17"+
		"\3\2\2\2\u0093\u0094\7\7\2\2\u0094\u0095\7\67\2\2\u0095\u0096\5.\30\2"+
		"\u0096\u0097\78\2\2\u0097\21\3\2\2\2\u0098\u0099\58\35\2\u0099\u009c\7"+
		"/\2\2\u009a\u009b\7\65\2\2\u009b\u009d\5.\30\2\u009c\u009a\3\2\2\2\u009c"+
		"\u009d\3\2\2\2\u009d\23\3\2\2\2\u009e\u009f\7/\2\2\u009f\u00a0\7\65\2"+
		"\2\u00a0\u00aa\5.\30\2\u00a1\u00a2\7/\2\2\u00a2\u00a3\7;\2\2\u00a3\u00a4"+
		"\5.\30\2\u00a4\u00a5\7<\2\2\u00a5\u00a6\7\65\2\2\u00a6\u00a7\5.\30\2\u00a7"+
		"\u00aa\3\2\2\2\u00a8\u00aa\5\26\f\2\u00a9\u009e\3\2\2\2\u00a9\u00a1\3"+
		"\2\2\2\u00a9\u00a8\3\2\2\2\u00aa\25\3\2\2\2\u00ab\u00ac\7/\2\2\u00ac\u00ad"+
		"\7\63\2\2\u00ad\u00ae\7/\2\2\u00ae\u00af\7\65\2\2\u00af\u00ba\5.\30\2"+
		"\u00b0\u00b1\7/\2\2\u00b1\u00b2\7\63\2\2\u00b2\u00b3\7/\2\2\u00b3\u00b4"+
		"\7;\2\2\u00b4\u00b5\5.\30\2\u00b5\u00b6\7<\2\2\u00b6\u00b7\7\65\2\2\u00b7"+
		"\u00b8\5.\30\2\u00b8\u00ba\3\2\2\2\u00b9\u00ab\3\2\2\2\u00b9\u00b0\3\2"+
		"\2\2\u00ba\27\3\2\2\2\u00bb\u00bc\7/\2\2\u00bc\u00bd\7\67\2\2\u00bd\u00be"+
		"\5\60\31\2\u00be\u00bf\78\2\2\u00bf\31\3\2\2\2\u00c0\u00c1\7\b\2\2\u00c1"+
		"\u00c2\7\67\2\2\u00c2\u00c3\5.\30\2\u00c3\u00c4\78\2\2\u00c4\u00c7\5\62"+
		"\32\2\u00c5\u00c6\7\t\2\2\u00c6\u00c8\5\62\32\2\u00c7\u00c5\3\2\2\2\u00c7"+
		"\u00c8\3\2\2\2\u00c8\33\3\2\2\2\u00c9\u00ca\7\n\2\2\u00ca\u00cb\7\67\2"+
		"\2\u00cb\u00cc\5.\30\2\u00cc\u00cd\78\2\2\u00cd\u00ce\5\62\32\2\u00ce"+
		"\35\3\2\2\2\u00cf\u00d0\7\13\2\2\u00d0\u00d1\79\2\2\u00d1\u00d2\7.\2\2"+
		"\u00d2\u00eb\7:\2\2\u00d3\u00d4\7\f\2\2\u00d4\u00d5\7.\2\2\u00d5\u00d6"+
		"\7.\2\2\u00d6\u00da\7\67\2\2\u00d7\u00d9\5 \21\2\u00d8\u00d7\3\2\2\2\u00d9"+
		"\u00dc\3\2\2\2\u00da\u00d8\3\2\2\2\u00da\u00db\3\2\2\2\u00db\u00dd\3\2"+
		"\2\2\u00dc\u00da\3\2\2\2\u00dd\u00de\78\2\2\u00de\u00df\7.\2\2\u00df\u00eb"+
		"\7\62\2\2\u00e0\u00e1\7\r\2\2\u00e1\u00e2\7.\2\2\u00e2\u00eb\7\62\2\2"+
		"\u00e3\u00e4\7\16\2\2\u00e4\u00e5\5.\30\2\u00e5\u00e6\7\62\2\2\u00e6\u00eb"+
		"\3\2\2\2\u00e7\u00e8\7\17\2\2\u00e8\u00e9\7.\2\2\u00e9\u00eb\7\62\2\2"+
		"\u00ea\u00cf\3\2\2\2\u00ea\u00d3\3\2\2\2\u00ea\u00e0\3\2\2\2\u00ea\u00e3"+
		"\3\2\2\2\u00ea\u00e7\3\2\2\2\u00eb\37\3\2\2\2\u00ec\u00ed\7.\2\2\u00ed"+
		"!\3\2\2\2\u00ee\u00ef\7/\2\2\u00ef\u00f0\7\63\2\2\u00f0\u00f1\7/\2\2\u00f1"+
		"\u00f2\7\67\2\2\u00f2\u00f3\5\60\31\2\u00f3\u00f4\78\2\2\u00f4\u00f5\7"+
		"\20\2\2\u00f5\u00f6\58\35\2\u00f6#\3\2\2\2\u00f7\u00f8\7*\2\2\u00f8\u00f9"+
		"\7\67\2\2\u00f9\u00fa\5\60\31\2\u00fa\u00fb\78\2\2\u00fb%\3\2\2\2\u00fc"+
		"\u00fd\58\35\2\u00fd\u00fe\7/\2\2\u00fe\u00ff\7\67\2\2\u00ff\u0100\5\66"+
		"\34\2\u0100\u0101\78\2\2\u0101\u0102\79\2\2\u0102\u0107\5\64\33\2\u0103"+
		"\u0104\7\21\2\2\u0104\u0105\5.\30\2\u0105\u0106\7\62\2\2\u0106\u0108\3"+
		"\2\2\2\u0107\u0103\3\2\2\2\u0107\u0108\3\2\2\2\u0108\u0109\3\2\2\2\u0109"+
		"\u010a\7:\2\2\u010a\'\3\2\2\2\u010b\u010c\7\22\2\2\u010c\u010d\7/\2\2"+
		"\u010d\u0111\79\2\2\u010e\u010f\5\22\n\2\u010f\u0110\7\62\2\2\u0110\u0112"+
		"\3\2\2\2\u0111\u010e\3\2\2\2\u0112\u0113\3\2\2\2\u0113\u0111\3\2\2\2\u0113"+
		"\u0114\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u0116\7:\2\2\u0116)\3\2\2\2\u0117"+
		"\u0118\7\r\2\2\u0118\u0119\58\35\2\u0119\u011a\7\67\2\2\u011a\u011b\5"+
		",\27\2\u011b\u011c\78\2\2\u011c\u0124\3\2\2\2\u011d\u011e\7\r\2\2\u011e"+
		"\u011f\5:\36\2\u011f\u0120\7;\2\2\u0120\u0121\5.\30\2\u0121\u0122\7<\2"+
		"\2\u0122\u0124\3\2\2\2\u0123\u0117\3\2\2\2\u0123\u011d\3\2\2\2\u0124+"+
		"\3\2\2\2\u0125\u012a\5.\30\2\u0126\u0127\7\64\2\2\u0127\u0129\5.\30\2"+
		"\u0128\u0126\3\2\2\2\u0129\u012c\3\2\2\2\u012a\u0128\3\2\2\2\u012a\u012b"+
		"\3\2\2\2\u012b-\3\2\2\2\u012c\u012a\3\2\2\2\u012d\u012e\b\30\1\2\u012e"+
		"\u012f\7\23\2\2\u012f\u014a\5.\30\27\u0130\u0131\7/\2\2\u0131\u0132\7"+
		"\63\2\2\u0132\u014a\7/\2\2\u0133\u0134\7/\2\2\u0134\u0135\7;\2\2\u0135"+
		"\u0136\5.\30\2\u0136\u0137\7<\2\2\u0137\u014a\3\2\2\2\u0138\u0139\7/\2"+
		"\2\u0139\u013a\7\63\2\2\u013a\u013b\7/\2\2\u013b\u013c\7;\2\2\u013c\u013d"+
		"\5.\30\2\u013d\u013e\7<\2\2\u013e\u014a\3\2\2\2\u013f\u014a\5*\26\2\u0140"+
		"\u014a\7+\2\2\u0141\u014a\7,\2\2\u0142\u014a\7-\2\2\u0143\u014a\7.\2\2"+
		"\u0144\u014a\7/\2\2\u0145\u014a\5$\23\2\u0146\u014a\5\30\r\2\u0147\u014a"+
		"\5\"\22\2\u0148\u014a\7$\2\2\u0149\u012d\3\2\2\2\u0149\u0130\3\2\2\2\u0149"+
		"\u0133\3\2\2\2\u0149\u0138\3\2\2\2\u0149\u013f\3\2\2\2\u0149\u0140\3\2"+
		"\2\2\u0149\u0141\3\2\2\2\u0149\u0142\3\2\2\2\u0149\u0143\3\2\2\2\u0149"+
		"\u0144\3\2\2\2\u0149\u0145\3\2\2\2\u0149\u0146\3\2\2\2\u0149\u0147\3\2"+
		"\2\2\u0149\u0148\3\2\2\2\u014a\u0162\3\2\2\2\u014b\u014c\f\26\2\2\u014c"+
		"\u014d\t\2\2\2\u014d\u0161\5.\30\27\u014e\u014f\f\25\2\2\u014f\u0150\t"+
		"\3\2\2\u0150\u0161\5.\30\26\u0151\u0152\f\24\2\2\u0152\u0153\t\4\2\2\u0153"+
		"\u0161\5.\30\25\u0154\u0155\f\23\2\2\u0155\u0156\t\5\2\2\u0156\u0161\5"+
		".\30\24\u0157\u0158\f\22\2\2\u0158\u0159\7!\2\2\u0159\u0161\5.\30\23\u015a"+
		"\u015b\f\21\2\2\u015b\u015c\7\"\2\2\u015c\u0161\5.\30\22\u015d\u015e\f"+
		"\20\2\2\u015e\u015f\7#\2\2\u015f\u0161\5.\30\21\u0160\u014b\3\2\2\2\u0160"+
		"\u014e\3\2\2\2\u0160\u0151\3\2\2\2\u0160\u0154\3\2\2\2\u0160\u0157\3\2"+
		"\2\2\u0160\u015a\3\2\2\2\u0160\u015d\3\2\2\2\u0161\u0164\3\2\2\2\u0162"+
		"\u0160\3\2\2\2\u0162\u0163\3\2\2\2\u0163/\3\2\2\2\u0164\u0162\3\2\2\2"+
		"\u0165\u016a\5.\30\2\u0166\u0167\7\64\2\2\u0167\u0169\5.\30\2\u0168\u0166"+
		"\3\2\2\2\u0169\u016c\3\2\2\2\u016a\u0168\3\2\2\2\u016a\u016b\3\2\2\2\u016b"+
		"\u016f\3\2\2\2\u016c\u016a\3\2\2\2\u016d\u016f\3\2\2\2\u016e\u0165\3\2"+
		"\2\2\u016e\u016d\3\2\2\2\u016f\61\3\2\2\2\u0170\u0171\79\2\2\u0171\u0172"+
		"\5\64\33\2\u0172\u0173\7:\2\2\u0173\63\3\2\2\2\u0174\u0176\5\f\7\2\u0175"+
		"\u0174\3\2\2\2\u0176\u0179\3\2\2\2\u0177\u0175\3\2\2\2\u0177\u0178\3\2"+
		"\2\2\u0178\65\3\2\2\2\u0179\u0177\3\2\2\2\u017a\u017f\5\22\n\2\u017b\u017c"+
		"\7\64\2\2\u017c\u017e\5\22\n\2\u017d\u017b\3\2\2\2\u017e\u0181\3\2\2\2"+
		"\u017f\u017d\3\2\2\2\u017f\u0180\3\2\2\2\u0180\u0184\3\2\2\2\u0181\u017f"+
		"\3\2\2\2\u0182\u0184\3\2\2\2\u0183\u017a\3\2\2\2\u0183\u0182\3\2\2\2\u0184"+
		"\67\3\2\2\2\u0185\u0187\5:\36\2\u0186\u0188\7=\2\2\u0187\u0186\3\2\2\2"+
		"\u0187\u0188\3\2\2\2\u0188\u018e\3\2\2\2\u0189\u018b\7/\2\2\u018a\u018c"+
		"\7=\2\2\u018b\u018a\3\2\2\2\u018b\u018c\3\2\2\2\u018c\u018e\3\2\2\2\u018d"+
		"\u0185\3\2\2\2\u018d\u0189\3\2\2\2\u018e9\3\2\2\2\u018f\u0190\t\6\2\2"+
		"\u0190;\3\2\2\2 ?EKTZ_ir\u008c\u009c\u00a9\u00b9\u00c7\u00da\u00ea\u0107"+
		"\u0113\u0123\u012a\u0149\u0160\u0162\u016a\u016e\u0177\u017f\u0183\u0187"+
		"\u018b\u018d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}