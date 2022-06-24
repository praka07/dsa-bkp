package com.practice;

import java.util.Arrays;
import java.util.Stack;

public class NearestSmallerElement {
    public static void main(String[] args) {
        int[] A = {4, 5, 2, 10, 8};
        int[] result = new int[A.length];
        Stack<Integer> stack = new Stack<Integer>();
        int k = 0;
        for (int i = 0; i < A.length; i++) {
            while (!stack.isEmpty() && stack.peek() >= A[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                result[k++] = -1;
            } else {
                result[k++] = stack.peek();

            }
            stack.push(A[i]);
        }

        System.out.println(Arrays.toString(result));
    }
}
