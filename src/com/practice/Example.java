package com.practice;

public class Example {
public int maxProduct(int[] A){
    int result= A[0];
    for(int i=0;i<A.length;i++){
        int product=1;
        for(int j=i;j<A.length;j++){
            System.out.print(A[j]);
        }
        System.out.println();
    }
    return result;

}
    public static void main(String[] args) {
    Example example= new Example();
    System.out.println(example.maxProduct(new int[]{2,3,-2,4}));


    }
}
