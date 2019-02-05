#define noMain

/**
 * Returns a square number
 *
 * @param x Value
 * @return Squared value
 */
int square(int x) {
	return x * x;
}

/**
 * Compares two values and returns the bigger value.
 *
 * @param a Value 1
 * @param b Value 2
 * @return Bigger value
 */
int max(int a, int b) {
	int bigger = a;
	if (b > a) {
		bigger = b;
	}
	return bigger;
}

/**
 * Compares two values and returns the smaller value.
 *
 * @param a Value 1
 * @param b Value 2
 * @return Smaller value
 */
int min(int a, int b) {
	int smaller = a;
	if (b < a) {
		smaller = b;
	}
	return smaller;
}

/**
 * Returns the difference between 0 and a number.
 *
 * @param x Number
 * @return Difference between 0 and x
 */
int abs(int x) {
	if (x < 0) {
		x = -x;
	}
	return x;
}
