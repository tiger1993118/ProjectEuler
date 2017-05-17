/**Problem88.java
 * {todo}
 @author Xiu Yi Tiger yixiu17@gmail.com
 Created on Jul 4, 2015 at 11:50:19 PM
 */
package part1.problem081to090;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Algorithm.Prime;

/**
 * @author Xiu Tiger Yi
 *
 */
public class Problem88 {

	public static void product_sum_numbers() {
		Integer size = 13000;
		Integer limit = 12001;
		Prime.setPrimes(size);
		boolean[] isPrime = Prime.getIsPrimes();
		BigInteger total = BigInteger.ZERO;
		int[] minimals = new int[size];
		List<Set<Integer>> nToKs = new ArrayList<Set<Integer>>();

		for (Integer n = 0; n < size; n++) {
			Set<Integer> ks = new HashSet<Integer>();
			ks.add(1);
			if (!isPrime[n]) {
				for (Integer a = 2; a <= Math.sqrt(n); a++) {
					if (n % a == 0) {
						Integer b = n / a;
						if (isPrime[a] && isPrime[b]) {
							int k = n - a - b + 2;
							minimals[k] = (minimals[k] == 0) ? n : Math.min(n,
									minimals[k]);
							ks.add(k);
						} else if (isPrime[a]) {
							for (Integer bK : nToKs.get(b)) {
								int k = n - a - b + 2;
								k = k + bK - 1;
								minimals[k] = (minimals[k] == 0) ? n : Math
										.min(n, minimals[k]);
								ks.add(k);
							}

						} else if (isPrime[b]) {
							for (Integer aK : nToKs.get(a)) {
								int k = n - a - b + 2;
								k = k + aK - 1;
								minimals[k] = (minimals[k] == 0) ? n : Math
										.min(n, minimals[k]);
								ks.add(k);
							}

						} else {
							for (Integer aK : nToKs.get(a)) {
								for (Integer bK : nToKs.get(b)) {
									int k = n - a - b + 2;
									k = k + aK + bK - 2;
									minimals[k] = (minimals[k] == 0) ? n : Math
											.min(n, minimals[k]);
									ks.add(k);
								}
							}
						}
					}
				}
			}
			nToKs.add(ks);
		}
		Set<Integer> minimal = new HashSet<Integer>();
		for (int k = 0; k < limit; k++) {
			minimal.add(minimals[k]);
		}
		for (int m : minimal) {
			total = total.add(BigInteger.valueOf(m));
		}
		System.out.println(total);
	}

	public static void main(String[] args) {
		product_sum_numbers();
	}

}
