grammar E;

// ---------------------------------------------------------------------------------------------------------------------
// PARSER RULES

// Start rule
// It is evaluated from left to right.
// A program consists of statements, functions or structures.

program                     : incls+=includes* command+ EOF
                            ;

includes                    : 'include' OPAREN (mods+=module)+ (COMMA (mods+=module)*)* CPAREN
                            ;

module                      : IDENTIFIER (DOT IDENTIFIER)*
                            ;

// ---------------------------------------------------------------------------------------------------------------------
// This is a helper for the program because of functions and structs must not be in the main method
// during code generation. Therefore statements and functions are separated.

command                     : statement #StatementCommand
                            | functionDefinition #FunctionDefinitionCommand
                            | structDeclaration #StructDeclarationCommand
                            ;

// ---------------------------------------------------------------------------------------------------------------------
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

// ---------------------------------------------------------------------------------------------------------------------
// Responsible for outputs without a new line

print                       : 'print' OPAREN arg=expression CPAREN
                            ;

// ---------------------------------------------------------------------------------------------------------------------
// Responsible for outputs with a new line

printLine                   : 'println' OPAREN arg=expression CPAREN
                            ;

// ---------------------------------------------------------------------------------------------------------------------
// Allowed declaration of variables (including an immediate initialization)

variableDeclaration         : type=DATATYPE varId=IDENTIFIER (ASSIGN expr=expression)?
                            ;

// ---------------------------------------------------------------------------------------------------------------------
// Assigning values to a variable or struct

assignment                  : varId=IDENTIFIER ASSIGN expr=expression
                            | varId=IDENTIFIER OBRACKET index=expression CBRACKET ASSIGN expr=expression
                            | structVariableAssignment
                            ;

// ---------------------------------------------------------------------------------------------------------------------
// This can be used to assign values to structures.

structVariableAssignment    : structId=IDENTIFIER DOT varId=IDENTIFIER ASSIGN expr=expression
                            | structId=IDENTIFIER DOT varId=IDENTIFIER OBRACKET index=expression CBRACKET ASSIGN
                                expr=expression
                            ;


// ---------------------------------------------------------------------------------------------------------------------
// Indicates a function call (with arguments).

functionCall                : funcId=IDENTIFIER OPAREN currentParams=currentParameters CPAREN
                            ;

// ---------------------------------------------------------------------------------------------------------------------
// The current parameter list of functions can be of any length.

currentParameters           : exprs+=expression (COMMA exprs+=expression)*
                            |
                            ;

// ---------------------------------------------------------------------------------------------------------------------
// Identifies a branch through which decisions can be made (else block is optional).

branch                      : 'if' OPAREN cond=expression CPAREN onTrue=block ('else' onFalse=block)?
                            ;

// ---------------------------------------------------------------------------------------------------------------------
// Realizes while loops whereby Turing-completeness applies.

loop                        : 'while' OPAREN cond=expression CPAREN body=block
                            ;

// ---------------------------------------------------------------------------------------------------------------------
// Provides a basic block (entry and exit from a control flow).

block                       : OBRACE statements CBRACE
                            ;

// ---------------------------------------------------------------------------------------------------------------------
// Helper for more statements regarding blocks

statements                  : statement*
                            ;

// ---------------------------------------------------------------------------------------------------------------------
// With this you can directly write assembler in high level language. Assembly can be executed or written directly.
// However, objects can also be initialized directly.

assembly                    : 'asm' OBRACE str=STRING CBRACE #InlineAssembly
                            | 'invoke' mod=STRING id=STRING OPAREN args+=STRING* CPAREN #InvokeAssembly
                            | 'new' type=STRING #InitObject
                            | 'pushToStack' expression #PushToStack
                            | 'setTopOfStack' type=STRING #SetTopOfStack
                            ;

// ---------------------------------------------------------------------------------------------------------------------
// This can be used to access functions from other packages.

includedFunctionCall        : inclDir=IDENTIFIER DOT funcId=IDENTIFIER OPAREN args=currentParameters CPAREN ':'
                                type=DATATYPE
                            ;

// ---------------------------------------------------------------------------------------------------------------------
// This can be used to call built-in functions such as castings (without any imports).

builtinFunctionCall         : funcId=BUILTINFUNCTION OPAREN args=currentParameters CPAREN
                            ;

// ---------------------------------------------------------------------------------------------------------------------
// Definition of a function with parameters and a body with (several) statements

functionDefinition          : type=DATATYPE funcId=IDENTIFIER OPAREN formalParams=formalParameters CPAREN OBRACE
                                stmts=statements 'return' returnVal=expression SCOLON CBRACE
                            ;

// ---------------------------------------------------------------------------------------------------------------------
// The formal parameter list of functions can be of any length.
// The number of parameters is also saved.

formalParameters            : decls+=variableDeclaration (COMMA decls+=variableDeclaration)*
                            |
                            ;

// ---------------------------------------------------------------------------------------------------------------------
// Describes the declaration of a structure with at least one variable.

structDeclaration           : 'struct' structId=IDENTIFIER OBRACE (decls+=variableDeclaration SCOLON)+ CBRACE
                            ;

// ---------------------------------------------------------------------------------------------------------------------
// Initializes an object.

structInitialization        : 'new' type=DATATYPE OPAREN args=assignments CPAREN
                            | 'new' type=PRIMITIVE OBRACKET size=expression CBRACKET
                            ;

// ---------------------------------------------------------------------------------------------------------------------
// Helper for initialization to assign values

assignments                 : asgmts+=expression (COMMA asgmts+=expression)*
                            ;

// ---------------------------------------------------------------------------------------------------------------------
// Mathematical operators
// Precedence (partial order): (div, mul, rem), (sub, add), comp (same precedences), and, or, ...
// Labels allow access in the code.

expression                  : expression op=('/' | '*' | '%') expression #DivisionMultiplicationModuloExpression
                            | expression op=('-' | '+') expression #SubtractionAdditionExpression
                            | expression op=('<<' | '>>') expression #ShiftExpression
                            | expression op=('<' | '<=' | '>' | '>=' | '==' | '!=') expression #RelationalExpression
                            | lExpr=expression '&&' rExpr=expression #ConjunctionExpression
                            | lExpr=expression '||' rExpr=expression #DisjunctionExpression
                            | expression '^' expression #ContravalenceExpression
                            | includedFunctionCall #IncludedFunctionExpression
                            | builtinFunctionCall #BuiltinFunctionExpression
                            | structInitialization #StructInitializationExpression
                            | varId=IDENTIFIER OPAREN index=expression CPAREN #ArrayExpression
                            | structId=IDENTIFIER DOT varId=IDENTIFIER #StructExpression
                            | structId=IDENTIFIER DOT varId=IDENTIFIER OPAREN index=expression CPAREN
                                #StructArrayExpression
                            | functionCall #FunctionExpression
                            | varId=IDENTIFIER #IdentifierExpression
                            | bool=BOOL #BoolExpression
                            | number=INTEGER #IntegerExpression
                            | number=DOUBLE #FloatingPointExpression
                            | str=STRING #StringExpression
                            ;

// ---------------------------------------------------------------------------------------------------------------------
// LEXER RULES

// Represents the different data types (including lists and objects)

DATATYPE                : PRIMITIVE ('[]')?
                        | IDENTIFIER ('[]')?
                        ;

// ---------------------------------------------------------------------------------------------------------------------
// The supported (primitive) types

PRIMITIVE               : 'bool'
                        | 'int'
                        | 'double'
                        | 'String'
                        | 'void'
                        ;

// ---------------------------------------------------------------------------------------------------------------------
// Represents the two truth values of logic (true, false).

BOOL                    : 'true'
                        | 'false'
                        ;

// ---------------------------------------------------------------------------------------------------------------------
// Refers to integers (4 or 8 bytes).

INTEGER                 : (DIGIT)+
                        ;

// ---------------------------------------------------------------------------------------------------------------------
// Refers to floating point numbers (4 or 8 bytes).

DOUBLE                  : INTEGER DOT INTEGER
                        ;

// ---------------------------------------------------------------------------------------------------------------------
// Any number of characters, but as little as possible that the rule is still fulfilled

STRING                  : QMARK .*? QMARK
                        ;

// ---------------------------------------------------------------------------------------------------------------------
// Identifiers

IDENTIFIER              : LETTER(LETTER | DIGIT)*
                        ;


// ---------------------------------------------------------------------------------------------------------------------
// Here are the built-in functions of the language E, where an access is possible even without imports.

BUILTINFUNCTION         : 'toInt'
                        | 'toLong'
                        | 'toFloat'
                        | 'toDouble'
                        | 'toString'
                        | 'append'
                        | 'length'
                        ;

// ---------------------------------------------------------------------------------------------------------------------
// (Multi)line comments (but as little as possible that the rule is still fulfilled)

COMMENT                     :   ('//' ~[\r\n]* '\r'? '\n' | '/*' .*? '*/') -> skip
                            ;

// ---------------------------------------------------------------------------------------------------------------------
// Ignore control characters (the screener removes these)

WHITESPACE                  : [ \t\n\r]+ -> skip
                            ;

// ---------------------------------------------------------------------------------------------------------------------
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

// ---------------------------------------------------------------------------------------------------------------------
// Letters (will never be counted as a token)

fragment LETTER             : [a-zA-Z_]
                            ;

// ---------------------------------------------------------------------------------------------------------------------
// Digits (used for data types and identifiers)

fragment DIGIT              : [0-9]
                            ;
