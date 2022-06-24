package com.practice;

public class BinarySearchRotated {
    public static void main(String[] args) {
        BinarySearchRotated objeUnderStandBinary = new BinarySearchRotated();
        System.out.println("answer" + objeUnderStandBinary.binarySearch(new int[]{12, 24, 18, 21, 3, 6, 8, 9}, 24));

    }

    private int binarySearch(int[] ints, int i) {
        int low = 0, high = ints.length - 1;
        while (low <= high) {
            int mid = low + high / 2;
            if (low == high) {
                return mid;

            } else if (ints[mid] > ints[ints.length - 1]) {
                low = mid + 1;
            } else if(ints[mid] < ints[ints.length - 1]){
                high = mid - 1;
            }

        }
        return -1;

    }
}
