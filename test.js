/*
 * Вызов функций.
 * Аргументы функции.
 * Добавить стандартные функции
 */

var print;

var Greeter = function(name) {
    return function() {
        print("Hello " + name + "!");
    };
};

var greeter = Greeter();
greeter();
