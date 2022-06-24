package com.practice;

class PalindromeNode {
    public int val;
    public PalindromeNode next;

    PalindromeNode(int x, PalindromeNode head) {
        this.val = x;
        this.next = head;
    }
}

public class PalindromeLinkedList {
    public int lPalin(PalindromeNode A) {
        PalindromeNode slow = A;
        PalindromeNode fast = A;
        PalindromeNode previousNode = A;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            previousNode = slow;
            slow = slow.next;
        }

        previousNode.next = null;
        PalindromeNode prev = null, current = slow, next;
        while (current.next != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;

        }
        current = prev;

        while (A != null && current != null) {
            if (A.val == current.val) {
                A = A.next;
                current = current.next;

            } else {
                return 0;
            }

        }

        // System.out.println("mid element " + slow.val);
        return 1;
    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 2, 1};
        PalindromeNode head = null;
        for (int i = nodes.length - 1; i >= 0; i--) {
            head = new PalindromeNode(nodes[i], head);

        }
        PalindromeLinkedList object = new PalindromeLinkedList();
        System.out.println("output " + object.lPalin(head));

    }
}
