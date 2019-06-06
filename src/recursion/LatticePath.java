package recursion;

/*
 * Problem: Lattice Paths - Pure Recursion
 *
 * Prompt: Count the number of unique paths to travel from the top left corder
 * to the bottom right corner of a lattice of M x N squares.
 *
 * When moving through the lattice, one can only travel to the adjacent corner
 * on the right or down.
 *
 * Input: m {Integer} - rows of squares Input: n {Integer} - column of squares
 * Output: {Integer}
 *
 * Example: input: (2, 3)
 *
 *           (2 x 3 lattice of squares)
 *            __ __ __
 *           |__|__|__|
 *           |__|__|__|
 *
 * output: 10 (number of unique paths from top left corner to bottom right)
 *
 * Resource: https://projecteuler.net/problem=15
 *
 * took me 17:30 min
 * if it was m - 1 and n - 1 for the base case, it would consider only the blocks within the matrix
 * m and n as base case consider the border, which is needed for this challenge
 *
 */

// Time Complexity:
// Auxiliary Space Complexity:
class LatticePaths {
	public static int compute(int m, int n) {
		if(m == 0 && n == 0)
			return 1;
		else {
			int value = compute(m, n, 0, 0);
			System.out.println(value);
			return value;
		}
	}

	private static int compute(int m, int n, int row, int col) {
		if(row == m && col == n) {
			return 1;
		}
		else if(row > m || col > n) {
			return 0;
		}
		else {
			int down = compute(m, n, row + 1, col);
			int right = compute(m, n, row, col + 1);
			return down + right;
		}
	}
}

////////////////////////////////////////////////////////////
/////////////// DO NOT TOUCH TEST BELOW!!! ///////////////
////////////////////////////////////////////////////////////

// use the Main class to run the test cases
class LatticePath {

	private int[] testCount;

	// an interface to perform tests
	public interface Test {
		public boolean execute();
	}

	public static void main(String[] args) {
		// instantiate the testing of each module by resetting count and printing title
		// of module
		int[] testCount = { 0, 0 };

		// instantiate the testing of each module by resetting count and printing title
		// of module
		testCount[0] = 0;
		testCount[1] = 0;

		System.out.println("Lattice Paths Tests");

		// tests are in the form as shown
		assertTest(testCount, "should work on example case", new Test() {
			public boolean execute() {
				LatticePaths example = new LatticePaths();
				return example.compute(2, 3) == 10;
			}
		});

		assertTest(testCount, "should return 1 for 0 x 0 lattice", new Test() {
			public boolean execute() {
				LatticePaths example = new LatticePaths();
				return example.compute(0, 0) == 1;
			}
		});

		assertTest(testCount, "should return 2496144 for 13 x 11 lattice", new Test() {
			public boolean execute() {
				LatticePaths example = new LatticePaths();
				return example.compute(13, 11) == 2496144;
			}
		});

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