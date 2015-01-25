/**
 * https://oj.leetcode.com/problems/linked-list-cycle/
 * Given a linked list, determine if it has a cycle in it.
 * Follow up:
 * Can you solve it without using extra space?
 * 
 * @author BigTiannn
 *
 */
public class LinkedListCycle {
	
	static class ListNode {
		int val;
		ListNode next;
		
		ListNode (int x) {
			val = x;
			next = null;
		}
	}
	
	public static boolean hasCycle(ListNode head) {
		ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
	}
	
	public static ListNode detectCycle(ListNode head) {
		ListNode ptr1 = head, ptr2 = head;
		
		while (ptr2 != null && ptr2.next != null ) {
			ptr1 = ptr1.next;
			ptr2 = ptr2.next.next;
			
			if (ptr1 == ptr2)
				break;
		}
		
		if (ptr2 == null || ptr2.next == null)
			return null;
		
		ptr1 = head;
		while (ptr1 != ptr2) {
			ptr1 = ptr1.next;
			ptr2 = ptr2.next;
		}
		
		return ptr1;
	}
	
	public ListNode detectCycle_2(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                // set another slow pointer starting from the head,
            	// and two slow pointers will meet at the entrance of the cycle
                ListNode slow2 = head;
                while (slow != slow2) {
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
        }
        return null;
    }

	public static void main(String[] args) {
//		ListNode head = new ListNode(1);
		ListNode head = null;
		
		boolean flag = hasCycle(head);
		
		System.out.println(flag);

	}

}
