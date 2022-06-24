package com.practice;

import java.util.Arrays;

public class LargerNumber {
    public String largestNumber(final int[] A) {
        StringBuilder result = new StringBuilder();
        String[] s = new String[A.length];
        for (int i = 0; i < A.length; i++)
            s[i] = String.valueOf(A[i]);
        Arrays.sort(s, (a, b) -> (b + a).compareTo(a + b));
        for (String str : s) {
            result.append(str);
        }


        return result.toString().startsWith("0") ? "0" : result.toString();
    }

    public static void main(String[] args) {

    }
}
