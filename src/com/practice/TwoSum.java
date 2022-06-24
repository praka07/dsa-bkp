package com.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {

      /*  int[] ans = new int[2];

        Hashtable<Integer, Integer> elementIndex = new Hashtable<>();
        for (int i = 0; i < nums.length; i++) {
            int tempDifference = target - nums[i];
            if (!elementIndex.containsKey(tempDifference)) {
                elementIndex.put(nums[i], i);

            } else {
                ans[0] = elementIndex.get(tempDifference);
                ans[1] = i;
                return ans;

            }
        }
        return ans;*/
        int[] result = new int[2];
        HashMap<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (frequencyMap.containsKey(target - nums[i])) {
                result[0] = frequencyMap.get(target - nums[i]);
                result[1] = i;
                return result;
            } else {
                frequencyMap.put(target - nums[i], i);
            }

        }
        return result;

    }

    public static void main(String[] args) {
        int[] a = {2, 7, 11, 15};
        int t = 9;
        TwoSum object = new TwoSum();
        System.out.println(" -> " + Arrays.toString(object.twoSum(a, t)));


    }
}
