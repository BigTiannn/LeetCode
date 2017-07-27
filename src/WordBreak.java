/**
 * https://leetcode.com/problems/word-break/tabs/description
 * Given a non-empty string s and a dictionary wordDict containing a list of 
 * non-empty words, determine if s can be segmented into a space-separated 
 * sequence of one or more dictionary words. You may assume the dictionary 
 * does not contain duplicate words.
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 * Return true because "leetcode" can be segmented as "leet code".
 *
 *UPDATE (2017/1/4):
 * The wordDict parameter had been changed to a list of strings (instead of 
 * a set of strings). Please reload the code definition to get the latest changes.
 * 
 * @author BigTiannn
 *
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {
	
	public static boolean Solution1 (String s, Set<String> dict) {
		if (s == null)
			return false;
		
		int len = s.length();
		boolean[] result = new boolean[len + 1];
		result[0] = true;
		
		for (int i = 1; i <= len; i ++) {
			for (int j = 0; j < i; j ++) {
				if (result[j] && dict.contains(s.substring(j, i))) {
					result[i] = true;
					break;
				}
			}
		}
		return result[len];
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
