import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/4sum-ii/#/description
 * Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) 
 * there are such that A[i] + B[j] + C[k] + D[l] is zero.
 * To make problem a bit easier, all A, B, C, D have same length of N where 0 <= N <= 500. 
 * All integers are in the range of -2^28 to 2^28 - 1 and the result is guaranteed to be at 
 * most 2^31 - 1.
 * Example:
 * Input:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 * Output: 2
 * Explanation:
 * The two tuples are:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 * 
 * @author BigTiannn
 *
 */

public class FourSumII {
  
  public static int solution(int[] A, int[] B, int[] C, int[] D) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < A.length; i ++) {
        for (int j = 0; j < B.length; j ++) {
            int sum = A[i] + B[j];
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
    }
    
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      System.out.println(entry.getKey() + " " + entry.getValue());
    }
    
    int res = 0;
    for (int i = 0; i < C.length; i ++) {
        for (int j = 0; j < D.length; j ++) {
            int sum = C[i] + D[j];
            System.out.println(sum);
            res += map.getOrDefault(-sum, 0);
        }
    }
    
    return res;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int[] A = {1,2}, B = {-2, -1}, C = {-1, 2}, D = {0, 2};
    FourSumII.solution(A, B, C, D);
  }

}
