import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/perfect-squares/description/
 * 
 * Given a positive integer n, find the least number of perfect square numbers 
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, 
 * return 2 because 13 = 4 + 9.
 * 
 * @author BigTiannn
 *
 */

public class PerfectSquares {
  
  // same idea as "Coin Change"
  public int solution(int n) {
    int[] arr = new int[n + 1];

    for (int i = 1; i <= n; i ++) {
      arr[i] = Integer.MAX_VALUE;
      for (int j = 1; j * j <= i; j ++) {
        arr[i] = Math.min(arr[i], arr[i - j * j] + 1);
      }
    }
    return arr[n];
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    PerfectSquares test = new PerfectSquares();
    System.out.println(test.solution(4));
  }

}
