import java.util.ArrayList;

/***
 * http://oj.leetcode.com/problems/permutation-sequence/
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 * Given n and k, return the k-th permutation sequence.
 * 
 * @author BigTiannn
 */
public class PermutationSequence {
	
	public static String getPermutation(int n, int k) {
		// transfer it to start from 0 rather than 1
        k --;
        
        ArrayList<Integer> numList = new ArrayList<>();
        for (int i = 1; i <= n; i ++) {
            numList.add(i);
        }
        
        // calculate the factorial
        int factorial = 1;
        for (int i = 2; i < n; i ++) {
            factorial *= i;
        }
        
        StringBuilder res = new StringBuilder();
        for (int i = n - 1; i > 0; factorial /= i, i --) {
            int div = k / factorial;
            k = k % factorial;
            res.append(numList.get(div));
            numList.remove(div);
        }
        res.append(numList.get(0));
        return res.toString();
    }
	
	public static void main(String[] args) {
		System.out.println(getPermutation(1, 1));

	}

}
