package com.practice;

public class LBSdp {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int i = 0, j = 1;
        int max = 0;
        while (i < prices.length && j < prices.length) {
            if (prices[j] - prices[i] > 0) {
                max = max+(prices[j]-prices[i]);

            }
            i++;
            j++;
        }
        System.out.println(max);

    }

    public int LBSlength(final String A) {
        int[] dp = new int[A.length()];

        for (int i = 0; i < A.length(); i++) {
            if (isOpen(A.charAt(i))) {
                dp[i] = 0;
            } else {

            }
        }

        return 0;
    }

    public static boolean isOpen(char check) {
        return (check == '(' || check == '[' || check == '{') ? true : false;
    }
}
