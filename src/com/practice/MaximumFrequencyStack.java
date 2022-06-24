package com.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MaximumFrequencyStack {
    static Map<Integer, Integer> freqMap = new HashMap<>();
    static Map<Integer, Stack<Integer>> freqStack = new HashMap<>();
    static int maxfreq = 0;

    public static void main(String[] args) {

        MaximumFrequencyStack object = new MaximumFrequencyStack();
        int[][] A = {{1, 8}, {1, 6}, {2, 0}, {2, 0}, {1, 7}};
        System.out.println(" result :: " + Arrays.toString(object.solve(A)));

    }

    public int[] solve(int[][] A) {
        int[] result = new int[A.length];
        int k = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A.length; i++) {
            // increment value in frequencyMap
            //updating the maxFreq
            //Adding value in freqStack
            if (A[i][0] == 1) {
                int freq = freqMap.getOrDefault(A[i][1], 0) + 1;
                freqMap.put(A[i][1], freq);
                if (freq > maxfreq)
                    maxfreq = freq;
                freqStack.computeIfAbsent(freq, z -> new Stack()).push(A[i][1]);
                result[k++] = -1;
            } else if (A[i][0] == 2) {
                Stack<Integer> temp = freqStack.get(maxfreq);
                int top = temp.pop();
                if (temp.isEmpty()) {
                    maxfreq--;
                }
                freqMap.put(top, freqMap.get(top) - 1);
                result[k++] = top;
            }
        }
        return result;
    }
}
