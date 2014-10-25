/**
 * https://oj.leetcode.com/problems/merge-two-sorted-lists/
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 * 
 * @author BigTiannn {10-24-2014}
 *
 */

public class MergeTwoSortedLists {
	
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode ptr = new ListNode(0);
		ListNode head = ptr;
		for (; l1 != null && l2 != null; ptr = ptr.next) {
			if (l1.val <= l2.val) {
				ptr.next = l1;
				l1 = l1.next;
			} else {
				ptr.next = l2;
				l2 = l2.next;
			}
		}
		
		ptr.next = (l1 == null) ? l2 : l1;
		
        return head.next;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
