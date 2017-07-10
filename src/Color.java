/**
 * https://oj.leetcode.com/problems/fraction-to-recurring-decimal/
 * Given two integers representing the numerator and denominator of a fraction, 
 * return the fraction in string format.
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 * For example,
 * Given numerator = 1, denominator = 2, return "0.5".
 * Given numerator = 2, denominator = 1, return "2".
 * Given numerator = 2, denominator = 3, return "0.(6)".
 * 
 * @author BigTiannn {12-20-2014}
 *
 */

import java.util.Arrays;

public class FractionToRecurringDecimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "/a/./b/../../c/";
		String[] array = s.split("/");
		System.out.println(Arrays.toString(array));
	}
	
	class MyType {
	    int someProperty;
	    String anotherProperty;
	    COLOR color; // 'COLOR' needs to be defined
	};

	public enum COLOR{
	    RED, GREEN, BLUE
	}
	
	public void sort(MyType[] array) {
	    int redPtr = 0, bluePtr = array.length - 1;
	    for (int i = 0; i < array.length;) {
	        if (array[i].color == COLOR.RED) {
	            swap(array, redPtr, i);
	            redPtr ++;
	            i ++;
	        } else if (array[i].color == COLOR.BLUE) {
	            swap(array, bluePtr, i);
	            bluePtr --;
	        } else { // green
	            i ++;
	        }
	    }
	    return;
	}

	public void swap(MyType[] array, int index1, int index2) {
		MyType tmp = array[index1];
	    array[index1] = array[index2];
	    array[index2] = tmp;
	    return;
	}

}
