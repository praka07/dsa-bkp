package com.practice;

import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

public class ReversingElementsOfQueue {
    public static void main(String[] args) {
        ReversingElementsOfQueue object = new ReversingElementsOfQueue();
        int[] A = {5, 17, 100, 11};
        int B = 2;
        System.out.println(" ans " + Arrays.toString(object.solve(A, B)));

    }

    public int[] solve(int[] A, int B) {
        int[] result = new int[A.length];
        Stack<Integer> elem = new Stack<>();
        for (int i = 0; i < B; i++) {
            elem.push(A[i]);
        }
        int k = 0;
        while (!elem.isEmpty()) {
            result[k++] = elem.pop();
        }
        for (int m = B; m < A.length; m++) {
            result[k++] = A[m];
        }
        return result;
    }
}
