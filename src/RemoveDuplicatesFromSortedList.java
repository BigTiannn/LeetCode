/**
 * https://oj.leetcode.com/problems/remove-duplicates-from-sorted-list/
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * 
 * @author BigTiannn {10-24-2014}
 *
 */

public class RemoveDuplicatesFromSortedList {
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return head;
		
		ListNode curr = head.next, prev = head;
		while (curr != null) {
			if (prev.val == curr.val)
				prev.next = curr.next;
			else
				prev = curr;
			curr = curr.next;
		}
		
        return head;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
