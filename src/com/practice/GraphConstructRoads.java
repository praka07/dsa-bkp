package com.practice;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class GraphConstructRoads {
    private LinkedList<Integer> adjLst[];

    public int solve(int A, int[][] B) {
        int mod = 1000000007;
        int ans = 0;
        int[] color = new int[A + 1];
        adjLst = new LinkedList[A + 1];
        for (int i = 1; i <= A; i++) {
            adjLst[i] = new LinkedList<>();

        }
        Arrays.fill(color, -1);
        for (int j = 0; j < B.length; j++) {
            addEdge(B[j][0], B[j][1]);
        }

        for (int k = 1; k <= A; k++) {
            if (color[k] == -1) {
                bfsCheck(k, color);
            }

        }
        int a = 0;
        int b = 0;
        for (int l = 1; l < color.length; l++) {
            if (color[l] == 1) {
                a++;
            } else {
                b++;
            }
        }
        ans = (a * b) - (A - 1) % mod;
        return ans % mod;
    }

    public void addEdge(int source, int destination) {
        adjLst[source].add(destination);
        adjLst[destination].add(source);
    }

    public void bfsCheck(int node, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        color[node] = 1;
        q.add(node);
        while (!q.isEmpty()) {
            Integer nde = q.poll();
            Iterator<Integer> it = adjLst[nde].listIterator();
            while (it.hasNext()) {
                int adj = it.next();
                if (color[adj] == -1) {
                    color[adj] = 1 - color[nde];
                    q.add(adj);
                }
            }
        }
    }

    public static void main(String[] args) {
        int a = 5;
        int[][] b = {{1, 3}, {1, 4}, {3, 2}, {3, 5}};
        GraphConstructRoads object = new GraphConstructRoads();
        System.out.println(" " + object.solve(a, b));
    }
}
