// Guess the number game

var print = Console.print;

function(min, max) {
    var from = min;
    var to = max;
    var guessed = false;
    print("Guess the number from " + from
            + " to " + to + "\n");
    while (from <= to && !guessed) {
        var guess = Math.round((from + to) / 2);
        print("Is it " + guess
                + "? (< - less, > - greater, = - equals): ");
        var i = Console.read();
        if (i == "<") {
            to = guess - 1;
        } else if (i == ">") {
            from = guess + 1;
        } else if (i == "=") {
            var guessed = true;
            print("Yeah!!\n");
        } else {
            print("I don't understand you!\n");
        }
    }
    if (!guessed) {
        print("You are a liar!\n");
    }
}(0, 1000);
