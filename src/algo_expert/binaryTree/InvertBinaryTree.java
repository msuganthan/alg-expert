package algo_expert.binaryTree;

/**
 * Write a function that takes in a Binary Tree and inverts it. In other words, the function
 * should swap every left node in the tree for its corresponding right node.
 */

public class InvertBinaryTree {

    static void invertBinaryTree(BinaryTree tree) {
        if (tree == null)
            return;
        swapLeftAndRight(tree);
        invertBinaryTree(tree.left);
        invertBinaryTree(tree.right);
    }

    static void swapLeftAndRight(BinaryTree tree) {
        BinaryTree temp = tree.left;
        tree.left = tree.right;
        tree.right = temp;
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
        }
    }
}
