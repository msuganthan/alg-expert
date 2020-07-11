package algo_expert.binarySearch;

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
     * Remove: It is a two step process
     * 1. Find the value
     * 2. Remove the value
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
        public BST right;

        public BST(int vlue) {
            this.value = vlue;
        }

        public BST insert(int value) {
            BST currentNode = this;
            while(currentNode != null) {
                if (value > currentNode.value) {
                    if (currentNode.right == null) {
                        BST newNode = new BST(value);
                        currentNode.right = newNode;
                        break;
                    } else
                        currentNode = currentNode.right;
                } else {
                    if (currentNode.left == null) {
                        BST newNode = new BST(value);
                        currentNode.left = left;
                        break;
                    } else
                        currentNode = currentNode.left;
                }
            }
            return currentNode;
        }

        public boolean contains(int value) {
            BST currentNode = this;
            while (currentNode != null) {
                if (value < currentNode.value)
                    currentNode = currentNode.left;
                else if (value > currentNode.value)
                    currentNode = currentNode.right;
                else //This one I am having doubts
                    return true;
            }
            return false;
        }

        //When you call the remove method on the root node, the parent node is null.
        public void remove(int value, BST parentNode) {
            BST currentNode = this;
            while (currentNode != null) {
                if (value < currentNode.value) {
                    parentNode = currentNode;
                    currentNode = currentNode.left;
                } else if (value > currentNode.value) {
                    parentNode = currentNode;
                    currentNode = currentNode.right;
                } else {
                    if (currentNode.left != null && currentNode.right != null) {
                        currentNode.value = currentNode.right.getMinValue();
                        currentNode.right.remove(currentNode.value, currentNode);
                    } else if (parentNode == null) {
                        if (currentNode.left != null) {
                            currentNode.value = currentNode.left.value;
                            currentNode.right = currentNode.left.right;
                            currentNode.left  = currentNode.left.left;
                        } else  if (currentNode.right != null) {
                            currentNode.value = currentNode.right.value;
                            currentNode.left  = currentNode.right.left;
                            currentNode.right = currentNode.right.right;
                        } else {
                            //Do Nothing
                        }
                    } else if (parentNode.left == currentNode)
                        parentNode.left = currentNode.left != null ? currentNode.left : currentNode.right;
                      else if (parentNode.right == currentNode)
                        parentNode.right = currentNode.left != null ? currentNode.left : currentNode.right;
                      break;
                }
            }
        }

        public int getMinValue() {
            if (left == null)
                return value;
            else
                return left.getMinValue();
        }

    }
}
