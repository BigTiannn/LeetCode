/**
 * https://oj.leetcode.com/problems/reverse-integer/
 * Reverse digits of an integer.
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * 
 * @author BigTiannn {11/01/2014}
 *
 */

public class ReverseInteger {
	
	public int reverse(int x) {
        boolean isNegative = false;
        
        if (x < 0) {
            isNegative = true;
            x = -x;
        }
        
        int ret = 0;
        while (x != 0) {
            ret = ret * 10 + x % 10;
            x = x / 10;
        }
        
        return isNegative ? -ret : ret;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
