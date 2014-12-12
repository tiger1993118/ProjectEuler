/**Problem32.java
TODO
@author Xiu Yi Tiger yixiu17@gmail.com
Created on2014-12-11
11:41:52 PM
 */
package Problem31to40;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO We shall say that an n-digit number is pandigital if it makes use of all
 * the digits 1 to n exactly once; for example, the 5-digit number, 15234, is 1
 * through 5 pandigital.
 * 
 * The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing
 * multiplicand, multiplier, and product is 1 through 9 pandigital.
 * 
 * Find the sum of all products whose multiplicand/multiplier/product identity
 * can be written as a 1 through 9 pandigital.
 * 
 * HINT: Some products can be obtained in more than one way so be sure to only
 * include it once in your sum.
 * 
 * Observation : multiplicand/multiplier/product can be written as 1 through 9
 * pandigital so that every number could only appear once, it limits the product
 * such that if product is a five digits number then multiplicand and multiplier
 * could only be (2 two digit number) or (one digit number and three digit
 * number). And we know that the biggest it could get is 99 * 99 which is
 * smaller than 10000(smallest five digit number), contradiction. same goes with
 * when product is three digit number. So that product could only be a four
 * digit number. There are 2 cases for multiplicand and multiplier(totally five
 * digits left): either (one digit number and four digit number) or (two digit
 * number and three digit number).
 * 
 * Solution : From observation, looping through every four digit number starting
 * from 1000 to 9999, filter out the number that only have distinct digits, then
 * remove digits that already existed in the number, and compute every
 * combination from the rest of the digits, return true if there is a product we
 * are looking for, false otherwise, then sum them up.
 * 
 * @author Tiger yi
 * 
 */
public class Problem32 {

	public void pandigitalProduct() {
		int sum = 0;
		for (int n = 1000; n < 10000; n++) {
			int[] digits = breakDown(n);
			if (digits != null) {
				if (isPandigital1(digits, n)) {
					System.out.println(n);
					sum += n;
				} else if (isPandigital2(digits, n)) {
					System.out.println(n);
					sum += n;
				}
			}
		}
		System.out.println(sum);
	}

	public boolean isPandigital2(int[] existed, int n) {
		List<Integer> digits = new ArrayList<Integer>();
		for (int i = 1; i < 10; i++) {
			digits.add(i);
		}
		for (Integer i : existed) {
			digits.remove(i);
		}
		for (Integer divide : digits) {
			if (n / divide < 1000) {
				return false;
			} else if (n % divide == 0) {
				List<Integer> copy = new ArrayList<Integer>();
				copy.addAll(digits);
				copy.remove(divide);
				int value = n / divide;
				int[] valueDigits = breakDown(value);
				if (valueDigits != null) {
					for (Integer d : valueDigits) {
						copy.remove(d);
					}
					if (copy.isEmpty()) {
						System.out.print(divide + "*" + value + "=");
						return true;
					}
				}
			}
		}
		return false;
	}

	public boolean isPandigital1(int[] existed, int n) {
		List<Integer> digits = new ArrayList<Integer>();
		for (int i = 1; i < 10; i++) {
			digits.add(i);
		}
		for (Integer i : existed) {
			digits.remove(i);
		}

		for (Integer h : digits) {
			for (Integer t : digits) {
				for (Integer o : digits) {
					if (h != t && h != o && t != o) {
						int divide = h * 100 + t * 10 + o;
						if (n / divide < 10) {
							return false;
						} else if (n % divide == 0) {
							int value = n / divide;
							Integer vt = value / 10;
							Integer vo = value - vt * 10;
							List<Integer> copy = new ArrayList<Integer>();
							copy.addAll(digits);
							copy.remove(h);
							copy.remove(t);
							copy.remove(o);
							copy.remove(vt);
							copy.remove(vo);
							if (copy.isEmpty()) {
								System.out.print(divide + "*" + value + "=");
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}

	public int[] breakDown(int n) {
		int th, hu, te, on;
		th = n / 1000;
		n -= th * 1000;
		hu = n / 100;
		n -= hu * 100;
		te = n / 10;
		on = n - te * 10;
		if ((th != hu) && (th != te) && (th != on) && (hu != te) && (hu != on)
				&& (te != on) && (th != 0) && (hu != 0) && (te != 0)
				&& (on != 0)) {
			int[] ret = { th, hu, te, on };
			return ret;
		} else {
			return null;
		}
	}

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		new Problem32().pandigitalProduct();
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println(totalTime);
		
	}

}
