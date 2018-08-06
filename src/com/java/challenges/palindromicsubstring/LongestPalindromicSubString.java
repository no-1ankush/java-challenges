package com.java.challenges.palindromicsubstring;

/**
 * @author Ankush Gupta
 * 
 * Email: no.1ankush@gmail.com 
 * GitHub: https://github.com/no-1ankush
 * LinkedIn: www.linkedin.com/in/no1ankush
 */
public class LongestPalindromicSubString {

	public static void main(String[] args) {
		String inputString = "babad";
		System.out.println("\nInput: " + inputString);
		System.out.println("\nOutput: " + longestPalindrome(inputString));

		inputString = "cbbd";
		System.out.println("\nInput: " + inputString);
		System.out.println("\nOutput: " + longestPalindrome(inputString));
		
		inputString = "xytattarrattatyz";
		System.out.println("\nInput: " + inputString);
		System.out.println("\nOutput: " + longestPalindrome(inputString));
	}

	/**
	 * Returns the longest Palindromic Sub string in a given String
	 * 
	 * @param inputString
	 * @return String
	 */
	public static String longestPalindrome(String inputString) {
		String longestPalindrome = "";
		int maxPalindromeLength = 0;
		
		if(inputString == null || inputString.length() < 2) {
			return inputString;
		}
		
		for(int i=0; i < inputString.length(); i++) {
			if(isPalindrome(inputString, i-maxPalindromeLength, i)) {
				longestPalindrome = inputString.substring(i-maxPalindromeLength, i + 1);
				maxPalindromeLength += 1; 
			}
			else if(isPalindrome(inputString, i-maxPalindromeLength-1, i)) {
				longestPalindrome = inputString.substring(i-maxPalindromeLength-1, i + 1);
				maxPalindromeLength += 2;
			}
		}
		
		return longestPalindrome;
	}
	
	/**
	 * Checks if the given string is a Palindrome from the given Start Index and End Index
	 * 
	 * @param inputString
	 * @param startIndex
	 * @param endIndex
	 * @return boolean
	 */
	private static boolean isPalindrome(String inputString, int startIndex, int endIndex) {
		if(startIndex < 0) {
			return false;
		}
		
		while(startIndex < endIndex) {
			if(inputString.charAt(startIndex) != inputString.charAt(endIndex)) {
				return false;
			}
			startIndex++;
			endIndex--;
		}
		
		return true;
	}
}