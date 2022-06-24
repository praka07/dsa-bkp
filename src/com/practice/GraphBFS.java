package com.practice;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class GraphBFS {
    public static int[][] am;
    public static LinkedList<Integer> AdjList[];

    public int solve(int A, int[][] B) {
        // construct Adjacency matrix
        am = new int[A][A];
        for (int i = 0; i < B.length; i++) {
            addEdge(B[i][0] - 1, B[i][1] - 1);
        }
        Queue<Integer> bfs = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<Integer>();
        // add source node
        bfs.add(B[0][0]);
        visited.add(B[0][0]);

        while (!bfs.isEmpty()) {
            int vertex = bfs.remove();
            //how to find neighbour
            // System.out.println("vertex " + vertex);
            for (int i = 0; i < vertex; i++) {
                for (int j = 0; j < vertex; j++) {
                    if (!visited.contains(B[i][j])) {
                        visited.add(B[i][j]);
                        bfs.add(B[i][j]);
                    }
                }
            }

        }

        if (visited.contains(A)) {
            return 1;
        }
        return 0;
    }

    private void addEdge(int source, int destination) {
        am[source][destination] = 1;
        am[destination][source] = 1;

    }

    public int solve1(int A, int[][] B) {
        AdjList = new LinkedList[A+1];

        for (int i = 1; i <=A; i++) {
            AdjList[i] = new LinkedList<Integer>();
        }
        for (int i = 0; i < B.length; i++) {
            addEdgeLL(B[i][0] , B[i][1] );
        }
        Queue<Integer> bfs = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<Integer>();
        bfs.add(1);
        visited.add(1);
        while (!bfs.isEmpty()) {
            int vertex = bfs.poll();
            Iterator<Integer> i = AdjList[vertex].iterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited.contains(n)) {
                    visited.add(n);
                    bfs.add(n);
                }

            }

        }
        if (visited.contains(A)) {
            return 1;
        }
        return 0;

    }

    private void addEdgeLL(int source, int destination) {
        AdjList[source].add(destination);
        AdjList[destination].add(source);

    }

    public static void main(String[] args) {

        GraphBFS object = new GraphBFS();
        int a = 5;
        int[][] b = {{1, 2},
                {2,3},
                {4,3},
               };
        System.out.println(" " + object.solve1(a, b));

    }
}
