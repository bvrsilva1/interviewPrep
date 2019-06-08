package dynamicprogramming;

public class MinCoinsChange {

	public static void main(String[] args) {
		
		int amount = 11;
		int coins[] = {1, 5, 6, 8};
		
		int table[][] = new int[coins.length][amount + 1];
		
		for(int i = 1; i < amount + 1; i++) {
			table[0][i] = 1 + table[0][i - 1];
		}
		
		for(int row = 1; row < coins.length; row++) {
			for(int col = 1; col < amount + 1; col++) {
				if(coins[row] <= col) {
					table[row][col] = Math.min(table[row - 1][col], 1 + table[row][col - coins[row]]);
				}
				else {
					table[row][col] = table[row - 1][col];
				}
			}
		}
		
		System.out.println(table[coins.length - 1][amount]);
		
	}
	
}
