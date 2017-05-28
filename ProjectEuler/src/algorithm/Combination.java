/**Combination.java
TODO
@author Xiu Yi Tiger yixiu17@gmail.com
Created on2014-12-21
3:31:33 PM
 */
package algorithm;

import java.math.BigInteger;

public class Combination {

	public static BigInteger algorithm(Integer r, Integer n) {
		BigInteger nf = factorial(n);
		BigInteger rf = factorial(r);
		BigInteger nrf = factorial(n - r);
		BigInteger denom = rf.multiply(nrf);
		return nf.divide(denom);
	}

	public static BigInteger factorial(Integer n) {
		BigInteger ret = new BigInteger("1");
		while (n >= 1) {
			BigInteger tem = new BigInteger(n.toString());
			ret = ret.multiply(tem);
			n -= 1;
		}
		return ret;
	}

	public static void main(String[] args) {

	}

}
