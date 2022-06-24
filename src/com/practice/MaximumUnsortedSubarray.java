package com.practice;

import java.util.Arrays;

public class MaximumUnsortedSubarray {
    public static void main(String[] args) {
        MaximumUnsortedSubarray maximumUnsortedSubarray = new MaximumUnsortedSubarray();
        System.out.println(";;;; " + maximumUnsortedSubarray.subUnsort(new int[]{1, 1}));
    }

    public int[] subUnsort(int[] A) {
        int[] copy = new int[A.length];
        copy = Arrays.copyOf(A, A.length);
        int leftMostIndex = -1, rightMostIndex = -1;
        for (int start = 0; start < A.length; start++) {
            if (A[start] != copy[start]) {
                leftMostIndex = start;
                break;
            }
        }

        if (leftMostIndex == -1) {
            return new int[]{-1};
        }

        for (int start = A.length - 1; start >= 0; start--) {
            if (A[start] != copy[start]) {
                rightMostIndex = start;
                break;
            }
        }

        return new int[]{leftMostIndex, rightMostIndex};

    }

}
