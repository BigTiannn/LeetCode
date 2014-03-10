/***
 * http://oj.leetcode.com/problems/sqrtx/
 * 
 * @author BigTiannn
 */

public class Sqrt {
	
	public static int sqrt (int x) {
		long i = 1;
		while (i * i <= x) {
			i = i << 1;
		}
		
		for (i = i >> 1; i * i <= x; i ++)
			;
		
		return (int)i - 1;
	}

	public static void main(String[] args) {
		int test = 20;
//		int test = 2147483647;
//		System.out.println(Math.sqrt(test));
//		System.out.println(46340 * 46340);
		System.out.println(sqrt(test));
	}

}
