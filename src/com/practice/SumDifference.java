package com.practice;

import java.util.Arrays;

public class SumDifference {
    public static void main(String[] args) {
        SumDifference sumDifference = new SumDifference();
        System.out.println(sumDifference.solve(new int[]{5, 4, 2}));
    }

    public int power(int x, int y) {
        if (y == 0)
            return 1;
        else if (y % 2 == 0)
            return power(x, y / 2) * power(x, y / 2);
        else
            return x * power(x, y / 2) * power(x, y / 2);
    }

    public int solve(int[] A) {
        Arrays.sort(A);
        long max = 0;
        long min = 0;
        int mod = 1000000007;
        for (int i = 0; i < A.length; i++) {

            max += A[i] * power(2, i);


        }
        int n = A.length - 1;
        for (int i = n; i >= 0; i--) {
            min += A[i] * power(2, n - i);
        }
        System.out.println("Answer "+(max-min));

        return (int)Math.abs(max - min )% mod;
    }

}
