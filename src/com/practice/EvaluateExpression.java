package com.practice;

import java.util.Stack;

public class EvaluateExpression {
    public static void main(String[] args) {
        String[] exp = {"-1"};

        EvaluateExpression object = new EvaluateExpression();
        System.out.println(" result " + object.evalRPN(exp));
    }

    public int evalRPN(String[] A) {
        Stack<Integer> output = new Stack<>();
        for (int i = 0; i < A.length; i++) {
            char digit = A[i].charAt(0);
            if (Character.isDigit(digit)) {
                output.push(digit - '0');

            } else {
                int value1 = output.pop();
                int value2 = output.pop();
                switch (digit) {
                    case '+':
                        output.push(value2 + value1);
                        break;
                    case '-':
                        output.push(value2 - value1);
                        break;
                    case '*':
                        output.push(value2 * value1);
                        break;
                    case '/':
                        output.push(value2 / value1);
                        break;


                }
            }

        }
        return output.pop();
    }
}
