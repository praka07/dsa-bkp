package com.practice;

public class ReverseNumberRecursion {
    public static void main(String[] args) {
        int n = 841;
        System.out.println(reverseNumber(n, 0));
    }

    private static int reverseNumber(int n, int sum) {
        if (n % 10 == n) {
            return n;
        }
        int r = n % 10;
        sum = sum * 10 + r;
        n = n / 10;
        return reverseNumber(n, sum);

    }
}
