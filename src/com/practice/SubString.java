package com.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class SubString {
    public static void main(String[] args) {
        SubString object = new SubString();
        object.findCount("aab");
    }

    private void findCount(String A) {
        int countA=0;
        for(int i=0;i<A.length();i++){
            if(A.charAt(i)=='a'){
                countA++;
            }

        }
       int result=countA*(countA+1)/2;
        System.out.println(result);
    }
    private void findCount1(String A) {
        for (int len = 1; len <= A.length(); len++) {
            // Pick ending point
            for (int i = 0; i <= A.length() - len; i++) {
                //  Print characters from current
                // starting point to current ending
                // point.
                int j = i + len - 1;
                for (int k = i; k <= j; k++) {
                    System.out.print(A.charAt(k));
                }

                System.out.println();
            }
        }
    }
}
