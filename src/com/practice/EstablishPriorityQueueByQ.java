package com.practice;

import java.util.*;

public class EstablishPriorityQueueByQ {
    private static Queue<Integer> q = new LinkedList<Integer>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // we get 5 element
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter Q value");
            int element = sc.nextInt();
            q.add(element);
        }
        // maintain order in Q
        maintainPriorityQueue(q);
    }

    private static Queue<Integer> maintainPriorityQueue(Queue<Integer> q) {
        Queue<Integer> q2= new LinkedList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        while(q.isEmpty() == false)
        {
            temp.add(q.peek());
            q.remove();
        }
        Collections.sort(temp);
        for(int i=0;i<temp.size();i++)
        {
            q.add(temp.get(i));
        }
        return q;


    }
}
