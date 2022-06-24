package com.practice;

class LcaNode {
    int data;
    LcaNode left;
    LcaNode right;

    LcaNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;

    }
}

public class LCATree {
    LcaNode firstRoot;

    public static LcaNode LCA(LcaNode root, int data1, int data2) {
        if (root == null)
            return null;
        if (root.data == data1 || root.data == data2)
            return root;
        LcaNode l = LCA(root.left, data1, data2);
        LcaNode r = LCA(root.right, data1, data2);
        if (l != null && r != null)
            return root;
        if (l != null)
            return l;
        return r;
    }
    public static boolean find(LcaNode root, int data1) {
        if (root == null)
            return false;
        if (root.data == data1)
            return true;
        return (find(root.left, data1) || find(root.right, data1));
    }
    public int lca(LcaNode A, int B, int C) {
        int data1 = B;
        int data2 = C;
        LcaNode root = A;
        if (find(root, data1) == false || find(root, data2) == false)
            return -1;
        LcaNode ans = LCA(root, data1, data2);
        if (ans == null)
            return -1;
        return ans.data;
    }

//    public static void main(String[] args) {
//        LCATree tree = new LCATree();
//        tree.firstRoot = new LcaNode(1);
//        tree.firstRoot.left = new LcaNode(2);
//        tree.firstRoot.right = new LcaNode(3);
//        tree.firstRoot.left.left = new LcaNode(4);
//        tree.firstRoot.left.right = new LcaNode(5);
//        tree.firstRoot.left.right.left = new LcaNode(6);
//        tree.firstRoot.left.right.right = new LcaNode(7);
//        tree.firstRoot.right.right = new LcaNode(9);
//        tree.firstRoot.right.left = new LcaNode(8);
//        LCATree object = new LCATree();
//        System.out.println(" " + object.LCA(tree, 4, 7));

  //  }
}
