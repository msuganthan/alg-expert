package algo_expert.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Function that takes in an x m two dimensional algo_expert.array and returns a one-dimensional algo_expert.array
 * of all the algo_expert.array's elements in spiral order.
 *
 * Spiral order start at the top left corner of the two-dimensional algo_expert.array, goes to the right
 * and proceeds in a spiral pattern all the way until every element has been visited.
 */
public class SpiralFill {
	public static void main(String[] args) {
		int[][] array = {{1, 2, 3, 4},
						 {12, 13, 14, 5},
						 {11, 16, 15, 6},
						 {10, 9, 8, 7}};
		List<Integer> spiralList = spiralTraverse(array);
		spiralList.stream()
				  .forEach(System.out::print);
	}

    public static List<Integer> spiralTraverse(int[][] array) {

        if(array.length == 0) return new ArrayList<>();

		List result = new ArrayList<Integer>();
		spiralFill(array, 0, array.length - 1, 0, array[0].length - 1, result);
        return result;
    }

	public static void spiralFill(int[][] array, int startRow, int endRow, int startCol, int endCol, List<Integer> result) {

		if (startRow > endRow || startCol > endCol)
			return;

		for (int col = startCol; col <= endCol; col++)
			result.add(array[startRow][col]);

		for (int row = startRow + 1; row <= endRow; row++) 
			result.add(array[row][endCol]);

		for (int col = endCol - 1; col >= startCol ; col--) {
			if (startRow == endRow) break;
			result.add(array[endRow][col]);
		}

		for (int row = endRow - 1; row >= startRow + 1; row--) {
			if (startCol == endCol) break;
			result.add(array[row][startCol]);
		}

		spiralFill(array, startRow + 1, endRow - 1, startCol + 1, endCol -1, result);
		
	}
}
