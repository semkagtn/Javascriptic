// Binary Search Tree

var Tree = function() {
    // Inner class
    var VALUE = 0;
    var LEFT = 1;
    var RIGHT = 2;
    var Node = function() {
        return [undefined, [], []];
    };

    // private field
    var root = Node();

    // public methods
    var tree = [];
    tree["insert"] = function(value) {
        var current = root;
        while (current[VALUE]) {
            if (value < current[VALUE]) {
                current = current[LEFT];
            } else if (value > current[VALUE]) {
                current = current[RIGHT];
            } else {
                return;
            }
        }
        current[VALUE] = value;
        current[LEFT] = Node();
        current[RIGHT] = Node();
    };
    tree["min"] = function() {
        var current = root;
        var min;
        while (current[VALUE]) {
            min = current[VALUE];
            current = current[LEFT];
        }
        return min;
    };
    tree["max"] = function() {
        var current = root;
        var max;
        while (current[VALUE]) {
            max = current[VALUE];
            current = current[RIGHT];
        }
        return max;
    };
    return tree;
};

var tree = Tree();
tree["insert"](9);
tree["insert"](1);
tree["insert"](7);
tree["insert"](2);
tree["insert"](20);
tree["insert"](1);
tree["insert"](3);
tree["insert"](4);
tree["insert"](10);
print(tree["min"]() + "\n");
print(tree["max"]() + "\n");
