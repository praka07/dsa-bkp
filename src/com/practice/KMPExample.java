package com.practice;

public class KMPExample {
    public static void main(String[] args) {
        String text = "prakash";
        String pattern = "kasah";
        int[] lps = new int[pattern.length()];
        lps[0] = 0;
        int i = 0, j = 1;
        while (i < pattern.length() && j < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                if (i == 0) {
                    lps[j] = 0;
                    j++;
                } else {
                    i = lps[i = 1];

                }
            }

        }
        int texti = 0, patternj = 0;
        while (texti < text.length() && patternj < pattern.length()) {
            if (text.charAt(texti) == pattern.charAt(patternj)) {
                texti++;
                patternj++;
            } else {
                if (patternj == 0) {
                    texti++;
                } else
                    patternj = lps[patternj - 1];
                }
            }


        if (patternj == pattern.length()) {
            System.out.println("matched");
        } else {
            System.out.println("not matched");
        }

    }
}
