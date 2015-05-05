/**Problem69.java
 * {todo}
 @author Xiu Yi Tiger yixiu17@gmail.com
 Created on May 2, 2015 at 5:41:01 AM
 */
package Problem61to70;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Algorithm.Prime;

/**
 * @author Xiu Tiger Yi
 *
 */
public class Problem69 {

	public static List<Integer> primes;

	public static boolean[] isPrime;

	public static void totientMax() {
		int limit = 1000000;
		Prime.setPrimes(limit);
		primes = Prime.getPrimes();
		isPrime = Prime.getIsPrimes();
		Integer product = 1;
		for (Integer prime : primes) {
			if (product * prime < limit) {
				product *= prime;
			} else {
				break;
			}
		}
		System.out.println(product);
	}

	public static Map<Integer, Integer> getCF(Integer n) {
		Integer index = 0;
		Map<Integer, Integer> ret = new HashMap<Integer, Integer>();
		while (!isPrime[n]) {
			while (n % primes.get(index) != 0) {
				index++;
			}
			ret.put(primes.get(index), 0);
			while (n % primes.get(index) == 0) {
				n /= primes.get(index);
				ret.replace(primes.get(index), ret.get(primes.get(index)) + 1);

			}
		}
		if (n != 1)
			ret.put(n, 1);
		return ret;
	}

	public static void main(String[] args) {
		totientMax();
	}
}
