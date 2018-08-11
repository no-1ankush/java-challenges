# Maximum Binary Tree #

## Problem Statement: ##

Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

* The root is the maximum number in the array.
* The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
* The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.

Construct the maximum tree by the given array and output the root node of this tree.

## Sample Input/ Output With Explanation##

**Input:** [3,2,1,6,0,5] <br/>

**Output:**

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;6<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;/&nbsp;&nbsp;&nbsp;&nbsp;\\<br/>
&nbsp;&nbsp;&nbsp;3&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;5<br/>
&nbsp;&nbsp;&nbsp;&nbsp;\\&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;/<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2&nbsp;&nbsp;0<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\\<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1<br/>