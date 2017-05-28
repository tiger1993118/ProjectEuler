/**Composite.java
 * {todo}
 @author Xiu Yi Tiger yixiu17@gmail.com
 Created on May 5, 2015 at 2:44:05 AM
 */
package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Xiu Tiger Yi
 *
 */
public class Composite {

	static List<Integer> primes;

	static boolean[] isPrimes;

	public static void setComposite(Integer n) {
		Prime.setPrimes(n);
		primes = Prime.getPrimes();
		isPrimes = Prime.getIsPrimes();
	}

	public static Map<Integer, Integer> getCF(Integer n) {
		Integer index = 0;
		Map<Integer, Integer> ret = new HashMap<Integer, Integer>();
		while (!isPrimes[n]) {
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

	public static List<Integer> getFactors(Integer n) {
		List<Integer> ret = new ArrayList<Integer>();
		for (Integer i = 0; !isPrimes[n] && i < primes.size(); i++) {
			Integer prime = primes.get(i);
			if (n % prime == 0) {
				ret.add(prime);
				n /= prime;
			}
			while (n % prime == 0) {
				n /= prime;
			}
		}
		if (n != 1) {
			ret.add(n);
		}
		return ret;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
