package com.practice;

public class UnderStandBinary {
    public int binarySearch(int[] A, int k) {
        int start = 0, end = A.length - 1, res = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (k < A[mid]) {
                end = mid - 1;
            } else if (A[mid] < k) {
                start = mid + 1;
            } else {
                res = mid;
                start = mid + 1;
            }

        }
        return res;

    }

    public static void main(String[] args) {
        UnderStandBinary objeUnderStandBinary = new UnderStandBinary();
        System.out.println("" + objeUnderStandBinary.binarySearch(new int[]{2, 4, 10, 10, 10, 10, 10, 10, 10, 10, 18, 20, 20, 27}, 10));

    }
}
