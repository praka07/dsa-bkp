package com.practice;

import org.w3c.dom.ls.LSOutput;

public class SlidingWindowSimple {
    public static void main(String[] args) {
        System.out.println(3%4);
        int[] array = {1, 7, 6, 10, 23, 3, 1, 0, 20};
        int k = 4;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            int sum = 0;
            for (int j = i + 1; j <= k; j++) {
                sum += array[j];


            }
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }

}
