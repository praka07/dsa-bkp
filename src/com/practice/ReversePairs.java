package com.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class ReversePairs {
    public int solve(int[] A) {
        return mergeSort(A, 0, A.length - 1);
    }

    private int mergeSort(int[] a, int l, int right) {
        System.out.println(" i am called " + right);

        if (l >= right)
            return 0;

        int mid = (l + right) / 2;
        int count = mergeSort(a, l, mid);
        count += mergeSort(a, mid + 1, right);
        count += mergeArray(a, l, mid + 1, right);


        return count;


    }

    private int mergeArray(int[] a, int l, int mid, int high) {
        int count = 0;
        int j = mid;
        for (int i = l; i < mid; i++) {
            while (j <= high && a[i] > 2L * a[j]) {
                j++;
                count += (mid - i);

            }


        }
        ArrayList<Integer> temp = new ArrayList<Integer>();
        int lef = l, right = mid;
        while (lef < mid && right <= high) {
            if (a[lef] <= a[right]) {
                temp.add(a[lef++]);
            } else {
                temp.add(a[right++]);
            }
        }

        while (lef < mid) {
            temp.add(a[lef++]);
        }
        while (right <= high) {
            temp.add(a[right++]);
        }
        for (int i = l; i <= high; i++) {
            a[i] = temp.get(i - l);
        }

        return count;

    }



    public static void main(String[] args) {
        int[] A = new int[]{40, 25, 19, 12, 9, 6, 2};
        ReversePairs inversionCount = new ReversePairs();
        System.out.println("ppppppp" + 1 / 2);
        System.out.println("final result " + inversionCount.solve(A));
    }
}
