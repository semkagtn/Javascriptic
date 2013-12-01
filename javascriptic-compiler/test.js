var sort = function(a) {
    var len = length(a);
    var i = 0;
    while (i < len - 1) {
        var min = i;
        var j = i + 1;
        while (j < len) {
            if (a[j] < a[min]) {
                min = j;
            }
            j = j + 1;
        }
        if (min != i) {
            var tmp = a[i];
            a[i] = a[min];
            a[min] = tmp;
        }
        i = i + 1;
    }
};

var a = [1, 7, 3, 5, 4, 11, 8];
sort(a);
print(a + "\n");
