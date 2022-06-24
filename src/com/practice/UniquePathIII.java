package com.practice;

public class UniquePathIII {
     int n;
     int m;
     int ans;
     int xx[] = new int[]{0, 1, -1, 0};
     int yy[] = new int[]{1, 0, -1, 0};

    boolean isV(int u, int v, int[][] A) {
        return 0 <= u && u < n && 0 <= v && v <= m && A[u][v] != 1;

    }

    void uniquePath(int[][] A, int startX, int startY, int totalZero) {
        if (A[startX][startY] == 2) {
            if (totalZero == 0) {
                ans++;

                return;
            }
        }
        A[startX][startY] = -1;
        ans = 0;
        for (int i = 0; i < 4; i++) {
            int u = startX + xx[i];
            int v = startY + yy[i];
            if (isV(u, v, A)) {
                uniquePath(A, u, v, totalZero - 1);

            }

        }
        A[startX][startY] = 0;


    }

    public int solve(int[][] A) {
        int totalZero = 0, startX = -1, startY = -1, n = A.length;
        m = A[0].length;
        for (int row = 0; row < A.length; row++) {
            for (int col = 0; col < A[row].length; col++) {
                if (A[row][col] == 0) {
                    totalZero++;
                } else if (A[row][col] == 1) {
                    startX = row;
                    startY = col;

                }
            }
        }
        uniquePath(A, startX, startY, totalZero + 1);
        return ans;
    }
}
