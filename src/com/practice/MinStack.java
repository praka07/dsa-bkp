package com.practice;

import java.util.Stack;

public class MinStack {
    public static void main(String[] args) {
        MinStack object = new MinStack();

        object.push(10);
        object.push(9);
        object.getMin();
        object.push(8);
        object.getMin();
        object.push(7);
        object.getMin();
        object.push(6);
        object.getMin();
        object.pop();
        object.getMin();
        object.pop();
        object.getMin();
        object.pop();
        object.getMin();
        object.pop();
        object.getMin();
        object.pop();
        object.getMin();

    }

    Stack<Integer> input = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();

    public void push(int x) {

        input.push(x);
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else {
            minStack.push(Math.min(x, minStack.peek()));
        }

    }

    public void pop() {

        if (input.isEmpty()) {

        } else {
            input.pop();
            minStack.pop();
        }

    }

    public int top() {
        if (input.isEmpty()) {
            return -1;
        }
        return input.peek();

    }

    public int getMin() {

        if (minStack.isEmpty()) {
            return -1;
        }
        return minStack.peek();
    }
}
