package com.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class LevelOrderNode {
    LevelOrderNode left;
    int data;
    LevelOrderNode right;

    LevelOrderNode(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}

public class LevelOrderTreeTraversal {
    public LevelOrderNode buildTree(int[] A, int[] B) {
        // A array is pre order elements
        //B array is in order elements
        int preIndex = 1, inIndex = 0, flag = 0;
        LevelOrderNode prev, root;
        Stack<LevelOrderNode> temp = new Stack<LevelOrderNode>();
        // keep preorder first node as root and prev node
        prev = root = new LevelOrderNode(A[0]);
        // push root node into  stack
        temp.push(root);
        while (preIndex < A.length) {
            if (!temp.isEmpty() && B[inIndex] == temp.peek().data) {
                prev = temp.pop();
                ++inIndex;
                flag = 1;

            } else {
                LevelOrderNode node = new LevelOrderNode(A[preIndex]);
                if (flag == 0) {
                    prev.left = node;
                    prev = prev.left;

                } else {
                    prev.right = node;
                    prev = prev.right;
                    flag = 0;
                }
                temp.push(node);
                ++preIndex;

            }
        }

        return root;
    }

    public void levelOrderTraversal(LevelOrderNode node) {
        Queue<LevelOrderNode> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            LevelOrderNode temp = q.remove();
            System.out.print(" " +temp.data);
            if (temp.left != null) {
                q.add(temp.left);
            }
            if (temp.right != null) {
                q.add(temp.right);
            }


        }

    }

    public static void main(String[] args) {
        LevelOrderTreeTraversal object = new LevelOrderTreeTraversal();
        int[] a = {8, 5, 4, 6, 20, 21};
        int[] b = {4, 5, 8, 6, 20, 21};
        LevelOrderNode input = object.buildTree(a, b);
        object.levelOrderTraversal(input);
    }
}
