package com.practice;

// A recursive java program to find difference between sum of nodes at
// odd level and sum at even level

// A binary tree node

class OddLevelNode
{
    int data;
    OddLevelNode left, right;

    OddLevelNode(int item)
    {
        data = item;
        left = right;
    }
}

class BinaryTree
{
    // The main function that return difference between odd and even level
    // nodes
    OddLevelNode root;

    int getLevelDiff(OddLevelNode node)
    {
        // Base case
        if (node == null)
            return 0;

        // Difference for root is root's data - difference for
        // left subtree - difference for right subtree
        return node.data - getLevelDiff(node.left) -
                getLevelDiff(node.right);
    }

    // Driver program to test above functions
    public static void main(String args[])
    {
        BinaryTree tree = new BinaryTree();
        tree.root = new OddLevelNode(5);
        tree.root.left = new OddLevelNode(2);
        tree.root.right = new OddLevelNode(6);
        tree.root.left.left = new OddLevelNode(1);
        tree.root.left.right = new OddLevelNode(4);
        tree.root.left.right.left = new OddLevelNode(3);
        tree.root.right.right = new OddLevelNode(8);
        tree.root.right.right.right = new OddLevelNode(9);
        tree.root.right.right.left = new OddLevelNode(7);
        System.out.println(tree.getLevelDiff(tree.root) +
                " is the required difference");

    }
}