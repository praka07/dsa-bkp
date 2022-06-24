package com.practice;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class CycleDirectedGraph {
    private LinkedList<Integer> adjacencyList[];
    private boolean visited[];


    public int solve(int A, int[][] B) {
        adjacencyList = new LinkedList[A + 1];
        visited = new boolean[A];

        for (int i = 1; i <= A; i++) {
            adjacencyList[i] = new LinkedList<>();
        }

        for (int i = 0; i < B.length; i++) {
            constructAdjacencyList(B[i][0], B[i][1]);
        }

        return dfs(1, 0) ? 1 : 0;

    }

    boolean dfs(int vertex, int parent) {
        visited[vertex] = true;
        Iterator<Integer> ite = adjacencyList[vertex].listIterator();
        while (ite.hasNext()) {
            int adj = ite.next();
            if (visited[adj] == true && vertex != parent) {
                return true;
            } else if (!visited[adj]) {
                boolean cycle = dfs(adj, vertex);
                if (cycle) {
                    return true;
                }
            }

        }
        return false;
    }


    public void constructAdjacencyList(int source, int destination) {
        adjacencyList[source].add(destination);
    }

    public static void main(String[] args) {
        CycleDirectedGraph object = new CycleDirectedGraph();
        int a = 2;
        int[][] b = {{1, 2}

        };
        System.out.println(" " + object.solve(a, b));
    }
}
