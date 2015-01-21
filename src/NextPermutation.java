import java.util.Arrays;
import java.util.Collections;

/***
 * http://oj.leetcode.com/problems/next-permutation/
 * Implement next permutation, which rearranges numbers into 
 * the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it 
 * as the lowest possible order (ie, sorted in ascending order).
 * The replacement must be in-place, do not allocate extra memory.
 * 
 * @author BigTiannn
 */
public class NextPermutation {
	
	public static void nextPermutation(int[] num) {
		// 1. from right to left, find the first element violates the increasing trend (partition number)
        int partitionIdx = -1;
        for (int i = num.length - 2; i >= 0; i --) {
            if (num[i] < num[i + 1]) {
                partitionIdx = i;
                break;
            }
        }
        
        // 2. from right to left, find the first number that is greater than the partition number (change number)
        if (partitionIdx != -1) {
            int changeIdx = -1;
            for (int i = num.length - 1; i > partitionIdx; i --) {
                if (num[i] > num[partitionIdx]) {
                    changeIdx = i;
                    break;
                }
            }
            // 3. swap the partition number and change number
            if (changeIdx != -1) {
                int tmp = num[partitionIdx];
                num[partitionIdx] = num[changeIdx];
                num[changeIdx] = tmp;
            }
        }
        
        // 4. reverse all the digits on the right of the partition number
        for (int i = partitionIdx + 1, j = num.length - 1; i < j; i ++, j --) {
            int tmp = num[i];
            num[i] = num[j];
            num[j] = tmp;
        }
        
        return;
    }
	
	

	public static void main(String[] args) {
//		int[] num = {4,2,0,2,3,2,0};
		int[] num = {1, 3, 2};
		nextPermutation(num);
		System.out.println(Arrays.toString(num));

	}

}
