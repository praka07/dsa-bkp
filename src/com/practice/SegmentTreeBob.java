package com.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class SegmentTreeBob {
    private static int[] segmentTree;

    public int[] solve(int A, int[][] B) {
        segmentTree = new int[4 * A - 1];
        ArrayList<Integer> temp = new ArrayList<>();

        for (int i = 0; i < B.length; i++) {
            if (B[i][0] == 1) {
                // Query 1
                update(0, 0, A - 1, 1, B[i][1] - 1);

            } else if (B[i][0] == 2) {
                //Query 2
                update(0, 0, A - 1, -1, B[i][1] - 1);
            } else if (B[i][0] == 3) {
                //Query 3
                int l = B[i][1] - 1;
                int r = B[i][2] - 1;

                int once = countOnes(0, 0, A - 1, l, r);
                temp.add(once);

            }

        }
        int[] result = new int[temp.size()];
        int k = 0;
        for (int total : temp) {
            result[k++] = total;
        }

        return result;

    }

    private int countOnes(int node, int start, int end, int l, int r) {
        // completely overlap condition
        if (l <= start && end <= r) {
            return segmentTree[node];
        }       // non overlap condition
        else if (end < l || r < start) {
            return 0;

        } else {

            //partially overlap
            int mid = (start + end) / 2;
            int lc = 2 * node + 1;
            int rc = 2 * node + 2;
            return countOnes(lc, start, mid, l, r) + countOnes(rc, mid + 1, end, l, r);
        }

    }

    private void update(int node, int start, int end, int value, int pos) {
        if (start == end) {
            if (!(segmentTree[node] == 0 && value == -1)) {
                segmentTree[node] += value;

            }
            return;
        }
        int mid = (start + end) / 2;
        int lc = 2 * node + 1;
        int rc = 2 * node + 2;
        if (pos <= mid) {
            update(lc, start, mid, value, pos);

        } else {
            update(rc, mid + 1, end, value, pos);
        }
        segmentTree[node] = segmentTree[lc] + segmentTree[rc];
    }


    public static void main(String[] args) {
        SegmentTreeBob object = new SegmentTreeBob();
        int a = 5;
        int[][] b = {{1, 1, -1}, {1, 2, -1}, {1, 3, -1}, {3, 1, 3}, {3, 2, 4}};

        System.out.println(" result ---" + Arrays.toString(object.solve(a, b)));

    }
}
