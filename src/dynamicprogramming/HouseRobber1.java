package dynamicprogramming;

public class HouseRobber1 {

	public static void main(String[] args) {
		
		int value1[] = {1,2,3,1};
		System.out.println(robber(value1));
		
		int value2[] = {2,7,9,3,1};
		System.out.println(robber(value2));
		
	}

	private static int robber(int[] value) {
		
		if(value == null || value.length == 0) {
			return 0;
		}
		else if(value.length == 1) {
			return value[0];
		}
		else if(value.length == 2) {
			return Math.max(value[0], value[1]);
		}
		else {
			
			int memo[] = new int[value.length];
			
			memo[0] = value[0];
			memo[1] = Math.max(value[0], value[1]);
			
			for(int i = 2; i < value.length; i++) {
				memo[i] = Math.max(memo[i - 1], memo[i - 2] + value[i]);  
			}
			
			return memo[memo.length - 1];
		}
		
	}
	
}
