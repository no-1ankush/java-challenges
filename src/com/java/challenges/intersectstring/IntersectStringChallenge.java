package com.java.challenges.intersectstring;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ankush Gupta 
 * 
 * Email: no.1ankush@gmail.com
 * GitHub: https://github.com/no-1ankush
 * LinkedIn: www.linkedin.com/in/no1ankush
 */
public class IntersectStringChallenge 
{
	/**
	 * PSVM
	 * @param args
	 */
	public static void main(String[] args) {	
		//Test Case # 1 - All Matching Characters (Non-Repetitive)
		String inputStringOne = "ABCDEF";
		String inputStringTwo = "ABCDEF";
		String outputString = intersetStrings(inputStringOne, inputStringTwo);
		printResults(inputStringOne, inputStringTwo, outputString);
		
		//Test Case # 2 - All Matching Characters (Repetitive)
		inputStringOne = "AAAAAA";
		inputStringTwo = "AAAAAA";
		outputString = intersetStrings(inputStringOne, inputStringTwo);
		printResults(inputStringOne, inputStringTwo, outputString);
		
		//Test Case # 3 - No Matching Characters (Non-Repetitive)
		inputStringOne = "ABCABC";
		inputStringTwo = "DEFDEF";
		outputString = intersetStrings(inputStringOne, inputStringTwo);
		printResults(inputStringOne, inputStringTwo, outputString);
		
		//Test Case # 4 - No Matching Characters (Repetitive)
		inputStringOne = "AAAAAA";
		inputStringTwo = "ZZZZZZ";
		outputString = intersetStrings(inputStringOne, inputStringTwo);
		printResults(inputStringOne, inputStringTwo, outputString);
		
		//Test Case # 5 - Multiple Matching Characters (Repetitive)
		inputStringOne = "AABBCC";
		inputStringTwo = "CCDDEE";
		outputString = intersetStrings(inputStringOne, inputStringTwo);
		printResults(inputStringOne, inputStringTwo, outputString);
		
		//Test Case # 6 - Multiple Matching Characters (Non-Repetitive)
		inputStringOne = "ZYXWVU";
		inputStringTwo = "RSTUVW";
		outputString = intersetStrings(inputStringOne, inputStringTwo);
		printResults(inputStringOne, inputStringTwo, outputString);
	}
	
	/**
	 * Prints the Inputs and Output in Console
	 * 
	 * @param inputStringOne
	 * @param inputStringTwo
	 * @param outputString
	 */
	private static void printResults(String inputStringOne, String inputStringTwo, String outputString) {
		System.out.println("Input String 1:\t\t" + inputStringOne);
		System.out.println("Input String 2:\t\t" + inputStringTwo);
		System.out.println("===================================");
		System.out.println("Intersected String:\t" + outputString);
		System.out.println("\n\n");
	}
	
	/**
	 * Intersect two strings and return only the common characters as String 
	 * 
	 * @param inputStringOne
	 * @param inputStringTwo
	 * @return String
	 */
	private static String intersetStrings (String inputStringOne, String inputStringTwo) {
		//Remove Duplicate Characters
		Set<Character> setOne = getStringAsHashSet(inputStringOne);
		Set<Character> setTwo = getStringAsHashSet(inputStringTwo);

		//Intersects the two sets and retains the values that exists in both sets
		//Refer:
		//https://docs.oracle.com/javase/7/docs/api/java/util/Set.html#retainAll(java.util.Collection)
		setOne.retainAll(setTwo);
		
		//Convert the Set to String
		StringBuilder sb = new StringBuilder();

		for(char inputchar : inputStringOne.toCharArray()) {
			
			if(setOne.contains(inputchar)) {
				//Only if the Set contains the Character
				//append it to the String Builder
				sb.append(inputchar);
				
				//Remove the character from the Set, so that we know
				// - When to break
				// - handle repetitive characters
				setOne.remove(inputchar);
			}
			
			//If Set is empty that means all the characters are appended
			//to the StringBuilder in the order they appear in inputStringOne.
			if(setOne.isEmpty()) {
				break;
			}
				
		}

		return sb.toString(); 
	}
	
	/**
	 * Converts String to a Set of Characters. Removes duplicate characters by default
	 * 
	 * @param inputString
	 * @return Set<Character>
	 */
	private static Set<Character> getStringAsHashSet(String inputString) {
		Set<Character> hashSet = new HashSet<Character>();
		
		//Check for valid inputs
		if(inputString != null && !inputString.isEmpty())
		{
			for(int i = 0; i< inputString.length(); i++)
			{
				hashSet.add(inputString.charAt(i));
			}
		}
		
		return hashSet;
	}
}
