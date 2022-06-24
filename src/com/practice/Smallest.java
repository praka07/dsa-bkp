package com.practice;

import java.util.ArrayList;
import java.util.List;

public class Smallest {

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {

        // iterate List and get pairs

        char[] array = s.toCharArray();
        for (List<Integer> pair : pairs) {
            List<Integer> first = pair;
            System.out.println(first.get(0) + " " + first.get(1));
            char temp = array[first.get(0)];
            array[first.get(0)] = array[first.get(1)];
            array[first.get(1)] = temp;
            System.out.println(new String(array));


        }

        return new String(array);
    }

    public static void main(String[] args) {
        List<List<Integer>> pairs = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list.add(0);
        list.add(3);
        list1.add(1);
        list1.add(2);
        list2.add(0);
        list2.add(2);
        pairs.add(list);
        pairs.add(list1);
        Smallest obj = new Smallest();
        System.out.println(" final --  " + obj.smallestStringWithSwaps("dcab", pairs));


    }
}
