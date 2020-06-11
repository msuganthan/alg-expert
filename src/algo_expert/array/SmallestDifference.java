package algo_expert.array;

import java.util.Arrays;

/**
 * Write a function that takes in two non-empty arrays of integers, finds the pair of numbers
 * whose absolute difference is closest to zero and returns an algo_expert.array containing these two
 * numbers, with the number from the first algo_expert.array in the first position.
 * arrayOne = [-1, 5, 10, 20, 28, 3]
 * arrayTwo = [26, 134, 135, 15, 17]
 */
public class SmallestDifference {
    //For some reason we are sorting both the algo_expert.array
    // arrayOne = [-1, 3, 5, 10, 20, 28]
    // arrayTwo = [15, 17, 26, 134, 135]
    //|-1 - 15| == 16
    //smallest = 16
    //lets say I am incrementing to 3
    //|3 - 15| ==> 12
    //smallest = 12
    //I am incrementing to 5
    //|5 - 15| ==> 10
    //smallest = 10
    // |10 - 15| ==> 5
    //smallest = 5
    // |20 - 15| ==> 5
    //smallest remains same
    // |20 - 17| ==> 3
    //smallest 3
    //|20 - 26| ==> 6
    //|28 - 26| ==> 2
    //smallest = 2

    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        Arrays.sort(arrayOne);
		Arrays.sort(arrayTwo);
		int firstArrayPointer  = 0;
		int secondArrayPointer = 0;
		int smallest			     = Integer.MAX_VALUE;
		int current 				   = Integer.MAX_VALUE;
		int[] smallestPair     = new int[2];
		while(firstArrayPointer < arrayOne.length && secondArrayPointer < arrayTwo.length) {
			int firstArrayElement  = arrayOne[firstArrayPointer];
			int secondArrayElement = arrayTwo[secondArrayPointer];
			if(firstArrayElement < secondArrayElement) {
				current = secondArrayElement - firstArrayElement;
				firstArrayPointer++;
			} else if(secondArrayElement < firstArrayElement) {
				current = firstArrayElement - secondArrayElement;
				secondArrayPointer++;
			} else {
				return new int[] {firstArrayElement, secondArrayElement};
			}
			if(current < smallest) {
				smallest = current;
				smallestPair = new int[] {firstArrayElement, secondArrayElement};
 			}
		}
		return smallestPair;
  }
}
