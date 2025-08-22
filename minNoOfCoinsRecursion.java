package dataStructurePractice;

public class minNoOfCoinsRecursion {

	public static int coinChange(int[] coins, int amount) {
		if (amount == 0)
			return 0;
		if (amount < 0)
			return -1;

		int min = Integer.MAX_VALUE;
		// for (int coin : coins) int res = coinChange(coins, amount - coin);

		for (int i = 0; i < coins.length; i++) {
			int res = coinChange(coins, amount - coins[i]);

			if (res >= 0 && res < min) {
				min = res + 1;
			}
		}

		// return (min == Integer.MAX_VALUE) ? -1 : min;
		if (min == Integer.MAX_VALUE) {
			return -1;
		} else {
			return min;
		}

	}

	public static void main(String[] args) {
		int[] coins = { 1, 2, 5 };
		int amount = 57;
		int result = coinChange(coins, amount);
		System.out.println("Minimum coins required: " + result);
	}
}
