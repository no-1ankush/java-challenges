# Eight Queen

## Problem Statement: ##

Determine if the Eight Queens are peacefully placed on a Chess Board.

Given an array of string is being passed which consist of the location of the Eight Queens on a chess board, determine if the Queens are peacefully placed on the board or they in-line of attack. If they are placed peacefully for the given input, return the string true otherwise return the first queen in the list that is attacking another piece in the same format it was provided.

**For example:** If input array is ["(2,1)", "(4,2)", "(6,3)", "(8,4)", "(3,5)", "(1,6)", "(7,7)", "(5,8)"] then the program should return true. 

![picture alt](https://github.com/no-1ankush/java-challenges/blob/master/src/com/java/challenges/eightqueen/Eight_Queen_Puzzle.png "Eight Queen Puzzle")

**Note**: Refer [Wikipedia](https://en.wikipedia.org/wiki/Eight_queens_puzzle) to better understand the Eight Queen Puzzle.

## Sample Input/Output: ##

<table>
    <thead>
        <tr>
            <th>Scenario # </th>
            <th>Input</th>
            <th>Output</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>1</td>
            <td>"(2,1)", "(4,3)", "(6,3)", "(8,4)", "(3,4)", "(1,6)", "(7,7)", "(5,8)"</td>
            <td>"(2,1)"</td>
        </tr>
        <tr>
            <td>2</td>
            <td>"(2,1)", "(5,3)", "(6,3)", "(8,4)", "(3,4)", "(1,8)", "(7,7)", "(5,8)"</td>
            <td>"(5,3)"</td>
        </tr>
        <tr>
            <td>3</td>
            <td>"(2,1)", "(4,2)", "(6,3)", "(8,4)", "(3,5)", "(1,6)", "(7,7)", "(5,8)"</td>
            <td>true</td>
        </tr>
    </tbody>
</table>
