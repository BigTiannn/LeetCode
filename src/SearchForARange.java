/**
 * https://oj.leetcode.com/problems/search-for-a-range/
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 * 
 * @author BigTiannn {11-14-2014}
 *
 */

public class SearchForARange {
  public int[] solution(int[] A, int target) {
  	int low = 0, high = A.length - 1;
    int ret[] = {-1, -1};
      
    while (low <= high) {
      int mid = (low + high) / 2;
      if (target < A[mid]) {
        high = mid - 1;
      } else if  (target > A[mid]){
        low = mid + 1;
      } else {
        while (mid >= 0 && A[mid] == target)
          mid --;
        ret[0] = ++ mid;
        while (mid < A.length && A[mid] == target)
          mid ++;
        ret[1] = -- mid;
        break;
      }
    }
    return ret;
  }
  
  // two binary searches for the beginning and end of the range,
  // If A[mid] < target, then the range must begins on the right of mid (i = mid + 1)
  // If A[mid] > target, it means the range must begins on the left of mid (j = mid - 1)
  // If A[mid] = target, then the range must begins on the left of or at mid (j= mid)
  // Since we would move the search range to the same side for case 2 and 3: If A[mid] >= target, j = mid;
  public int[] solution2(int[] nums, int target) {
    int[] res = {-1, -1};
    int low = 0, high = nums.length - 1;
    if (nums.length == 0) return res;
    // search for left boundary
    while (low < high) {
        int mid = (low + high) / 2;
        if (nums[mid] < target) low = mid + 1;
        else high = mid;
    }
    if (nums[low] != target)  return res;
    res[0] = high;
    // search for right boundary
    high = nums.length - 1;
    while (low < high) {
        int mid = (low + high) / 2 + 1;
        if (nums[mid] > target) high = mid - 1;
        else low = mid;
    }
    res[1] = low;
    return res;
  }
  
  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	  SearchForARange test = new SearchForARange();
	  int[] nums = {};
	  test.solution2(nums, 0);
	}

}
