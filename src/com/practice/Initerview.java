package com.practice;

public class Initerview {

    public static void main(String[] args) {

        Initerview obj = new Initerview();
        Integer i=null;
        obj.displayName(i);

    }

    public void displayName(String s) {
        System.out.println("String called");
    }

    public void displayName(Integer s) {
        System.out.println(" int called ");
    }
}
