grammar E;

// ----------------------------------------------------------------------------------------------------------------------------------------------
// PARSER RULES

// Start rule
// It is evaluated from left to right.
// A program consists of statements or functions.

program                 : command+
                        ;

// ----------------------------------------------------------------------------------------------------------------------------------------------
// This is a helper for the program because of functions must not be in the main method
// during code generation. Therefore statements and functions are separated.

command                 : statement #MainStatement
                        | functionDefinition #ProgramFunction
                        ;

// ----------------------------------------------------------------------------------------------------------------------------------------------
// Statements in the program code (also without a semicolon at the end)

statement               : print ';'
                        | variableDeclaration ';'
                        | assignment ';'
                        | branch
                        ;

// ----------------------------------------------------------------------------------------------------------------------------------------------
// Mathematical operators
// Precedence: div, mul (commutative), rem, sub, add
// Labels allow access in the code.

expression              : expression '/' expression #Division
                        | expression '*' expression #Multiplication
                        | expression '%' expression #Modulo
                        | expression '-' expression #Subtraction
                        | expression '+' expression #Addition
                        | digit=INT #Digit
                        | varId=IDENTIFIER #Variable
                        | functionCall #Function
                        ;

// ----------------------------------------------------------------------------------------------------------------------------------------------
// Responsible for outputs

print                   : 'print(' arg=expression ')'
                        ;

// ----------------------------------------------------------------------------------------------------------------------------------------------
// Allowed declaration of variables

variableDeclaration     : TYPE varId=IDENTIFIER
                        ;

// ----------------------------------------------------------------------------------------------------------------------------------------------
// Assigning values to a variable

assignment              : varId=IDENTIFIER '=' expr=expression
                        ;

// ----------------------------------------------------------------------------------------------------------------------------------------------
// Identifies a branch through which decisions can be made.
branch                  : 'if' '(' cond=expression ')' onTrue=block 'else' onFalse=block
                        ;

// ----------------------------------------------------------------------------------------------------------------------------------------------
// Provides a basic block (entry and exit from a control flow).
block                   : '{' statements '}'
                        ;

// ----------------------------------------------------------------------------------------------------------------------------------------------
// Definition of a function with parameters and a body

functionDefinition      : TYPE funcId=IDENTIFIER '(' formalParams=formalParameters ')' '{' stmts=statements 'return' returnVal=expression ';' '}'
                        ;

// ----------------------------------------------------------------------------------------------------------------------------------------------
// The formal parameter list of functions can be of any length.
// The number of parameters is also saved.
formalParameters        : decls+=variableDeclaration (',' decls+=variableDeclaration)*
                        |
                        ;

// ----------------------------------------------------------------------------------------------------------------------------------------------
// A function can consist of several statements (list). However, there does not have to be
// statements, i.e. a return can also be made directly.
statements              : statement*
                        ;

// ----------------------------------------------------------------------------------------------------------------------------------------------
// Indicates a function call (with arguments).
functionCall            : funcId=IDENTIFIER '(' currentParams=currentParameters ')'
                        ;

// ----------------------------------------------------------------------------------------------------------------------------------------------
// The current parameter list of functions can be of any length.
currentParameters       : exprs+=expression (',' exprs+=expression)*
                        |
                        ;

// ----------------------------------------------------------------------------------------------------------------------------------------------
// LEXER RULES

// Types
TYPE                    : 'int'
                        ;

// ----------------------------------------------------------------------------------------------------------------------------------------------
// Identifiers
IDENTIFIER              : LETTER(LETTER | DIGIT)*
                        ;

// ----------------------------------------------------------------------------------------------------------------------------------------------
// References the DIGIT helper rule
INT                     : DIGIT+
                        ;

// ----------------------------------------------------------------------------------------------------------------------------------------------
// Digits

DIGIT                   : [0-9]
                        ;

// ----------------------------------------------------------------------------------------------------------------------------------------------
// Letters

LETTER                  : [a-zA-Z_]
                        ;

// ----------------------------------------------------------------------------------------------------------------------------------------------
// Ignore control characters

WHITESPACE              : [ \t\n\r]+ -> skip
                        ;
