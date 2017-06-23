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
		while (i >= 0) {
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
	
	/**
	 * 1) Reverse the individual words, e.g.
     * "i ekil siht margorp yrev hcum"
	 * 2) Reverse the whole string from start to end and you get the desired output.
     * "much very program this like i"
	 */
	public static String Solution2 (String s) {
	  char[] chars = s.toCharArray();
	  int i = 0, j = 0, n = chars.length;
	  
	  while (i < n) {
		while ( i < j || i < n && chars[i] == ' ' )	i ++;
		while ( j < i || j < n && chars[j] != ' ' )	j ++;
		System.out.println("i = " + i + ", j = " + j);
		reverse(chars, i, j - 1);
	  }
	  reverse(chars, 0, n - 1);
		
	  return cleanSpaces(chars);
	}
	
	private static void reverse(char[] a, int i, int j) {
	  while (i < j) {
	    char t = a[i];
	    a[i++] = a[j];
	    a[j--] = t;
	  }
	}
	
	private static String cleanSpaces(char[] a) {
	  int i = 0, j = 0, n = a.length;
	  while (j < n) {
	    while (j < n && a[j] == ' ') j++;             // skip spaces
	    while (j < n && a[j] != ' ') a[i++] = a[j++]; // keep non spaces
	    while (j < n && a[j] == ' ') j++;             // skip spaces
	    if (j < n) a[i++] = ' ';                      // keep only one space
	  }
	  return new String(a).substring(0, i);
    }

	public static void main(String[] args) {
//		String test = "   the     sky is blue    ";
		String test = " a";
		System.out.println(Solution2(test));
	}

}
