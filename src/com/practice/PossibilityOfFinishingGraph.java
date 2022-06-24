package com.practice;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class PossibilityOfFinishingGraph {
    private LinkedList<Integer> adjacencyList[];
    private HashSet<Integer> visited;

    public int solve(int A, int[] B, int[] C) {
        adjacencyList = new LinkedList[A + 1];
        visited = new HashSet<>();

        for (int i = 1; i <= A; i++) {
            adjacencyList[i] = new LinkedList<>();
        }

        for (int i = 0; i < B.length; i++) {
            constructAdjacencyList(B[i], C[i]);
        }

        return dfs(1, 0) ? 0 : 1;
    }

    boolean dfs(int vertex, int parent) {
        visited.add(vertex);
        Iterator<Integer> ite = adjacencyList[vertex].listIterator();
        while (ite.hasNext()) {
            int adj = ite.next();
            if (visited.contains(adj) && vertex != parent) {
                return true;
            } else if (!visited.contains(adj)) {
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
        PossibilityOfFinishingGraph objet = new PossibilityOfFinishingGraph();
        int a = 3;
        int[] b = {1, 2, 3};
        int[] c = {2, 3, 1};
        System.out.println("res -> " + objet.solve(a, b, c));
    }
}
