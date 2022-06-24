package com.practice;

public class RecursionSumOfDigit {
    public static void main(String[] args) {
        int digit = 12345;
        System.out.println(sumOfDigit(digit));
    }

    private static int sumOfDigit(int digit) {

        if (digit == 0) {

            return 0;

        }
        int lastDigit = digit % 10;
        int remainingDigit = digit / 10;
        return sumOfDigit(remainingDigit) + lastDigit;


    }
}
