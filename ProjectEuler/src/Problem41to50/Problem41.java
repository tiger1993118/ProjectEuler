/**Problem41.java
TODO
@author Xiu Yi Tiger yixiu17@gmail.com
Created on2014-12-16
10:40:43 PM
 */
package Problem41to50;

import java.util.HashSet;
import java.util.Set;

/**
 * TODO We shall say that an n-digit number is pandigital if it makes use of all
 * the digits 1 to n exactly once. For example, 2143 is a 4-digit pandigital and
 * is also prime.
 * 
 * What is the largest n-digit pandigital prime that exists?
 * 
 * @author Tiger yi
 * 
 */
public class Problem41 {

	public int primeLimit = 7654322;

	public boolean[] isPrime = new boolean[primeLimit];

	public void pandigitalPrime() {
		allPrimes();

		int max = 7654321;

		while (!isPrime[max]) {

			max -= 1;
			while (!isPandigital(max)) {
				max -= 1;
			}
		}

		System.out.println(max);
	}

	public boolean isPandigital(Integer n) {
		String s = n.toString();
		Set<Integer> digits = new HashSet<Integer>();
		for (int i = 1; i <= s.length(); i++) {
			digits.add(i);
		}
		Set<Integer> digits2 = new HashSet<Integer>();
		for (int i = 0; i < s.length(); i++) {
			if (!digits.contains(Character.getNumericValue(s.charAt(i)))) {
				return false;
			}
			digits2.add(Character.getNumericValue(s.charAt(i)));
		}
		if (digits.equals(digits2))
			return true;
		return false;
	}

	public void allPrimes() {
		isPrime[0] = false;
		isPrime[1] = false;
		for (int i = 2; i < primeLimit; i++) {
			isPrime[i] = true;
		}

		for (int i = 2; i < primeLimit; i++) {
			if (isPrime[i]) {
				for (int ni = i + i; ni < primeLimit; ni = ni + i) {
					isPrime[ni] = false;
				}
			}
		}
	}

	public static void main(String[] args) {
		new Problem41().pandigitalPrime();

	}

}
