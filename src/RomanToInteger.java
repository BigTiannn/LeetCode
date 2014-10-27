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
		int ret = 0, prevBit = 0;
		for (int i = 0; i < s.length(); i ++) {
			switch(s.charAt(i)) {
			case 'M':
				if (prevBit == 100)
					ret -= 2 * prevBit;
				ret += 1000;
				prevBit = 1000;
				break;
			case 'D':
				if (prevBit == 100)
					ret -= 2 * prevBit;
				ret += 500;
				prevBit = 500;
				break;
			case 'C':
				if (prevBit == 10)
					ret -= 2 * prevBit;
				ret += 100;
				prevBit = 100;
				break;
			case 'L':
				if (prevBit == 10)
					ret -= 2 * prevBit;
				ret += 50;
				prevBit = 50;
				break;
			case 'X':
				if (prevBit == 1)
					ret -= 2 * prevBit;
				ret += 10;
				prevBit = 10;
				break;
			case 'V':
				if (prevBit == 1)
					ret -= 2 * prevBit;
				ret += 5;
				prevBit = 5;
				break;
			case 'I':
				ret += 1;
				prevBit = 1;
				break;
			default:
				break;
			}
		}
		
        return ret;
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
