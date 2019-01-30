grammar E;

// -------------------------------------------------------------------------------------------------
// PARSER RULES

// Start rule
// It is evaluated from left to right.
// A program consists of statements, functions or structures.

program                     : incls+=includes* noMains+=noMain* command+ EOF
                            ;

// -------------------------------------------------------------------------------------------------
// Allows the import of different modules for e.g. mathematical calculations.

includes                    : 'use' OPAREN (mods+=module)+ (COMMA (mods+=module)*)* CPAREN
                            ;

// -------------------------------------------------------------------------------------------------
// A namespace can consist of several modules that are separated from each other by dots.

module                      : IDENTIFIER (DOT IDENTIFIER)*
                            ;

// -------------------------------------------------------------------------------------------------
// This indicates that no starting point is generated for a class.

noMain                      : '#define' name='noMain'
                            ;

// -------------------------------------------------------------------------------------------------
// This is a helper for the program because of functions and structs must not be in the main method
// during code generation. Therefore statements and functions are separated.

command                     : statement #StatementCommand
                            | functionDefinition #FunctionDefinitionCommand
                            | structDeclaration #StructDeclarationCommand
                            ;

// -------------------------------------------------------------------------------------------------
// Statements in the program code (also without a semicolon at the end)
// Statements can stand alone and are not dependent on an expression.

statement                   : print SCOLON
                            | printLine SCOLON
                            | variableDeclaration SCOLON
                            | assignment SCOLON
                            | functionCall SCOLON
                            | branch
                            | loop
                            | includedFunctionCall SCOLON
                            | builtinFunctionCall SCOLON
                            | assembly
                            ;

// -------------------------------------------------------------------------------------------------
// Responsible for outputs without a new line

print                       : 'print' OPAREN arg=expression CPAREN
                            ;

// -------------------------------------------------------------------------------------------------
// Responsible for outputs with a new line

printLine                   : 'println' OPAREN arg=expression CPAREN
                            ;

// -------------------------------------------------------------------------------------------------
// Allowed declaration of variables (including an immediate initialization)

variableDeclaration         : type=dataType varId=IDENTIFIER (ASSIGN expr=expression)?
                            ;

// -------------------------------------------------------------------------------------------------
// Assigning values to a variable or struct

assignment                  : varId=IDENTIFIER ASSIGN expr=expression
                            | varId=IDENTIFIER OBRACKET index=expression CBRACKET ASSIGN
                              expr=expression
                            | structVariableAssignment
                            ;

// -------------------------------------------------------------------------------------------------
// This can be used to assign values to structures.

structVariableAssignment    : structId=IDENTIFIER DOT varId=IDENTIFIER ASSIGN expr=expression
                            | structId=IDENTIFIER DOT varId=IDENTIFIER OBRACKET index=expression
                              CBRACKET ASSIGN expr=expression
                            ;


// -------------------------------------------------------------------------------------------------
// Indicates a function call (with arguments).

functionCall                : funcId=IDENTIFIER OPAREN currentParams=currentParameters CPAREN
                            ;

// -------------------------------------------------------------------------------------------------
// Identifies a branch through which decisions can be made (else block is optional).

branch                      : 'if' OPAREN cond=expression CPAREN onTrue=block ('else'
                              onFalse=block)?
                            ;

// -------------------------------------------------------------------------------------------------
// Realizes while loops whereby Turing-completeness applies.

loop                        : 'while' OPAREN cond=expression CPAREN body=block
                            ;

// -------------------------------------------------------------------------------------------------
// With this you can directly write assembler in high level language. Assembly can be executed or
// written directly. However, objects can also be initialized directly.

assembly                    : 'asm' OBRACE str=STRING CBRACE #InlineAssembly
                            | 'invoke' mod=STRING id=STRING OPAREN args+=STRING* CPAREN
                              #InvokeAssembly
                            | 'new' type=STRING #InitObject
                            | 'pushToStack' expression #PushToStack
                            | 'setTopOfStack' type=STRING #SetTopOfStack
                            ;

// -------------------------------------------------------------------------------------------------
// This can be used to access functions from other packages.

includedFunctionCall        : inclDir=IDENTIFIER DOT funcId=IDENTIFIER OPAREN args=currentParameters
                              CPAREN ':' type=dataType
                            ;

// -------------------------------------------------------------------------------------------------
// This can be used to call built-in functions such as castings (without any imports).

builtinFunctionCall         : funcId=BUILTINFUNCTION OPAREN args=currentParameters CPAREN
                            ;

// -------------------------------------------------------------------------------------------------
// Definition of a function with parameters and a body with (several) statements

functionDefinition          : type=dataType funcId=IDENTIFIER OPAREN formalParams=formalParameters
                              CPAREN OBRACE
                                stmts=statements ('return' returnVal=expression SCOLON)? CBRACE
                            ;

// -------------------------------------------------------------------------------------------------
// Describes the declaration of a structure with at least one variable.

structDeclaration           : 'struct' structId=IDENTIFIER OBRACE (decls+=variableDeclaration
                              SCOLON)+ CBRACE
                            ;

// -------------------------------------------------------------------------------------------------
// Initializes an object.

structInitialization        : 'new' object=dataType OPAREN args=assignments CPAREN
                            | 'new' type=primitive OBRACKET size=expression CBRACKET
                            ;

// -------------------------------------------------------------------------------------------------
// Helper for initialization to assign values

assignments                 : asgmts+=expression (COMMA asgmts+=expression)*
                            ;

// -------------------------------------------------------------------------------------------------
// Mathematical operators
// Precedence (partial order): neg, (div, mul, rem), (sub, add), comp (same precedences), and, or,
// ... Labels allow access in the code.

expression                  : '!' expression #NegationExpression
                            | expression op=('/' | '*' | '%') expression
                              #DivisionMultiplicationModuloExpression
                            | expression op=('-' | '+') expression #SubtractionAdditionExpression
                            | expression op=('<<' | '>>') expression #ShiftExpression
                            | expression op=('<' | '<=' | '>' | '>=' | '==' | '!=') expression
                              #RelationalExpression
                            | lExpr=expression '&&' rExpr=expression #ConjunctionExpression
                            | lExpr=expression '||' rExpr=expression #DisjunctionExpression
                            | expression '^' expression #ContravalenceExpression
                            | includedFunctionCall #IncludedFunctionExpression
                            | builtinFunctionCall #BuiltinFunctionExpression
                            | structInitialization #StructInitializationExpression
                            | varId=IDENTIFIER OPAREN index=expression CPAREN #ArrayExpression
                            | structId=IDENTIFIER DOT varId=IDENTIFIER #StructExpression
                            | structId=IDENTIFIER DOT varId=IDENTIFIER OPAREN index=expression
                              CPAREN #StructArrayExpression
                            | functionCall #FunctionExpression
                            | varId=IDENTIFIER #VariableExpression
                            | bool=BOOL #BoolExpression
                            | number=INTEGER #IntegerExpression
                            | number=FLOAT #FloatingPointExpression
                            | str=STRING #StringExpression
                            ;

// -------------------------------------------------------------------------------------------------
// The current parameter list of functions can be of any length (no visitor).

currentParameters           : exprs+=expression (COMMA exprs+=expression)*
                            |
                            ;

// -------------------------------------------------------------------------------------------------
// Provides a basic block with an entry and exit from a control flow (no visitor).

block                       : OBRACE statements CBRACE
                            ;

// -------------------------------------------------------------------------------------------------
// Helper for more statements regarding blocks (no visitor)

statements                  : statement*
                            ;

// -------------------------------------------------------------------------------------------------
// The formal parameter list of functions can be of any length (no visitor).
// The number of parameters is also saved.

formalParameters            : decls+=variableDeclaration (COMMA decls+=variableDeclaration)*
                            |
                            ;

// Represents the different data types (including lists and objects)

dataType                : primitive(OCBRACKET)?
                        | IDENTIFIER(OCBRACKET)?
                        ;

// -------------------------------------------------------------------------------------------------
// The supported (primitive) types

primitive               : 'bool'
                        | 'int'
                        | 'float'
                        | 'String'
                        | 'void'
                        ;

// -------------------------------------------------------------------------------------------------
// LEXER RULES

// Represents the two truth values of logic (true, false).

BOOL                    : 'true'
                        | 'false'
                        ;

// -------------------------------------------------------------------------------------------------
// Refers to integers

INTEGER                 : (DIGIT)+
                        ;

// -------------------------------------------------------------------------------------------------
// Refers to floating point numbers

FLOAT                   : INTEGER DOT INTEGER
                        | DOT INTEGER
                        ;

// -------------------------------------------------------------------------------------------------
// Any number of characters, but as little as possible that the rule is still fulfilled

STRING                  : QMARK .*? QMARK
                        ;

// -------------------------------------------------------------------------------------------------
// Identifiers

IDENTIFIER              : LETTER(LETTER | DIGIT)*
                        ;


// -------------------------------------------------------------------------------------------------
// Here are the built-in functions of the language E, where an access is possible even without
// imports.

BUILTINFUNCTION         : 'toInt'
                        | 'toLong'
                        | 'toFloat'
                        | 'toDouble'
                        | 'toString'
                        | 'append'
                        | 'length'
                        ;

// -------------------------------------------------------------------------------------------------
// (Multi)line comments (but as little as possible that the rule is still fulfilled)

COMMENT                     :   ('//' ~[\r\n]* '\r'? '\n' | '/*' .*? '*/' | '/**' .*? '*/') -> skip
                            ;

// -------------------------------------------------------------------------------------------------
// Ignore control characters (the screener removes these)

WHITESPACE                  : [ \t\n\r]+ -> skip
                            ;

// -------------------------------------------------------------------------------------------------
// Here are the repeating tokens in the grammar

SCOLON                      : ';'
                            ;

DOT                         : '.'
                            ;

COMMA                       : ','
                            ;

ASSIGN                      : '='
                            ;

QMARK                       : '"'
                            ;

OPAREN                      : '('
                            ;

CPAREN                      : ')'
                            ;

OBRACE                      : '{'
                            ;

CBRACE                      : '}'
                            ;

OBRACKET                    : '['
                            ;

CBRACKET                    : ']'
                            ;

OCBRACKET                   : '[]'
                            ;

// -------------------------------------------------------------------------------------------------
// Letters (will never be counted as a token)

fragment LETTER             : [a-zA-Z_]
                            ;

// -------------------------------------------------------------------------------------------------
// Digits (used for data types and identifiers)

fragment DIGIT              : [0-9]
                            ;
