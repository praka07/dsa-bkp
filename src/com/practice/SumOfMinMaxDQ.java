package com.practice;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class SumOfMinMaxDQ {
    public static void main(String[] args) {
        int[] a = {2, 5, -1, 7, -3, -1, -2};
        int b = 4;

        SumOfMinMaxDQ object = new SumOfMinMaxDQ();
        System.out.println(" out " + SumOfKsubArray(a, b));
        System.out.println("out " + object.solve(a, b));
        // System.out.println("out " + object.navive(a, b));

    }

    public int solve(int[] A, int B) {
        int sum = 0;
        int mod = 1000000009;
        Deque<Integer> minDq = new ArrayDeque<Integer>();
        Deque<Integer> maxDq = new ArrayDeque<Integer>();
        for (int i = 0; i < B; i++) {
            // collect min value of first slide window
            while (!minDq.isEmpty() && A[i] <= A[minDq.peekLast()]) {
                minDq.removeLast();

            }
            // collect max values of first slide window
            while (!maxDq.isEmpty() && A[i] >= A[maxDq.peekLast()]) {
                maxDq.removeLast();


            }
            minDq.addLast(i);
            maxDq.addLast(i);
        }

        for (int k = B; k < A.length; k++) {
            sum += A[maxDq.peekFirst()] + A[minDq.peekFirst()];
            //remove useless

            while (!maxDq.isEmpty() && maxDq.peekFirst() <= k - B) {
                maxDq.removeFirst();
            }

            while (!minDq.isEmpty() && minDq.peekFirst() <= k - B) {
                minDq.removeFirst();
            }

            while (!minDq.isEmpty() && A[k] <= A[minDq.peekLast()]) {
                minDq.removeLast();
            }
            while (!maxDq.isEmpty() && A[k] >= A[maxDq.peekLast()]) {
                maxDq.removeLast();
            }
            minDq.addLast(k);
            maxDq.addLast(k);

        }
        sum += A[maxDq.peekFirst()] + A[minDq.peekFirst()];

        return sum % mod;
    }

    public static int SumOfKsubArray(int arr[], int k) {
        int sum = 0;  // Initialize result

        // The queue will store indexes of useful elements
        // in every window
        // In deque 'G' we maintain decreasing order of
        // values from front to rear
        // In deque 'S' we  maintain increasing order of
        // values from front to rear
        Deque<Integer> S = new LinkedList<>(), G = new LinkedList<>();

        // Process first window of size K
        int i = 0;
        for (i = 0; i < k; i++) {
            // Remove all previous greater elements
            // that are useless.
            while (!S.isEmpty() && arr[S.peekLast()] >= arr[i])
                S.removeLast(); // Remove from rear

            // Remove all previous smaller that are elements
            // are useless.
            while (!G.isEmpty() && arr[G.peekLast()] <= arr[i])
                G.removeLast(); // Remove from rear

            // Add current element at rear of both deque
            G.addLast(i);
            S.addLast(i);
        }

        // Process rest of the Array elements
        for (; i < arr.length; i++) {
            // Element at the front of the deque 'G' & 'S'
            // is the largest and smallest
            // element of previous window respectively
            sum += arr[S.peekFirst()] + arr[G.peekFirst()];

            // Remove all elements which are out of this
            // window
            while (!S.isEmpty() && S.peekFirst() <= i - k)
                S.removeFirst();
            while (!G.isEmpty() && G.peekFirst() <= i - k)
                G.removeFirst();

            // remove all previous greater element that are
            // useless
            while (!S.isEmpty() && arr[S.peekLast()] >= arr[i])
                S.removeLast(); // Remove from rear

            // remove all previous smaller that are elements
            // are useless
            while (!G.isEmpty() && arr[G.peekLast()] <= arr[i])
                G.removeLast(); // Remove from rear

            // Add current element at rear of both deque
            G.addLast(i);
            S.addLast(i);
        }

        // Sum of minimum and maximum element of last window
        sum += arr[S.peekFirst()] + arr[G.peekFirst()];

        return sum;
    }

    public int navive(int[] A, int B) {
        int sum = 0;
        int mod = 1000000009;
        for (int i = 0; i <= A.length - B; i++) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + B; j++) {
                min = Math.min(min, A[j]);
                max = Math.max(max, A[j]);
            }
            sum = sum + (min + max);
        }

        return sum % mod;
    }
}
