/**Problem71.java
 * {todo}
 @author Xiu Yi Tiger yixiu17@gmail.com
 Created on May 5, 2015 at 5:41:32 AM
 */
package Problem71to80;

import java.util.List;

import Algorithm.Composite;
import Algorithm.Prime;

/**
 * @author Xiu Tiger Yi
 *
 */
public class Problem71 {

	public static void orderedFractions() {
		Integer limit = 1000001;
		Prime.setPrimes(limit);
		Composite.setComposite(limit);
		boolean[] isPrime = Prime.getIsPrimes();
		double ratio = 10.0;
		Integer numer = 0, denom = 0;
		for (Integer n = 3; n <= limit - 1; n++) {
			if (n != 7) {
				Integer upper = (int) Math.floor(n * 3 / 7);
				Integer lower = (int) Math.ceil(n / ratio);
				if (isPrime[n]) {
					Integer estimate = upper;
					if ((double) n / (double) estimate < ratio) {
						ratio = (double) n / (double) estimate;
						numer = estimate;
						denom = n;
					}
				} else {
					List<Integer> factors = Composite.getFactors(n);
					for (Integer estimate = upper; estimate >= lower; estimate--) {
						boolean isNewNumer = true;
						for (Integer factor : factors) {
							if (estimate % factor == 0) {
								isNewNumer = false;
								break;
							}
						}
						if (isNewNumer) {
							ratio = (double) n / (double) estimate;
							numer = estimate;
							denom = n;
							break;
						}
					}
				}
			}
		}
		System.out.println(numer + "-" + denom + "-" + ratio);
	}

	public static void main(String[] args) {
		orderedFractions();

	}

}
