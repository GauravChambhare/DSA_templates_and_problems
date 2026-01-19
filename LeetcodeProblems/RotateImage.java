package LeetcodeProblems;

// https://neetcode.io/problems/rotate-matrix/question
public class RotateImage {

    // Same method signature LeetCode uses
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // 1) Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // 2) Reverse each row
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n / 2; col++) {
                int temp = matrix[row][n - col - 1];
                matrix[row][n - col - 1] = matrix[row][col];
                matrix[row][col] = temp;
            }
        }
    }

    // Optional: simple main to test locally
    public static void main(String[] args) {
        RotateImage ri = new RotateImage();
        int[][] matrix = {
                {1, 2},
                {3, 4}
        };

        ri.rotate(matrix);

        // print result
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
        // Expected:
        // 3 1
        // 4 2
    }
}
