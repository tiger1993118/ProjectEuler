/**Problem49.java
TODO
@author Xiu Yi Tiger yixiu17@gmail.com
Created on2014-12-18
2:26:09 AM
 */
package Problem41to50;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * TODO The arithmetic sequence, 1487, 4817, 8147, in which each of the terms
 * increases by 3330, is unusual in two ways: (i) each of the three terms are
 * prime, and, (ii) each of the 4-digit numbers are permutations of one another.
 * 
 * There are no arithmetic sequences made up of three 1-, 2-, or 3-digit primes,
 * exhibiting this property, but there is one other 4-digit increasing sequence.
 * 
 * What 12-digit number do you form by concatenating the three terms in this
 * sequence?
 * 
 * Solution : Compute all the four-digit primes, and loop through them. compute
 * all the permutations of current one(denote it b). If one permutation is
 * smaller than current one(denote it a), check whether it is a prime or not, if
 * yes, then compute the biggest one(denote c) such that c-b = b-a. Check
 * whether c is a prime. If yes, then a,b,c is the answer.
 * 
 * @author Tiger yi
 * 
 */
public class Problem49 {

	public int primeLimit = 10000;

	public boolean[] isPrime = new boolean[primeLimit];

	public List<Integer> primes = new ArrayList<Integer>();

	public String[] allP = { "0123", "0132", "0213", "0231", "0312", "0321",
			"1023", "1032", "1203", "1230", "1302", "1320", "2013", "2031",
			"2103", "2130", "2301", "2310", "3012", "3021", "3102", "3120",
			"3201", "3210" };

	public void primePermutation() {
		allPrimes();
		for (Integer prime : primes) {
			if (isPermutation(prime.toString())) {
				System.out.println(prime);
			}
		}
	}

	public boolean isPermutation(String s) {
		Set<Integer> ps = permutation(s);
		Integer n = Integer.parseInt(s);
		for (Integer p : ps) {
			if (p > 1000 && p < n) {
				if (isPrime[p]) {
					int next = 2 * n - p;
					if ((next < 10000) && isPrime[next]) {
						if (ps.contains(next)) {
							System.out.println(p + "" + n + "" + next);
						}
					}
				}
			}
		}
		return false;
	}

	public Set<Integer> permutation(String s) {
		char[] chars = s.toCharArray();
		Set<Integer> ret = new HashSet<Integer>();
		for (String oneP : allP) {
			String add = "";
			for (int i = 0; i < 4; i++) {
				add += chars[Character.getNumericValue(oneP.charAt(i))];
			}
			ret.add(Integer.parseInt(add));
		}
		ret.remove(Integer.parseInt(s));
		// System.out.println(ret);
		return ret;
	}

	public void allPrimes() {
		isPrime[0] = false;
		isPrime[1] = false;
		for (int i = 2; i < primeLimit; i++) {
			isPrime[i] = true;
		}

		for (int i = 2; i < primeLimit; i++) {
			if (isPrime[i]) {
				if (i > 1000) {
					primes.add(i);
				}
				for (int ni = i + i; ni < primeLimit; ni = ni + i) {
					isPrime[ni] = false;
				}
			}
		}
	}

	public static void main(String[] args) {
		new Problem49().primePermutation();
	}

}
