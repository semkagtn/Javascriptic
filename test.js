/*
 * Вызов функций.
 * Аргументы функции.
 * Добавить стандартные функции
 */
var print;
var Counter = function() {
    var i = 0;
    return function() {
        print((i = i + 1) + "\n");
    };
};

var c1 = Counter();
var c2 = Counter();
c1();
c1();
c1();
c2();
c1();
