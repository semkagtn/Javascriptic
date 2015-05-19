var Matrix = function(m, n) {
    var elements = [];

    if (n !== undefined) {
        // creating matrix M x N
        var i = 0;
        while (i < m) {
            elements[i] = [];
            var j = 0;
            while (j < n) {
                elements[i][j] = 0;
                j = j + 1;
            }
            i = i + 1;
        }
    } else if (m !== undefined) {
        // m must be correct matrix
        elements = m;
        m = elements.length;
        n = elements[0].length;
    } else {
        elements = [[0]];
        m = n = 1;
    }

    var matrix = [];
    matrix.set = function(i, j, value) {
        if (i < m && j < n) {
            elements[i][j] = value;
        }
    };
    matrix.get = function(i, j) {
        return elements[i][j];
    };
    matrix.transpose = function() {
        var newElements = [];
        var i = 0;
        while (i < m) {
            newElements[i] = [];
            var j = 0;
            while (j < n) {
                newElements[i][j] = elements[j][i];
                j = j + 1;
            }
            i = i + 1;
        }
        return Matrix(newElements);
    };
    matrix.toString = function() {
        var str = "";
        var i = 0;
        while (i < m) {
            str = str + elements[i] + "\n";
            i = i + 1;
        }
        return str;
    };
    return matrix;
};

var oneElementMatrix = Matrix();
Console.println("One element matrix:");
Console.println(oneElementMatrix.toString());

var zeroMatrix = Matrix(3, 3);
Console.println("Zero matrix:");
Console.println(zeroMatrix.toString());

var matrix = Matrix([[1, 2, 3],
                     [4, 5, 6],
                     [7, 8, 9]]);
matrix.set(1, 1, 0); 
Console.println("Matrix:");
Console.println(matrix.toString()); 

Console.println("Transpose matrix:");
Console.println(matrix.transpose().toString());

