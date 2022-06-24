package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum3 {
    public static void main(String[] args) {

        int[] nums = {-1, 0, 1, 2, -1, -4};
        Sum3 obj = new Sum3();
        System.out.println(" --- " + Arrays.asList(obj.threeSum(nums)));

    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        //int[] nums = {-1, 0, 1, 2, -1, -4};
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i + 1; j < nums.length-1; j++) {
                for (int k = j + 1; k < nums.length-1; k++) {
                    if ((nums[i] + nums[j] + nums[k] == 0) && (nums[i] != nums[j]) && (nums[i] != nums[k]) && (nums[j] != nums[k])) {
                        List<Integer> ansInner = new ArrayList<>();
                        ansInner.add(nums[i]);
                        ansInner.add(nums[j]);
                        ansInner.add(nums[k]);
                        ans.add(ansInner);
                    }
                }

            }
        }

        return ans;
    }
}