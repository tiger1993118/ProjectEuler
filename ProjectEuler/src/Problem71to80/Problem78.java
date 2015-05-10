/**Problem78.java
 * {todo}
 @author Xiu Yi Tiger yixiu17@gmail.com
 Created on May 6, 2015 at 10:07:19 AM
 */
package Problem71to80;

import java.math.BigInteger;

/**
 * @author Xiu Tiger Yi
 *
 */
public class Problem78 {

	static BigInteger[][] counts = null;

	public static void coinPartitions() {
		int limit = 100_0000;
		counts = new BigInteger[limit][];
		counts[1] = new BigInteger[2];
		counts[1][1] = BigInteger.valueOf(1);
		BigInteger ret = new BigInteger("0");

		for (Integer n = 2; n < limit; n++) {
			counts[n] = new BigInteger[n + 1];
			counts[n][n] = BigInteger.valueOf(1);

			BigInteger added = new BigInteger("1");

			for (Integer i = 1; i < n; i++) {

				Integer rest = n - i;
				Integer bound = Math.min(n - i, i);
				for (Integer first = 2; first <= i / 2; first++) {
					for (Integer i2 = 1; i2 <= bound; i2++) {
						// added = added.add(last[i2]);
					}
				}
				// counts[n][i] = total;
				ret = ret.add(added);
			}

			if (ret.mod(BigInteger.valueOf(100_000))
					.equals(new BigInteger("0"))) {
				System.out.println(n + "-" + ret);
				break;
			}
			System.out.println(n + "-" + ret);
		}
	}

	// 1-1
	// 2-2
	// 3-3
	// 4-5
	// 5-7
	// 6-11
	// 7-15
	// 8-22
	// 9-30
	// 10-42
	// 11-56
	// 12-77
	// 13-101
	// 14-135
	// 15-176
	// 16-231
	// 17-297
	// 18-385
	// 19-490
	// 20-627
	// 21-792
	// 22-1002
	// 23-1255
	// 24-1575
	// 25-1958
	// 26-2436
	// 27-3010
	// 28-3718
	// 29-4565
	// 30-5604
	// 31-6842
	// 32-8349
	// 33-10143
	// 34-12310
	// 35-14883
	// 36-17977
	// 37-21637

	public static void main(String[] args) {
		coinPartitions();
	}

}
