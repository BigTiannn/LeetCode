/***
 * http://oj.leetcode.com/problems/string-to-integer-atoi/
 * Implement atoi to convert a string to an integer.
 * 
 * @author BigTiannn
 */
public class StringToInteger {
	
	public static int atoi(String str) {
        int ret = 0, index = 0, sign = 0;
        boolean negFlag = false;
        
        str = str.trim();
        if (str.length() == 0)
        	return 0;
        
        if (str.charAt(0) == '-') {
        	negFlag = true;
        	sign = 1;
        	index ++;
        } else if (str.charAt(0) == '+') {
        	sign = 1;
        	index ++;
        }
        
        if (!Character.isDigit(str.charAt(index)))
        	return 0;
        
        while( index < str.length() && Character.isDigit(str.charAt(index)) ) {
        	if (negFlag && index > 9 + sign)
        		return Integer.MIN_VALUE;
        	if (!negFlag && index > 9 + sign)
        		return Integer.MAX_VALUE;
        		
        	ret = ret * 10 + str.charAt(index) - '0';
        	index ++;
        }
        
        if (!negFlag && ret < 0)
        	return Integer.MAX_VALUE;
        
        if (negFlag  && ret < 0)
        	return Integer.MIN_VALUE;
        
        if (negFlag)
        	ret = -ret;
        
        return ret;
    }
	
	public static int atoi_2(String str) {
        if (str == null || str.trim().length() == 0)
            return 0;
        
        boolean negFlag = false;
        int index = 0, res = 0, sign = 0;
        str = str.trim();
        if (str.charAt(0) == '-') {
            negFlag = true;
            sign = 1;
            index ++;
        } else if (str.charAt(0) == '+') {
            negFlag = false;
            sign = 1;
            index ++;
        }
        
        if (!Character.isDigit(str.charAt(index)))
        	return 0;
        
        while (index < str.length() && Character.isDigit(str.charAt(index))) {
            if (index > 9 + sign && !negFlag)
                return Integer.MAX_VALUE;
            if (index > 9 + sign && negFlag)
                return Integer.MIN_VALUE;
                
            if (index == 9 + sign && !negFlag &&
                res == Integer.MAX_VALUE / 10 && 
                str.charAt(index) - '0' >= Integer.MAX_VALUE % 10)
                return Integer.MAX_VALUE;
                
            if (index == 9 + sign && negFlag &&
                res == Integer.MAX_VALUE / 10 && 
                str.charAt(index) - '0' >= Integer.MAX_VALUE % 10 + 1)
                return Integer.MIN_VALUE;
            
            res = res * 10 + str.charAt(index) - '0';
            index ++;
        }
        if (negFlag)    res = -res;
        return res;
    }

	public static void main(String[] args) {
//		String test = "-2147483647";
//		String test = "    10522545459";
		String test = "+1146905820n1";
		System.out.println(atoi(test));
//		System.out.println(Integer.MIN_VALUE);
//		System.out.println(Integer.MAX_VALUE);
		System.out.println(atoi_2("-2147483647"));
	}

}
