package com.practice;

import java.util.*;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {

        LongestConsecutiveSequence object = new LongestConsecutiveSequence();
        System.out.println(" Naive Approach " + findLongestConseqSubseq(new int[]{6, 4, 5, 2, 3}));
        System.out.println(" Best Approach " + longestConsSubSeq(new int[]{6, 4, 5, 2, 3}));


    }

    static int longestConsSubSeq(int[] A) {
        int max = Integer.MIN_VALUE;
        Set<Integer> ele = new HashSet<Integer>();
        for (int i = 0; i < A.length; i++) {
            ele.add(A[i]);

        }
        for (int num : A) {
            if (!ele.contains(num-1)) {
                int currentNum=num;
                int maxLength = 1;
                while (ele.contains(currentNum + 1)) {
                    maxLength+=1;
                    currentNum+=1;


                }
                max= Math.max(max, maxLength);
            }

        }
        return max;

    }

    // naive Appraoch
    static int findLongestConseqSubseq(int A[]) {
        int max = Integer.MIN_VALUE;
        Arrays.sort(A);
        List<Integer> removeDuplicate = new ArrayList<Integer>();
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] != A[i + 1]) {
                removeDuplicate.add(A[i]);
            }
        }
        int count = 0;
        for (int i = 0; i < removeDuplicate.size(); i++) {
            if (i > 0 && removeDuplicate.get(i) == removeDuplicate.get(i - 1) + 1) {
                count++;
            } else {
                count = 1;
            }
            max = Math.max(count, max);


        }

        return max;
    }

}
