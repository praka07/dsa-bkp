package com.practice;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class CustomComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return (o2 - o1);
    }


}

public class PriorityQueueUnderstanding {
    public static void main(String[] args) {
        PriorityQueue<Integer> prQueue = new PriorityQueue<>(new CustomComparator());
        int[] A = {3, 4, 6, 7, 2, 19, 10};
        for (int i = 0; i < A.length; i++) {
            prQueue.add(A[i]);
        }
        prQueue.add(4);
        System.out.println(prQueue);
        System.out.println('0');
        PriorityQueueUnderstanding obj= new PriorityQueueUnderstanding();
        obj.largestInteger(3214);
    }

    public int largestInteger(int num) {

        PriorityQueue<Integer> epq = new PriorityQueue<Integer>(new CustomComparator());
        PriorityQueue<Integer> opq = new PriorityQueue<Integer>(new CustomComparator());

        String nums = num + "";
        for (int i = 0; i < nums.length(); i++) {
            int digit = nums.charAt(i) - '0';
            if (digit % 2 == 0) {
                epq.add(digit);

            } else {
                opq.add(digit);
            }
        }

        String ans = "";

        for (int j = 0; j < nums.length(); j++) {
            int digit = nums.charAt(j) - '0';
            if (digit % 2 == 0) {
                ans = ans + epq.poll() + "";
            } else {
                ans = ans + opq.poll() + "";
            }
        }

        return Integer.parseInt(ans);
    }
}
