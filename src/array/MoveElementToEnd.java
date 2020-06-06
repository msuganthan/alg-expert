package array;

import java.util.List;

/**
 * You are given an array of integer and an integer. Write a function that moves all instances
 * of that integer in the array to the end of the array and return the array.
 *
 * The function should perform this in-place.
 *
 * array  = [2, 1, 2, 2, 2, 3, 4, 2]
 * toMove = 2
 */
public class MoveElementToEnd {
    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        //Maintain two pointer leftpointer, rigtPointer
        //Move the right pointer inwards as longs it point to the integer to move
        //Move the left pointer inwards as long as it doesn't point to the integer to move.
        int leftPointer = 0;
        int rigtPointer = array.size() - 1;
        while(leftPointer < rigtPointer) {
            while (leftPointer < rigtPointer && array.get(rigtPointer) == toMove) rigtPointer--;
                if (array.get(leftPointer) == toMove) swap(leftPointer, rigtPointer, array);
            leftPointer++;
        }
        return array;
    }

    private static void swap(int i, int j, List<Integer> array) {
        int temp = array.get(j);
        array.set(j, array.get(i));
        array.set(i, temp);
    }
}
