package com.practice;

public class CheckForBSTWithOneChildTree {
    public String solve(int[] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] > A[j]) {
                    return "NO";
                }
            }
        }

        return "YES";
    }

    public static void main(String[] args) {
        int[] input = {9, 8, 5, 7, 6};
        CheckForBSTWithOneChildTree object = new CheckForBSTWithOneChildTree();
        System.out.println(" output " + object.solve(input));
    }
}
