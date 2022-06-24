package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CompareSortedSubarrays {
    public static void main(String[] args) {
        CompareSortedSubarrays obj = new CompareSortedSubarrays();
        int[] a = {0, 100000};
        int[][] b = {{0, 0, 0, 0},{1, 1, 1, 1},{0, 1, 0, 1}};
        System.out.println("Result :::" + Arrays.toString(obj.solve(a, b)));


    }

    public int[] solve(int[] A, int[][] B) {

        int[] result = new int[B.length];

        for (int i = 0; i < B.length; i++) {
            int l1 = B[i][0];
            int r1 = B[i][1];
            int l2 = B[i][2];
            int r2 = B[i][3];
            ArrayList<Integer> firstSegment = new ArrayList<>();
            ArrayList<Integer> secondSegment = new ArrayList<>();
            for (int k = l1; k <= r1; k++) {
                firstSegment.add(A[k]);

            }
            for (int l = l2; l <= r2; l++) {
                secondSegment.add(A[l]);

            }
            Collections.sort(firstSegment);
            Collections.sort(secondSegment);
            if (firstSegment.equals(secondSegment)) {
                result[i]=1;
            }


        }


        return result;
    }
}
