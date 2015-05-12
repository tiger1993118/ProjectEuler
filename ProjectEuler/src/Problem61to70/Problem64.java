/**Problem64.java
 * {todo}
 @author Xiu Yi Tiger yixiu17@gmail.com
 Created on May 10, 2015 at 11:39:35 AM
 */
package Problem61to70;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xiu Tiger Yi
 *
 */
public class Problem64 {

	public static void oddPeriodSquareRoots() {
		Integer total = 0;
		Integer square = 2;
		Integer num = 8;
		Integer limit = 10000;
		boolean[] isOdd = new boolean[limit + 1];
		for (Integer n = 2; n <= limit; n++) {

			if (n == square * square) {
				square++;
				for (Integer x = 1; x * n < limit; x++) {
					isOdd[x * n] = true;
				}
			} else if (!isOdd[n]) {
				List<Double> lst = new ArrayList<Double>();
				double root = Math.sqrt(n);
				root -= Math.floor(root);
				while (!lst.contains(cutNumber(root, num))) {
					lst.add(cutNumber(root, num));
					root = 1 / root;
					root -= Math.floor(root);
				}
				Integer start = lst.indexOf((cutNumber(root, num)));
				if ((lst.size() - start) % 2 == 1) {
					System.out.println(n + "-" + lst + "-"
							+ (lst.size() - start));
				} else {
					for (Integer x = 1; x * n < limit; x++) {
						isOdd[x * n] = true;
					}
				}
				// total++;

			}
		}
		System.out.println(total);
	}

	public static double cutNumber(Double d, Integer numOfDigitsAfterDot) {
		String s = d.toString();
		int dot = s.indexOf(".");
		String sub = s.substring(0,
				Math.min(numOfDigitsAfterDot + dot + 1, s.length()));
		return Double.valueOf(sub);
	}

	public static void main(String[] args) {
		oddPeriodSquareRoots();
	}

}
