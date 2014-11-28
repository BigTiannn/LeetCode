/**
 * http://oj.leetcode.com/problems/anagrams/
 * Given an array of strings, return all groups of strings that are anagrams.
 * Note: All inputs will be in lower-case.
 * 
 * @author BigTiannn {11-26-2014}
 * 
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Anagrams {
	/*
	 * Denotion: k is the longest length of string, and n is the size of string array
	 * Space Complexity: O(n*k)
	 * Time Complexity: O(n*klgk)
	 */
	public List<String> anagrams(String[] strs) {
		// The key is the sorted string. Because if two strings are anagrams, their sorted results are the same.
        HashMap<String, List<String>> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        
        for (String s : strs) {
            String sortedStr = sortStr(s);
            if (!map.containsKey(sortedStr)) {
                List<String> list = new ArrayList<>();
                map.put(sortedStr, list);
            } 
            map.get(sortedStr).add(s);
        }
        
        // interate the hashmap and collect all groups of anagrams to the returned list
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            ArrayList<String> list = (ArrayList<String>) entry.getValue();
            if (list.size() > 1)
                res.addAll(list);
        }
        
        return res;
    }
	
	public String sortStr(String s) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }

	public static void main(String[] args) {
		String[] strs = {"abc", "bca", "bac", "bbb", "bbca", "abcb"};
//		System.out.println(Arrays.toString(anagrams(strs).toArray()));
	}

}
