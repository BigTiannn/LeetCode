
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
	
	// solution 2: bucket sorting
	// time complexity: O(n)
	public int firstMissingPositive(int[] A) {
        // bucket sorting
        for (int i = 0; i < A.length; i ++) {
            while (A[i] != i + 1) {
                if (A[i] <= 0 || A[i] > A.length || A[i] == A[A[i] - 1])    break;
                swap(A, i, A[i] - 1);
            }
        }
        
        for (int i = 0; i < A.length; i ++) {
            if (A[i] != i + 1)    return i + 1;
        }
        
        return A.length + 1;
    }
    
    private void swap(int[] A, int i1, int i2) {
        int tmp = A[i1];
        A[i1] = A[i2];
        A[i2] = tmp;
        return;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
