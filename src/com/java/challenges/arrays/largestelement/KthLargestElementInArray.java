package com.java.challenges.arrays.largestelement;

import java.util.Arrays;

/**
 * @author Ankush Gupta
 * 
 * Email: no.1ankush@gmail.com 
 * GitHub: https://github.com/no-1ankush
 * LinkedIn: www.linkedin.com/in/no1ankush
 */
public class KthLargestElementInArray {

	public static void main(String[] args) {
		
		int[] inputNums = new int[]{3,2,1,5,6,4};
		int target = 2;
		System.out.println("\nInput: " + Arrays.toString(inputNums) + "\nTarget: " + target);
		System.out.println("\nOutput: " + findKthLargest(inputNums, target));
		
		inputNums = new int[]{3,2,3,1,2,4,5,5,6};
		target = 4;
		System.out.println("\nInput: " + Arrays.toString(inputNums) + "\nTarget: " + target);
		System.out.println("\nOutput: " + findKthLargest(inputNums, target));
		
		inputNums = new int[]{3,1,2,4};
		target = 2;
		System.out.println("\nInput: " + Arrays.toString(inputNums) + "\nTarget: " + target);
		System.out.println("\nOutput: " + findKthLargest(inputNums, target));
	}
	
	/**
	 * Returns Kth Largest Element in the array
	 * 
	 * @param inputChars
	 * @return String
	 */
	private static int findKthLargest(int[] inputNums, int target) {
		if(inputNums == null 
				|| inputNums.length == 0
				|| target > inputNums.length) {
			return -1;
		}
		
		return findKthLargest(inputNums, 0, inputNums.length - 1, inputNums.length - target);
	}
	
	/**
	 * Returns Kth Largest Element in the array
	 * 
	 * @param inputNums
	 * @param start
	 * @param end
	 * @param targetLength
	 * @return
	 */
	private static int findKthLargest(int[] inputNums, int start, int end, int targetLength) {
		if(start > end) {
			return -1;
		}
		
		int pivot = inputNums[end];
		int leftIndex = start;
		
		for(int i = start; i < end; i++) {
			if(inputNums[i] < pivot) {
				swap(inputNums, leftIndex++, i);
			}
		}
		
		swap(inputNums, leftIndex, end);
		
		if (leftIndex == targetLength)
			// Found kth smallest number
			return inputNums[leftIndex];
		else if (leftIndex < targetLength)
			// Check right part
			return findKthLargest(inputNums, leftIndex + 1, end, targetLength);
		else
			// Check left part
			return findKthLargest(inputNums, start, leftIndex - 1, targetLength);
	}
	
	/**
	 * Swaps the two numbers in an array.
	 * 
	 * @param inputNums
	 * @param i
	 * @param j
	 */
	private static void swap(int[] inputNums, int i, int j) {
		int tmp = inputNums[i];
		inputNums[i] = inputNums[j];
		inputNums[j] = tmp;				
	}
}