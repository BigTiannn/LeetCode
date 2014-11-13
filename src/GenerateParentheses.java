/**
 * https://oj.leetcode.com/problems/generate-parentheses/
 * Given n pairs of parentheses, write a function to generate all 
 * combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 * 
 * @author BigTiannn {11-12-2014}
 *
 */

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	
	public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        
        generate(n, 0, 0, "", list);
        
        return list;
    }
	
	public void generate(int n, int left, int right, String curr, List<String> list) {
        if (left == n && right == n) {
            list.add(curr);
            return;
        }
        
        if (left == n) {
            generate(n, left, right + 1, curr + ")", list);
        } else if (left == right) {
            generate(n, left + 1, right, curr + "(", list);
        } else {
            generate(n, left, right + 1, curr + ")", list);
            generate(n, left + 1, right, curr + "(", list);
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
