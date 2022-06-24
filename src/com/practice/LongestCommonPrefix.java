package com.practice;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] input = {"apple", "ape", "april","a"};
        StringBuilder prefix = new StringBuilder();
        String currentPrefix = input[0];
        for (int arrayString = 1; arrayString < input.length; arrayString++) {
            int j = 0, k = 0;
            while (j < input[arrayString].length() && k < currentPrefix.length()) {
                if(input[arrayString].charAt(j)==currentPrefix.charAt(k)){
                     prefix.append(currentPrefix.charAt(k));
                }
                j++;
                k++;

            }
            currentPrefix=prefix.toString();
            prefix= new StringBuilder();

        }
        System.out.println(currentPrefix);
    }

}
