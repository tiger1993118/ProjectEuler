/**Probelm19.java
TODO
@author Xiu Yi Tiger yixiu17@gmail.com
Created on2014-11-30
4:00:40 PM
 */
package Problem11to20;

/**
 * TODO Counting Sundays You are given the following information, but you may
 * prefer to do some research for yourself.
 * 
 * 1 Jan 1900 was a Monday. Thirty days has September, April, June and November.
 * All the rest have thirty-one, Saving February alone, Which has twenty-eight,
 * rain or shine. And on leap years, twenty-nine. A leap year occurs on any year
 * evenly divisible by 4, but not on a century unless it is divisible by 400.
 * How many Sundays fell on the first of the month during the twentieth century
 * (1 Jan 1901 to 31 Dec 2000)?
 * 
 * 
 * Solution: What i do is to set the 1900-01-01 as Integer 1, because we know
 * that 1900-01-01 is a Monday, so the day before 1990-01-01(which is
 * 1989-12-30) must be a Sunday.Like we indirectly set 1989-12-30 as 0 so that
 * if the n-th day is divisible by 7 we know that n-th day must be a Sunday. Now
 * we have the algorithm, all we have to do is to loop through everyday from
 * 1901-01-01 to 2000-12-30, notice that we only care about first day of every
 * months. Adding the number of days of every month, the number will not only be
 * the n-th day but also the first day of every months. Be careful with February
 * have different number of days in leap year.
 * 
 * @author Tiger yi
 * 
 */
public class Problem19 {
	public static final Integer[] normal = { 31, 28, 31, 30, 31, 30, 31, 31,
			30, 31, 30, 31 };
	public static final Integer[] leap = { 31, 29, 31, 30, 31, 30, 31, 31, 30,
			31, 30, 31 };

	public static Integer countingSunday() {
		Integer counter = 0;
		Integer year = 1900;
		Integer day = 1;
		while (year < 2001) {
			if (year == 1900) {
				for (Integer days : normal) {
					day += days;
				}
			} else {
				Integer[] currentYear;
				if (year % 4 == 0) {
					currentYear = leap;
				} else {
					currentYear = normal;
				}
				for (Integer days : currentYear) {
					if (day % 7 == 0) {
						counter++;
					}
					day += days;
				}
			}
			year++;
		}

		return counter;
	}

	public static void main(String[] args) {
		System.out.println(Problem19.countingSunday());
	}
}
