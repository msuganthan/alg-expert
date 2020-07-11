package algo_expert.array;

public class SubArraySort {
    public static void main(String[] args) {
        subArraySort(new int[] {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19});
        subArraySortIndex(new int[] {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19});
    }

    public static int[] subArraySortIndex(int[] array) {
        int minOutOfOrder = Integer.MAX_VALUE;
        int maxOutOfOrder = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            if (isOutOfOrder(i, num, array)) {
                minOutOfOrder = Math.min(minOutOfOrder, num);
                maxOutOfOrder = Math.max(maxOutOfOrder, num);
            }
        }
        if (minOutOfOrder == Integer.MIN_VALUE)
            return new int[] {-1, -1};

        int subArrayLeftIndex = 0;
        while (minOutOfOrder >= array[subArrayLeftIndex])
            subArrayLeftIndex++;

        int subArrayRightIndex = array.length - 1;
        while (maxOutOfOrder <= array[subArrayRightIndex])
            subArrayRightIndex--;

        return new int[] {subArrayLeftIndex, subArrayRightIndex};
    }


    static boolean isOutOfOrder(int i, int num, int[] array) {
        if (i == 0)
            return num > array[i + 1];
        else if (i == array.length - 1)
            return num < array[i - 1];
        else
            return num < array[i - 1] || num > array[i + 1];
    }

    static int[] subArraySort(int[] array) {
        int i = 1;
        while (i < array.length) {
            int suspectElement = array[i];
            int neighbourElement = array[i - 1];
            if (suspectElement < neighbourElement) {
                int indexToSwap = i;
                while (suspectElement < array[indexToSwap -1])
                    indexToSwap--;
                swap(array, indexToSwap, i);
            } else
                i++;
        }
        return array;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
