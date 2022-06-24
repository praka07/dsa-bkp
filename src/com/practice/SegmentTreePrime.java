package com.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class SegmentTreePrime {
    static int N = 40010;
    static int M = 1000010;
    static int[] segtree = new int[4 * N];
    static int[] a = new int[N];
    static int n, q;
    static boolean[] isPrime = new boolean[M];

    public static void sieve() {
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i < M; i++) {
            if (isPrime[i] == true) {
                int j = i * 2;
                while (j < M) {
                    isPrime[j] = false;
                    j += i;
                }
            }
        }
    }

    public static void init(int l, int r, int pos) {
        if (l == r) {
            segtree[pos] = a[l];
            return;
        }
        int md = (l + r) >> 1;
        init(l, md, pos * 2 + 1);
        init(md + 1, r, pos * 2 + 2);
        segtree[pos] = segtree[pos * 2 + 1] + segtree[pos * 2 + 2];
    }

    public static void update(int l, int r, int ql, int qr, int pos, int v) {
        if (ql > r || qr < l)
            return;
        if (l == r) {
            a[l] = v;
            segtree[pos] = a[l];
            return;
        }
        int md = (l + r) >> 1;
        update(l, md, ql, qr, pos * 2 + 1, v);
        update(md + 1, r, ql, qr, pos * 2 + 2, v);
        segtree[pos] = segtree[pos * 2 + 1] + segtree[pos * 2 + 2];
    }

    public static int geta(int l, int r, int ql, int qr, int pos) {
        if (ql > r || qr < l)
            return 0;
        if (ql <= l && qr >= r)
            return segtree[pos];
        int md = (l + r) >> 1;
        return geta(l, md, ql, qr, pos * 2 + 1) + geta(md + 1, r, ql, qr, pos * 2 + 2);
    }

    public int[] solve(int[] A, String[] B, int[] C, int[] D) {
        n = A.length;
        sieve();
        for (int i = 0; i < n; i++) {
            if (isPrime[A[i]])
                a[i] = 1;
            else
                a[i] = 0;
        }
        init(0, n - 1, 0);
        q = B.length;
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < q; i++) {

            String type = B[i];

            if (type.charAt(0) == 'C') {
                update(0, n - 1, C[i] - 1, C[i] - 1, 0, isPrime[D[i]] == true ? 1 : 0);
            } else {
                res.add(geta(0, n - 1, C[i] - 1, D[i] - 1, 0));
            }
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++)
            ans[i] = res.get(i);
        return ans;
    }
}
