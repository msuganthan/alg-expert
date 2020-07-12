package algo_expert.binaryTree;

/**
 * This distance between a node in a binary tree and the tree's root is called the node's depth.
 */
public class NodeDepth {

    static int nodeDepths(BinaryTree root) {
        return nodeDepthHelper(root, 0);
    }

    static int nodeDepthHelper(BinaryTree root, int depth) {
        if (root == null)
            return 0;
        return depth + nodeDepthHelper(root.left, depth + 1) + nodeDepthHelper(root.right, depth + 1);
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
