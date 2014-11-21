/**
 * https://oj.leetcode.com/problems/palindrome-partitioning-ii/
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * For example, given s = "aab",
 * Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 * 
 * @author BigTiannn {11-20-2014}
 *
 */
public class PalindromePartitioningII {
	
	public static int minCut(String s) {
		int n = s.length();
        int[] cuts = new int[n + 1];  // cuts[i] records the minCut value of substring starting from i to the end
        boolean[][] p = new boolean[n][n];	// "p" stores the number of partitions, the cut number is partition number - 1.
        
        // initialization
        // worst case: every single character is a cut. So substr starting from i contains (n - i) cuts.
        for (int i = 0; i <= n; i ++)
            cuts[i] = n - i;
        
        // dp
        for (int i = n - 1; i >= 0; i --) {
            for (int j = i; j < n; j ++) {
                if ((s.charAt(i) == s.charAt(j) && j - i < 2) ||
                    (p[i + 1][j - 1] && s.charAt(i) == s.charAt(j))) {
                    p[i][j] = true;
                    cuts[i] = Math.min(cuts[i], 1 + cuts[j + 1]);
                }
            }
        }
        
        return cuts[0] - 1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minCut("aab"));
	}

}
