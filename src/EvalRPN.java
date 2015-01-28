/**
 * https://oj.leetcode.com/problems/evaluate-reverse-polish-notation/
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * 
 * @author BigTiannn
 * 
 */
import java.util.Stack;

public class EvalRPN {
	// no sanity check (suppose the input string is valid RPT)
	public static int Solution (String[] tokens) {
		if (tokens == null || tokens.length == 0)
			return 0;
		
		Stack<Integer> stack = new Stack<>();
		for (String t : tokens) {
		    if (!isOperator(t)) {
		        stack.add(Integer.parseInt(t));
		    } else {
		        int num2 = stack.pop();
		        int num1 = stack.pop();
		        switch(t.charAt(0)) {
		        case '+':   stack.add(num1 + num2);	break;
		        case '-':   stack.add(num1 - num2);	break;
		        case '*':   stack.add(num1 * num2);	break;
		        case '/':   stack.add(num1 / num2);	break;
		        }
		    }
		}
		
		return stack.pop();
	}
	
	private static boolean isOperator(String s) {
        if (s.length() == 1) {
            if (s.charAt(0) == '+' || s.charAt(0) == '-' || s.charAt(0) == '*' || s.charAt(0) == '/')
                return true;
        }
        return false;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String[] s = {"-78","-33","196","+","-19","-","115","+","-","-99","/","-18","8","*","-86","-","-","16","/","26","-14","-","-","47","-","101","-","163","*","143","-","0","-","171","+","120","*","-60","+","156","/","173","/","-24","11","+","21","/","*","44","*","180","70","-40","-","*","86","132","-84","+","*","-","38","/","/","21","28","/","+","83","/","-31","156","-","+","28","/","95","-","120","+","8","*","90","-","-94","*","-73","/","-62","/","93","*","196","-","-59","+","187","-","143","/","-79","-89","+","-"};
		String[] s = {"4","-2","/","2","-3","-","-"};
		System.out.println(Solution(s));
	}
}
