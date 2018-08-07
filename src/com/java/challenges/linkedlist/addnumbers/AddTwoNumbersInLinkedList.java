package com.java.challenges.linkedlist.addnumbers;

public class AddTwoNumbersInLinkedList {

	public static class ListNode {
		int val;
		ListNode next;
		
		ListNode(int x) { 
			val = x; 
		}
	}
	
	public static void main(String[] args) {
		ListNode l11 = new ListNode(2);
		ListNode l12 = new ListNode(4);
		l11.next = l12;
		ListNode l13 = new ListNode(3);
		l12.next = l13;
		
		ListNode l21 = new ListNode(5);
		ListNode l22 = new ListNode(4);
		l21.next = l22;
		ListNode l23 = new ListNode(3);
		l22.next = l23;
		
		System.out.println("Input List Node 1: " + printListNode(l11));
		System.out.println("Input List Node 2: " + printListNode(l21));
		System.out.println("\nOutput List Node: " + printListNode(addTwoNumbers(l11, l21)));
		
		ListNode l14 = new ListNode(2);
		ListNode l15 = new ListNode(4);
		l14.next = l15;
		ListNode l16 = new ListNode(3);
		l15.next = l16;
		
		ListNode l24 = new ListNode(5);
		ListNode l25 = new ListNode(6);
		l24.next = l25;
		ListNode l26 = new ListNode(4);
		l25.next = l26;
		
		System.out.println("\n\nInput List Node 1: " + printListNode(l14));
		System.out.println("Input List Node 2: " + printListNode(l24));
		System.out.println("\nOutput List Node: " + printListNode(addTwoNumbers(l14, l24)));
	}
	
	/**
	 * Converts the List Node into a String
	 * 
	 * @param inputNode
	 * @return String
	 */
	private static String printListNode(ListNode inputNode) {
		StringBuilder sb = new StringBuilder();
		while(inputNode != null) {
			sb.append(inputNode.val + ",");
			inputNode = inputNode.next;
		}
		return sb.toString();
	}
	
	/**
	 * Returns Head ListNode for the sum of two input LinkedList
	 * 
	 * @param l1
	 * @param l2
	 * @return ListNode
	 */
	private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode resultHeadNode = null;
		ListNode previousNode = null;
		
		int sum = 0;
		int carry = 0;
		
		while(l1 != null || l2 != null || carry != 0) {
			
			ListNode currentNode = new ListNode(0);
			
			int v1 = l1 != null ? l1.val : 0;
			int v2 = l2 != null ? l2.val : 0;
			
			//Sum of values of two nodes
			sum = v1 + v2 + carry;
			
			//Carry over of two nodes
			carry = sum / 10;
			
			//Value of the Current Node
			currentNode.val = sum % 10;
			
			if(resultHeadNode == null) {
				resultHeadNode = currentNode;
				previousNode = resultHeadNode;
			}
			else {
				previousNode.next = currentNode;
				previousNode = currentNode;
			}
			
			l1 = l1 != null ? l1.next: null;
			l2 = l2 != null ? l2.next: null;
		}
		
		return resultHeadNode;
	}
}