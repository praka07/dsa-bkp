package com.practice;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] input = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        SpiralMatrix obj = new SpiralMatrix();
        obj.printMatrix(input);
    }

    public void printMatrix(int[][] a) {
        int left = 0, bottom = a.length - 1, top = 0, right = a[0].length - 1;

        int dir = 0;
        while (left <= right && top <= bottom) {
            if (dir == 0) {
                for (int i = left; i <= right; i++) {
                    System.out.println(a[top][i]);

                }
                top++;
            }
            if (dir == 1) {

                for (int i = top; i <= bottom; i++) {
                    System.out.println(a[i][right]);
                }
                right--;
            }

            if (dir == 2) {

                for (int i = right; i >= left; i--) {
                    System.out.println(a[bottom][i]);
                }
                bottom--;
            }




            if (dir == 3) {

                for (int i = bottom; i >= top; i--) {
                    System.out.println(a[i][left]);
                }
                left++;
            }
            dir = (dir+1) % 4;

        }

    }
}
