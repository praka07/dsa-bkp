package com.practice;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class CollectAllRewards {
    private LinkedList<Integer> adjLst[];
    static int paths = 0;

    public int numberOfPaths(int A, int[][] B) {
        adjLst = new LinkedList[A + 1];
        for (int i = 1; i <= A; i++) {
            adjLst[i] = new LinkedList<Integer>();
        }
        //add Edge
        for (int i = 0; i < B.length; i++) {
            addEdge(B[i][0], B[i][1]);
        }
        count(1, A);

        return paths;
    }

    public void count(int start, int target) {
        if (start == target) {
            // System.out.println(paths);
            paths++;
        } else {
            for (int i = 0; i < adjLst[start].size(); i++) {
                int adjVertex = adjLst[start].get(i);
                count(adjVertex, target);
            }
        }

    }

    public void addEdge(int source, int destination) {
        adjLst[source].add(destination);
    }

    public static void main(String[] args) {
        // int a = 11;
        //int[][] b = {{1, 2}, {1, 3}, {1, 4}, {2, 9}, {3, 8}, {4, 8}, {4, 7}, {4, 6}, {4, 5}, {5, 6}, {6, 10}, {7, 10}, {8, 10}, {9, 11}, {10, 11}};

        int a = 4;
        int[][] b = {{1, 2}, {2, 3}, {3, 4}};
        CollectAllRewards object = new CollectAllRewards();
        System.out.println(" total Path " + object.numberOfPaths(a, b));

    }
}
