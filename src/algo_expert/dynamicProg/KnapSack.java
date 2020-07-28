package algo_expert.dynamicProg;

import java.util.ArrayList;
import java.util.List;

public class KnapSack {

    public static void main(String[] args) {
        knapsackProblem(new int[][]{{1, 2}, {4, 3}, {5, 6}, {6, 7}}, 10);
    }

    static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {
        int[][] knapsack = new int[items.length + 1][capacity + 1];

        for (int i = 0; i < items.length + 1; i++) {
            int currentValue  = items[i - 1][0];
            int currentWeight = items[i - 1][1];

            for (int c = 0; c < capacity + 1; c++) {
                if (currentWeight > c)
                    knapsack[i][c] = knapsack[i - 1][c];
                else
                    knapsack[i][c] = Math.max(knapsack[i - 1][c], knapsack[i - 1][c - currentWeight] + currentValue);
            }
        }
        return getKnapSackItems(knapsack, items, knapsack[items.length][capacity]);
    }

    public static List<List<Integer>> getKnapSackItems(int[][] knapsackValues, int[][] items, int weight) {
        List<List<Integer>> sequence = new ArrayList<>();
        List<Integer> totalWeight = new ArrayList<>();
        totalWeight.add(weight);
        sequence.add(totalWeight);
        sequence.add(new ArrayList<>());
        int i = knapsackValues.length - 1;
        int c = knapsackValues[0].length - 1;
        while (i > 0) {
            if (knapsackValues[i][c] == knapsackValues[i-1][c])
                i--;
            else {
                sequence.get(1).add(0, i -1);
                c -= items[i - 1][1];
                i--;
            }

            if (c == 0)
                break;
        }
        return sequence;
    }

}
