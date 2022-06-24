package com.practice;

public class KMPUNderstanding {
    public static void main(String[] args) {
        KMPUNderstanding object = new KMPUNderstanding();
        String A = "aabaabaaa";
        System.out.println(object.solve(A));

    }

    public int solve(String A) {
        String reverseInput = reverseString(A);
        String concat = A + "$" + reverseInput;
        int[] lps = new int[concat.length()];
        lps[0] = 0;
        int i = 0, j = 1;
        while (i < lps.length && j < lps.length) {
            if (concat.charAt(i) == concat.charAt(j)) {
                lps[j] = i + 1;
                i++;
                j++;

            } else {
                if (i == 0) {
                    lps[j] = 0;
                    j++;
                } else {
                    i = lps[i - 1];
                }

            }
        }
        return A.length() - lps[lps.length - 1];

    }

    private String reverseString(String a) {
        char[] input = a.toCharArray();
        for (int i = 0; i < input.length / 2; i++) {
            char temp = input[i];
            input[i] = input[input.length - i - 1];
            input[input.length - i - 1] = temp;

        }
     //   System.out.println(" reverse--"+new String(input));
        return new String(input);
    }
}
