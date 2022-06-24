package com.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class CountThePrimesSegmentTree {
    private static int[] st;

    public int[] solve(int[] A, String[] B, int[] C, int[] D) {
        ArrayList<Integer> tempResult = new ArrayList<Integer>();
        int[] primeStatus = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            primeStatus[i] = isPrmie(A[i]) ? 1 : 0;

        }

        st = new int[4 * primeStatus.length - 1];
        buildSegementTree(primeStatus, 0, 0, primeStatus.length - 1);
        for (int j = 0; j < B.length; j++) {
            if ("A".equals(B[j])) {
                int totalPrime = numberOfPrimes(0, 0, primeStatus.length - 1, C[j] - 1, D[j] - 1);
                tempResult.add(totalPrime);

            } else {
                updatePosition(0, 0, primeStatus.length - 1, C[j] - 1, D[j] - 1);
            }
        }


        int[] result = new int[tempResult.size()];
        int k = 0;
        for (int count : tempResult) {
            result[k++] = count;
        }

        return result;

    }

    private int numberOfPrimes(int node, int start, int end, int l, int r) {
        //non-overlap
        if (end < l || r < start) {
            return 0;
        }

        //completely overlap
        if (l <= start && end <= r) {
            return st[node];
        }

        // partially overlap
        int mid = (start + end) / 2;
        int lc = 2 * node + 1;
        int rc = 2 * node + 2;
        return (numberOfPrimes(lc, start, mid, l, r) + numberOfPrimes(rc, mid + 1, end, l, r));
    }

    private void updatePosition(int node, int start, int end, int newIndex, int value) {
        if (start == end) {

            st[node] = isPrmie(value) ? 1 : 0;
            return;

        }
        int mid = (start + end) / 2;
        int lc = 2 * node + 1;
        int rc = 2 * node + 2;
        if (newIndex <= mid) {
            // eliminate RST
            updatePosition(lc, start, mid, newIndex, value);
        } else {
            //eliminate LST
            updatePosition(rc, mid + 1, end, newIndex, value);
        }

    }

    private void buildSegementTree(int[] primeStatus, int node, int start, int end) {
        if (start == end) {
            st[node] = primeStatus[start];
            return;
        }
        int mid = (start + end) / 2;
        int lc = 2 * node + 1;
        int rc = 2 * node + 2;
        buildSegementTree(primeStatus, lc, start, mid);
        buildSegementTree(primeStatus, rc, mid + 1, end);
        st[node] = st[lc] + st[rc];
    }

    public boolean isPrmie(int number) {
        // Check if number is less than
        // equal to 1
        if (number <= 1)
            return false;

            // Check if number is 2
        else if (number == 2)
            return true;

            // Check if n is a multiple of 2
        else if (number % 2 == 0)
            return false;

        // If not, then just check the odds
        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            if (number % i == 0)
                return false;
        }
        return true;

    }

    public static void main(String[] args) {
        int[] a = {1, 3, 121, 20, 17, 26, 29};
        String[] b = {"A", "C", "A"};
        int[] c = {1, 3, 1};
        int[] d = {7, 19, 7};
        CountThePrimesSegmentTree object = new CountThePrimesSegmentTree();
        System.out.println(" " + Arrays.toString(object.solve(a, b, c, d)));
    }
}
