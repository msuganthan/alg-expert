package algo_expert.graphs;

/**
 * You are given an array of integers where each integer represents a jump of its value in the array.
 * For instance, the integer 2 represents a jump of two indices forward in the array; the integer -3
 * represents a jump of three indices backward in the array.
 *
 * If a jump spills past the array's bounds, it wraps over to the other side. For instance, a jump of -1 at
 * the index 0 brings us to the last index in the array. Similarly, a jump of 1 at the last index in the array
 * brings us to index 0.
 */
public class SingleCycleChecks {

    static boolean hasSingleCycle(int[] array) {
        int numOfElementsVisited = 0;
        int currentIdx           = 0;

        while (numOfElementsVisited < array.length) {
            if (numOfElementsVisited > 0 && currentIdx == 0) return false;
            numOfElementsVisited++;
            currentIdx = getNextIdx(currentIdx, array);
        }

        return currentIdx == 0;
    }

    public static int getNextIdx(int currentIdx, int[] array) {
        int jump    = array[currentIdx];
        int nextIdx = ( currentIdx + jump ) % array.length;
        return nextIdx >= 0 ? nextIdx : nextIdx + array.length;
     }
}
