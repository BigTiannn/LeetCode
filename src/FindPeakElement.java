/**
 * https://leetcode.com/problems/find-peak-element/description/
 * 
 * A peak element is an element that is greater than its neighbors.
 * Given an input array where num[i] != num[i+1], find a peak element and return its index.
 * You may imagine that num[-1] = num[n] = negative infinite.
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return 
 * the index number 2.
 *
 * @author BigTiannn {12-05-2014}
 *
 */

public class FindPeakElement {
	
	public int findPeakElement(int[] num) {
    if (num.length == 0)
      return -1;
        
    return binarySearch(num, 0, num.length - 1);
  }
    
  public int binarySearch(int[] num, int start, int end) {
    if (start > end)
        return -1;
    
    int mid = (start + end) / 2;
    
    // check first half
    int ret = binarySearch(num, start, mid - 1);
    if (ret != -1)  return ret;
    
    // check middle point
    if ((mid == 0 || num[mid] > num[mid - 1]) &&  
      (mid == num.length - 1 || num[mid] > num[mid + 1])) {
      return mid;
    }
    
    // check second half
    return binarySearch(num, mid + 1, end);
  }
  
  public int solution(int[] nums) {
    int n = nums.length;
    int low = 0, high = n - 1;
    while (low < high) {
      int mid = (low + high) / 2;
      if (nums[mid] < nums[mid + 1]) {
        low = mid + 1;
      } else {
        high = mid;
      }
    }
    return low;
}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
