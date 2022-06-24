package com.practice;

public class SpecialInteger {
    public int solve(int[] A, int B) {
        int i = 0, j = 0, k = 0, ans = 0;
        while (i < A.length && j < A.length) {
            if (A[i] < B && A[j] < B) {
                ans += 1;
                i++;
                j++;
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        SpecialInteger object = new SpecialInteger();
        int[] A = new int[]{5, 7, 100, 11};
        System.out.println(" result :::" + object.solve(A, 130));

    }
}
