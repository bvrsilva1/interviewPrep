package dynamicprogramming;

import java.io.*;
import java.util.*;

/*
 *  Target Practice 03 - Dynamic Programming pt. 2
 */

class MinWindowSubstringProblem {

	/*
	 * Minimum Window Substring (Sliding Window)
	 *
	 * Given a string, and a set of characters return the substring representing the
	 * SMALLEST window containing those characters.
	 *
	 * The characters needn't appear in the order in which they are given.
	 *
	 * If not all the characters are present in the string, return the empty string.
	 *
	 *
	 * Input: str (String) chars (String)
	 *
	 * Output: {String}
	 *
	 *
	 * Example: Input: "ADOBECODEBANC", "ABC" Output: "BANC"
	 *
	 * Input: "HELLO WORLD", "FOO" Output: ""
	 *
	 *
	 * Explanation: Though there are many substrings containing all the characters
	 * "BANC" is the shortest.
	 *
	 * Assume that there won't be repeated characters in the second string input.
	 *
	 * Ignore capitalization. (though taking it into account doesn't change the
	 * solution much)
	 *
	 * But as extra credit, how would you handle repeats? Meaning if you were given
	 * two "A" characters, a valid window MUST contain two "A"s
	 *
	 *
	 */

	// Time Complexity:
	// Auxiliary Space Complexity:
	public static String minimumWindowSubstring(String str, String targets) {

		HashMap<Character, Integer> valid = new HashMap<>();
		
		for(int i = 0; i < targets.length(); i++) {
			valid.put(targets.charAt(i), 0);
		}
		
		int minLength = Integer.MAX_VALUE;
		int minLeft = 0;
		int minRight = 0;
		int left = 0;
		int right = -1;
		
		boolean expand = true;
		boolean alive = true;
		
		while(alive) {
			
			if(isValid(valid)) {
				
				int newMin = right - left + 1;
				
				if(newMin < minLength) {
					minLength = newMin;
					minLeft = left;
					minRight = right;
				}
				
				expand = false;
			}
			else {
				expand = true;
			}
			
			if(expand) {
				right++;
				
				if(right >= str.length()) {
					alive = false;
				}
				else {
					char elem = str.charAt(right);
					if(valid.containsKey(elem)) {
						int counter = valid.get(elem) + 1;
						valid.put(elem, counter);
					}
				}
				
				
				
			}
			else {
				char elem = str.charAt(left);
				if(valid.containsKey(elem)) {
					int counter = valid.get(elem) - 1;
					valid.put(elem, counter);
				}
				left++;
			}
			
		}
		
		if(minLength == Integer.MAX_VALUE) {
			return "";
		}
		else {
			
			StringBuilder substring = new StringBuilder();
			for(int i = minLeft; i <= minRight; i++) {
				substring.append(str.charAt(i));
			}
			
			return substring.toString();
		}
		
		
	}

	private static boolean isValid(HashMap<Character, Integer> valid) {
		
		boolean isValid = true;
		
		for(Map.Entry<Character, Integer> entry : valid.entrySet()) {
			if(entry.getValue() == 0) {
				isValid = false;
			}
		}

		return isValid;
	}

}
////////////////////////////////////////////////////////////
/////////////// DO NOT TOUCH TEST BELOW!!! ///////////////
////////////////////////////////////////////////////////////

// use the Main class to run the test cases
class MinWindowSubstring {
	private int[] testCount;

	// an interface to perform tests
	public interface Test {
		public boolean execute();
	}

	public static void main(String[] args) {

		int[] testCount = { 0, 0 };
		System.out.println("Minimum Window Substring Tests");

		assertTest(testCount, "should work on first example case", new Test() {
			public boolean execute() {
				return MinWindowSubstringProblem.minimumWindowSubstring("ADOBECODEBANC", "ABC").equals("BANC");
			}
		});

		assertTest(testCount, "should work on second example case", new Test() {
			public boolean execute() {
				return MinWindowSubstringProblem.minimumWindowSubstring("HELLO WORLD", "FOO").equals("");
			}
		});

		// print the result of tests passed for a module
		System.out.println("PASSED: " + testCount[0] + " / " + testCount[1] + "\n\n");

	}

	// do not edit below, this is to wrap the test and check for exceptions
	private static void assertTest(int[] count, String name, Test test) {
		String pass = "false";
		count[1]++;

		try {
			if (test.execute()) {
				pass = " true";
				count[0]++;
			}
		} catch (Exception e) {
		}
		String result = "  " + (count[1] + ")   ").substring(0, 5) + pass + " : " + name;
		System.out.println(result);
	}
}