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
    a = 5;
} else {
    a = 3;
}
int b;
b = a << 1;
print(mul(a, b));
