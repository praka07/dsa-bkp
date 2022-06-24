package com.practice;

public class RecursionPower {
    public static void main(String[] args) {
        RecursionPower object = new RecursionPower();
        System.out.println(object.powSimple(2, 20));
    }

    public int pow(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        int ans = pow(base, exponent - 1) * base;
        return ans;


    }

    public int powSimple(int base, int exponent) {
        if (exponent == 0)
            return 1;
        if (exponent % 2 == 0) {
            int x = powSimple(base, exponent / 2);
            return x * x;

        } else {
            int x = powSimple(base, exponent / 2);
            return base * x * x;
        }
    }
}
