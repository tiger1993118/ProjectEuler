/**Problem60.java
 * {todo}
 @author Xiu Yi Tiger yixiu17@gmail.com
 Created on Jan 3, 2015 at 4:08:45 PM
 */
package part1.problem051to060;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import algorithm.PrimeFirstN;

/**
 * @author Xiu Tiger Yi
 *
 */
public class Problem60 {

	public static Map<Integer, List<Integer>> prime_counts;

	public static void primePairSets() {
		PrimeFirstN primes = new PrimeFirstN(5000000);
		boolean[] isPrimes = primes.getIsPrimes();
		System.out.println("okay");
		prime_counts = new HashMap<Integer, List<Integer>>();
		for (Integer prime : primes.getPrimes()) {
			if (prime > 10) {
				String s_prime = prime.toString();
				for (Integer i = 1; i < s_prime.length(); i++) {
					if (s_prime.charAt(i) != '0') {
						String s1 = s_prime.substring(0, i);
						String s2 = s_prime.substring(i, s_prime.length());
						Integer p1 = Integer.parseInt(s1);
						Integer p2 = Integer.parseInt(s2);
						Integer p_rev = Integer.parseInt(s2 + s1);
						if (isPrimes[p1] && isPrimes[p2] && isPrimes[p_rev]) {
							if (!prime_counts.containsKey(p1)) {
								List<Integer> primePair = new ArrayList<Integer>();
								primePair.add(p2);
								prime_counts.put(p1, primePair);
							} else {
								List<Integer> primePair = prime_counts.get(p1);
								if (!primePair.contains(p2))
									primePair.add(p2);
								prime_counts.put(p1, primePair);
							}
							if (!prime_counts.containsKey(p2)) {
								List<Integer> primePair = new ArrayList<Integer>();
								primePair.add(p1);
								prime_counts.put(p2, primePair);
							} else {
								List<Integer> primePair = prime_counts.get(p2);
								if (!primePair.contains(p1))
									primePair.add(p1);
								prime_counts.put(p2, primePair);
							}
						}
					}
				}
			}
		}
		recurrsiveFilters(0, null);
	}

	public static void recurrsiveFilters(Integer n,
			Map<Set<Integer>, List<Integer>> pre) {
		Integer total = 4;
		Map<Set<Integer>, List<Integer>> next = new HashMap<Set<Integer>, List<Integer>>();
		if (n == total) {
			System.out.println(pre);
		} else if (n == 0) {
			for (Iterator<Integer> it = prime_counts.keySet().iterator(); it
					.hasNext();) {
				Integer key = it.next();
				List<Integer> pairs = prime_counts.get(key);
				if (pairs.size() < (total - n)) {
					it.remove();
					for (Integer pair : pairs) {
						if (prime_counts.containsKey(pair)) {
							prime_counts.get(pair).remove((Integer) key);
						}
					}
				} else {
					Set<Integer> newKey = new HashSet<Integer>();
					newKey.add(key);
					next.put(newKey, pairs);
				}
			}
			recurrsiveFilters(n + 1, next);
		} else {
			for (Iterator<Set<Integer>> it = pre.keySet().iterator(); it
					.hasNext();) {
				Set<Integer> key = it.next();// a
				List<Integer> pairs = pre.get(key);// [...]_a
				for (Iterator<Integer> it2 = pairs.iterator(); it2.hasNext();) {// b
					Integer pair = it2.next();// b
					List<Integer> new_pairs = new ArrayList<Integer>();// [...]_a_b
					List<Integer> another_pairs = prime_counts.get(pair);// [...]_b
					if (another_pairs.size() <= pairs.size()) {
						for (Integer i : another_pairs) {
							if (pairs.contains(i)) {
								new_pairs.add(i);
							}
						}
					} else {
						for (Integer i : pairs) {
							if (another_pairs.contains(i)) {
								new_pairs.add(i);
							}
						}
					}
					if (new_pairs.size() < (total - n)) {
						it2.remove();
					} else {
						Set<Integer> new_key = new HashSet<Integer>();
						new_key.addAll(key);
						new_key.add(pair);
						next.put(new_key, new_pairs);
					}
				}
			}
			recurrsiveFilters(n + 1, next);
		}
	}

	public static void main(String[] args) {
		primePairSets();
	}
}
