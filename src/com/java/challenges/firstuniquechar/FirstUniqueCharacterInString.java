package com.java.challenges.firstuniquechar;

public class FirstUniqueCharacterInString {

	public static void main(String[] args) {
		
		String inputString = "ankush";
		System.out.println("\nInput: " + inputString);
		System.out.println("\nOutput: " + firstUniqChar(inputString));
		
		inputString = "abcabc";
		System.out.println("\nInput: " + inputString);
		System.out.println("\nOutput: " + firstUniqChar(inputString));
		
		inputString = "ababc";
		System.out.println("\nInput: " + inputString);
		System.out.println("\nOutput: " + firstUniqChar(inputString));
	}
	
	/**
	 * Returns the index of the First Unique Character in a given String
	 * 
	 * @param inputString
	 * @return int
	 */
	private static int firstUniqChar(String inputString) {
		int firstUniqCharIndex = -1;
		
		if(inputString == null) {
			return firstUniqCharIndex;
		}
		
		for(char alphabet = 'a'; alphabet <= 'z'; alphabet++ ) {
			int firstIndex = inputString.indexOf(alphabet);
			
			if(firstIndex >= 0 
					&& inputString.lastIndexOf(alphabet) == firstIndex) {
				if(firstUniqCharIndex == -1 
						|| firstUniqCharIndex > firstIndex) {
					firstUniqCharIndex = firstIndex;
				}
			}
		}
		return firstUniqCharIndex;
	}
}