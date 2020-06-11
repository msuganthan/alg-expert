package miscellaneous.binaryTree;

public class DepthFirstSearch {

    public static void main(String[] args) {
        BinaryTree root = new BinaryTree("root");
        //==================Level One====================
        BinaryTree node1 = new BinaryTree("node1");
        BinaryTree node2 = new BinaryTree("node2");
        root.left        = node1;
        root.right       = node2;

        //=================Level Two====================
        BinaryTree node3 = new BinaryTree("node3");
        BinaryTree node4 = new BinaryTree("node4");
        node1.left       = node3;
        node1.right      = node4;

        BinaryTree node5 = new BinaryTree("node5");
        BinaryTree node6 = new BinaryTree("node6");
        node2.left       = node5;
        node2.right      = node6;

        //=================Level Three===================
        BinaryTree node7 = new BinaryTree("node7");
        node3.left       = node7;

        //=================Level Four====================
        BinaryTree node8 = new BinaryTree("node8");
        BinaryTree node9 = new BinaryTree("node9");
        node7.left       = node8;
        node7.right      = node9;

        preOrderTraversal(root);
    }

    static class BinaryTree {
        String value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(String value) {
            this.value = value;
            this.left  = null;
            this.right = null;
        }
    }

    static void preOrderTraversal(BinaryTree node) {
        if(node == null) return;
        System.out.println(node.value);
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }
}
