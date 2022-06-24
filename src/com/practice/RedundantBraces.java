package com.practice;

import java.util.Stack;

public class RedundantBraces {
    public static void main(String[] args) {

        String A = "(a+(a+b))";

        RedundantBraces object = new RedundantBraces();
        System.out.println("output " + object.braces(A));

    }

    public int braces(String A) {
        Stack<Character> output = new Stack<Character>();
        for (int characterFrmString = 0; characterFrmString < A.length(); characterFrmString++) {
            char character = A.charAt(characterFrmString);
            if (character == '(' || character == '+' || character == '*' || character == '-' || character == '/') {
                output.push(A.charAt(characterFrmString));
            } else if (character == ')') {
                if (output.peek() != '+' && output.peek() != '-' && output.peek() != '/' && output.peek() != '*') {
                    return 1;

                } else {
                    while (!output.isEmpty()) {
                        if (output.peek() == '+' || output.peek() == '-' || output.peek() == '/' || output.peek() == '*') {
                            output.pop();

                        } else {
                            break;
                        }
                    }
                    if (output.peek() != '(') {
                        return 1;
                    }
                    output.pop();
                }

            }
        }
        while (!output.isEmpty()) {
            if (output.peek() == '+' || output.peek() == '-' || output.peek() == '/' || output.peek() == '*') {
                output.pop();

            } else {
                break;
            }
        }
        if (output.isEmpty()) {
            return 0;
        } else {
            return 1;
        }

    }
}
