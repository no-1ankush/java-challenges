package com.java.challenges.trees.roottoleafsum;

/**
 * @author Ankush Gupta
 * 
 * Email: no.1ankush@gmail.com 
 * GitHub: https://github.com/no-1ankush
 * LinkedIn: www.linkedin.com/in/no1ankush
 */
public class BinaryTreeSumOfRootToLeafNumbers {

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
		root.left = new TreeNode(9);
		root.right = new TreeNode(0);
		
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(1);

		System.out.print("Input Binary Tree: ");
		printBinaryTree(root);
		
		System.out.println("\nSum : " + getSumofRootToLeaf(root, 0));
	}
	
	/**
	 * Compares the values and returns the value in the BST closest to the target
	 * 
	 * @param node
	 * @param target
	 * @return int
	 */
	public static int getSumofRootToLeaf(TreeNode node, int sum) {
        
		if(node == null) 
			return 0;
		
		sum = sum*10 + node.val;

		if(node.left == null && node.right == null)
			return sum;
		
        return getSumofRootToLeaf(node.left, sum) + getSumofRootToLeaf(node.right, sum);
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