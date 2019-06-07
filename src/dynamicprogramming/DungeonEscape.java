package dynamicprogramming;

import java.io.*;
import java.util.*;

/*
 *  Target Practice 03 - Dynamic Programming pt. 2
 */

class DungeonEscape {

	/*
	 * Problem: Dungeon Escape
	 *
	 * Given a matrix of integers that represents rooms in a dungeon, determine the
	 * minimum amount of health a adventurer must start with in order to escape the
	 * dungeon
	 *
	 * The adventurer starts at the upper left corner of the matrix, and the exit is
	 * located at the bottom right corner.
	 *
	 * The adventurer must leave the dungeon before sundown, so in the interest of
	 * time, this brave adventurer decides to only travel downwards and to the right
	 *
	 * Negative integers represent rooms with monsters, so the adventurer would lose
	 * health when going though these rooms. 0s represent empty rooms, and positive
	 * integers represent rooms that contain health pots that will increase the
	 * adventurer's health
	 *
	 *
	 * Input: dungeon {Integer[][]} Output: {Integer}
	 *
	 *
	 * Example: Input: [[ -2, -5, 10], [ -3,-10, 30], [ 3, 1, -5]]
	 *
	 * Output: 7 (The steps to do this would be down, down, right, right)
	 *
	 *
	 * Note: The initial health should be represented by a positve integers If the
	 * health ever drops to zero or a negative integer, the adventurer dies. Every
	 * room will contain an integer. It will either be empty (0), contain a monster
	 * (negative), or contain a health pot (positive). You could create every single
	 * possible path, but there is of course a dynamic programming approach to not
	 * go with this route.
	 *
	 */

	// Time Complexity:
	// Auxiliary Space Complexity:

	public static void main(String[] args) {

		/*
		 * int dungeon[][] = { {-2, -5, 10}, {-3, -10, 30}, {3, 1, -5}};
		 */

		int dungeon[][] = { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } };

		int arr[] = new int[dungeon[0].length];

		arr[0] = dungeon[0][0];

		for (int i = 1; i < dungeon[0].length; i++) {
			arr[i] = arr[i - 1] + dungeon[0][i];
		}

		for (int row = 1; row < dungeon.length; row++) {
			arr[0] = arr[0] + dungeon[row][0];

			for (int col = 1; col < dungeon[0].length; col++) {
				if (arr[col - 1] < 0 && arr[col] < 0 /* && dungeon[row][col] < 0 */) {
					arr[col] = Math.max(arr[col - 1] + dungeon[row][col], arr[col] + dungeon[row][col]);
				} else {
					arr[col] = Math.min(arr[col - 1] + dungeon[row][col], arr[col] + dungeon[row][col]);
				}

			}
		}

		int minHealth = arr[dungeon[0].length - 1] * (-1) + 1;

		System.out.println("min health: " + minHealth);

	}

}
