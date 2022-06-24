package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Anagram {
    public int solve(int A, String B) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0; i<B.length(); i++){
            Character ch = B.charAt(i);
           map.put(ch,map.getOrDefault(ch,0)+1);
        }

        for(Character i : map.keySet()){
            int val = map.get(i);
            if((val % A) != 0) {
                return -1;
            }
        }

        return 1;
    }
    public static void main(String[] args) {
        String[] A = {"abbbaabbbabbbbabababbbbbbbaabaaabbaaababbabbabbaababbbaaabbabaabbaabbabbbbbababbbababbbbaabababba", "abaaabbbabaaabbbbabaabbabaaaababbbbabbbaaaabaababbbbaaaabbbaaaabaabbaaabbaabaaabbabbaaaababbabbaa", "babbabbaaabbbbabaaaabaabaabbbabaabaaabbbbbbabbabababbbabaabaabbaabaabaabbaabbbabaabbbabaaaabbbbab", "bbbabaaabaaaaabaabaaaaaaabbabaaaabbababbabbabbaabbabaaabaabbbabbaabaabaabaaaabbabbabaaababbaababb", "abbbbbbbbbbbbabaabbbbabababaabaabbbababbabbabaaaabaabbabbaaabbaaaabbaabbbbbaaaabaaaaababababaabab", "aabbbbaaabbaabbbbabbbbbaabbababbbbababbbabaabbbbbbababaaaabbbabaabbbbabbbababbbaaabbabaaaabaaaaba", "abbaaababbbabbbbabababbbababbbaaaaabbbbbbaaaabbaaabbbbbbabbabbabbaabbbbaabaabbababbbaabbbaababbaa", "aabaaabaaaaaabbbbaabbabaaaabbaababaaabbabbaaaaababaaabaabbbabbababaabababbaabaababbaabbabbbaaabbb"};
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (checkAnagram(A[i], A[j])) {
                    ArrayList<Integer> result1 = new ArrayList<>();
                    result1.add((i + 1));
                    result1.add((j + 1));

                    result.add(result1);
                }
            }
        }
        System.out.println(Arrays.asList(result));

    }

    private static boolean checkAnagram(String s, String s1) {
        int count[] = new int[26];
        if (s.length() != s1.length()) {
            return false;

        }
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[s1.charAt(i) - 'a']--;

        }
        for (int i = 0; i < 26; i++)
            if (count[i] != 0) {
                return false;
            }
        return true;
    }

}
