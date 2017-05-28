/**Polygonal.java
 * {todo}
 @author Xiu Yi Tiger yixiu17@gmail.com
 Created on Apr 26, 2015 at 1:31:40 AM
 */
package algorithm;

/**
 * @author Xiu Tiger Yi
 *
 */
public class Polygonal {

	public static Integer Triangle(Integer n) {
		return n * (n + 1) / 2;
	}

	public static Integer Square(Integer n) {
		return n * n;
	}

	public static Integer Pentagonal(Integer n) {
		return n * (3 * n - 1) / 2;
	}

	public static Integer Hexagonal(Integer n) {
		return n * (2 * n - 1);
	}

	public static Integer Heptagonal(Integer n) {
		return n * (5 * n - 3) / 2;
	}

	public static Integer Octagonal(Integer n) {
		return n * (3 * n - 2);
	}

}
