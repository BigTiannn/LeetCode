import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/***
 * http://oj.leetcode.com/problems/remove-element/
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * 
 * @author BigTiannn
 */
public class RemoveElement {
	public static int removeElement(int[] A, int elem) {
		if (A == null || A.length == 0)
			return 0;
		
		int front = 0, back = A.length - 1;
		int newLength = A.length;
		while (front <= back) {
			while (front < A.length && A[front] != elem)
				front ++;
			while (back >= 0 && A[back] == elem) {
				back --;
				newLength --;
			}
			if (front < back) {
				A[front] = A[back];
				newLength --;
				front ++;
				back --;
			}
		}
        
        return newLength;
    }

	public static void main(String[] args) {
		int[] test = {1, 2, 4, 4, 7};
		int newLength = removeElement(test, 4);
		for (int i = 0; i < newLength; i ++) {
			System.out.print(test[i]);
		}
	}

}
