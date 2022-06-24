package com.practice;

public class MaximumPathTriangle {

    public static void main(String[] args) {
        int[][] a = {{3, 0, 0, 0}, {7, 4, 0, 0}, {2, 4, 6, 0}, {8, 5, 9, 3}};
        MaximumPathTriangle obj = new MaximumPathTriangle();
        System.out.println(obj.solve(a));
    }

    public int solve(int[][] A) {

        int range = A.length;
        int[][] dp = new int[A.length][A.length];

        return findMaxPath(0, 0, range, A, dp);
    }

    public static int findMaxPath(int r, int c, int range, int[][] array, int[][] dp) {

        if (r + 1 >= range) {
            return array[r][c];
        }

        if (dp[r][c] != 0) {
            return dp[r][c];
        }

        int choice1 = array[r][c] + findMaxPath(r + 1, c, range, array, dp);
        int choice2 = array[r][c] + findMaxPath(r + 1, c + 1, range, array, dp);

        dp[r][c] = Math.max(choice1, choice2);

        return dp[r][c];
    }
}
