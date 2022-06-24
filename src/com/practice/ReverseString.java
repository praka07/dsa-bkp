package com.practice;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the string");
        String input = sc.next();
        char[] array = input.toCharArray();
        for (int i = 0; i < array.length / 2; i++) {
            char temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        System.out.println(" reverse " + new String(array));
        System.out.println(recursiveString(input));
    }

    private static String recursiveString(String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }
        String subString = input.substring(1);
        char c = input.charAt(0);

        return recursiveString(input.substring(1)) + input.charAt(0);
    }

}
