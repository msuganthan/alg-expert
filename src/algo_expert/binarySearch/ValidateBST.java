package algo_expert.binarySearch;

/**
 * Write a function that takes in a potentially invalid BST and returns a boolean
 * representing whether the BST is valid.
 *
 */
public class ValidateBST {

    public static void main(String[] args) {
        //Tree
        //         10
        //       /    \
        //      5     15
        //     / \   /  \
        //    2   5 13  22
        //   /        \
        //  1         14

        BST tree22  = new BST(22);
        BST tree15  = new BST(15);
        BST tree14  = new BST(14);
        BST tree13  = new BST(13);
        BST tree10  = new BST(10);
        BST tree5   = new BST(5);
        BST tree5_2 = new BST(5);
        BST tree2   = new BST(2);
        BST tree1   = new BST(1);

        tree2.left = tree1;
        tree5.left = tree2;
        tree5.right = tree5_2;

        tree10.left = tree5;
        tree10.right = tree15;

        tree15.left = tree13;
        tree15.right = tree22;

        tree13.right = tree14;

        System.out.println(validateBst(tree10));
    }

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
        return isValid(tree, null, null);
    }

    public static boolean isValid(BST tree, Integer lowerLimit, Integer upperLimit) {
		if (tree == null)
            return true;

        /**
         * For left tree
         * If left tree's value is greater than or equals upperLimit return false.
         */
        if (upperLimit != null && tree.value >= upperLimit)
            return false;

        /**
         * For right tree
         * If right tree's value is lesser then lower limit return false
         */
        if (lowerLimit != null && tree.value < lowerLimit)
            return false;

        return isValid(tree.left, lowerLimit, tree.value) && isValid(tree.right, tree.value, upperLimit);
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
