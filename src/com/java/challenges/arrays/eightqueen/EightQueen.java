package com.java.challenges.arrays.eightqueen;

import java.util.Arrays;

public class EightQueen {

	public static void main(String[] args) {
		
		String [] queenPositions = new String[] {"(2,1)", "(4,3)", "(6,3)", "(8,4)", "(3,4)", "(1,6)", "(7,7)", "(5,8)"};
		System.out.println("\nInput: " + getInputArrayAsString(queenPositions));
		System.out.println("\nOutput: " + eiqhtQueens(queenPositions));
		
		queenPositions = new String[] {"(2,1)", "(5,3)", "(6,3)", "(8,4)", "(3,4)", "(1,8)", "(7,7)", "(5,8)"};
		System.out.println("\nInput: " + getInputArrayAsString(queenPositions));
		System.out.println("\nOutput: " + eiqhtQueens(queenPositions));
		
		queenPositions = new String[] {"(2,1)", "(4,2)", "(6,3)", "(8,4)", "(3,5)", "(1,6)", "(7,7)", "(5,8)"};
		System.out.println("\nInput: " + getInputArrayAsString(queenPositions));
		System.out.println("\nOutput: " + eiqhtQueens(queenPositions));
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
	 * Solves the eight queen problem and returns
	 * 	- true, if all the eight queens are peacefully placed.
	 * 	- coordinates of the first queen attacking any other queens.  
	 * 
	 * @param queenPositions
	 * @return String
	 */
	private static String eiqhtQueens(String[] queenPositions) {
		String eightQueenPuzzle = "true";
		
		int [][] chessboard = getQueensPlottedOnChessBoard(queenPositions);
		
		for(int queenNr = 0; queenNr < queenPositions.length; queenNr++ ) {
			int [] queenCoordinates = getQueenCoordinates(queenPositions[queenNr]);
			
			if(isQueenAttackingOtherQueen(chessboard, queenNr + 1, queenCoordinates)) {
				eightQueenPuzzle = queenPositions[queenNr];
				break;
			}
		}
		return eightQueenPuzzle;
	}
	
	/**
	 * Checks if the Queen is attacking any other Queen or not..
	 * 
	 * @param chessboard
	 * @return boolean
	 */
	private static boolean isQueenAttackingOtherQueen(int [][] chessboard, int queenNr, int [] queenCoordinates) {
		//Check for Horizontal Line of Attack
		for(int j = 0; j < chessboard[queenCoordinates[0]].length; j++) {
			if(chessboard[queenCoordinates[0]][j] != 0 
					&& chessboard[queenCoordinates[0]][j] != queenNr) {
				return true;
			}
		}
		
		//Check for Vertical Line of Attack
		for(int i = 0; i < chessboard.length; i++) {
			if(chessboard[i] [queenCoordinates[1]] != 0 
					&& chessboard[i] [queenCoordinates[1]] != queenNr) {
				return true;
			}
		}
		
		//Check for Diagonal Line of Attack
		//Towards TOP LEFT
		int i = queenCoordinates[0];
		int j = queenCoordinates[1];
		while(--i >= 0 && --j >= 0) {
			if(chessboard[i] [j] != 0) {
				return true;
			}
		}
		//Towards BOTTOM RIGHT
		i = queenCoordinates[0];
		j = queenCoordinates[1];
		while(++i < 8 && ++j < 8) {
			if(chessboard[i] [j] != 0) {
				return true;
			}
		}
		
		//Towards TOP RIGHT
		i = queenCoordinates[0];
		j = queenCoordinates[1];
		while(--i >= 0 && ++j < 8) {
			if(chessboard[i] [j] != 0) {
				return true;
			}
		}
		
		//Towards BOTTOM LEFT
		i = queenCoordinates[0];
		j = queenCoordinates[1];
		while(++i < 8 && --j >= 0) {
			if(chessboard[i] [j] != 0) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Plots the Eight Queens on a Matrix for 8x8
	 * with the Queen Number. 
	 * 
	 * @param queenPositions
	 * @return int [][]
	 */
	private static int[][] getQueensPlottedOnChessBoard(String[] queenPositions) {
		int [][] chessboard = new int [8][8];
		
		if(queenPositions == null 
				|| queenPositions.length != 8) {
			throw new IllegalStateException("Invalid inputs: Queen Positions are not of size 8.");
		}
		
		for(int queenNr = 0; queenNr < queenPositions.length; queenNr++) {
			int [] queenCoordinates = getQueenCoordinates(queenPositions[queenNr]);
			
			chessboard[queenCoordinates[0]][queenCoordinates[1]] = queenNr + 1;
		}
			
		return chessboard;
	}
	
	/**
	 * Converts the input Queen Coordinates from String to X & Y Coordinates
	 * 
	 * @param queenPosition
	 * @return int[]
	 */
	private static int[] getQueenCoordinates(String queenPosition) {
		String[] queenCoordinates = queenPosition
										.replace("(", "")
										.replace(")", "")
										.split(",");

		if(queenCoordinates == null 
				|| queenCoordinates.length != 2) {
			throw new IllegalStateException("Invalid inputs: Queen Positions are not incorrect and can not be plotted.");
		}
		
		int xCoordinates = Integer.parseInt(queenCoordinates[0]);
		int yCoordinates = Integer.parseInt(queenCoordinates[1]);
		
		if(xCoordinates < 0 
				|| xCoordinates > 8 
				|| yCoordinates < 0 
				|| yCoordinates > 8) {
			throw new IllegalStateException("Invalid inputs: Queen Positions are not incorrect and can not be plotted.");
		}
		
		return new int[] {xCoordinates -1 , yCoordinates - 1};
	}
}