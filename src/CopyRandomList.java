import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class CopyRandomList {
	
	//A linked list is given such that each node contains an additional 
	//random pointer which could point to any node in the list or null.
	//Return a deep copy of the list.
	
	static class RandomListNode {
		int label;
		RandomListNode next, random;
		
		RandomListNode(int x) { 
			this.label = x;
		}
	};
	
	// Suppose there is no cycle??
	public static RandomListNode Solution (RandomListNode head) {
		if (head == null)
			return null;
		
		RandomListNode pre = head;
		Map<RandomListNode, Integer> oriMap = new HashMap<>();
		Map<Integer, RandomListNode> newMap = new HashMap<>();
		
		RandomListNode newPre = new RandomListNode(pre.label);
		newPre.next = null;
		newPre.random = null;
		oriMap.put(head, 0);
		newMap.put(0, newPre);
		
		int index = 1;
		RandomListNode curr = pre.next;
		while (curr != null) {
			RandomListNode newNode = new RandomListNode (curr.label);
			newNode.next = null;
			newNode.random = null;
			newPre.next = newNode;
			oriMap.put(curr, index);
			newMap.put(index, newNode);
			curr = curr.next;
			newPre = newNode;
			index ++;
			
		}
		
		RandomListNode oriPtr = head;
		RandomListNode newPtr = newMap.get(0);
		while (oriPtr != null) {
			if (oriPtr.random != null) {
				int i = oriMap.get(oriPtr.random);
				newPtr.random = newMap.get(i);
			}
			oriPtr = oriPtr.next;
			newPtr = newPtr.next;
		}
		
		return newMap.get(0);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomListNode node1 = new RandomListNode(-1);
		RandomListNode node2 = new RandomListNode(8);
		RandomListNode node3 = new RandomListNode(7);
		RandomListNode node4 = new RandomListNode(-3);
		RandomListNode node5 = new RandomListNode(4);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = null;
		
		node1.random = node5;
		node2.random = node4;
		node3.random = null;
		node4.random = null;
		node5.random = node1;
		
		RandomListNode node = Solution(node1);
		System.out.println(node1);
		System.out.println(node);
		
	}

}
