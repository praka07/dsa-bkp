package com.practice;

public class ReverseNumber {
    public static void main(String[] args) {
        ReverseNumber obj = new ReverseNumber();
        System.out.println(obj.reverse(-123));

    }

    public int reverse(int x) {
        int sign = x < 0 ? -1 : 1;
        int reverseNumber = 0;
        while (x != 0) {
            int number = x % 10;
            reverseNumber = reverseNumber * 10 + number;
            x = x / 10;
        }
        //  System.out.println(reverseNumber);
        return  reverseNumber;
    }
}
