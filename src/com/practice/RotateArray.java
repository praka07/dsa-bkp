package com.practice;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;


        reverse(input, k + 1, input.length);
        reverse(input, 0, k + 1);
        reverse(input, 0, input.length);
        // System.out.println(" result " + Arrays.toString(input));
    }

    public static void reverse(int[] intArray, int start, int end) {
        int n = start + end;
        for (int i = start; i < n / 2; i++) {
            int temp = intArray[i];
            intArray[i] = intArray[n - i - 1];
            intArray[n - i - 1] = temp;
        }
        System.out.println(" result - " + Arrays.toString(intArray));
    }
}
