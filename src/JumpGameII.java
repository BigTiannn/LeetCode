import java.util.Arrays;

/***
 * http://oj.leetcode.com/problems/jump-game-ii/
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * @author BigTiannn
 */
public class JumpGameII {
	
	public static int jump(int[] A) {
		if (A == null || A.length == 0)
			return 0;
		
		int step = 0, canReach = 0, lastReach = 0;
		for (int i = 0; i < A.length; i ++) {
			if (i > lastReach) {
				step ++;
				lastReach = canReach;
			}
			canReach = Math.max(canReach, i + A[i]);
		}
		
		return step;
    }
	
	public static void main(String[] args) {
		int[] test = {2, 3, 1, 1, 4};
		System.out.println(jump(test));
	}

}
