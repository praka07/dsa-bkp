package com.practice;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

class ReverseComparator implements Comparator<Long> {

    @Override
    public int compare(Long o1, Long o2) {
        return (int) (o2 - o1);
    }


}

public class MagicianAndChocolates {
    public int nchoc(int A, int[] B) {
        int mod = 1000000007;
        PriorityQueue<Long> pr = new PriorityQueue<Long>(new ReverseComparator());
        long ans = 0;
        for (int i = 0; i < B.length; i++) {
            pr.add((long) B[i]);
        }
        while (A-- > 0) {
            long temp = pr.poll();
            ans = ans + temp;
            pr.add(temp / 2);

        }
        return (int) (ans % mod);
    }
}
