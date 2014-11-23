/**
 * https://oj.leetcode.com/problems/longest-valid-parentheses/
 * Given a string containing just the characters '(' and ')', find 
 * the length of the longest valid (well-formed) parentheses substring.
 * For "(()", the longest valid parentheses substring is "()", 
 * which has length = 2.
 * Another example is ")()())", where the longest valid parentheses 
 * substring is "()()", which has length = 4.
 * 
 * @author BigTiannn {11-21-2014}
 *
 */

import java.util.Stack;

public class LongestValidParentheses {
	
	
	/*
	 * Solution 1: stack
	 * Pay attention to line 41. Previously I wrote like following:
	 * maxMatch = Math.max(maxMatch, i - j + 1);
	 * which cannot pass the test "(()()"
	 */
	public int longestValidParentheses(String s) {
		Stack<Integer> stack = new Stack<>();
        int maxMatch = 0, start = -1;
        
        if (s == null || s.length() == 0)
            return maxMatch;
            
        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    start = i;
                } else {
                    int j = stack.pop();
                    if (stack.isEmpty()) {
                        maxMatch = Math.max(maxMatch, i - start);
                    } else {
                        maxMatch = Math.max(maxMatch, i - stack.peek());
                    }
                }
            }
        }
        
        return maxMatch;
    }
	
	/*
	 * Solution 2: DP
	 */
	public int longestValidParentheses_2(String s) {
		if (s == null || s.length() < 2)
            return 0;
        
        int[] prefixMatch = new int[s.length()];
        int maxMatch = 0;
        
        for (int i = s.length() - 2; i >= 0; i --) {
            if (s.charAt(i) == ')') {
                prefixMatch[i] = 0;
            } else {
                int j = i + prefixMatch[i + 1] + 1;
                if (j < s.length() && s.charAt(j) == ')') {
                    prefixMatch[i] = prefixMatch[i + 1] + 2;
                    if (j + 1 < s.length())
                        prefixMatch[i] += prefixMatch[j + 1];
                }
            }
            maxMatch = Math.max(maxMatch, prefixMatch[i]);
        }
        
        return maxMatch;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
