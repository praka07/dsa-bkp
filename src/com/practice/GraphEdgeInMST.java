package com.practice;

import java.util.*;

class Vertex {
    int source;
    int destionation;
    int weight;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return source == vertex.source && destionation == vertex.destionation && weight == vertex.weight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, destionation, weight);
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getSource() {
        return source;
    }

    public int getDestionation() {
        return destionation;
    }

    public void setDestionation(int destionation) {
        this.destionation = destionation;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "source=" + source +
                ", destionation=" + destionation +
                ", weight=" + weight +
                '}';
    }

    public void setSource(int source) {
        this.source = source;
    }

    public Vertex(int s, int d, int w) {
        this.source = s;
        this.destionation = d;
        this.weight = w;
    }
}

class CustomComparatorWeight implements Comparator<Vertex> {
    @Override
    public int compare(Vertex o1, Vertex o2) {
        return o1.getWeight() - o2.getWeight();
    }


}

public class GraphEdgeInMST {
    public static void main(String[] args) {
        GraphEdgeInMST object = new GraphEdgeInMST();
        int a = 2;
        int[][] b = {{1, 2, 42}
               };
        System.out.println(" Result -> " + Arrays.toString(object.solve(a, b)));
    }

    public int[] solve(int A, int[][] B) {
        int m = B.length;
        int[] solution = new int[m];
        PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>(new CustomComparatorWeight());
        HashMap<Vertex, Integer> map = new HashMap<>();
        // sort all the edges based on weight
        for (int i = 0; i < B.length; i++) {
            pq.add(new Vertex(B[i][0], B[i][1], B[i][2]));
        }

        int parent[] = new int[A + 1];
        int rank[] = new int[A + 1];

        for (int i = 0; i < A + 1; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        // Disjoint union sets
        int k = 0;
        while (!pq.isEmpty()) {
            Vertex temp = pq.poll();
            if (findPar(temp.getSource(), parent) != findPar(temp.getDestionation(), parent)) {
                System.out.println(" soure --> " + temp.getSource() + " des --> " + temp.getDestionation());
                map.put(new Vertex(temp.getSource(), temp.destionation, temp.getWeight()), 1);
                union(temp.getSource(), temp.getDestionation(), parent, rank);
            } else {
                System.out.println(" in else  soure --> " + temp.getSource() + " des --> " + temp.getDestionation());
                map.put(new Vertex(temp.getSource(), temp.destionation, temp.getWeight()), 0);
            }
        }
        for (int i = 0; i < B.length; i++) {
            solution[i] = map.get(new Vertex(B[i][0], B[i][1], B[i][2]));
        }
        return solution;

    }

    private int findPar(int u, int parent[]) {
        if (u == parent[u]) return u;
        return parent[u] = findPar(parent[u], parent);
    }

    private void union(int u, int v, int parent[], int rank[]) {
        u = findPar(u, parent);
        v = findPar(v, parent);
        if (rank[u] < rank[v]) {
            parent[u] = v;
        } else if (rank[v] < rank[u]) {
            parent[v] = u;
        } else {
            parent[v] = u;
            rank[u]++;
        }
    }

}
