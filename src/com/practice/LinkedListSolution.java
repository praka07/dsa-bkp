package com.practice;


class ListNode {

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

    public Node removeNthFromEnd(int B) {
        int sizeOfLinkedList = 0;
        Node A = head;
        Node dummy = A;
        Node first = A;
        Node second = A;
        Node prev;
        while (dummy != null) {
            dummy = dummy.next;
            sizeOfLinkedList++;
        }
        if (B > sizeOfLinkedList) {
            return A.next;
        } else {

            while (B-- > 0 && second.next != null) {
                second = second.next;
            }
            while (second.next != null) {
                first = first.next;
                second = second.next;

            }
            prev = first;
            prev.next = first.next.next;

        }

        return A;
    }

    public Node reverseBetween(int B, int C) {
        Node A = head;
        Node findStartNode = A;

        Node traversal = A;

        Node prevNode = null;

        int tempB = B;

        if (A.next == null) {
            return A;
        }

        for (int i = 0; i < B; i++) {
            prevNode = traversal;
            traversal = traversal.next;

        }

        while (B-- > 1) {

            findStartNode = findStartNode.next;
        }

        System.out.println("start " + findStartNode.data);
        int nodeToBeStorted = C - tempB + 1;

        Node prev = null, current = findStartNode, next;

        while (nodeToBeStorted-- > 0) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        prevNode.next = prev;
        prev.next = null;
        Node dummy = prev;
        while (prev != null) {
            dummy = prev;
            prev = prev.next;
        }
        dummy.next = current;

        return prevNode;

    }

    public Node deleteDuplicateNode() {

        Node p = head;
        while(head!=null){
            while(head.next!=null && head.data==head.next.data){
                head.next=head.next.next;
            }
            head=head.next;
        }

        return p;
    }

    public static void main(String[] args) {
        ListNode llist = new ListNode();

        llist.push(2);
        llist.push(2);
        llist.push(2);
        llist.push(1);
        llist.push(1);
        llist.push(1);
        // llist.removeNthFromEnd(3);
       // llist.reverseBetween(2, 3);
        llist.deleteDuplicateNode();
        System.out.println("\nLinked List after Deletion is:");
        llist.printList();
    }


}
