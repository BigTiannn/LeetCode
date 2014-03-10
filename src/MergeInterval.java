import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/***
 * http://oj.leetcode.com/problems/merge-intervals/
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * @author BigTiannn
 */
public class MergeInterval {
	
	public static class Interval {
		int start;
		int end;
		Interval() {
			start = 0;
			end = 0;
		}
		
		Interval(int s, int e) { 
			start = s;
			end = e;
		}
	}
	
	public static ArrayList<Interval> Solution(ArrayList<Interval> intervals) {
        ArrayList<Interval> res = new ArrayList<>();
        
        if (intervals == null)
        	return res;
        
        Collections.sort(intervals, new Comparator<Interval> () {
        	public int compare (Interval interval1, Interval interval2) {
        		if (interval1.start < interval2.start)
        			return -1;
        		if (interval1.start == interval2.start && interval1.end < interval2.end)
        			return -1;
        		return 1;
        	}
        });
        
        int curr = 0;
        while (curr < intervals.size()) {
        	Interval newInterval = new Interval(intervals.get(curr).start,
        			intervals.get(curr).end);
        	int i = curr + 1;
        	while (i < intervals.size()) {
        		if (intervals.get(i).start >= newInterval.start &&
        				intervals.get(i).start <= newInterval.end) {
        			if (intervals.get(i).end > newInterval.end) {
        				newInterval.end = intervals.get(i).end;
        			}
        			i ++;
        		} else {
        			break;
        		}
        	}
        	res.add(newInterval);
    		curr = i;
        }
        
        return res;
    }

	public static void main(String[] args) {
//		[1,3],[2,6],[8,10],[15,18]
		Interval interval1 = new Interval(1, 4);
		Interval interval2 = new Interval(0, 2);
		Interval interval3 = new Interval(3, 5);
//		Interval interval4 = new Interval(15, 18);
		
		ArrayList<Interval> list = new ArrayList<>();
		list.add(interval1);
		list.add(interval2);
		list.add(interval3);
//		list.add(interval4);
		
		System.out.println(Arrays.toString(Solution(list).toArray()));
		
	}

}
