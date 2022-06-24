package com.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PerfectNumbersQ {
    public static void main(String[] args) {
        PerfectNumbersQ object = new PerfectNumbersQ();
        System.out.println("Ans " + object.solve(10));

    }

    public String solve(int A) {
        Queue<String> q = new LinkedList<String>();
        ArrayList<String> series = new ArrayList<String>();
        int index = A;
        q.add("1");
        q.add("2");
        while (A-- > 0) {
            String qEle = q.remove();
            // reverse the String
            String firstSeries = qEle + reverseString(qEle);
            series.add(firstSeries);
            String first = qEle + "1";
            q.add(first);
            String nextEle = qEle + "2";
            q.add(nextEle);
        }
        return series.get(index - 1);
    }

    private String reverseString(String qEle) {
        char[] charArray = qEle.toCharArray();
        for (int i = 0; i < charArray.length / 2; i++) {
            char temp = charArray[i];
            charArray[i] = charArray[charArray.length - i - 1];
            charArray[charArray.length - i - 1] = temp;

        }
        return new String(charArray);
    }
}
