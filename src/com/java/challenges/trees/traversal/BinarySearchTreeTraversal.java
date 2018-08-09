package com.java.challenges.trees.traversal;

import java.util.Stack;

/**
 * @author Ankush Gupta
 * 
 * Email: no.1ankush@gmail.com 
 * GitHub: https://github.com/no-1ankush
 * LinkedIn: www.linkedin.com/in/no1ankush
 */
public class BinarySearchTreeTraversal {

	public static class Node {
	    int key;
	    Node left, right;
	 
	    public Node(int item) {
	        key = item;
	        left = right = null;
	    }
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		
		root.left.left = new Node(4);
		root.left.right = new Node(5);

		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		root.left.left.left = new Node(8);
		root.left.left.right = new Node(9);

		root.left.right.left = new Node(10);
		root.left.right.right = new Node(11);
		
		root.right.left.left = new Node(12);
		root.right.left.right = new Node(13);

		root.right.right.left = new Node(14);
		root.right.right.right = new Node(15);
		
		System.out.println("Preorder traversal of binary tree with recursion is ");
		printPreorderWithRecursion(root);

		System.out.println("\n\nInorder traversal of binary tree with recursion is ");
		printInorderWithRecursion(root);

		System.out.println("\n\nPostorder traversal of binary tree with recursion is ");
		printPostorderWithRecursion(root);
		
		System.out.println("\n\nPreorder traversal of binary tree iteratively is ");
		printPreorderIteratively(root);

		System.out.println("\n\nInorder traversal of binary tree iteratively is ");
		printInorderIteratively(root);

		System.out.println("\n\nPostorder traversal of binary tree iteratively is ");
		printPostorderIteratively(root);
	}
	
	/**
	 * Prints the Binary Tree with Pre-Order Traversal
	 * @param node
	 */
	public static void printPreorderIteratively(Node node)
    {
        if (node == null)
            return;
 
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        
        /* Iterate over all the nodes */
        while(!stack.isEmpty()) {
        	/* Get the latest node from stack */
            node = stack.peek();
        	
            /* Print data of node */
            System.out.print(node.key + " ");
            
            stack.pop();
            
            /* Push right node in Stack */
            if (node.right != null) {
            	stack.push(node.right);
            }
            
            /* Push left node in Stack */
            if (node.left != null) {
            	stack.push(node.left);
            }
        }
    }
	
	/**
	 * Prints the Binary Tree with In Order Traversal
	 * @param node
	 */
	public static void printInorderIteratively(Node node)
    {
        if (node == null)
            return;
 
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
	 * Prints the Binary Tree with Post Order Traversal
	 * @param node
	 */
	public static void printPostorderIteratively(Node node) {
        if (node == null)
            return;
 
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        
        /* Iterate over all the nodes */
        while(!stack.isEmpty()) {
        	
        	node = stack.peek();
        	
            if(node.left == null 
            		&& node.right == null) {
                /* first print data of node */
                System.out.print(stack.pop().key + " ");
            }
            else {
                if(node.right != null) {
                    stack.push(node.right);
                    node.right = null;
                }
     
                if(node.left != null) {
                    stack.push(node.left);
                    node.left = null;
                }
            }
        }
    }
 
	/**
	 * Prints the Binary Tree with Pre-Order Traversal
	 * @param node
	 */
	public static void printPreorderWithRecursion(Node node) {
        if (node == null)
            return;
 
        /* first print data of node */
        System.out.print(node.key + " ");
 
        /* then recur on left sutree */
        printPreorderWithRecursion(node.left);
 
        /* now recur on right subtree */
        printPreorderWithRecursion(node.right);
    }
	
	/**
	 * Prints the Binary Tree with In Order Traversal
	 * @param node
	 */
	public static void printInorderWithRecursion(Node node) {
        if (node == null)
            return;
 
        /* first recur on left child */
        printInorderWithRecursion(node.left);
 
        /* then print the data of node */
        System.out.print(node.key + " ");
 
        /* now recur on right child */
        printInorderWithRecursion(node.right);
    }
	
	/**
	 * Prints the Binary Tree with Post Order Traversal
	 * @param node
	 */
	public static void printPostorderWithRecursion(Node node) {
        if (node == null)
            return;
 
        // first recur on left subtree
        printPostorderWithRecursion(node.left);
 
        // then recur on right subtree
        printPostorderWithRecursion(node.right);
 
        // now deal with the node
        System.out.print(node.key + " ");
    }
}