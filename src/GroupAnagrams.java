import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/group-anagrams/tabs/description
 * 
 * Given an array of strings, group anagrams together.
 * 
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
 * Return:
 * [
 *   ["ate", "eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 
 * Note: All inputs will be in lower-case.
 * 
 * @author BigTiannn
 *
 */

public class GroupAnagrams {
  public List<List<String>> solution(String[] strs) {
    HashMap<String, List<String>> map = new HashMap<>();
    for (String str : strs) {
      String sortedStr = sortString(str);
      if (!map.containsKey(sortedStr)) {
        List<String> list = new ArrayList<>();
        list.add(str);
        map.put(sortedStr, list);
      } else {
        map.get(sortedStr).add(str);
      }
    }
    List<List<String>> res = new ArrayList<List<String>>(map.values());
    return res;
  }
  
  private String sortString(String str) {
    char[] charArray = str.toCharArray();
    Arrays.sort(charArray);
    return new String(charArray);
  }
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
