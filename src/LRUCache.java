/**
 * https://oj.leetcode.com/problems/lru-cache/
 * Design and implement a data structure for Least Recently Used (LRU) cache. 
 * It should support the following operations: get and set.
 * get(key) - Get the value (will always be positive) of the key if the key 
 * exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. 
 * When the cache reached its capacity, it should invalidate the least recently 
 * used item before inserting a new item.
 * 
 * @author BigTiannn {11-24-2014}
 *
 */

import java.util.HashMap;

public class LRUCache {
	
	private int capacity;
    private int usedCapacity;
    private HashMap<Integer, DoubleLinkedListNode> map;
    DoubleLinkedListNode head;  // newly touched node add to the head
    DoubleLinkedListNode tail;  // remove from the tail
    
    class DoubleLinkedListNode{
        int key;
        int val;
        DoubleLinkedListNode prev, next;
        public DoubleLinkedListNode (int key, int val) {
            this.val = val;
            this.key = key;
            this.prev = null;
            this.next = null;
        }
    }
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.usedCapacity = 0;
        map = new HashMap<>(); 
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            DoubleLinkedListNode node = map.get(key);
            removeFromCache(node);
            addToCache(node);
            return node.val;
        }
        return -1;
    }
    
    public void set(int key, int value) {
        // set value
        if (map.containsKey(key)) {
            DoubleLinkedListNode node = map.get(key);
            node.val = value;
            removeFromCache(node);
            addToCache(node);
        } else {    // insert
            DoubleLinkedListNode node = new DoubleLinkedListNode(key, value);
            map.put(key, node);
            if (this.usedCapacity < this.capacity) {
                this.usedCapacity ++;
            } else {
                map.remove(this.tail.key);
                removeFromCache(this.tail);
            }
            addToCache(node);
        }
    }
    
    // remove from tail
    private void removeFromCache (DoubleLinkedListNode node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            this.head = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            this.tail = node.prev;
        }
        return;
    }
    
    // add to head
    private void addToCache(DoubleLinkedListNode node) {
        node.next = this.head;
        node.prev = null;   // pay attention!
        if (this.head != null)
            this.head.prev = node;
        this.head = node;
        
        if (this.tail == null)
            this.tail = node;
        return;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRUCache lru = new LRUCache(1);
		lru.set(2, 1);
		System.out.println(lru.get(2));
		lru.set(3, 2);
		System.out.println(lru.get(2));
		System.out.println(lru.get(3));
	}

}
