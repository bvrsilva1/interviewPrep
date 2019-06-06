package dynamicprogramming;

import java.io.*;
import java.util.*;

class LatticePathsProblems {

  	/*
	 * Problem 1: Lattice Paths (Dynamic Programming Approach)
	 *
	 * Prompt: Count the number of unique paths to travel from the top left to the
	 * bottom right of a lattice of squares.
	 *
	 * NOTE: You are traveling along the **EDGES** of the lattice
	 *
	 * Input: An integer N (which is the width of the lattice) An integer M (which
	 * is the height of the lattice)
	 *
	 * Output: An interger (which represents the number of unique paths)
	 *
	 * Example: input: 2
	 *
	 * (2 x 3 lattice of squares) __ __ __ |__|__|__| |__|__|__|
	 *
	 * output: 10 (number of unique paths from top left corner to bottom right)
	 *
	 * Diagram:
     *
     *             1__1__1__1
     *             |  |  |  |
     *             1__2__3__4
     *             |  |  |  |
     *             1__3__6__10
     *             
	 * Notes: What is the time and auxilliary space complexity of your solution?
	 *
	 * When moving through the lattice, you can only move either down or to the
	 * right.
	 *
	 * You did this problem before with recursion. Try implementing it now with
	 * dynamic programming!
	 *
	 * Resources: 1: https://projecteuler.net/problem=15 2:
	 * https://en.wikipedia.org/wiki/Lattice_path
	 *
	 */

  // Time Complexity:
  // Auxiliary Space Complexity:
   public static int latticePaths(int m, int n) {
     if(m == 0 && n == 0) {
    	 	return 1;
     }
     else {
    	 	
    	 	//int memo[] = new int[n + 1];
    	 	int memo[][] = new int[m + 1][n + 1];
    	 	latticePath(memo, m + 1, n + 1);
    	 	System.out.println(memo[m][n]);
    	 	return memo[m][n];
     }
     
   }

	private static void latticePath(int[][] memo, int m, int n) {
		
		memo[0][0] = 1;
		
		/*for(int row = 0; row < m; row++) {
			for(int col = 1; col < n; col++) {
				memo[col] += memo[col - 1];
			}
		}*/
		
		for(int row = 0; row < m; row++) {
			for(int col = 0; col < n; col++) {
				if(isValid(row + 1, col, m, n)) {
					memo[row + 1][col] += memo[row][col];
				}
				if(isValid(row, col + 1, m, n)) {
					memo[row][col + 1] += memo[row][col];
				}
			}
		}
		
	}

	private static boolean isValid(int row, int col, int m, int n) {
		if(row < m && col < n)
			return true;
		return false;
	}

 }


 ////////////////////////////////////////////////////////////
 ///////////////  DO NOT TOUCH TEST BELOW!!!  ///////////////
 ////////////////////////////////////////////////////////////

 // use the Main class to run the test cases
 class LatticePaths {
   private int[] testCount;

   // an interface to perform tests
   public interface Test {
     public boolean execute();
   }

   public static void main(String[] args) {

     int[] testCount = {0, 0};
     System.out.println("Lattice Paths Tests");

     assertTest(testCount, "should work on a 2 x 3 lattice", new Test() {
       public boolean execute() {
         return LatticePathsProblems.latticePaths(2, 3) == 10;
       }
     });

     assertTest(testCount, "should return the same for a 3 x 2 lattice", new Test() {
       public boolean execute() {
         return LatticePathsProblems.latticePaths(3, 2) == 10;
       }
     });

     assertTest(testCount, "should return the same for a 0 x 0 lattice", new Test() {
       public boolean execute() {
         return LatticePathsProblems.latticePaths(0, 0) == 1;
       }
     });

     assertTest(testCount, "should work for a 10 x 10 lattice (square input)", new Test() {
       public boolean execute() {
         return LatticePathsProblems.latticePaths(10, 10) == 184756;
       }
     });

     assertTest(testCount, "should work for a 17 x 14 lattice (large input)", new Test() {
       public boolean execute() {
         return LatticePathsProblems.latticePaths(17, 14) == 265182525;
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
     } catch(Exception e) {}
     String result = "  " + (count[1] + ")   ").substring(0, 5) + pass + " : " + name;
     System.out.println(result);
   }
 }