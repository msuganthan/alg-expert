package binarySearch;

/**
 * Write a BST class for the Binary Search Tree. The class should support
 * 1. Inserting value in the insert method
 * 2. Removing values with the remove method
 * 3. Searching for values with the contains method.
 *
 * Note that you can't remove values from a single-node tree. In other words, calling the remove
 * method on a single node tree should simply not do anything.
 *
 */
public class BSTConstruction {
    /**
     * Insert method
     * --------------------
     *
     * I should know the root in the first place
     *
     * BST currentNode = this
     *
     * while(true) {
     *      if(value < currentNode.value) {
     *         if(currentNode.left == null) {
     *             BST tree = new BST(value);
     *             currentNode.left = tree;
     *             break;
     *         }
     *         else
     *           currentNode = currentNode.left;
     *      }
     *      if(value > currentNode.value) {
     *         if(currentNode.right== null) {
     *             BST tree = new BST(value);
     *             currentNode.right= tree;
     *             break;
     *         }
     *         else
     *           currentNode = currentNode.right;
     *      }
     * }
     *
     * ===============================================================
     *
     * Contains
     * ========
     * BST currentNode = this
     * while(currentNode != null) {
     *    if(currentNode .value == searchValue)
     *     return value;
     *   else if(currentNode.value < searchValue && currentNode.left!= null) {
     *     currentNode = currentNode.left
     *   }
     *   else if(currentNode.value > searchValue && currentNode.right!= null) {
     *      currentNode = currentNode.right
     *   }
     *   return -1;
     * }
     *
     * Remove:
     * ========
     *
     * //it is important to maintain the parent node
     *             //if the value is less than the current node value
     *             //  parent node is current node and current node is left node
     *             //if the value is greater than the current node value
     *             //  parent node is current node and current node is right node
     *             //else
     *             //  you found the value to remove
     *             //  1. Node has both the left and right node
     *             //  2. Parent is null ==> No idea what is this
     *             //      left is not null
     *             //          current.value = current.left.value
     *             //          current.rigt  = current.left.rigt
     *             //          current.left  = current.left.left
     *             //      rigt is not null
     *             //          current.value = current.rigt.value
     *             //          current.rigt  = current.rigt.rigt
     *             //          current.left  = current.rigt.left
     *             //      else
     *             //          No idea what is this.
     *             //  3. Parent.left is current node
     *             //  4. Parent.rigt is current node
     */


    static class BST {
        public int value;
        public BST left;
        public BST rigt;

        public BST(int value) {
            this.value = value;
        }

        public void remove(int value, BST parentNode) {

        }
    }
}
