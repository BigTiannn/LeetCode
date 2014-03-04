import java.util.Arrays;


public class Candy {
	// sorting
	public static int solution1(int[] ratings) {
		int total = 0;
		int[] candy = new int[ratings.length];
		int[] ratings2 = new int[ratings.length];
		
		int[] queue = new int[ratings.length];
		
		for (int i = 0; i < ratings.length; i ++) {
			queue[i] = i;
			ratings2[i] = ratings[i];
		}
		
		QuickSort(ratings2, queue, 0, ratings.length-1);
		
		System.out.println(Arrays.toString(ratings2));
		System.out.println(Arrays.toString(queue));
		
		for (int i = 0; i < ratings.length; i ++) {
			int index = queue[i];
			candy[index] = 1;
			
			if (index - 1 >= 0 && ratings[index] > ratings[index-1])
				candy[index] = candy[index-1] + 1;
			if (index + 1 < ratings.length && ratings[index] > ratings[index+1])
				candy[index] = candy[index] > candy[index+1] ? candy[index] : candy[index+1] + 1;
				
			total += candy[index];
		}
		
		System.out.println(Arrays.toString(candy));
		return total;
	}
	
	public static int solution2 (int ratings[]) {
		long t1 = System.currentTimeMillis();
		int[] candy = new int[ratings.length];
		candy[0] = 1;
		int total = candy[0];
		
		if (ratings == null || ratings.length == 0)
			return 0;
		
		if (ratings.length == 1)
			return 1;
		
		for (int i = 1; i < ratings.length; i ++) {
			if (ratings[i] > ratings[i-1]) {
				candy[i] = candy[i-1] + 1;
				total += candy[i];
			}
			
			else if (ratings[i] == ratings[i-1]) {
				candy[i] = 1;
				total += candy[i];
			}
			
			else if (ratings[i] < ratings[i-1] && candy[i-1] > 1){
				candy[i] = 1;
				total += candy[i];
			}
			
			else {	//back-track
				candy[i] = 1;
				total += candy[i];
				int j = i;
				while (j > 0 && ratings[j] < ratings[j-1] && candy[j] >= candy[j-1]){
					candy[j-1] ++;
					total ++;
					j --;
				}
			}
		}
		
		long t2 = System.currentTimeMillis();
		System.out.println(t1);
        System.out.println(t2);
		
		return total;
	}
	
	public static void QuickSort(int[] array, int[] indices, int left, int right) {
		
		if (left >= right)
			return;
		
		int mark = array[left];
		int i = left + 1;
		int j = right;
		
		while (true) {
			while (i != right && array[i] < mark)
				i ++;
			
			while (j != left && array[j] >= mark)
				j --;
			
			if (i >= j)
				break;
			
			int tmp = array[i];
			array[i] = array[j];
			array[j] = tmp;
			
			tmp = indices[i];
			indices[i] = indices[j];
			indices[j] = tmp;
		}
		
		int tmp = array[j];
		array[j] = array[left];
		array[left] = tmp;
		
		tmp = indices[j];
		indices[j] = indices[left];
		indices[left] = tmp;
		
		QuickSort(array, indices, left, j - 1);
		QuickSort(array, indices, j + 1, right);
		
	}
	
	public static void main (String[] args) {
		// test case 1
//		int[] ratings = {58,21,72,77,48,9,38,71,68,77,82,47,25,94,89,54,26,54,54,99,64,71,76,63,81,82,60,64,29,51,87,87,72,12,16,20,21,54,43,41,83,77,41,61,72,82,15,50,36,69,49,53,92,77,16,73,12,28,37,41,79,25,80,3,37,48,23,10,55,19,51,38,96,92,99,68,75,14,18,63,35,19,68,28,49,36,53,61,64,91,2,43,68,34,46,57,82,22,67,89};
		// test case 2
		int[] ratings = new int[8893];
		for (int i = 0; i < 8893; i ++) {
			ratings[i] = i+1;
		}
		// test case 3
//		int[] ratings = {58,21,72,77,48,9,38,71,68,77,82,47,25,94,89,54,26,54,54,99,64,71,76,63,81,82,60,64,29,51,87,87,72,12,16,20,21,54,43,41,83,77,41,61,72,82,15,50,36,69,49,53,92,77,16,73,12,28,37,41,79,25,80,3,37,48,23,10,55,19,51,38,96,92,99,68,75,14,18,63,35,19,68,28,49,36,53,61,64,91,2,43,68,34,46,57,82,22,67,89};
		System.out.println(solution2(ratings));
	}
}
