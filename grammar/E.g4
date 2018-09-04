grammar E;

// ------------------------------------------------------------------------
// PARSER RULES

// Start rule
// It is evaluated from right to left

program             : (statement ';')+
                    ;

// ------------------------------------------------------------------------
// Statements in the program code

statement           : say
                    | variableDeclaration
                    | assignment
                    ;

// ------------------------------------------------------------------------
// Mathematical operators
// Precedence: div (commutative), mul, rem, add, sub
// Labels allow access in the code.

expression          : left=expression '/' right=expression #Division
                    | left=expression '*' right=expression #Multiplication
                    | left=expression '%' right=expression #Modulo
                    | left=expression '-' right=expression #Subtraction
                    | left=expression '+' right=expression #Addition
                    | digit=INT #Digit
                    | identifier=IDENTIFIER #Variable
                    ;

// ------------------------------------------------------------------------
// Responsible for outputs

say                 : 'say(' argument=expression ')'
                    ;

// ------------------------------------------------------------------------
// Allowed declaration of variables

variableDeclaration : TYPE identifier=IDENTIFIER
                    ;

// ------------------------------------------------------------------------
// Assigning values to a variable
assignment          : identifier=IDENTIFIER '=' expr=expression
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