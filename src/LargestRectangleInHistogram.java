/**
 * https://oj.leetcode.com/problems/largest-rectangle-in-histogram/
 * Given n non-negative integers representing the histogram's bar height 
 * where the width of each bar is 1, find the area of largest rectangle 
 * in the histogram.
 * 
 * @author BigTiannn {11-01-2014}
 *
 */

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleInHistogram {
	
	// brute-force with pruning
	// Time complexity is O(n^2)
	public static int largestRectangleArea(int[] height) {
		int maxArea = 0;
        for (int i = 0; i < height.length; i ++) {
            if (i < height.length - 1 && height[i] <= height[i + 1])
                continue;
            
            // calculate area for [j, i]
            int minHeight = height[i];
            for (int j = i; j >= 0; j --) {
                if (minHeight > height[j])
                    minHeight = height[j];
                int area = minHeight * (i - j + 1);
                if (maxArea < area)
                    maxArea = area;
            }
        }
        
        return maxArea;
    }
	
	// the stack is used to store the index of monotonically increasing elements
	public static int largestRectangleArea_2(int[] height) {
		Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        int maxArea = 0;
        int[] h = new int[height.length + 1];
        h = Arrays.copyOf(height, height.length + 1);
        while(i < h.length){
            if(stack.isEmpty() || h[stack.peek()] <= h[i]){
                stack.push(i++);
            }else {
                int t = stack.pop();
                maxArea = Math.max(maxArea, h[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }
        return maxArea;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int height[] = {1, 1};
		System.out.println(largestRectangleArea_2(height));
	}

}
