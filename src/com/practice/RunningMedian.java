package com.practice;

import java.util.Arrays;
import java.util.PriorityQueue;

public class RunningMedian {
    public int[] solve(int[] A) {
        PriorityQueue<Integer> b = new PriorityQueue<Integer>();
        int[] c = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            // add element to priorityqueue
            b.add(A[i]);
            // find median
            if (b.size() % 2 == 0) {
                //even
                int pqIndex = b.size() / 2;

            } else {
                //odd
                int pqIndex = (b.size() / (2 - 1));

            }
        }
        return c;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 5, 4, 3};
        RunningMedian object = new RunningMedian();
        System.out.println(" Result " + Arrays.toString(object.solve(A)));
    }
}
