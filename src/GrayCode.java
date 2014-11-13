/**
 * https://oj.leetcode.com/problems/gray-code/
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * Given a non-negative integer n representing the total number of bits in the code, print the 
 * sequence of gray code. A gray code sequence must begin with 0.
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * 
 * @author BigTiannn {11-12-2014}
 *
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GrayCode {
	
	public static List<Integer> grayCode(int n) {
		List<Integer> list = new ArrayList<>();
        list.add(0);
        
        if (n == 0)
            return list;
        
        list.add(1);
        for (int i = 1; i < n; i ++) {
            int len = list.size();
            for (int j = len - 1; j >= 0; j --) {
                list.add(list.get(j) + (int)Math.pow(2, i));
            } 
        }
        
        return list;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(grayCode(2).toArray()));
	}

}
