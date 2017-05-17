/**Problem14.java
TODO
@author Tiger Yi <a href = "mailto:yixiu17@gmail.com">yixiu17@gmail.com</a>
Created on2014-11-28
6:12:12 PM
 */
package part1.problem011to020;

/**
 * TODO Longest Collatz sequence The following iterative sequence is defined for
 * the set of positive integers:
 * 
 * n → n/2 (n is even) n → 3n + 1 (n is odd)
 * 
 * Using the rule above and starting with 13, we generate the following
 * sequence:
 * 
 * 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1 It can be seen that this sequence
 * (starting at 13 and finishing at 1) contains 10 terms. Although it has not
 * been proved yet (Collatz Problem), it is thought that all starting numbers
 * finish at 1.
 * 
 * Which starting number, under one million, produces the longest chain?
 * 
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 * 
 * 
 * Solution : Instead of computing length of every collatz numbers, we will only
 * care the 'possible' longest one. e.g, if a -> b we must know that a takes
 * more steps than b, start from a to 1, and a is the 'possible longest one' and
 * b certainly does not take most steps. Based on this idea, Every numbers
 * appear between the process starting form a to 1, all takes less steps than a.
 * So i give a boolean array such that the array at index i not only represent
 * starting from number i, but also the value store in the array at i represents
 * whether i is the 'possible' longest starting point or not. The benefit of
 * this array is that 1.boolean array takes little space 2.we could always avoid
 * duplicating calculation if some starting point is already calculated
 * before(Because every starting point could only appear once, otherwise we will
 * have an infinite steps). After all the iteration we have true and false in
 * the arrays such that false represent is not the longest starting point and
 * true represents that this number might be the longest.Notice that this will
 * not give us the final longest one starting point, there might be more than
 * one trues in the array, but definitely a lot less than the input number. All
 * we have to is to loop through the array, find out the value at index i which
 * is true, and do a calculation steps starting at i, compare it with longest
 * value. Finally, we have our longest steps and the starting number.
 * 
 * @author Xiu Yi Tiger
 * 
 */
public class Problem14 {

	public boolean[] isLongest;
	public final int limit;

	public Problem14(Integer limit) {
		this.limit = limit;
		isLongest = new boolean[limit];

		for (Integer i = 2; i < limit; i++)
			isLongest[i] = true;

		isLongest[1] = false;
	}

	public Integer longestCollatz() {
		Integer max = 0;
		Integer index = 0;

		for (Integer in = 2; in < limit; in += 1) {
			if (isLongest[in]) {
				Long lon = (long) in;
				lon = algorithm(lon);
				notLongest(lon);
			}
		}

		for (Integer i = 1; i < limit; i += 1) {
			if (isLongest[i]) {
				Integer length = collatzCount(i);
				if (max < length) {
					max = length;
					index = i;
				}
			}
		}
		return index;
	}

	private Integer collatzCount(Integer i) {
		Integer counter = 1;
		long input = (long) i;

		while (input != 1) {
			input = algorithm(input);
			counter += 1;
		}
		return counter;
	}

	public void notLongest(Long input) {

		while (input != 1) {
			if (0 <= input && input < limit) {
				Integer i = (int) (long) input;
				if (!isLongest[i]) {
					input = (long) 1;
				}
				isLongest[i] = false;
			}
			input = algorithm(input);
		}
	}

	public Long algorithm(Long lon) {
		if (lon == 1) {
			return (long) 1;
		} else {
			if (lon % 2 == 0) {
				return lon / 2;
			} else {
				return 3 * lon + 1;
			}
		}
	}

	public static void main(String[] args) {
		Problem14 P14 = new Problem14(1000000);
		System.out.println(P14.longestCollatz());

	}
}
