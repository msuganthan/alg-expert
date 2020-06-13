package algo_expert.searching;

/**
 * You are given a two dimensional array of distinct integer and a target integer. Each row in the matrix
 * is sorted and each column is also sorted, the matrix doesn't necessarily have the same height and width.
 */
public class SearchInSortedMatrix {
    static int[] searchInSortedMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] > target)
                col--;
            else if (matrix[row][col] < target)
                row++;
            else
                return new int[] {row, col};
        }
        return new int[] {-1, -1};
    }
}
