/**
 * https://oj.leetcode.com/problems/word-ladder/
 * Given two words (start and end), and a dictionary, find the length 
 * of shortest transformation sequence from start to end, such that:
 * 1. Only one letter can be changed at a time
 * 2. Each intermediate word must exist in the dictionary
 * For example, Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * Note:
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * 
 * @author BigTiannn {11-26-2014}
 *
 */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class WordLadder {
	
	public static int ladderLength(String start, String end, Set<String> dict) {
		int length = 1;
        LinkedList<String> toVisit = new LinkedList<>();
        toVisit.add(start);
        
        while (!toVisit.isEmpty()) {
            int n = toVisit.size();
            for (int i = 0; i < n; i ++) {
                String curr = toVisit.poll();
                
                if (curr.equals(end))
                    return length;
                    
                // add those words whose edit distance is 1 to 'toVisit' list
                for (int j = 0; j < curr.length(); j ++) {
                    char[] chArray = curr.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch ++) {
                        if (chArray[j] == ch)
                            continue;
                        
                        chArray[j] = ch;
                        String tmp = new String(chArray);
                        if (dict.contains(tmp)) {
                            toVisit.add(tmp);
                            dict.remove(tmp);	// PAY ATTENTION HERE: don't forget!
                        }
                    }
                }
            }
            length ++;
        }
        
        return 0;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String start = "hot", end = "dog";
		Set<String> dict = new HashSet<>();
		dict.add("hot");
		dict.add("dog");
		System.out.println(ladderLength(start, end, dict));
	}

}
