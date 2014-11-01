/**
 * https://oj.leetcode.com/problems/substring-with-concatenation-of-all-words/
 * You are given a string, S, and a list of words, L, that are all of the same length. 
 * Find all starting indices of substring(s) in S that is a concatenation of each word 
 * in L exactly once and without any intervening characters.
 * For example, given:
 * S: "barfoothefoobarman"
 * L: ["foo", "bar"]
 * You should return the indices: [0,9]. (order does not matter).
 *
 * @author BigTiannn {10-31-2014}
 *
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SubstringWithConcatenationOfAllWords {
	
	// It is the same as "Longest Substring Without Repeating Characters"
	// Because all the words in L is of the same length, we can treat every word like a character.
	
	// Denote the length of each word in L as wordLen
	// S can be cut for wordLen situations, for example:
	// bar|foo|the|foo|bar|man
	// ba|rfo|oth|efo|oba|rma|n
	// b|arf|oot|hef|oob|arm|an
	// Time Complexity is O(n) * O(m/n) = O(m), where n is the length of each word in L, and m is the length of S
	
	public static List<Integer> findSubstring(String S, String[] L) {
		if (L.length == 0 || S.length() == 0)
			return null;
		
		HashMap<String, Integer> mapL = new HashMap<>();
		for (String s : L) {
			if (mapL.containsKey(s))
				mapL.put(s, mapL.get(s) + 1);
			else
				mapL.put(s, 1);
		}
		
		List<Integer> retList = new ArrayList<>();
		int wordLen = L[0].length();
		for (int i = 0; i < wordLen; i ++) {
		    HashMap<String, Integer> mapS = new HashMap<>();
			int found = 0;
			int start = i;	//string window [start, j] is supposed to contain all the strings in L
			for (int j = i; j < S.length() - wordLen + 1; j += wordLen) {
				String sub = S.substring(j, j + wordLen);
				if (!mapL.containsKey(sub)) {
					start = j + wordLen;	//
					mapS.clear();
					found = 0;
					continue;
				}
				
				// sub is in L
				if (!mapS.containsKey(sub))
					mapS.put(sub, 1);
				else
					mapS.put(sub, mapS.get(sub) + 1);
				
				if (mapS.get(sub) <= mapL.get(sub)) {
					found ++;
				} else {	// move "start" forward to delete some words, s.t. mapS.get(sub) < mapL.get(sub)
					while (mapS.get(sub) > mapL.get(sub)) {
						String tmp = S.substring(start, start + wordLen);
						mapS.put(tmp, mapS.get(tmp) - 1);
						if (mapS.get(tmp) < mapL.get(tmp))
							found --;
						start += wordLen;
					}
				}
				
				if (found == L.length) {
					retList.add(start);
					String tmp = S.substring(start, start + wordLen);
					mapS.put(tmp, mapS.get(tmp) - 1);
					start += wordLen;
					found --;
				}
				
			} // for
		} // for
		
		return retList;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// test 1
		String s = "barfoothefoobarman";
		String[] t = {"foo", "bar"};
		System.out.println(Arrays.toString(findSubstring(s, t).toArray()));
		
		// test 2
		String s2 = "aaa";
		String[] t2 = {"a", "a"};
		System.out.println(Arrays.toString(findSubstring(s2, t2).toArray()));
	}

}
