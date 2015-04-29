/**Problem60.java
 * {todo}
 @author Xiu Yi Tiger yixiu17@gmail.com
 Created on Jan 3, 2015 at 4:08:45 PM
 */
package Problem51to60;

import java.math.BigInteger;

import Algorithm.Prime2;

/**
 * @author Xiu Tiger Yi
 *
 */
public class Problem60 {
	// [11, 23, 743, 1871]

	// [11, 239, 1091, 1847]

	// [11, 239, 1049, 1847]

	// [23, 311, 677, 827]
	// [23, 677, 827, 1871]

	public void primePairSets() {
		Prime2 prime2 = new Prime2(5000000);

		Integer[] exists = { 11, 23, 743, 1871 };
		for (Integer prime : prime2.getPrimes()) {
			System.out.print(prime + "-");
			boolean valid = true;
			if (prime > 827) {
				for (Integer exist : exists) {
					BigInteger n1 = new BigInteger(exist + "" + prime);
					BigInteger n2 = new BigInteger(prime + "" + exist);
					// System.out.println(n1 + "-" + n2);
					if (!(n1.isProbablePrime(1) && n2.isProbablePrime(1))) {
						System.out.println(prime + "-" + n1 + "-" + n2);
						valid = false;
						break;
					}
				}
				if (valid) {
					System.out.println(prime);
					break;
				}
			}
		}

		// Integer pairLimit = 2000;
		// List<List<Integer>> pairs = new ArrayList<List<Integer>>();
		// for (int i1 = 0; i1 < primes.size(); i1++) {
		// int prime1 = primes.get(i1);
		// if (prime1 < pairLimit) {
		// for (int i2 = i1 + 1; i2 < primes.size(); i2++) {
		// int prime2 = primes.get(i2);
		// if (prime2 < pairLimit) {
		// Integer n1 = Integer.parseInt(prime1 + "" + prime2);
		// Integer n2 = Integer.parseInt(prime2 + "" + prime1);
		// if (Prime.isPrime(n1) && Prime.isPrime(n2)) {
		// List<Integer> curr = new ArrayList<Integer>();
		// curr.add(prime1);
		// curr.add(prime2);
		// // System.out.println(curr);
		// pairs.add(curr);
		// }
		// } else {
		// break;
		// }
		// }
		// } else {
		// break;
		// }
		// }
		// System.out.println(pairs);
		//
		// List<List<Integer>> quads = new ArrayList<List<Integer>>();
		// for (int i1 = 0; i1 < pairs.size(); i1++) {
		// List<Integer> pair1 = pairs.get(i1);
		// for (int i2 = i1 + 1; i2 < pairs.size(); i2++) {
		// List<Integer> pair2 = pairs.get(i2);
		//
		// Integer n1 = Integer.parseInt(pair1.get(0) + "" + pair2.get(0));
		// Integer n2 = Integer.parseInt(pair1.get(0) + "" + pair2.get(1));
		// Integer n3 = Integer.parseInt(pair1.get(1) + "" + pair2.get(0));
		// Integer n4 = Integer.parseInt(pair1.get(1) + "" + pair2.get(1));
		// Integer n5 = Integer.parseInt(pair2.get(0) + "" + pair1.get(0));
		// Integer n6 = Integer.parseInt(pair2.get(0) + "" + pair1.get(1));
		// Integer n7 = Integer.parseInt(pair2.get(1) + "" + pair1.get(0));
		// Integer n8 = Integer.parseInt(pair2.get(1) + "" + pair1.get(1));
		//
		// if (Prime.isPrime(n1) && Prime.isPrime(n2) && Prime.isPrime(n3)
		// && Prime.isPrime(n4) && Prime.isPrime(n5)
		// && Prime.isPrime(n6) && Prime.isPrime(n7)
		// && Prime.isPrime(n8)) {
		// List<Integer> curr = new ArrayList<Integer>();
		// curr.add(pair1.get(0));
		// curr.add(pair1.get(1));
		// curr.add(pair2.get(0));
		// curr.add(pair2.get(1));
		// Collections.sort(curr);
		// if (!quads.contains(curr))
		// quads.add(curr);
		// // System.out.println(curr);
		// }
		// }
		// }
		// System.out.println(quads);

		// System.out.println(pairs);

		// for (List<Integer> pair : pairs) {
		// for (int prime : primes) {
		// if (prime < 5000) {
		// if (prime > pair.get(0) && prime > pair.get(1)) {
		// Integer n1 = Integer.parseInt(pair.get(0) + "" + prime);
		// Integer n2 = Integer.parseInt(prime + "" + pair.get(0));
		// Integer n3 = Integer.parseInt(pair.get(1) + "" + prime);
		// Integer n4 = Integer.parseInt(prime + "" + pair.get(1));
		//
		// if (Prime.isPrime(n1) && Prime.isPrime(n2)
		// && Prime.isPrime(n3) && Prime.isPrime(n4)) {
		// List<Integer> curr = new ArrayList<Integer>();
		// curr.add(pair.get(0));
		// curr.add(pair.get(1));
		// curr.add(prime);
		// System.out.println(curr);
		// }
		// }
		// } else {
		// break;
		// }
		// }
		// }
		// System.out.println(pairs.size());

	}

	public static void main(String[] args) {
		new Problem60().primePairSets();

	}

}
