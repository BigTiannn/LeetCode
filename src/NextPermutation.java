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
        if (num == null)
        	return;
        for (int i = num.length - 1; i >= 0; i --) {
        	int max = -1;
        	for (int j = i + 1; j < num.length; j ++) {
        		if (num[j] > num[i] && 
        				(max == -1 || num[max] > num[j])) {
        			max = j;
        		}
        	}
        	if (max != -1) {
    			int tmp = num[i];
    			num[i] = num [max];
    			num[max] = tmp;
    			sort(num, i + 1);
    			return;
    		}
        }
        
        //rearrange it in ascending order
        for (int i = 0; i < num.length / 2; i ++) {
        	int tmp = num[i];
        	num[i] = num[num.length - i - 1];
        	num[num.length - i - 1] = tmp;
        }
        
        return;
    }
	
	public static void sort(int[] num, int start) {
		int[] array = new int[num.length - start];
		for (int i = start; i < num.length; i ++)
			array[i - start] = num[i];
		Arrays.sort(array);
		for (int i = start; i < num.length; i ++)
			num[i] = array[i - start];
	}

	public static void main(String[] args) {
//		int[] num = {4,2,0,2,3,2,0};
		int[] num = {1, 3, 2};
		nextPermutation(num);
		System.out.println(Arrays.toString(num));

	}

}
