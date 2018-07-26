# Intersect Strings

### Problem Statement: ###
Intersect two Strings and print the output in the same order as the first String.

**Note:** Output should not have duplicates

### Sample Input/Output: ###

<table>
    <thead>
        <tr>
            <th rowspan=2>Scenario</th>
            <th colspan=2>Input</th>
            <th rowspan=2>Output</th>
        </tr>
        <tr>
            <th>First String</th>
            <th>Second String</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>All Matching Characters (Non-Repetitive)</td>
            <td>ABCDEF</td>
            <td>ABCDEF</td>
            <td>ABCDEF</td>
        </tr>
        <tr>
            <td>All Matching Characters (Repetitive)</td>
            <td>AAAAAA</td>
            <td>AAAAAA</td>
            <td>A</td>
        </tr>
        <tr>
        	<td>No Matching Characters (Non-Repetitive)</td>
            <td>ABCABC</td>
            <td>DEFDEF</td>
            <td></td>
        </tr>
        <tr>
        	<td>No Matching Characters (Repetitive)</td>
            <td>AAAAAA</td>
            <td>ZZZZZZ</td>
            <td></td>
        </tr>
        <tr>
        	<td>Multiple Matching Characters (Repetitive)</td>
            <td>AABBCC</td>
            <td>CCDDEE</td>
            <td>C</td>
        </tr>
        <tr>
        	<td>Multiple Matching Characters (Non-Repetitive)</td>
            <td>ZYXWVU</td>
            <td>RSTUVW</td>
            <td>WVU</td>
        </tr>
    </tbody>
</table>