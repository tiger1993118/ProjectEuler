/**Problem80.java
 * {todo}
 @author Xiu Yi Tiger yixiu17@gmail.com
 Created on May 8, 2015 at 11:12:37 AM
 */
package part1.problem071to080;

import java.math.BigDecimal;

import Algorithm.Digits;

/**
 * @author Xiu Tiger Yi
 *
 */
public class Problem80 {

	public static void squareRootDigitalExpansion() {
		Integer sum = 0;
		Integer x = 1;
		for (Integer n = 1; n < 101; n++) {
			if (n != x * x) {
				BigDecimal incre = new BigDecimal(1.0);
				BigDecimal num = new BigDecimal(n);
				BigDecimal square = new BigDecimal(x - 1);
				for (Integer i = 0; i < 99; i++) {
					incre = incre.divide(BigDecimal.valueOf(10.0));
					while (square.pow(2).compareTo(num) == -1) {
						square = square.add(incre);
					}
					square = square.subtract(incre);
				}
				sum += Digits.digitSum(square.toString());
			} else {
				x++;
			}
		}
		System.out.println(sum);
	}

	public static void main(String[] args) {
		squareRootDigitalExpansion();
	}

}
