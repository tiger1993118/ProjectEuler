/**Problem86.java
 * {todo}
 @author Xiu Yi Tiger yixiu17@gmail.com
 Created on Jun 25, 2015 at 10:50:45 PM
 */
package Problem81to90;

/**
 * @author Xiu Tiger Yi
 *
 */
public class Problem86 {

	public static Integer limit = 1819;

	public static boolean[][] isInteger = new boolean[limit][limit * 2];

	public static void cuboidRoute() {
		Integer total = 0;
		for (Integer m = 2; m < limit; m++) {
			// m:1 in 3
			for (Integer b = 1; b < m; b++) {
				for (Integer a = 1; a <= b; a++) {
					total += isCount(a, b, m) ? 1 : 0;
				}
			}
			// m:2 in 3
			for (Integer a = 1; a < m; a++) {
				total += isCount(a, m, m) ? 1 : 0;
			}
			if (total > 100_0000) {
				System.out.println(m + "-" + total);
				break;
			}
		}
		System.out.println(total);

	}

	// 1818-1000457
	public static boolean isCount(Integer a, Integer b, Integer m) {
		double half = (double) (a + b + m) / 2;
		double abs_a = Math.abs(a - half);
		double abs_b = Math.abs(b - half);
		double abs_m = Math.abs(m - half);
		Integer side1, side2;
		if (abs_a <= abs_b && abs_a <= abs_m) {// a
			return isInteger[a][b + m];
		} else if (abs_b <= abs_a && abs_b <= abs_m) {// b
			return isInteger[b][a + m];
		} else {// m
			side1 = m;
			side2 = a + b;
		}
		double hypo = side1 * side1 + side2 * side2;
		double root = Math.round(Math.sqrt(hypo));
		if (root * root == hypo) {
			// System.out.println(a + "-" + b + "-" + m);
			isInteger[m][a + b] = true;
			return true;
		}
		return false;

	}

	public static void main(String[] args) {
		cuboidRoute();
	}

}
