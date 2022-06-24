package com.practice;

import java.util.Arrays;
import java.util.LinkedList;

public class MakeCircleGraph {
    private int[] inDegree = new int[26];
    private int[] outDegree = new int[26];
    private boolean[] mark = new boolean[26];
    private LinkedList<Integer> adjLst[] = new LinkedList[26];

    public int solve(String[] A) {

        for (int i = 0; i < 26; i++) {
            adjLst[i] = new LinkedList<>();
        }
        for (int i = 0; i < A.length; i++) {
            String s = A[i];
            int u = s.charAt(0) - 'a';
            int v = s.charAt(s.length() - 1) - 'a';
            mark[u] = mark[v] = true;
            inDegree[u]++;
            outDegree[v]++;
            addEdge(u, v);
        }
        for (int i = 0; i < 26; i++) {
            if (inDegree[i] != outDegree[i]) return 0;
        }
        return isConnected(A[0].charAt(0) - 'a', 26);
    }

    private int isConnected(int s, int v) {
        boolean[] visited = new boolean[26];
        Arrays.fill(visited, false);
        dfs(s, visited);

        for (int i = 0; i < 26; i++)
            if (visited[i] == false && mark[i] == true)
                return 0;

        return 1;
    }

    private void dfs(int start, boolean[] visited) {
        visited[start] = true;
        for (int it : adjLst[start]) {
            if (visited[it] == false)
                dfs(it, visited);
        }
    }

    public void addEdge(int source, int destination) {
        adjLst[source].add(destination);
    }

    public static void main(String[] args) {
        MakeCircleGraph graph = new MakeCircleGraph();
        String[] A = {"aab", "bac", "aaa", "cda"};
        System.out.println(" result -> " + graph.solve(A));
    }
}
