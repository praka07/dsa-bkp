package com.practice;

public class GoodString {
    public static void main(String[] args) {
        GoodString obj = new GoodString();
        System.out.println(obj.countGoodSubstrings("aababcabc"));
    }

    public int countGoodSubstrings(String s) {

        int goodSubStringCount = 0;

        char[] charArray = s.toCharArray();
        for (int k = 0; k <= charArray.length-3; k++) {
            if (checkUnique(s.substring(k, k + 3))) {
                goodSubStringCount++;
            }
        }

        return goodSubStringCount;

    }

    public boolean checkUnique(String s) {
        boolean[] array = new boolean[26];
        System.out.println("string -- " + s);
        for (char c : s.toCharArray()) {
            if (array[c - 'a']) {
                return false;
            } else {
                array[c - 'a'] = true;
            }
        }

        return true;
    }
}
