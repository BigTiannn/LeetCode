/**
 * https://oj.leetcode.com/problems/plus-one/
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head of the list.
 * 
 * @author BigTiannn {11-02-2014}
 *
 */

public class PlusOne {
	
	public int[] plusOne(int[] digits) {
        int carry = 0;
        for (int i = digits.length - 1; i >= 0; i --) {
            int tmp = digits[i];
            if (i == digits.length - 1)
                tmp += 1;
            digits[i] = (tmp + carry) % 10;
            carry = (tmp + carry) / 10;
        }
        
        int k = 0;
        int ret[] = (carry > 0) ? new int[digits.length + 1] : new int[digits.length];
        if (carry > 0)
            ret[k ++] = carry;
        for (int d : digits)
            ret[k ++] = d;
        
        return ret;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
