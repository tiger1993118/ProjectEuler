/**Problem78.java
 * {todo}
 @author Xiu Yi Tiger yixiu17@gmail.com
 Created on May 6, 2015 at 10:07:19 AM
 */
package part1.problem071to080;

/**
 * @author Xiu Tiger Yi
 *
 */
public class Problem78 {
	static int limit = 10_0000;
	static int mill = 100_0000;

	public static void coinPartitions() {
		int[] tracks = new int[limit];
		tracks[0] = 1;
		tracks[1] = 1;
		int[][] counts = new int[limit][];
		counts[0] = new int[1];
		counts[0][0] = 1;
		counts[1] = new int[2];
		counts[1][0] = 0;
		counts[1][1] = 1;
		int ret = 0;
		for (Integer n = 2; n < limit; n++) {
			ret = 0;
			counts[n] = new int[n];
			int[] here = counts[n];

			for (Integer i = 1; i < n / 2.0; i++) {
				ret += counts[n - i][i];
				counts[n - i][i] = 0;
				ret %= mill;
				here[i] = ret;
			}

			for (Integer i = (n + 1) / 2; i < n; i++) {
				ret += tracks[n - i];
				ret %= mill;
				here[i] = ret;
			}
			ret++;

			if (n % 2 == 1) {
				counts[n / 2] = null;
			}
			tracks[n] = ret;

			if (ret % mill == 0) {
				System.out.println("-----" + n + "-" + ret);
				break;
			}
			System.out.println(n + "-" + ret);
		}
	}

	public static void coinPartitions2() {

		int[][] counts = new int[limit][];
		counts[1] = new int[2];
		counts[1][0] = 0;
		counts[1][1] = 1;

		Integer ret = 1, incre = 0, curr = 0;
		for (Integer n = 2; n < limit; n++) {
			int[] here = new int[n + 1];
			counts[n] = here;
			here[0] = 0;
			int[] last = counts[n - 1];
			int length = last.length;
			for (int i = 0; i < length; i++) {
				here[i + 1] = last[i];
			}

			for (Integer i = 1; i <= n / 2; i++) {
				incre = counts[n - i][i];
				ret += incre;
				if (ret > mill)
					ret -= mill;
				curr = here[i];
				curr += incre;
				if (curr > mill)
					curr -= mill;
				here[i] = curr;
			}

			if (n % 2 == 0) {
				counts[n / 2] = null;
			}
			if (ret == 0) {
				System.out.println(n + "-" + ret);
				break;
			}
			System.out.println(n + "-" + ret);
		}
	}

	public static void main(String[] args) {
		coinPartitions();
	}
}
