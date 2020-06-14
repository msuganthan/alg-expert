package algo_expert.sorting;

/**
 * Write a function that takes in an array of integers and returns a sorted version of that array.
 * Use the bubble sort algorithm to sort the array.
 */
public class BubbleSort {

    public static int[] bubbleSort(int[] array) {
        if (array.length == 0)
            return new int[] {};
        boolean isSorted = false;
        int counter      = 0;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1 - counter; i++) {
                if (array[i] > array[i+1]) {
                    swap(array, i, i+1);
                    isSorted = false;
                }
            }
            counter++;
        }
        return array;
    }

    static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
