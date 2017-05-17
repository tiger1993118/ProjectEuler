/**Problem72.java
 * {todo}
 @author Xiu Yi Tiger yixiu17@gmail.com
 Created on May 5, 2015 at 6:23:30 AM
 */
package part1.problem071to080;

import java.math.BigInteger;
import java.util.List;

import Algorithm.Composite;
import Algorithm.Prime;

/**
 * @author Xiu Tiger Yi
 *
 */
public class Problem72 {

	public static void countingFractions() {
		Integer limit = 1000001;
		Prime.setPrimes(limit);
		Composite.setComposite(limit);
		boolean[] isPrime = Prime.getIsPrimes();
		BigInteger total = new BigInteger("0");
		for (Integer n = 2; n < limit; n++) {
			if (isPrime[n]) {
				total = total.add(BigInteger.valueOf(n - 1));
			} else {
				List<Integer> factors = Composite.getFactors(n);
				Long numer = (long) n, denom = 1L;
				for (Integer factor : factors) {
					numer *= (factor - 1);
					denom *= factor;
				}
				total = total.add(BigInteger.valueOf(numer / denom));
			}
		}
		System.out.println(total);
	}

	public static void main(String[] args) {
		countingFractions();
	}

}
