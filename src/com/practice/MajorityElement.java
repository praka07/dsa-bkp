package com.practice;

import java.util.HashMap;

public class MajorityElement {
    public static void main(String[] args) {
        int[] a = {2, 1, 2};
        System.out.println(findMajority(a));


    }

    public static int findMajority(int[] a) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (frequencyMap.containsKey(a[i])) {
                int count = frequencyMap.get(a[i]) + 1;
                if (count > a.length / 2) {
                    return a[i];
                }else{
                    frequencyMap.put(a[i], count);
                }

            } else {
                frequencyMap.put(a[i], 1);
            }

        }
        return 0;
    }
}
