// Simple stack

var Stack = function() {
    var array = [];

    var stack = [];
    stack.push = function(x) {
        array[array.length] = x;
    };
    stack.pop = function(x) {
        if (array.length != 0) {
            array.length = array.length - 1;
            return array[array.length];
        }
    };
    return stack;
};

var N = 10;

var stack = Stack();

var i = 0;
while (i < N) {
    stack.push(i);
    i = i + 1;
}

i = 0;
while (i < N) {
    Console.print(stack.pop(i) + " ");
    i = i + 1;
}

