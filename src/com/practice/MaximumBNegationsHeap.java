package com.practice;

import java.util.PriorityQueue;

public class MaximumBNegationsHeap {
    public int solve(int[] A) {
        PriorityQueue<Integer> pr = new PriorityQueue<>();
        for (int i = 0; i < A.length; i++) {
            pr.add(A[i]);
        }
        int minCost = 0;
        while (pr.size() > 1) {
            int tempCost = pr.poll() + pr.poll();
            minCost += tempCost;
            pr.add(tempCost);
        }
        return minCost;
    }

    public static void main(String[] args) {

        int[] A = {1, 2, 3, 4, 5};

        MaximumBNegationsHeap object = new MaximumBNegationsHeap();
        System.out.println(" max " + object.solve(A));

    }

}
