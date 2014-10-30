import java.util.Arrays;

/**
 * https://oj.leetcode.com/problems/sort-colors/
 * Given an array with n objects colored red, white or blue, 
 * sort them so that objects of the same color are adjacent, 
 * with the colors in the order red, white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent 
 * the color red, white, and blue respectively.
 * 
 * @author BigTiannn {10-29-2014}
 *
 */

public class SortColors {
	public final static int RED = 0;
	public final static int WHITE = 1;
	public final static int BLUE = 2;
	
	// two passes
	public void sortColors(int[] A) {
		int count[] = new int[3];
        
        for (int i = 0; i < A.length; i ++) {
            count[A[i]] ++;
        }
        
        int counter = 0;
        for (int i = 0; i < 3; i ++) {
            for (int j = 0; j < count[i]; j ++) {
                A[counter ++] = i;
            }
        }
        return;
    }
	
	// one passes, two pointers
	public static void sortColors_2(int[] A) {
		int red = 0, blue = A.length - 1;
		for (int i = 0; i < blue + 1; ) {
			if (A[i] == RED) {
				swap(A, i ++, red ++);
			} else if (A[i] == BLUE) {
				swap(A, i, blue --);
			} else
			    i ++;
		}
	}
	
	private static void swap(int[] A, int index1, int index2) {
		int tmp = A[index1];
		A[index1] = A[index2];
		A[index2] = tmp;
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {0, 1};
		sortColors_2(A);
	}

}
