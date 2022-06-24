package com.practice;

import java.util.HashMap;
import java.util.HashSet;

public class SubArraySum {
    public static void main(String[] args) {
        int[] input = {7, 1, 3, -2, 4, -1, -1, -1, 8};
        SubArraySum obj = new SubArraySum();
        obj.bruteForceApproach(input);
       // obj.optimalSolution(input);
    }

    private void bruteForceApproach(int[] input) {
        int sum = 0;
        for (int i = 0; i < input.length; i++) {
            sum = input[i];
            for (int j = i+1 ; j < input.length; j++) {
                sum += input[j];
                if (sum == 0) {
                    for (int s = i; s <= j; s++) {
                        System.out.print(" " + input[s]);

                    }
                }
            }

        }
    }

    private void optimalSolution(int[] input) {
        HashSet<Integer> hashSet = new HashSet<>();
        int[] psa = new int[input.length];
        // form prefix sum
        for (int i = 0; i < input.length; i++) {
            if (i == 0) {
                psa[i] = input[i];
            } else {
                psa[i] = psa[i - 1] + input[i];
            }

        }
        for (int ps = 0; ps < psa.length; ps++) {
            if (hashSet.contains(psa[ps])) {
                System.out.println(" found zero");
            } else {
                System.out.println(" no zero");
            }
        }
    }

    public int subarraySum(int[] nums, int k) {

        HashMap<Integer,Integer> map= new HashMap<>();
        int count=0;
        int[] psa= new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(i==0){
                psa[i]=nums[i];
            }else{
                int currentSum=psa[i-1]+nums[i];
                if(currentSum==k){
                    count++;
                }
                if(map.containsKey(currentSum-k)){
                    count+=map.get(currentSum-k);
                }else{
                    map.put(currentSum,map.getOrDefault(currentSum,0)+1);
                }


            }
        }
        return count;
    }
}
