package algo_expert.binaryTree;

import algo_expert.binarySearch.ValidateBST;

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

    public static void main(String[] args) {
        //Tree
        //         10
        //       /    \
        //      5     15
        //     / \   /  \
        //    2   5 13  22
        //   /        \
        //  1         14
        //Tree
        //         10
        //       /    \
        //      5     15
        //     / \   /  \
        //    2   5 13  22
        //   /        \
        //  1         14

        BinaryTree tree10 = new BinaryTree(10);
        BinaryTree tree9 = new BinaryTree(9);
        BinaryTree tree8 = new BinaryTree(8);
        BinaryTree tree7 = new BinaryTree(7);
        BinaryTree tree6 = new BinaryTree(6);
        BinaryTree tree5 = new BinaryTree(5);
        BinaryTree tree4 = new BinaryTree(4);
        BinaryTree tree3 = new BinaryTree(3);
        BinaryTree tree2 = new BinaryTree(2);
        BinaryTree tree1 = new BinaryTree(1);

        tree1.left = tree2;
        tree1.right = tree3;

        tree2.left = tree4;
        tree2.right = tree5;

        tree3.left = tree6;
        tree3.right = tree7;

        tree4.left = tree8;
        tree4.right = tree9;

        tree5.left = tree10;

        branchSum(tree1)
                .stream()
                .forEach(it -> System.out.print(it + " "));
    }

    public static List<Integer> branchSum(BinaryTree root) {
        List<Integer> sums = new ArrayList<>();
        calculateBranchSums(root, 0, sums);
        return sums;
    }

    //Use depth first traversal
    //If left and right of a node is null => return it
    public static void calculateBranchSums(BinaryTree node, int runningSum, List<Integer> sums) {
        if (node == null) return;

        int currentSum = runningSum + node.value;
        if (node.left == null && node.right == null) {
            sums.add(currentSum);
            return;
        }
        calculateBranchSums(node.left, currentSum, sums);
        calculateBranchSums(node.right, currentSum, sums);
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
