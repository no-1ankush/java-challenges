# Maximal Square

## Problem Statement: ##

Find the Maximal Square in a Matrix.

Given an array of string is being passed which will be a 2D matrix of 0 and 1's, and determine the area of the largest square submatrix that contains all 1's. A square submatrix is one of equal width and height, and your program should return the area of the largest submatrix that contains only 1's. For example: if array of string is ["10100", "10111", "11111", "10010"] then this looks like the following matrix: 

1 0 1 0 0<br />
1 0 1 **1 1**<br />
1 1 1 **1 1**<br />
1 0 0 1 0<br /> 

For the input above, you can see the bolded 1's create the largest square submatrix of size 2x2, so your program should return the area which is 4.

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
            <td>0111, 1111, 1111, 1111</td>
            <td>9</td>
        </tr>
        <tr>
            <td>2</td>
            <td>0111, 1101, 0111</td>
            <td>1</td>
        </tr>
        <tr>
            <td>3</td>
            <td>110000, 001100, 000011</td>
            <td>1</td>
        </tr>
        <tr>
            <td>4</td>
            <td>000000, 000000, 000000</td>
            <td>0</td>
        </tr>
        <tr>
            <td>5</td>
            <td>1111, 1111, 1111, 1111</td>
            <td>16</td>
        </tr>
    </tbody>
</table>
