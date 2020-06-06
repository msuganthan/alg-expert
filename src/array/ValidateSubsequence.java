package array;

import java.util.List;

/**
 * Given two non-empty arrays of integers, write a function that determines
 * whether the second array is sub-sequence of the first one.
 *
 * A subsequence of an array is a set of numbers that aren't necessarily adjacent in the array but that
 * are in the same order as they appear in the array. For instance [1, 3, 4] form a subsequence of
 * the array [1,2,3,4], and so do the numbers [2,4]. Note that a single number in an array itself
 * are both valid sub-sequences of the array.
 */
public class ValidateSubsequence {
    //A is the master data
    //B is the data u need to validate
    //Move the a
    //Move the b when u found some element in a
    //True if b-sequencing is equal to b sizing

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        int masterDataSequence = 0;
        int subDataSequence    = 0;
        while (masterDataSequence < array.size() && subDataSequence < sequence.size()) {
            if (array.get(masterDataSequence).equals(sequence.get(subDataSequence)))
                subDataSequence++;
            masterDataSequence++;
        }
        return subDataSequence == sequence.size();
    }
}
