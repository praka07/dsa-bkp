package com.practice;

import java.util.ArrayList;

public class Solution {
    public ArrayList<ArrayList<String>> partition(String a) {
        ArrayList<ArrayList<String>> result = new ArrayList();
        helper(a, new ArrayList(), result);
        return result;

    }

    private void helper(String s, ArrayList<String> currList, ArrayList<ArrayList<String>> result) {
        if (s.isEmpty()) {
            result.add(currList);
        }
        for (int i = 1; i <= s.length(); i++) {
            String left = s.substring(0, i);
            String right = s.substring(i);
            if (isPalindrome(left)) {
                ArrayList<String> copyLst = new ArrayList<>(currList);
                copyLst.add(left);
                helper(right, copyLst, result);


            }

        }

    }

    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l <= r && s.charAt(l) == s.charAt(r)) {
            l++;
            r--;

        }
        return l >= r;

    }
}

