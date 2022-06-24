package com.practice;

import java.util.ArrayList;
import java.util.Collections;

class GraphVertexMst implements Comparable<GraphVertexMst> {

    private int source;
    private int destination;
    private int weight;

    GraphVertexMst(int s, int d, int w) {
        this.source = s;
        this.destination = d;
        this.weight = w;
    }

    @Override
    public int compareTo(GraphVertexMst o1) {
        return this.weight - o1.weight;

    }

    public int getDestination() {
        return destination;
    }

    public int getWeight() {
        return weight;
    }

    public int getSource() {
        return source;
    }
}

public class MatrixAbsoluteDifferenceGraph {
    static ArrayList<GraphVertexMst> edges = new ArrayList<>();
    static ArrayList<Integer> mst = new ArrayList<>();

    public int solve(int A, int B, int[][] C) {
        int column = C[0].length;


        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < C[i].length - 1; j++) {
                edges.add(new GraphVertexMst(column * i + j, column * i + j + 1, Math.abs(C[i][j] - C[i][j + 1])));
                edges.add(new GraphVertexMst(column * i + j + 1, column * i + j, Math.abs(C[i][j] - C[i][j + 1])));

            }
        }
        for (int i = 0; i < C.length - 1; i++) {
            for (int j = 0; j < C[i].length; j++) {
                edges.add(new GraphVertexMst(column * i + j, column * (i + 1) + j, Math.abs(C[i][j] - C[i + 1][j])));
                edges.add(new GraphVertexMst(column * (i + 1) + j, column * i + j, Math.abs(C[i][j] - C[i + 1][j])));

            }
        }

        int[] arrayParent = new int[edges.size() + 1];
        int[] rank = new int[edges.size() + 1];
        for (int i = 0; i < edges.size() + 1; i++) {
            arrayParent[i] = i;
        }
        Collections.sort(edges);
        for (GraphVertexMst edge : edges) {
            if (findParent(edge.getSource(), arrayParent) != (findParent(edge.getDestination(), arrayParent))) {
                mst.add(edge.getWeight());
                union(edge.getSource(), edge.getDestination(), arrayParent, rank);

            }
        }
        Collections.sort(mst);

        return mst.get(mst.size() - 1);
    }

    private int findParent(int u, int[] parent) {
        if (parent[u] == u) {
            return u;
        }
        return parent[u] = findParent(parent[u], parent);
    }

    public void union(int u, int v, int[] par, int[] rank) {
        u = findParent(u, par);
        v = findParent(v, par);
        if (rank[u] < rank[v]) {
            par[u] = v;
        } else if (rank[u] > rank[v]) {
            par[v] = u;

        } else {
            par[v] = u;
            rank[u]++;

        }


    }

    public static void main(String[] args) {
        int a = 6, b = 8;
        int[][] c = {{9, 7, 7, 3, 4, 1, 2, 8},
                {8, 9, 3, 1, 4, 7, 2, 5},
                {1, 7, 9, 4, 1, 10, 4, 10},
                {8, 2, 7, 3, 6, 2, 7, 10},
                {4, 9, 2, 10, 3, 1, 1, 6},
                {9, 9, 3, 2, 7, 1, 8, 3}};
        MatrixAbsoluteDifferenceGraph obj = new MatrixAbsoluteDifferenceGraph();
        System.out.println(" " + obj.solve(a, b, c));

    }
}
