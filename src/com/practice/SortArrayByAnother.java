package com.practice;

import java.util.*;

class SortPair {
    int time;
    int beauty;

    SortPair(int t, int b) {
        this.time = t;
        this.beauty = b;
    }
}

class SortComparator implements Comparator<SortPair> {
    @Override
    public int compare(SortPair f, SortPair s) {
        return (f.time - s.time);
    }
}

public class SortArrayByAnother {

    public static void main(String[] args) {
        int[] A = {3, 8, 7, 5};
        int[] B = {3, 1, 7, 19};
        int t = 0, profit = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<SortPair> elem = new ArrayList<SortPair>();
        for (int i = 0; i < A.length; i++) {
            elem.add(new SortPair(A[i], B[i]));
        }
        Collections.sort(elem, new SortComparator());
        int k = 0;
        for (SortPair e : elem) {
            A[k] = e.time;
            B[k] = e.beauty;
            k++;
        }
        for (SortPair e : elem) {
            if (t < e.time) {
                profit = profit + e.beauty;
                pq.add(e.beauty);
                t++;

            } else {

                if (pq.peek() < e.beauty) {
                    int min = pq.poll();
                    profit = profit - min;
                    profit = profit + e.beauty;
                    pq.add(e.beauty);

                }
            }
        }
    }

}
