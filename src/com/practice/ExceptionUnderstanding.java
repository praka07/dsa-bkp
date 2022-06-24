package com.practice;

public class ExceptionUnderstanding {
    public static void main(String[] args) {
       // System.out.println(test());
        System.out.println(calculate(50));
    }

    private static String test() {
        try {
            int i = 4 / 0;
            return "A";
        } catch (Exception e) {
            return "B";
        } finally {
            return "C";
        }
    }

    public static  int calculate(int i) {
        return i ^ 40 ^ 50;
    }
}
