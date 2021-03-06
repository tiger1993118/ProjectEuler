/**SummationOfPrimes.java
TODO
@author Tiger Yi <a href = "mailto:yixiu17@gmail.com">yixiu17@gmail.com</a>
Created on2014-11-26
11:42:57 PM
 */
package part1.problem001to010;

public class Problem10 {

	public Problem10() {

	}

	public Long sOP(Integer n) {
		Long total = (long) 2;
		boolean[] isPrimes = new boolean[n + 1];
		isPrimes[1] = false;
		isPrimes[2] = true;
		for (int i = 3; i < n; i++) {
			if (i % 2 == 0) {
				isPrimes[i] = false;
			} else {
				isPrimes[i] = true;
			}

		}
		for (int i1 = 3; i1 < n; i1 += 2) {

			if (isPrimes[i1]) {
				for (int i2 = i1 + i1; i2 < n; i2 += i1) {
					if (i2 < n)
						isPrimes[i2] = false;
				}
			}
		}

		for (int i = 3; i < n; i += 2) {
			if (isPrimes[i]) {
				total += i;
			}
		}
		return total;

	}

	public static void main(String[] args) {
		Problem10 SOP = new Problem10();
		System.out.println(SOP.sOP(2000000));
	}
}
