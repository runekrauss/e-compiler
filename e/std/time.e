#define noMain

/**
 * Returns time in nanoseconds.
 *
 * @return Time
 */
int time() {
	invoke "static" "java/lang/System/nanoTime"() "J";
	asm {
	    "
	    ldc2_w 1000000
	    ldiv
	    l2i
	    "
	}
	setTopOfStack "int";
    setTopOfStack "int";
    return topOfStack;
}
