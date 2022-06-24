package com.practice;

/**
 * Slow method of pattern matching
 */
public class PatternMatching {
    public static void main(String[] args) {
        String text = "prakash";
        String pattern = "kash";
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < text.length() && j < pattern.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                j = 0;
                k++;
                i = k;
            }
        }
        if (j == pattern.length()) {
            System.out.println("pattern matched");
        } else {
            System.out.println("pattern not matched");
        }
    }
}
