grammar Javascriptic;

@header {
package com.semkagtn.generated;
}

program
    : stat*
    ; 

// Unlike JavaScript, in this language we MUST put a semicolon after certain statements
stat
    : blockStat       
    | varDecl 
    | ifStat
    | whileStat 
    | doWhileStat 
    | returnStat 
    | breakStat
    | continueStat
    | exprStat
    ;

blockStat
    : '{' stat* '}'
    ;

varDecl
    : 'var' ID ('=' expr)? ';'
    ;

ifStat
    : 'if' '(' expr ')' stat ('else' stat)? 
    ;

whileStat
    : 'while' '(' expr ')' stat
    ;

returnStat
    : 'return' expr? ';'
    ;

breakStat
    : 'break' ';'
    ;

continueStat
    : 'continue' ';'
    ;

exprStat
    : expr ';'
    ;

// operations with priority
expr
    : '(' expr ')' # ParenExpr
    | expr '(' functionArgs? ')' # FunctionCall
    | op=('!' | '-') expr # Unary
    | expr op=('*' | '/' | '%') expr # MulDivMod
    | expr op=('+' | '-') expr # AddSub
    | expr op=('<' | '<=' | '>' | '>=') expr # Cmp
    | expr op=('==' | '!=') expr # Eq
    | expr '&&' expr # And
    | expr '||' expr # Or
    | ID '=' expr # Assign
    | ID # Variable
    | (NUM | STR | BOOL | NAN | UNDEF) # Constant
    | 'function' '(' functionParams? ')' blockStat # Function
    ;

// concrete values
functionArgs
    : expr (',' expr)*
    ;

// abstract values
functionParams
    : ID (',' ID)* 
    ;

NOT : '!' ;
MINUS : '-' ;
MUL : '*' ;
DIV : '/' ;
MOD : '%' ;
ADD : '+' ;
LT : '<' ;
LE : '<=' ;
GT : '>' ;
GE : '>=' ;
EQ : '==' ;
NE : '!=' ;

NUM : DIGIT+ ('.' DIGIT+)? ; // we can get negative numbers using unary minus operator
STR : '"' (ESC | . )*? '"' ; // unlike JavaScript only double quotes
BOOL : 'true' | 'false' ; 
NAN : 'NaN' ;
UNDEF : 'undefined' ; 

ID : ID_LETTER (ID_LETTER | DIGIT)* ;

COMMENT : '/*' .*? '*/' -> skip ;
LINE_COMMENT : '//' .*? '\n' -> skip ;
WS : [ \t\r\n]+ -> skip ;

fragment DIGIT : [0-9] ;
fragment ID_LETTER : [a-zA-Z_$] ;
fragment ESC : '\\' [btnr"\\] ; 
