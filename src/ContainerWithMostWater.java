/**
 * https://oj.leetcode.com/problems/container-with-most-water/
 * Given n non-negative integers a1, a2, ..., an, where each 
 * represents a point at coordinate (i, a_i). n vertical lines 
 * are drawn such that the two endpoints of line i is at (i, a_i) 
 * and (i, 0). Find two lines, which together with x-axis forms 
 * a container, such that the container contains the most water.
 * 
 * @author BigTiannn {10-29-2014}
 *
 */

public class ContainerWithMostWater {
	
	public int maxArea(int[] height) {
		int mArea = 0;
        for (int start = 0, end = height.length - 1; start < end;) {
            int area = Math.min(height[start], height[end]) * (end - start);
            if (area > mArea)
                mArea = area;
            if (height[start] <= height[end])
            	start ++;
            else
            	end --;
        }
        return mArea;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
