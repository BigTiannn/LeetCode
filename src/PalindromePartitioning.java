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
	public List<List<String>> partition(String s) {
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
