package recursion;

/*
 *  Target Practice 01 - Recursion
 *
 *  Problem 1:  Powerset - Helper Method Recursion
 *
 *  Prompt:   Given a set S, return the powerset P(S), which is
 *            a set of all subsets of S.
 *
 *  Input:    {String}
 *  Output:   {Array}
 *
 *  Example:  S = "abc", P(S) = ['', 'a', 'b','c','ab','ac','bc','abc']
 *
 *  Notes:     The input string will not contain duplicate characters
 *            The letters in the subset string must be in the same order
 *            as the original input.
 *            
 *  21 min
 */

import java.util.*;
import java.util.ArrayList;

class Powersets {

	public static List<String> compute(String str) {
		
		List<String> powerSet = new ArrayList<String>();
		powerSet.add("");
		
		if(str.length() > 0) {
			
			for(int i = 0; i < str.length(); i++) {
				int wall = powerSet.size();
				for(int j = 0; j < wall; j++) {
					powerSet.add(powerSet.get(j) + str.charAt(i));
				}
			}
		}
		
		return powerSet;
	}

}

////////////////////////////////////////////////////////////
/////////////// DO NOT TOUCH TEST BELOW!!! ///////////////
////////////////////////////////////////////////////////////

// use the Main class to run the test cases
class PowerSet {

	private int[] testCount;

	// an interface to perform tests
	public interface Test {
		public boolean execute();
	}

	public static void main(String[] args) {
		// instantiate the testing of each module by resetting count and printing title
		// of module
		int[] testCount = { 0, 0 };
		System.out.println("Power Set Tests");

		// tests are in the form as shown
		assertTest(testCount, "should work on example input", new Test() {
			public boolean execute() {

				Powersets powerSet = new Powersets();
				List<String> result = powerSet.compute("abc");

				List<String> answer = Arrays.asList("", "c", "b", "bc", "a", "ac", "ab", "abc");

				Collections.sort(result);
				Collections.sort(answer);

				return result.equals(answer);
			}
		});

		assertTest(testCount, "should work on empty input", new Test() {
			public boolean execute() {

				Powersets powerSet = new Powersets();
				List<String> result = powerSet.compute("");

				List<String> answer = Arrays.asList("");

				Collections.sort(result);
				Collections.sort(answer);

				return result.equals(answer);
			}
		});

		assertTest(testCount, "should work on two-letter input", new Test() {
			public boolean execute() {

				Powersets powerSet = new Powersets();
				List<String> result = powerSet.compute("ab");

				List<String> answer = Arrays.asList("", "a", "b", "ab");

				Collections.sort(result);
				Collections.sort(answer);

				return result.equals(answer);
			}
		});

		assertTest(testCount, "should work on longer input", new Test() {
			public boolean execute() {

				Powersets powerSet = new Powersets();
				List<String> result = powerSet.compute("abcdefg");

				List<String> answer = Arrays.asList("", "g", "f", "fg", "e", "eg", "ef", "efg", "d", "dg", "df", "dfg",
						"de", "deg", "def", "defg", "c", "cg", "cf", "cfg", "ce", "ceg", "cef", "cefg", "cd", "cdg",
						"cdf", "cdfg", "cde", "cdeg", "cdef", "cdefg", "b", "bg", "bf", "bfg", "be", "beg", "bef",
						"befg", "bd", "bdg", "bdf", "bdfg", "bde", "bdeg", "bdef", "bdefg", "bc", "bcg", "bcf", "bcfg",
						"bce", "bceg", "bcef", "bcefg", "bcd", "bcdg", "bcdf", "bcdfg", "bcde", "bcdeg", "bcdef",
						"bcdefg", "a", "ag", "af", "afg", "ae", "aeg", "aef", "aefg", "ad", "adg", "adf", "adfg", "ade",
						"adeg", "adef", "adefg", "ac", "acg", "acf", "acfg", "ace", "aceg", "acef", "acefg", "acd",
						"acdg", "acdf", "acdfg", "acde", "acdeg", "acdef", "acdefg", "ab", "abg", "abf", "abfg", "abe",
						"abeg", "abef", "abefg", "abd", "abdg", "abdf", "abdfg", "abde", "abdeg", "abdef", "abdefg",
						"abc", "abcg", "abcf", "abcfg", "abce", "abceg", "abcef", "abcefg", "abcd", "abcdg", "abcdf",
						"abcdfg", "abcde", "abcdeg", "abcdef", "abcdefg");

				Collections.sort(result);
				Collections.sort(answer);

				return result.equals(answer);
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