package com.practice;

import java.util.Arrays;

public class CoinProblem {
    public static void main(String[] args) {
        int n = 10, m = 4;
        int S[] = {2, 5, 3, 6};
       // int i1 = n + 1;
        long[] count= new long[n+1];
        Arrays.fill(count,1);
        for (int i = 1; i <= m; i++) {
            for (int j = S[i - 1]; j <= n; j++) {
                count[j] += count[j - S[i - 1]];
                System.out.print(" "+count[j]+" ");

            }

        }

       // System.out.println(Arrays.toString(count));
        //return count[n];
    }
}
