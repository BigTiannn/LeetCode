/**
 * https://oj.leetcode.com/problems/insert-interval/
 * Given a set of non-overlapping intervals, insert a new interval into the intervals 
 * (merge if necessary).
 * You may assume that the intervals were initially sorted according to their start times.
 * Example 1:
 * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 * Example 2:
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 * 
 * @author BigTiannn {11-23-2014}
 *
 */

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
	
	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
ArrayList<Interval> result=new ArrayList<Interval>();
        
        if (newInterval == null)
            return intervals;
        
        if (intervals == null || intervals.size() == 0){
            result.add(newInterval);
            return result;
        }
        
        for (Interval tmp : intervals) {
            // tmp is completely before newInterval
            if (tmp.end < newInterval.start) {
                result.add(tmp);
            }
            // tmp is completely after newInterval
            else if (tmp.start > newInterval.end) {
                result.add(newInterval);
                newInterval = tmp;
            }
            // tmp and newInterval are overlapped, merge
            else {
                newInterval.start = Math.min(newInterval.start, tmp.start);
                newInterval.end = Math.max(newInterval.end, tmp.end);
            }
        }
        
        result.add(newInterval);
        
        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
