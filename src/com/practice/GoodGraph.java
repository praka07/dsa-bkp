package com.practice;

public class GoodGraph {
    public int solve(int[] A) {
        int n = A.length;
        boolean[] visited = new boolean[n];
        int curr, next, ans = 0, c = 0;
        int[] color = new int[n];
        for (int i = 0; i < n; i += 1) {
            visited[i] = false;
        }
        for (int i = 0; i < n; i += 1) {
            if (visited[i] == false) {
                curr = i;
                visited[i] = true;
                next = A[curr] - 1;
                color[curr] = c;
                while (visited[curr] == false) {
                    visited[next] = true;
                    color[next] = c;
                    curr = next;
                    next = A[curr] - 1;

                }
                if (color[next] == c && next != 0) {
                    ans += 1;

                }
                c += 1;
            }
        }
        return ans;
    }
}
