/**LargestPrimeFactor.java
TODO
@author Tiger Yi <a href = "mailto:yixiu17@gmail.com">yixiu17@gmail.com</a>
Created on2014-11-26
6:57:36 PM
 */
package Problem01to10;

import java.util.ArrayList;
import java.util.List;

public class LargestPrimeFactor {

	public LargestPrimeFactor() {

	}

	public long infiniteDivide(long numerator, long denominator) {
		while (numerator % denominator == 0) {
			numerator = numerator / denominator;
		}
		return numerator;
	}

	public long lPF(long number) {
		List<Long> factors = new ArrayList<Long>();
		factors.add((long) 1);
		while (number != 1) {
			number = lPFHelper(factors.get(factors.size() - 1) + 1, number, number, factors);
		}
		return factors.get(factors.size() - 1);
	}

	public long lPFHelper(long start, long end, long number, List<Long> factors) {
		for (long i = start; i < end; i++) {
			if (number % i == 0) {
				factors.add(i);
				return infiniteDivide(number, i);
			}
		}
		factors.add(number);
		return 1;
	}

}
