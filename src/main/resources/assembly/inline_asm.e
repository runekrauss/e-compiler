float number() {
    asm {
        "
        ldc 5.1
        ldc 0.4
        fadd
        "
    }
    setTopOfStack "float";
    return topOfStack;
}

print(number());
