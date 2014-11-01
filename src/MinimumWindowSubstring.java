/**
 * https://oj.leetcode.com/problems/minimum-window-substring/
 * Given a string S and a string T, find the minimum window in S 
 * which will contain all the characters in T in complexity O(n).
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 * 
 * @author BigTiannn {10-31-2014}
 *
 */

public class MinimumWindowSubstring {
	
	public static String minWindow(String S, String T) {
		if (S.length() == 0 || S.length() < T.length())
			return "";
		
        // use an array to record how many times each character showing in T
		int[] charInT = new int[128];
		for (int i = 0; i < T.length(); i ++) {
			charInT[T.charAt(i)] ++;
		}
		
		int[] charInS = new int[128];
		int start = 0;
		int found = 0;	// the number of chars found in S which is also in T
		int minLength = Integer.MAX_VALUE;
		int winBegin = -1, winEnd = -1;
		for (int i = 0; i < S.length(); i ++) {
			if (charInT[S.charAt(i)] != 0) {
				charInS[S.charAt(i)] ++;
				if (charInS[S.charAt(i)] <= charInT[S.charAt(i)])
					found ++;
				// A window containing all chars in T has been found: S[start, i]
				// Now try to shrink the window to be a minimum window
				if (found == T.length()) {
					// Two shrinking condition (i.e. we can update start -> start + 1)
					// 1. the char is not in T;
					// 2. though char is in T, but there're still enough this chars in the remaining window
					while (start < i) {
						if (charInT[S.charAt(start)] == 0)
							start ++;
						else if (charInS[S.charAt(start)] > charInT[S.charAt(start)]) {
							charInS[S.charAt(start)] --;
							start ++;
						} else
							break;
					}
					// update minLength, winBegin and winEnd
					if (minLength > i - start + 1) {
						minLength = i - start + 1;
						winBegin = start;
						winEnd = i;
					}
					
					// Attention:
					// The first char in the window must be in T.
					// So before moving start forward, we need to update the number in substr by minusing 1
					charInS[S.charAt(start)]--;
					start ++;
					found --;
				}
			}
		}
		
		return winBegin == -1 ? "" : S.substring(winBegin, winEnd + 1);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "bdab";
		String t = "ab";
		System.out.println(minWindow(s, t));
	}

}
