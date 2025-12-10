/*
 * https://neetcode.io/problems/set-zeroes-in-matrix?list=blind75
*/

package Blind75.Math_and_geometry;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        List<Integer> ans = new ArrayList<>();

        while (top <= bottom && left <= right) {

            // --->
            for (int col = left; col <= right; col++) {
                ans.add(matrix[top][col]);
            }
            top++;

            // down
            for (int row = top; row <= bottom; row++) {
                ans.add(matrix[row][right]);
            }
            right--;

            if (top <= bottom) {
                // <---
                for (int col = right; col >= left; col--) {
                    ans.add(matrix[bottom][col]);
                }
                bottom--;
            }

            if (left <= right) {
                // up
                for (int row = bottom; row >= top; row--) {
                    ans.add(matrix[row][left]);
                }
                left++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // Option 1: read matrix from input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int n = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int m = sc.nextInt();

        int[][] matrix = new int[n][m];
        System.out.println("Enter matrix elements row-wise:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        SpiralMatrix sm = new SpiralMatrix();
        List<Integer> res = sm.spiralOrder(matrix);

        System.out.println("Spiral order:");
        for (int x : res) {
            System.out.print(x + " ");
        }
        System.out.println();

        sc.close();

        // Option 2: quick hardcoded test (uncomment to use)
        /*
        int[][] matrix2 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        List<Integer> res2 = sm.spiralOrder(matrix2);
        System.out.println(res2);
        */
    }
}
