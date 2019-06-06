package dynamicprogramming;

import java.io.*;
import java.util.*;

class MinStepsToOneProblems {

	/*
	 * Problem 2: Minimum Steps to One - Memoization or Tabulation
	 *
	 * Prompt: Given a positive integer, you can perform any combination of these 3
	 * steps: 1.) Subtract 1 from it. 2.) If its divisible by 2, divide by 2. 3.) If
	 * its divisible by 3, divide by 3.
	 *
	 * Find the minimum number of steps that it takes get from N to 1
	 *
	 * Input: Positive Integer N Output: Integer
	 *
	 * Example: input: 10
	 *
	 * output: 3
	 */

	// Time Complexity:
	// Auxiliary Space Complexity:
	private static HashMap<Integer, Integer> memo = new HashMap<>();
	public static int minStepsToOne(int n) {
		
		int arr[] = new int[n + 1];
		
		if(n == 1) {
			return 0;
		}
		
		//returns 0 for 1
		arr[2] = 1;
		arr[3] = 1;
		
		for(int i = 4; i < arr.length; i++) {
			if(i % 2 == 0 && i % 3 == 0) {
				arr[i] = Math.min(arr[i-1], Math.min(arr[i/2], arr[i/3])) + 1;
				
			}
			else if(i % 2 == 0) {
				arr[i] = Math.min(arr[i-1], arr[i/2]) + 1;
			}
			else if(i % 3 == 0){
				arr[i] = Math.min(arr[i-1], arr[i/3]) + 1;
			}
			else {
				arr[i] = arr[i-1] + 1;
			}
		}
		
		return arr[n];
		
		/*if(n <= 1) {
			return 0;
		}
		else if(n <= 3) {
			return 1;
		}
		else if(memo.containsKey(n)) {
			return memo.get(n);
		}
		else {
			int smallest = Integer.MAX_VALUE; 
			int subtract = Integer.MAX_VALUE;
			int divideTwo = Integer.MAX_VALUE;
			int divideThree = Integer.MAX_VALUE;
			
			subtract = minStepsToOne(n - 1);
			
			if(subtract < smallest)
				smallest = subtract;
			
			if(n % 2 == 0) {
				divideTwo = minStepsToOne(n/2);
				
				if(divideTwo < smallest)
					smallest = divideTwo;
			}
			
			if(n % 3 == 0) {
				divideThree = minStepsToOne(n/3);
				
				if(divideThree < smallest)
					smallest = divideThree;
			}
			
			smallest++;
			memo.put(n, smallest);
			
			return smallest;
		}*/
		
		
	}

}

////////////////////////////////////////////////////////////
/////////////// DO NOT TOUCH TEST BELOW!!! ///////////////
////////////////////////////////////////////////////////////

// use the Main class to run the test cases
class MinStepstoOne {
	private int[] testCount;

	// an interface to perform tests
	public interface Test {
		public boolean execute();
	}

	public static void main(String[] args) {

		int[] testCount = { 0, 0 };

		// instantiate the testing of each module by resetting count and printing title
		// of module
		testCount[0] = 0;
		testCount[1] = 0;

		System.out.println("Minimum Steps to One Tests");

		// tests are in the form as shown
		assertTest(testCount, "should return 3 for 10", new Test() {
			public boolean execute() {
				int output = MinStepsToOneProblems.minStepsToOne(10);
				return output == 3;
			}
		});

		assertTest(testCount, "should return 0 for 1", new Test() {
			public boolean execute() {
				int output = MinStepsToOneProblems.minStepsToOne(1);
				return output == 0;
			}
		});

		assertTest(testCount, "should work for large numbers", new Test() {
			public boolean execute() {
				int output = MinStepsToOneProblems.minStepsToOne(1334425);
				return output == 22;
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