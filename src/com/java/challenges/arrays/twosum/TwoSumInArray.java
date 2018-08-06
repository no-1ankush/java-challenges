package com.java.challenges.arrays.twosum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumInArray {

	public static void main(String[] args) {
		
		int[] inputNums = new int[]{2, 7, 11, 15};
		int target = 9;
		System.out.println("\nInput: " + Arrays.toString(inputNums) + "\nTarget: " + target);
		System.out.println("\nOutput: " + Arrays.toString(twoSum(inputNums, target)));
		
		inputNums = new int[]{2, 3, 1, 5};
		target = 3;
		System.out.println("\nInput: " + Arrays.toString(inputNums) + "\nTarget: " + target);
		System.out.println("\nOutput: " + Arrays.toString(twoSum(inputNums, target)));
		
		inputNums = new int[]{8, 11, -5, 4};
		target = 6;
		System.out.println("\nInput: " + Arrays.toString(inputNums) + "\nTarget: " + target);
		System.out.println("\nOutput: " + Arrays.toString(twoSum(inputNums, target)));
	}
	
	/**
	 * Returns two indexes who's value sums to the given target
	 * 
	 * @param inputChars
	 * @return String
	 */
	private static int[] twoSum(int[] inputNums, int target) {
		int[] result = new int[2];
		Map<Integer, Integer> hashMap = new HashMap<>();
		
		for(int i = 0; i < inputNums.length; i ++) {
			if(hashMap.containsKey(target - inputNums[i])) {
				result[1] = i;
				result[0] = hashMap.get(target - inputNums[i]);
				break;
			}
			hashMap.put(inputNums[i], i);
		}
		
		return result;
	}
}