/***
 * http://oj.leetcode.com/problems/reverse-words-in-a-string/
 * Given an input string, reverse the string word by word.
 * Input string may contain leading or trailing spaces
 * However, reversed string should not.
 * Reduce multiple spaces between two words to a single space
 * in the reversed string.
 * 
 * @author BigTiannn
 */

public class ReverseWordsInString {
	
	public static String Solution (String s) {
		String reversed = new String();
		
		if (s == null || s.length() == 0)
			return reversed;
		
		s = s.trim();
		
		int i = s.length() - 1;
		while(i >= 0) {
			int j = i + 1;
			while (i >= 0 && s.charAt(i) != ' ')
				i --;
			reversed += s.substring(i + 1, j);
			reversed += ' ';
			while(i >= 0 && s.charAt(i) == ' ')
				i --;
		}
		
		return reversed.trim();
	}

	public static void main(String[] args) {
		String test = "   the     sky is blue   ";
		System.out.println(Solution(test));
	}

}
