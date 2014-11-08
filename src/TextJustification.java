/**
 * https://oj.leetcode.com/problems/text-justification/
 * Given an array of words and a length L, format the text such that each 
 * line has exactly L characters and is fully (left and right) justified.
 * You should pack your words in a greedy approach; that is, pack as many 
 * words as you can in each line. Pad extra spaces ' ' when necessary so 
 * that each line has exactly L characters.
 * Extra spaces between words should be distributed as evenly as possible. 
 * If the number of spaces on a line do not divide evenly between words, 
 * the empty slots on the left will be assigned more spaces than the slots 
 * on the right.
 * For the last line of text, it should be left justified and no extra space 
 * is inserted between words.
 * For example,
 * words: ["This", "is", "an", "example", "of", "text", "justification."]
 * L: 16.
 * Return the formatted lines as:
 * [
   "This    is    an",
   "example  of text",
   "justification.  "
   ]
 * Note: Each word is guaranteed not to exceed L in length.
 * 
 * @author BigTiannn {11-07-2014}
 *
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextJustification {
	
	public static List<String> fullJustify(String[] words, int L) {
		List<String> text = new ArrayList<>();
        int i = 0;
        while (i < words.length) {
        	int tmpSum = words[i].length();
        	int k = i + 1;
        	while (k < words.length && tmpSum < L) {
        		if (tmpSum + words[k].length() + 1 <= L) {
        			// at least one space between words
        			tmpSum += 1 + words[k ++].length();
        		} else
        			break;
        	}
        	
        	StringBuilder sb = new StringBuilder();
        	// there's only one situation that spaces are needed at the end of the line
        	// that is when there's only one word in this line and its length < L
        	if (k - i == 1)  {
        		sb.append(words[i ++]);
        		for (int j = 0; j < L - tmpSum; j ++) {
        			sb.append(" ");
        		}
        	} else if (k == words.length) {	// the last line
        		int remain_space = L - tmpSum;
        		System.out.println(remain_space);
        		while (i < k) {
            		sb.append(words[i ++]);
            		// don't need to append evenly spaces after the last word, so we need (i != k)
            		if (i != k)
            			sb.append(" ");
            	}
        		while (remain_space > 0) {
        			sb.append(" ");
        			remain_space --;
        		}
        	} else {
        		// check remaining spaces
            	int spaces = L - tmpSum;
            	// there's (k - i) words in this line, and (k - i - 1) space slots
            	int evenly_space = spaces / (k - i - 1);
            	int remain_space = spaces - evenly_space * (k - i - 1);
        		while (i < k) {
            		sb.append(words[i ++]);
            		// don't need to append evenly spaces after the last word, so we need (i != k)
            		for (int j = 0; j <= evenly_space && i != k; j ++)
            			sb.append(" ");
            		if (remain_space > 0) {
            			sb.append(" ");
            			remain_space --;
            		}
            	}
        	}
        	
        	text.add(sb.toString());
        }
        
        return text;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// test 1 (yes! passed this test at the first attempt!)
		String words[] = {"This", "is", "an", "example", "of", "text", "justification."};
		List<String> result = fullJustify(words, 16);
		System.out.println(Arrays.toString(result.toArray()));
		
		// test 2
		String words2[] = {""};
		List<String> result2 = fullJustify(words2, 2);
		System.out.println(Arrays.toString(result2.toArray()));
		
		// test 3
		String words3[] = {"a","b","c","d","e"};
		List<String> result3 = fullJustify(words3, 3);
		System.out.println(Arrays.toString(result3.toArray()));
		
		// test 4
		String words4[] = {"What","must","be","shall","be."};
		List<String> result4 = fullJustify(words4, 12);
		System.out.println(Arrays.toString(result4.toArray()));
	}

}
