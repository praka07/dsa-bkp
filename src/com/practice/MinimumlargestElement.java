package com.practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class Element {
    int val;
    int orig;

    public Element(int val, int orig) {
        this.val = val;
        this.orig = orig;
    }
}

class ElementComparator implements Comparator<Element> {
    @Override
    public int compare(Element e1, Element e2) {
        return (e1.val + e1.orig) - (e2.val + e2.orig);
    }
}

public class MinimumlargestElement {
    public int solve(ArrayList<Integer> A, int B) {
        int max = Integer.MIN_VALUE;
        PriorityQueue<Element> pq = new PriorityQueue<Element>(new ElementComparator());
        int n = A.size();
        for (int i = 0; i < n; i++) {
            pq.add(new Element(A.get(i), A.get(i)));
        }
        while (B-- > 0) {
            Element x = pq.poll();
            int val = x.val;
            int orig = x.orig;
            val += orig;
            pq.add(new Element(val, orig));
        }
        while (pq.size() > 0) {
            max = Math.max(max, pq.poll().val);
        }
        return max;
    }
}
