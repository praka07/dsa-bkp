package com.practice;

public class CountNumberOfZero {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 5,8,6};
        System.out.println(checkArraySorted(a, 0));


    }

    public static boolean checkArraySorted(int[] a, int index) {
        System.out.println(index);
        if (index == a.length - 1) {
            return true;
        }
        return (a[index] < a[index + 1] && checkArraySorted(a, index + 1));
    }
}
