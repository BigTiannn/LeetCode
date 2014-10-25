/**
 * https://oj.leetcode.com/problems/length-of-last-word/
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', 
 * return the length of last word in the string.
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * 
 * @author BigTiannn {10-22-2014}
 *
 */
public class LengthOfLastWord {
	
	public int lengthOfLastWord(String s) {
        if (s == null)
            return 0;
            
        s = s.trim();
        int i = s.length() - 1;
        for (; i >= 0 && s.charAt(i) != ' '; i --)
            ;
        return s.length() - i - 1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
