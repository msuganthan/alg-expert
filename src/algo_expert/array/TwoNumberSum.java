package algo_expert.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Write a function that take in an non-empty algo_expert.array of distinct integer and an integer representing a target sum. If any
 * two numbers in the input algo_expert.array sum up to the target sum, the function should return them in an algo_expert.array, in any order.
 * If no two numbers sum up to the target sum, the function should return an empty algo_expert.array.
 *
 * Note that the target sum has to be obtained by summing two different integers in the algo_expert.array; you can't add a single
 * integer to itself in order to obtain the target sum.
 *
 * Sample input
 * algo_expert.array = [3, 5, -4, 8, 11, 1, -1, 6]
 * targetSum = 10
 */
public class TwoNumberSum {
    //We need to find the pair for the given number in the algo_expert.array.
    //For example: 1. If 3  is there search for 7
    //                If 5  is there search for 5
    //                If -4 is there search for 14
    //Use HashMap to store and search for numbers
    //What you store --> 3 in key and algo_expert.array index in value
    //What you search --> search for remainder i.e. 7

    public static int[] searchForPair(int[] array, int targetNum) {
        Map<Integer, Integer> container = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            int targetNeeded = targetNum - array[i];
            if (container.containsKey(targetNeeded))
                return new int[] {array[i], targetNeeded};
            else
                container.put(array[i], i);
        }

        return new int[] {};
    }
}
