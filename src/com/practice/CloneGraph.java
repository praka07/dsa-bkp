package com.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
};

public class CloneGraph {
    HashMap<UndirectedGraphNode, UndirectedGraphNode> visited = new HashMap<>();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return node;
        }
        if (visited.containsKey(node)) {
            return visited.get(node);
        }
        UndirectedGraphNode cloneNode = new UndirectedGraphNode(node.label);
        visited.put(node, cloneNode);
        for (UndirectedGraphNode neighbour : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbour));
        }

        return cloneNode;
    }
}
