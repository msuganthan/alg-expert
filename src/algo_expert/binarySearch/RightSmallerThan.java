package algo_expert.binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RightSmallerThan {
    public static void main(String[] args) {
        rightSmallerThan(Arrays.asList(new Integer[]{8, 5, 11, -1, 3, 4, 2}));
    }


    static List<Integer> rightSmallerThan(List<Integer> array) {
        List<Integer> rightSmallerThan = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            int rightSmallerCount = 0;
            for (int j = i + 1; j < array.size(); j++) {
                if (array.get(j) < array.get(i))
                    rightSmallerCount++;
            }
            rightSmallerThan.add(rightSmallerCount);
        }
        return rightSmallerThan;
    }
}
