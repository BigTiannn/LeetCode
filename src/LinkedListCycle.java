
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
		ListNode ptr1 = head, ptr2 = head;
		
		while (ptr2 != null && ptr2.next != null ) {
			ptr1 = ptr1.next;
			ptr2 = ptr2.next.next;
			
			if (ptr1 == ptr2)
				break;
		}
		
		if (ptr2 == null || ptr2.next == null)
			return false;
		
		return true;
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

	public static void main(String[] args) {
//		ListNode head = new ListNode(1);
		ListNode head = null;
		
		boolean flag = hasCycle(head);
		
		System.out.println(flag);

	}

}
