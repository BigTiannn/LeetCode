import java.util.Arrays;

/**
 * https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/description/
 * 
 * Find the length of the longest substring T of a given string (consists of 
 * lowercase letters only) such that every character in T appears no less than k times.
 * Example 1:
 * Input: s = "aaabb", k = 3
 * Output: 3
 * The longest substring is "aaa", as 'a' is repeated 3 times.
 * Example 2:
 * Input: s = "ababbc", k = 2
 * Output: 5
 * The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 * 
 * @author BigTiannn
 *
 */

public class LongestSubstringWithAtLeastKRepeatingCharacters {

  public int longestSubstring(String s, int k) {
    int[] freq = new int[26];
    for (int i = 0; i < s.length(); i ++) {
      freq[s.charAt(i) - 'a'] ++;
    }
    System.out.println(Arrays.toString(freq));
    StringBuilder regex = new StringBuilder("");
    boolean emtpyFlag = true;
    for (int i = 0; i < freq.length; i ++) {
      if (freq[i] < k && freq[i] > 0) {
        if (emtpyFlag) {
          regex.append((char)(i + 'a'));
          emtpyFlag = false;
        } else {
          regex.append("|" + (char)(i + 'a'));
        }
      }
    }
    System.out.println(regex.toString());
    if (regex.length() > 0) {
      String[] splitedArray = s.split(regex.toString());
      System.out.println(Arrays.toString(splitedArray));
      int max = 0;
      for (String sub : splitedArray) {
        max = Math.max(max, longestSubstring(sub, k));
      }
      return max;
    }
    return s.length();
  }

  public int solution2(String s, int k) {
    int n = s.length(), max = 0, i = 0;
    while (i + k <= n) {
      int mask = 0, max_idx = i;
      int[] freq = new int[26];
      for (int j = i; j < n; j ++) {
        int ch = s.charAt(j) - 'a';
        freq[ch] ++;
        if (freq[ch] < k)  mask |= (1 << ch);   // set bit "ch" to be 1
        else mask &= ~(1 << ch);
        if (mask == 0) {
          max = Math.max(max, j - i + 1);
          max_idx = j;
        }
      }
      i = max_idx + 1;
    }
    return max;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    LongestSubstringWithAtLeastKRepeatingCharacters  test = new LongestSubstringWithAtLeastKRepeatingCharacters();
    System.out.println(test.longestSubstring("aaabb", 3));
  }

}
