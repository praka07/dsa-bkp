package com.practice;

import java.util.Arrays;

public class AddOrNotBinarySearch {
    int[] prefix;

    public int[] solve(int[] A, int B) {
        Arrays.sort(A);
        int n = A.length;
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        prefix = new int[A.length+1];
        prefix[0] = 0;
        int max = 0;
        for (int i = 0; i < n ; i++) {
            prefix[i + 1] = prefix[i] + A[i];
        }
        for (int i = 0; i <= n - 1; i++) {
            int low = 1, high = i + 1;
            while (low <= high) {
                int count = (low + high) / 2;
                if (check(count, B, A, i)) {
                    max = count;
                    low = count + 1;

                } else {
                    high = count - 1;
                }
            }
            if (ans[0] < max) {
                ans[0] = max;
                ans[1] = A[i];

            }
        }
        return ans;
    }

    public boolean check(int count, int B, int[] A, int i) {
        if ((A[i] * count) - (prefix[i + 1] - prefix[i - count + 1]) <= B) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        AddOrNotBinarySearch object = new AddOrNotBinarySearch();
        System.out.println(" " + Arrays.toString(object.solve(new int[]{5,5,5}, 4)));

    }
}
