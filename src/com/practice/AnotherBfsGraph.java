package com.practice;

import java.util.LinkedList;
import java.util.Queue;

class GraphNode {
    int source;
    int destination;
    int weight;

    GraphNode(int s, int d, int w) {
        this.source = s;
        this.destination = d;
        this.weight = w;
    }

}

public class AnotherBfsGraph {
    public int solve(int A, int[][] B, int C, int D) {
        int maxn = 1009;
        LinkedList<Integer> adjLst[];
        int[] disArray = new int[maxn];
        for (int i = 0; i < maxn; i++) {
            disArray[i] = 1000000000;

        }
        adjLst = new LinkedList[maxn];
        for (int i = 0; i < maxn; i++) {
            adjLst[i] = new LinkedList<>();
        }
        System.out.println(adjLst);
        // add edge
        for (int j = 0; j < B.length; j++) {
            if (B[j][2] == 2) {
                A = A + 1;
            }
            addEdge(A, B[j][0], B[j][1], B[j][2], adjLst);

        }
        Queue<Integer> q = new LinkedList<>();
        disArray[C] = 0;
        q.add(C);

        while (q.isEmpty() == false) {
            int node = q.poll();
            for (int it : adjLst[node]) {
                if (disArray[node] + 1 < disArray[it]) {
                    disArray[it] = disArray[node] + 1;
                    q.add(it);
                }
            }
        }

        return disArray[D]==1000000000?-1:disArray[D];
    }

    private void addEdge(int n, int source, int destination, int weight, LinkedList<Integer> adjLst[]) {
        // GraphNode node = new GraphNode(source, destination, weight);
        if (weight == 2) {
            adjLst[source].add(n);
            adjLst[n].add(destination);
            adjLst[n].add(source);
            adjLst[destination].add(n);

        } else {
            adjLst[source].add(destination);
            adjLst[destination].add(source);
        }
    }

    public static void main(String[] args) {

        AnotherBfsGraph obGraph = new AnotherBfsGraph();
        int a = 6;
        int[][] b = {{2, 5, 1},
                {1, 3, 1},
                {0, 5, 2},
                {0, 2, 2},
                {1, 4, 1},
                {0, 1, 1}};
        int c = 3;
        int d = 2;
        System.out.println(" -> " + obGraph.solve(a, b, c, d));

    }
}
