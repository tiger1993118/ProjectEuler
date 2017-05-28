package algorithm;

import org.apache.commons.math3.fraction.*;

public class Matrix {
	
	/*
	 * Solve the matrix equation Ax=b
	 */
	public static BigFraction[] solve(BigFraction[][] A, BigFraction[] b, int dim) {
		for (int n = dim-1; n >= 0; n--) {
			BigFraction f = A[n][n].reciprocal();
			for (int j = n; j >= 0 ; j--) {//Row n
				A[n][j] = A[n][j].multiply(f);
			}
			b[n] = b[n].multiply(f);	
			BigFraction t;
			
			for (int i = n-1; i >= 0; i --) {//Row i between n-1 and 0
				t = A[i][n];
				A[i] = subtract(A[i], multiply(A[n], t, dim), dim);
				b[i] = b[i].subtract(b[n].multiply(t));
			}
		}
		
		// Construct the identity matrix
		for(int n = 0; n < dim; n++) {
			BigFraction t;
			for(int i = n+1; i < dim; i++) {
				t = A[i][n];
				A[i][n] = A[i][n].subtract(A[n][n].multiply(t));
				b[i] = b[i].subtract(b[n].multiply(t));
			}
		}
		return b;
	}
	
	/*
	 * Return the array, each value in a subtracted by corresponding value in b
	 */
	public static BigFraction[] subtract(BigFraction[] a, BigFraction[] b, int n) {
		BigFraction[] ret = new BigFraction[n];
		for (int i = 0; i < n; i++) {
			ret[i] = a[i].subtract(b[i]);
		}
		return ret;
	}
	
	/*
	 * return the multiplied array, each value multiplied by b
	 */
	public static BigFraction[] multiply(BigFraction[] a, BigFraction b, int n) {
		BigFraction[] ret = new BigFraction[n];
		for (int i = 0; i < n; i++) {
			ret[i] = a[i].multiply(b);
		}
		return ret;
	}
	
	/*
	 * return the multiplied array, each value in a multiplied by corresponding value in b 
	 */
	public static BigFraction[] multiply(BigFraction[] a, BigFraction[] b, int n) {
		BigFraction[] ret = new BigFraction[n];
		for (int i = 0; i < n; i++) {
			ret[i] = a[i].multiply(b[i]);
		}
		return ret;
	}
	
	/*
	 * Return the sum of the array
	 */
	public static BigFraction sum(BigFraction[] A, int n) {
		BigFraction ret = new BigFraction(0);
		for (int i=0; i < n; i++) {
			ret = ret.add(A[i]);
		}
		return ret;
	}
	
	/*
	 * Print the nxn matrix 
	 */
	public static void printMatrix(BigFraction[][] A, int n) {
		for (int i = 0; i < n; i++) {
			System.out.print("||");
			for (int j = 0; j < n; j++) {
				System.out.print(A[i][j]);
				System.out.print("|");
			}
			System.out.println("|");
		}
	}
	
	/*
	 * Print the array
	 */
	public static void printMatrix(BigFraction[] b, int n) {
			System.out.print("||");
			for (int j = 0; j < n; j++) {
				System.out.print(b[j]);
				System.out.print("|");
			}
			System.out.println("|");
	}
	
	public static void main(String[] args) {
		BigFraction[][] f = new BigFraction[3][3];
		f[0][0] = new BigFraction(1, 1);
		f[0][1] = new BigFraction(1, 1);
		f[0][2] = new BigFraction(1, 1);
		
		f[1][0] = new BigFraction(0, 1);
		f[1][1] = new BigFraction(2, 1);
		f[1][2] = new BigFraction(5, 1);
		
		f[2][0] = new BigFraction(2, 1);
		f[2][1] = new BigFraction(5, 1);
		f[2][2] = new BigFraction(-1, 1);
		
		BigFraction[] b = new BigFraction[3];
		b[0] = new BigFraction(6, 1);
		b[1] = new BigFraction(-4, 1);
		b[2] = new BigFraction(27, 1);
		
		
		printMatrix(solve(f, b, 3), 3);
		printMatrix(f, 3);
	}
}
