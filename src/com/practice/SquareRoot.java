package com.practice;

public class SquareRoot {
    public static void main(String[] args) {
        SquareRoot oSquareRoot= new SquareRoot();
        oSquareRoot.sqrt(11);
    }
    public int sqrt(int A) {
        int low = 1, high = A,ans=0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(mid<=A/mid){
                ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }
}
