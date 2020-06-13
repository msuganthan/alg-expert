package algo_expert.searching;

/**
 * Write a function that takes in a sorted array of integers as well as a target integer. The
 * function should use the Binary Search algorithm to determine of the target integer is contained
 * in the array and should return its index if it is. otherwise -1.
 */
public class BinarySearch {

    static int binarySearch(int[] array, int target) {
        return binarySearch(array, target, 0, array.length);
    }

    static int binarySearch(int[] array, int target, int left, int right) {
        if (left > right)
            return -1;

        int middle = (left + right) / 2;
        if (target == array[middle])
            return middle;
        else if (target < array[middle])
            return binarySearch(array, target, left, middle - 1);
        else
            return binarySearch(array, target, middle + 1, right);
    }

}
