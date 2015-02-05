import java.util.LinkedList;


public class ShapeMatrix {
	
//	Count the number of shapes in a given (1/0) matrix.
//	A cluster of consecutive (not diagonal) 1's defines one shape.
//	eg 
//	1 1 0 0 1
//	1 0 0 1 0
//	1 1 0 1 0
//	0 0 1 0 0
//	No of shapes = 4
	
	public int CountShape(int [][] matrix){
		int m = matrix.length;
		int n = matrix[0].length;
		int counter = 0;
		
		LinkedList<int[]> queue = new LinkedList<int[]>();
		
		for(int i = 0; i < m; i ++){
			for(int j = 0; j < n; j ++){
				if(matrix[i][j] == 1){
					queue.add(new int[] {i, j});
					counter ++;
				}
				
				while(!queue.isEmpty()){
					int[] pos = queue.getFirst();
					queue.removeFirst();
					int x = pos[0];
					int y = pos[1]; 
					
					matrix[x][y] = -1;	//marked as visited
					
					if( x - 1 >= 0 && matrix[x - 1][y] == 1 ){	//top
						queue.add(new int[] {x - 1,y});
					}
					if( x + 1 < m && matrix[x + 1][y] == 1 ){	//bottom	
						queue.add(new int[] {x + 1,y});
					}
					if( y - 1 >= 0 && matrix[x][y - 1] == 1 ){	//left
						queue.add(new int[] {x,y - 1});
					}
					if( y + 1 < n && matrix[x][y + 1] == 1 ){	//right
						queue.add(new int[] {x,y + 1});
					}
				}
				
			}
		}
		
		return counter;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] matrix = {{1,1,0,0,1}, {1,0,0,1,0}, {1,1,0,1,0}, {0,0,1,0,0}};
		ShapeMatrix sm = new ShapeMatrix();
		System.out.println(sm.CountShape(matrix));
	}

}
