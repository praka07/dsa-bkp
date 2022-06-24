package com.practice;

class NodeLL {
    int val;
    NodeLL next;

    NodeLL(int data, NodeLL pointer) {
        this.val = data;
        this.next = pointer;
    }
}

public class MergeTwoSortedLists {

    public static NodeLL mergeTwoLists(NodeLL A, NodeLL B) {
        NodeLL sorting = null;
        NodeLL newHead = null;
        if (A == null) {
            return B;
        }
        if (B == null) {
            return A;
        }

        if (A != null && B != null) {
            if (A.val <= B.val) {
                sorting = A;
                A = sorting.next;
            } else {
                sorting = B;
                B = sorting.next;
            }
        }
        newHead = sorting;

        while (A != null && B != null) {
            if (A.val <= B.val) {
                sorting.next = A;
                sorting = A;
                A = sorting.next;


            } else {
                sorting.next = B;
                sorting = B;
                B = sorting.next;

            }
        }
        if (A == null) {
            sorting.next = B;

        }
        if (B == null) {
            sorting.next = A;
        }

        return newHead;

    }

    public static void main(String[] args) {
        int[] A = {5, 8, 20, 25};
        int[] B = {4, 11, 15};
        NodeLL head = null;
        NodeLL secondHead = null;
        for (int i = A.length - 1; i >= 0; i--) {
            head = new NodeLL(A[i], head);

        }
        for (int j = B.length - 1; j >= 0; j--) {
            secondHead = new NodeLL(B[j], secondHead);

        }
        mergeTwoLists(head, secondHead);
    }

}
