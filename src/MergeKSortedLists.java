/**
 * https://oj.leetcode.com/problems/merge-k-sorted-lists/
 * Merge k sorted linked lists and return it as one sorted list. 
 * Analyze and describe its complexity.
 * 
 * @author BigTiannn {10-29-2014}
 *
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {
	
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	/**
	 * Solution 1
	 * Divide-and-Conquer: everytime merge lists.get(i) and lists.get(i + (n+1)/2)
	 * T(k) = 2T(k/2) + O(nk), time complexity is O(nklogk)
	 * Run Time on LeetCode platform: 600ms.
	 * @param lists
	 * @return
	 */
	public static ListNode mergeKLists(List<ListNode> lists) {
		if (lists == null || lists.size() == 0)
			return null;
		
		int n = lists.size();
		while (n > 1) {
			int m = (n + 1) / 2;
			System.out.println(m);
			for (int i = 0; i < n / 2; i ++) {
				ListNode l = mergeTwoLists(lists.get(i), lists.get(i + m));
				print(l);
				lists.remove(i);
				lists.add(i, l);
			}
			n = m;
		}
        
        return lists.get(0);
    }
	
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode ptr = new ListNode(-1);
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
	
	/**
	 * Solution 2
	 * Heap: priority queue
	 * Insertion to heap is O(logk), total time complexity is O(nklogk)
	 * where n is the average length of each list
	 * Run Time on LeetCode platform: 428ms.
	 * @param lists
	 * @return
	 */
	public static ListNode mergeKLists_2(List<ListNode> lists) {
		if (lists == null || lists.size() == 0)
			return null;
		
		PriorityQueue<ListNode> kheap = new PriorityQueue<>(lists.size(),
				new Comparator<ListNode>() {
					public int compare(ListNode node1, ListNode node2) {
						if (node1.val > node2.val)
							return 1;
						else if (node1.val == node2.val)
							return 0;
						else
							return -1;
					}
				});
		
		for (ListNode list : lists) {
			if (list != null)
				kheap.add(list);
		}
		
		ListNode head = new ListNode(-1);
		ListNode ptr = head;
		while (!kheap.isEmpty()) {
			ListNode node = kheap.poll();
			ptr.next = node;
			if (node.next != null)
				kheap.add(node.next);
			ptr = ptr.next;
		}
        
        return head.next;
    }
	
	public static void print(ListNode head) {
		while (head != null) {
			System.out.print(head.val);
			head = head.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(-1);
		ListNode node2 = new ListNode(2);
		List<ListNode> lists = new ArrayList<>();
		lists.add(node1);
		lists.add(null);
		lists.add(node2);
		mergeKLists(lists);
	}

}
