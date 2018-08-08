package com.java.challenges.arrays.maximalsquare;

import java.util.Arrays;

/**
 * @author Ankush Gupta
 * 
 * Email: no.1ankush@gmail.com 
 * GitHub: https://github.com/no-1ankush
 * LinkedIn: www.linkedin.com/in/no1ankush
 */
public class MaximalSquare {

	public static void main(String[] args) {
		
		String [] inputArray = new String[] {"0111", "1111", "1111", "1111"};
		System.out.println("\nInput: " + getInputArrayAsString(inputArray));
		System.out.println("Output: " + getMaximalSquare(inputArray));
		
		inputArray = new String[] {"0111", "1101", "0111"};
		System.out.println("\nInput: " + getInputArrayAsString(inputArray));
		System.out.println("Output: " + getMaximalSquare(inputArray));
		
		inputArray = new String[] {"110000", "001100", "000011"};
		System.out.println("\nInput: " + getInputArrayAsString(inputArray));
		System.out.println("Output: " + getMaximalSquare(inputArray));
		
		inputArray = new String[] {"000000", "000000", "000000"};
		System.out.println("\nInput: " + getInputArrayAsString(inputArray));
		System.out.println("Output: " + getMaximalSquare(inputArray));
		
		inputArray = new String[] {"1111", "1111", "1111", "1111"};
		System.out.println("\nInput: " + getInputArrayAsString(inputArray));
		System.out.println("Output: " + getMaximalSquare(inputArray));
	}

	/**
	 * Converts the Array as String for Printing
	 * 
	 * @param inputArray
	 * @return String
	 */
	private static String getInputArrayAsString(String[] inputArray) {
		return Arrays.asList(inputArray).toString().replace("[", "").replace("]", "");
	}
	
	/**
	 * Returns the MaximalSquare in the inputArray
	 * 
	 * @param inputArray
	 * @return String
	 */
	private static String getMaximalSquare(String[] inputArray) {
		//Validate of input is available. 
		//if not Return 0 as no maximal square is available
		if(inputArray == null || inputArray.length == 0) {
			return "0";
		}
		
		//Convert StringArray to 2D int Matrix
		int [][] matrix = getStringArrayAsIntMatrix(inputArray);
		
		//Get the number of repeated Ones in each row
		int [] rowsRepeatedOnes = getRowMaxRepeatedOnes(matrix);
		
		//Get the number of repeated Ones in each column
		int [] columnRepeatedOnes = getColumnMaxRepeatedOnes(matrix);
		
		//Get the Highest Maximal Square possible
		int highestPossibleSquare = getHighestPossibleSquare(matrix);
	
		//Iterate in desc order to check for the highest possible square available
		int maximalSquareArea = 0;
		for(int i = highestPossibleSquare; i > 0; i--) {
			if(isSquare(rowsRepeatedOnes, columnRepeatedOnes, i)) {
				//
				maximalSquareArea = i * i;
				break;
			}
		}
		
		return String.valueOf(maximalSquareArea);
	}
	
	/**
	 * Checks if the square area for the given matrix is possible
	 * 
	 * @param repeatedOnes
	 * @param square
	 * @return boolean
	 */
	private static boolean isSquare(int[] rowRepeatedOnes, int[] columnRepeatedOnes, int square) {
		int repeatedRows = 0;
		for(int i=0; i < rowRepeatedOnes.length; i++) {
			if(rowRepeatedOnes[i] >= square) {
				repeatedRows++;
			}
			if(repeatedRows == square) {
				break;
			}
			if(rowRepeatedOnes[i] < square) {
				repeatedRows = 0;
			}
		}
		int repeatedColumns = 0;
		if(repeatedRows >= square) {
			for(int i=0; i < columnRepeatedOnes.length; i++) {
				if(columnRepeatedOnes[i] >= square) {
					repeatedColumns++;
				}
				if(repeatedColumns == square) {
					break;
				}
				if(columnRepeatedOnes[i] < square) {
					repeatedColumns = 0;
				}
			}
		}
		return repeatedRows >= square && repeatedColumns >= square;
	}
	
	/**
	 * Returns the Highest Possible Square in the Matrix.
	 *  
	 * @param matrix
	 * @return int
	 */
	private static int getHighestPossibleSquare(int[][] matrix) {
		int highestMaximalSquarePossible = matrix.length;
		
		if(matrix[0].length < highestMaximalSquarePossible) {
			highestMaximalSquarePossible = matrix[0].length;
		}
		return highestMaximalSquarePossible;
	}
	
	/**
	 * Returns the Max Number of 1s repeated in each Column.
	 *  
	 * @param matrix
	 * @return int[]
	 */
	private static int [] getColumnMaxRepeatedOnes(int [][] matrix) {
		int [] repeatedOnes = new int[matrix[0].length];
		
		for(int j=0; j < matrix[0].length ; j++) {
			int repeatedOnesCount = 0;
			int maxRepeatedOnes = 0;
			for (int i=0; i < matrix.length; i++) {
				//increment the count of repeated ones if we encounter a 1
				if(matrix[i][j] == 1) {
					repeatedOnesCount++;
				}
				//set the max repeatedOnes if it is less than the repeatedOnesCount
				if(repeatedOnesCount > maxRepeatedOnes) {
					maxRepeatedOnes = repeatedOnesCount;
				}
				//reset the count of repeated ones if we encounter a 0
				if(matrix[i][j] == 0) {
					repeatedOnesCount = 0;
				}
			}
			
			repeatedOnes[j] = maxRepeatedOnes;
		}
		
		
		return repeatedOnes;
	}
	
	/**
	 * Returns the Max Number of 1s repeated in each Row.
	 *  
	 * @param matrix
	 * @return int[]
	 */
	private static int [] getRowMaxRepeatedOnes(int [][] matrix) {
		int [] repeatedOnes = new int[matrix.length];
		
		for(int i=0; i < matrix.length ; i++) {
			int repeatedOnesCount = 0;
			int maxRepeatedOnes = 0;
			for (int j=0; j < matrix[i].length; j++) {
				//increment the count of repeated ones if we encounter a 1
				if(matrix[i][j] == 1) {
					repeatedOnesCount++;
				}
				//set the max repeatedOnes if it is less than the repeatedOnesCount
				if(repeatedOnesCount > maxRepeatedOnes) {
					maxRepeatedOnes = repeatedOnesCount;
				}
				//reset the count of repeated ones if we encounter a 0
				if(matrix[i][j] == 0) {
					repeatedOnesCount = 0;
				}
			}
			
			repeatedOnes[i] = maxRepeatedOnes;
		}
		
		
		return repeatedOnes;
	}
	
	/**
	 * Converts the Array of Strings (containing only 0s and 1s) into a 2D Array
	 *  
	 * @param inputArray
	 * @return 2D Int Array
	 */
	private static int [][] getStringArrayAsIntMatrix(String[] inputArray) {
		//All Strings in the inputArray should be of same length
		int matrixColumnLength = inputArray[0].length();
		
		int [][] matrix = new int[inputArray.length][matrixColumnLength];
		
		for(int i=0; i < inputArray.length; i++ ) {
			//validate that all strings in input array are of same length
			//this is to ensure we don't face any errors in subsequent logic
			if(inputArray[i].length() != matrixColumnLength ) {
				throw new IllegalStateException("Input should be in form of a matrix.");
			}
			
			//Iterate over each char in the string and parse it to an int
			//and add it to the 2D array
			for(int j=0; j < matrixColumnLength; j++) {
				int intValue = Integer.parseInt(String.valueOf(inputArray[i].charAt(j)));
				
				//Validate that we just have 0s and 1s as an input 
				if(intValue != 0 & intValue != 1) {
					throw new IllegalStateException("Input should only contain 0s and 1s");
				}
				matrix[i][j] = intValue;
			}
		}
		
		return matrix;
	}
}
