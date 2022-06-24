package com.practice;

import java.util.Arrays;

public class Query2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] prefixSum = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 1; i <=matrix.length; i++) {
            for (int j = 1; j <=matrix[0].length; j++) {
                prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1] + matrix[i-1][j-1];
            }
        }

        System.out.println(Arrays.deepToString(prefixSum));
    }
}
