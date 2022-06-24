package com.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class AthLargestElementHeap {
    public int[] solve(int A, int[] B) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        int[] solution = new int[B.length];
        int k = 0;
        // iterate array elements one by one
        for (int i = 1; i <= A; i++) {
            pq.add(B[i]);
            if (i < A) {
                solution[k++] = -1;
            } else if (i == A) {
                solution[k++] = pq.peek();

            }

        }
        for(int j=A+1;j<B.length;j++){
            if(pq.peek()<B[j]){
                pq.poll();
                pq.add(B[j]);

            }
            solution[k++]=B[j];
        }
        return solution;
    }

    public static void main(String[] args) {

        int A = 4;
        int[] B = {1, 2, 3, 4, 5, 6};
        AthLargestElementHeap object = new AthLargestElementHeap();
        System.out.println(Arrays.toString(object.solve(A, B)));

    }
}
