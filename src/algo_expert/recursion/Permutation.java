package algo_expert.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Write a function that taken in an array of unique integers and returns and array
 * of all permutations of those integers in no particular order.
 *
 * [1, 2, 3]
 *
 * [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]
 */
public class Permutation {

    public static void main(String[] args) {
        getPermutations(Arrays.asList(new Integer[]{1, 2, 3}));
    }

    static List<List<Integer>> getPermutations(List<Integer> array) {
        List<List<Integer>> permutations = new ArrayList<>();
        getPermutations(0, array, permutations);
        return permutations;
    }

    static void getPermutations(int i, List<Integer> array, List<List<Integer>> permutations) {
        if (i == array.size() - 1)
            permutations.add(new ArrayList<>(array));
        else {
            for (int j = i; j < array.size(); j++) {
                swap(array, i, j);
                getPermutations(i + 1, array, permutations);
                swap(array, i, j);
            }
        }
    }

    static void swap(List<Integer> array, int i, int j) {
        int temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }
}
