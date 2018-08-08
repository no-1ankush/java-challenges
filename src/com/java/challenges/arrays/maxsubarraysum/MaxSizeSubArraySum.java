package com.java.challenges.arrays.maxsubarraysum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ankush Gupta
 * 
 * Email: no.1ankush@gmail.com 
 * GitHub: https://github.com/no-1ankush
 * LinkedIn: www.linkedin.com/in/no1ankush
 */
public class MaxSizeSubArraySum {

	public static void main(String[] args) {
		
		int[] inputNums = new int[]{1, -1, 5, -2, 3};
		int target = 3;
		System.out.println("\nInput: " + Arrays.toString(inputNums) + "\nTarget: " + target);
		System.out.println("\nOutput: " + maxSubArrayLen(inputNums, target));
		
		inputNums = new int[]{-2, -1, 2, 1};
		target = 1;
		System.out.println("\nInput: " + Arrays.toString(inputNums) + "\nTarget: " + target);
		System.out.println("\nOutput: " + maxSubArrayLen(inputNums, target));
		
		inputNums = new int[]{8, 11, -5, 4};
		target = 3;
		System.out.println("\nInput: " + Arrays.toString(inputNums) + "\nTarget: " + target);
		System.out.println("\nOutput: " + maxSubArrayLen(inputNums, target));
	}
	
	/**
	 * Returns the maximum size sub array who's sum equals the given target.
	 * 
	 * @param inputChars
	 * @return String
	 */
	private static int maxSubArrayLen(int[] inputNums, int target) {
		int maxSubArraySize = 0;
		int sum = 0;
		
		if(inputNums == null || inputNums.length == 0) {
			return maxSubArraySize; 
		}
		
		Map<Integer, Integer> hashMap = new HashMap<>();
		
		for(int i = 0; i < inputNums.length; i ++) {
			sum += inputNums[i];
			if(sum == target) {
				maxSubArraySize = i + 1;
			}
			
			if(hashMap.containsKey(sum - target)) {
				maxSubArraySize = Math.max(maxSubArraySize, i - hashMap.get(sum - target));
			}
			
			if(!hashMap.containsKey(sum)) {
				hashMap.put(sum, i);
			}
		}
		
		return maxSubArraySize;
	}
}