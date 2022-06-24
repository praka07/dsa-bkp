package com.practice;

import java.util.Arrays;
import java.util.List;

public class MedianArray {
    public double simpleApproach(final List<Integer> a, final List<Integer> b) {
        // declare required variable to iterate array elements
        int i = 0, j = 0, k = 0;
        // merged array declaration
        int[] mergedArray = new int[a.size() + b.size()];
        while (i < a.size() && j < b.size()) {

            if (a.get(i) <= b.get(j)) {
                mergedArray[k] = a.get(i);
                i++;
                k++;

            } else {
                mergedArray[k] = b.get(j);
                j++;
                k++;
            }

        }

        while (i < a.size()) {
            mergedArray[k++] = a.get(i++);
        }
        while (j < b.size()) {
            mergedArray[k++] = b.get(j++);
        }
        if (mergedArray.length % 2 == 1) {
            return mergedArray[(mergedArray.length / 2)];

        } else {
            double first = mergedArray[(mergedArray.length / 2) - 1];
            double second = mergedArray[(mergedArray.length / 2)];
            // System.out.println((first + second) / 2);
            return (first + second) / 2;


        }

    }

    public double bestApproach(int[] a, int[] b) {
        if (b.length < a.length) return bestApproach(b, a);
        int n1 = a.length;
        int n2 = b.length;
        int low = 0, high = n1;

        while (low <= high) {
            int cut1 = (low + high) >> 1;
            int cut2 = (n1 + n2 + 1) / 2 - cut1;


            int left1 = cut1 == 0 ? Integer.MIN_VALUE : a[cut1 - 1];
            int left2 = cut2 == 0 ? Integer.MIN_VALUE : b[cut2 - 1];

            int right1 = cut1 == n1 ? Integer.MAX_VALUE : a[cut1];
            int right2 = cut2 == n2 ? Integer.MAX_VALUE : b[cut2];


            if (left1 <= right2 && left2 <= right1) {
                if ((n1 + n2) % 2 == 0)
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                else
                    return Math.max(left1, left2);
            } else if (left1 > right2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }
        }
        return 0.0;

    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        int[] b = {5, 6};
        MedianArray object = new MedianArray();
        System.out.println("Median " + object.bestApproach(a, b));
    }
}
