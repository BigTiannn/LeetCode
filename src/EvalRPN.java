import java.util.Stack;


public class EvalRPN {
	// no sanity check (suppose the input string is valid RPT)
	public static int Solution (String[] tokens) {
		if (tokens == null || tokens.length == 0)
			return 0;
		
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < tokens.length; i ++) {
			int num1, num2;
			switch (tokens[i]) {
			case "+":
				num2 = stack.pop();
				num1 = stack.pop();
				stack.push(num1 + num2);
				break;
			case "-":
				num2 = stack.pop();
				num1 = stack.pop();
				stack.push(num1 - num2);
				break;
			case "*":
				num2 = stack.pop();
				num1 = stack.pop();
				stack.push(num1 * num2);
				break;
			case "/":
				num2 = stack.pop();
				num1 = stack.pop();
				stack.push(num1 / num2);
				break;
			default:
				int start = 0, tmp = 0;
				if (tokens[i].charAt(0) == '-') {
					start = 1;
				}
				for (int k = start; k < tokens[i].length(); k ++) {
					int tt = tokens[i].charAt(k) - '0';
					tmp = tmp * 10 + tt;
				}
				if (start == 1) 
					tmp = -tmp;
				stack.push(tmp);
				break;
			}
		}
		
		return stack.pop();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s = {"-78","-33","196","+","-19","-","115","+","-","-99","/","-18","8","*","-86","-","-","16","/","26","-14","-","-","47","-","101","-","163","*","143","-","0","-","171","+","120","*","-60","+","156","/","173","/","-24","11","+","21","/","*","44","*","180","70","-40","-","*","86","132","-84","+","*","-","38","/","/","21","28","/","+","83","/","-31","156","-","+","28","/","95","-","120","+","8","*","90","-","-94","*","-73","/","-62","/","93","*","196","-","-59","+","187","-","143","/","-79","-89","+","-"};
		System.out.println(Solution(s));
	}
}
