package algo_expert.binaryTree;

/**
 * This distance between a node in a binary tree and the tree's root is called the node's depth.
 */
public class NodeDepth {

    public static void main(String[] args) {
        //Tree
        //           1
        //        /     \
        //       2       3
        //    /    \    /   \
        //   4      5  6     7
        //  /  \   /
        // 8    9 10

        /**
         * The depth of the node 2 is 1
         * The depth of the node 3 is 1
         * The depth of the node 4 is 2
         * The depth of the node 5 is 2
         * ....
         * Sum up all the node depths you will get 19
         */

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

        System.out.println(nodeDepths(tree1));
    }

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
