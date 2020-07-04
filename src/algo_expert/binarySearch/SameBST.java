package algo_expert.binarySearch;


import java.util.ArrayList;
import java.util.List;

public class SameBST {

    public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
        if (arrayOne.size() != arrayTwo.size()) return false;

        if (arrayOne.size() == 0 && arrayTwo.size() == 0) return true;

        if (arrayOne.get(0).intValue() != arrayTwo.get(0).intValue()) return false;

        List<Integer> leftOne = getSmaller(arrayOne);
        List<Integer> leftTwo = getSmaller(arrayTwo);
        List<Integer> rightOne = getBiggerOrEquals(arrayOne);
        List<Integer> rightTwo = getBiggerOrEquals(arrayTwo);

        return sameBsts(leftOne, leftTwo) && sameBsts(rightOne, rightTwo);
    }

    public static List<Integer> getSmaller(List<Integer> array) {
        List<Integer> smaller = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).intValue() < array.get(0).intValue()) smaller.add(array.get(i).intValue());
        }
        return smaller;
    }

    public static List<Integer> getBiggerOrEquals(List<Integer> array) {
        List<Integer> biggerOrEquals = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).intValue() >= array.get(0).intValue()) biggerOrEquals.add(array.get(i).intValue());
        }
        return biggerOrEquals;
    }
}
