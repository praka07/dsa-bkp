package com.practice;

import java.util.Arrays;

public class SheldonPairGraph {
    public static void main(String[] args) {
        SheldonPairGraph obkect = new SheldonPairGraph();
        int a = 4;
        int b = 6;
        int c = 2;
        int[] d = {1, 2, 3, 2, 4, 3};
        int[] e = {2, 3, 4, 4, 1, 1};
        int[] f = {4, 1, 1, 1, 1, 1};
        int[] g = {1, 1};
        int[] h = {2, 3};
        System.out.println(" result " + Arrays.toString(obkect.solve(a, b, c, d, e, f, g, h)));

    }

    public int[] solve(int A, int B, int C, int[] D, int[] E, int[] F, int[] G, int[] H) {
        int[] ans = new int[C];
        int max=1000000009;
        int[][] minDistance = new int[A + 1][A + 1];
        for (int r = 1; r < minDistance.length; r++) {
            for (int c = 1; c < minDistance[0].length; c++) {
                if (r == c) {
                    minDistance[r][c] = 0;
                } else {
                    minDistance[r][c] = max;
                }
            }
        }
        for (int u = 0; u < D.length; u++) {
            minDistance[D[u]][E[u]] = Math.min(minDistance[D[u]][E[u]],F[u]);
            minDistance[E[u]][D[u]] = Math.min(minDistance[E[u]][D[u]],F[u]);

        }
        for (int k = 1; k < minDistance.length; k++) {
            for (int i = 1; i < minDistance.length; i++) {
                for (int j = 1; j < minDistance[0].length; j++) {
                    if (i == j) {
                        continue;
                    } else {
                        minDistance[i][j] = Math.min(minDistance[i][j], minDistance[i][k] + minDistance[k][j]);
                    }
                }
            }
        }
        int m = 0;
        for (int q = 0; q < G.length; q++) {
            if (minDistance[G[q]][H[q]] == max) {
                ans[m++] = -1;
            } else {
                ans[m++] = minDistance[G[q]][H[q]];
            }
        }
        return ans;
    }
}
