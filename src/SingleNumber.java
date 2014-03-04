
public class SingleNumber {
	
	// without using extra space (XOR)
	public static int findSingleNumber2(int[] A) {
        for (int i = A.length - 1; i > 0; i --) {
        	A[i-1] ^= A[i];
        }
        return A[0];
    }
	
	// without using extra space (mod)
	public static int findSingleNumber3(int[] A) {
		int result = 0;
		int[] bits = new int[32];
		
		for (int i = 0; i < 32; i ++) {
			for (int j = 0; j < A.length; j ++) {
				bits[i] += ( A[j] >> i ) & 1;
			}
			result |= ( bits[i] % 3 ) << i;
		}
		
		return result;
	}
	

	public static void main(String[] args) {
		int[] A = {8, 7, 8, 8};
		System.out.println(findSingleNumber3(A));
;	}

}
