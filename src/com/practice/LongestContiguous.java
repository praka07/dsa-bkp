package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class LongestContiguous {
    public ArrayList<Integer> findoutLongestContiguous(int[] input) {
        ArrayList<Integer> result = new ArrayList<>();
        int maxValue = 1, l = 1, startPosition = 0;
        for (int i = 1; i < input.length; i++) {
            if (input[i] > input[i - 1])
                l++;
            else {
                if (maxValue < l) {
                    maxValue = l;
                    startPosition = i - maxValue;
                }
                l = 1;
            }
        }
        if (maxValue < l) {
            maxValue = l;
            startPosition = input.length - maxValue;
        }
        for (int i = startPosition; i < maxValue + startPosition; i++)
            result.add(input[i]);
        return result;
    }

    public static void main(String[] args) {
        int[] A = {5, 16, 17, 3, 4, 5, 6, 9, 12, 4, 5};
        LongestContiguous object = new LongestContiguous();
        System.out.println(" result " + Arrays.asList(object.findoutLongestContiguous(A)));
    }
}
