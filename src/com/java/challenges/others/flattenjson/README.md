# Flatten JSON

## Problem Statement: ##
To Flatten the JSON Object

**Assumptions:** 

* JSON contains only Strings or Objects (of type *Map*).
* Input is a *List of Map* (*Key* of type String and *Value*  of Type Object)
* Output is a *List of Map* (*Key* of type String and *Value*  of Type Object)


## Sample Input/Output ##

<table>
    <thead>
        <tr>
            <th>Scenario #</th>
            <th>Input</th>
            <th>Output</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>1</td>
            <td>[{ "a" : { "b" : { "c" : { "d" : "e" }}}}]</td>
            <td>[{ "a_b_c_d" = "e" }]</td>
        </tr>
        <tr>
            <td>2</td>
            <td>[{ "a" : { "b" : { "c" : { "d" : "e" }}}, "a1" : "b1" }]</td>
            <td>[{ "a1" : "b1" }, { "a_b_c_d" = "e" } ]</td>
        </tr>
        <tr>
            <td>3</td>
            <td>[{ "a" : { "b" : { "c" : { "d" : "e" }, "c1" : "d1" }}, "a1" : "b1" }]</td>
            <td>[{ "a1" : "b1" }, { "a_b_c1" : "d1" }, { "a_b_c_d" = "e" } ]</td>
        </tr>
        <tr>
            <td>4</td>
            <td>[{ "a" : { "b" : { "c" : { "d" : "e" }, "c1" : "d1" }}, "a1" : "b1", "a2" : "b2" }]</td>
            <td>[{ "a1" : "b1" }, { "a2" : "b2" }, { "a_b_c1" : "d1" }, { "a_b_c_d" = "e" } ]</td>
        </tr>
    </tbody>
</table>
