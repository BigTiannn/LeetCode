/**
 * https://oj.leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 * Given a singly linked list where elements are sorted in ascending order, 
 * convert it to a height balanced BST.
 * 
 * @author BigTiannn {10-29-2014}
 *
 */

public class ConvertSortedListToBinarySearchTree {
	
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	// Top-down. Time complexity is O(n^2)
	public static TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;
		if (head.next == null)
			return new TreeNode(head.val);
		
		// split the list into two parts
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null) {
        	slow = slow.next;
        	fast = fast.next.next;
        }
        ListNode middle = slow.next;
        slow.next = null;
        
        System.out.print("middle: ");
        System.out.println(middle.val);
        
        TreeNode root = new TreeNode(middle.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(middle.next);
        
        return root;
    }
	
	// TODO: Bottom-up!

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(3);
		ListNode node2 = new ListNode(5);
		ListNode node3 = new ListNode(8);
		node1.next = node2;
		node2.next = node3;
		
		sortedListToBST(node1);
	}

}
