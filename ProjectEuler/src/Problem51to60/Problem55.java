/**Problem55.java
TODO
@author Xiu Yi Tiger yixiu17@gmail.com
Created on2014-12-29
7:41:26 PM
 */
package Problem51to60;

import java.math.BigInteger;

import Algorithm.Palindromic;

/**
 * TODO If we take 47, reverse and add, 47 + 74 = 121, which is palindromic.
 * 
 * Not all numbers produce palindromes so quickly. For example,
 * 
 * 349 + 943 = 1292, 1292 + 2921 = 4213 4213 + 3124 = 7337
 * 
 * That is, 349 took three iterations to arrive at a palindrome.
 * 
 * Although no one has proved it yet, it is thought that some numbers, like 196,
 * never produce a palindrome. A number that never forms a palindrome through
 * the reverse and add process is called a Lychrel number. Due to the
 * theoretical nature of these numbers, and for the purpose of this problem, we
 * shall assume that a number is Lychrel until proven otherwise. In addition you
 * are given that for every number below ten-thousand, it will either (i) become
 * a palindrome in less than fifty iterations, or, (ii) no one, with all the
 * computing power that exists, has managed so far to map it to a palindrome. In
 * fact, 10677 is the first number to be shown to require over fifty iterations
 * before producing a palindrome: 4668731596684224866951378664 (53 iterations,
 * 28-digits).
 * 
 * Surprisingly, there are palindromic numbers that are themselves Lychrel
 * numbers; the first example is 4994.
 * 
 * How many Lychrel numbers are there below ten-thousand?
 * 
 * NOTE: Wording was modified slightly on 24 April 2007 to emphasise the
 * theoretical nature of Lychrel numbers.
 * 
 * Solution : Two methods, one to check whether it is palindromic, another one
 * to add the reverse of the number.
 * 
 * @author Tiger yi
 * 
 */
public class Problem55 {

	public void lychrelNumber() {
		Integer count = 0;
		for (Integer i = 1; i < 10000; i++) {

			BigInteger bi = new BigInteger(i.toString());
			bi = new BigInteger(Palindromic.addReverse(bi.toString()));
			Integer time = 1;

			while (time < 50 && !Palindromic.isPalindromic(bi.toString())) {
				bi = new BigInteger(Palindromic.addReverse(bi.toString()));
				time += 1;

			}
			if (time >= 50) {
				System.out.println(i);
				count++;
			}
		}
		System.out.println(count);
	}

	public static void main(String[] args) {
		new Problem55().lychrelNumber();

	}

}
