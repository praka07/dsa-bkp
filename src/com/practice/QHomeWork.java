package com.practice;

import java.util.LinkedList;
import java.util.Queue;

public class QHomeWork {
    public static void main(String[] args) {
        int n = 5;
        Queue<String> binaryNumberQ = new LinkedList<String>();
        binaryNumberQ.add("1");
        while (n-- > 0) {
            String s1 = binaryNumberQ.peek();
            binaryNumberQ.remove();
            System.out.println("Binary Number " + s1);
            String s2 = s1;
            binaryNumberQ.add(s1 + "0");
            binaryNumberQ.add(s2 + "1");
        }
    }
}
