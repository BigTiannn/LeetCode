/**
 * https://oj.leetcode.com/problems/letter-combinations-of-a-phone-number/
 * Given a digit string, return all possible letter combinations that the number could represent.
 * 
 * @author BigTiannn
 */
import java.util.ArrayList;
import java.util.List;


public class LetterCombinationsOfPhoneNumber {
	String[] phonePad = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(digits, 0, sb, res);
        return res;
    }
    
    void helper(String digits, int start, StringBuilder sb, List<String> res) {
        if (start == digits.length()) {
            res.add(new String(sb));
            return;
        }
        
        int currNum = digits.charAt(start) - '0';
        for (int i = 0; i < phonePad[currNum].length(); i ++) {
            sb.append(phonePad[currNum].charAt(i));
            helper(digits, start + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
        
        return;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
