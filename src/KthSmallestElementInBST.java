import java.util.Stack;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/#/description
 * Given a binary search tree, write a function kthSmallest to find the kth 
 * smallest element in it.
 * Note: 
 * You may assume k is always valid, 1 <= k <= BST's total elements.
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to 
 * find the kth smallest frequently? How would you optimize the kthSmallest routine?
 * 
 * @author BigTiannn
 *
 */

public class KthSmallestElementInBST {
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode (int x) { 
      val = x;
    }
  }
  
  // use in-order traversal
  public int kthSmallest(TreeNode root, int k) {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode curr = root;
    int count = 0;
    while (!stack.isEmpty() || curr != null) {
        if (curr == null) {
            curr = stack.pop();
            count ++;
            if (count == k) break;
            curr = curr.right;
        } else {
            stack.push(curr);
            curr = curr.left;
        }
    }
    return curr.val;
  }
  
  // follow-up: if can change the structure of the tree,
  // add one more attribute --- leftCount
  // then the time complexity is O(height of the BST)
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
