package algo_expert.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LargestRange {
    public static void main(String[] args) {
        int[] ints = largestRange(new int[]{1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6});
        for (int num: ints)
            System.out.println(num);
    }

    static int[] largestRange(int[] array) {
        int[] largestRange = new int[2];
        int longestLength  = 0;
        Map<Integer, Boolean> nums = new HashMap<>();
        for (int num: array)
            nums.put(num, true);

        for (int num: array) {

            nums.put(num, false);
            int currentLength = 1;

            int left = num - 1;
            while (nums.containsKey(left)) {
                nums.put(left, false);
                currentLength++;
                left--;
            }

            int right = num + 1;
            while (nums.containsKey(right)) {
                nums.put(right, false);
                currentLength++;
                right++;
            }

            if (currentLength > longestLength) {
                longestLength = currentLength;
                largestRange = new int[] {left + 1, right - 1};
            }
        }
        return largestRange;
    }

}
