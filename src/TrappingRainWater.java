/**
 * https://oj.leetcode.com/problems/trapping-rain-water/
 * Given n non-negative integers representing an elevation map 
 * where the width of each bar is 1, compute how much water it 
 * is able to trap after raining.
 * For example, Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * 
 * @author BigTiannn {10-30-2014}
 *
 */

import java.util.Stack;

public class TrappingRainWater {
	
	// This is a wrong solution. It gonna lose some water...
	public int trap_wrong(int[] A) {
		int water = 0, currWater = 0;
        int i = 0;
        while (i < A.length) {
            if (currWater == 0) {
                int tmp = i ++;
                while (i < A.length && A[i] < A[tmp]) {
                    // calculate trapped water
                    currWater += A[tmp] - A[i];
                    i ++;
                }
                if (i == A.length)
                    break;
                water += currWater;
                currWater = 0;
            }
        }
        return water;
    }
	
	// Modify it with a similar thought by using a stack
	public int trap(int[] A) {
        // use a stack to store the index of bar
        Stack<Integer> stack = new Stack<>();
        int water = 0;
        
        for (int i = 0; i < A.length; i ++) {
            // pop all the elements lower than A[i]
            int bottom = 0;
            while (!stack.isEmpty()) {
                int idx = stack.peek();
                // bar, A[idx] and A[i] form a trap
                water += (Math.min(A[idx], A[i]) - bottom) * (i - idx - 1);
                bottom = A[idx];
                
                if (A[i] < A[idx])
                    break;
                else
                    stack.pop();
            }
            
            stack.add(i);
        }
        
        return water;
    }
	
	public static int trap_2(int[] A) {
		int water = 0;
        int n = A.length;
        int maxLeft[] = new int[n];
        int maxRight[] = new int[n];
        
        for (int i = 1; i < n; i ++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], A[i - 1]);
            maxRight[n - i - 1] = Math.max(maxRight[n - i], A[n - i]);
        }
        
        for (int i = 0; i < n; i ++) {
            int bar = Math.min(maxLeft[i], maxRight[i]);
            if (bar > A[i])
                water += bar - A[i];
        }
        
        return water;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
