/**
 * https://oj.leetcode.com/problems/longest-substring-without-repeating-characters/
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 * 
 * @author BigTiannn {10-31-2014}
 *
 */

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
	
	public static int lengthOfLongestSubstring(String s) {
		int maxLen = 0, start = 0;
		// This hashmap is used to record the position of latest occurrence
		HashMap<Character, Integer> position = new HashMap<>();
        
    for (int i = 0; i < s.length(); i ++) {
      // current substring already contains the character
      if (position.containsKey(s.charAt(i)) && position.get(s.charAt(i)) >= start) {
        maxLen = Math.max(maxLen, i - start);
        start = position.get(s.charAt(i)) + 1;
      }
      position.put(s.charAt(i), i);
    }
    return Math.max(maxLen, s.length() - start);
  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "abcabcbb";
		System.out.println(lengthOfLongestSubstring(s1));
		String s2 = "bbbbbb";
		System.out.println(lengthOfLongestSubstring(s2));
		String s3 = "wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco";
		System.out.println(lengthOfLongestSubstring(s3));
	}

}
