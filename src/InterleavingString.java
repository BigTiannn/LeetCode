/**
 * https://oj.leetcode.com/problems/interleaving-string/
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * For example, Given:
 * s1 = "aabcc",
 * s2 = "dbbca",
 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false.
 * 
 * @author BigTiannn {11-22-2014}
 *
 */

public class InterleavingString {
	
	public static boolean isInterleave(String s1, String s2, String s3) {
		if (s1.length() == 0)
            return s2.equals(s3);
        if (s2.length() == 0)
            return s1.equals(s3);
        if (s1.length() + s2.length() != s3.length())
            return false;
            
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        
        // initialize dp[0][] and dp[][0]: if s3 can be interleaved with single string
        dp[0][0] = true;
        for (int i = 0; i < s1.length() && s1.charAt(i) == s3.charAt(i); i ++)
            dp[i + 1][0] = true;
        for (int i = 0; i < s2.length() && s2.charAt(i) == s3.charAt(i); i ++)
            dp[0][i + 1] = true;
        
        /* dp state transition function:
         * PAY ATTENTION: s3 starts from index 1!
         * dp[i][j]: if the s1[0...i] and s2[0..j] can interleave to form s3[0...i + j]
         * dp[i + 1][j + 1] = dp[i][j + 1] | dp[i + 1][j], if s1[i] == s2[j] == s3[i + j + 1]
         * dp[i + 1][j + 1] = dp[i][j + 1], if s1[i] == s3[i + j + 1]
         * dp[i + 1][j + 1] = dp[i + 1][j], if s2[j] == s3[i + j + 1]
         */
        for (int i = 0; i < s1.length(); i ++) {
            for (int j = 0; j < s2.length(); j ++) {
                if (s1.charAt(i) == s3.charAt(i + j + 1) && s2.charAt(j) == s3.charAt(i + j + 1)) {
                    dp[i + 1][j + 1] = dp[i][j + 1] | dp[i + 1][j];
                } else if (s1.charAt(i) == s3.charAt(i + j + 1)) {
                    dp[i + 1][j + 1] = dp[i][j + 1];
                } else if (s2.charAt(j) == s3.charAt(i + j + 1)) {
                    dp[i + 1][j + 1] = dp[i + 1][j];
                }
            }
        }
        
        return dp[s1.length()][s2.length()];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = new String("aabaac");
		String s2 = new String("aadaaeaaf");
		String s3 = new String("aadaaeaabaafaac");
		System.out.println(isInterleave(s1, s2, s3));
	}

}
