grammar E;

add     : left=add '+' right=DIGIT #Addition
        | digit=DIGIT #Digit
        ;

DIGIT   : [0-9]+
        ;