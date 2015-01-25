/**
 * https://oj.leetcode.com/problems/implement-strstr/
 * Implement strStr().
 * Returns the index of the first occurrence of needle in haystack, 
 * or -1 if needle is not part of haystack.
 * 
 * @author BigTiannn
 *
 */
public class StrStr {
	
	public static int strStr(String haystack, String needle) {
		if (needle == null || needle.length() == 0)
            return 0;
        if (haystack == null || needle.length() > haystack.length())
            return -1;
            
        for (int i = 0; i <= haystack.length() - needle.length(); i ++) {
            int j = 0;
            while (j < needle.length()) {
                if (haystack.charAt(i + j) != needle.charAt(j))
                    break;
                j ++;
            }
            if (j == needle.length())
                return i;
        }
        
        return -1;
    }

	public static void main(String[] args) {
		String s1 = "", s2 = "";
		System.out.println(strStr(s1, s2));
	}

}
