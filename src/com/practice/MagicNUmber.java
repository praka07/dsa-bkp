package com.practice;

import java.util.Arrays;

public class MagicNUmber {
    public int[] solve(int[] A) {
        Arrays.sort(A);
        int n = A.length;
        int mod = 1000000007;
        int min = 0;
        int max = 0;
        for (int i = 0; i < n-1; i += 2) {
            min = Math.abs(A[i] - A[i + 1]);
            min %= 1000000007;

        }
        for (int i = 0; i < n / 2; i++) {
            max += Math.abs(A[i] - A[n / 2 + i]);
            max %= 1000000007;

        }
        return new int[]{max, min};

    }

    public static void main(String[] args) {
        int[] A = new int[]{3, 11, -1, 5};
        MagicNUmber oMagicNUmber = new MagicNUmber();
        System.out.println("" + Arrays.toString(oMagicNUmber.solve(A)));

    }
}
