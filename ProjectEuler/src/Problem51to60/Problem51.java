/**Problem51.java
TODO
@author Xiu Yi Tiger yixiu17@gmail.com
Created on2014-12-19
12:39:09 AM
 */
package Problem51to60;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * TODO By replacing the 1st digit of the 2-digit number *3, it turns out that
 * six of the nine possible values: 13, 23, 43, 53, 73, and 83, are all prime.
 * 
 * By replacing the 3rd and 4th digits of 56**3 with the same digit, this
 * 5-digit number is the first example having seven primes among the ten
 * generated numbers, yielding the family: 56003, 56113, 56333, 56443, 56663,
 * 56773, and 56993. Consequently 56003, being the first member of this family,
 * is the smallest prime with this property.
 * 
 * Find the smallest prime which, by replacing part of the number (not
 * necessarily adjacent digits) with the same digit, is part of an eight prime
 * value family.
 * 
 * 
 * Observation : 1. The digit we choose to replace cannot be the last digit, for
 * every even last digit is not a prime 2.The smallest prime to have 8 primes
 * must replace at least 3 digits(or multiplier of 3). Because if it replace 1
 * or 2 digits(or not multiplier of 3), in every one of three, the number will
 * be a multiplier of 3.So maximumly there are only 7 primes, not 8.
 * 
 * Solution : Loop through number(odd number, even number is not prime),
 * starting from 1001(at least have 3 digits to replace, last one not counted).
 * Find a number with these properties : 1.It is prime 2.It has at least three
 * same digits(excluding the last digit). 3. replace three of them into 0 - 9,
 * such that there are 8 primes of them. Return the number.
 * 
 * @author Tiger yi
 * 
 */
public class Problem51 {

	public boolean[] isPrime;

	public void primeDigit() {
		Integer primeLimit = 10000;
		allPrimes(primeLimit);
		boolean hasAnswer = false;
		Integer n = 1001;
		while (!hasAnswer) {

			if (isPrime[n]) {
				if (hasThree(n.toString())) {
					if (hasEightPrimes(n.toString())) {
						System.out.println(n);
						hasAnswer = true;
					}
				}
			}

			n += 2;

			if (n > primeLimit) {
				primeLimit *= 10;
				allPrimes(primeLimit);
			}
		}
	}

	public boolean hasThree(String n) {
		char[] cs = n.toCharArray();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : cs) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		map.put(n.charAt(n.length() - 1), map.get(n.charAt(n.length() - 1)) - 1);
		for (Integer i : map.values()) {
			if (i >= 3) {
				return true;
			}
		}
		return false;
	}

	public boolean hasEightPrimes(String n) {
		char[] cs = n.toCharArray();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : cs) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		map.put(n.charAt(n.length() - 1), map.get(n.charAt(n.length() - 1)) - 1);
		for (Character c : map.keySet()) {
			int time = map.get(c);
			Integer newc = 0;
			int good = 0;
			if (time == 3) {
				while (newc <= 9) {
					String s = n.replace(c.toString(), newc.toString());
					Integer i1 = Integer.parseInt(s);
					if (isPrime[i1] && i1.toString().length() == n.length()) {
						good += 1;
					}
					newc += 1;
				}

			} else if (time == 4) {
				for (int i = 0; i < 4; i++) {
					int index = nthOccurrence(n, c, i);
					while (newc <= 9) {
						String s = n.replace(c.toString(), newc.toString());
						if (index + 1 < s.length()) {
							String s1 = s.substring(0, index) + c
									+ s.substring(index + 1, s.length() - 1);
							if (isPrime[Integer.parseInt(s1)]) {
								good += 1;
							}
						}
						newc += 1;
					}
				}
			}
			if (good == 8) {
				return true;
			}
		}
		return false;
	}

	public int nthOccurrence(String str, char c, int n) {
		int pos = str.indexOf(c, 0);
		while (n-- > 0 && pos != -1)
			pos = str.indexOf(c, pos + 1);
		return pos;
	}

	public void allPrimes(Integer primeLimit) {
		isPrime = new boolean[primeLimit];
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
		new Problem51().primeDigit();
	}

}
