package com.java.challenges.flattenjson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ankush Gupta
 * 
 * Email: no.1ankush@gmail.com 
 * GitHub: https://github.com/no-1ankush
 * LinkedIn: www.linkedin.com/in/no1ankush
 */
public class FlattenJSON {

	public static void main(String[] args) {
		executeInputForScenario1();
		executeInputForScenario2();
		executeInputForScenario3();
		executeInputForScenario4();
	}

	/**
	 * Builds inputs, executed flattening and print the results..
	 */
	private static void executeInputForScenario1() {
		List<Map<String, Object>> inputList = new ArrayList<Map<String, Object>>();

		Map<String, Object> aMap = new HashMap<>();
		Map<String, Object> bMap = new HashMap<>();
		Map<String, Object> cMap = new HashMap<>();
		Map<String, Object> dMap = new HashMap<>();
		dMap.put("d", "e");
		cMap.put("c", dMap);
		bMap.put("b", cMap);
		aMap.put("a", bMap);

		inputList.add(aMap);
		
		System.out.println("\nScenario 1 Input");
		System.out.println("------------------");
		System.out.println("[{ a : { b : { c : { d : e }}}}]");
		System.out.println("\nScenario 1 Output");
		System.out.println("-------------------");
		System.out.println(getFlattenListMap(inputList));
		
	}
	
	/**
	 * Builds inputs, executed flattening and print the results..
	 */
	private static void executeInputForScenario2() {
		List<Map<String, Object>> inputList = new ArrayList<Map<String, Object>>();

		Map<String, Object> aMap = new HashMap<>();
		Map<String, Object> bMap = new HashMap<>();
		Map<String, Object> cMap = new HashMap<>();
		Map<String, Object> dMap = new HashMap<>();
		dMap.put("d", "e");
		cMap.put("c", dMap);
		bMap.put("b", cMap);
		aMap.put("a", bMap);
		aMap.put("a1", "b1");

		inputList.add(aMap);
		
		System.out.println("\nScenario 2 Input");
		System.out.println("------------------");
		System.out.println("[{ a : { b : { c : { d : e }}}, a1 : b1 }]");
		System.out.println("\nScenario 2 Output");
		System.out.println("-------------------");
		System.out.println(getFlattenListMap(inputList));
		
	}
	
	/**
	 * Builds inputs, executed flattening and print the results..
	 */
	private static void executeInputForScenario3() {
		List<Map<String, Object>> inputList = new ArrayList<Map<String, Object>>();

		Map<String, Object> aMap = new HashMap<>();
		Map<String, Object> bMap = new HashMap<>();
		Map<String, Object> cMap = new HashMap<>();
		Map<String, Object> dMap = new HashMap<>();
		dMap.put("d", "e");
		cMap.put("c", dMap);
		cMap.put("c1", "d1");
		bMap.put("b", cMap);
		aMap.put("a", bMap);
		aMap.put("a1", "b1");

		inputList.add(aMap);
		
		System.out.println("\nScenario 3 Input");
		System.out.println("------------------");
		System.out.println("[{ a : { b : { c : { d : e }, c1: d1}}, a1 : b1 }]");
		System.out.println("\nScenario 3 Output");
		System.out.println("-------------------");
		System.out.println(getFlattenListMap(inputList));
		
	}
	
	/**
	 * Builds inputs, executed flattening and print the results..
	 */
	private static void executeInputForScenario4() {
		List<Map<String, Object>> inputList = new ArrayList<Map<String, Object>>();

		Map<String, Object> aMap = new HashMap<>();
		Map<String, Object> bMap = new HashMap<>();
		Map<String, Object> cMap = new HashMap<>();
		Map<String, Object> dMap = new HashMap<>();
		dMap.put("d", "e");
		cMap.put("c", dMap);
		cMap.put("c1", "d1");
		bMap.put("b", cMap);
		aMap.put("a", bMap);
		aMap.put("a1", "b1");
		aMap.put("a2", "b2");

		inputList.add(aMap);
		
		System.out.println("\nScenario 4 Input");
		System.out.println("------------------");
		System.out.println("[{ a : { b : { c : { d : e }, c1: d1}}, a1 : b1, a2 : b2 }]");
		System.out.println("\nScenario 4 Output");
		System.out.println("-------------------");
		System.out.println(getFlattenListMap(inputList));
		
	}
	
	/**
	 * Flattens the List of Map<String, Object> into a List of Map<String, String>
	 * 
	 * @param inputList
	 * @return List<Map<String, String>>
	 */
	public static List<Map<String, String>> getFlattenListMap(List<Map<String, Object>> inputList) {
	    List<Map<String, String>> outputList = new ArrayList<Map<String, String>>();
	    
	    //Check for valid inputs
	    if(inputList != null && !inputList.isEmpty()) {
	    	//Iterate over the list and flatten each Map
	    	for(Map<String, Object> inputMap : inputList) {
	        	outputList.add(getFlattenedChildMap(inputMap));
	        }
	    }
	    return outputList;
	}

	/**
	 * Flattens the Map<String, Object> to Map<String, String>
	 * 
	 * @param inputMap
	 * @return Map<String, String>
	 */
	@SuppressWarnings("unchecked")
	private static Map<String, String> getFlattenedChildMap(Map<String, Object> inputMap) {
	     Map<String, String> flattenedMap = new HashMap<String, String>();
	     
	     for(String inputMapKey: inputMap.keySet()) {
	         Object mapValue = inputMap.get(inputMapKey);
	                
	         //If the Map Value is a String then we have reach the max depth. 
	         //Add the key and value as the output Map
	         if(mapValue instanceof String) {
	        	 flattenedMap.put(inputMapKey, (String) mapValue);
	         }
	         else {
	        	 //If the Map Value is not a String then we havn't hit the max depth yet.
	        	 // 1. Cast the the mapValue to a Map as the value can either be a String or Map
	        	 // 2. Update the traversed map key into the child map
		         Map<String, Object> childMap = getUpdatedChildMapWithPrependedInputMapKey((Map<String, Object>) mapValue, inputMapKey);      
		         
		         //Call the flattenChildMap Method recursively to flatten all maps in the tree
		         Map<String, String> flattenedChildMap = getFlattenedChildMap(childMap);
		         
		         //Add the flattened child maps to the final flattened maps
		         for(String childMapKey: flattenedChildMap.keySet()) {
		             flattenedMap.put(childMapKey, flattenedChildMap.get(childMapKey));
		         } 
	         }
	     }
	     return flattenedMap;
	}
	
	/**
	 * Update the Child Map with the Keys prepend with the traversed key
	 * E.g. If inputMap has the key for a and the child map has the key of b.
	 *  	since child is not a string but a map we want to update the key to a_b to meet the desired output
	 *  
	 * @param childMap
	 * @param inputMapKey
	 * @return Map<String, Object>
	 */
	private static Map<String, Object> getUpdatedChildMapWithPrependedInputMapKey(Map<String, Object> childMap, String inputMapKey){
		Map<String, Object> updatedChildMap = new HashMap<String, Object>();
        
        //Pre-append the inputMap key to all the keys in the child Map
        for(String childMapKey : childMap.keySet()) {
        	updatedChildMap.put(inputMapKey + "_" + childMapKey, childMap.get(childMapKey)); 
        }
        
        return updatedChildMap;
	}
}