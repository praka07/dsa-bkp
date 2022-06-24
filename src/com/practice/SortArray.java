package com.practice;

import java.util.*;

public class SortArray {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(98, 84, 62, 93, 49, 47, 7, 91, 48, 66, 67, 28, 15, 70, 36, 63, 49, 9, 24, 94, 49, 69, 33, 64, 77, 78, 71, 72, 96, 81, 61, 99, 11, 36, 63, 37, 74, 59, 35, 77));
        ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(1, 19, 24, 18, 41, 26, 39, 3, 50, 27, 4, 11, 35, 12, 5, 38, 7, 45, 49, 2, 43, 10, 42, 14, 32));
        SortArray object = new SortArray();

        System.out.println("res " + Arrays.asList(object.solve(A, B)));
    }

    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        HashMap<Integer, Integer> mapArray = new HashMap<Integer, Integer>();
        ArrayList<Integer> remainingElements = new ArrayList<Integer>();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < A.size(); i++) {
            mapArray.put(A.get(i), mapArray.getOrDefault(A.get(i), 0) + 1);
        }
        int j;
        for (j = 0; j < B.size(); j++) {
            if (mapArray.containsKey(B.get(j))) {
                int frequency = mapArray.get(B.get(j));
                for (int k = 0; k < frequency; k++) {
                    ans.add(B.get(j));
                }
                mapArray.remove(B.get(j));
            }
        }

        // add remaining element from A

        for (Map.Entry<Integer, Integer> entry : mapArray.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                remainingElements.add(entry.getKey());
            }
        }
        Collections.sort(remainingElements);
        ans.addAll(remainingElements);

        return ans;
    }
}
