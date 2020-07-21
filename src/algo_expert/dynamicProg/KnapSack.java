package algo_expert.dynamicProg;

import java.util.ArrayList;
import java.util.List;

public class KnapSack {

    public static void main(String[] args) {
        knapsackProblem(new int[][]{{1, 2}, {4, 3}, {5, 6}, {6, 7}}, 10);
    }

    static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {
        int[][] knapsackValue = new int[items.length + 1][capacity + 1];

        for (int i = 1; i < items.length + 1; i++) {
            int currentWeight = items[i - 1][1];
            int currentValue  = items[i - 1][0];

            for (int c = 0; c < capacity + 1; c++) {
                if (currentWeight > c)
                    knapsackValue[i][c] = knapsackValue[i - 1][c];
                else
                    //We are creating a 2d knapsack and try to put the item which bring more profit.
                    knapsackValue[i][c] = Math.max(knapsackValue[i - 1][c], knapsackValue[i - 1][c - currentWeight] + currentValue);
            }
        }
        return getKnapSackItems(knapsackValue, items, knapsackValue[items.length][capacity]);
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
            //IS the row above is equal to our current row
            if (knapsackValues[i][c] == knapsackValues[i - 1][c])
                i--;
            else {
                sequence.get(1).add(0, i - 1);
                //evaluating c
                c -= items[i - 1][1];
                i--;
            }

            if (c == 0)
                break;
        }
        return sequence;
    }

}
