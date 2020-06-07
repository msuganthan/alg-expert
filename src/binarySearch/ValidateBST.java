package binarySearch;

/**
 * Write a function that takes in a potentially invalid BST and returns a boolean
 * representing whether the BST is valid.
 *
 */
public class ValidateBST {

    //Tree
    //         10
    //       /    \
    //      5     15
    //     / \   /  \
    //    2   5 13  22
    //   /        \
    //  1         14
    // The node 5 is value if it less than 10
    // In other word
    //  tree.left.value is valid
    //  if
    //      tree.left.value(value) < tree.value (maxValue)
    //
    public static boolean validateBst(BST tree) {
        //Left  tree is valid if all the value is lesser  than the current node.
        //Right tree is valid if all the value is greater than the current node.
        return validateBst(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    static boolean validateBst(BST tree, int minValue, int maxValue) {
        if (tree == null)
            return true;

        //[Left tree] If the value is lesser  than           min value
        //[rigt tree] If the value is greater than or equals max value
        //Then the tree is invalid
        if (tree.value < minValue || tree.value >= maxValue)
            return false;

        return validateBst(tree.left, minValue, tree.value) && validateBst(tree.right, tree.value, maxValue) ;
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
