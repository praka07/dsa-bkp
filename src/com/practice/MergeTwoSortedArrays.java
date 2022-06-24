package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeTwoSortedArrays {
    public ArrayList<Integer> solve(final List<Integer> A, final List<Integer> B) {
        ArrayList<Integer> mergedSortedList = new ArrayList<Integer>();
        int i = 0, j = 0;
        while (i < A.size() && j < B.size()) {
            if (A.get(i) < B.get(j)) {
                mergedSortedList.add(A.get(i));
                i++;


            } else {
                mergedSortedList.add(B.get(j));
                j++;
            }

        }
        while (i < A.size()) {
            mergedSortedList.add(A.get(i));
            i++;
        }
        while (j < B.size()) {
            mergedSortedList.add(B.get(j));
            j++;
        }
        return mergedSortedList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A= new ArrayList<Integer>();
        A.add(-4);
        A.add(-3);
        A.add(0);
        ArrayList<Integer> B= new ArrayList<Integer>();
        B.add(2);
        MergeTwoSortedArrays object= new MergeTwoSortedArrays();
        object.solve(A,B);


    }
}
