package com.practice;

import java.util.HashSet;

public class GymTrainer {
    public static void main(String[] args) {
        GymTrainer object = new GymTrainer();
        int a = 20;
        int[][] b = {{1, 5},
                {4, 6},
                {18, 3},
                {4, 5},
                {15, 9},
                {15, 4}};
        int[][] c = {{13, 20},
                {7, 20},
                {8, 19},
                {13, 7},
                {13, 8},
                {2, 19}};
        System.out.println(" " + object.solve(a, b, c));

    }

    public int solve(int A, int[][] B, int[][] C) {
        int mod = 1000000007;
        HashSet<Integer> walk = new HashSet<>();
        HashSet<Integer> dietSet = new HashSet<>();
        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < B[i].length; j++) {
                walk.add(B[i][j]);
            }
        }
        for (int r = 0; r < C.length; r++) {
            for (int c = 0; c < C[r].length; c++) {
                if (walk.contains(C[r][c])) {
                    return 0;

                }
            }
        }
        int ans = 0;
        int[] parent = new int[A + 1];
        int[] rank = new int[A + 1];
        for (int i = 0; i < A + 1; i++) {
            parent[i] = i;
        }
        for (int w = 0; w < B.length; w++) {
            if (findParent(B[w][0], parent) != findParent(B[w][1], parent)) {
                union(B[w][0], B[w][1], parent, rank);
            }
        }

        for (int w = 0; w < C.length; w++) {
            if (findParent(C[w][0], parent) != findParent(C[w][1], parent)) {
                union(C[w][0], C[w][1], parent, rank);
            }
        }
        for (int p = 0; p < parent.length; p++) {
            if (parent[p] == p) {
                dietSet.add(parent[p]);
            }
        }

        int result = (int) myPow(2, dietSet.size());
        return result % mod;


    }


    public int findParent(int u, int[] arr) {
        if (u == arr[u]) {
            return u;
        }
        return arr[u] = findParent(arr[u], arr);

    }

    public double myPow(double x, int n) {
        double ans = 1.0;
        long nn = n;
        if (nn < 0) {
            nn = -1 * nn;
        }
        while (nn > 0) {
            if (nn % 2 == 1) {
                ans = ans * x;
                nn = nn - 1;

            } else {
                x = x * x;
                nn = nn / 2;
            }
        }
        if (n < 0) {
            ans = (double) (1.0) / (double) ans;
        }

        return ans;
    }

    public void union(int u, int v, int[] arr, int[] rank) {
        u = findParent(u, arr);
        v = findParent(v, arr);
        if (rank[u] < rank[v]) {
            arr[u] = v;
        } else if (rank[u] > rank[v]) {
            arr[v] = u;
        } else {
            arr[v] = u;
            rank[u]++;
        }
    }
}
