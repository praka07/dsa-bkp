package com.practice;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumber {
    public static void main(String[] args) {
        PhoneNumber obj = new PhoneNumber();
        System.out.println(obj.letterCombinations("23"));

    }

    public List<String> letterCombinations(String digits) {
        char[][] map = {{}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
        return formCombinations("", digits, map);

    }

    private List<String> formCombinations(String p, String up, char[][] map) {

        if (up.isEmpty()) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        int digit = up.charAt(0) - '0';
        List<String> res = new ArrayList<>();
        int k = (digit - 2) * 3;
        if (digit == 8 || digit == 9) {
            k += 1;
        }
        for (int i = k; i < k + map[digit].length; i++) {
            char ch = (char) ('a' + i);
            res.addAll(formCombinations(p + ch, up.substring(1), map));

        }

        return res;
    }
}
