package com.practice;

import javax.print.DocFlavor;
import java.util.Arrays;

public class ReverseWordOfStrng {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();
        String s = "crulgzfkif gg ombt vemmoxrgf qoddptokkz op xdq hv ";
        String[] afterSplit = s.split(" ");


        for (int i = afterSplit.length - 1; i >= 0; i--) {
            if (afterSplit[i].length() != 0) {
                result.append(reverseString(reverseString(afterSplit[i]))).append(" ");

            }


        }
        System.out.println(result.toString().trim());

    }

    public static String reverseString(String A) {
        char[] word = A.toCharArray();
        StringBuilder reverseString = new StringBuilder();
        for (int i = 0; i < word.length / 2; i++) {
            char temp = word[i];
            word[i] = word[word.length - i - 1];
            word[word.length - i - 1] = temp;


        }
        reverseString.append(word);
        return reverseString.toString();
    }

}
