/**
 * https://oj.leetcode.com/problems/roman-to-integer/
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * @author BigTiannn {10-26-2014}
 *
 */

public class RomanToInteger {
	
	public int romanToInt(String s) {
        int res = 0;
        int prevDigit = 0, currDigit = 0;
        for (int i = 0; i < s.length(); i ++) {
            currDigit = getValue(s.charAt(i));
            res += getValue(s.charAt(i));
            if (i > 0 && currDigit > prevDigit)
                res -= 2 * prevDigit;
            prevDigit = currDigit;
        }
        return res;
    }
	
	private int getValue(char ch) {
        switch(ch) {
        case 'I':   return 1;
        case 'V':   return 5;
        case 'X':   return 10;
        case 'L':   return 50;
        case 'C':   return 100;
        case 'D':   return 500;
        case 'M':   return 1000;
        default:    return -1;
        }
    }
	
	// cannot tell an invalid Roman number
	public static int romanToInt_2(String s) {
		char[] RomanCharChart = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
		int[] RomanValueChart = {1000, 500, 100, 50, 10, 5, 1};
		
		int i = 0, prefix = 0, ret = 0;
		while (i < s.length()) {
			for (int j = 0; j < RomanCharChart.length; j ++) {
				if (s.charAt(i) == RomanCharChart[j]) {
					if (RomanValueChart[j] > prefix) {
						ret += RomanValueChart[j] - 2 * prefix;
					} else {
						ret += RomanValueChart[j];
					}
					prefix = RomanValueChart[j];
					i ++;
					break;
				}
			}
		}
		
		return ret;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "DCXXI";
		System.out.println(romanToInt_2(s));
	}

}
