package Algorithm;

import org.apache.commons.math3.fraction.BigFraction;

/*
 * A object of a 2D point (x, y)
 * both of them are BigFraction for the purpose of calculation
 */
public class Point2D {
		
	BigFraction x, y; 
	public Point2D(Integer x, Integer y) {
		this.x = new BigFraction(x);
		this.y = new BigFraction(y);
	}
	
	public void setXY(Integer x, Integer y) {
		this.x = new BigFraction(x);
		this.y = new BigFraction(y);
	}
	
	/*
	 * Return true if p1 and p2 on the same side of line ab
	 * include edge case: if p1 is on the line, and p2 is not, then they are not on the same side
	 */
	public static boolean sameSide(Point2D a, Point2D b, Point2D p1, Point2D p2) {
		return side(a, b, p1) == side(a,b, p2);
	}
	
	/*
	 * Return a integer to indicate the side that the point p take, comparing to line ab
	 * -1 if p is on the left side(i.e. has a smaller x value)
	 * 0 if p is on the line(the line is infinite, not just bounded by ab)
	 * 1 if p is on the right side 
	 */
	public static int side(Point2D a, Point2D b, Point2D p) {
		// Special case if a and b has same y value
		if (b.y.subtract(a.y).compareTo(BigFraction.ZERO) == 0) {
			return p.y.subtract(b.y).compareTo(BigFraction.ZERO);// only need to compare value y
		}else {
			// Calculated by 
			// p_x - (b_x + (p_y - b_y)*(b_x - a_x)/(b_y - a_y))
			// (b_x - a_x)/(b_y - a_y)
			BigFraction n = (b.x.subtract(a.x)).divide(b.y.subtract(a.y));
			// (p_y - b_y)
			BigFraction m = p.y.subtract(b.y);
			//(p_y - b_y) * (b_x - a_x)/(b_y - a_y)
			BigFraction z = m.multiply(n);
			// x1 is the corresponding x value on the line ab, with the y from point p
			BigFraction x1 = b.x.add(z);
			// Compare value x and value x1 on the line ab
			return p.x.subtract(x1).compareTo(BigFraction.ZERO);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
