/**
 * https://oj.leetcode.com/problems/maximum-gap/
 * 
 * Given an unsorted array, find the maximum difference between the 
 * successive elements in its sorted form.
 * Try to solve it in linear time/space.
 * Return 0 if the array contains less than 2 elements.
 * You may assume all elements in the array are non-negative integers 
 * and fit in the 32-bit signed integer range.
 * 
 * @author BigTiannn {01-04-2015}
 *
 */

import java.util.Arrays;

public class MaximumGap {
	
	public int maximumGap(int[] num) {
		int n = num.length;
        if (n < 2)
            return 0;
        
        // 1. find the min and max of num[]
        int minVal = num[0], maxVal = num[0];
        for (int i = 1; i < n; i ++) {
            minVal = Math.min(minVal, num[i]);
            maxVal = Math.max(maxVal, num[i]);
        }
        
        // 2. size of each bucket is len = ceiling{(max - min + 1) / (num.length - 1)}
        //    number of bucket is (max - min) / len + 1
        int bucketLen = (int) Math.ceil((double)(maxVal - minVal) / (n - 1));
        int bucketNum = (maxVal - minVal) / bucketLen + 1;
        
        // 3. claims empty buckets
        int[] minBucket = new int[bucketNum];
        int[] maxBucket = new int[bucketNum];
        Arrays.fill(minBucket, Integer.MAX_VALUE);
        Arrays.fill(maxBucket, Integer.MIN_VALUE);
        
        // 4. the number of bucket num[i] falls is (num[i] - min) / len
        for (int i = 0; i < n; i ++) {
            int idx = (num[i] - minVal) / bucketLen;
            minBucket[idx] = Math.min(minBucket[idx], num[i]);
            maxBucket[idx] = Math.max(maxBucket[idx], num[i]);
        }
        
        // 5. go through all the buckets, the maximum gap is the gap between the max value and min value of two successive non-empty buckets
        int ret = Integer.MIN_VALUE;
        int prev = minVal;
        for (int i = 0; i < bucketNum; i ++) {
            // empty bucket
            if (minBucket[i] == Integer.MAX_VALUE || maxBucket[i] == Integer.MIN_VALUE)
                continue;
            ret = Math.max(ret, minBucket[i] - prev);
            prev = maxBucket[i];
        }
        
        return ret;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
