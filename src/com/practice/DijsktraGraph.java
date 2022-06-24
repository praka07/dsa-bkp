package com.practice;

import java.util.*;

class Edge {
    int node;
    int distance;


    Edge(int vertex, int weight) {
        this.node = vertex;
        this.distance = weight;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "distance=" + distance +
                ", node=" + node +
                '}';
    }

    public int getVertex() {
        return node;
    }

}

class CustomComparatorEdge implements Comparator<Edge> {

    @Override
    public int compare(Edge node1, Edge node2) {
        return node1.distance - node2.distance;
    }
}

public class DijsktraGraph {
    private LinkedList<Edge> adjLst[];

    public int[] solve(int A, int[][] B, int C) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(new CustomComparatorEdge());
        int[] distanceArray = new int[A];
        Arrays.fill(distanceArray,Integer.MAX_VALUE);
        adjLst = new LinkedList[A];
        // allocate size to list
        for (int i = 0; i < A; i++) {
            adjLst[i] = new LinkedList<Edge>();
        }
        // add Edge
        for (int i = 0; i < B.length; i++) {
            addEdge(B[i][0], B[i][1], B[i][2]);
        }
        // add source
        pq.add(new Edge(C, 0));
        distanceArray[C] = 0;

        if (!pq.isEmpty()) {
            Edge node = pq.poll();
            Iterator<Edge> it = adjLst[node.getVertex()].listIterator();
            while (it.hasNext()) {
                Edge adjNode = it.next();
                if (distanceArray[node.getVertex()] + adjNode.getDistance() < distanceArray[adjNode.getVertex()]) {
                    distanceArray[adjNode.getVertex()] = distanceArray[node.getVertex()] + adjNode.getDistance();
                    pq.add(new Edge(adjNode.getVertex(), distanceArray[adjNode.getVertex()]));
                }


            }
        }
        for(int i=0;i<distanceArray.length;i++){
            if(distanceArray[i]==Integer.MAX_VALUE){
                distanceArray[i]=-1;
            }
        }
        return distanceArray;
    }

    private void addEdge(int source, int destination, int weight) {
        adjLst[source].add(new Edge(destination, weight));
        adjLst[destination].add(new Edge(source, weight));
    }

    public static void main(String[] args) {
        DijsktraGraph object = new DijsktraGraph();
        int a = 6;
        int[][] b = {{0, 4, 9},
                {3, 4, 6},
                {1, 2, 1},
                {2, 5, 1},
                {2, 4, 5},
                {0, 3, 7},
                {0, 1, 1},
                {4, 5, 7},
                {0, 5, 1}};
        int c = 4;
        System.out.println(" " + Arrays.toString(object.solve(a, b, c)));
    }
}
