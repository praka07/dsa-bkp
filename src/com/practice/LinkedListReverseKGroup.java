package com.practice;

public class LinkedListReverseKGroup {
    Node head;

    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public void push(int new_data) {
        Node newNode = new Node(new_data);
        newNode.next = head;
        head = newNode;
    }

    public void printList() {
        Node tnode = head;
        while (tnode != null) {
            System.out.print(tnode.data + " ");
            tnode = tnode.next;
        }
    }

    public Node reverseList(int B) {
        Node A=head;

        return A;
    }

    public static void main(String[] args) {

        LinkedListReverseKGroup llist = new LinkedListReverseKGroup();

        llist.push(6);
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);
        llist.reverseList(2);
        System.out.println("\nLinked List after Deletion is:");
        llist.printList();

    }
}
