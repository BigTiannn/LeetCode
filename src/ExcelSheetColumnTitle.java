/**
 * https://oj.leetcode.com/problems/excel-sheet-column-title/
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * For example: 
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 * 
 * @author BigTiannn {12-20-2014}
 *
 */

public class ExcelSheetColumnTitle {
	
	public String convertToTitle(int n) {
		StringBuilder sb = new StringBuilder();
        
        while (n > 0) {
            int tmp = (n - 1) % 26;		// pay attention here: (n - 1), not n!
            sb.append((char)('A' + tmp));
            n = (n - tmp) / 26;
        }
        
        return sb.reverse().toString();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
