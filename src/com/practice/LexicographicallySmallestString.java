package com.practice;

import java.util.HashMap;
import java.util.Stack;

public class LexicographicallySmallestString {
    public static void main(String[] args) {
        String s = "yzxyz";
        //  int[] count = new int[26];
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Integer> freqCount = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            //count[s.charAt(i) - 'a']++;
            freqCount.put(s.charAt(i), freqCount.getOrDefault(s.charAt(i), 0) + 1);
        }
        //System.out.println(count);
        for (int j = 0; j < s.length(); j++) {
            System.out.println(stack.peek());
            System.out.println(s.charAt(j));
            freqCount.put(s.charAt(j), freqCount.get(s.charAt(j)) - 1);
            while (s.charAt(j) < stack.peek() && !stack.isEmpty()) {
                stack.pop();

            }
            stack.push(s.charAt(j));
        }
        System.out.println(stack);
    }
}
