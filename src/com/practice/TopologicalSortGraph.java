package com.practice;

import java.util.*;

public class TopologicalSortGraph {
    private LinkedList<Integer> adjacenyLst[];
    private HashSet<Integer> visited;

    public int[] solve(int A, int[][] B) {
        adjacenyLst = new LinkedList[A + 1];
        for (int i = 1; i <= A; i++) {
            adjacenyLst[i] = new LinkedList<Integer>();
        }
        visited = new HashSet<>();
        for (int i = 0; i < B.length; i++) {
            constructAdjacencyList(B[i][0], B[i][1]);
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A; i++) {
            if (!visited.contains(i)) {
                dfs(1, stack);
            }
        }
        int[] result = new int[stack.size()];
        int k = 0;
        while (!stack.isEmpty()) {
            result[k++] = stack.pop();
        }
        return result;
    }

    void dfs(int v, Stack<Integer> stack) {
        visited.add(v);
        Iterator<Integer> iterator = adjacenyLst[v].listIterator();
        while (iterator.hasNext()) {
            int adj = iterator.next();
            if (!visited.contains(adj)) {
                dfs(adj, stack);
            }
        }
        stack.push(v);
    }

    public void constructAdjacencyList(int source, int destination) {
        adjacenyLst[source].add(destination);
    }

    public static void main(String[] args) {
        int a = 6;
        int[][] b = {{6,3}, {6,1}, {5,1}, {5,2},{3,4},{4,2}


        };
        TopologicalSortGraph objGraph = new TopologicalSortGraph();
        System.out.println(Arrays.toString(objGraph.solve(a, b)));
    }
}
