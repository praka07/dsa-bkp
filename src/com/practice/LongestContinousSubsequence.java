package com.practice;

public class LongestContinousSubsequence {
    public static void main(String[] args) {
        int[] a = { 1, 1, 1, 0, 1};
        int maxLength = 0;
        int position = 0;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] == 0) {
                int j = i + 1;
                int k = 0;
                while (j < a.length && a[j] != 0) {
                    k++;
                    j++;
                }
                if (k > maxLength) {
                    maxLength = k;
                    position = i;

                }
            }

        }
        System.out.println(position);
    }
}
