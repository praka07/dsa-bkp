package com.practice;

import java.util.Arrays;

public class SmallestElement {
    public int kthsmallest(final int[] A, int B) {
        int start=0,end=A.length-1;
        while(start<=end){
            int mid=(start+end)/2;
            if((mid==0 || A[mid-1]>= A[mid]) && (mid==A.length-1 || A[mid]>=A[mid+1])){
                return mid;
            }else if(mid>0 && A[mid-1]>A[mid]){
                end=mid-1;

            }else{
                start=mid+1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        SmallestElement smallestElement= new SmallestElement();
        int []A = new int[] { 8, 16, 80, 55, 32, 8, 38, 40, 65, 18, 15, 45, 50, 38, 54, 52, 23, 74, 81, 42, 28, 16, 66, 35, 91, 36, 44, 9, 85, 58, 59, 49, 75, 20, 87, 60, 17, 11, 39, 62, 20, 17, 46, 26, 81, 92 };
        int B=9;
        System.out.println("Array :::"+smallestElement.kthsmallest(A,B));

    }

}
