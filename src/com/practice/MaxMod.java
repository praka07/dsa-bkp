package com.practice;

public class MaxMod {
    public int solve(int[] A) {
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for (int i = 0; i < A.length - 1; i++) {
            if (first < A[i]) {
                second = first;
                first = A[i];
            } else if (second < A[i] && A[i] != first) {
                second = A[i];
            }

        }

        if (second == Integer.MIN_VALUE) {
            return second;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {

    }
}
