package algo_expert.dynamicProg;

import java.util.Arrays;

/**
 * Given an array of positive integers representing coin denominations and a single non-negative
 * integer `n` representing a target amount of money, write a function that returns the number of
 * ways to make change for that target amount using the given coin denominations.
 *
 * Note that unlimited amount of coins is at your disposal.
 *
 * demons = [1, 5]
 * n = 6
 * 1. 1 * 6
 * 2. 1 * 1 + 5 * 1
 *
 * How are they deciding this factor one
 */

public class NumberOfWaysToMakeChange {
    public static void main(String[] args) {
        System.out.println(numberOfWaysToMakeChange(11, new int[] {1,2, 5}));
    }
    public static int numberOfWaysToMakeChange(int targetAmount, int[] denoms) {
        int[] dp = new int[targetAmount+1];
		Arrays.fill(dp, targetAmount + 1);
		dp[0] = 0;
        for (int amount = 1; amount <= targetAmount ; amount++) {
            for (int j = 0; j < denoms.length; j++) {
                if (denoms[j] <= amount) {
                    dp[amount] = Math.min(dp[amount], 1 + dp[amount - denoms[j]]); // 1 plus next best.
                }
            }
        }
		return dp[targetAmount] > targetAmount ? -1 : dp[targetAmount];
    }
}
