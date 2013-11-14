var print = function(x) {
    /* code */
};

var Greeter = function(name) {
    return function() {
        print("Hello " + name + "!\n");
    };
};

var g = Greeter("Artyom");
g();
