package algo_expert.binarySearch;

import java.util.ArrayList;
import java.util.List;

public class BSTTraversal {

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

        List<Integer> inOrderElements = new ArrayList<>();
        inOrderTraverse(tree10, inOrderElements);
        System.out.println("***************In Order***************");
        inOrderElements.stream()
                        .forEach(integer -> System.out.print(integer+ " "));

        List<Integer> preOrderTraverse = new ArrayList<>();
        preOrderTraverse(tree10, preOrderTraverse);
        System.out.println("\n***************Pre Order***************");
        preOrderTraverse.stream()
                        .forEach(integer -> System.out.print(integer+ " "));

        List<Integer> postOrderTraverse = new ArrayList<>();
        postOrderTraverse(tree10, postOrderTraverse);
        System.out.println("\n***************Post Order***************");
        postOrderTraverse.stream()
                        .forEach(integer -> System.out.print(integer+ " "));

    }

    public static List<Integer> inOrderTraverse(BST tree, List<Integer> array) {
        if (tree.left != null)
            inOrderTraverse(tree.left, array);

        array.add(tree.value);

        if (tree.right != null)
            inOrderTraverse(tree.right, array);

        return array;
    }

    public static List<Integer> preOrderTraverse(BST tree, List<Integer> array) {
        array.add(tree.value);

        if (tree.left != null)
            preOrderTraverse(tree.left, array);

        if (tree.right != null)
            preOrderTraverse(tree.right, array);

        return array;
    }

    public static List<Integer> postOrderTraverse(BST tree, List<Integer> array) {
        if (tree.left != null)
            postOrderTraverse(tree.left, array);

        if (tree.right != null)
            postOrderTraverse(tree.right, array);

        array.add(tree.value);

        return array;
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
