grammar Javascriptic;

@header {
package com.semkagtn.javascriptic.generated;
}

program
    : stat*
    ; 

// Unlike JavaScript, in this language we MUST put a semicolon after certain statements
stat
    : blockStat       
    | varDeclStat
    | ifStat
    | whileStat 
    | doWhileStat
    | returnStat 
    | exprStat
    ;

blockStat
    : '{' stat* '}'
    ;

varDeclStat
    : 'var' ID ('=' expr)? ';'
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

returnStat
    : 'return' expr? ';'
    ;

exprStat
    : expr ';'
    ;

// operations with priority
expr
    : '(' expr ')' # Parens
    | expr (index | field) # GetField
    | expr '(' functionArgs? ')' # FunctionCall
    | op=('!' | '-' | '+') expr # UnaryExpr
    | expr op=('*' | '/' | '%') expr # MulDivMod
    | expr op=('+' | '-') expr # AddSub
    | expr op=('<' | '<=' | '>' | '>=') expr # Cmp
    | expr op=('==' | '!=' | '===' | '!==') expr # Eq
    | expr '&&' expr # And
    | expr '||' expr # Or
    | expr (index | field) '=' expr #PutField
    | ID '=' expr # Assign
    | ID # Var
    | (NUM | STR | BOOL | UNDEF) # Constant
    | '[' functionArgs? ']' # Array
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

index
    : '[' expr ']'
    ;

field
    : '.' ID
    ;

NOT : '!' ;
MINUS : '-' ;
MUL : '*' ;
DIV : '/' ;
MOD : '%' ;
PLUS : '+' ;
LT : '<' ;
LE : '<=' ;
GT : '>' ;
GE : '>=' ;
EQ : '==' ;
NE : '!=' ;
SEQ : '===' ;
SNE : '!==' ;

NUM : (DIGIT+ ('.' DIGIT+)?) | 'NaN' ; // we can get negative numbers using unary minus operator
STR : ('"' (ESC | ~["\\])*? '"') | ('\'' (ESC | ~[\'\\])*? '\'') ; 
BOOL : 'true' | 'false' ; 
UNDEF : 'undefined' ; 

ID : ID_LETTER (ID_LETTER | DIGIT)* ;

COMMENT : '/*' .*? '*/' -> skip ;
LINE_COMMENT : '//' .*? '\n' -> skip ;
WS : [ \t\r\n]+ -> skip ;

fragment DIGIT : [0-9] ;
fragment ID_LETTER : [a-zA-Z_$] ;
fragment ESC : '\\' ["\\/bfnrt] ; 
