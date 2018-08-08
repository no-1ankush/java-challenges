package com.java.challenges.linkedlist.mergesortedlist;

import java.util.PriorityQueue;

/**
 * @author Ankush Gupta
 * 
 * Email: no.1ankush@gmail.com 
 * GitHub: https://github.com/no-1ankush
 * LinkedIn: www.linkedin.com/in/no1ankush
 */
public class MergeSortedLists {

	public static class ListNode {
		int val;
		ListNode next;
		
		ListNode(int x) { 
			val = x; 
		}
	}
	
	public static void main(String[] args) {
		ListNode l11 = new ListNode(1);
		ListNode l12 = new ListNode(4);
		l11.next = l12;
		ListNode l13 = new ListNode(5);
		l12.next = l13;
		
		ListNode l21 = new ListNode(1);
		ListNode l22 = new ListNode(3);
		l21.next = l22;
		ListNode l23 = new ListNode(4);
		l22.next = l23;
		
		ListNode l31 = new ListNode(2);
		ListNode l32 = new ListNode(6);
		l31.next = l32;
		
		System.out.println("Input List Node 1: " + printAllListNode(l11));
		System.out.println("Input List Node 2: " + printAllListNode(l21));
		System.out.println("Input List Node 3: " + printAllListNode(l31));
		
		System.out.println("\nOutput List Node: " + printAllListNode(mergeLists(new ListNode[] { l11, l21, l31})));
	}
	
	/**
	 * Converts the List Node into a String
	 * 
	 * @param inputNode
	 * @return String
	 */
	private static String printAllListNode(ListNode inputNode) {
		StringBuilder sb = new StringBuilder();
		while(inputNode != null) {
			sb.append(inputNode.val + ",");
			inputNode = inputNode.next;
		}
		return sb.toString();
	}
	
	/**
	 * Returns Head ListNode with the merged input lists
	 * 
	 * @param lists
	 * @return ListNode
	 */
	private static ListNode mergeLists(ListNode[] lists) {
		// initial check
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        // add first node of each list to the minHeap
        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>((n1, n2) -> n1.val - n2.val);
        
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.add(node);
            }
        }
        
        // if no node was added to the minHeap we return null
        if (minHeap.isEmpty()) {
            return null;
        }
        
        // save head since we need to return it
        ListNode resultNodeHead = minHeap.peek();
    
        while(!minHeap.isEmpty()) {
            // extract node from minHeap
            ListNode node = minHeap.poll();
            if (node.next != null) {
              // add next node to minHeap
              minHeap.add(node.next);
            }
            // set node.next
            if (minHeap.peek() != null) {
                node.next = minHeap.peek();
            }
        }
		return resultNodeHead;
	}
}