/**
 * https://oj.leetcode.com/problems/longest-common-prefix/
 * Write a function to find the longest common prefix string amongst an array of strings.
 * 
 * @author BigTiannn {11-02-2014}
 *
 */
public class LongestCommonPrefix {
	
	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0)
            return "";
            
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            char currChar = ' ';
            boolean flag = false;
            for (String str : strs) {
                if (i == str.length()) {
                    flag = true;
                    break;
                }
                if (currChar == ' ') {
                    currChar = str.charAt(i);
                } else {
                    if (str.charAt(i) != currChar) {
                        flag = true;
                        break;
                    }
                }
            }
            if (flag)
                break;
            sb.append(currChar);
            i ++;
        }
        
        return sb.toString();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
