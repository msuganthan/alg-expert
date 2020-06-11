package algo_expert.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a function that takes in a binary tree and returns a list of its branch sums
 * ordered from leftmost branch sum to rightmost branch sum.
 *
 * A branch sum is the sum of all values in a Binary Tree branch. A binary tree branch is
 * a path of nodes in a tree that starts at the root node and ends at any leaf node.
 */

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
