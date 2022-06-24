package com.practice;

import java.util.Arrays;

public class Z {
    public static void main(String[] args) {
        String s = "abcdab";
        for (int i = 0; i < s.length() - 1; i++) {
            int j = 0;
            while (i + j < s.length() && s.charAt(i) == s.charAt(i+j)) {
                j++;
            }
        }
//        int[] Z = constructZArray(s);
//        for (int i = 1; i < s.length(); i++) {
//            if (i+Z[i] == s.length())
//
//                System.out.println(i);
//        }
//        System.out.println(-1);

    }

    public static int[] constructZArray(String A) {
        int L = 0, R = 0;
        int n = A.length();
        int[] z = new int[A.length()];
        for (int i = 1; i < n; i++) {
            if (i > R) {
                L = R = i;
                while (R < n && A.charAt(R - L) == A.charAt(R)) {
                    R++;
                }
                z[i] = R - L;
                R--;
            } else {
                int k = i - L;
                if (z[k] < R - i + 1) {
                    z[i] = z[k];
                } else {
                    L = i;
                    while (R < n && A.charAt(R - L) == A.charAt(R)) {
                        R++;
                    }
                    z[i] = R - L;
                    R--;
                }
            }
        }
        return z;
    }
}
