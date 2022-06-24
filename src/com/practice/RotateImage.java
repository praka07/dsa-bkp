package com.practice;

import java.util.Arrays;

public class RotateImage {
    public static void main(String[] args) {
        int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] result= new int[array.length][array[0].length];
        for (int i = 0,k=0; i < array.length; i++,k++) {
            for (int j = array[i].length-1,l=0; j>=0; j--,l++) {
                result[k][l] = array[j][i];
            }
        }
        System.out.println(" result "+ Arrays.deepToString(result));
    }
}
