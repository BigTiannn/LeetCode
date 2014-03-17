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
		String ret = "";
		ArrayList<Integer> list = new ArrayList<Integer>();
		int factorial = 1;
		for (int i = 1; i <= n; i ++) {
			list.add(i);
			factorial *= i;
		}
		factorial /= n;
		int i = n - 1;
		int div = 0;
		while (i > 0) {
			div = k / factorial;
			k = k % factorial;
			if (k > 0) {
				ret += Integer.toString(list.get(div));
				list.remove(div);
			} else if (div > 0) {
				ret += Integer.toString(list.get(div - 1));
				list.remove(div - 1);
			} else {
				for (int j = list.size() - 1; j >= 0; j --)
					ret += Integer.toString(list.get(j));
				return ret;
			}
			factorial /= i;
			i --;
		}
		
		ret += Integer.toString(list.get(0));
		
        return ret;
    }
	
	public static void main(String[] args) {
		System.out.println(getPermutation(1, 1));

	}

}
