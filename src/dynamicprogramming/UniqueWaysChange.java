package dynamicprogramming;

public class UniqueWaysChange {

	public static void main(String[] args) {
		
		int amount = 5;
		int coins[] = {1, 2, 5};
		int table[][] = new int[coins.length][amount + 1];
		
		for(int row = 0; row < coins.length; row++) {
			table[row][0] = 1;
		}
		
		for(int col = 1; col < amount + 1; col++) {
			table[0][col] = 1;
		}
		
		for(int row = 1; row < coins.length; row++) {
			for(int col = 1; col < amount + 1; col++) {
				if(coins[row] <= col) {
					table[row][col] = table[row - 1][col] + table[row][col - coins[row]];
				}
				else {
					table[row][col] = table[row - 1][col];
				}
				
			}
		}
		
		System.out.println(table[coins.length - 1][amount]);
		
	}
	
}
