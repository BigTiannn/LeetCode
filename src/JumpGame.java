import java.util.Arrays;

/***
 * http://oj.leetcode.com/problems/jump-game/
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
