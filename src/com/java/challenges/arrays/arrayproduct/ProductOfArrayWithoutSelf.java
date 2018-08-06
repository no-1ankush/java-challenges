package com.java.challenges.arrays.arrayproduct;

import java.util.Arrays;

/**
 * @author Ankush Gupta
 * 
 * Email: no.1ankush@gmail.com 
 * GitHub: https://github.com/no-1ankush
 * LinkedIn: www.linkedin.com/in/no1ankush
 */
public class ProductOfArrayWithoutSelf {

	public static void main(String[] args) {
		int[] inputArray = new int [] {1, 2, 3, 4};
		System.out.println("\nInput: " + Arrays.toString(inputArray));
		System.out.println("\nOutput: " + Arrays.toString(productOfArray(inputArray)));

		inputArray = new int [] {9, 8, 7, 6, 5, 4, 3, 2, 1};
		System.out.println("\nInput: " + Arrays.toString(inputArray));
		System.out.println("\nOutput: " + Arrays.toString(productOfArray(inputArray)));
		
		inputArray = new int [] {5, 6, 7};
		System.out.println("\nInput: " + Arrays.toString(inputArray));
		System.out.println("\nOutput: " + Arrays.toString(productOfArray(inputArray)));
	}

	/**
	 * Returns the product of thr array except the self
	 * 
	 * @param inputArray
	 * @return int[]
	 */
	public static int[] productOfArray(int[] inputArray) {
		if(inputArray == null || inputArray.length < 1) {
			return inputArray;
		}
		
		int [] productArray = new int [inputArray.length];
		productArray[0] = 1;
		
		for(int i = 1; i < inputArray.length; i++) {
			productArray[i] = productArray[i - 1] * inputArray[i - 1];
		}
		
		int rightIndexValue = 1;
		for(int i = inputArray.length-1; i >= 0; i--) {
			productArray[i] *= rightIndexValue;
			rightIndexValue *= inputArray[i];
		}
		
		return productArray;
	}
	
}