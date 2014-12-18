/**Problem48.java
TODO
@author Xiu Yi Tiger yixiu17@gmail.com
Created on2014-12-18
2:16:52 AM
 */
package Problem41to50;

import java.math.BigInteger;

/**
 * TODO The series, 11 + 22 + 33 + ... + 1010 = 10405071317.
 * 
 * Find the last ten digits of the series, 11 + 22 + 33 + ... + 10001000.
 * 
 * Solution : Simply using BigInteger and its methods to get the sum.
 * 
 * @author Tiger yi
 * 
 */
public class Problem48 {

	public void selfPower() {
		BigInteger total = new BigInteger("0");
		for (Integer i = 1; i <= 1000; i++) {
			BigInteger thisI = new BigInteger(i.toString());
			BigInteger pow = thisI.pow(i);
			total = total.add(pow);
		}
		String s = total.toString();
		System.out.print(s.substring(s.length() - 10, s.length()));
	}

	public static void main(String[] args) {
		new Problem48().selfPower();

	}

}
