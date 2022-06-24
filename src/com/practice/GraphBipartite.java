package com.practice;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class GraphBipartite {
    private LinkedList<Integer> adjacencyList[];

    public int solve(int A, int[][] B) {
        adjacencyList = new LinkedList[A];
        for (int i = 0; i <A; i++) {
            adjacencyList[i] = new LinkedList<>();
        }

        int[] color = new int[A];
        Arrays.fill(color, -1);


        for (int j = 0; j < B.length; j++) {
            addEdge(B[j][0], B[j][1]);
        }

        for (int k = 0; k < A; k++) {
            if (color[k] == -1) {
                if (!bfscheck(k, color)) {
                    return 0;
                }
            }
        }
        return 1;
    }

    private boolean bfscheck(int node, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        color[node] = 1;
        while (!q.isEmpty()) {
            Integer nde = q.poll();
            Iterator<Integer> it = adjacencyList[nde].listIterator();
            while (it.hasNext()) {
                int adj = it.next();
                if (color[adj] == -1) {
                    color[adj] = 1 - color[nde];
                    q.add(adj);
                } else if (color[adj] == color[nde]) {
                    return false;
                }
            }
        }
        return true;
    }

    private void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);

    }

    public static void main(String[] args) {
        int a = 10;
        int[][] b = {{7, 8},
                {1, 2},
                {0, 9},
                {1, 3},
                {6, 7},
                {0, 3},
                {2, 5},
                {3, 8},
                {4, 8}

        };
        GraphBipartite object = new GraphBipartite();
        System.out.println(" " + object.solve(a, b));
    }
}
