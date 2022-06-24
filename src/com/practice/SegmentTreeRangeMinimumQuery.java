package com.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class SegmentTreeRangeMinimumQuery {
    public static int[] st;

    public int[] solve(int[] A, int[][] B) {

        ArrayList<Integer> ans = new ArrayList<Integer>();
        st = new int[4 * A.length - 1];
        buildSegmentTree(A, 0, 0, A.length - 1);
        int k = 0;
        for (int i = 0; i < B.length; i++) {
            if (B[i][0] == 0) {
                // update
                update(0, 0, A.length - 1, B[i][1] - 1, B[i][2]);
            } else if (B[i][0] == 1) {
                //find minimum
                int minValue = findMinValue(0, 0, A.length - 1, B[i][1] - 1, B[i][2] - 1);
                ans.add(minValue);
            }

        }
        int[] result = new int[ans.size()];
        for (int minimumValue : ans) {
            result[k++] = minimumValue;
        }
        return result;
    }

    private int findMinValue(int index, int start, int end, int l, int r) {
        // completely overlap condition
        if (l <= start && end <= r) {
            return st[index];
        }
        // non overlap condition
        if (end < l || r < start) {
            return Integer.MAX_VALUE;

        }
        //partial condition
        int mid = (start + end) / 2;
        int lc = 2 * index + 1;
        int rc = 2 * index + 2;
        return Math.min(findMinValue(lc, start, mid, l, r), findMinValue(rc, mid + 1, end, l, r));

    }

    public static void buildSegmentTree(int[] a, int index, int start, int end) {
        if (start == end) {
            st[index] = a[start];
            return;
        }
        int mid = (start + end) / 2;
        int lc = 2 * index + 1;
        int rc = 2 * index + 2;
        buildSegmentTree(a, lc, start, mid);
        buildSegmentTree(a, rc, mid + 1, end);
        st[index] = Math.min(st[lc], st[rc]);


    }

    void update(int node, int start, int end, int pos, int val) {
        if (start == end) {
            // Leaf node
            st[node] = val;
            return;
        }
        int lc = 2 * node + 1;
        int rc = 2 * node + 2;
        int mid = (start + end) / 2;
        if (pos <= mid) {
            //elminate RST
            update(lc, start, mid, pos, val);
        } else {
            //eliminate LST
            update(rc, mid + 1, end, pos, val);
        }
        st[node] = Math.min(st[lc], st[rc]);
    }

    public static void main(String[] args) {
        SegmentTreeRangeMinimumQuery object = new SegmentTreeRangeMinimumQuery();
        int[] a = {1, 4, 1};
        int[][] b = {{1, 1, 3}, {0, 1, 5}, {1, 1, 2}};
        System.out.println(" result " + Arrays.toString(object.solve(a, b)));

    }
}
