/**SmallestMultiple.java
TODO
@author Tiger Yi <a href = "mailto:yixiu17@gmail.com">yixiu17@gmail.com</a>
Created on2014-11-26
10:05:34 PM
 */
package part1.problem001to010;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Problem05 {

	public Problem05() {

	}

	public Integer sm(Integer n) {
		List<List<Integer>> factorsOfFactors = divideFactors(n);
		for (int i = factorsOfFactors.size() - 1; i >= 0; i--) {
			if (!factorsOfFactors.get(i).isEmpty()) {

				for (int i2 = 0; i2 < i; i2++) {
					List<Integer> factorsAtI = new ArrayList<Integer>(
							factorsOfFactors.get(i));
					factorsOfFactors.get(i2);
					for (Iterator<Integer> iter = factorsOfFactors.get(i2)
							.listIterator(); iter.hasNext();) {
						Integer factor = iter.next();
						if (factorsAtI.contains(factor)) {
							iter.remove();
							factorsAtI.remove(factor);
						}
					}
				}
			}
		}
		Integer product = 1;
		for (List<Integer> l : factorsOfFactors) {
			if (!l.isEmpty()) {
				for (Integer i : l) {
					product *= i;
				}
			}
		}
		return product;
	}

	public List<List<Integer>> divideFactors(Integer n) {
		List<List<Integer>> factorsOfFactors = new ArrayList<List<Integer>>();
		for (int i = 2; i <= n; i++) {
			if (isPrime(i)) {
				List<Integer> factors = new ArrayList<Integer>();
				factors.add(i);
				factorsOfFactors.add(factors);
			} else {
				factorsOfFactors.add(divide(i));
			}

		}
		return factorsOfFactors;
	}

	public List<Integer> divide(Integer number) {
		List<Integer> factors = new ArrayList<Integer>();
		Integer end = number;
		for (int i = 2; i < end; i++) {
			if (isPrime(i)) {
				while (number > 1 && number % i == 0) {
					factors.add(i);
					number = number / i;
				}
				if (number == 1) {
					return factors;
				}
			}
		}
		return factors;
	}

	public boolean isPrime(Integer n) {
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Problem05 SM = new Problem05();
		System.out.println(SM.sm(20));
	}
}
