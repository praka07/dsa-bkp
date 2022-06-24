package com.practice;

public class WeirdFunction {
    public int sum(int A, int[] B) {
        long ans = 0;
       long m=1000000007;
        for (int i = 0; i < B.length; i++) {
            for (int j = i + 1; j < B.length; j++) {
                System.out.println("pair " + "i " + B[i] + " j " + B[j]);
                ans = ans %m  + calculation(B[i], B[j]);
                System.out.println("inside "+ans);

            }
        }
        System.out.println("outside "+ans);
        return (int) ((ans%m+m) % m);
    }

    public int calculation(int a, int b) {
        int result = 0;
        long m=1000000007;
        if (Math.abs(a - b) > 1) {
            result = (int)((b - a)%m);

        }
        if (Math.abs(a - b) <= 1) {
            result = 0;
        }
        return result;

    }

    public static void main(String[] args) {

        WeirdFunction object = new WeirdFunction();
        int[] A = {1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000};
        int N = 9;
        System.out.println(" Result --  :::" + object.sum(N, A));

    }
}
