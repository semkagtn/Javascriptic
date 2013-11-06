grammar Javascriptic;

@header {
package com.semkagtn.generated;
}

program
    : stat*
    ; 

// unlike JavaScript in this language we MUST type ';' after statements which are expressions
stat
    : scopeStat        // { ... }
    | functionDecl
    | varDecl 
    | assign
    | ifStat
    | whileStat 
    | doWhileStat 
    | returnStat 
    | breakStat
    | continueStat
    | exprStat
    ;

scopeStat
    : '{' stat* '}'
    ;

functionDecl
    : 'function' ID '(' functionParams? ')' scopeStat
    ;

varDecl
    : 'var' ID ('=' expr)? ';'
    ;

assign
    : ID '=' expr ';'
    ;

ifStat
    : 'if' '(' expr ')' stat ('else' stat)? 
    ;

whileStat
    : 'while' '(' expr ')' stat
    ;

doWhileStat
    : 'do' stat 'while' '(' expr ')' ';'
    ;

// operations with priority
expr
    : op=('!' | '-') expr # UnaryExpr
    | expr op=('*' | '/' | '%') expr # MulDivModExpr
    | expr op=('+' | '-') expr # AddSubExpr
    | expr op=('<' | '<=' | '>' | '>=') expr # CmpExpr
    | expr op=('==' | '!=') expr # EqExpr
    | expr '&&' expr # AndExpr
    | expr '||' expr # OrExpr
    | '(' expr ')' # ParenExpr
    | ID # Variable
    | constantExpr # Constant
    | functionCall # FunctionCallExpr 
    ;

constantExpr
    : NUM
    | STR
    | BOOL
    | UNDEF
    ;

functionCall
    : ID '(' functionArgs? ')' 
    ;

returnStat
    : 'return' expr ';'
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

// abstract values
functionParams
    : param (',' param)* 
    ;

param
    : ID
    ;

// concrete values
functionArgs
    : expr (',' expr)*
    ;

NOT : '!' ;
MINUS : '-' ;
MUL : '*' ;
DIV : '/' ;
MOD : '%' ;
ADD : '+' ;
LT : '<' ;
LQ : '<=' ;
GT : '>' ;
GE : '>=' ;
EQ : '==' ;
NE : '!=' ;

NUM : DIGIT+ ; // we can get negative numbers using unary minus operator
STR : '"' (ESC | . )*? '"' ; // unlike JavaScript only double quotes
BOOL : 'true' | 'false' ; 
UNDEF : 'undefined' ; 

ID : ID_LETTER (ID_LETTER | DIGIT)* ;

COMMENT : '/*' .*? '*/' -> skip ;
LINE_COMMENT : '//' .*? '\n' -> skip ;
WS : [ \t\r\n]+ -> skip ;

fragment DIGIT : [0-9] ;
fragment ID_LETTER : [a-zA-Z_$] ;
fragment ESC : '\\' [btnr"\\] ; 
