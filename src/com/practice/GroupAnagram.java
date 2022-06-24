package com.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagram {
    public static void main(String[] args) {
        GroupAnagram object = new GroupAnagram();
        String input[] = {"eat", "tea", "tan", "ate", "nat", "bat" };
       /* for (int i = 0; i < input.length; i++) {
            for (int j = i + 1; j < input.length; j++) {
                if (object.printGroupAnagram(input[i], input[j])) {
                    System.out.println(input[i] + " " + input[j]);
                }

            }
        }*/
        object.groupAnagrams(input);

    }

    // bruteforce approach
    public boolean printGroupAnagram(String first, String second) {
        int[] count = new int[26];
        if (first.length() != second.length()) {
            return false;
        }
        for (int i = 0; i < first.length(); i++) {
            //System.out.println((int) first.charAt(i));
            // System.out.println((int) 'a');
            count[first.charAt(i) - 'a']++;
            count[second.charAt(i) - 'a']--;
        }
        for (int t = 0; t < 26; t++) {
            if (count[t] != 0) {
                return false;
            }

        }
        return true;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character, Integer>, ArrayList<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for (String str : strs) {
            HashMap<Character, Integer> tempMapFrequency = new HashMap<>();
            for (int i = 0; i < str.length(); i++) {
                tempMapFrequency.put(str.charAt(i), tempMapFrequency.getOrDefault(str.charAt(i), 0) + 1);
            }
            if (map.containsKey(tempMapFrequency)) {
                map.get(tempMapFrequency).add(str);

            } else {
                ArrayList<String> temp = new ArrayList<String>();
                temp.add(str);
                map.put(tempMapFrequency, temp);


            }
        }

        for(HashMap<Character,Integer> res:map.keySet()){
            System.out.println(" "+map.get(res));
            result.add(map.get(res));
        }



        return result;

    }
}
