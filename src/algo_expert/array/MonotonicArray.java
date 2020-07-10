package algo_expert.array;

/**
 * Write a function that takes in an array of integers and returns a boolean representing whether
 * the array is monotonic.
 *
 * An array is said to be monotonic if its elements, from left to right are entirely
 * non-increasing or entirely non-decreasing.
 *
 * [-1, -5, -10, -1100, -1100, -1101, -1102, -9001]
 */
public class MonotonicArray {
    public static void main(String[] args) {
        isMonotonic(new int[] {-1, -5, -10, -1100, -1100, -1101, -1102, -9001});
    }

    public static boolean isMonotonic(int[] array) {
        boolean increasing = true;
        boolean decreasing = true;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1])
                decreasing = false;
            if (array[i] > array[i - 1])
                increasing = false;
        }
        return increasing || decreasing;
    }
}
