/**
 * https://oj.leetcode.com/problems/palindrome-number/
 * Determine whether an integer is a palindrome. Do this without extra space.
 * Note that negative integers are not palindromes.
 * 
 * @author BigTiannn {10-28-2014}
 *
 */
public class PalindromeNumber {
	
	public boolean isPalindrome(int x) {
		if (x < 0)
            return false;
        
        int divider = 1;
		while (x / divider > 9 || x / divider < -9)
			divider *= 10;
			
		while (x != 0) {
		    if (x / divider != x % 10)
		        return false;
		    x %= divider;
		    x -= x % 10;
		    x /= 10;
		    divider /= 100;
		}
		
		return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
