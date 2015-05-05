/**Problem70.java
 * {todo}
 @author Xiu Yi Tiger yixiu17@gmail.com
 Created on May 4, 2015 at 11:00:43 PM
 */
package Problem61to70;

import java.util.List;

import Algorithm.Algorithm1;
import Algorithm.Composite;
import Algorithm.Prime;

/**
 * @author Xiu Tiger Yi
 *
 */
public class Problem70 {

	public static void totientPermutation() {
		int limit = 10000000;
		Prime.setPrimes(limit);
		boolean[] isPrime = Prime.getIsPrimes();
		Composite.setComposite(limit);

		double totient = (double) 87109 / (double) 79180;
		for (Integer n = 3; n < limit; n += 2) {
			if (n % 3 != 0 && !(isPrime[n])) {

				List<Integer> factors = Composite.getFactors(n);
				if (factors.size() == 2 && factors.get(0) * factors.get(1) == n) {

					Integer count = factors.get(1) + factors.get(0) - 2;
					Integer rPrime = n - count - 1;
					if ((((double) n / (double) rPrime) < totient)
							&& Algorithm1.isPermuted(n, rPrime)) {
						totient = (double) n / (double) rPrime;
						System.out.println(n + "-" + rPrime + "-" + totient);
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		totientPermutation();

	}

}
