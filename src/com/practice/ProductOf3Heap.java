package com.practice;

import java.util.Collections;
import java.util.PriorityQueue;

public class ProductOf3Heap {
    public int[] naviveApproach(int[] A) {
        int[] result = new int[A.length];
        result[0] = -1;
        result[1] = -1;
        for (int i = 2; i < A.length; i++) {
            int product = A[0];
            for (int j = 0; j <= i; j++) {
                product *= A[j];

            }
            result[i] = product;

        }

        return result;
    }

    public int[] solve(int[] A) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        int[] result = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            priorityQueue.add(A[i]);
            if (i < 2) {
                result[i] = -1;
            } else {
                int firstMax = priorityQueue.poll();
                int secondMax = priorityQueue.poll();
                int thirdMax = priorityQueue.poll();
                priorityQueue.add(firstMax);
                priorityQueue.add(secondMax);
                priorityQueue.add(thirdMax);
                result[i] = firstMax * secondMax * thirdMax;


            }


        }
        return result;
    }

    public static void main(String[] args) {
        ProductOf3Heap object = new ProductOf3Heap();
        System.out.println("first " + object.solve(new int[]{20, 10, 8, 3, 22,100}));

    }
}
