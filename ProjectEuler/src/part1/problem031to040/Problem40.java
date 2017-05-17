/**Problem40.java
TODO
@author Xiu Yi Tiger yixiu17@gmail.com
Created on2014-12-12
5:42:54 PM
 */
package part1.problem031to040;

/**
 * An irrational decimal fraction is created by concatenating the positive
 * integers:
 * 
 * 0.123456789101112131415161718192021...
 * 
 * It can be seen that the 12th digit of the fractional part is 1.
 * 
 * If dn represents the nth digit of the fractional part, find the value of the
 * following expression.
 * 
 * d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000
 * 
 * Solution : Looping through 1 to 1000000, set an integer counter, add length
 * of each number to the counter, if the counter hit the index(e.g., 1, 10,
 * 100...), current number contain the digit we are looking for, do more
 * computation on the indices to find out the exact digit. Finally compute the
 * product of them all.
 * 
 * @author Tiger yi
 * 
 */
public class Problem40 {

	public void champernowneConstant() {
		int product = 1;
		int total = 0;
		int n = 0;
		for (Integer i = 1; i < 1000000; i++) {
			total += i.toString().length();

			if (total >= Math.pow(10, n)) {
				int index = (int) Math.pow(10, n) - total
						+ i.toString().length() - 1;
				int digit = Character.getNumericValue(i.toString()
						.charAt(index));
				System.out.println(digit);
				product *= digit;
				n += 1;
				if (n > 6)
					break;
			}
		}
		System.out.println(product);
	}

	public static void main(String[] args) {
		new Problem40().champernowneConstant();

	}

}
