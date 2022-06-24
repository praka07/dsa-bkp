package com.practice;

import java.util.Arrays;

public class SegmentTreeSimple {
    private static int[] st;

    public static void main(String[] args) {
        int[] a = {10, 2, 6, -3, 5, 8, 1, 15};
        int startIndex = 1, endIndex = 4;
        st = new int[4 * a.length - 1];
        //form segment tree
        buildSegmentTree(a, 0, 0, a.length - 1);
        System.out.println("Segment Tree " + Arrays.toString(st));

        int sumValue = sumQuery(0, 0, a.length - 1, startIndex, endIndex);
        System.out.println(" result " + sumValue);


    }

    private static int sumQuery(int index, int start, int end, int l, int r) {
        //non-overlap condition
        if (end < l || r < start) {
            return 0;
        }
        //completely overlap
        if (l <= start && end <= r) {
            return st[index];
        }
        // partial overlap
        int mid = (start + end) / 2;
        int lc = 2 * index + 1;
        int rc = 2 * index + 2;
        return (sumQuery(lc, start, mid, l, r) + sumQuery(rc, mid + 1, end, l, r));

    }

    public static void buildSegmentTree(int[] a, int index, int start, int end) {

        if (start == end) {
            st[index] = a[start];
        } else {
            int mid = (start + end) / 2;
            int lc = 2 * index + 1;
            int rc = 2 * index + 2;
            buildSegmentTree(a, lc, start, mid);
            buildSegmentTree(a, rc, mid + 1, end);
            st[index] = st[lc] + st[rc];

        }

    }

    void update(int node, int start, int end, int idx, int val) {
        int[] a = new int[2];
        if (start == end) {
            // Leaf node
            a[idx] += val;
            st[node] += val;
        } else {
            int mid = (start + end) / 2;
            if (start <= idx && idx <= mid) {
                // If idx is in the left child, recurse on the left child
                update(2 * node+1, start, mid, idx, val);
            } else {
                // if idx is in the right child, recurse on the right child
                update(2 * node + 2, mid + 1, end, idx, val);
            }
            // Internal node will have the sum of both of its children
            st[node] = st[2 * node] + st[2 * node + 1];
        }
    }
}
