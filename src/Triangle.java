import java.util.ArrayList;
import java.util.Arrays;


public class Triangle {
	
	// Given a triangle, find the minimum path sum from top to bottom.
	// Each step you may move to adjacent numbers on the row below.
	
	// DP (bottom-up)
	public static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0)
			return 0;
		
		int row = triangle.size();
		int maxLine = triangle.get(row - 1).size();
		int[] minV = new int[maxLine];
		
		for (int i = 0; i < maxLine; i ++)
			minV[i] = triangle.get(row - 1).get(i);
		
		for (int i = row - 2; i >= 0; i --){
			for (int j = 0; j < triangle.get(i).size(); j ++)
				minV[j] = Math.min(minV[j], minV[j + 1]) + triangle.get(i).get(j);
		}
		
        return minV[0];
    } 
	
	// DP (top-down)
	public static int minimumTotal2(ArrayList<ArrayList<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0)
			return 0;
			
		int row = triangle.size();
		int maxLine = triangle.get(row - 1).size();
		int[][] minV = new int[2][maxLine];
			
		minV[0][0] = triangle.get(0).get(0);
		for (int i = 1; i < row; i ++) {
			for (int j = 0; j < triangle.get(i).size(); j ++){
				if ( j == 0 )
					minV[i % 2][j] = minV[(i + 1) % 2][j] + triangle.get(i).get(j);
				else if (j == triangle.get(i).size() - 1 )
					minV[i % 2][j] = minV[(i + 1) % 2][j - 1] + triangle.get(i).get(j);
				else
					minV[i % 2][j] = Math.min(minV[(i + 1) % 2][j - 1], minV[(i + 1) % 2][j]) + triangle.get(i).get(j);
			}
		}
		
		int minTotal = minV[(row - 1) % 2][0];
		for (int i = 1; i < triangle.get(row - 1).size(); i ++) {
			if (minV[(row - 1) % 2][i] < minTotal)
				minTotal = minV[(row - 1) % 2][i];
		}
		
		return minTotal;
	} 	
	
	public static void main (String[] args) {
		ArrayList<Integer> a1 = new ArrayList<>();
		a1.add(2);
		ArrayList<Integer> a2 = new ArrayList<>();
		a2.add(3);
		a2.add(4);
		ArrayList<Integer> a3 = new ArrayList<>();
		a3.add(6);
		a3.add(5);
		a3.add(7);
		ArrayList<Integer> a4 = new ArrayList<>();
		a4.add(4);
		a4.add(1);
		a4.add(8);
		a4.add(3);
		ArrayList<ArrayList<Integer>> aa = new ArrayList<>();
		aa.add(a1);
		aa.add(a2);
		aa.add(a3);
		aa.add(a4);
		System.out.println(minimumTotal2(aa));
	}

}
