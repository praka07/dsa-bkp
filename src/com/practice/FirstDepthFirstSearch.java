package com.practice;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class FirstDepthFirstSearch {
    private LinkedList<Integer> adjacencyList[];
    private HashSet<Integer> visited;

    public int solve(int[] A, final int B, final int C) {
        adjacencyList = new LinkedList[A.length + 1];
        visited = new HashSet<>();
        for (int j = 1; j <= A.length; j++) {
            adjacencyList[j] = new LinkedList<>();
        }
        // add edge
        for (int k = 1; k < A.length; k++) {
            addEdge(A[k], k + 1);
        }

        return dfs(C, B) ? 1 : 0;
    }

    public boolean dfs(int s, int x) {
        if (s == x) {
            return true;
        }
        visited.add(s);
        int i, j, k = adjacencyList[s].size();
        for (i = 0; i < k; i++) {
            j = adjacencyList[s].get(i);
            if (!visited.contains(j) && dfs(j, x)==true) {
                return true;
            }

        }

        return false;
    }

    public void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
    }

    public static void main(String[] args) {

        int[] a = {1, 1, 1, 3, 3, 2, 2, 7, 6};
        int b = 9, c = 1;
        FirstDepthFirstSearch object = new FirstDepthFirstSearch();
        System.out.println("out " + object.solve(a, b, c));

    }
}
