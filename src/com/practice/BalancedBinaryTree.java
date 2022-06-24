package com.practice;

public class BalancedBinaryTree {
    int balanced = 1;

    public int isBalanced(TreeNode A) {
        balanced(A);
        return balanced;
    }

    public int balanced(TreeNode A) {
        if (A == null)
            return 0;

        int heightLeft = 1 + balanced(A.left);
        int heightRight = 1 + balanced(A.right);

        if (Math.abs(heightLeft - heightRight) > 1)
            balanced = 0;
        return Math.max(heightLeft, heightRight);
    }

    /* O(n) approach */
    public int isBalancedON(TreeNode A) {
        return isBalancedRec(A) == -1 ? 0 : 1;
    }

    public int isBalancedRec(TreeNode A) {
        if (A == null) return 0;

        int lh = isBalancedRec(A.left);
        if (lh == -1) return -1;
        int rh = isBalancedRec(A.right);
        if (rh == -1) return -1;

        if (Math.abs(lh - rh) > 1)
            return -1;

        return 1 + Math.max(lh, rh);
    }
}
