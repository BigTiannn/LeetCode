/**
 * https://oj.leetcode.com/problems/decode-ways/
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * The number of ways decoding "12" is 2.
 * 
 * @author BigTiannn {11-23-2014}
 *
 */
public class DecodeWays {
	
	public int numDecodings(String s) {
        if (s == null || s.length() == 0)
            return 0;
            
        int[] ways = new int[s.length() + 1];
        ways[0] = 1;
        ways[1] = s.charAt(0) == '0' ? 0 : 1;
        
        for (int i = 1; i < s.length(); i ++) {
            if (isValid(s.substring(i, i + 1))) {
                ways[i + 1] = ways[i];
            }
            if (isValid(s.substring(i - 1, i + 1))) {
                ways[i + 1] += ways[i - 1];
            }
        }
        
        return ways[s.length()];
    }
    
    public boolean isValid(String s) {
        if (s.charAt(0) == '0')
            return false;
        int val = Integer.parseInt(s);
        return val > 0 && val <= 26;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
