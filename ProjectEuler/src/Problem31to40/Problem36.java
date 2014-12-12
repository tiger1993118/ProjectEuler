/**Problem36.java
TODO
@author Xiu Yi Tiger yixiu17@gmail.com
Created on2014-12-12
4:08:43 AM
 */
package Problem31to40;

/**
 * TODO The decimal number, 585 = 10010010012 (binary), is palindromic in both
 * bases.
 * 
 * Find the sum of all numbers, less than one million, which are palindromic in
 * base 10 and base 2.
 * 
 * (Please note that the palindromic number, in either base, may not include
 * leading zeros.)
 * 
 * Solution : Loop through numbers from 1 to 1 million, return True if both
 * base2 and base10 are panlindrome number. Transfer from base10 to base2 using
 * Integer.toString() which returns a String on base2. In order to check if the
 * number is palindromic, concatenating the string to compare the digits like
 * the first one and last have to be the same. Found all such number and sum
 * them up.
 * 
 * @author Tiger yi
 * 
 */
public class Problem36 {

	public final int limit = 1000000;

	public void doubleBase() {
		int sum = 0;
		for (Integer i = 1; i < limit; i++) {
			if (isPanlindrome(i.toString())) {
				if (isPanlindrome(Integer.toString(i, 2))) {
					System.out.println(i);
					sum += i;
				}
			}
		}
		System.out.println(sum);
	}

	public boolean isPanlindrome(String s) {
		int length = s.length();
		for (int i = 0; i < length / 2; i++) {
			char a = s.charAt(i);
			char b = s.charAt(length - i - 1);
			if (a != b) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		new Problem36().doubleBase();
	}

}
