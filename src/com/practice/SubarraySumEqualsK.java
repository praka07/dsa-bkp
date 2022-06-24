package com.practice;

import java.util.HashMap;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        SubarraySumEqualsK k = new SubarraySumEqualsK();
        int[] input = {1, 2, 3};
        System.out.println(k.subarraySum(input, 3));

    }

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int currentSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            if (currentSum == k) {
                count++;
            }
            if (map.containsKey(currentSum - k)) {
                count += map.get(currentSum - k);
            }
            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        }
        return count;
    }

}
