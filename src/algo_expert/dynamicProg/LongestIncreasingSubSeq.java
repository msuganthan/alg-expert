package algo_expert.dynamicProg;

public class LongestIncreasingSubSeq {
    public static void main(String[] args) {
        lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});
    }

    static int lengthOfLIS(int[] nums) {
        if (nums.length <= 1)
            return nums.length;

        int[] T = new int[nums.length];
        for (int i = 1; i < nums.length; i++)
            for (int j = 0; j < i; j++)
                if (nums[i] > nums[j] && T[j] + 1 > T[i])
                    T[i] = T[j]++;

        int longest = 0;
        for (int i = 0; i < T.length; i++)
            longest = Math.max(longest, T[i]);

        return longest;
    }
}
