// Delegation demonstration

// Super-class
var Animal = function(name) {
    var _name = name;

    var animal = [];
    animal.getName = function() {
        return _name;
    };
    animal.say = function() {
        Console.println("...");
    };
    return animal;
};

// Sub-class 1
var Cat = function(name) {
    var cat = Animal(name);

    cat.say = function() {
        Console.println("Meow!");
    };
    return cat;
};

// Sub-class 2
var Dog = function(name) {
    var dog = Animal(name);

    dog.say = function() {
        Console.println("Woof!");
    };
    return dog;
};

var animals = [];
animals[animals.length] = Cat("Felix");
animals[animals.length] = Dog("Pluto");
animals[animals.length] = Dog("Spike");
animals[animals.length] = Cat("Tom");
animals[animals.length] = Cat("Kitty");

var i = 0;
while (i < animals.length) {
    Console.print(animals[i].getName() + ": ");
    animals[i].say();
    i = i + 1;
}
