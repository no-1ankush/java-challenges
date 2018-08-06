# Compare Version Numbers

## Problem Statement: ##
Compare two version numbers version1 and version2.
* If version1 > version2 return 1
* if version1 < version2 return -1
* if version1 = version2 return 0.

**Assumptions:** 

* The version strings are non-empty and contain only digits and the . character.
* The . character does not represent a decimal point and is used to separate number sequences. For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.


## Sample Input/Output ##

<table>
    <thead>
        <tr>
            <th rowspan="2">Scenario #</th>
            <th colspan="2">Input</th>
            <th rowspan="2">Output</th>
        </tr>
        <tr>
            <th>Version 1</th>
            <th>Version 2</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>1</td>
            <td>7.5.2.4</td>
            <td>7.5.3</td>
            <td>-1</td>
        </tr>
        <tr>
            <td>2</td>
            <td>1.0.1</td>
            <td>1</td>
            <td>1</td>
        </tr>
        <tr>
            <td>3</td>
            <td>1.0</td>
            <td>1</td>
            <td>0</td>
        </tr>
    </tbody>
</table>
