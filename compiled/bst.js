// Binary Search Tree (No remove function)

var Tree = function() {
    // Inner class
    var Node = function() {
        var node = [];
        return node;
    };

    // private field
    var root = Node();

    // public methods
    var tree = [];
    tree.insert = function(value) {
        var current = root;
        while (current.value !== undefined) {
            if (value < current.value) {
                current = current.left;
            } else if (value > current.value) {
                current = current.right;
            } else {
                return;
            }
        }
        current.value = value;
        current.left = Node();
        current.right = Node();
    };
    tree.min = function() {
        var current = root;
        var min;
        while (current.value) {
            min = current.value;
            current = current.left;
        }
        return min;
    };
    tree.max = function() {
        var current = root;
        var max;
        while (current.value) {
            max = current.value;
            current = current.right;
        }
        return max;
    };
    return tree;
};

// Tree test

var N = 30;
var MIN = 0;
var MAX = 10000;

var tree = Tree();

var i = 0;
while (i < N) {
    var random = Math.round(MIN + Math.random() * (MAX - MIN));
    Console.print("Insert " + random + "\n");
    tree.insert(random);
    i = i + 1;
}

Console.print("Min = " + tree.min() + '\n');
Console.print("Max = " + tree.max() + '\n');
