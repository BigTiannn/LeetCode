import java.util.Arrays;

/***
 * https://leetcode.com/problems/jump-game/tabs/description
 * 
 * Given an array of non-negative integers, you are initially positioned 
 * at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * 
 * For example:
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 * 
 * @author BigTiannn
 */

public class JumpGame {
	
	public static boolean canJump(int[] A) {
		int farthest = A[0];
		for (int i = 1; i < A.length && i <= farthest; i ++) {
			if (i + A[i] > farthest)
				farthest = i + A[i];
		}
    return farthest >= A.length - 1;
  }

	public static void main(String[] args) {
//		int[] test = {2, 3, 1, 1, 4};
//		int[] test = {3, 2, 1, 0, 4};
		int[] test = {1, 2, 3};
		System.out.println(canJump(test));
	}

}
