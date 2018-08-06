package com.java.challenges.arrays.duplicatenumber;

import java.util.Arrays;

public class DuplicateNumberInArray {

	public static void main(String[] args) {
		
		int[] inputInts = new int[]{1,3,4,2,2};
		System.out.println("\nInput: " + Arrays.toString(inputInts));
		System.out.println("\nOutput: " + duplciateNumber(inputInts));
		
		inputInts = new int[] {3,2,5,14,5,5,19,18,11,10,1,4,5,5,5,5,12,5,17,5};
		System.out.println("\nInput: " + Arrays.toString(inputInts));
		System.out.println("\nOutput: " + duplciateNumber(inputInts));
		
		inputInts = new int[] {3,2,5,14,5,5,19,18,11,10,1,4,5,5,5,5,12,5,17,5};
		System.out.println("\nInput: " + Arrays.toString(inputInts));
		System.out.println("\nOutput: " + duplciateNumber(inputInts));	}
	
	/**
	 * Returns the index of the First Unique Character in a given String
	 * 
	 * @param inputInts
	 * @return int
	 */
	private static int duplciateNumber(int[] inputInts) {
		int firstDuplicateInt = -1;
		
        if (inputInts == null || inputInts.length < 2) {
        	return firstDuplicateInt;
        }
        
        int slow = inputInts[0];
        int fast = inputInts[0];
        
        while (true) {
            slow = inputInts[slow];
            fast = inputInts[inputInts[fast]];
            
            if (slow == fast) {
                fast = inputInts[0];
                while (slow != fast) {
                    slow = inputInts[slow];
                    fast = inputInts[fast];
                }
                firstDuplicateInt = slow;
                break;
            }
        }
		return firstDuplicateInt;
	}
}