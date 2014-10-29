/**
 * https://oj.leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * 
 * @author BigTiannn {10-28-2014}
 *
 */

public class ConvertSortedArrayToBinarySearchTree {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public TreeNode sortedArrayToBST(int[] num) {
		if (num == null)
			return null;
		
        return sortedArrayToBST(num, 0, num.length - 1);
    }
	
	public TreeNode sortedArrayToBST(int[] num, int start, int end) {
		if (start > end)
		    return null;
		
		// left sub-tree is always full
        int mIndex = (start + end) / 2;
        if ((end - start + 1) % 2 == 0)
        	mIndex += 1;
        // right sub-tree is always full
        // int mIndex = start + (end - start) / 2;
        TreeNode root = new TreeNode(num[mIndex]);
        root.left = sortedArrayToBST(num, start, mIndex - 1);
        root.right = sortedArrayToBST(num, mIndex + 1, end);
        return root;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
