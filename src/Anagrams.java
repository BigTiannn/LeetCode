import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/***
 * http://oj.leetcode.com/problems/anagrams/
 * Given an array of strings, return all groups of strings that are anagrams.
 * Note: All inputs will be in lower-case.
 * 
 * @author BigTiannn
 */
public class Anagrams {
	public static ArrayList<String> anagrams(String[] strs) {
		ArrayList<String> result = new ArrayList<>();
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        
        for (String str : strs) {
        	String sorted = sort(str);
        	if (!map.containsKey(sorted)) {
        		ArrayList<String> list = new ArrayList<>();
        		map.put(sorted, list);
        	}
        	map.get(sorted).add(str);
        }
        
        Iterator it = map.entrySet().iterator();
        while(it.hasNext()) {
        	Map.Entry entry = (Map.Entry) it.next();
        	ArrayList<String> list = (ArrayList<String>) entry.getValue();
        	if (list.size() > 1)
        		result.addAll(list);
        }
        
        return result;
    }
	
	public static String sort(String s) {
		char[] chars = s.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}

	public static void main(String[] args) {
		String[] strs = {"abc", "bca", "bac", "bbb", "bbca", "abcb"};
		System.out.println(Arrays.toString(anagrams(strs).toArray()));
	}

}
