
public class ReorderList {

	static class ListNode {
		int val;
		ListNode next;
		
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public static void reorderList(ListNode head) {
		int length = 0;
		ListNode ptr = head;
		ListNode tail = head;
		
		if (head == null)
			return ;
		
		while (ptr != null) {
			length ++;
			tail = ptr;
			ptr = ptr.next;
		}
		
		ptr = head;
		int half = length % 2 == 0 ? length / 2 - 1 : length / 2;
		for (int i = 0; i < half; i ++) {
			ptr = ptr.next;
		}
		
		// reverse the second half of the linked list
		ListNode pre = ptr;
		ListNode curr = ptr.next;
		pre.next = null;
		while (curr != null) {
			ListNode tmp = curr.next;
			curr.next = pre;
			pre = curr;
			curr = tmp;
		}
		
		ptr = head;
		for (int i = 0; i < length / 2; i ++) {
			ListNode newtail = tail.next;
			ListNode newhead = ptr.next;
			tail.next = ptr.next;
			ptr.next = tail;
			ptr = newhead;
			tail = newtail;
		}
		
		return ;
	}
		 
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		
		reorderList(n1);
		
		ListNode ptr = n1;
		while (ptr != null) {
			System.out.println(ptr.val);
			ptr = ptr.next;
		}

	}

}
