grammar E;

// ------------------------------------------------------------
// Start rule

program     : (say ';')+
            ;

// ------------------------------------------------------------
// Mathematical operators

expression  : left=expression '+' right=DIGIT #Addition
            | left=expression '-' right=DIGIT #Subtraction
            | left=expression '*' right=DIGIT #Multiplication
            | left=expression '/' right=DIGIT #Division
            | left=expression '%' right=DIGIT #Modulo
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