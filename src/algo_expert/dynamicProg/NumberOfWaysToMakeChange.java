package algo_expert.dynamicProg;

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
    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        int[] ways = new int[n + 1];
        ways[0]    = 1;
        for (int denom : denoms) {
            for (int amount = 1; amount < n + 1; amount++) {
                if (denom <= amount) {
                    ways[amount] += ways[amount - denom];
                }
            }
        }
        return ways[n];
    }
}
