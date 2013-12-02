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

// 8. Funny cast number to bool (double not)
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
array[length(array)] = "New element"; // push
print(array + "\n\n");

// 14. Input
print("14. Input your name: ");
var Greeter = function(name) {
    return function() {
        print("Hello " + name + "!\n");
    };
};
var name = read();
var greeter = Greeter(name);
greeter();
