package dynamicprogramming;

public class Knapsack {

	public static void main(String[] args) {
		
		/*int knapsackWeight = 7;
		int value[] = {1, 4, 5, 7};
		int weight[] = {1, 3, 4, 5};*/
		
		int knapsackWeight = 50;
		int value[] = {60, 100, 120};
		int weight[] = {10, 20, 30};
		
		int table[][] = new int[value.length][knapsackWeight + 1];
		
		//action for first item
		for(int i = 1; i < knapsackWeight + 1; i++) {
			table[0][i] = value[0];
		}
		
		//action for remaining items
		for(int row = 1; row < value.length; row++) {
			for(int col = 1; col < knapsackWeight + 1; col++) {
				if(weight[row] <= col) {
					table[row][col] = Math.max(table[row - 1][col], value[row] + table[row - 1][col - weight[row]]);
				}
				else {
					table[row][col] = table[row - 1][col]; 
				}
				
			}
		}
		
		System.out.println(table[value.length - 1][knapsackWeight]);
		
	}
	
}
