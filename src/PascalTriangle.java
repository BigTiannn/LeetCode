import java.util.ArrayList;
import java.util.Arrays;


public class PascalTriangle {
	
	public static ArrayList<ArrayList<Integer>> generate(int numRows) {
		ArrayList<ArrayList<Integer>> triangle = new ArrayList<>();
		
		if (numRows <= 0)
			return triangle;
		
		ArrayList<Integer> prelist = new ArrayList<>();
		prelist.add(1);
		triangle.add(prelist);
		
		for (int i = 1; i < numRows; i ++) {
			ArrayList<Integer> list = new ArrayList<>();
			list.add(1);
			for (int j = 1; j < i; j ++) {
				list.add(prelist.get(j - 1) + prelist.get(j));
			}
			list.add(1);
			triangle.add(list);
			prelist = list;
		}
		
		return triangle;
        
    }
	
	// Given an index k, return the k-th row of the Pascal's triangle.
	// For example, given k = 3, return [1,3,3,1].
	public static ArrayList<Integer> getRow(int rowIndex) {
		if (rowIndex < 0)
			return new ArrayList<>();
			
		if (rowIndex == 0){
			ArrayList<Integer> row = new ArrayList<>();
			row.add(1);
			return row;
		}
		
		ArrayList<Integer> row = new ArrayList<>();
		ArrayList<Integer> prerow = new ArrayList<>();
		for (int i = 0; i < rowIndex; i ++) {
			row = new ArrayList<>();
			row.add(1);
			for (int j = 0; j < i; j ++) {
				row.add(prerow.get(j) + prerow.get(j + 1));
			}
			row.add(1);
			prerow = row;
		}
		
		return row;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		ArrayList<ArrayList<Integer>> tri = generate(5);
//		for (int i = 0; i < tri.size(); i ++)
//			System.out.println(Arrays.toString(tri.get(i).toArray()));
		
		System.out.println(Arrays.toString(getRow(3).toArray()));
		
	}

}
