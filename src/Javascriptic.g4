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
    | returnStat ';'
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
    : op=('!' | '-') expression # UnaryExpr
    | expression op=('*' | '/' | '%') expression # MulDivModExpr
    | expression op=('+' | '-') expression # AddSubExpr
    | expression op=('<' | '<=' | '>' | '>=') expression # CmpExpr
    | expression op=('==' | '!=') expression # EqExpr
    | expression '&&' expression # AndExpr
    | expression '||' expression # OrExpr
    | assignment # AssignExpr 
    | '(' expression ')' # ParenExpr
    | ID # Id
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
    : 'return' expression
    ;

functionParams
    : ID (',' ID)* 
    ;

functionArgs
    : expression (',' expression)*
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

NUM : DIGIT+ ;
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
