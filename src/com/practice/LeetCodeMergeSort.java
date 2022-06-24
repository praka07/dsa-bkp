package com.practice;

import java.util.Arrays;

public class LeetCodeMergeSort {
    public static void main(String[] args) {
        LeetCodeMergeSort obj = new LeetCodeMergeSort();
        System.out.println(Arrays.toString(obj.merge(new int[]{-1, 0, 0, 3, 3, 3, 0, 0, 0}, 6, new int[]{1, 2, 2}, 3)));

    }

    public int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m + n];
        int i = 0, j = 0, k = 0;
        int firstArrayLength=nums1.length - nums2.length;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                result[k] = nums1[i];
                i++;
                k++;
            } else {
                result[k] = nums2[j];
                j++;
                k++;
            }


        }

        while (i < m) {
            result[k] = nums1[i];
            i++;
            k++;
        }
        while (j < n) {
            result[k] = nums2[j];
            j++;
            k++;
        }
        for (int index = 0; index < result.length; index++) {
            nums1[index] = result[index];
        }
        return nums1;
    }
}
