package com.practice;

public class DistributeCandyGreedy {
    public int candy(int[] A) {
        int totalCandy = 0;
        int[] leftToRight = new int[A.length];
        int[] rightToLeft = new int[A.length];
        leftToRight[0] = 1;
        rightToLeft[A.length - 1] = 1;
// compare only left neighbour
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] < A[i + 1]) {
                leftToRight[i + 1] = leftToRight[i] + 1;

            } else {
                leftToRight[i + 1] = 1;
            }


        }
//compare only right neighbour
        for (int j = A.length - 1; j > 0; j--) {
            if (A[j] < A[j - 1]) {
                rightToLeft[j - 1] = rightToLeft[j] + 1;

            } else {
                rightToLeft[j - 1] = 1;
            }
        }

        // get Max

        for (int k = 0; k < leftToRight.length; k++) {
            totalCandy = totalCandy + Math.max(leftToRight[k], rightToLeft[k]);
        }
        return totalCandy;
    }

    public static void main(String[] args) {
        int[] input = {1, 5, 2, 1};
        DistributeCandyGreedy object = new DistributeCandyGreedy();
        System.out.println("Total Candy " + object.candy(input));

    }
}
