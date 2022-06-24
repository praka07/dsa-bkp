package com.practice;

import java.util.Stack;

class NodeDaily {
    char c;
    int frequency;

    public NodeDaily(char input) {
        this.c = input;
        this.frequency = 1;
    }
}

public class RemoveAllAdjacentDuplicate {
    public static void main(String[] args) {
        RemoveAllAdjacentDuplicate obj = new RemoveAllAdjacentDuplicate();
        System.out.println(obj.removeDuplicates("abcd", 2));
    }

    public String removeDuplicates(String s, int k) {
        Stack<NodeDaily> stack = new Stack<NodeDaily>();
        for (char ch : s.toCharArray()) {
            if (stack.isEmpty() || ch != stack.peek().c) {
                stack.push(new NodeDaily(ch));
            } else {
                int times = stack.peek().frequency;
                if (times + 1 == k) {
                    stack.pop();
                } else {
                    stack.peek().frequency++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (NodeDaily entry : stack) {
            int times = entry.frequency;
            for (int i = 0; i < times; i++) {
                sb.append(entry.c);
            }
        }

        return sb.reverse().toString();
    }
}
