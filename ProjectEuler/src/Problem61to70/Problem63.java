/**Problem63.java
 * {todo}
 @author Xiu Yi Tiger yixiu17@gmail.com
 Created on Apr 25, 2015 at 11:30:45 PM
 */
package Problem61to70;

import java.math.BigInteger;

/**
 * @author Xiu Tiger Yi
 * 
 * time : 00:15:45
 * start : 2015-04-25 11:27
 */
public class Problem63 {

	public static int problem63() {
		int total = 0;

		for (Integer i = 1; i < 10; i++) {
			int pow = 1;
			BigInteger base = new BigInteger(i.toString());
			BigInteger curr = base.pow(pow);
			while (numOfDigits(curr) == pow) {
				total += 1;
				pow += 1;
				curr = base.pow(pow);
			}
		}
		return total;
	}

	public static int numOfDigits(BigInteger bi) {
		return bi.toString().length();
	}

	public static void main(String[] args) {
		System.out.println(problem63());
	}
}
