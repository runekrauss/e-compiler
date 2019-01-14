int mul(int a, int b) {
    return a*b;
}

int mul(int a) {
    return a;
}

int x;
x = 1;
int a;
if (x) {
    a = 3;
} else {
    a = 5;
}
int b;
b = 7+5*3;
print(mul(a, b));
