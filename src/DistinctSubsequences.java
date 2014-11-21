/**
 * https://oj.leetcode.com/problems/distinct-subsequences/
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
 * A subsequence of a string is a new string which is formed from the original string by 
 * deleting some (can be none) of the characters without disturbing the relative positions 
 * of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 * 
 * Here is an example:
 * S = "rabbbit", T = "rabbit"
 * Return 3.
 * 
 * @author BigTiannn {11-20-2014}
 *
 */

public class DistinctSubsequences {
	
	public int numDistinct(String S, String T) {
        if (S.length() < T.length())
            return 0;
        
        int[][] m = new int[T.length() + 1][S.length() + 1];
        
        // initialization
        // m[0][i]: when T is empty, the number of sub sequences is 1.
        for (int i = 0; i <= S.length(); i ++)
            m[0][i] = 1;
        // m[i][0]: when S is empty, no sub sequences exists.
        // Note: i should start from 1!
        for (int i = 1; i <= T.length(); i ++)
            m[i][0] = 0;
        
        // dp
        for (int i = 1; i <= T.length(); i ++) {
            for (int j = 1; j <= S.length(); j ++ ) {
                m[i][j] = m[i][j - 1];
                if (T.charAt(i - 1) == S.charAt(j - 1)) {
                    m[i][j] += m[i - 1][j - 1];
                }
            }
        }
        
        return m[T.length()][S.length()];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
