package algo_expert.sorting;

/**
 * We are gonna divide the array into two separate array.
 * 1. Sublist unsorted
 * 2. Sublist sorted
 *
 * We will iterate through unsorted sublist and find the smallest number and put it in sorted sublist.
 */
public class SelectionSort {
    static int[] selectionSort(int[] array) {
        if (array.length == 0)
            return new int[] {};
        int startIndex = 0;
        while (startIndex < array.length - 1) {
            int smallestIndex = startIndex;

            /**
             * Identify the smallest number in the array by iterating the entire array.
             */
            for (int i = startIndex + 1; i < array.length; i++)
                if (array[smallestIndex] > array[i])
                    smallestIndex = i;
            swap(array, startIndex, smallestIndex);
            startIndex++;
        }
        return array;
    }

    static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
