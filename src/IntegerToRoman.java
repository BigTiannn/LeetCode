/**
 * https://oj.leetcode.com/problems/integer-to-roman/
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * @author BigTiannn {10-26-2014}
 *
 */

public class IntegerToRoman {
	
	public String intToRoman(int num) {
		char[] RomanCharChart = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
		int[] RomanValueChart = {1000, 500, 100, 50, 10, 5, 1};
		
		StringBuilder sb = new StringBuilder();
		
		while (num != 0) {
			for (int i = 0; i < RomanCharChart.length; i += 2) {
				int factor = num / RomanValueChart[i];
				if (factor > 0 && factor < 4) {
					for (int j = 0; j < factor; j ++) {
						sb.append(RomanCharChart[i]);
					}
					num -= factor * RomanValueChart[i];
					break;
				} else if (factor == 4) {
					sb.append(RomanCharChart[i]);
					sb.append(RomanCharChart[i - 1]);
					num -= factor * RomanValueChart[i];
					break;
				} else if (factor == 5) {
					sb.append(RomanCharChart[i - 1]);
					num -= factor * RomanValueChart[i];
					break;
				} else if (factor > 5 && factor < 9) {
					sb.append(RomanCharChart[i - 1]);
					for (int j = 0; j < factor - 5; j ++) {
						sb.append(RomanCharChart[i]);
					}
					num -= factor * RomanValueChart[i];
					break;
				} else if (factor == 9) {
				    sb.append(RomanCharChart[i]);
				    sb.append(RomanCharChart[i - 2]);
				    num -= factor * RomanValueChart[i];
					break;
				}
			}
		}
        
        return sb.toString();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
