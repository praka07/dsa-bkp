package com.practice;

import java.sql.PreparedStatement;

public class FibRecursion {
    public static void main(String[] args) {
        int f = 0;
        int s = 1;
        int result = 0;
        for (int i = 2; i <= 5; i++) {
            result = f + s;
            f = s;
            s = result;

        }
        System.out.println(result);
        FibRecursion object = new FibRecursion();
        System.out.println(object.recursionFib(5));
    }

    public int recursionFib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int ans = recursionFib(n - 1) + recursionFib(n - 2);
        return ans;

    }
}
