package com.practice;

import java.util.Arrays;

public class BoringString {
    public static void main(String[] args) {
        String s = "aabddbc";
        BoringString objeBoringString = new BoringString();
        objeBoringString.solve(s);
    }

    public int solve(String A) {

        StringBuilder evenString = new StringBuilder();
        StringBuilder oddString = new StringBuilder();

        for (int i = 0; i < A.length(); i++) {
          //  System.out.println(A.charAt(i) % 2);
            if (A.charAt(i) % 2 == 0) {
                evenString.append(A.charAt(i));
            } else {
                oddString.append(A.charAt(i));
            }
        }
        char[] even = evenString.toString().toCharArray();
        char[] odd = oddString.toString().toCharArray();
        Arrays.sort(even);
        Arrays.sort(odd);
        if(even.length==0 || odd.length==0){
            return 1;
        }
        if (isValid(odd.toString(), even.toString())) {
            return 1;
        } else if (isValid(even.toString(), odd.toString())) {
            return 1;
        }
        return 0;
    }

    boolean isValid(String a, String b) {

        return Math.abs(a.charAt(0) - b.charAt(b.length() - 1)) != 1;

    }
}
