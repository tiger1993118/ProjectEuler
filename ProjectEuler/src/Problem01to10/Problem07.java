/**Prime.java
TODO
@author Tiger Yi <a href = "mailto:yixiu17@gmail.com">yixiu17@gmail.com</a>
Created on2014-11-26
11:12:31 PM
 */
package Problem01to10;

import java.util.ArrayList;
import java.util.List;

public class Problem07 {

	public Problem07() {

	}

	public Integer prime(Integer i) {
		List<Integer> primes = new ArrayList<Integer>();
		primes.add(2);
		int n = 3;
		while (i > primes.size()) {
			if (isPrime(n)) {
				primes.add(n);
			}
			n++;
		}
		return primes.get(i - 1);
	}

	public boolean isPrime(Integer n) {
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public boolean isPrime2(List<Integer> primes, Integer n) {
		for (int i : primes) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Problem07 P = new Problem07();
		System.out.println(P.prime(10001));
	}

}
