package com.practice;

import java.util.ArrayList;
import java.util.Collections;

public class CombinationSumII {
    ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> temp = new ArrayList<Integer>();

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        combination(A, 0, B, 0);
        return ans;
    }

    private void combination(ArrayList<Integer> A, int index, int target, int currentSum) {
        if (currentSum == target) {
            ans.add(new ArrayList<Integer>(temp));
            return;
        }
        for (int i = 0; i < A.size(); i++) {
            int currentNum = A.get(i);
            if (i > index && currentNum == A.get(i - 1)) {
                continue;

            }
            if (currentNum + currentSum > target) {
                break;
            }
            temp.add(currentNum);
            currentSum += currentNum;
            combination(A, i + 1, target, currentSum);
            temp.remove(temp.size() - 1);
            currentSum -= currentNum;
        }
    }
}
