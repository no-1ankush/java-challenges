package com.java.challenges.string.reversewords;

public class ReverseWordsInString {

	public static void main(String[] args) {
		
		char[] inputChars = "My Name is Ankush Gupta".toCharArray();
		System.out.println("\nInput: " + new String(inputChars));
		reverseWords(inputChars);
		System.out.println("\nOutput: " + new String(inputChars));
		
		inputChars = "The Sky is Blue".toCharArray();
		System.out.println("\nInput: " + new String(inputChars));
		reverseWords(inputChars);
		System.out.println("\nOutput: " + new String(inputChars));
		
		inputChars = "Hello".toCharArray();
		System.out.println("\nInput: " + new String(inputChars));
		reverseWords(inputChars);
		System.out.println("\nOutput: " + new String(inputChars));
	}
	
	/**
	 * Returns the Reversed String
	 * 
	 * @param inputChars
	 * @return String
	 */
	private static void reverseWords(char[] inputChars) {
		
		//Handle Null, Single Character and Single Word Scenarios
		if(inputChars == null || inputChars.length <= 1 
				|| new String(inputChars).indexOf(' ') == -1) {
			return;
		}
		
		//Reverse the Entire String
		reverseString(inputChars, 0, inputChars.length - 1);
		
		//Reverse each Word in String
		int start = 0;
		for(int end = 0; end < inputChars.length; end ++) {
			if(inputChars[end] == ' ') {
				reverseString(inputChars, start, end - 1); //end - 1 to remove the space
				start = end + 1; // end + 1 as the word starts after space
			}
			
			if(end == inputChars.length - 1) {
				reverseString(inputChars, start, end);
			}
		}
	}
	
	/**
	 * Reverses the String from a given start and end index
	 * @param inputChars
	 * @param start
	 * @param end
	 */
	private static void reverseString(char[] inputChars, int start, int end) {
		
		if(inputChars == null || inputChars.length <= 1) {
			return;
		}
		
		for(; start < end; start ++, end --) {
			char temp = inputChars[start];
			inputChars[start] = inputChars[end];
			inputChars[end] = temp;
		}
	}
}