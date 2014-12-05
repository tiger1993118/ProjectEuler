/**Problem24.java
TODO
@author Xiu Yi Tiger yixiu17@gmail.com
Created on2014-12-04
9:59:36 PM
 */
package Problem21to30;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO A permutation is an ordered arrangement of objects. For example, 3124 is
 * one possible permutation of the digits 1, 2, 3 and 4. If all of the
 * permutations are listed numerically or alphabetically, we call it
 * lexicographic order. The lexicographic permutations of 0, 1 and 2 are:
 * 
 * 012 021 102 120 201 210
 * 
 * What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4,
 * 5, 6, 7, 8 and 9?
 * 
 * 
 * Solution: We compute each digit starting at the highest one.It has 10 options
 * 0~9 and we know the number starting with 0 gonna be the smallest and then
 * 1,.. the largest one starting with 9.so that all we have to do is to decide
 * our millionth belong to which section. Keep doing that till the last digit.
 * 
 * @author Tiger yi
 */
public class Problem24 {

	public static List<Integer> numbers = new ArrayList<Integer>();

	public static Integer product = 10;

	public static void lexicographic(Integer n) {
		numbers.add(0);
		int fraction = 0;
		for (Integer i = 1; i < 10; i++) {
			numbers.add(i);
			product *= i;
		}
		for (int i = 10; i >= 1; i--) {
			product = product / i;
			fraction = n / product;
			n = n % product;
			System.out.print(numbers.get(fraction));
			numbers.remove(fraction);

		}
	}

	public static void main(String[] args) {
		Problem24.lexicographic(999999);

	}
}
