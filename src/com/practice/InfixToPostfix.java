package com.practice;

import java.util.Arrays;
import java.util.Stack;

public class InfixToPostfix {
    public static void main(String[] args) {
        InfixToPostfix object = new InfixToPostfix();
        String A = "t*(s-n^v)^n*(q*k)*v*(w*k)";
        System.out.println("result :: " + object.solve(A));

    }

    public String solve(String A) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < A.length(); i++) {
            if (Character.isLetter(A.charAt(i))) {
                result.append(A.charAt(i));
            } else if (A.charAt(i) == '(') {
                stack.push(A.charAt(i));
            } else if (A.charAt(i) == ')') {
                while (stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop();
            } else {
                if (stack.isEmpty()) {
                    stack.push(A.charAt(i));
                } else {

//                    if (prec(A.charAt(i)) <= prec(stack.peek())) {
//                        stack.push(A.charAt(i));
//                    } else {
//                        while (!stack.isEmpty()) {
//                            result.append(stack.pop());
//                        }
                    while (!stack.isEmpty() && !(stack.peek()=='(') && prec(A.charAt(i)) <= prec(stack.peek()))
                        result.append(stack.pop());
                    stack.push(A.charAt(i));
                }
            }
                }



        while (!stack.isEmpty())
            result.append(stack.pop());
        // System.out.println(Arrays.asList(stack));
        return result.toString();
    }

    static int prec(char x) {
      //  System.out.println("chara " + x);
        switch (x) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

}



