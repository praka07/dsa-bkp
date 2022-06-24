package com.practice;

import java.util.*;

public class SlidingWindowQ {
    public static void main(String[] args) {
        int[] a = {1, 10, 3, 2, 6, 7, 11};
        int k = 3;
        SlidingWindowQ object = new SlidingWindowQ();
        object.solve(a, k);
    }

    public void solve(int[] input, int k) {
        Deque<Integer> dq = new ArrayDeque<Integer>();
        int[] maxAns = new int[input.length - k + 1];
        int index = 0;
        for (int i = 0; i < k; i++) {
            if (dq.isEmpty()) {
                dq.addLast(i);
            } else {
                while (!dq.isEmpty() && input[i] >= input[dq.peekLast()]) {
                    dq.pollLast();
                }
                dq.addLast(i);
            }
        }
        maxAns[index++] = input[dq.peekFirst()];
        for (int m = k; m < input.length; m++) {
            // drop the elements that are out of window
            int c = m - k;
            while (!dq.isEmpty() && dq.peekFirst() <= c)
                dq.pollFirst();

            // remove those elements smaller than the current element from back
            while (!dq.isEmpty() && input[m] >= input[dq.peekLast()]) {
                dq.pollLast();

            }
            dq.addLast(m);

            maxAns[index++] = input[dq.peekFirst()];


        }

        System.out.println(Arrays.toString(maxAns));
    }
}
