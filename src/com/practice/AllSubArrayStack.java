package com.practice;

import java.util.Stack;

public class AllSubArrayStack {
    public static void main(String[] args) {

        AllSubArrayStack object = new AllSubArrayStack();
        System.out.println(" result ::; " + object.solve(new int[]{2, 3, 1, 4}));

    }

            public int solve(int[] A) {
                int ans = 0;
                Stack<Integer> monoStack = new Stack<Integer>();
                for (int i = 0; i < A.length; i++) {

                    while (!monoStack.isEmpty()) {
                        ans = Math.max(ans, A[monoStack.peek()] ^ A[i]);
                        if (A[monoStack.peek()] > A[i])
                            break;
                        monoStack.pop();
                    }
                    monoStack.push(i);

                }
                return ans;
            }
}
