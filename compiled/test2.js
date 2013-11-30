var from = 0;
var to = 1000;
var guessed = false;
print("Задумай число от " + from
        + " до " + to + ", а я буду угадывать.\n");
while (from <= to && !guessed) {
    var guess = round((from + to) / 2);
    print("Это " + guess
            + "? (< - меньше, > - больше, = - равно): ");
    var i = read();
    if (i == "<") {
        to = guess - 1;
    } else if (i == ">") {
        from = guess + 1;
    } else if (i == "=") {
        var guessed = true;
        print("Ура! Я молодец!\n");
    } else {
        print("Я ничего не понял!\n");
    }
}
if (!guessed) {
    print("Врёшь, так не бывает!\n");
}
