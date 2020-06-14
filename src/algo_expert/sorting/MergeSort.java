package algo_expert.sorting;

public class MergeSort {

    static int[] mergeSort(int[] array) {
        if (array.length <= 1)
            return array;
        int[] auxiliaryArray = array.clone();
        mergeSort(array, 0, array.length - 1, auxiliaryArray);
        return array;
    }

    static void mergeSort(int[] mainArray, int startIndex, int endIndex, int[] auxiliaryArray) {
        if (startIndex == endIndex)
            return;
        int middleIndex = (startIndex + endIndex) / 2;
        mergeSort(auxiliaryArray, startIndex, middleIndex, mainArray);
        mergeSort(auxiliaryArray, middleIndex + 1, endIndex, mainArray);
        doMerge(mainArray, startIndex, middleIndex, endIndex, auxiliaryArray);
    }

    static void doMerge(int[] mainArray, int startIndex, int middleIndex, int endIndex, int[] auxiliaryArray) {
        int k = startIndex;
        int i = startIndex;
        int j = middleIndex + 1;
        while (i <= middleIndex && j <= endIndex) {
            if (auxiliaryArray[i] <= auxiliaryArray[j])
                mainArray[k++] = auxiliaryArray[i++];
            else
                mainArray[k++] = auxiliaryArray[j++];
        }

        while(i <= middleIndex)
            mainArray[k++] = auxiliaryArray[i++];

        while (j <= endIndex)
            mainArray[k++] = auxiliaryArray[j++];
    }
}
