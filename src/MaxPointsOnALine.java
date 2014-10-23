/**
 * https://oj.leetcode.com/problems/max-points-on-a-line/
 *  
 * @author BigTiannn {10-22-2014}
 * 
 */

import java.util.HashMap;

public class MaxPointsOnALine {
	
	static class Point {
		int x;
		int y;
		Point() { x = 0; y = 0; }
		Point(int a, int b) { x = a; y = b; }
	}
	
	public static int maxPoints(Point[] points) {
		if (points == null)
			return 0;
		
		if (points.length < 3)
			return points.length;
		
		HashMap<Double, Integer> kmap = new HashMap<>();
		int ret = 0;
		
		for (int i = 0; i < points.length; i ++) {
			kmap.clear();
			
			double slope = 0;
			int samePointsCnt = 0;
			int maxPoints = 1;
			
			for (int j = i + 1; j < points.length; j ++) {
				// calculate the slope of points[i] with the rest of the points with greater indices
				if (points[i].x == points[j].x) {
					if (points[i].y == points[j].y) {
						samePointsCnt ++;
						continue;
					}
					else
						slope = Double.POSITIVE_INFINITY;
				}
				else {
					slope = (double) (points[i].y - points[j].y) / (double)(points[i].x - points[j].x);
					// signed zero!!!
					if (slope == -0.0)
						slope = 0;
				}
				
				System.out.print("slope: ");
				System.out.println(slope);
				
				int count = 0;
				if (kmap.containsKey(slope)) {
					count = kmap.get(slope);
					kmap.put(slope, ++ count);
				} else {
					kmap.put(slope, 2);
				}
				maxPoints = Math.max(maxPoints, count);
				System.out.println(maxPoints);
			}
			ret = Math.max(ret, maxPoints + samePointsCnt);
		}
        return ret;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// test case 1
//		Point p1 = new Point(2, 3);
//		Point p2 = new Point(3, 3);
//		Point p3 = new Point(-5, 3);
//		
//		Point array[] = {p1, p2, p3};
//		System.out.println(maxPoints(array));
		
		// test case 2
		Point p1 = new Point(1, 1);
		Point p2 = new Point(1, 1);
		Point p3 = new Point(1, 1);
		
		Point array[] = {p1, p2, p3};
		System.out.println(maxPoints(array));
	}

}
