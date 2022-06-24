package com.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class SegmentTree {
    public static int segmentTree[];

    public int[] solve(int[] A, int[][] B) {
        ArrayList<Integer> tempResult = new ArrayList<Integer>();
        segmentTree = new int[4 * A.length - 1];

        buildSegmentTree(A, 0, 0, A.length - 1);

        for (int i = 0; i < B.length; i++) {
            // append back of the array
            if (B[i][0] == 1) {

            } else if (B[i][0] == 2) {
                // update the array
                int tempSum=setQuery(0, 0, A.length - 1, B[i][1] - 1, B[i][2] - 1);

            } else if (B[i][0] == 3) {
                //delete the array

            } else {
                //sum range
            }
        }


        int[] result = new int[tempResult.size()];

        return result;
    }

    private int setQuery(int i, int i1, int i2, int i3, int i4) {
        return 0;
    }


    private void buildSegmentTree(int[] a, int node, int start, int end) {
        if (start == end) {
            segmentTree[node] = a[start];
        }
        int mid = (start + end) / 2;
        int lc = 2 * node + 1;
        int rc = 2 * node + 2;
        buildSegmentTree(a, lc, start, mid);
        buildSegmentTree(a, rc, mid + 1, end);
        segmentTree[node] = segmentTree[lc] + segmentTree[rc];
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 5, 3, 4};
        int[][] b = {{4, 2, 4}, {3, 3, 0}, {1, 6, 0}, {4, 3, 5}};
        SegmentTree object = new SegmentTree();
        System.out.println(" output " + Arrays.toString(object.solve(a, b)));

    }
}
