package com.practice;

public class BitOnicArray {
    public static void main(String[] args) {
        int[] input = {3, 9, 10, 20, 17, 5, 1};
        int target = 5;
        BitOnicArray obj = new BitOnicArray();
        System.out.println(" index " + obj.bitOnicSort(input, target, 0, input.length - 1));
    }

    private int bitOnicSort(int[] a, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (a[mid] == target) {
            return mid;
        }
        if (a[start] <= a[mid]) {
            if (target >= a[start] && target <= a[mid]) {
                return bitOnicSort(a, target, start, mid - 1);
            } else {
                return bitOnicSort(a, target, mid + 1, end);
            }
        }
        if (target > a[mid] && target <= a[end]) {
            return bitOnicSort(a, target, mid + 1, end);
        } else {
            return bitOnicSort(a, target, start, mid - 1);
        }
    }
}
