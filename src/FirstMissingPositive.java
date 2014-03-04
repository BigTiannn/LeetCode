
public class FirstMissingPositive {
	
	public static int solution(int[] A) {
		int[] array = new int[65536];
		
		for (int i = 0; i < A.length; i ++) {
			if (A[i] >= 0) {
				array[A[i]] = 1;
			}
		}
		
		for (int i = 1; i < array.length; i ++) {
			if (array[i] == 0)
				return i;
		}
		
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
