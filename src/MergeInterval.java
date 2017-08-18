import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/***
 * https://leetcode.com/problems/merge-intervals/description/
 * Given a collection of intervals, merge all overlapping intervals.
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
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
	
	// implementation @ Jan-2015
	public static ArrayList<Interval> Solution(ArrayList<Interval> intervals) {
    ArrayList<Interval> res = new ArrayList<>();
        
    if (intervals == null)  return res;
        
    Collections.sort(intervals, new Comparator<Interval> () {
    	public int compare (Interval i1, Interval i2) {
    		if (i1.start < i2.start)
    			return -1;
    		if (i1.start == i2.start && i1.end < i2.end)
    			return -1;
    		return 1;
    	}
    });
        
    int curr = 0;
    while (curr < intervals.size()) {
    	Interval newInterval = new Interval(intervals.get(curr).start, intervals.get(curr).end);
    	int i = curr + 1;
    	while (i < intervals.size()) {
    		if (intervals.get(i).start >= newInterval.start && intervals.get(i).start <= newInterval.end) {
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
	
	// a more concise implementation
	public List<Interval> merge(List<Interval> intervals) {
    List<Interval> res = new ArrayList<>();
    
    if (intervals == null || intervals.size() == 0) return res;
    
    intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
    
    Interval toMergeIntv = intervals.get(0);
    for (int i = 1; i < intervals.size(); i ++) {
        Interval intv = intervals.get(i);
        if (intv.start > toMergeIntv.end) {
            res.add(toMergeIntv);
            toMergeIntv = intv;
        } else {
            if (toMergeIntv.end < intv.end)    toMergeIntv.end = intv.end;
        }
    }
    res.add(toMergeIntv);
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
