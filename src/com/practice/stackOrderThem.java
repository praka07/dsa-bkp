package com.practice;

import java.util.Iterator;
import java.util.Stack;

public class stackOrderThem {
    public static void main(String[] args) {

        stackOrderThem object = new stackOrderThem();
        System.out.println("output " + object.solve(new int[]{2, 4, 6, 1, 3, 7, 8, 5}));

    }

    public int solve(int[] A) {
        int[] b = new int[A.length];
        Stack<Integer> c = new Stack<Integer>();
        int k = 1, j = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == k) {
                k++;

            } else {
                c.push(A[i]);
            }
            while (!c.isEmpty() && c.peek() == k) {
                k++;
                c.pop();
            }
        }
        while (!c.isEmpty() && c.peek() == k) {
            k++;
            c.pop();
        }
        if (c.isEmpty()) {
            return 1;
        }
        return 0;
    }
}
