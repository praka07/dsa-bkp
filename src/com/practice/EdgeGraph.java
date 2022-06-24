package com.practice;

import java.util.ArrayList;
import java.util.Collections;

public class EdgeGraph {
    static int maxn = 300009;
    static int[] arr = new int[maxn];
    static int[] sz = new int[maxn];
    static ArrayList<Pair> edges;

    public int[] solve(int A, int[][] B) {
        ini();
        for (int i = 0; i < B.length; i++) {
            edges.add(new Pair(B[i][2], i, B[i][0], B[i][1]));
        }
        int[] ans = new int[B.length];
        Collections.sort(edges);
        int i = 0;
        int m = B.length;
        while (i < m) {
            int j = i;
            while (j < m && edges.get(j).a == edges.get(i).a) {
                if (root(edges.get(j).c) != root(edges.get(j).d)) {
                    ans[edges.get(j).b] = 1;
                }
                j++;
            }
            j = i;
            while (j < m && edges.get(j).a == edges.get(i).a) {
                if (root(edges.get(j).c) != root(edges.get(j).d)) {
                    un(edges.get(j).c, edges.get(j).d);
                }
                j++;
            }
            i = j;
        }
        return ans;
    }

    public static void ini() {
        edges = new ArrayList<Pair>();
        for (int i = 0; i < maxn; i++) {
            arr[i] = i;
            sz[i] = 1;
        }
    }

    public static int root(int a) {
        while (arr[a] != a) {
            arr[a] = arr[arr[a]];
            a = arr[a];

        }
        return a;
    }

    public static void un(int a, int b) {
        int ra = root(a);
        int rb = root(b);
        if (sz[ra] <= sz[rb]) {
            arr[ra] = rb;
            sz[rb] += sz[ra];

        } else {
            arr[rb] = ra;
            sz[ra] += sz[rb];

        }
    }
}

class Pair implements Comparable<Pair> {
    int a, b, c, d;

    Pair(int e, int f, int g, int h) {
        this.a = e;
        this.b = f;
        this.c = g;
        this.d = h;
    }

    @Override
    public int compareTo(Pair aa) {
        return this.a - aa.a;

    }
}
