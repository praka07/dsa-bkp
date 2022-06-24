package com.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ContainsDuplicate2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, List<Integer>> indices = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> lst = indices.getOrDefault(nums[i], new ArrayList<>());
            for (int j : lst) {
                if (Math.abs(i - 1) <= k) {
                    return true;
                }
            }
            System.out.println(i);
            lst.add(i);
            indices.put(nums[i], lst);
        }


        return false;

    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        HashMap<Integer, List<Integer>> indices = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> lst = indices.getOrDefault(nums[i], new ArrayList<Integer>());
            for (int j : lst) {
                int conditionOne = Math.abs(nums[i] - nums[j]);
                int conditionTwo = Math.abs(i - j);
                if (conditionOne <= t && conditionTwo <= k) {
                    return true;
                }
            }
            lst.add(i);
            indices.put(nums[i], lst);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {8, 7, 15, 1, 6, 1, 9, 15};
        int k = 1;
        int t = 3;
        ContainsDuplicate2 obj = new ContainsDuplicate2();
        //System.out.println(obj.containsNearbyDuplicate(nums, k));
        System.out.println(obj.containsNearbyAlmostDuplicate(nums, k, t));
    }
}
