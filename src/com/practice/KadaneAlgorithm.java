package com.practice;

public class KadaneAlgorithm {
    public static void main(String[] args) {
        KadaneAlgorithm object = new KadaneAlgorithm();
        object.understand(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        object.efficientApproach(new int[]{-2, 3, -1, 2});
    }

    public void efficientApproach(int[] a) {
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            currentSum += a[i];
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
            if (currentSum < 0) {
                currentSum = 0;
            }

        }
        System.out.println("rsult " + maxSum);

    }

    public void understand(int[] a) {
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            int currentSum = 0;
            for (int j = i; j < a.length; j++) {
                currentSum += a[j];
                ans = Math.max(ans, currentSum);

            }
        }
        System.out.println(ans);
    }
}
