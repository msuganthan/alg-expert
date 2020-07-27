package algo_expert.dynamicProg;

/**
 * Write a function that takes in an array of positive integers and returns the maximum sum of non-adjacent elements
 * in the array.
 * [75, 105, 120, 75, 90, 135]
 *
 * [75, 105,                ]
 *
 * For the third place you can either take sum of 75 + 120 or 105
 * We take 75 + 120 ==> 195
 * [75, 105, 195,          ]
 * second = 105
 * first  = 195
 * For the fourth place you can either take the sum of 105 + 75 or 195
 * We take 195
 * [75, 105, 195, 195,    ]
 * second = 195
 * first  = 195
 * For the fifth place you can either take the sum of 195 + 90 or 195
 * We take 195 + 90 ==> 285
 * [75, 105, 195, 195, 285,  ]
 * second = 195
 * first  = 285
 * Now either 195 + 135 or 285
 * We take 195 + 135 ==> 330
 * [75, 105, 195, 195, 285, 330]
 * first = 330
 * second = 285
 * return the first
 */
public class MaxSubsetSum {

    static int maxSubsetSumNoAdjacent(int[] array) {
        if(array.length == 0)
            return 0;
        else if(array.length == 1)
            return array[0];

        int[] maxSum = array.clone();
        maxSum[1]    = Math.max(array[0], array[1]);


        for (int i = 2; i < array.length; i++) {
            maxSum[i] = Math.max(maxSum[i - 2] + maxSum[i],  maxSum[i -1]);
        }
        return maxSum[array.length - 1];
    }
}
