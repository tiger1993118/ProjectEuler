/**Problem17.java
TODO
@author Xiu Yi Tiger yixiu17@gmail.com
Created on2014-11-30
4:34:06 PM
 */
package part1.problem011to020;

/**
 * TODO If the numbers 1 to 5 are written out in words: one, two, three, four,
 * five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 * 
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out
 * in words, how many letters would be used?
 * 
 * 
 * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and
 * forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20
 * letters. The use of "and" when writing out numbers is in compliance with
 * British usage.
 * 
 * Solution: Most importantly be careful with the corner cases, like 100, 200 no
 * 'and' 11 to 19 is very unique etc.. other than that, if a number is over a
 * hundred simply add 'hundred' + 'add' to the length, and the length of the
 * number at 100th digit, the rest of the part belong to 10th. till we get to
 * the 1th , done!
 * 
 * @author Tiger yi
 * 
 */
public class Problem17 {
	public static String[] ones = { "", "one", "two", "three", "four", "five",
			"six", "seven", "eight", "nine" };
	public static String[] teens = { "ten", "eleven", "twelve", "thirteen",
			"fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
			"nineteen" };
	public static String[] tens = { "", "", "twenty", "thirty", "forty",
			"fifty", "sixty", "seventy", "eighty", "ninety" };

	public static String hundred = "hundred";

	public static String and = "and";

	public static Integer letterCounts() {
		Integer counter = 0;
		for (Integer i = 0; i < 1000; i++) {
			Integer number = 0;
			Integer hun = i / 100;
			Integer ten = (i - hun * 100) / 10;
			Integer one = (i - hun * 100 - ten * 10);
			if (hun > 0) {
				System.out.print(ones[hun] + hundred);
				number += ones[hun].length();
				number += hundred.length();
				if (i % 100 != 0) {
					System.out.print(and);
					number += and.length();
				}

			}
			if (ten > 0) {
				if (ten == 1) {
					System.out.print(teens[one]);
					number += teens[one].length();
				} else {
					System.out.print(tens[ten] + ones[one]);
					number += tens[ten].length();
					number += ones[one].length();
				}
			} else {
				System.out.print(ones[one]);
				number += ones[one].length();
			}
			System.out.println();
			System.out.println(i + " - " + number);

			counter += number;
		}

		counter += "onethousand".length();
		return counter;
	}

	public static void main(String[] args) {
		System.out.println(Problem17.letterCounts());
	}
}
