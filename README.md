Javascriptic
============

Simple and very slow Javascript-like language,
Written in java using [ANTLR4](http://antlr.org/) and [ASM library](http://asm.ow2.org/).

### Usage
    Собрать мавен-проект:
    $ mvn clean package
    Добавить CLASSPATH (для рантайма):
    $ export CLASSPATH=javascriptic-compiler-1.0-SNAPSHOT-jar-with-dependencies.jar:$CLASSPATH
    Компилировать так (примеры рабочего кода есть в examples)
    $ java -jar javascriptic-compiler-1.0-SNAPSHOT-jar-with-dependencies.jar test.js
    Запускать скомпилированный код так:
    $ java Out
### Standard functions
*    **Console.print(x1, x2,.., xn)** - prints *x1*, *x2*,.., *xn* to the console
*    **Console.println(x1, x2,.., xn)** - prints *x1*, *x2*,.., *xn* and *\n*(new line) to the console
*    **Console.read()** - returns user input
*    **Math.random()** - returns a pseudo-random number in the range [0, 1)
*    **Math.round(x)** - returns the value of *x* rounded to the nearest integer
*    **Math.ceil(x)** - returns the smallest integer greater or equal to *x*
*    **Math.floor(x)** - returns the largers integer less then or equal to *x*
*    **Math.min(x1, x2,.., xn)** - returns the lowest of *n* numbers
*    **Math.max(x1, x2,.., xn)** - returns the largest of *n* numbers
