package com.java.challenges.compareversion;

/**
 * @author Ankush Gupta
 * 
 * Email: no.1ankush@gmail.com 
 * GitHub: https://github.com/no-1ankush
 * LinkedIn: www.linkedin.com/in/no1ankush
 */
public class CompareVersion {

	public static void main(String[] args) {
		String version1 = "7.5.2.4";
		String version2 = "7.5.3";
		
		System.out.println("\nVersion 1: " + version1 + "\nVersion 2: " + version2);
		System.out.println("\nOutput: " + compareVersion(version1, version2));

		version1 = "1.0.1";
		version2 = "1";
		
		System.out.println("\nVersion 1: " + version1 + "\nVersion 2: " + version2);
		System.out.println("\nOutput: " + compareVersion(version1, version2));
		
		version1 = "1.0";
		version2 = "1";
		
		System.out.println("\nVersion 1: " + version1 + "\nVersion 2: " + version2);
		System.out.println("\nOutput: " + compareVersion(version1, version2));
	}

	/**
	 * Compares the Version Numbers
	 * 
	 * @param version1
	 * @param version2
	 * @return int
	 */
	public static int compareVersion(String version1, String version2) {
		int result = 0;
		
		String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        
        int longest = v1.length > v2.length? v1.length: v2.length;
        
        for(int i=0; i < longest; i++) { 
            Integer ver1 = i < v1.length? Integer.parseInt(v1[i]): 0;
            Integer ver2 = i < v2.length? Integer.parseInt(v2[i]): 0;
            
            int compare = ver1.compareTo(ver2);
            
            if(compare != 0) {
            	result = compare;
            	break;
            }
        }
		return result;
	}
}