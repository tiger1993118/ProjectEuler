/**LargestPalindromeProduct.java
TODO
@author Tiger Yi <a href = "mailto:yixiu17@gmail.com">yixiu17@gmail.com</a>
Created on2014-11-26
7:21:04 PM
 */
package Problem01to10;

public class LargestPalindromeProduct {
	public LargestPalindromeProduct() {

	}

	public boolean isPalindrome(Integer n) {
		int length = String.valueOf(n).length() - 1;

		if ((length + 1) % 2 == 0) {
			for (int left = length; left >= (length + 1) / 2; left--) {
				int coefficient = (int) (n / Math.pow(10, left));
				n = (int) (n - coefficient * Math.pow(10, left) - coefficient
						* Math.pow(10, length - left));
			}
		} else {
			for (int left = length; left >= (length + 1) / 2; left--) {
				int coefficient = (int) (n / Math.pow(10, left));
				n = (int) (n - coefficient * Math.pow(10, left) - coefficient
						* Math.pow(10, length - left));
			}
			int coefficient = (int) (n / Math.pow(10, length / 2));
			n = (int) (n - coefficient * Math.pow(10, length / 2));
		}
		if (n == 0)
			return true;
		return false;
	}

	public Integer lPP(Integer n) {
		for (int i = n; i > 10000; i--) {
			if (isPalindrome(i)) {
				if (is3Product(i))
					return i;
			}
		}
		return 0;
	}
	
	public boolean is3Product(Integer n){
		for (int p = 999; p > 100; p --){
			if (n % p == 0){
				Integer p2 = n/p;
				if (1000 > p2 && p2 > 100){
					return true;
				}
			}
		}
		return false;
	}
}









