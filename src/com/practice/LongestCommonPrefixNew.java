package com.practice;

public class LongestCommonPrefixNew {
    public static void main(String[] args) {

        String[] strs = {"flower", "flow", "flight"};
        String ans = strs[0];
        int length = strs.length;

        LongestCommonPrefixNew obj = new LongestCommonPrefixNew();
        System.out.println(longestCommonPrefix(strs, strs.length));
       /* for (int i = 1; i < length; i++) {
            ans = obj.commonPrefix(ans, strs[i]);
        }
        System.out.println(ans);*/
        //return ans;
    }

    public String commonPrefix(String first, String second) {

        StringBuilder sb = new StringBuilder();

        if (first.length() > second.length()) {
            String temp = first;
            first = second;
            second = temp;
        }

        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) == second.charAt(i)) {
                sb.append(first.charAt(i));
            } else {
                break;
            }


        }

        return sb.toString();
    }

    public static int findMinLength(String S[], int n) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= (n - 1); i++) {
            if (S[i].length() < min) {
                min = S[i].length();
            }
        }
        return min;
    }

    public static boolean allContainsPrefix(String S[], int n,
                                            String str, int start, int end) {
        for (int i = 0; i <= (n - 1); i++) {
            String S_i = S[i];

            for (int j = start; j <= end; j++)
                if (S_i.charAt(j) != str.charAt(j))
                    return false;
        }
        return true;
    }

    public static String longestCommonPrefix(String S[], int n) {
        int index = findMinLength(S, n);
        String prefix = "";
        int low = 0, high = index - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (allContainsPrefix(S, n, S[0], low,
                    mid)) {
                prefix = prefix + S[0].substring(low, mid + 1);
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return prefix;
    }
}
