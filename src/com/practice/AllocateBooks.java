package com.practice;

import java.util.Arrays;

public class AllocateBooks {
    public int books(int[] A, int B) {
        int low = 0, high = Arrays.stream(A).sum(), ans = -1;
        if (A.length < B) return -1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (isValidAllocation(A, mid, B)) {
                ans = mid;
                high = mid - 1;

            } else {
                low = mid + 1;

            }

        }
        return ans;

    }

    private boolean isValidAllocation(int[] a, int mid, int student) {
        int allocatedStudent = 1, pages = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] > mid)
                return false;
            if (pages + a[i] > mid) {
                allocatedStudent += 1;
                pages = a[i];
            } else {
                pages+= a[i];
            }
        }
        if (allocatedStudent > student) {
            return false;
        } else {
            return true;
        }

    }

    public static void main(String[] args) {
        AllocateBooks object = new AllocateBooks();
        System.out.println("Answer ::: " + object.books(new int[]{73, 58, 30, 72, 44, 78, 23, 9}, 5));

    }
}
