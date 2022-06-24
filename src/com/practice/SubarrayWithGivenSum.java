package com.practice;

import java.util.Arrays;

public class SubarrayWithGivenSum {
    public int[] solve(int[] A, int B) {
        int left = 0, right = 1, currentSum = A[0];
        Arrays.sort(A);
        while (left <A.length && right<A.length) {
            if (currentSum < B) {
                currentSum+=A[right];
                right++;
            } else if (currentSum > B) {

                currentSum -= A[left];
                left++;

            } else if(currentSum==B) {
                return new int[]{left, right};
            }
        }


        return new int[]{-1};
    }

    public static void main(String[] args) {
        SubarrayWithGivenSum oGivenSum = new SubarrayWithGivenSum();
        System.out.println("Result ::: "+ oGivenSum.solve(new int[] { 1, 1000000000 },1000000000));

    }
}
