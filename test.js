/* This * is * a * test * file */

function sayHello(name) {
    echo("Hello " + name + "!\n");
}

function calcD(a, b, c) {
    return b * b - 4 * a * c;
}

var greetings = true; 
var name = "Artyom"; 
var a = 1; /***********************************/
var b = 2; /* can't declarate on one line :(  */
var c = 3; /***********************************/ 

if (greetings) {
    sayHello(name);
}
echo( calcD(a, b, c) );

