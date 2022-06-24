package com.practice;

public class RotateMatrix {
    public static void main(String[] args) {
        int [][] input={{1,2},{3,4}};
        RotateMatrix object= new RotateMatrix();
        object.solve(input);

    }

    public void solve(int[][] A) {
        int row = A.length;
        int col = A.length;
        //transpose matrix
        for (int i = 0; i < row; i++) {
            for (int j = i; j < col; j++) {
                int temp=A[i][j];
                A[i][j]=A[j][i];
                A[j][i]=temp;
            }
        }

        // reverse the row
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col/2; j++) {
                int temp = A[i][j];
                A[i][j] = A[i][col - j - 1];
                A[i][col - j - 1] = temp;


            }
        }
    }
}
