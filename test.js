function f(x, y, z) {
    var a = x + y + z;
    a = a + 1;
    var y = x;
    function g(a, b, c) {
        x = x + 3;
    }
}

f(1, 2, 2 + 2 * 2);
