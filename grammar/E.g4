grammar E;

// ------------------------------------------------------------------------
// PARSER RULES

// Start rule
// It is evaluated from right to left

program             : (statement ';')+
                    ;

// ------------------------------------------------------------------------
// Statements in the program code

statement           : print
                    | variableDeclaration
                    | assignment
                    ;

// ------------------------------------------------------------------------
// Mathematical operators
// Precedence: div, mul (commutative), rem, sub, add
// Labels allow access in the code.

expression          : expression '/' expression #Division
                    | expression '*' expression #Multiplication
                    | expression '%' expression #Modulo
                    | expression '-' expression #Subtraction
                    | expression '+' expression #Addition
                    | digit=INT #Digit
                    | var=IDENTIFIER #Variable
                    ;

// ------------------------------------------------------------------------
// Responsible for outputs

print               : 'print(' arg=expression ')'
                    ;

// ------------------------------------------------------------------------
// Allowed declaration of variables

variableDeclaration : TYPE var=IDENTIFIER
                    ;

// ------------------------------------------------------------------------
// Assigning values to a variable
assignment          : var=IDENTIFIER '=' expr=expression
                    ;


// ------------------------------------------------------------------------
// LEXER RULES

// Types
TYPE                : 'int'
                    ;

// Identifiers
IDENTIFIER          : LETTER(LETTER | DIGIT)*
                    ;

// ------------------------------------------------------------------------
// References the DIGIT helper rule
INT                 : DIGIT+
                    ;

// ------------------------------------------------------------------------
// Digits

DIGIT               : [0-9]
                    ;

// ------------------------------------------------------------------------
// Letters

LETTER              : [a-zA-Z_]
                    ;

// ------------------------------------------------------------------------
// Ignore control characters

WHITESPACE          : [ \t\n\r]+ -> skip
                    ;