package com.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class SortedInsertPosition {
    public int searchInsert(ArrayList<Integer> A, int B) {
        int start = 0, end = A.size()-1;

        if (B > A.get(end)) {
            return A.size() ;

        }
        if (B < A.get(start)) {
            return -1;
        }
        while (start <= end) {
            int mid = (start + end) / 2;
            if (A.get(mid) == B) {
                return mid;
            }

            if (B < A.get(mid).intValue()) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(1));
        SortedInsertPosition sortedInsertPosition = new SortedInsertPosition();
        System.out.println("position :::" + sortedInsertPosition.searchInsert(input, 1));


    }
}
