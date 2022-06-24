package com.practice;

public class SingleElement {
    public int solve(int[] A) {
        int high = A.length - 1;
        int low = 0;
        int mid;
        if (high == 0) {
            return A[0];
        } else if (A[0] != A[1]) {
            return A[0];
        } else if (A[high] != A[high - 1]) {
            return A[high];

        }
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (A[mid] != A[mid - 1] && A[mid] != A[mid + 1])
                return A[mid];
            if (((mid % 2) == 0) && A[mid] == A[mid + 1] || ((mid % 2) == 1 && A[mid] == A[mid - 1])) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] A = new int[]{13, 13, 21, 21, 27, 50, 50, 102, 102, 108, 108, 110, 110, 117, 117, 120, 120, 123, 123, 124, 124, 132, 132, 164, 164, 166, 166, 190, 190, 200, 200, 212, 212, 217, 217, 225, 225, 238, 238, 261, 261, 276, 276, 347, 347, 348, 348, 386, 386, 394, 394, 405, 405, 426, 426, 435, 435, 474, 474, 493, 493};
        SingleElement inversionCount = new SingleElement();
        System.out.println("final result " + inversionCount.solve(A));
    }
}
