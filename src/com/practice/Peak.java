package com.practice;

public class Peak {
    public int solve(int[] A) {
        int low = 0, high = A.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (A[mid] < A[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid;


            }

        }
        return low;
    }
        public static void main (String[]args){
            Peak objPeak = new Peak();
            System.out.println("result " + objPeak.solve(new int[]{1, 2, 3, 4, 5}));

        }
    }
