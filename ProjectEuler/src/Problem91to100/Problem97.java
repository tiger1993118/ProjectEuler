/**Problem97.java
 * {todo}
 @author Xiu Yi Tiger yixiu17@gmail.com
 Created on Jul 12, 2015 at 12:11:54 AM
 */
package Problem91to100;

import java.math.BigInteger;

/**
 * @author Xiu Tiger Yi
 *
 */
public class Problem97 {

	public static void large_NonMersennPrime() {
		BigInteger bi = new BigInteger("1");
		BigInteger two = new BigInteger("2");
		for (int i = 0; i < 7830457; i++) {
			bi = bi.multiply(two);
			String s = bi.toString();
			if (s.length() > 10) {
				bi = new BigInteger(s.substring(s.length() - 10, s.length()));
			}
		}
		bi = bi.multiply(new BigInteger("28433"));
		String s = bi.toString();
		if (s.length() > 10) {
			bi = new BigInteger(s.substring(s.length() - 10, s.length()));
		}
		bi = bi.add(BigInteger.ONE);
		System.out.println(bi);
	}

	public static void main(String[] args) {
		large_NonMersennPrime();
	}

}
