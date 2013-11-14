var print = function(x) {
    /* code */
};

var input = function() {
    /* code */
};

var Greeter = function(name) {
    return function() {
        print("Hello " + name + "!\n");
    };
};


print("Greeting:\n");
var g1 = Greeter("Johnny");
var g2 = Greeter("Ivan");
g1();
g2();


print("Print numbers from 5 to 0:\n");
var x = 5;
while (x >= 0) {
    function(x) {
        print(x + "\n");
    }(); // create anonymous function and call it
    x = x - 1;
}


print("Input command: ");
var command = input();
if (command == "exit") {
    print("OK. Bye bye");
} else if (command == "2+2*2") {
    print(2 + 2 * 2);
} else {
    print("???");
}


