package com.practice;

import java.util.ArrayList;
import java.util.Stack;

class BSTNode {
    BSTNode left;
    int data;
    BSTNode right;

    BSTNode(int x) {
        data = x;
        left = null;
        right = null;
    }
}

public class ConstructBinarySearchTree {
    public BSTNode root;

    ConstructBinarySearchTree() {
        root = null;
    }

    public void insert(int data) {
        //Create a new node
        BSTNode newNode = new BSTNode(data);

        //Check whether tree is empty
        if (root == null) {
            root = newNode;
            return;
        } else {
            //current node point to root of the tree
            BSTNode current = root, parent = null;

            while (true) {
                //parent keep track of the parent node of current node.
                parent = current;

                //If data is less than current's data, node will be inserted to the left of tree
                if (data < current.data) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        return;
                    }
                }
                //If data is greater than current's data, node will be inserted to the right of tree
                else {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    public void inOrderTraversalAnotherApproach(BSTNode A) {
        // declare stak to store TreeNode
        Stack<BSTNode> stack = new Stack<>();
        // list to store TreeList
        // ArrayList<Integer> inorderResult = new ArrayList<Integer>();

        while (A != null || !stack.isEmpty()) {
            if (A != null) {
                stack.push(A);
                A = A.left;
            } else {
                A = stack.pop();
                System.out.print(" " + A.data);
                A = A.right;
            }


        }

    }
    public int[] recoverTree(BSTNode A) {
        int[] result= new int[2];
        Stack<BSTNode> stack= new Stack<BSTNode>();
        ArrayList<Integer> inorderElements= new ArrayList<Integer>();
        while(A!=null || stack.size()>0){
            if(A!=null){
                stack.push(A);
                A=A.left;
            }else{
                A=stack.pop();
                inorderElements.add(A.data);
                A=A.right;

            }
        }
        for(int i=0;i<inorderElements.size()-1;i++){
            if(inorderElements.get(i)>inorderElements.get(i+1)){
                result[0]=inorderElements.get(i);
                result[1]=inorderElements.get(i+1);
                break;

            }
        }
        return result;

    }

    public int inOrderTraversal(BSTNode A) {
        // declare stak to store TreeNode
        Stack<BSTNode> stack = new Stack<>();
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
            inorderResult.add(A.data);
            A = A.right;

        }

        for (int i = 0; i < inorderResult.size() - 1; i++) {
            if (!(inorderResult.get(i + 1) > inorderResult.get(i))) {
                return -1;

            }
        }
        return 0;
    }

    public static void main(String[] args) {
        ConstructBinarySearchTree object = new ConstructBinarySearchTree();
        object.insert(8);
        object.insert(5);
        object.insert(4);
        object.insert(6);
        object.insert(20);
        object.insert(16);
        object.insert(21);
        // System.out.println(" result " + object.inOrderTraversal(object.root));
        //object.inOrderTraversalAnotherApproach(object.root);
      //  object.solve(object.root, object.root);
        object.recoverTree(object.root);

    }
}
