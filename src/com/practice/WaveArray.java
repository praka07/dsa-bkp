package com.practice;

import java.util.Arrays;

public class WaveArray {
    public int[] wave(int[] A) {
        Arrays.sort(A);
        for (int i = 0; i < A.length - 1; i = i + 2) {
            System.out.println("i value " + i);
            swap(A, i, i + 1);


        }
        return A;
    }

    private void swap(int[] a, int i, int i1) {
        int temp = a[i];
        a[i] = a[i1];
        a[i1] = temp;
    }

    public int solve(int[] A) {
        Arrays.sort(A);
        int i = 1, j = 0, ans = 0;
        while (i < A.length) {
            if (i >= A[j]) {
                ans += i - A[j];
                i++;
                j++;
            } else {
                i = A[j] + 1;
                j++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {5, 1, 3, 2, 4};
        WaveArray object = new WaveArray();
        System.out.println("output " + Arrays.toString(object.wave(A)));

    }
}
