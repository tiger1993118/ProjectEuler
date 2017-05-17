/**Problem95.java
 * {todo}
 @author Xiu Yi Tiger yixiu17@gmail.com
 Created on Jul 12, 2015 at 12:25:02 AM
 */
package part1.problem091to100;

import java.util.ArrayList;
import java.util.List;

import Algorithm.Prime;

/**
 * @author Xiu Tiger Yi
 *
 */
public class Problem95 {

	public static void amicableChains() {
		int limit = 100_0000;
		int longestLength = 0, longestIndex = 0;
		int[] chainLength = new int[limit];
		chainLength[1] = 1;
		Prime.setPrimes(limit);
		boolean[] isPrime = Prime.getIsPrimes();
		for (int i = 2; i < limit; i++) {
			if (chainLength[i] == 0) {
				if (isPrime[i]) {
					chainLength[i] = -1;
				} else {
					int n = i;
					List<Integer> chain = new ArrayList<Integer>();
					do {
						chain.add(n);
						int sum = 1;// new sum of divisor
						for (int d = 2; d <= Math.sqrt(n); d++) {
							if (n % d == 0) {
								if (n == d * d) {
									sum += d;
								} else {
									sum += d;
									sum += (n / d);
								}
							}
						}
						n = sum;

					} while (n < limit && !isPrime[n] && n > i
							&& !chain.contains(n));
					if (chain.contains(n)) {
						int index = chain.indexOf(n);
						int length = chain.size() - index;
						for (int im = 0; im < index; im++)
							chainLength[chain.get(im)] = -1;
						for (int ip = index; ip < chain.size(); ip++)
							chainLength[chain.get(ip)] = length;
						if (length > longestLength) {
							longestLength = length;
							longestIndex = chain.get(index);
						}
					} else {
						for (int c : chain)
							chainLength[c] = -1;
					}
				}
			}
		}
		System.out.println(longestIndex);
	}

	public static void main(String[] args) {
		amicableChains();
	}

}
