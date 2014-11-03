/**
 * https://oj.leetcode.com/problems/climbing-stairs/
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * 
 * @author BigTiannn {11-02-2014}
 *
 */

public class ClimbingStairs {
	public int climbStairs(int n) {
        if (n <= 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
            
        int steps[] = new int[n];
        for (int i = 0; i < n; i ++) {
            if (i == 0)
                steps[i] = 1;
            else if (i == 1)
                steps[i] = 2;
            else
                steps[i] = steps[i - 2] + steps[i - 1];
        }
        
        return steps[n - 1];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
