package com.practice;

import java.util.Arrays;
import java.util.Stack;

public class RemoveAdjacentDuplicateByStack {
    public static void main(String[] args) {
        String input = "ab";
        Stack<Character> output = new Stack<Character>();
        for (int i = 0; i < input.length(); i++) {
            if (output.isEmpty()) {
                output.push(input.charAt(i));

            } else {
                if (input.charAt(i) == output.peek()) {
                    output.pop();
                } else {
                    output.push(input.charAt(i));
                }
            }

        }
        StringBuilder result = new StringBuilder();
        for (int j = 0; j < output.size(); j++)
            result.append(output.get(j));

        System.out.println("output ::" + result.toString());
    }

    public int largestRectangleArea(int[] A) {
        if (A.length == 0)
            return 0;
        if (A.length == 1)
            return A[0];
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        stack.add(0);
        for (int i = 1; i < A.length; i += 1) {
            if (A[i] >= A[stack.peek()])
                stack.add(i);
            else {
                while (!stack.isEmpty() && A[stack.peek()] > A[i]) {
                    int curr = A[stack.pop()];
                    if (stack.isEmpty())
                        maxArea = Math.max(maxArea, curr * i);
                    else {
                        maxArea = Math.max(maxArea, curr * (i - stack.peek() - 1));
                    }
                }
                stack.add(i);
            }
        }

        if (!stack.isEmpty()) {
            int i = A.length;
            while (!stack.isEmpty()) {
                int curr = A[stack.pop()];
                if (stack.isEmpty())
                    maxArea = Math.max(maxArea, curr * i);
                else
                    maxArea = Math.max(maxArea, curr * (i - stack.peek() - 1));
            }
        }
        return maxArea;
    }
}