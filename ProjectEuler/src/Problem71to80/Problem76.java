/**Problem76.java
 * {todo}
 @author Xiu Yi Tiger yixiu17@gmail.com
 Created on May 6, 2015 at 2:33:04 AM
 */
package Problem71to80;

/**
 * @author Xiu Tiger Yi
 *
 */
public class Problem76 {

	public static int countingSummations(int n, int bound) {
		Integer total = 0;
		if (n == 0)
			return 1;
		if (n == 1)
			return 1;
		if (bound == 1)
			return 1;
		for (Integer i = 1; i <= bound; i++) {
			int ret = countingSummations(n - i, Math.min(i, n - i));
			total += ret;
			// System.out.println(i + "-" + ret);
		}
		return total;
	}

	public static void main(String[] args) {
		int n = 100;
		System.out.println(countingSummations(n, n - 1));
	}
}
