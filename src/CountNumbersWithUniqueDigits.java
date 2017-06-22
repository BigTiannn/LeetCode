/***
 * https://leetcode.com/problems/count-numbers-with-unique-digits/
 * Given a non-negative integer n, count all numbers with unique digits, x, where 0 <= x < 10^n.
 * Example:
 * Given n = 2, return 91. (The answer should be the total numbers in the range of 0 <= x < 100, 
 * excluding [11,22,33,44,55,66,77,88,99])
 * 
 * @author BigTiannn
 *
 */

public class CountNumbersWithUniqueDigits {
	// space: O(n), time: O(1)
	public static int solution(int n) {
		int ret = 0;
        int arr[] = new int [n + 1];
        for (int i = 0; i <= n; i ++) {
            if ( i == 0 ) {
                arr[i] = 1;
            } else if ( i == 1 ) {
                arr[i] = 9;
            } else {
                arr[i] = arr[i - 1] * (10 - (i - 1));
            }
            ret += arr[i];
        }
        return ret;
	}
	
	// space: O(1), time: O(1)
	public static int solution2(int n) {
		if ( n == 0 )   return 1;
        
        int ret = 10;
        int uniqueNumberPreviousN = 9;
        for (int i = 2; i <= n && n <= 10; i ++) {
            uniqueNumberPreviousN *= (10 - (i - 1));
            ret += uniqueNumberPreviousN;
        }
        return ret;
	}
		
	public static void main(String[] args) {
		System.out.println(solution(0));
		System.out.println(solution(1));
		System.out.println(solution(2));
		System.out.println(solution(3));
		System.out.println(solution(4));
		System.out.println(solution(5));
		System.out.println(solution(6));
		System.out.println(solution(7));
		System.out.println(solution(8));
		System.out.println(solution(9));
		System.out.println(solution(10));
		System.out.println(solution(11));
		System.out.println(solution(12));
		System.out.println(solution(50));
	}
}
