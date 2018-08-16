/**Timer.java
 * {todo}
 @author Xiu Yi Tiger yixiu17@gmail.com
 Created on Aug 15, 2018 at 11:05:38 PM
*/
package algorithm;

/**
 * @author Xiu Tiger Yi
 *
 */
public class Timer {
	
	public static long start;
	
	public static double NANO = Math.pow(10, 9);
	public static long start() {
		start = System.nanoTime();
		return start;
	}
	
	public static double duartion() {
		return (System.nanoTime() - start) / NANO;
	}
	
	public static double duartion(long start) {
		return (System.nanoTime() - start) / NANO;
	}
}
