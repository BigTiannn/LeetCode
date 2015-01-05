/**
 * https://oj.leetcode.com/problems/excel-sheet-column-number/
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * For example:
 *  A -> 1
 *  B -> 2
 *  C -> 3
 *  ...
 *  Z -> 26
 *  AA -> 27
 *  AB -> 28 
 *  
 * @author BigTiannn {01-05-2015}
 *
 */

public class ExcelSheetColumnNumber {
	
	public int titleToNumber(String s) {
        if (s == null || s.length() == 0)
            return 0;
        
        int ret = 0;
        for (int i = s.length() - 1; i >= 0; i --) {
            // illegal character
            if (s.charAt(i) < 'A' || s.charAt(i) > 'Z')
                return -1;
            
            ret += (s.charAt(i) - 'A' + 1) * Math.pow(26, s.length() - 1 - i);
        }
        return ret;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
