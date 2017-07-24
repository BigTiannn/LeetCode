/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/#/description
 * Given a (n x n) matrix where each of the rows and columns are sorted in ascending order, 
 * find the kth smallest element in the matrix.
 * Note that it is the kth smallest element in the sorted order, 
 * not the kth distinct element.
 * Example:
 * matrix = [
 *  [ 1,  5,  9],
 *  [10, 11, 13],
 *  [12, 13, 15]
 * ],
 * k = 8,
 * return 13.
 * Note: You may assume k is always valid, 1 <= k <= n2.
 * 
 * @author BigTiannn
 *
 */

public class KthSmallestElementInASortedMatrix {
  // time complexity: O(nlgn*lgX) where X is the difference between the smallest element and the largest element
  public static int solution(int[][] matrix, int k) {
    int n = matrix.length;
    int low = matrix[0][0], high = matrix[n - 1][n - 1];
    while (low < high) {
      int mid = (low + high) / 2;
      int rankOfMid = searchRank(matrix, mid);
      if (rankOfMid < k) {    // mid is too large
        low = mid + 1;
      } else { // mid is too small
        high = mid;
      }
      System.out.println(low + ", " + high);
    }
    return high;
  }
  private static int searchRank(int matrix[][], int target) {
    int n = matrix.length, i = n - 1, j = 0, rank = 0;
    while (i >= 0 && j < n) {
      if (matrix[i][j] <= target) {
        j ++;
        rank += i + 1;
      } else if (matrix[i][j] > target) {
        i --;
      }
    }
    return rank;
}
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int matrix[][] = {{1,5,9},{10,11,13},{12,13,15}};
    System.out.println(solution(matrix, 8));
  }

}
