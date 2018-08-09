package com.java.challenges.trees.closestvalue;

/**
 * @author Ankush Gupta
 * 
 * Email: no.1ankush@gmail.com 
 * GitHub: https://github.com/no-1ankush
 * LinkedIn: www.linkedin.com/in/no1ankush
 */
public class ClosestBinarySearchTreeValue {

	public static class TreeNode {
	    int val;
	    TreeNode left, right;
	 
	    public TreeNode(int val) {
	    	this.val = val;
	        left = right = null;
	    }
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(6);
		
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);

		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(7);
		
		double target = 3.714286;
		
		System.out.print("Input Binary Tree: ");
		printBinaryTree(root);
		
		System.out.println("\n\nTarget: " + target);
		
		System.out.println("\nCloset Value : " + getClosestValue(root, target));
	}
	
	/**
	 * Compares the values and returns the value in the BST closest to the target
	 * 
	 * @param node
	 * @param target
	 * @return int
	 */
	public static int getClosestValue(TreeNode node, double target) {
        
		if(node == null) return 0;
		
		int closestValue = node.val;
        double bestDiff = Math.abs(target - node.val);
        
		while(node != null) {
			double diff = Math.abs(target - node.val);
            if (diff < bestDiff) {
                bestDiff = diff;
                closestValue = node.val;
            }
			
			//Select the next node for traversal
			node = node.val > target ? node.left : node.right;
		}
 
        return closestValue;
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