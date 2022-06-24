package com.practice;

import java.util.HashMap;

public class SubsetOfArray {
    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            frequencyMap.put(array[i], frequencyMap.getOrDefault(array[i], 0) + 1);
        }
        subset(frequencyMap, 0, frequencyMap.size());
    }

    public static void subset(HashMap<Integer, Integer> curr, int index, int n) {
        if (index == n) {
            for (int j = 0; j <= curr.size() - 1; j++) {
                for (int k = 0; k <= curr.get(j)-1; k++) {
                    System.out.println(curr.get(j));
                }
            }

        }
        int count = curr.get(index);
        for (int i = 0; i <= count; i++) {
            curr.put(index, i);
            subset(curr, index + 1, n);

        }

    }
}
