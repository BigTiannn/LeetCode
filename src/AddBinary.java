/**
 * https://oj.leetcode.com/problems/add-binary/
 * Given two binary strings, return their sum (also a binary string).
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 * 
 * @author BigTiannn {11-02-2014}
 *
 */

public class AddBinary {
	
	public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1, j = b.length() - 1; 
        while (i >= 0 && j >= 0) {
            int tmp = a.charAt(i --) - '0' + b.charAt(j --) - '0' + carry;
            sb.append(tmp % 2);
            carry = tmp / 2;
        }
        
        while (i >= 0) {
            int tmp = a.charAt(i --) - '0' + carry;
            sb.append(tmp % 2);
            carry = tmp / 2;
        }
        
        while (j >= 0) {
            int tmp = b.charAt(j --) - '0' + carry;
            sb.append(tmp % 2);
            carry = tmp / 2;
        }
        
        if (carry > 0)
            sb.append(carry);
        
        return sb.reverse().toString();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "11", b = "1";
		System.out.println(addBinary(a, b));
	}

}
