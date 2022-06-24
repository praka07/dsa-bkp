package com.practice;

public class Pali {
    public static void main(String[] args) {
        String A = "madam";
        int n = A.length();
        int count = 0;
        for (int i = 0; i < n / 2; ++i) {

            if (A.charAt(i) != A.charAt(n - i - 1))

                count++;

        }
        System.out.println(count);
    }
}
