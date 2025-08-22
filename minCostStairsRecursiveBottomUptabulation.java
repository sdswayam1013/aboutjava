package dataStructurePractice;

public class minCostStairsRecursiveBottomUptabulation {


	    public static int minCostClimbingStairs(int[] cost) {
	        int n = cost.length;
	        int[] dp = new int[n]; //1st step creation

	        dp[0] = cost[0]; //base case + 2nd step 
	        dp[1] = cost[1];

	        for (int i = 2; i < n; i++) { //3rd step
	            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
	        }

	        // Minimum cost to reach top is min of last two steps
	        return Math.min(dp[n - 1], dp[n - 2]);
	    }

	    public static void main(String[] args) {
	        int[] cost = {10, 15, 20};
	        System.out.println("Minimum Cost = " + minCostClimbingStairs(cost));
	    }
	}

