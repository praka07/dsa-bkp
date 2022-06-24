package com.practice;

public class TwoSum2 {
    public static void main(String[] args) {
        TwoSum2 obj= new TwoSum2();
        System.out.println(obj.twoSum(new int[]{2,7,11,15},9));

    }
    public int[] twoSum(int[] numbers, int target) {
        int l=0;
        int r=numbers.length-1;
        int[] result= new int[2];

        while(l<r){

            if(numbers[l]+numbers[r]<target){
                l++;
            }else if(numbers[l]+numbers[r]>target){
                r--;
            }else if(numbers[l]+numbers[r]==target){
                result[0]=l;
                result[1]=r;
                return result;
            }

        }
        return result;

    }
}
