/**
 * https://oj.leetcode.com/problems/min-stack/
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * 
 * @author BigTiannn {11-10-2014}
 *
 */

import java.util.Stack;

public class MinStack {
	Stack<Integer> s;
    Stack<Integer> minStack;
    
    public MinStack () {
        s = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int x) {
        if (x <= getMin())
            minStack.push(x);
        s.push(x);
    }

    public void pop() {
        int x = s.pop();
        if (x == getMin())
        	minStack.pop();
    }

    public int top() {
        if (s.isEmpty())
            return Integer.MAX_VALUE;
        return s.peek();
    }

    public int getMin() {
        if (minStack.isEmpty())
            return Integer.MAX_VALUE;
        return minStack.peek();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
