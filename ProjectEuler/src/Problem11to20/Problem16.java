/**Problem16.java
TODO
@author Xiu Yi Tiger yixiu17@gmail.com
Created on2014-11-29
5:33:56 PM
 */
package Problem11to20;

/**
 * TODO 215 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 * 
 * What is the sum of the digits of the number 21000?
 * 
 * Solution : I save the result in an Integer array the length is the number of
 * power, each value in the array represent a single digit and the order of
 * array is backwards.e.g., [3,4,5] in the array represents 543 in real
 * number.And for each time a number multiplied by 2 is equal to for every
 * digits in the number multiplied by 2.But notice if a digit multiplied by 2 is
 * a 2 digits number(e.g., 6*2 = 12) then we move the 1 at 10th and add it the
 * value at next digit in the array, the value at this index decreased by
 * 10.Finally, we add up all the numbers in the array and give the final
 * sum.Tips: i always keep track of the highest digit so that i do not have to
 * loop through every digits every multiplication. Alternative solution : simply
 * using BigInteger and pow method. I prefer my solution is that it feels more
 * like programming.
 * 
 * @author Xiu Yi Tiger
 * 
 */
public class Problem16 {

	public Integer[] number;

	public Integer next;

	public final static Integer limit = 1000;

	public Problem16() {

		number = new Integer[limit];

		for (Integer i = 0; i < limit; i++) {

			number[i] = 0;
		}
		number[0] = 1;
		next = 1;
	}

	public Integer powerDigitSum() {
		Integer sum = 0;

		for (Integer i = 0; i < limit; i++) {
			multiplyBy2();
		}

		for (Integer i = 0; i < next; i++) {
			sum += number[i];
		}
		return sum;
	}

	public void multiplyBy2() {

		for (Integer i = 0; i < next; i++)
			number[i] = number[i] * 2;

		for (Integer i = 0; i < next; i++) {
			Integer product = number[i];
			if (product > 9) {
				number[i] = product - 10;
				number[i + 1] += 1;
			}
		}

		if (number[next] > 0)
			next += 1;
	}

	public static void main(String[] args) {
		Problem16 P16 = new Problem16();
		System.out.println(P16.powerDigitSum());
	}
}
