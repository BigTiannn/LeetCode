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
	
	// some idea with "convert from sorted array"
	// use fast and slow pointers to find middle element
	// Time Complexity: T(n) = n + T(n / 2) = nlogn
	public TreeNode sortedListToBST(ListNode head) {
        return buildBST(head);
    }
    
    private TreeNode buildBST(ListNode head) {
        if (head == null)    return null;
        
        if (head.next == null)  return new TreeNode(head.val);
        
        // use fast and slow pointers to get the middle element
        ListNode prev = head, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        
        // "slow" is middle element
        TreeNode root = new TreeNode(slow.val);
        root.left = buildBST(head);
        root.right = buildBST(slow.next);
        
        return root;
    }
    
    // Bottom-up recursive
    ListNode listHead;	// pay attention here! java pass by value, so we need a member variable
    public TreeNode sortedListToBST_recusive(ListNode head) {
        this.listHead = head;
        
        int len = 0;
        ListNode ptr = head;
        while (ptr != null) {
            ptr = ptr.next;
            len ++;
        }
        
        return buildBST(0, len - 1);
    }
    
    private TreeNode buildBST(int start, int end) {
        if (start > end)    return null;
        
        int mid = (start + end) / 2;
        TreeNode left = buildBST(start, mid - 1);
        TreeNode root = new TreeNode(listHead.val);
        root.left = left;
        listHead = listHead.next;	// pay attention here(this is why we need a member variable)
        // if we don't want a variable, we can do a trick
//        if (head.next != null) { // "move to next"  
//        	head.val = head.next.val;  
//        	head.next = head.next.next;  
//        	root.right = buildBST(head, mid + 1, end);  
//        }  
        root.right = buildBST(mid + 1, end);
        return root;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
