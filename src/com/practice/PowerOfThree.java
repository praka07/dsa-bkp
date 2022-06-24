package com.practice;

public class PowerOfThree {
    public static void main(String[] args) {
        int n = 27;
        PowerOfThree obj = new PowerOfThree();
        System.out.println(obj.isPowerOfThree(n));

    }

    public boolean isPowerOfThree(int n) {

        if (n == 0) {
            return false;
        }

        while (n % 3 == 0) {
            n = n / 3;
        }
        return n == 1;
    }
}
