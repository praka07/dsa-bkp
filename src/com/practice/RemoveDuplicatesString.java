package com.practice;

import java.util.*;

public class RemoveDuplicatesString {
    public static void main(String[] args) {
        String input = "prakash";
        HashMap<Character, Integer> frequencyMap = new LinkedHashMap<>();
        for (int i = 0; i < input.length(); i++) {
            frequencyMap.put(input.charAt(i), frequencyMap.getOrDefault(input.charAt(i), 0) + 1);
        }
        for (Map.Entry<Character, Integer> keyPair : frequencyMap.entrySet()) {
            if (keyPair.getValue() == 1) {
                System.out.print(keyPair.getKey());
            }
        }
    }
}