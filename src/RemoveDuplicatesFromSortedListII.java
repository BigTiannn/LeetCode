/**
 * https://oj.leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 * Given a sorted linked list, delete all nodes that have duplicate numbers, 
 * leaving only distinct numbers from the original list.
 * 
 * @author BigTiannn {10-24-2014}
 *
 */

public class RemoveDuplicatesFromSortedListII {
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public ListNode deleteDuplicates(ListNode head) {
		ListNode curr = head, prev = null, newhead = head;
		
		while (curr != null) {
			boolean flag = false;
			while (curr.next != null && curr.val == curr.next.val) {
				curr = curr.next;
				flag = true;
			}
			if (flag) {
				// the first element is duplicated
				if (prev == null)
					newhead = curr.next;
				else
					prev.next = curr.next;
				curr = curr.next;
				continue;
			}
			prev = curr;
			curr = curr.next;
		}
		
		return newhead;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
