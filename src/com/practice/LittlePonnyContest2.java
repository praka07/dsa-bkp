package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LittlePonnyContest2 {
    public static void main(String[] args) {

        LittlePonnyContest2 object = new LittlePonnyContest2();
        ArrayList<Integer> A = new ArrayList<Integer>();
        ArrayList<Integer> B = new ArrayList<Integer>();
        A.add(3);
        A.add(4);
        A.add(4);
        A.add(6);
        B.add(20);
        B.add(4);
        B.add(10);
        B.add(2);

        System.out.println("result " + Arrays.asList(object.solve(A, B)));


    }

    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {

        ArrayList<Integer> result = new ArrayList<Integer>();

     //   Set<Integer> withoutDuplicate = new HashSet<Integer>(A);

        for (int i = 0; i < B.size(); i++) {
            int sum = 0;
            int count = 0;
            for (int j = 0; j < A.size(); j++) {
                if (sum + A.get(j) <= B.get(i)) {
                    sum += A.get(j);
                    count++;

                }


            }

            result.add(count);

        }
        return result;
    }
}
