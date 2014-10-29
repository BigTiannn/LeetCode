/**
 * https://oj.leetcode.com/problems/valid-parentheses/
 * Given a string containing just the characters '(', ')', 
 * '{', '}', '[' and ']', determine if the input string is valid.
 * 
 * @author BigTiannn {10-28-2014}
 */

import java.util.Stack;


public class ValidParentheses {
	
	public boolean isValid(String s) {
        if (s == null || s.length() == 0)
            return true;
            
        Stack<Character> stack = new Stack<>();
        stack.add(s.charAt(0));
        
        for (int i = 1; i < s.length(); i ++) {
            if (!stack.isEmpty()) {
                char top = stack.peek();
                if (isMatched(top, s.charAt(i))) {
                    stack.pop();
                } else {
                    stack.add(s.charAt(i));
                }
            } else {
                stack.add(s.charAt(i));
            }
        }
        
        return stack.isEmpty();
        
    }
    
    public boolean isMatched(char c1, char c2) {
        if (c1 == '(' && c2 == ')')
            return true;
        if (c1 == '[' && c2 == ']')
            return true;
        if (c1 == '{' && c2 == '}')
            return true;
            
        return false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
