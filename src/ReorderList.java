
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
	
	public static void reorderList_2(ListNode head) {
        if (head == null || head.next == null) return;
        
        // find the middle node
        ListNode slow = head, fast = slow, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        
        System.out.println(slow.val);
        
        // len(second half) == len(first half) (even len)
        // len(second half) == len(first half) + 1 (odd len)
        slow = reverse(slow);
        printList(slow);
        
        // merge two lists
        ListNode first = head, second = slow;
        while (first.next != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;
            first.next = second;
            second.next = tmp1;
            first = tmp1;
            second = tmp2;
        }
        first.next = second;
        return;
    }
	
	public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;
            
        ListNode prev = head, curr = head.next;
        while (curr != null) {
            ListNode tmp = curr;
            curr = curr.next;
            tmp.next = prev;
            prev = tmp;
        }
        head.next = null;   // pay attention here
        return prev;
    }
	
	public static void printList(ListNode head) {
		ListNode ptr = head;
		while (ptr != null) {
			System.out.print(ptr.val + " ");
			ptr = ptr.next;
		}
		System.out.println();
	}
		 
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		
		reorderList_2(n1);
		printList(n1);
	}

}
