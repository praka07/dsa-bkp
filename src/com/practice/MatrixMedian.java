package com.practice;

import java.util.Arrays;

public class MatrixMedian {
    public int findMedian(int[][] A) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i=0;i<A.length;i++){
            max = Math.max(max,A[i][A[i].length-1]);
            min = Math.min(min,A[i][0]);
        }
        int median = (1+A.length*A[0].length)/2;
        while(min<max){
            int total_count = 0;//keep count of all the elements smaller or equals till mid
            int mid = min + (max -min)/2;
            for(int i=0;i<A.length;i++){
                int index = Arrays.binarySearch(A[i],mid);

                if(index<0){//element not present
                    index = Math.abs(index)-1;
                }else{
                    //but hey!! there could be more than one occurance of same number
                    while(index<A[i].length && A[i][index]==mid){
                        index++;//going till last element
                    }
                }
                total_count += index;//add element seen which are lesser or equal to mid
            }

            if(total_count<median){
                min = mid + 1; //Here we are ingnoring first half of matrix
            }else{
                max = mid; //here we are keeping the second half + mid
            }

        }
        return min;//or return max, it's the same thing

    }
    public static void main(String[] args) {
        MatrixMedian object= new MatrixMedian();
        int[][] input={{1,3,5},{2,6,9},{3,6,9}};
        System.out.println("Median "+object.findMedian(input));
    }
}
