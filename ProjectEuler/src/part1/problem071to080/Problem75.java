/**Problem75.java
 * {todo}
 @author Xiu Yi Tiger yixiu17@gmail.com
 Created on May 5, 2015 at 11:24:00 AM
 */
package part1.problem071to080;

/**
 * @author Xiu Tiger Yi
 *
 *         gcd and Pythagorean triple : a = m*m - n*n; b = 2*m*n; c = m*m + n*n
 */
public class Problem75 {

	public static void singularIntegerRightTriangles() {
		Integer limit = 1_500_000;
		Integer total = 0;
		int[] lengthTri = new int[limit];
		for (Integer m = 2; 2 * m * m + 2 * m < limit; m++) {
			for (Integer l = 2 * m * m + 2 * m, n = 1; n < m && l < limit; l += 2 * m, n++) {
				Integer a = m * m - n * n;
				Integer b = 2 * m * n;
				if (gcd(a, b) == 1) {
					for (Integer t = 1; t * l < limit; t++) {
						lengthTri[t * l] = lengthTri[t * l] + 1;
					}
				}
			}
		}
		for (Integer i = 0; i < lengthTri.length; i++) {
			if (lengthTri[i] == 1)
				total++;
		}
		System.out.println(total);
	}

	public static int gcd(Integer a, Integer b) {
		while (a % b != 0) {
			Integer r = a % b;
			a = b;
			b = r;
		}
		return b;
	}

	public static void main(String[] args) {
		singularIntegerRightTriangles();
	}
}
