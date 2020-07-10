package algo_expert.array;

import java.util.Arrays;
import java.util.List;

/**
 * You are given an algo_expert.array of integer and an integer. Write a function that moves all instances
 * of that integer in the algo_expert.array to the end of the algo_expert.array and return the algo_expert.array.
 *
 * The function should perform this in-place.
 *
 * algo_expert.array  = [2, 1, 2, 2, 2, 3, 4, 2]
 * toMove = 2
 */
public class MoveElementToEnd {
    public static void main(String[] args) {
        moveElementToEnd(Arrays.asList(new Integer[] { 2, 1, 2, 2, 2, 3, 4, 2}), 2)
                .stream()
                .forEach(System.out::print);
    }

    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        //Maintain two pointer leftpointer, rigtPointer
        //Move the right pointer inwards as longs it point to the integer to move
        //Move the left pointer inwards as long as it doesn't point to the integer to move.
        int pointer = array.size() - 1;
		for(int i = 0; i < pointer; i++) {
		    if(array.get(i) == toMove) {
		        while(i < pointer && array.get(pointer) == toMove)
				    pointer--;
		        swap(i, pointer, array);
            }
		}
		return array;
    }

    private static void swap(int i, int j, List<Integer> array) {
        int temp = array.get(j);
        array.set(j, array.get(i));
        array.set(i, temp);
    }
}
