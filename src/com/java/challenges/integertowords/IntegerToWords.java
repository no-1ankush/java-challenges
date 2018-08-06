package com.java.challenges.integertowords;

/**
 * @author Ankush Gupta
 * 
 * Email: no.1ankush@gmail.com 
 * GitHub: https://github.com/no-1ankush
 * LinkedIn: www.linkedin.com/in/no1ankush
 */
public class IntegerToWords {
	
	private static final String[] BELOW_TEN = new String[] { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
			"Nine" };
	
	private static final String[] BELOW_TWENTY = new String[] { "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
			"Sixteen", "Seventeen", "Eighteen", "Nineteen" };
	
	private static final String[] BELOW_HUNDRED = new String[] { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty",
			"Seventy", "Eighty", "Ninety" };

	public static void main(String[] args) {
		int inputInt = 20;
		System.out.println("\nInput: " + inputInt);
		System.out.println("\nOutput: " + integerToWords(inputInt));

		inputInt = 12345;
		System.out.println("\nInput: " + inputInt);
		System.out.println("\nOutput: " + integerToWords(inputInt));
		
		inputInt = 1234567891;
		System.out.println("\nInput: " + inputInt);
		System.out.println("\nOutput: " + integerToWords(inputInt));
	}

	/**
	 * Converts the integer to Words
	 * 
	 * @param inputInt
	 * @return String
	 */
	public static String numberToWords(int inputInt) {
		if(inputInt == 0) {
			return "Zero";
		}
		return integerToWords(inputInt); 
	}
	
	/**
	 * Converts non-zero integer to words
	 * @param inputInt
	 * @return String
	 */
	private static String integerToWords(int inputInt) {
		String result = new String();
		
		if(inputInt < 10) {
			result = BELOW_TEN[inputInt];
		}
		else if(inputInt < 20) {
			result = BELOW_TWENTY[inputInt - 10];
		}
		else if(inputInt < 100) {
			result = BELOW_HUNDRED[inputInt / 10] + " " + integerToWords(inputInt % 10);
		}
		else if(inputInt < 1000) {
			result = integerToWords(inputInt / 100) + " Hundred " + integerToWords(inputInt % 100);
		}
		else if(inputInt < 1000000) {
			result = integerToWords(inputInt / 1000) + " Thousand " + integerToWords(inputInt % 1000);
		}
		else if(inputInt < 1000000000) {
			result = integerToWords(inputInt / 1000000) + " Million " + integerToWords(inputInt % 1000000);
		}
		else {
			result = integerToWords(inputInt / 1000000000) + " Billion " + integerToWords(inputInt % 1000000000);
		}
		
		return result.trim();
	}
}