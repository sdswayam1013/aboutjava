package dataStructurePractice;

import java.util.Arrays;

public class minNoOfCoinsTabulation {

	public static int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount + 1];// +1 because we want one place more that the given
										// amount because we want to make space for amount=0 also

		// Initialize with a large number (greater than any possible number of coins)
		Arrays.fill(dp, amount + 1); // +1 because we want to assign dp with some larger value
										// so that whenever we will compare the obtained values,
										// it will always be lesser than the larger value taken

		// Base case: 0 coins needed to make amount 0
		dp[0] = 0;

		// Build up the dp table from 1 to amount
		for (int i = 1; i <= amount; i++) {
			for (int coin : coins) {
				if (i - coin >= 0) {
					dp[i] = Math.min(dp[i], dp[i - coin] + 1);// we are adding the current coin
																// which us getting subtracted now.
				}
			}
		}

		// If dp[amount] is still a large number, it means no solution
		return dp[amount] > amount ? -1 : dp[amount];
	}

	public static void main(String[] args) {
		int[] coins = { 1, 2, 5 };
		int amount = 11;
		int result = coinChange(coins, amount);
		System.out.println("Minimum coins required: " + result);
	}
}
