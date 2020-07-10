package algo_expert.array;

import java.util.Arrays;
import java.util.List;

/**
 * Given two non-empty arrays of integers, write a function that determines
 * whether the second algo_expert.array is sub-sequence of the first one.
 *
 * A subsequence of an algo_expert.array is a set of numbers that aren't necessarily adjacent in the algo_expert.array but that
 * are in the same order as they appear in the algo_expert.array. For instance [1, 3, 4] form a subsequence of
 * the algo_expert.array [1,2,3,4], and so do the numbers [2,4]. Note that a single number in an algo_expert.array itself
 * are both valid sub-sequences of the algo_expert.array.
 */
public class ValidateSubsequence {
    //A is the master data
    //B is the data u need to validate
    //Move the a
    //Move the b when u found some element in a
    //True if b-sequencing is equal to b sizing

	public static void main(String[] args) {
		System.out.println(isValidSubsequence(Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10), Arrays.asList(1, 6, -1, 10)));
	}

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        int firstArrayPointer = 0;
		int secondArrayPointer = 0;
		while(firstArrayPointer < array.size() && secondArrayPointer < sequence.size()) {
			int firstArrayElement = array.get(firstArrayPointer);
			int secondArrayElement = sequence.get(secondArrayPointer);
			if(firstArrayElement == secondArrayElement)
				secondArrayPointer++;
			firstArrayPointer++;
		}
		return secondArrayPointer == sequence.size();
    }
}
