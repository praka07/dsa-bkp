package com.practice;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    int row = i;
                    int column = j - 1;
                    // fill up all column by -1
                    while (column >= 0) {
                        matrix[i][column--] = -1;
                    }
                    column = j + 1;
                    while (column < matrix[i].length) {
                        if (0 != matrix[i][column]) {
                            matrix[i][column++] = -1;
                        }else{
                            column++;
                        }



                    }
//fil up all row with -1
                    row = i - 1;
                    while (row >= 0) {
                        matrix[row--][j] = -1;
                    }

                    row = i + 1;
                    while (row < matrix.length) {
                        matrix[row++][j] = -1;


                    }

                }

            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] input = {{0,0,0,5}, {4,3,1,4}, {0,1,1,4},{1,2,1,3},{0,0,1,1}};


        SetMatrixZeroes obSetMatrixZeroes = new SetMatrixZeroes();
        obSetMatrixZeroes.setZeroes(input);

    }
}
