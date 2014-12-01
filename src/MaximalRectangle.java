/**
 * https://oj.leetcode.com/problems/maximal-rectangle/
 * Given a 2D binary matrix filled with 0's and 1's, 
 * find the largest rectangle containing all ones and return its area.
 * 
 * @author BigTiannn {11-27-2014}
 *
 */

import java.util.Arrays;
import java.util.Stack;

public class MaximalRectangle {
	
	public int maximalRectangle(char[][] matrix) {
		if (matrix.length == 0)
            return 0;
            
        int[] oneHeight = new int[matrix[0].length];
        int maxArea = 0;
        for (int i = 0; i < matrix.length; i ++) {
            // build the histogram, each column's height is the number of one's
            for (int j = 0; j < matrix[0].length; j ++) {
                if (matrix[i][j] == '1' && i > 0 && matrix[i - 1][j] == '1') {
                    oneHeight[j] += 1;
                } else if (matrix[i][j] == '1') {
                    oneHeight[j] = 1;
                } else {
                    oneHeight[j] = 0;
                }
            }
            int area = largestRectangleArea(oneHeight);
            maxArea = Math.max(maxArea, area);
        }
        
        return maxArea;
    }
    
    public int largestRectangleArea(int[] height) {
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
	}

}
