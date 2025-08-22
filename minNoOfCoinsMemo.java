package dataStructurePractice;

import java.util.Arrays;

public class minNoOfCoinsMemo {

	public static int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount + 1];// we want to store all possible sub-amounts from 0(included)to 12, total 13
										// boxes needed
		Arrays.fill(dp, -1);
		return helper(coins, amount, dp);
	}

	private static int helper(int[] coins, int amount, int[] dp) {
		if (amount == 0)
			return 0;
		if (amount < 0)
			return -1;

		if (dp[amount] != -1)
			return dp[amount];

		int min = Integer.MAX_VALUE;
//	        for (int coin : coins) {
//	            int res = helper(coins, amount - coin, dp);

		for (int i = 0; i < coins.length; i++) {
			int res = helper(coins, amount - coins[i], dp);

			if (res >= 0 && res < min) {
				min = res + 1;
			}
		}

		dp[amount] = (min == Integer.MAX_VALUE) ? -1 : min;
		return dp[amount];
	}

	public static void main(String[] args) {
		int[] coins = { 1, 2, 5 };
		int amount = 11;
		int result = coinChange(coins, amount);
		System.out.println("Minimum coins required: " + result);
	}
}
