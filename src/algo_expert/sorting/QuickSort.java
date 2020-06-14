package algo_expert.sorting;

/**
 * Write a function that takes in an array of integers and return a sorted version of that array.
 * Use the quickSort algorithm to sort the array.
 *
 * 1. Pick the pivot
 * 2. Iterate thru the rest of the array and sort every other number just w.r.t pivot
 *  a. Every number which is smaller you are gonna move it to the left
 *  b. Every number which is greater you are gonna move it to the right
 *
 * Now apply the same to sub-array which is positioned to the left of the pivot
 */
public class QuickSort {
    public static int[] quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
        return array;
    }

    static void quickSort(int[] array, int startIndex, int endIndex) {
        if (startIndex >= endIndex)
            return;

        int pivotIndex = startIndex;
        int leftIndex  = startIndex + 1;
        int rightIndex = endIndex;

        while (rightIndex >= leftIndex) {
            if (array[leftIndex] > array[pivotIndex] && array[rightIndex] < array[pivotIndex])
                swap(array, leftIndex, rightIndex);

            if (array[leftIndex] <= array[pivotIndex])
                leftIndex += 1;

            if (array[rightIndex] >= array[pivotIndex])
                rightIndex -= 1;
        }
        //swap the pivot and right pointer
        swap(array, pivotIndex, rightIndex);
        boolean leftSubArrayIsSmaller = rightIndex - 1 - startIndex < endIndex - (rightIndex + 1);
        if (leftSubArrayIsSmaller) {
            quickSort(array, startIndex, rightIndex - 1);
            quickSort(array, rightIndex + 1, endIndex);
        } else {
            quickSort(array, rightIndex + 1, endIndex);
            quickSort(array, startIndex, rightIndex - 1);
        }
    }

    static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
