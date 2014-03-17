/***
 * http://oj.leetcode.com/problems/string-to-integer-atoi/
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

	public static void main(String[] args) {
//		String test = "-2147483647";
//		String test = "    10522545459";
		String test = "+1146905820n1";
		System.out.println(atoi(test));
//		System.out.println(Integer.MIN_VALUE);
//		System.out.println(Integer.MAX_VALUE);
	}

}
