package com.java.challenges.reversestring;

public class ReverseString {

	public static void main(String[] args) {
		
		String inputString = "ankush";
		System.out.println("\nInput: " + inputString);
		System.out.println("\nOutput: " + reverseString(inputString));
		
		inputString = "abcdefghijklmnopqrstuvwxyz";
		System.out.println("\nInput: " + inputString);
		System.out.println("\nOutput: " + reverseString(inputString));
		
		inputString = "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ";
		System.out.println("\nInput: " + inputString);
		System.out.println("\nOutput: " + reverseString(inputString));
	}
	
	/**
	 * Returns the Reversed String
	 * 
	 * @param inputString
	 * @return String
	 */
	private static String reverseString(String inputString) {
		
		if(inputString == null || inputString.length() <= 1) {
			return inputString;
		}
		
		char[] stringChars = inputString.toCharArray();
		
		for(int start = 0, end = stringChars.length - 1; start < end; start ++, end --) {
			char temp = stringChars[start];
			stringChars[start] = stringChars[end];
			stringChars[end] = temp;
		}
		return new String(stringChars);
	}
}