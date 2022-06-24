package com.practice;

public class IsMagicRecursion {
    int temp = 0;

    public static void main(String[] args) {
        IsMagicRecursion object = new IsMagicRecursion();
        System.out.println(object.solve(83557));

    }

    public int solve(int A) {
        temp = A;
        while (temp > 9) {
            temp = isMagic(temp);
        }
        System.out.println("-- temp --" + temp);

        if (temp == 1) {
            return 1;
        } else {
            return 0;
        }


    }

    public int isMagic(int input) {
        if (input == 0) {
            return 0;
        } else {
            return input % 10 + isMagic(input / 10);
        }
    }
}
