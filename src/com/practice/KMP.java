package com.practice;

import java.util.Arrays;

public class KMP {
    public static void main(String[] args) {
        String concat="aabaabaaa";
        int[] lps = new int[concat.length()];
        lps[0] = 0;
        int i = 0, j = 1;
        while (i < lps.length && j < lps.length) {
            if (concat.charAt(i) == concat.charAt(j)) {
                lps[j] = i + 1;
                i++;
                j++;

            } else {
                if (i == 0) {
                    lps[j] = 0;
                    j++;
                } else {
                    i = lps[i - 1];
                }

            }
        }
        System.out.println(Arrays.toString(lps));
    }
}
