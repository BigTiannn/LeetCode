/**
 * https://oj.leetcode.com/problems/multiply-strings/
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 * Note: The numbers can be arbitrarily large and are non-negative.
 * 
 * @author BigTiannn {11-24-2014}
 *
 */

public class MultiplyStrings {
	
	public String multiply(String num1, String num2) {
		int[] res = new int[num1.length() + num2.length()];
        
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        
        for (int i = 0; i < num1.length(); i ++) {
            for (int j = 0; j < num2.length(); j ++) {
                res[i + j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        
        int carry = 0;
        for (int i = 0; i < res.length; i ++) {
            int tmp = res[i] + carry;
            res[i] = tmp % 10;
            carry = tmp / 10;
        }
        
        // remove zeros from the most significant bits
        int high = res.length - 1;
        while (high >= 0 && res[high] == 0)
            high --;
        
        if (high < 0)
            return "0";
        
        StringBuilder sb = new StringBuilder();
        for (int i = high; i >= 0; i --)
            sb.append(res[i]);
        
        return sb.toString();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
