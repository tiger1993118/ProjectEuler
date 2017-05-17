/**Problem73.java
 * {todo}
 @author Xiu Yi Tiger yixiu17@gmail.com
 Created on May 5, 2015 at 8:11:00 AM
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
public class Problem73 {

	public static void countingFractionsInARange() {
		Integer limit = 12001;
		Prime.setPrimes(limit);
		Composite.setComposite(limit);
		boolean[] isPrime = Prime.getIsPrimes();
		BigInteger total = new BigInteger("0");
		for (Integer n = 4; n < limit; n++) {
			Integer upper = (int) Math.floor((double) n / 2.0);
			Integer lower = (int) Math.ceil((double) n / 3);
			if (isPrime[n]) {
				total = total.add(BigInteger.valueOf(upper - lower + 1));
			} else {
				Integer count = 0;
				List<Integer> factors = Composite.getFactors(n);
				for (Integer i = lower; i <= upper; i++) {
					boolean isPrimeR = true;
					for (Integer factor : factors) {
						if (i % factor == 0) {
							isPrimeR = false;
							break;
						}
					}
					if (isPrimeR) {
						total = total.add(BigInteger.valueOf(1));
						count++;
					}
				}
			}
		}
		System.out.println(total);
	}

	public static void main(String[] args) {
		countingFractionsInARange();

	}

}
