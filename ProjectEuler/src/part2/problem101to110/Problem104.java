package part2.problem101to110;

import java.math.BigInteger;

import algorithm.Digits;
import algorithm.Pandigit;

public class Problem104 {

	
	public static void solve() {
		// Keep Track of the first couple digits in big Fibb number
		BigInteger n1_last = BigInteger.ONE, n2_last = BigInteger.ONE;
		// Keep Track of the last couple digits in big Fibb number
		BigInteger n1_first = BigInteger.ONE, n2_first = BigInteger.ONE;
		BigInteger last_nine, first_nine;
		BigInteger tem;
		
		// Keep only the cut number of first digit
		int cut = 20;
		for(int i = 3; i < 10000000; i++) {
			
			// First nine digit part
			tem = n2_first;
			n2_first = n2_first.add(n1_first);
			n1_first = tem;
			if(n2_first.toString().length() > cut) {// Trim the number
				n1_first = Digits.firstNDigits(n1_first, cut-1);// move n1 down one position
				n2_first = Digits.firstNDigits(n2_first, cut);
			}
			
			// Last nine digit part
			tem = n2_last;
			n2_last = n2_last.add(n1_last);
			n1_last = tem;
			n2_last = Digits.lastNDigits(n2_last, 9);
			
			//Check part
			first_nine = Digits.firstNDigits(n2_first, 9);
			last_nine = n2_last;
			if(Pandigit.isPandigital(first_nine.toString()) && Pandigit.isPandigital(last_nine.toString())) {
					System.out.println(i);
			}
		}
	}
	
	public static void main(String[] args) {
		Problem104.solve();
	}

}
