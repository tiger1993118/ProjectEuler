/**Problem28.java
TODO
@author Xiu Yi Tiger yixiu17@gmail.com
Created on2014-12-08
6:33:30 PM
 */
package Problem21to30;

/**
 * TODO Starting with the number 1 and moving to the right in a clockwise
 * direction a 5 by 5 spiral is formed as follows:
 * 
 * 21 22 23 24 25
 * 20  7  8  9 10
 * 19  6  1  2 11
 * 18  5  4  3 12
 * 17 16 15 14 13
 * 
 * It can be verified that the sum of the numbers on the diagonals is 101.
 * 
 * What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral
 * formed in the same way?
 * 
 * Observation : 1.Every number at the top-right position of each layer, is
 * a square of odd number increasingly(or the number of this layer multiplied
 * by 2 plus + 1), and this number is also the first number of this layer
 * 2.numbers appear four times in diagonals in each layer, and next number 
 * subtract this number is always 2 multiplied by the number
 * of this layer.
 * 
 * Solution : From observation, we could compute every first of each layer using
 * observation 1, and compute other 3 number in current layer using observation 2,
 * Add up all of them, that is the sum(Be careful with first number at layer 0 which
 * is 1, layer 0 only have 1 number instead of 4).
 * 
 * @author Tiger yi
 * 
 */
public class Problem28 {

	public void numberSpiralD(Integer size) {
		size = (size + 1) / 2;
		Integer total = 1;
		Integer first;
		Integer last = 1;
		for (int i = 1; i < size; i++) {
			first = last + i * 2;
			last = (int) Math.pow(i * 2 + 1, 2);
			total += (first + last) * 2;
		}
		System.out.println(total);
	}

	public static void main(String[] args) {
		new Problem28().numberSpiralD(1001);
	}

}
