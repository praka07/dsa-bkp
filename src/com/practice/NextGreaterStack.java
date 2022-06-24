package com.practice;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterStack {
    public static void main(String[] args) {
        int[] A = {34, 35, 27, 42, 5, 28, 39, 20, 28};
        NextGreaterStack object = new NextGreaterStack();
        object.nextGreater(A);

    }

    public int[] nextGreater1(int[] A) {
        int[] greaterArray = new int[A.length];
        Arrays.fill(greaterArray, -1);
        int k = 0;
        boolean flag = false;
        for (int i = 0; i < A.length; i++) {
            flag = false;
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] > A[i]) {
                    greaterArray[k++] = A[j];
                    flag = true;
                    break;

                }

            }
            if (!flag) {
                k++;
            }

        }
        System.out.println(Arrays.toString(greaterArray));
        return greaterArray;
    }
    public int[] nextGreater(int[] A) {
        Stack < Integer > s = new Stack< >();
        s.push(0);
        int n = A.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for (int i = 1; i < n; i++) {
            if (s.isEmpty()) {
                s.push(i);
                continue;
            }
            System.out.println(s.peek());
            while (!s.isEmpty() && A[s.peek()] < A[i]) {
                ans[s.peek()] = A[i];
                s.pop();
            }
            s.push(i);
        }
        return ans;
    }


    static int maxHist(int R, int C, int row[])
    {

        Stack<Integer> result = new Stack<Integer>();

        int top_val; // Top of stack

        int max_area = 0; // Initialize max area in current
        // row (or histogram)

        int area = 0; // Initialize area with current top

        // Run through all bars of given histogram (or row)
        int i = 0;
        while (i < C) {

            if (result.empty()
                    || row[result.peek()] <= row[i])
                result.push(i++);

            else {

                top_val = row[result.peek()];
                result.pop();
                area = top_val * i;

                if (!result.empty())
                    area
                            = top_val * (i - result.peek() - 1);
                max_area = Math.max(area, max_area);
            }
        }


        while (!result.empty()) {
            top_val = row[result.peek()];
            result.pop();
            area = top_val * i;
            if (!result.empty())
                area = top_val * (i - result.peek() - 1);

            max_area = Math.max(area, max_area);
        }
        return max_area;
    }


    static int maxRectangle(int R, int C, int A[][])
    {
        // Calculate area for first row and initialize it as
        // result
        int result = maxHist(A.length, A[0].length, A[0]);

        // iterate over row to find maximum rectangular area
        // considering each row as histogram
        for (int i = 1; i < R; i++) {

            for (int j = 0; j < C; j++)

                // if A[i][j] is 1 then add A[i -1][j]
                if (A[i][j] == 1)
                    A[i][j] += A[i - 1][j];

            // Update result if area with current row (as
            // last row of rectangle) is more
            result = Math.max(result, maxHist(R, C, A[i]));
        }

        return result;
    }

}
