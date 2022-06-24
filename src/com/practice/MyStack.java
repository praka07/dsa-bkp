package com.practice;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    Queue<Integer> q1, q2;

    public MyStack() {
        q1 = new LinkedList();
        q2 = new LinkedList();

    }

    public void push(int x) {
        // Add element to q2
        q2.add(x);
        while (!q1.isEmpty()) {
            q2.add(q1.peek());
            q1.remove();
        }
        // swap element
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

    }

    public int pop() {
        return q1.remove();
    }

    public int top() {
        return q1.peek();

    }

    public boolean empty() {
        if (q1.isEmpty()) {
            return false;
        }
        return true;
    }
}
