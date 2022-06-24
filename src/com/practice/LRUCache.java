package com.practice;

import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class LRUCache {

    Deque<Integer> doublyLinkedList = new LinkedList<>();
    HashSet<Integer> set = new HashSet<Integer>();
    // max capacity of cache size
    int CACHE_CAPACITY = 3;

    public void checkChache(int data) {
        // 1.check if requested data present in hashset

        if (!set.contains(data)) {
            // check reched Max capcity or not
            if (doublyLinkedList.size() == CACHE_CAPACITY) {
                // remove rear part of double linked list
                int lruElement = doublyLinkedList.removeLast();
                set.remove(lruElement);

            } else {
                // if element present in set, remove from list as well. it may present anywhere in linked list
                doublyLinkedList.remove(data);

            }
            // push element near by front
            doublyLinkedList.push(data);
            set.add(data);
        }


    }

    // display contents of cache
    public void display() {
        Iterator<Integer> itr = doublyLinkedList.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
    }

    public static void main(String[] args) {
        int[] requestData = {1, 2, 3, 4, 1, 2, 5};
        LRUCache object = new LRUCache();

        for (int i = 0; i < requestData.length; i++) {
            object.checkChache(requestData[i]);

        }
        object.display();

    }
}
