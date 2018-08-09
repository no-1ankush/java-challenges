package com.java.challenges.trees.validbinary;

import java.util.Stack;

/**
 * @author Ankush Gupta
 * 
 * Email: no.1ankush@gmail.com 
 * GitHub: https://github.com/no-1ankush
 * LinkedIn: www.linkedin.com/in/no1ankush
 */
public class ValidBinarySearchTree {

	public static class Node {
	    int key;
	    Node left, right;
	 
	    public Node(int item) {
	        key = item;
	        left = right = null;
	    }
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Node root = new Node(4);
		root.left = new Node(2);
		root.right = new Node(6);
		
		root.left.left = new Node(1);
		root.left.right = new Node(3);

		root.right.left = new Node(5);
		root.right.right = new Node(7);
		
		System.out.println("\nInput Binary Tree: ");
		printInorderIteratively(root);
		
		System.out.println("\n\nIs Valid Binary Tree: " + isValidBinarySearchTree(root));
	}
	
	/**
	 * Prints the Binary Tree with In Order Traversal
	 * @param node
	 */
	public static void printInorderIteratively(Node node) {
        Stack<Node> stack = new Stack<>();
		
        /* Iterate over all the nodes */
        while(node != null || !stack.empty()) {
        	while(node != null) {
        		/* Store the node in Stack */
        		stack.push(node);
        		/* Navigate to the left tree */
        		node = node.left;
            }
            
            /* Get the latest node from stack */
            node = stack.pop();
            /* Print data of node */
            System.out.print(node.key + " ");
            /* Navigate to the right tree */
            node = node.right;
        }
    }
	
	/**
	 * Checks if Binary Search Tree is valid
	 * 
	 * @param node
	 * @return boolean
	 */
	public static boolean isValidBinarySearchTree(Node node) {
        Stack<Node> stack = new Stack<>();
        Node previousNode = null;
        
        while(node != null || !stack.empty()) {
        	while(node != null) {
        		stack.push(node);
        		node = node.left;
            }
            
            node = stack.pop();

            if(previousNode != null 
            		&& node.key <= previousNode.key) {
            	return false;
            }
            
            previousNode = node;
            node = node.right;
        }
        
        return true;
	}
}