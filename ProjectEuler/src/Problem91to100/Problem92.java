/**Problem92.java
 * {todo}
 @author Xiu Yi Tiger yixiu17@gmail.com
 Created on Jul 6, 2015 at 2:39:15 PM
 */
package Problem91to100;

import Algorithm.Digits;

/**
 * @author Xiu Tiger Yi
 *
 */
public class Problem92 {

	public static void squareDigitChains() {
		int total = 0;
		boolean[] isArrivedAt89 = new boolean[568];
		for (Integer n = 1; n <= 567; n++) {
			Integer last = n;
			Integer sum;
			do {
				sum = Digits.digitSquareSum(last.toString());
				last = sum;
			} while (sum != 1 && sum != 89);
			if (sum == 89) {
				isArrivedAt89[n] = true;
			}
		}
		for (Integer n = 1; n < 1000_0000; n++) {
			Integer sum = Digits.digitSquareSum(n.toString());
			total += (isArrivedAt89[sum]) ? 1 : 0;
		}
		System.out.println(total);
	}

	public static void main(String[] args) {
		squareDigitChains();
	}

}
