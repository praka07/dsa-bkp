package com.practice;


import java.util.Arrays;

public class CheckPattern {
    public static void main(String[] args) {
        String B = "1010";
        String A = "0101";
        String text = B + B;
        String pattern = A;
        int[] lps = new int[pattern.length()];
        int i = 0, j = 1;
        lps[0] = 0;
        while (i < lps.length && j < lps.length) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
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
        System.out.println("Result " + Arrays.toString(lps));
        int k = 0, l = 0;
        while (k < text.length()) {
            if (text.charAt(k) == pattern.charAt(l)) {
                k++;
                l++;
            } else {
                l = lps[l];
                k++;


            }

        }
    }
}
