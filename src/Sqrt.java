/***
 * http://oj.leetcode.com/problems/sqrtx/
 * 
 * @author BigTiannn
 */

public class Sqrt {
	
	public static int sqrt(int x) {
		long i = 1;
		while (i * i <= x) {
			i = i << 1;
		}
		
		for (i = i >> 1; i * i <= x; i ++)
			;
		
		return (int)i - 1;
	}
	
	public int sqrt_2(int x) {
        if (x < 0)  return -1;
      
        int left = 1, right = x;
        int last_middle = 0;
    
        while (left <= right) { // 1,5 
            int middle = (left + right) / 2; //
            if (x / middle > middle) {
                left = middle + 1;
                last_middle = middle;
            } else if (x / middle < middle) {
                right = middle - 1;
            } else {
                return middle;
            }
        }
        return last_middle;
    }

	public static void main(String[] args) {
		int test = 20;
//		int test = 2147483647;
//		System.out.println(Math.sqrt(test));
//		System.out.println(46340 * 46340);
		System.out.println(sqrt(test));
	}

}
