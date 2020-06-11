package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BranchSum {

    public static List<Integer> branchSum(BinaryTree root) {
        List<Integer> sums = new ArrayList<>();
        calculateBranchSums(root, 0, sums);
        return sums;
    }

    //Use depth first traversal
    //If left and right of a node is null => return it
    public static void calculateBranchSums(BinaryTree node, int runningSum, List<Integer> sums) {
        if (node == null) return;

        int newRunningSum = node.value + runningSum;
        if (node.left == null && node.right == null) {
            sums.add(newRunningSum);
            return;
        }
        calculateBranchSums(node.left, newRunningSum, sums);
        calculateBranchSums(node.right, newRunningSum, sums);
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left  = null;
            this.right = null;
        }
    }
}
