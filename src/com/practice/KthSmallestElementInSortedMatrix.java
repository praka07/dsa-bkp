package com.practice;

import java.util.PriorityQueue;

//see here in your code , you are iterating over n*m elements and inserting all of them in priority queue
//
//        so for iterating it take O(n*m) and for inserting in priority queue it takes log(size) times
//
//        here our size is (n*m)
//
//        so overall timecomplexity is O(n*m*(log(n*m)), now also in another loop you are iterating over B and removing the pop elements B times , so time complexity for this loop is O(B*log(n*m)) , now overall timecompleixty of the code will becomes
//
//        O(n*m*log(n*m)) + O(B*log(n*m))

public class KthSmallestElementInSortedMatrix {
    public int solve(int[][] A, int B) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                pq.add(A[i][j]);

            }
        }
        //System.out.println(pq);
        int m = 0;
        while (m < B - 1) {
         //   System.out.println(pq.poll());
            pq.poll();
            m++;
        }
       // System.out.println("after " + pq);
        return pq.peek();
    }

    public static void main(String[] args) {
        int[][] input = {{9, 11, 15}, {10, 15, 17}};
        int b = 6;
        KthSmallestElementInSortedMatrix object = new KthSmallestElementInSortedMatrix();
        System.out.println(" Kth element " + object.solve(input, b));

    }
}
