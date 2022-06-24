package com.practice;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int[] fib;

    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner sc = new Scanner(System.in);
        int positiveInteger = sc.nextInt();
        fib = new int[positiveInteger+1];
        Arrays.fill(fib, -1);

        System.out.println(findFib(positiveInteger));

    }

    static int findFib(int input) {
        if (input < 2) {
            return input;
        }

        if (fib[input] != -1) {
            return fib[input];
        }
        fib[input] = findFib(input - 1) + findFib(input - 2);
        return fib[input];
    }

}