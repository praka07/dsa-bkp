package com.practice;

import java.util.HashMap;
import java.util.Map;

public class PairSum {
    public static void main(String[] args) {

    }

    public int solve(int[] A, int B) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            frequencyMap.put(A[i],frequencyMap.getOrDefault(A[i],0)+1);
        }
        for (Map.Entry<Integer, Integer> x : frequencyMap.entrySet()) {
            if (B == 0 && frequencyMap.get(x.getKey()) > 1) {
                ans++;
            } else if (B>0 && frequencyMap.containsKey(B+ x.getKey())) {
                ans++;

            }

        }
        return ans;
    }
}
