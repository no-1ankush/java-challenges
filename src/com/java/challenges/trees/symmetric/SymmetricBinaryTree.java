package com.java.challenges.trees.symmetric;

import java.util.Stack;

/**
 * @author Ankush Gupta
 * 
 * Email: no.1ankush@gmail.com 
 * GitHub: https://github.com/no-1ankush
 * LinkedIn: www.linkedin.com/in/no1ankush
 */
public class SymmetricBinaryTree {

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
		root.right = new Node(2);
		
		root.left.left = new Node(3);
		root.left.right = new Node(4);

		root.right.left = new Node(4);
		root.right.right = new Node(3);
		
		System.out.println("Input Binary Tree: ");
		printBinaryTree(root);
		
		System.out.println("\n\nIs Symmetric Tree With Recursion: " + isSymmetricTreeWithRecursion(root));

		System.out.println("\n\nIs Symmetric Tree Iteratively: " + isSymmetricTreeIteratively(root));
	}
	
	/**
	 * Compares values and checks if the given binary Tree is Symmetric or not
	 * @param boolean
	 */
	public static boolean isSymmetricTreeIteratively(Node node)
    {
        if (node == null)
            return true;
 
        Stack<Node> stack = new Stack<>();
		stack.push(node.left);
		stack.push(node.right);
		
        while(!stack.empty()) {
        	Node leftNode = stack.pop();
        	Node rightNode = stack.pop();

    		if(leftNode == null && rightNode == null)
    	        continue;
    	    
    		if(leftNode == null || rightNode == null || leftNode.key != rightNode.key)
    	        return false;
    		
    		stack.push(leftNode.left);
    		stack.push(rightNode.right);
    		
    		stack.push(leftNode.right);
    		stack.push(rightNode.left);
        }
        
        return true;
    }
	
	/**
	 * Compares values and checks if the given binary Tree is Symmetric or not
	 * @param boolean
	 */
	public static boolean isSymmetricTreeWithRecursion(Node node) {
        if (node == null)
            return true;
 
        return isSymmetricTreeWithRecursion(node.left, node.right);
    }
	
	/**
	 * Compares values and checks if the given binary Tree is Symmetric or not
	 * 
	 * @param leftNode
	 * @param rightNode
	 * @return boolean
	 */
	private static boolean isSymmetricTreeWithRecursion(Node leftNode, Node rightNode) {
		
		if(leftNode == null || rightNode == null)
	        return leftNode == rightNode;
	    
		if(leftNode.key != rightNode.key)
	        return false;
		
	    return isSymmetricTreeWithRecursion(leftNode.left, rightNode.right) 
	    		&& isSymmetricTreeWithRecursion(leftNode.right, rightNode.left);
	}
	
	/**
	 * Prints the Binary Tree with In Order Traversal
	 * @param node
	 */
	public static void printBinaryTree(Node node) {
        if (node == null)
            return;
 
        // first recur on left subtree
        printBinaryTree(node.left);
 
        // now deal with the node
        System.out.print(node.key + " ");
        
        // then recur on right subtree
        printBinaryTree(node.right);
    }
}