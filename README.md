### Javascriptic
Very simple Javascript-like language,
written in java using ANTLR4 and ASM library.

### Usage
    $ git clone https://github.com/semkagtn/Javascriptic.git
    $ cd Javascriptic/compiled
    $ export CLASSPATH=$CLASSPATH:./runtime.jar
    $ java -jar javascriptic.jar test.js
    $ java Out

### Standard functions
*    **print(text)** - print the text to console
*    **read()** - returns user input
*    **round(number)** - for example: round(3.7) = 4 or round(3.4) = 3
*    **length(x)** - returns length of array or string (or an undefined for other arguments)
*    **random()** - returns a number from 0.0 to 1.0
