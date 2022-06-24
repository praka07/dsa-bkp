package com.practice;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqCharVimeo {
    public static void main(String[] args) {
        String s = "loveleetcode";
        FirstUniqCharVimeo object = new FirstUniqCharVimeo();
        System.out.println(" -> " + object.firstUniqCharMap(s));
        System.out.println("->" + object.firstUniqCharArray(s));
    }

    // frequencyMap Approach
    public int firstUniqCharMap(String s) {
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> unique = new LinkedHashMap<>();
        // build hash map : character and how often it appears
        for (int i = 0; i < chars.length; i++) {
//            if (!unique.containsKey(chars[i])) {
//                unique.put(s.charAt(i), 1);
//
//            } else {
//                unique.put(chars[i], unique.get(chars[i]) + 1);
//            }
            unique.put(chars[i], unique.getOrDefault(chars[i], 0) + 1);
        }
        //find indes
        for (int j = 0; j < chars.length; j++) {
            if (unique.get(chars[j]) == 1) {
                return j;

            }
        }
        return -1;
    }

    public int firstUniqCharArray(String s) {
        int[] frequencyArray = new int[25];
        for (int i = 0; i < s.length(); i++) {
            frequencyArray[s.charAt(i) - 'a']++;
        }

        //find index
        for (int k = 0; k < frequencyArray.length; k++) {
            if (frequencyArray[k] == 1) {
                return k;
            }
        }
        return -1;
    }
}
