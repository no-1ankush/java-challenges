# Sum Root to Leaf Numbers #

## Problem Statement: ##

Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
An example is the root-to-leaf path 1->2->3 which represents the number 123.
Find the total sum of all root-to-leaf numbers.

**Note:** A leaf is a node with no children.

## Sample Input/ Output With Explanation##

**Input:** [4,9,0,5,1] <br/>

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;4<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;/&nbsp;&nbsp;&nbsp;&nbsp;\\<br/>
&nbsp;&nbsp;&nbsp;9&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;0<br/>
&nbsp;&nbsp;/&nbsp;&nbsp;\\<br/>
5&nbsp;&nbsp;&nbsp;1<br/>

**Output:** 1026

**Explanation:**

* The root-to-leaf path 4->9->5 represents the number 495.
* The root-to-leaf path 4->9->1 represents the number 491.
* The root-to-leaf path 4->0 represents the number 40.
* **Sum: ** 495 + 491 + 40 = 1026.