package algorithm;

public class IntegerHelper {
	
	public static int gcd(int a, int b) {
		if(a == 0|| b == 0) {
			return 1;
		}
		int tem;
		while(a % b != 0) {
			tem = b;
			b = a % b;
			a = tem;
		}
		return b;
	}
	
	public static int lcm(int a, int b) {
		return a*b/gcd(a, b);
	}
	
	public static void main(String[] args) {
		System.out.println(gcd(-12,-15));

	}

}
