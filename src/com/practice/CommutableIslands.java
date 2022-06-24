package com.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class MST {
    private int source, destination, weight;

    MST(int s, int d, int w) {
        this.source = s;
        this.destination = d;
        this.weight = w;
    }

    public int getSource() {
        return source;
    }

    public int getDestination() {
        return destination;
    }

    public int getWeight() {
        return weight;
    }

}

class Mst implements Comparator<MST> {

    @Override
    public int compare(MST o1, MST o2) {
        return o1.getWeight() - o2.getWeight();
    }

}

public class CommutableIslands {
    public static void main(String[] args) {
        CommutableIslands object = new CommutableIslands();
        int a = 4;
        int[][] b = {{1, 2, 1}, {2, 3, 2}, {3, 4, 4}, {1, 4, 3}
        };
        System.out.println(" Result -> " + object.solve(a, b));
    }

    public int solve(int A, int[][] B) {
        int minimumCost = 0;
        PriorityQueue<MST> pq = new PriorityQueue<MST>(new Mst());
        for (int i = 0; i < B.length; i++) {
            pq.add(new MST(B[i][0], B[i][1], B[i][2]));
        }
        int[] parArray = new int[A + 1];
        int[] rank = new int[A + 1];
        for (int j = 0; j < A + 1; j++) {
            parArray[j] = j;
        }
        while (!pq.isEmpty()) {
            MST object = pq.poll();
            if (findParent(object.getSource(), parArray) != findParent(object.getDestination(), parArray)) {
                minimumCost += object.getWeight();
                union(object.getSource(), object.getDestination(), parArray, rank);

            }

        }
        return minimumCost;
    }
    // find parent of vertex

    public int findParent(int u, int[] arr) {
        if (arr[u] == u) {
            return u;
        }
        return arr[u] = findParent(arr[u], arr);
    }

    public void union(int u, int v, int[] arr, int[] rank) {
        u = findParent(u, arr);
        v = findParent(v, arr);
        if (rank[u] < rank[v]) {
            arr[u] = v;
        } else if (arr[u] > arr[v]) {
            arr[v] = u;
        } else {
            arr[v] = u;
            rank[u]++;
        }

    }
}
