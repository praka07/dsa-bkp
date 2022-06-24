package com.practice;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatingCharacterQ {
    public static void main(String[] args) {
        String A = "abcabc";
        FirstNonRepeatingCharacterQ object = new FirstNonRepeatingCharacterQ();
        System.out.println("o/p " + object.solve(A));
    }

    public String solve(String A) {
        Queue<Character> ele = new LinkedList<Character>();
        int[] countArray = new int[26];
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < A.length(); i++) {
            ele.add(A.charAt(i));
            countArray[A.charAt(i) - 'a']++;
            while (!ele.isEmpty()) {
                if (countArray[ele.peek() - 'a'] > 1) {
                    ele.remove();

                } else {
                    output.append(ele.peek());
                    break;
                }

            }
            if (ele.isEmpty()) {
                output.append("#");
            }
        }
        return output.toString();
    }
}
