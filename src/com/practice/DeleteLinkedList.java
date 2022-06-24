package com.practice;

class LinkedNode {
    int data;
    LinkedNode next;

    LinkedNode(int val, LinkedNode pointer) {
        this.data = val;
        this.next = pointer;
    }
}

public class DeleteLinkedList {

    public void deleteGivenNode(LinkedNode head, int numberToDelete) {

        // take temp
        LinkedNode temp = head;
        LinkedNode prev = null;

        // check if head to be delete
        if (temp != null && temp.data == numberToDelete) {
            head = temp.next;
            return;

        }
        // find the node to be deleted
        while (temp != null && temp.data != numberToDelete) {
            prev = temp;
            temp = temp.next;
        }
        System.out.println("prev -> " + prev.data);
        // delete the node
        prev.next = temp.next;
    }

    public void displayNode(LinkedNode head) {
        while (head != null) {
            System.out.print(head.data + "  ");
            head = head.next;
        }

    }

    public static void main(String[] args) {
        LinkedNode head = null;
        int[] data = {2, 4, 6, 8, 10, 40, 36, 23};
        for (int i = data.length - 1; i >= 0; i--) {
            head = new LinkedNode(data[i], head);
        }
        DeleteLinkedList object = new DeleteLinkedList();
        object.deleteGivenNode(head, 23);
        System.out.println(" after deletion");
        object.displayNode(head);
    }
}
