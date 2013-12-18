var print = Console.print;
var read = Console.read;

// 1. 1 2 3 4 5 6 7 8 9
print("1. while test: ");
var i = 0;
while ((i = i + 1) < 10) {
    print(i + " ");
}
print("\n\n");

// 2. String comparing
if ("abc" < "abd") {
    print("2. \"abc\" < \"abd\"\n\n");
}

// 3. NaN
print("3. \"true\" * 500 == ");
print("true" * 500);
print("\n\n");

// 4. undefined
var undef;
print("4. " + undef + "\n\n");

// 5. Print function, but without whitespaces :(
var f = function() {
    return undefined;
};
print("5. " + f + "\n\n");

// 6. Implicit type conversion
if ("123" == 123)
    print("6. Yes, \"123\" == 123\t O_O\n");

// 7. Oh my JavaScript!
print("7. Oh my JavaScript\n");
f = function() {
    print("First ");
    f = function() {
        print("WTF? O_O\n");
    };
    print("call\n");
};
f();
f();
print("\n");

// 8. Funny cast number to bool (two logical not operators)
print("8. " + !!0 + " " + !!1 + "\n\n"); // false true

// 9. Typical JavaScript code
var func = function() {
    print(outer_var);
};
var outer_var = "9. :D";
func();
print("\n\n");

// 10. Recursion
var fact = function(n) {
    if (n > 0) {
        return n * fact(n - 1);
    }
    return 1;
};
print("10. 5! = " + fact(5) + "\n\n");

// 11. Too much (too few) arguments
print("11. Wrong number of arguments: \n");
var f = function(a, b) {
    print(a + " " + b + "\n");
};
f(1, 2, 3); // 1 2
f(1); // 1 undefined
print("\n");

// 12. Closure
print("12. Closure: ");
var Counter = function() {
    var i = 0;
    return function() {
        i = i + 1;
        print(i + " ");
    };
};
var c1 = Counter();
var c2 = Counter();
c1(); c1(); c1(); c2(); c1(); // 1 2 3 1 4
print("\n\n");

// 13. Arrays
var array = [1, 2, "hello", false, undefined, 0.9];
print("13. " + array + "\n");
array[array.length] = "New element"; // push
print(array + "\n\n");

// 14. String iteration
print("14. String iteration: ");
var abra = "abracadabra";
var i = 0;
while (i < abra.length) {
    print(abra[i] + " ");
    i = i + 1;
}
print("\n\n");

// 15. Arrays as dictonary
print("15. Arrays as dictonaries: ");
var dict = [];
dict["pi"] = 3.1416;
print('dict["pi"] = ' + dict.pi + '\n\n'); // dict["pi"] = dict.pi

// 16. Arrays as objects
print("16. Arrays as objects: ");
var Point = function(x, y) {
    // private fields
    var _x = x;
    var _y = y;

    var point = [];
    // public methods
    point.getX = function() {
        return _x;
    };
    point.getY = function() {
        return _y;
    };
    return point;
};
var p = Point(5, 3);
print("p = (" + p.getX() + ", " + p.getY() + ")\n\n");


// 17. Someone little example
print("17. \n");
var diff = function(f) {
    var dx = 0.000001;
    return function(x) {
        return (f(x + dx) - f(x)) / dx;
    };
};
var f = function(x) { return x * x * x; };
var df = diff(f);
print("f(x) = " + f + "\n");
print("df(x) = " + df + "\n");
print("df(5) = " + df(5) + "\n\n");

// 18. Standard library
// Console.print, Console.read
// Math.random, Math.round, Math.ceil, Math.floor
print('18. Standard library:\n');
var n = Math.random() * 1000;
print("n = " + n + "\n");
print("Math.round(n) = " + Math.round(n) + "\n");
print("Math.ceil(n) = " + Math.ceil(n) + "\n");
print("Math.floor(n) = " + Math.floor(n) + "\n\n");

// 19. Input
print("19. Input your name: ");
var Greeter = function(name) {
    return function() {
        print("Hello " + name + "!\n");
    };
};
var name = read();
var greeter = Greeter(name);
greeter();
