var toChar = []; var toByte = [];
toChar[32] = " "; toByte[" "] = 32;
toChar[33] = "!"; toByte["!"] = 33;
toChar[34] = '"'; toByte['"'] = 34;
toChar[35] = "#"; toByte["#"] = 35;
toChar[36] = "$"; toByte["$"] = 36;
toChar[37] = "%"; toByte["%"] = 37;
toChar[38] = "&"; toByte["&"] = 38;
toChar[39] = "'"; toByte["'"] = 39;
toChar[40] = "("; toByte["("] = 40;
toChar[41] = ")"; toByte[")"] = 41;
toChar[42] = "*"; toByte["*"] = 42;
toChar[43] = "+"; toByte["+"] = 43;
toChar[44] = ","; toByte[","] = 44;
toChar[45] = "-"; toByte["-"] = 45;
toChar[46] = "."; toByte["."] = 46;
toChar[47] = "/"; toByte["/"] = 47;
toChar[48] = "0"; toByte["0"] = 48;
toChar[49] = "1"; toByte["1"] = 49;
toChar[50] = "2"; toByte["2"] = 50;
toChar[51] = "3"; toByte["3"] = 51;
toChar[52] = "4"; toByte["4"] = 52;
toChar[53] = "5"; toByte["5"] = 53;
toChar[54] = "6"; toByte["6"] = 54;
toChar[55] = "7"; toByte["7"] = 55;
toChar[56] = "8"; toByte["8"] = 56;
toChar[57] = "9"; toByte["9"] = 57;
toChar[58] = ":"; toByte[":"] = 58;
toChar[59] = ";"; toByte[";"] = 59;
toChar[60] = "<"; toByte["<"] = 60;
toChar[61] = "="; toByte["="] = 61;
toChar[62] = ">"; toByte[">"] = 62;
toChar[63] = "?"; toByte["?"] = 63;
toChar[64] = "@"; toByte["@"] = 64;
toChar[65] = "A"; toByte["A"] = 65;
toChar[66] = "B"; toByte["B"] = 66;
toChar[67] = "C"; toByte["C"] = 67;
toChar[68] = "D"; toByte["D"] = 68;
toChar[69] = "E"; toByte["E"] = 69;
toChar[70] = "F"; toByte["F"] = 70;
toChar[71] = "G"; toByte["G"] = 71;
toChar[72] = "H"; toByte["H"] = 72;
toChar[73] = "I"; toByte["I"] = 73;
toChar[74] = "J"; toByte["J"] = 74;
toChar[75] = "K"; toByte["K"] = 75;
toChar[76] = "L"; toByte["L"] = 76;
toChar[77] = "M"; toByte["M"] = 77;
toChar[78] = "N"; toByte["N"] = 78;
toChar[79] = "O"; toByte["O"] = 79;
toChar[80] = "P"; toByte["P"] = 80;
toChar[81] = "Q"; toByte["Q"] = 81;
toChar[82] = "R"; toByte["R"] = 82;
toChar[83] = "S"; toByte["S"] = 83;
toChar[84] = "T"; toByte["T"] = 84;
toChar[85] = "U"; toByte["U"] = 85;
toChar[86] = "V"; toByte["V"] = 86;
toChar[87] = "W"; toByte["W"] = 87;
toChar[88] = "X"; toByte["X"] = 88;
toChar[89] = "Y"; toByte["Y"] = 89;
toChar[90] = "Z"; toByte["Z"] = 90;
toChar[91] = "["; toByte["["] = 91;
toChar[92] = "\\"; toByte["\\"] = 92;
toChar[93] = "]"; toByte["]"] = 93;
toChar[94] = "^"; toByte["^"] = 94;
toChar[95] = "_"; toByte["_"] = 95;
toChar[96] = "`"; toByte["`"] = 96;
toChar[97] = "a"; toByte["a"] = 97;
toChar[98] = "b"; toByte["b"] = 98;
toChar[99] = "c"; toByte["c"] = 99;
toChar[100] = "d"; toByte["d"] = 100;
toChar[101] = "e"; toByte["e"] = 101;
toChar[102] = "f"; toByte["f"] = 102;
toChar[103] = "g"; toByte["g"] = 103;
toChar[104] = "h"; toByte["h"] = 104;
toChar[105] = "i"; toByte["i"] = 105;
toChar[106] = "j"; toByte["j"] = 106;
toChar[107] = "k"; toByte["k"] = 107;
toChar[108] = "l"; toByte["l"] = 108;
toChar[109] = "m"; toByte["m"] = 109;
toChar[110] = "n"; toByte["n"] = 110;
toChar[111] = "o"; toByte["o"] = 111;
toChar[112] = "p"; toByte["p"] = 112;
toChar[113] = "q"; toByte["q"] = 113;
toChar[114] = "r"; toByte["r"] = 114;
toChar[115] = "s"; toByte["s"] = 115;
toChar[116] = "t"; toByte["t"] = 116;
toChar[117] = "u"; toByte["u"] = 117;
toChar[118] = "v"; toByte["v"] = 118;
toChar[119] = "w"; toByte["w"] = 119;
toChar[120] = "x"; toByte["x"] = 120;
toChar[121] = "y"; toByte["y"] = 121;
toChar[122] = "z"; toByte["z"] = 122;
toChar[123] = "{"; toByte["{"] = 123;
toChar[124] = "|"; toByte["|"] = 124;
toChar[125] = "}"; toByte["}"] = 125;
toChar[126] = "~"; toByte["~"] = 126;

var Reader = function() {
    var buffer = "";
    var i = 0;

    var reader = [];
    reader.nextChar = function() {
        if (i == buffer.length) {
            buffer = Console.read();
            i = 0;
        }
        i = i + 1;
        return buffer[i - 1];
    };
    return reader;
};

var validate = function(source) {
    var errorCode = 0;
    var l = 0;

    var i = 0;
    while (i < source.length) {
        if (source[i] == '[') {
            l = l + 1;
        } else if (source[i] == ']') {
            l = l - 1;
            if (l < 0) return 2;
        }
        i = i + 1;
    }

    if (l > 0) {
        return 1;
    } else if (l < 0) {
        return 2;
    } else {
        return 0;
    }
};

var error = function(code) {
    if (code == 1) {
        Console.print("Error: Closing bracket(s) missing.");
    } else if (code == 2) {
        Console.print("Error: Opening bracket(s) missing.");
    } else {
        Console.print("Error: Unknown error code.");
    }
};

var brainfuck = function(source) {
    var memSize = 20000;
    var maxVal = 256;
    var mem = [];
    var pointer = 0;
    var l = 0;
    var reader = Reader();

    var i = 0;
    while (i < memSize) {
        mem[i] = 0;
        i = i + 1;
    }

    i = 0;
    while (i < source.length) {
        if (source[i] == '+') {
            if (mem[pointer] < maxVal) {
                mem[pointer] = mem[pointer] + 1;
            }
        } else if (source[i] == '-') {
            if (mem[pointer] > 0) {
                mem[pointer] = mem[pointer] - 1;
            }
        } else if (source[i] == ',') {
            mem[pointer] = toByte[reader.nextChar()];
        } else if (source[i] == '.') {
            var symbol = toChar[mem[pointer]];
            if (symbol === undefined) {
                symbol = '';
            }
            Console.print(symbol);
        } else if (source[i] == '<') {
            pointer = pointer - 1;
            if (pointer < 0) pointer = 0;
        } else if (source[i] == '>') {
            pointer = pointer + 1;
            if (pointer >= memSize) pointer = memSize - 1;
        } else if (source[i] == '[') {
            if (mem[pointer] == 0) {
                while (source[i] != ']' || l > 0) {
                    i = i + 1;
                    if (source[i] == '[') l = l + 1;
                    if (source[i] == ']') l = l - 1;
                }
            }
        } else if (source[i] == ']') {
            if (mem[pointer] != 0) {
                while (source[i] != '[' || l > 0) {
                    i = i - 1;
                    if (source[i] == '[') l = l - 1;
                    if (source[i] == ']') l = l + 1;
                }
            }
        }
        i = i + 1;
    }
};

var helloWorld = "++++++++++[>+++++++>++++++++++>+++>+<<<<-]>++.>+.+++++++..+++.>++.<<+++++++++++++++.>.+++.------.--------.>+.>.";


var source = helloWorld;

var errorCode = validate(source);
if (errorCode != 0) {
    error(errorCode);
} else {
    brainfuck(source);
}

