package com.practice;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SpecialMedianHeap {
    public boolean find(int[] A, PriorityQueue<Integer> max, PriorityQueue<Integer> min) {
        double currMedian = 0;
        max.add(A[0]);
        currMedian = A[0];
        for (int i = 1; i < A.length - 1; i++) {
            //insertion
            if (A[i] < currMedian) {
                max.add(A[i]);
                if (max.size() - min.size() > 1) {
                    int temp = max.poll();
                    min.add(temp);
                }
            } else {
                min.add(A[i]);
                if (min.size() - max.size() > 1) {
                    int temp = min.poll();
                    max.add(temp);
                }
            }
            int maxSize = max.size(), minSize = min.size();
            if (maxSize == minSize) {
                int mid1 = max.peek(), mid2 = min.peek();
                currMedian = ((double) mid1 + mid2) / 2;
            } else if (maxSize > minSize) {
                currMedian = max.peek();

            } else {
                currMedian = min.peek();
            }
            if (currMedian == A[i + 1]) {
                return true;
            }

        }
        return false;
    }

    public class CustomComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return (o2 - o1);

        }

    }

    public int solve(int[] A) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new CustomComparator());
        if (find(A, maxHeap, minHeap)) {
            return 1;
        }
        int n = A.length;
        for (int i = 0; i < n / 2; i++) {

            int temp = A[i];
            A[i] = A[n - i - 1];

            A[n - i - 1] = temp;
        }
        minHeap.clear();
        maxHeap.clear();
        if (find(A, maxHeap, minHeap)) {
            return 1;
        }
        return 0;

    }
}
