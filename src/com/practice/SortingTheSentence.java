package com.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class SortingTheSentence {
    public static void main(String[] args) {
        String s = "sentence4 a3 is2 This1";
        String[] result = new String[s.split(" ").length];
        StringBuilder sb = new StringBuilder();
        for (String word : s.split(" ")) {
            int index = word.charAt(word.length() - 1) - '0';
            // System.out.println(" subString "+ word.substring(0, word.length()-1));
            result[index - 1] = word.substring(0, word.length() - 1);
            sb.append(result[index - 1]).append("");

        }

        sb.toString().trim();
        // System.out.println(Arrays.toString(result));
    }

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {

        String s = "Hello".toLowerCase();

        int match = 0;
        for (int itemIndex = 0; itemIndex < items.size(); itemIndex++) {
            if ("type".equalsIgnoreCase(ruleKey)) {
                if (ruleValue.equalsIgnoreCase(items.get(itemIndex).get(0))) {
                    match++;

                }

            } else if ("color".equalsIgnoreCase(ruleKey)) {
                if (ruleValue.equalsIgnoreCase(items.get(itemIndex).get(1))) {
                    match++;
                }

            } else {
                if (ruleValue.equalsIgnoreCase(items.get(itemIndex).get(2))) {
                    match++;
                }

            }


        }
        return match;
    }

    public String toLowerCase(String s) {

        char result[] = new char[s.length()];
        int i = 0;
        for (char c : s.toCharArray()) {
            int asci = c;
            result[i++] = (char) (asci + 32);
        }
        return new String(result);
    }

}

