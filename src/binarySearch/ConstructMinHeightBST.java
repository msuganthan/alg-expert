package binarySearch;

import java.util.List;

public class ConstructMinHeightBST {
    public static BST minHeightBst(List<Integer> array) {
    // Write your code here.
    return constructMinHeightBst(array, 0, array.size() - 1);
  }

	static BST constructMinHeightBst(List<Integer> array, int startIndex, int endIndex) {
		if(endIndex < startIndex ) return null;
		int midIndex = (startIndex + endIndex) / 2;
		BST bst   = new BST(array.get(midIndex));
		bst.left  = constructMinHeightBst(array, startIndex, midIndex - 1);
		bst.right = constructMinHeightBst(array, midIndex + 1, endIndex);
		return bst;

	}

  static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
      left = null;
      right = null;
    }

    public void insert(int value) {
      if (value < this.value) {
        if (left == null) {
          left = new BST(value);
        } else {
          left.insert(value);
        }
      } else {
        if (right == null) {
          right = new BST(value);
        } else {
          right.insert(value);
        }
      }
    }
  }
}
