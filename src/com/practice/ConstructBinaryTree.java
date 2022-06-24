package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}


public class ConstructBinaryTree {
    public TreeNode buildTree(int[] A, int[] B) {
        // A array is pre order elements
        //B array is in order elements
        int preIndex = 1, inIndex = 0, flag = 0;
        TreeNode prev, root;
        Stack<TreeNode> temp = new Stack<TreeNode>();
        // keep preorder first node as root and prev node
        prev = root = new TreeNode(A[0]);
        // push root node into  stack
        temp.push(root);
        while (preIndex < A.length) {
            if (!temp.isEmpty() && B[inIndex] == temp.peek().val) {
                prev = temp.pop();
                ++inIndex;
                flag = 1;

            } else {
                TreeNode node = new TreeNode(A[preIndex]);
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

    public int kthsmallest(TreeNode A, int B) {
        // declare stak to store TreeNode
        Stack<TreeNode> stack = new Stack<>();
        // list to store TreeList
        ArrayList<Integer> inorderResult = new ArrayList<Integer>();
        while (true) {
            while (A != null) {
                stack.push(A);
                A = A.left;
            }
            if (stack.isEmpty()) {
                break;
            }
            A = stack.pop();
            inorderResult.add(A.val);
            A = A.right;

        }
        System.out.print(Arrays.asList(inorderResult));

        return inorderResult.get(B - 1);
    }

    public static void main(String[] args) {
        int[] a = {8, 5, 4, 6, 20, 16, 21};
        int[] b = {4, 5, 8, 16, 20, 21};
        ConstructBinaryTree object = new ConstructBinaryTree();
        TreeNode input = object.buildTree(a, b);
        object.kthsmallest(input, 2);


    }
}



