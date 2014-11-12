/**
 * https://oj.leetcode.com/problems/unique-binary-search-trees/
 * 
 * @author BigTiannn {11-10-2014}
 *
 */

public class UniqueBinarySearchTrees {
	
	public int numTrees(int n) {
		if (n <= 1)
			return 1;
        
        int trees[] = new int[n + 1];
        trees[0] = 1;
        trees[1] = 1;
        
        for (int i = 2; i <= n; i ++) {
            for (int j = 0; j < i; j ++) {
                trees[i] += trees[j] * trees[i - j - 1];
            }
        }
        
        return trees[n];
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
