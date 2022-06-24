package com.practice;

public class SearchForRangeBinarySearch {
    public int[] searchRange(final int[] A, int B) {
        int[] result = new int[2];
        result[0] = first(A, B, A.length);
        result[1] = last(A, B, A.length);
        return result;
    }

    static int first(int arr[],
                     int x, int n) {
        int low = 0, high = n - 1,
                res = -1;
        while (low <= high) {
            // Normal Binary Search Logic
            int mid = (low + high) / 2;
            if (arr[mid] > x)
                high = mid - 1;
            else if (arr[mid] < x)
                low = mid + 1;

                // If arr[mid] is same as
                // x, we update res and
                // move to the left half.
            else {
                res = mid;
                high = mid - 1;
            }
        }
        return res;
    }

    static int last(int arr[], int x, int n) {
        int low = 0, high = n - 1,
                res = -1;
        while (low <= high) {
            // Normal Binary Search Logic
            int mid = (low + high) / 2;
            if (arr[mid] > x)
                high = mid - 1;
            else if (arr[mid] < x)
                low = mid + 1;

                // If arr[mid] is same as x,
                // we update res and move to
                // the right half.
            else {
                res = mid;
                low = mid + 1;
            }
        }
        return res;
    }
}
