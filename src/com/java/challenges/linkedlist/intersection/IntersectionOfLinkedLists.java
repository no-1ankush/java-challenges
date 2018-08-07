package com.java.challenges.linkedlist.intersection;

public class IntersectionOfLinkedLists {

	public static class ListNode {
		int val;
		ListNode next;
		
		ListNode(int x) { 
			val = x; 
		}
	}
	
	public static void main(String[] args) {
		ListNode l11 = new ListNode(1);
		ListNode l12 = new ListNode(2);
		l11.next = l12;
		ListNode l13 = new ListNode(3);
		l12.next = l13;
		ListNode l14 = new ListNode(4);
		l13.next = l14;
		
		ListNode l21 = new ListNode(5);
		l21.next = l13;
		
		System.out.println("Input List Node 1: " + printAllListNode(l11));
		System.out.println("Input List Node 2: " + printAllListNode(l21));
		System.out.println("\nOutput List Node: " + printListNode(getIntersectionNode(l11, l21)));
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
	 * Converts the List Node into a String
	 * 
	 * @param inputNode
	 * @return String
	 */
	private static String printListNode(ListNode inputNode) {
		while(inputNode != null) {
			return Integer.toString(inputNode.val);
		}
		return null;
	}
	
	/**
	 * Returns Head ListNode for the sum of two input LinkedList
	 * 
	 * @param headA
	 * @param headB
	 * @return ListNode
	 */
	private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA == null || headB == null) {
			return null;
		}
		
		ListNode a = headA;
		ListNode b = headB;
			
		while( a!= b) {
			a = a != null ? a.next: headB;
			b = b != null ? b.next: headA;
		}
			
		return a;
	}
}