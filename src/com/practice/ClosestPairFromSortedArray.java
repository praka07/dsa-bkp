package com.practice;

import java.util.Arrays;

public class ClosestPairFromSortedArray {
    public static void main(String[] args) {
        ClosestPairFromSortedArray object = new ClosestPairFromSortedArray();
        int[] A = {1, 2, 3, 4, 5};
        int[] B = {2, 4, 6, 8};
        int C = 9;
        System.out.println(" " + Arrays.toString(object.solve(A, B, C)));
    }

    public int[] solve(int[] A, int[] B, int C) {
        int maxx = Integer.MAX_VALUE;
        int firstIndex = 0, lastIndex = 0;
        int i = 0, j = B.length - 1;
        while (i < A.length && j >= 0) {
            if (Math.abs(A[i] + B[j] - C) < maxx) {
                firstIndex = i;
                lastIndex = j;
                maxx = Math.abs(A[i] + B[j] - C);
            } else if (Math.abs(A[i] + B[j] - C) == maxx && firstIndex == i) {
                lastIndex = j;
            }
            if (A[i] + B[j] > C)
                j--;
            else
                i++;
        }
        return new int[]{firstIndex, lastIndex};

    }
}
