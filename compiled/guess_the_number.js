// Guess the number game

var from = 0;
var to = 1000;
var guessed = false;
print("Guess the number from " + from
        + " to " + to + "\n");
while (from <= to && !guessed) {
    var guess = round((from + to) / 2);
    print("Is it " + guess
            + "? (< - less, > - greater, = - equals): ");
    var i = read();
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
