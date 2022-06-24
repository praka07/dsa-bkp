package com.practice;

import java.util.*;

class SortStack {
    // This function return the sorted stack
    public static Stack<Integer> sortstack(Stack<Integer>
                                                   input) {
        Stack<Integer> tmpStack = new Stack<Integer>();

        while (!input.isEmpty()) {
            // pop out the first element
            int tmp = input.pop();

            // while temporary stack is not empty and
            // top of stack is greater than temp
            while (!tmpStack.isEmpty() && tmpStack.peek()
                    < tmp) {
                // pop from temporary stack and
                // push it to the input stack
                input.push(tmpStack.pop());
            }

            // push temp in temporary of stack
            tmpStack.push(tmp);
        }
        return tmpStack;
    }

    public int[] solve(int[] A) {
        Stack<Integer> input = new Stack<Integer>();
        Stack<Integer> tempStack = new Stack<Integer>();

        for (int i = 0; i < A.length; i++) {
            input.add(A[i]);
        }
        while (!input.isEmpty()) {
            int temp = input.pop();
            while (!tempStack.isEmpty() && tempStack.peek() < temp) {
                input.push(tempStack.pop());
            }
            tempStack.push(temp);
        }
        int tempSize=tempStack.size();
        int[] result= new int[tempSize];
        for (int i = 0; i < tempSize; i++) {
            result[i] = tempStack.pop();

        }
        return result;
    }

    // Driver Code
    public static void main(String args[]) {
      int [] A = { 66, 96, 43, 28, 14, 1, 41, 76, 70, 81, 22, 11, 42, 78, 4, 88, 70, 43, 90, 6, 12 };
        SortStack object= new SortStack();
        object.solve(A);
    }
}