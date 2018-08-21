grammar E;

program     : (say ';')+
            ;

add         : left=add '+' right=DIGIT #Addition
            | digit=DIGIT #Digit
            ;

say         : 'say(' arg=add ')'
            ;

DIGIT       : [0-9]+
            ;

WHITESPACE  : [ \t\n\r]+ -> skip
            ;