package dataStructurePractice;

public class minCostStairsRecursiveTopDownDpM {
	public static int minCost(int[] cost, int n, int[] dp) {
		if (n == 0 || n == 1) // base case
			return cost[n];

		if (dp[n] != -1) // 3rd step
			return dp[n];

		dp[n] = cost[n] + Math.min(minCost(cost, n - 1, dp), minCost(cost, n - 2, dp));// 2nd step
		return dp[n];
	}

	public static void main(String[] args) {
		int[] cost = { 10, 15, 20 };
		int n = cost.length;

		int[] dp = new int[n];// 1st step
		// Arrays.fill(dp, -1);
		for (int i = 0; i <= n; i++)//i here includes 0 too//
			dp[i] = -1;

		int result = Math.min(minCost(cost, n - 1, dp), minCost(cost, n - 2, dp));
		System.out.println("Minimum Cost = " + result);
	}
}
