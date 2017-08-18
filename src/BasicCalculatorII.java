import java.util.Stack;

/**
 * https://leetcode.com/problems/basic-calculator-ii/description/
 * Implement a basic calculator to evaluate a simple expression string.
 * The expression string contains only non-negative integers, +, -, *, / 
 * operators and empty spaces . The integer division should truncate toward zero.
 * You may assume that the given expression is always valid.
 * Some examples:
 * "3+2*2" = 7
 * " 3/2 " = 1
 * " 3+5 / 2 " = 5
 * 
 * @author BigTiannn
 *
 */

public class BasicCalculatorII {
  public int calculate(String s) {
    Stack<Integer> stack = new Stack<>();
    int num = 0;
    char op = '+';
    for (int i = 0; i < s.length(); i ++) {            
      if (Character.isDigit(s.charAt(i))) {
          num = num * 10 + s.charAt(i) - '0';
      } 
      if ((!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ') || i == s.length() - 1) {
        switch (op) {
          case '+':
              stack.push(num);
              break;
          case '-':
              stack.push(-num);
              break;
          case '*':
              stack.push(stack.pop() * num);
              break;
          case '/':
              stack.push(stack.pop() / num);
              break;
        }
        num = 0;
        op = s.charAt(i);
      }
    }
    int res = 0;
    while (!stack.isEmpty()) {
        res += stack.pop();
    }
    return res;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
