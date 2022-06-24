package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum3 {
    List<List<Integer>> result = new ArrayList<>();


    public static void main(String[] args) {
        CombinationSum3 obj = new CombinationSum3();
        System.out.println(Arrays.asList(obj.combinationSum3(3, 7)));
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> list = new ArrayList<>();
        tryCombination(1, k, n, list);
        return result;

    }

    void tryCombination(int start, int k, int n, List<Integer> combination) {

        // base condition
        if (combination.size() == k) {
            if (n == 0) {
                result.add(new ArrayList<Integer>(combination));
            }
            return;
        }


        for (int place = start; place <= 9; place++) {
            combination.add(place);
            tryCombination(place + 1, k, n - place, combination);
            combination.remove(combination.size() - 1);
        }

    }
}
