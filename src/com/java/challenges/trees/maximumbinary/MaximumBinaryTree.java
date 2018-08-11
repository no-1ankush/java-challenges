package com.java.challenges.trees.maximumbinary;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Ankush Gupta
 * 
 * Email: no.1ankush@gmail.com 
 * GitHub: https://github.com/no-1ankush
 * LinkedIn: www.linkedin.com/in/no1ankush
 */
public class MaximumBinaryTree {

	public static class TreeNode {
	    int val;
	    TreeNode left, right;
	 
	    public TreeNode(int val) {
	    	this.val = val;
	        left = right = null;
	    }
	}
	
	public static void main(String[] args) {
		int[] inputNums = new int[] {3,2,1,6,0,5};

		System.out.println("Input Array: " + Arrays.toString(inputNums));
		
		System.out.print("\nOutput Binary Tree: ");
		printBinaryTree(getMaximumBinaryTree(inputNums));
	}
	
	/**
	 * Builds the Maximum Binary Tree from the given array of ints
	 * 
	 * @param inputNums
	 * @return TreeNode
	 */
	public static TreeNode getMaximumBinaryTree(int[] inputNums) {
		if(inputNums == null) 
			return null;
		
		Stack<TreeNode> stack = new Stack<>();
		
		for (int num : inputNums) {
			TreeNode node = new TreeNode(num);
			
			while(!stack.isEmpty() && stack.peek().val < num) {
				node.left = stack.pop();
			}
			
			if(!stack.isEmpty()) {
				stack.peek().right = node;
			}
			
			stack.push(node);
		}
		
        return stack.isEmpty() ? null : stack.firstElement();
    }
	
	/**
	 * Prints the Binary Tree with In Order Traversal
	 * @param node
	 */
	public static void printBinaryTree(TreeNode node) {
        if (node == null)
            return;
 
        // first recur on left subtree
        printBinaryTree(node.left);
 
        // now deal with the node
        System.out.print(node.val + " ");
        
        // then recur on right subtree
        printBinaryTree(node.right);
    }
}