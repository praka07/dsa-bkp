package com.practice;


class Node {
    int data;
    Node next;

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    Node() {
    }
}

public class ClearLinkedList {
    // Helper function to print a given linked list
    public static void printList(Node head) {
        Node ptr = head;
        while (ptr != null) {
            System.out.print(ptr.data + " —> ");
            ptr = ptr.next;
        }

        System.out.println("null");
    }

    // Function takes a linked list and returns a complete copy of that
    // list using a dummy node
    public static Node copyList(Node head) {
        Node current = head;        // used to iterate over the original list
        Node tail;                  // point to the last node in the new list
        Node dummy = new Node();    // build the new list of this dummy node

        tail = dummy;               // start the tail pointing at the dummy

        while (current != null) {
            // add each node at the tail
            tail.next = new Node(current.data, tail.next);

            // advance the tail to the new last node
            tail = tail.next;
            current = current.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        // input keys
        int[] keys = {1, 2, 3, 4};

        // points to the head node of the linked list
        Node head = null;

        // construct a linked list
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }

        // copy linked list
        Node dup = copyList(head);

        // print duplicate linked list
        printList(dup);
    }

}
