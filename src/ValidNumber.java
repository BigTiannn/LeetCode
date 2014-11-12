/**
 * https://oj.leetcode.com/problems/valid-number/
 * Validate if a given string is numeric.
 * 
 * @author BigTiannn {11-10-2014}
 *
 */

public class ValidNumber {
	
	public static boolean isNumber(String s) {
		if (s == null)
            return false;
            
        int dotPosition = -1;
		int start = 0;
		
		s = s.trim();
		if (s.length() == 0)
		    return false;
		
		// sign can be only at the beginning of the string, but dot can be anywhere
		if (s.charAt(0) == '+' || s.charAt(0) == '-')
			start = 1;

        for (int i = start; i < s.length(); i ++) {
            if (s.charAt(i) == 'e') {
            	if (i == start)
            		return false;
            	if (dotPosition == i - 1 && dotPosition == start)   //".e1"
            	    return false;
            	return isInteger(s, i + 1, s.length());
            } else if (s.charAt(i) == '.') {
            	if (dotPosition != -1)
            		return false;
            	dotPosition = i;
            } else if (!Character.isDigit(s.charAt(i))) {
            	return false;
            }
        }
        
        // ".", "-."
        if (dotPosition == start && dotPosition == s.length() - 1)
            return false;
        
        return true;
    }
	
	private static boolean isInteger(String s, int start, int end) {
        if (start >= end)
            return false;
        if (s.charAt(start) == '+' || s.charAt(start) == '-')
            start ++;
        if (start == end)
            return false;
        while (start < end && start < s.length()) {
			if (!Character.isDigit(s.charAt(start ++)))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// corner case 1: "."
		// corner case 2: "1 "
		// corner case 3: "0e"
		// corner case 4: "3."
		// corner case 5: ".e1"
		// corner case 6: " -."
		// corner case 7: " -e58"
		System.out.println(isNumber("+9"));
	}

}
