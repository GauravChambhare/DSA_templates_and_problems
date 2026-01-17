/*
https://leetcode.com/problems/search-a-2d-matrix-ii/
Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This 
matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
*/

package LeetcodeProblems.Math_and_geometry;

public class SearchA2DMatrixII {

    // Your original approach (nested for-loops)
    public boolean searchMatrixBrutish(int[][] matrix, int target) {
        int n = matrix.length;
        if (n == 0) return false;
        int m = matrix[0].length;
        for (int row = 0; row <= n - 1; row++) {
            // If last element in this row is smaller than target, skip this row
            if (matrix[row][m - 1] < target) continue;
            // Scan this row from right to left
            for (int col = m - 1; col >= 0; col--) {
                if (matrix[row][col] == target) return true;
            }
        }
        return false;
    }

    // Optimized "staircase" search using while-loop: O(m + n)
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        if (n == 0) return false;
        int m = matrix[0].length;
        // Start from top-right corner
        int row = 0;
        int col = m - 1;

        while (row < n && col >= 0) {
            int val = matrix[row][col];
            if (val == target) {
                return true;
            } else if (val > target) {
                // Current value too big → move left (smaller values)
                col--;
            } else {
                // Current value too small → move down (larger values)
                row++;
            }
        }
        return false;
    }

    // Simple local test
    public static void main(String[] args) {
        SearchA2DMatrixII solver = new SearchA2DMatrixII();

        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        System.out.println(solver.searchMatrix(matrix, 5));   // true
        System.out.println(solver.searchMatrix(matrix, 20));  // false
    }
}
