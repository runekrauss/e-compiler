// Different library imports
use(e.std.math)

/**
 * A point in a two-dimensional space
 *
 * @author Rune Krauss
 */
struct Point1 {
  int x;
  int y;
}

/**
 * One more point in a two-dimensional space
 *
 * @author Rune Krauss
 */
struct Point2 {
  float x;
  float y;
}

/**
 * Finds the square root of an integer.
 *
 * @param x Integer
 * @return Square root
 */
int sqrt(int x) {
  int result;
  // Illegal
  if (x < 0) {
    result = -1;
  }
  // Base cases
  if (x == 0 || x == 1) {
    result = x;
  } else {
    int temp = 1;
    int i = 1;
    /*
     * Starting from 1, try all numbers until
     * i*i is greater than or equal to x
     */
    while (temp <= x) {
      i = i + 1;
      temp = i * i;
    }
    result = i - 1;
  }
  return result;
}

/**
 * Calculates the distance between two points.
 *
 * @param x1 X value of the first point
 * @param y1 Y value of the first point
 * @param x2 X value of the second point
 * @param y2 Y value of the second point
 * @return Distance
 */
int dist(int x1, int y1, int x2, int y2) {
    int part1 = math.square(x2-x1): int;
    int part2 = math.square(y2-y1): int;
    int result = sqrt(part1+part2);
    return result;
}

// Create different points
Point1 p1 = new Point1(5, 2);
Point2 p2 = new Point2(3.7, 4.1);
p1.x = 1;

// Calculate the distance between these points
int dist = dist(p1.x, p1.y, toInt(p2.x), toInt(p2.y));

// Save the result in a list
int[] list = new int[3];
list[0] = dist;

// Output some information about the list
String txt = "Result: ";
String output = append(txt, toString(dist));

print(output);
