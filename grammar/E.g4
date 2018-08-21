grammar E;

// ------------------------------------------------------------
// Start rule
// It is evaluated from right to left

program     : (say ';')+
            ;

// ------------------------------------------------------------
// Mathematical operators
// Precedence: div (commutative), mul, rem, add, sub

expression  : left=expression '/' right=expression #Division
            | left=expression '*' right=expression #Multiplication
            | left=expression '%' right=expression #Modulo
            | left=expression '+' right=expression #Addition
            | left=expression '-' right=expression #Subtraction
            | digit=DIGIT #Digit
            ;

// ------------------------------------------------------------
// Responsible for outputs

say         : 'say(' argument=expression ')'
            ;

// ------------------------------------------------------------
// Digits

DIGIT       : [0-9]+
            ;

// ------------------------------------------------------------
// Ignore control characters

WHITESPACE  : [ \t\n\r]+ -> skip
            ;