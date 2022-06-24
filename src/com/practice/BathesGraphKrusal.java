package com.practice;

import java.util.HashMap;
import java.util.Map;

public class BathesGraphKrusal {
    public int solve(int A, int[] B, int[][] C, int D) {
        int ans = 0;
        int[] parent = new int[A + 1];
        int[] rank = new int[A + 1];
        for (int i = 0; i < A + 1; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        for (int i = 0; i < C.length; i++) {
            if (findPar(C[i][0], parent) != findPar(C[i][1], parent)) {
                union(C[i][0], C[i][1], parent, rank);
            }

        }
        HashMap<Integer, Integer> result = new HashMap<>();
        for (int index = 1; index < A + 1; index++) {
            System.out.println(" value " + index + " parent " + parent[index]);

            result.put(parent[index], result.getOrDefault(parent[index], 0) + B[index - 1]);


        }
        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            if (entry.getValue() >= D) {
                ans++;
            }
        }
        System.out.println(" ans " + ans);
        return ans;
    }

    private int findPar(int u, int parent[]) {
        if (u == parent[u]) return u;
        return parent[u] = findPar(parent[u], parent);
    }

    private void union(int u, int v, int parent[], int rank[]) {
        u = findPar(u, parent);
        v = findPar(v, parent);
        if (rank[u] < rank[v]) {
            parent[u] = v;
        } else if (rank[v] < rank[u]) {
            parent[v] = u;
        } else {
            parent[v] = u;
            rank[u]++;
        }
    }

    public static void main(String[] args) {
        BathesGraphKrusal obj = new BathesGraphKrusal();
        int a = 14;
        int[] b = {7, 5, 7, 3, 9, 4, 4, 6, 3, 1, 4, 8, 7, 6};
        int[][] c = {{1, 2},
                {2, 6},
                {2, 7},
                {4, 13},
                {5, 8},
                {5, 13},
                {6, 12},
                {7, 10},
                {10, 14},
                {13, 14}};
        int d = 2;
        obj.solve(a, b, c, d);
    }
}
