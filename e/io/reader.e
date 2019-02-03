#define noMain

/**
 * Reads an input from the console
 *
 * @return Input
 */
String readConsole() {
	invoke "static" "java/lang/System/console"() "Ljava/io/Console;";
	invoke "virtual" "java/io/Console/readLine"() "S";
	return topOfStack;
}
