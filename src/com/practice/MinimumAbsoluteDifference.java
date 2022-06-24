package com.practice;

import java.util.Arrays;

public class MinimumAbsoluteDifference {
    public int solve(int[] A) {
        int ans=Integer.MAX_VALUE;
        Arrays.sort(A);
        for(int i=0;i<A.length-1;i++){
            ans = Math.min(ans, A[i+1] - A[i]);
        }
        return ans;
    }
    public static void main(String[] args) {
        MinimumAbsoluteDifference obj= new MinimumAbsoluteDifference();
        System.out.println("result "+obj.solve(new int[]{5, 17, 100, 11}));

    }
}
