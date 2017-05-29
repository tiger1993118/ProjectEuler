package algorithm;

public class Pandigit {

	public static boolean isPandigital(String s) {
		if(s.length() < 9) {
			return false;
		}
		boolean[] digits = new boolean[10];
		digits[0] = true;
		for(int i = 1; i < 10; i++) {
			digits[i] = false;
		}
		for(char c : s.toCharArray()) {
			int i = c - '0';
			if(digits[i]) {
				return false;
			}else {
				digits[i] = true;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(Pandigit.isPandigital("432719685"));
	}
}
