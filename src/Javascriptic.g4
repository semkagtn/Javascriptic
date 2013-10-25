grammar Javascriptic;

program
    : block
    ; 

block
    : statement*
    ;

statement
    : scopeStat
    | functionDecl
    | varDecl ';'
    | assignment ';'
    | ifStat
    | whileStat
    | functionCall ';'
    ;

scopeStat
    : '{' block '}'
    ;

functionDecl
    : 'function' ID '(' functionParams? ')' scopeStat
    ;

varDecl
    : 'var' ID ('=' expression)? 
    ;

assignment
    : ID '=' expression 
    ;

ifStat
    : 'if' '(' expression ')' statement ('else' statement)? 
    ;

whileStat
    : 'while' '(' expression ')' statement
    ;

expression
    : ID
    | constant
    | functionCall
    ;

constant
    : NUM
    | STR
    | BOOL
    | UNDEF
    ;

functionCall
    : ID '(' functionArgs? ')' 
    ;

functionParams
    : ID (',' ID)* 
    ;

functionArgs
    : expression (',' expression)*
    ;

NUM : '-'? DIGIT+ ;
STR : '"' (ESC | . )*? '"' ;
BOOL : 'true' | 'false' ;
UNDEF : 'undefined' ; 

ID : ID_LETTER (ID_LETTER | DIGIT)* ;

COMMENT : '/*' .*? '*/' -> skip ;
LINE_COMMENT : '//' .*? '\n' -> skip ;
WS : [ \t\r\n]+ -> skip ;

fragment DIGIT : [0-9] ;
fragment ID_LETTER : [a-zA-Z_$] ;
fragment ESC : '\\' [btnr"\\] ; 
