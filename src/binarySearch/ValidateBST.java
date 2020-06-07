package binarySearch;

/**
 * Write a function that takes in a potentially invalid BST and returns a boolean
 * representing whether the BST is valid.
 *
 */
public class ValidateBST {

    public static boolean validateBst(BST tree) {
        //Left  tree is valid if all the value is lesser  than the current node.
        //Right tree is valid if all the value is greater than the current node.
        return validateBst(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    static boolean validateBst(BST tree, int minValue, int maxValue) {
        //The tree's value should be greater than the minValue
        //The tree's value should be lesser  than the maxValue
        if (tree.value < minValue || tree.value >= maxValue)
            return false;

        if (tree.left != null && !validateBst(tree.left, minValue, tree.value))
            return false;

        if (tree.right != null && !validateBst(tree.right, tree.value, maxValue))
            return false;
        return true;
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
