/**
 * https://oj.leetcode.com/problems/palindrome-partitioning/
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * For example, given s = "aab", return
 * [
 *  ["aa","b"],
 *  ["a","a","b"]
 * ]
 *
 * @author BigTiannn {11-19-2014}
 *
 */

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
	
	// time complexity O(2^(n - 1))
	public List<List<String>> solution(String s) {
    List<List<String>> reslist = new ArrayList<>();
    List<String> list = new ArrayList<>();
    dfs(s, 0, reslist, list);
    return reslist;
  }
    
  public void dfs(String s, int start, List<List<String>> reslist, List<String> list) {
    if (start == s.length()) {
      reslist.add(new ArrayList<String>(list));
      return;
    }
    
    for (int i = start; i < s.length(); i ++) {
      if (isPalindrome(s, start, i)) {
        list.add(s.substring(start, i + 1));
        dfs(s, i + 1, reslist, list);
        list.remove(list.size() - 1);
      }
    }
  }
    
  public boolean isPalindrome(String s, int start, int end) {
    while (start < end) {
      if (s.charAt(start ++) != s.charAt(end --)) return false;
    }
    return true;
  }
  
  // solution 2
  // time complexity: O(n*2^n)
  public List<List<String>> partition(String s) {
    List<List<String>> res = new ArrayList<>();
    ArrayList<String> list = new ArrayList<>();
    // build 2d array - isPalindrome
    int n = s.length();
    boolean[][] isPalindrome = new boolean[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j <= i; j ++) {
        isPalindrome[j][i] = (i - j < 2 || isPalindrome[j + 1][i - 1]) && s.charAt(i) == s.charAt(j);
      }
    }
    dfs(s, 0, isPalindrome, res, list);
    return res;
  }
  private void dfs(String s, int start, boolean[][] isPalindrome, List<List<String>> res, List<String> list) {
    if (start == s.length()) {
      res.add(new ArrayList<>(list));
      return;
    }
    // "i" is the end of substring
    for (int i = start + 1; i <= s.length(); i ++) {
      String sub = s.substring(start, i);
      if (isPalindrome[start][i - 1]) {
        list.add(sub);
        dfs(s, i, isPalindrome, res, list);
        list.remove(list.size() - 1);
      }
    }
    return;
  }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
