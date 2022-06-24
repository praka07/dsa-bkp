package com.practice;

import java.util.LinkedList;
import java.util.Queue;

public class TaskSchedulingQ {
    public static void main(String[] args) {
       int[] A = {2, 3, 1, 5, 4};
        int []B = {1, 3, 5, 4, 2};
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < A.length; i++) {
            q.add(A[i]);
        }
        int ans = 0;
        for (int i = 0; i < B.length; i++) {
            while (B[i] != q.peek()) {
                ans++;
                q.add(q.remove());
            }
            q.remove();
            ans++;
        }
        System.out.println(ans);
       // return ans;
    }
}
