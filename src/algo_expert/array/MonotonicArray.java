package algo_expert.array;

/**
 * Write a function that takes in an algo_expert.array of integers and returns a boolean representing whether
 * the algo_expert.array is monotonic.
 *
 * An algo_expert.array is said to be monotonic if its elements, from left to right are entirely
 * non-increasing or entirely non-decreasing.
 *
 * [-1, -5, -10, -1100, -1100, -1101, -1102, -9001]
 */
public class MonotonicArray {
    public static boolean isMonotonic(int[] array) {
        boolean isIncreasing = true;
        boolean isDecreasing = true;
        for (int i = 1; i < array.length - 1; i++) {
            if (array[i] < array[i - 1])
                isIncreasing = false;

            if (array[i] > array[i - 1])
                isDecreasing = false;
        }
        return isIncreasing || isDecreasing;
    }
}
