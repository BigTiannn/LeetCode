/**
 * https://oj.leetcode.com/problems/longest-palindromic-substring/
 * Given a string S, find the longest palindromic substring in S. 
 * You may assume that the maximum length of S is 1000, and there 
 * exists one unique longest palindromic substring.
 * 
 * @author BigTiannn {11-23-2014}
 *
 */

public class LongestPalindromicSubstring {
	
	/*
	 * Brute force: O(n^2)
	 * For every character, check if the substring whose center is the character is palindromic.
	 * Pay attention to handle both odd and even length of substring
	 */
	public static String longestPalindrome(String s) {
        int start = 0, end = 0;
        int maxlen = 0;
        
        for (int i = 0; i < s.length(); i ++) {
            // check odd length
            int j = 1, oddlen = 1;
            while (i - j >= 0 && i + j < s.length() && s.charAt(i - j) == s.charAt(i + j)) {
            	oddlen += 2;
            	j ++;
            }
            // substring[i-(j-1), i+(j-1)]
            if (oddlen > maxlen) {
            	maxlen = oddlen;
                start = i - (j - 1);
                end = i + (j - 1);
            }
            
            // check even length
            int evenlen = 0;
            j = 0;
            while (i - j >= 0 && i + 1 + j < s.length() && s.charAt(i - j) == s.charAt(i + 1 + j)) {
            	evenlen += 2;
            	j ++;
            }
            if (evenlen > maxlen) {
            	maxlen = evenlen;
                start = i - (j - 1);
                end = i + 1 + (j - 1);
            }
        }
        
        return s.substring(start, end + 1);
    }
	
	/*
	 * DP
	 * time complexity O(n^2), space complexity O(n^2)
	 */
	public String longestPalindrome_dp(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int start = 0, end = 0;
        int maxlen = 0;
        
        for (int i = 0; i < s.length(); i ++) {
            for (int j = 0; j <= i; j ++) {
                if (i == j) {
                    dp[j][i] = true;
                } else if (s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                }
                if (i - j + 1 > maxlen && dp[j][i]) {	// don't forget "&& dp[j][i]"
                    maxlen = i - j + 1;
                    start = j;
                    end = i;
                }
            }
        }
        
        return s.substring(start, end + 1);
    }
	
	public static String longestPalindrome_manacher(String s){
		int n = s.length();
		int longestBegin = 0;
		int maxlen = 1;
		boolean table[][] = new boolean[1000][1000];
		
		for(int i = 0; i < n; i ++){
			table[i][i] = true;
		}
		
		for(int i = 0; i < n-1; i ++){
			if(s.charAt(i)==s.charAt(i+1)){
				table[i][i+1] = true;
				longestBegin = i;
				maxlen = 2;
			}
		}
		
		for(int len = 3; len <= n; len ++){
			for(int i = 0; i < n - len + 1; i ++){
				int j = i + len - 1;
				if(s.charAt(i) == s.charAt(j) && table[i + 1][j - 1] == true){
					table[i][j] = true;
					maxlen = len;
					longestBegin = i;
				}
			}
		}
		System.out.println("maxlen:" + maxlen);
		System.out.println("longestBegin:" + longestBegin);
		return s.substring(longestBegin, longestBegin+maxlen);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestPalindrome("aab"));
		//System.out.println(longestPalindrome_manacher("efabcdedcba"));
	}

}
