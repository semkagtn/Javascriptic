// Binary Search Tree

var Tree = function() {
    // Inner class
    var Node = function() {
        var node = [];
        node.value = undefined;
        node.left = [];
        node.right = [];
        return node;
    };

    // private field
    var root = Node();

    // public methods
    var tree = [];
    tree.insert = function(value) {
        var current = root;
        while (current.value) {
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

var tree = Tree();
tree.insert(9);
tree.insert(1);
tree.insert(7);
tree.insert(2);
tree.insert(20);
tree.insert(1);
tree.insert(3);
tree.insert(4);
tree.insert(10);
print(tree.min() + '\n');
print(tree.max() + '\n');
