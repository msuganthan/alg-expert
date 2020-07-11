package algo_expert.binarySearch;

/**
 * Write a function that takes in a Binary Search Tree and a target integer value
 * and return the closest value to that target value container in the BST.
 *
 * You can assume that there will be one closest value.
 */
public class ClosestValueInBST {

    public static void main(String[] args) {
        BST tree22 = new BST(22);
        BST tree15 = new BST(15);
        BST tree14 = new BST(14);
        BST tree13 = new BST(13);
        BST tree10 = new BST(10);
        BST tree5 = new BST(5);
        BST tree5_2 = new BST(5);
        BST tree2 = new BST(2);
        BST tree1 = new BST(1);

        tree2.left = tree1;
        tree5.left = tree2;
        tree5.right = tree5_2;

        tree10.left = tree5;
        tree10.right = tree15;

        tree15.left = tree13;
        tree15.right = tree22;

        tree13.right = tree14;

        System.out.println(findClosestValueInBst(tree10, 12, Integer.MAX_VALUE));

        System.out.println(findClosestValueInBstUsingRecursion(tree10, 12, Integer.MAX_VALUE));
    }
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
    static int findClosestValueInBst(BST tree, int target, int closest) {
        BST currentNode = tree;
        while (currentNode != null) {
            if (Math.abs(target - closest) > Math.abs(target - currentNode.value))
                closest = currentNode.value;

            if (target < currentNode.value)
                currentNode = currentNode.left;

            else if (target > currentNode.value)
                currentNode = currentNode.right;

            else
                break;
        }
        return closest;
    }

    static int findClosestValueInBstUsingRecursion(BST tree, int target, int closest) {
        if (Math.abs(target - closest) > Math.abs(target - tree.value))
                closest = tree.value;

        if (target < tree.value && tree.left != null)
            return findClosestValueInBstUsingRecursion(tree.left, target, closest);
        else if (target > tree.value && tree.right != null)
            return findClosestValueInBstUsingRecursion(tree.right, target, closest);
        else
            return closest;
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
