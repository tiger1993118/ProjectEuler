package part2.problem101to110;

import java.math.BigInteger;

import org.apache.commons.math3.fraction.BigFraction;

import algorithm.Matrix;

public class Problem101 {
	
	/*
	 * Calculate the polynomial value of n
	 */
	public BigInteger polysum(Integer n) {
		BigInteger sum = BigInteger.ZERO;
		BigInteger x;
		for(int t = 0; t <= 10; t++) {
			x = new BigInteger(n.toString());
			sum = sum.add(x.negate().pow(t));
		}
		return sum;
	}
	
	public void solve() {
		// Calculate all the poly values from 1 to n
		BigInteger[] sum = new BigInteger[10];
		for(int n = 1; n <= 10; n++) {
			sum[n-1] = polysum(n);
		}
		
		// Construct the matrix equation
		BigFraction ret = new BigFraction(0);
		BigFraction[][] A;
		BigFraction[] b, x;
		for (int n = 1; n <= 10; n++) {
			A = new BigFraction[n][n];
			b = new BigFraction[n];
			x = new BigFraction[n];
			
			//Construct poly value matrix from 1 to i
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					A[i][j] = new BigFraction(i+1);
					A[i][j] = A[i][j].pow(j);
				}
				b[i] = new BigFraction(sum[i]);
				x[i] = new BigFraction(Math.pow(n+1, i));
			}
			
			//Solve the equation
			Matrix.solve(A, b, n);
			ret = ret.add(Matrix.sum(Matrix.multiply(x, b, n), n));
		}
		System.out.println(ret);
	}
	
	public static void main(String[] args) {
		Problem101 problem101 = new Problem101();
		problem101.solve();

	}

}
