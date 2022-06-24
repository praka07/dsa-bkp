package com.practice;

import java.util.Arrays;

public class InversionCount {
    public int solve(int[] A) {
        return mergeSort(A, 0, A.length - 1);
    }

    private int mergeSort(int[] a, int l, int right) {
        int count = 0;
        if (l < right) {
            int mid = (l + right) / 2;

            count += mergeSort(a, l, mid);
            count = count % 1000000007;
            count += mergeSort(a, mid + 1, right);

            count = count % 1000000007;
            count += mergeArray(a, l, mid + 1, right);

            count = count % 1000000007;
        }

        return count;


    }

    private int mergeArray(int[] a, int l, int mid, int right) {
        int k = l, ic = 0;
        int leftSubArray[] = Arrays.copyOfRange(a, l, mid); //123
        int rightSubArray[] = Arrays.copyOfRange(a, mid, right + 1);
        int i = 0, j = 0;
        System.out.println("leftSubArray "+Arrays.toString(leftSubArray));
        System.out.println("rightSubArray "+Arrays.toString(rightSubArray));
        while (i < leftSubArray.length && j < rightSubArray.length) {
            if (leftSubArray[i] <= rightSubArray[j]) {
                a[k++] = leftSubArray[i];
                i++;
            } else {
                a[k++] = rightSubArray[j];
                j++;
                ic += (mid) - (l + i);
                ic = ic % 1000000007;

            }

        }
        while (i < leftSubArray.length) {
            a[k++] = leftSubArray[i];
            i++;
        }
        while (j < rightSubArray.length) {
            a[k++] = rightSubArray[j];
            j++;
        }
        // System.out.print(Arrays.toString(a));
        return ic;
    }

    public static void main(String[] args) {
        int[] A = new int[]{45, 25, 19,12,9,6,2};
        InversionCount inversionCount = new InversionCount();
        System.out.println("final result " + inversionCount.solve(A));


    }
}
