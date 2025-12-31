package Temp_random_questions;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {

    public ArrayList<Integer> boundaryTraversal(int mat[][]) {
        // code here
        int bottom = mat.length;
        int right = mat[0].length;
        int left = 0, top = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        
        while(right>left){
            ans.add(mat[top][left]);
            left++;
        }
        left--;
        top++;
        while(top<bottom){
            ans.add(mat[top][left]);
            top++;
        }
        top--;
        left--;
        while(left>=0){
            ans.add(mat[top][left]);
            left--;
        }
        left++;
        top--;
        while(top>=1){
            ans.add(mat[top][left]);
            top--;
        }
        return ans;
    }

    public void temp(){
        PriorityQueue q = new ArrayList<>();
        
    }
    public static void main(String[] args) {
        // Example: read matrix from input and print boundary traversal
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int n = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int m = sc.nextInt();

        int[][] mat = new int[n][m];
        System.out.println("Enter matrix elements row-wise:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        Solution sol = new Solution();
        ArrayList<Integer> res = sol.boundaryTraversal(mat);

        System.out.println("Boundary traversal:");
        for (int x : res) {
            System.out.print(x + " ");
        }
        System.out.println();

        sc.close();
    }

}
