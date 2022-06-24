package com.practice;

public class LearnLinkedList {

    class ListNode {
        private int data;
        private ListNode next;

        ListNode(int d) {
            this.data = d;
            this.next = null;

        }
    }

    ListNode head;

    public void formLinkedList(int data) {

        ListNode newNode = new ListNode(data);
        newNode.next = head;
        head = newNode;


        System.out.println("added node");


    }

    public void showLinkedList() {
        ListNode tnode = head;
        while (tnode != null) {
            System.out.print(tnode.data + " -> ");
            tnode = tnode.next;
        }
        System.out.println("END");
    }

    public static void main(String[] args) {
        LearnLinkedList firstNode = new LearnLinkedList();
        firstNode.formLinkedList(2);
        firstNode.formLinkedList(3);
        firstNode.showLinkedList();

    }
}

