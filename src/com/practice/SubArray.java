package com.practice;

import java.util.*;

public class SubArray {
    public int countSubArray(int[] A) {
        int MOD = (int) 10e9 + 7;
        System.out.println(MOD);
        HashMap<Long, Boolean> hashMap = new HashMap<Long, Boolean>();
        Long s = 0l;
        for (int i = 0; i < A.length; i++) {
            s += A[i];
            if (s == 0 || hashMap.containsKey(s) || A[i] == 0) {
                return 1;
            }
            hashMap.put(s, true);
        }
        return 0;

    }

    public int threeSumClosest(int[] A, int B) {
        Arrays.sort(A);
        int i;
        int j;
        int k = 0;
        int min = Integer.MAX_VALUE;
        int ans = 0;
        for (k = 0; k < A.length - 2; k++) {
            i = k + 1;
            j = A.length - 1;
            while (i < j) {
                int sum = A[i] + A[j] + A[k];
                if (Math.abs(B - sum) < min) {
                    min = Math.abs(B - sum);
                    ans = sum;
                }
                if (sum > B) {
                    j--;
                } else {
                    i++;
                }

            }

        }
        return ans;
    }

    public static void main(String[] args) {
        SubArray object = new SubArray();
        System.out.println(" " + object.countSubArray(new int[]{-1, 1}));


    }
}
