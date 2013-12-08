Javascriptic
============

Simple and very slow Javascript-like language,
Written in java using [ANTLR4](http://antlr.org/) and [ASM library](http://asm.ow2.org/).

### Usage
    $ git clone https://github.com/semkagtn/Javascriptic.git
    $ cd Javascriptic/compiled
    $ export CLASSPATH=$CLASSPATH:./runtime.jar
    $ java -jar javascriptic.jar test.js
    $ java Out

### Standard functions
*    **Console.print(text)** - print the text to the console
*    **Console.read()** - returns user input
*    **Math.random()** - returns a number from 0.0 to 1.0
*    **Math.round(number)** 
*    **Math.ceil(number)**
*    **Math.floor(number)**
*    **Math.min(x1, x2,.., xn)**
*    **Math.max(x1, x2,.., xn)**
