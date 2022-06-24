package com.practice;

import java.util.Arrays;

public class DutchNationalFlagTwo {
    public static void main(String[] args) {
        int[] input = {-12, 11, -13, 5, 6, -7};
        int low = 0, high = input.length - 1;
        while (low <= high) {
            if (input[low] <= 0) {
                low++;

            } else {
                int temp = input[low];
                input[low] = input[high];
                input[high] = temp;
                high--;
            }
        }
        System.out.println(Arrays.toString(input));
    }
}
