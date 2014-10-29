/**
 * https://oj.leetcode.com/problems/sort-list/
 * Sort a linked list in O(nlogn) time using constant space complexity.
 * 
 * @author BigTiannn {10-29-2014}
 *
 */
public class SortList {
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		
		// find the middle node using two poiters
		ListNode slow = head, fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		// split the list into two parts
		fast = slow;
		slow = slow.next;
		fast.next = null;
		
		ListNode head1 = sortList(head);
		ListNode head2 = sortList(slow);
		return mergeSortedList(head1, head2);
    }
	
	public ListNode mergeSortedList(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(-1);
		ListNode ptr = head;
		
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				ptr.next = l1;
				l1 = l1.next;
			} else {
				ptr.next = l2;
				l2 = l2.next;
			}
			ptr = ptr.next;
		}
		ptr.next = (l1 == null) ? l2 : l1;
		
		return head.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
