package algo_expert.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Write a function that takes in a non-empty algo_expert.array of distinct integers and an integer
 * representing a target sum. The function should find all triplets in the algo_expert.array that sum up
 * to the target sum and return a two-dimensional algo_expert.array of all these triplets.
 *
 * If no three numbers sum up to the target sum, the function should return an empty algo_expert.array.
 *
 * Sample Input:
 * algo_expert.array = [12, 3, 1, 2, -6, 5, -8, 6]
 * targetSum = 0
 *
 * Output: [[-8,2,6], [-8,3,5], [-6,1,5]]
 */
public class ThreeNumberSum {
    public static void main(String[] args) {
        List<Integer[]> integers = threeNumberSum(new int[]{12, 3, 1, 2, -6, 5, -8, 6}, 0);
        for (Integer[] integerArray : integers) {
            for (int i = 0; i < integerArray.length; i++) {
                System.out.print(integerArray[i]);
            }
            System.out.print("\n");
        }
    }

    //Sort the given algo_expert.array -8, -6, 1, 2, 3, 5, 6, 12
    //Consider -8 as your first number
    //-6 as second number & 12 as third number
    // -8 + -6 + 12 ==> 2 which is greater than target 0
    //So Move the right pointer
    //-8 + -6 + 6 ==> -6 which is lesser than target 0
    //So Move the left pointer
    //-8 + 1 + 6  ==> -3
    //Move the left pointer
    //-8 + 2 + 6 ==> 0 ==> Add this to triplet
    //Move the left pointer
    //-8 + 3 + 6 ==> 1
    //Move the right pointer
    //-8 + 3 + 5 ==> 0 ==> Add this to triplet
    //Move the left pointer
    //-8 + 5 + 5 ==> 2
    //Break the loop as left and right is same now
    //Continue the same from -6

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
            Arrays.sort(array);
            List<Integer[]> result = new ArrayList<>();
            for(int i = 0; i < array.length - 2; i++) {
                int firstElement = array[i];
                int firstPointer = i + 1;
                int secondPointer = array.length - 1;

                while(firstPointer < secondPointer) {
                    int firstPointerElement = array[firstPointer];
                    int secondPointerElement = array[secondPointer];
                    int totalSum = firstElement + firstPointerElement + secondPointerElement;
                    if(totalSum == targetSum) {
                        result.add(new Integer[]{firstElement, firstPointerElement, secondPointerElement});
                        firstPointer++;
                        secondPointer--;
                    }
                    else if (totalSum < targetSum)
                        firstPointer++;
                    else
                        secondPointer--;
                }
            }
            return result;
    }
}
