package algo_expert.binarySearch;

/**
 * Write a function that takes in a Binary Search Tree and a target integer value
 * and return the closest value to that target value container in the BST.
 *
 * You can assume that there will be one closest value.
 */
public class ClosestValueInBST {
    //Tree
    //         10
    //       /    \
    //      5     15
    //     / \   /  \
    //    2   5 13  22
    //   /        \
    //  1         14
    //Input:  12
    //Output: 13
    // Try to identify which tree is worth exploring
    //Explore:
    //If target is lesser than tree value and tree.left is not null
    //explore left tree
    //If target is greater than tree value and tree.right is not null
    //explore right tree
    //Update closest when existing closest is greater then current tree value closest

    static int findClosestValueInBst(BST tree, int target) {
        return findClosestValueInBst(tree, target, Double.MAX_VALUE);
    }

    static int findClosestValueInBst(BST tree, int target, double closest) {
        if (Math.abs(target - closest) > Math.abs(target - tree.value))
            closest = tree.value;
        if (target < tree.value && tree.left != null)
            return findClosestValueInBst(tree.left, target, closest);
        else if (target > tree.value && tree.right != null)
            return findClosestValueInBst(tree.right, target, closest);
        else
            return (int) closest;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
          this.value = value;
        }
    }
}
