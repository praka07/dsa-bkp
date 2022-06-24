package com.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Vector;

public class SmallestPrefixString {
    public static void main(String[] args) {
        String A = "abba";
        String B = "cdd";
        SmallestPrefixString object = new SmallestPrefixString();


    }



    public String getPermutation(int A, int B) {
        int fact = 1;
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i < A; i++) {
            fact = fact * i;
            numbers.add(i);
        }
        numbers.add(A);
        String ans = "";
        B = B - 1;
        while (true) {
            ans = ans + numbers.get(B / fact);
            numbers.remove(B / fact);
            if (numbers.size() == 0) {
                break;
            }

            B = B % fact;
            fact = fact / numbers.size();
        }
        return ans;
    }
}
