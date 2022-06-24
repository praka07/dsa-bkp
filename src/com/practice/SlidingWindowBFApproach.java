package com.practice;

public class SlidingWindowBFApproach {
    public static void main(String[] args) {
        int[] A = {2, 5, -1, 7, -3, -1, -2};
        int k = 4;
        int maxEle = Integer.MIN_VALUE;
        for (int i = 0; i <= A.length - k; i++) {
            maxEle = A[i];
            for (int j = 1; j < k; j++) {
               // System.out.print(" " + A[j]);
                if (A[i + j] > maxEle) {
                    maxEle = A[i + j];
                }
            }
            System.out.println(maxEle);
        }
    }
}
