/**
 * https://oj.leetcode.com/problems/wildcard-matching/
 * Implement wildcard pattern matching with support for '?' and '*'.
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * Some examples:
 * isMatch("aa","a") -> false
 * isMatch("aa","aa") -> true
 * isMatch("aaa","aa") -> false
 * isMatch("aa", "*") -> true
 * isMatch("aa", "a*") -> true
 * isMatch("ab", "?*") -> true
 * isMatch("aab", "c*a*b") -> false
 * 
 * @author BigTiannn {11-26-2014}
 *
 */
public class WildCardMatching {
	
	/*
	 * Greedy
	 */
	public static boolean isMatch(String s, String p) {
		int i = 0, j = 0;
        int mark = -1;  // the index in s when we meet star in p
        int star = -1;  // the index of latest star in p
        
        while (i < s.length()) {
            if (j < p.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
                i ++;
                j ++;
            } else if (j < p.length() && p.charAt(j) == '*') {
                star = j ++;
                mark = i;
            } else if (star != -1) {  // s[i] != p[j]
                j = star + 1;
                i = ++ mark;    // pay attention here: if we failed at this time, next time s start matchig at (mark + 1)
            } else {
                return false;
            }
        }
        
        while (j < p.length() && p.charAt(j) == '*') {
            j ++;
        }
        
        return j == p.length();
    }

	public static void main(String[] args) {
		System.out.println(isMatch("aa","a"));
		System.out.println(isMatch("aa","aa"));
		System.out.println(isMatch("aaa","aa"));
		System.out.println(isMatch("aa","*"));
		System.out.println(isMatch("aa","a*"));
		System.out.println(isMatch("ab","?*"));
		System.out.println(isMatch("aab","c*a*b"));
		System.out.println(isMatch("abcaacabc","abc*aa*abd"));
	}

}
