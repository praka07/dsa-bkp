package com.practice;

import java.util.ArrayList;

public class WordBreakTwo {
    public ArrayList<String> wordBreak(String A, ArrayList<String> B) {
        ArrayList<String> res = new ArrayList<String>();
        for (String word : B) {
            if (A.substring(0, word.length()) == word) {
                if (word.length() == A.length()) {
                    res.add(word);
                } else {
                    ArrayList<String> temp = wordBreak(A.substring(word.length()), B);
                    for (String t : temp) {
                        res.add(word+" "+t);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
